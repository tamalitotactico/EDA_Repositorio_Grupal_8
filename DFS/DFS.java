package DFS;

import static java.util.Objects.isNull;

import java.util.*;

public class DFS {

    private final Stack<NodoDFS> nodoDFS = new Stack<>();
    private final List<NodoDFS> visited = new LinkedList<>();
    public static void main(String[] args) {
        int[] estadoInicial = new int[]{4,2,3,1};
        int[] estadoFinal = new int[]{1,2,3,4};
        final DFS BFS = new DFS();
        long tiempoInicial = System.currentTimeMillis();
        final NodoDFS nodoDFSSolucion = BFS.search(estadoInicial, estadoFinal).orElseThrow(NullPointerException::new);
        BFS.printSolution(nodoDFSSolucion, (System.currentTimeMillis()-tiempoInicial));
    }
    Optional<NodoDFS> search(final int[] initialEstado, final int[] finalEstado) {
        if(isNull(initialEstado)) {
            throw new NullPointerException("El estado inicial no debe ser nulo");
        }
        if(isNull(finalEstado)) {
            throw new NullPointerException("finalEstado no debe ser nul");
        }
        boolean buscarFinalEstado = false;
        Optional<NodoDFS> foundNode = Optional.empty();
        final NodoDFS root = NodoDFS.of(initialEstado);
        nodoDFS.add(root);
        
        while(!buscarFinalEstado && nodoDFS.size() != 0) {
            final NodoDFS nodoDFS = this.nodoDFS.pop();
            visited.add(nodoDFS);
            if(Arrays.equals(nodoDFS.getEstado(), finalEstado)) {
            	buscarFinalEstado = true;
                foundNode = Optional.of(nodoDFS);
            } else {
                int[] nodoState = nodoDFS.getEstado();
                this.processChild(new int[]{nodoState[1],nodoState[0],nodoState[2],nodoState[3]}, nodoDFS);
                this.processChild(new int[]{nodoState[0],nodoState[2],nodoState[1],nodoState[3]}, nodoDFS);
                this.processChild(new int[]{nodoState[0],nodoState[1],nodoState[3],nodoState[2]}, nodoDFS);
            }
        }
        return foundNode;
    }

    private void processChild(final int[] estado, final NodoDFS nodoDFS) {
        final NodoDFS nodoDFSChild = NodoDFS.of(estado);
        nodoDFSChild.setParent(nodoDFS);
        if(!this.nodoDFS.contains(nodoDFSChild) && !visited.contains(nodoDFSChild)) {
            this.nodoDFS.add(nodoDFSChild);
        }
    }
    private void printSolution(final NodoDFS solucion, long tiempo) {
        boolean parentNull = false;
        NodoDFS actualNodoDFS = solucion;
        final List<String> estados = new LinkedList<>();
        while(!parentNull) {
            estados.add(actualNodoDFS.toString());
            if(isNull(actualNodoDFS.getParent())) {
                parentNull = true;
            }
            actualNodoDFS = actualNodoDFS.getParent();
        }
        Collections.reverse(estados);
        System.out.println("Solution in: " + estados.size() + " levels [" + String.join(",", estados) + "] time: " + tiempo + "ms");
    }
}