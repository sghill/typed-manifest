package net.sghill.manifest;

public interface ManifestParser {
    TypedManifest parseManifestFromClasspath();
    TypedManifest parseManifestFromClasspath(String path, Class<?> clazz);
}
