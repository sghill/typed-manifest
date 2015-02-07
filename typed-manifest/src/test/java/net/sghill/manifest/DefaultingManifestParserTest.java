package net.sghill.manifest;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultingManifestParserTest {
    private DefaultingManifestParser parser;
    public static final String DEFAULT_VERSION = "[version not found]";

    @Before
    public void setUp() {
        TypedManifest defaultManifest = new TypedManifest(DEFAULT_VERSION);
        parser = new DefaultingManifestParser(defaultManifest);
    }

    @Test
    public void shouldReturnEmptyStringVersionWhenManifestNotFound() {
        // When
        TypedManifest manifest = parser.parseManifestFromClasspath("missing-manifest.MF", DefaultingManifestParserTest.class);

        // Then
        assertThat(manifest.getImplementationVersion()).isEqualTo(DEFAULT_VERSION);
    }

    @Test
    public void shouldReturnEmptyStringWhenKeyMissingInManifest() {
        // When
        TypedManifest manifest = parser.parseManifestFromClasspath("missing-key/META-INF/MANIFEST.MF", DefaultingManifestParserTest.class);

        // Then
        assertThat(manifest.getImplementationVersion()).isEqualTo(DEFAULT_VERSION);
    }

    @Test
    public void shouldReturnEmptyStringWhenKeyEmptyInManifest() {
        // When
        TypedManifest manifest = parser.parseManifestFromClasspath("empty-key/META-INF/MANIFEST.MF", DefaultingManifestParserTest.class);

        // Then
        assertThat(manifest.getImplementationVersion()).isEqualTo(DEFAULT_VERSION);
    }

    @Test
    public void shouldReturnVersionStringWhenKeyPopulatedInManifest() {
        // When
        TypedManifest manifest = parser.parseManifestFromClasspath("populated-key/META-INF/MANIFEST.MF", DefaultingManifestParserTest.class);

        // Then
        assertThat(manifest.getImplementationVersion()).isEqualTo("80b498030d");
    }
}
