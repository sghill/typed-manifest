package net.sghill.manifest;


import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class DefaultingManifestParser implements ManifestParser {
    private static final TypedManifest DEFAULT_MANIFEST = new TypedManifest("");

    @Override
    public TypedManifest parseManifestFromClasspath(String path, Class<?> clazz) {
        try(InputStream is = clazz.getClassLoader().getResourceAsStream(path)) {
            if(is == null) {
                return DEFAULT_MANIFEST;
            }
            Manifest manifest = new Manifest(is);
            String versionValue = manifest.getMainAttributes().getValue(Attributes.Name.IMPLEMENTATION_VERSION);
            String implementationVersion = versionValue != null ? versionValue : "";
            return new TypedManifest(implementationVersion);
        } catch (IOException e) {
            return DEFAULT_MANIFEST;
        }
    }
}
