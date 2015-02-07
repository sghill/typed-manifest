package net.sghill.manifest;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultingManifestParserTest {
    private DefaultingManifestParser parser;

    @Before
    public void setUp() {
        parser = new DefaultingManifestParser();
    }

    @Test
    public void shouldReturnEmptyStringVersionWhenManifestNotFound() {
        // When
        TypedManifest manifest = parser.parseManifestFromClasspath("missing-manifest.MF", DefaultingManifestParserTest.class);

        // Then
        assertThat(manifest.getImplementationVersion()).isEmpty();
    }

    @Test
    public void shouldReturnEmptyStringWhenKeyMissingInManifest() {
        // When
        TypedManifest manifest = parser.parseManifestFromClasspath("missing-key/META-INF/MANIFEST.MF", DefaultingManifestParserTest.class);

        // Then
        assertThat(manifest.getImplementationVersion()).isEmpty();
    }

    @Test
    public void shouldReturnEmptyStringWhenKeyEmptyInManifest() {
        // When
        TypedManifest manifest = parser.parseManifestFromClasspath("empty-key/META-INF/MANIFEST.MF", DefaultingManifestParserTest.class);

        // Then
        assertThat(manifest.getImplementationVersion()).isEmpty();
    }

    @Test
    public void shouldReturnVersionStringWhenKeyPopulatedInManifest() {
        // When
        TypedManifest manifest = parser.parseManifestFromClasspath("populated-key/META-INF/MANIFEST.MF", DefaultingManifestParserTest.class);

        // Then
        assertThat(manifest.getImplementationVersion()).isEqualTo("80b498030d");
    }
}
