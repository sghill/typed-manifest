package net.sghill.manifest;


import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/**
 * A manifest parser that defaults to a given {@link TypedManifest} if anything
 * goes wrong.
 */
public class DefaultingManifestParser implements ManifestParser {
    private static final String DEFAULT_MANIFEST_PATH = "META-INF/MANIFEST.MF";
    private static final TypedManifest DEFAULT_MANIFEST = new TypedManifest("");
    private final TypedManifest defaultManifest;

    /**
     * Returns a {@code DefaultingManifestParser} with the given
     * {@code TypedManifest} as a default manifest.
     *
     * @param defaultManifest   the manifest with default values
     */
    public DefaultingManifestParser(TypedManifest defaultManifest) {
        this.defaultManifest = defaultManifest;
    }

    /**
     * Returns a {@code DefaultingManifestParser} with a default
     * {@code TypedManifest}.
     *
     * <p>This constructor is equivalent to
     * {@code new DefaultingManifestParser(new TypedManifest(""))}.
     *
     */
    public DefaultingManifestParser() {
        this(DEFAULT_MANIFEST);
    }

    /**
     * Returns a new {@code TypedManifest} from the default path as resolved
     * by the {@code DefaultingManifestParser} {@link ClassLoader}.
     *
     * <p>This method is equivalent to {@code
     * parseManifestFromClasspath("META-INF/MANIFEST",
     * DefaultingManifestParser.class)}
     *
     * @return      the manifest at "META-INF/MANIFEST.MF"
     * @see         TypedManifest
     * @see         #parseManifestFromClasspath(String, Class)
     */
    @Override
    public TypedManifest parseManifestFromClasspath() {
        return parseManifestFromClasspath(DEFAULT_MANIFEST_PATH, DefaultingManifestParser.class);
    }

    /**
     * Returns a new {@link TypedManifest} from the given {@code path},
     * resolved from the given {@code clazz} {@link ClassLoader}.
     *
     * <p>If an {@link IOException} occurs when resolving the manifest at the
     * {@code path} specified, the default {@link TypedManifest} is returned.
     *
     * @param path  the path to the MANIFEST.MF
     * @param clazz the class whose {@link ClassLoader} will be used to
     *              resolve the given {@code path}
     * @return      the manifest from the given location
     * @see         TypedManifest
     */
    @Override
    public TypedManifest parseManifestFromClasspath(String path, Class<?> clazz) {
        try(InputStream is = clazz.getClassLoader().getResourceAsStream(path)) {
            if(is == null) {
                return defaultManifest;
            }
            Manifest manifest = new Manifest(is);
            String versionValue = manifest.getMainAttributes().getValue(Attributes.Name.IMPLEMENTATION_VERSION);
            String implementationVersion = versionValue != null ? versionValue : defaultManifest.getImplementationVersion();
            return new TypedManifest(implementationVersion);
        } catch (IOException e) {
            return defaultManifest;
        }
    }
}
