package net.sghill.manifest;

/**
 * Returns a {@link TypedManifest} from the classpath.
 */
public interface ManifestParser {

    /**
     * Returns the manifest from an assumed location and assumed
     * {@link ClassLoader}.
     *
     * @return  the manifest at assumed location
     * @see     TypedManifest
     */
    TypedManifest parseManifestFromClasspath();

    /**
     * Returns the manifest from a given {@code path}, using the
     * {@link ClassLoader} of the provided {@code clazz}.
     *
     * @return  the manifest at specified {@code path}
     * @see     TypedManifest
     */
    TypedManifest parseManifestFromClasspath(String path, Class<?> clazz);
}
