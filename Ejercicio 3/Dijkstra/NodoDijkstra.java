package Dijkstra;

import java.util.Map;

public class NodoDijkstra {

    private final String nombre;

    private Map<NodoDijkstra, Integer> adyacente;

    public NodoDijkstra(String nombre) {
        this.nombre = nombre;
    }
    public Map<NodoDijkstra, Integer> getAdjacency() {
        return adyacente;
    }
    public String getName() {
        return nombre;
    }
    public void setAdyacente(Map<NodoDijkstra, Integer> adyacente) {
        this.adyacente = adyacente;
    }
    public String toString() {
        return "NodeDijkstra{" +"name='" + nombre + '\'' + '}';
    }
}
