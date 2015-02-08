package net.sghill.manifest;

/**
 * Immutable, typed representation of the standard Java manifest.
 */
public class TypedManifest {
    private final String implementationVersion;

    /**
     * Returns a {@code TypedManifest} with an the given
     * {@code implementationVersion}.
     *
     * @param implementationVersion     Implementation-Version header value
     */
    public TypedManifest(String implementationVersion) {
        this.implementationVersion = implementationVersion;
    }

    /**
     * Manifest's {@code Implementation-Version} header.
     *
     * @return  the "Implementation-Version" header of the manifest
     */
    public String getImplementationVersion() {
        return implementationVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypedManifest that = (TypedManifest) o;
        return implementationVersion.equals(that.implementationVersion);
    }

    @Override
    public int hashCode() {
        return implementationVersion.hashCode();
    }

    @Override
    public String toString() {
        return String.format("TypedManifest{implementationVersion='%s'}", implementationVersion);
    }
}
