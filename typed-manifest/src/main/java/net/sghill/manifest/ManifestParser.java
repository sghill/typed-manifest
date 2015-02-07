package net.sghill.manifest;

public interface ManifestParser {
    TypedManifest parseManifestFromClasspath(String path, Class<?> clazz);
}
