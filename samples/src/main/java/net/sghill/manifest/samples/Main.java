package net.sghill.manifest.samples;

import net.sghill.manifest.DefaultingManifestParser;
import net.sghill.manifest.ManifestParser;
import net.sghill.manifest.TypedManifest;

public class Main {
    public static void main(String[] args) {
        new Main().run(args);
    }

    public void run(String[] args) {
        ManifestParser manifestParser = new DefaultingManifestParser();
        TypedManifest typedManifest = manifestParser.parseManifestFromClasspath("META-INF/MANIFEST.MF", Main.class);
        System.out.println("version: " + typedManifest.getImplementationVersion());
    }
}
