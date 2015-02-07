package net.sghill.manifest;

public class TypedManifest {
    private final String implementationVersion;

    public TypedManifest(String implementationVersion) {
        this.implementationVersion = implementationVersion;
    }

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
