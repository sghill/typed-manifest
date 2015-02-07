package net.sghill.manifest;


import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class DefaultingManifestParser implements ManifestParser {
    private static final String DEFAULT_MANIFEST_PATH = "META-INF/MANIFEST.MF";
    private static final TypedManifest DEFAULT_MANIFEST = new TypedManifest("");
    private final TypedManifest defaultManifest;

    public DefaultingManifestParser(TypedManifest defaultManifest) {
        this.defaultManifest = defaultManifest;
    }

    public DefaultingManifestParser() {
        this(DEFAULT_MANIFEST);
    }

    @Override
    public TypedManifest parseManifestFromClasspath() {
        return parseManifestFromClasspath(DEFAULT_MANIFEST_PATH, DefaultingManifestParser.class);
    }

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
