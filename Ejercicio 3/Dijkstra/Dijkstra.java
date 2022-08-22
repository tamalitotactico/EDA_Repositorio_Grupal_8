package Dijkstra;

import java.util.*;

import static java.util.Objects.isNull;

public class Dijkstra {

    public static Map<NodoDijkstra, Tag> tagging(final NodoDijkstra from) {
        final Map<NodoDijkstra, Tag> tags= new LinkedHashMap<>();
        final List<NodoDijkstra> visitado = new ArrayList<>();
        final List<NodoDijkstra> pendienteVisitar = new ArrayList<>();

        tags.put(from, Tag.of(null, 0));
        pendienteVisitar.add(from);
        NodoDijkstra actual;

        while(!pendienteVisitar.isEmpty()) {
        	actual = distanciaMenorNodo(tags, visitado);
            if(isNull(actual)) { break; }
            visitado.add(actual);

            for(Map.Entry<NodoDijkstra, Integer> adyacente:actual.getAdjacency().entrySet()) {
                if(!visitado.contains(adyacente.getKey()) && !pendienteVisitar.contains(adyacente.getKey())) {
                	pendienteVisitar.add(adyacente.getKey());
                }
                if(!visitado.contains(adyacente.getKey())) {
                    final Integer weight = tags.get(actual).getWeight() + adyacente.getValue();
                    if(!tags.containsKey(adyacente.getKey())) {
                        tags.put(adyacente.getKey(), Tag.of(actual, weight));
                    } else if(tags.get(adyacente.getKey()).getWeight() > weight) {
                        tags.put(adyacente.getKey(), Tag.of(actual, weight));
                    }
                }
            }
            pendienteVisitar.remove(actual);
        }
        return tags;
    }

    private static NodoDijkstra distanciaMenorNodo(final Map<NodoDijkstra, Tag> tags,final List<NodoDijkstra> visited) {
        Integer min = Integer.MAX_VALUE;
        NodoDijkstra minNodo = null;
        for(Map.Entry<NodoDijkstra, Tag> node:tags.entrySet()) {
            if(node.getValue().getWeight() < min && ! visited.contains(node.getKey())) {
                min = node.getValue().getWeight();
                minNodo = node.getKey();
            }
        }
        return minNodo;
    }

}