package Dijkstra;

import static java.util.Objects.nonNull;

public class Tag {

    private final NodoDijkstra nodo;

    private final Integer weight;

    private Tag(NodoDijkstra nodo, Integer weight) {
        this.nodo = nodo;
        this.weight = weight;
    }
    public static Tag of(final NodoDijkstra nodo, final Integer weight) {
        return new Tag(nodo,weight);
    }
    public Integer getWeight() {
        return weight;
    }
    public NodoDijkstra getNode() {
        return nodo;
    }
    public String toString() {
        String n = nonNull(nodo) ? ", nodo=" + nodo.getName()  : ", nodo=";
        return "Tag{ peso=" + weight + ", nodo=" + n + "}";
    }
}
