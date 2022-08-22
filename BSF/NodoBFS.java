package BSF;

import java.util.Arrays;

public final class NodoBFS {

    private int[] estado;
    private NodoBFS parent;
    @SuppressWarnings("unused")
    private NodoBFS() { }

    private NodoBFS(final int[] estado) {
        this.estado = estado;
    }
    static NodoBFS of(final int[] dato) {
        return new NodoBFS(dato);
    }
    int[] getEstado() {
        return estado;
    }
    NodoBFS getParent() {
        return parent;
    }
    void setParent(final NodoBFS parent) {
        this.parent = parent;
    }
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        NodoBFS nodeBFS = (NodoBFS) object;
        return Arrays.equals(this.estado, nodeBFS.estado);
    }
    public String toString() {
        return Arrays.toString(this.getEstado());
    }
}
