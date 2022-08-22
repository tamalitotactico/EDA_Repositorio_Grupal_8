package DFS;

import java.util.Arrays;

public final class NodoDFS {

    private int[] estado;
    private NodoDFS parent;
    @SuppressWarnings("unused")
    private NodoDFS() { }
    private NodoDFS(final int[] estado) {
        this.estado = estado;
    }
    static NodoDFS of(final int[] dato) {
        return new NodoDFS(dato);
    }
    int[] getEstado() {
        return estado;
    }
    NodoDFS getParent() {
        return parent;
    }
    void setParent(final NodoDFS parent) {
        this.parent = parent;
    }
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        NodoDFS nodoDFS = (NodoDFS) object;
        return Arrays.equals(this.estado, nodoDFS.estado);
    }
    public String toString() {
        return Arrays.toString(this.getEstado());
    }
}