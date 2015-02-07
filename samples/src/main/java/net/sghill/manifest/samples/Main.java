package net.sghill.manifest.samples;

import net.sghill.manifest.DefaultingManifestParser;
import net.sghill.manifest.ManifestParser;
import net.sghill.manifest.TypedManifest;

public class Main {
    public static final String DEFAULT_VERSION = "Not found. Perhaps you're running from outside a jar?";

    public static void main(String[] args) {
        new Main().run(args);
    }

    public void run(String[] args) {
        ManifestParser manifestParser = new DefaultingManifestParser(new TypedManifest(DEFAULT_VERSION));
        TypedManifest typedManifest = manifestParser.parseManifestFromClasspath("META-INF/MANIFEST.MF", Main.class);
        System.out.println("version: " + typedManifest.getImplementationVersion());
    }
}
