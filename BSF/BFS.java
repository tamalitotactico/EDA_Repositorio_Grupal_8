package BSF;

import java.util.*;

import static java.util.Objects.isNull;

public class BFS {

    private final Queue<NodoBFS> nodeBFS = new LinkedList<>();
    private final List<NodoBFS> visited = new LinkedList<>();
    public static void main(String[] args) {
        int[] estadoInicial = new int[]{4,2,3,1};
        int[] estadoFinal = new int[]{1,2,3,4};
        final BFS breadthFirstSearch = new BFS();
        long initialTime = System.currentTimeMillis();
        final NodoBFS nodeDFSSolucion = breadthFirstSearch.search(estadoInicial, estadoFinal).orElseThrow(NullPointerException::new);
        breadthFirstSearch.printSolution(nodeDFSSolucion, (System.currentTimeMillis()-initialTime));
    }
    Optional<NodoBFS> search(final int[] initialState, final int[] finalState) {
        if(isNull(initialState)) {
            throw new NullPointerException("initialState shouldn't be null");
        }
        if(isNull(finalState)) {
            throw new NullPointerException("finalState shouldn't be null");
        }
        boolean foundFinalState = false;
        Optional<NodoBFS> foundNode = Optional.empty();
        final NodoBFS root = NodoBFS.of(initialState);
        nodeBFS.add(root);
        
        while(!foundFinalState && nodeBFS.size() != 0) {
            final NodoBFS nodeDFS = this.nodeBFS.poll();
            visited.add(nodeDFS);
            if(Arrays.equals(nodeDFS.getEstado(), finalState)) {
                foundFinalState = true;
                foundNode = Optional.of(nodeDFS);
            } else {
                int[] nodeState = nodeDFS.getEstado();
                this.processChild(new int[]{nodeState[1],nodeState[0],nodeState[2],nodeState[3]}, nodeDFS);
                this.processChild(new int[]{nodeState[0],nodeState[2],nodeState[1],nodeState[3]}, nodeDFS);
                this.processChild(new int[]{nodeState[0],nodeState[1],nodeState[3],nodeState[2]}, nodeDFS);
            }
        }
        return foundNode;
    }

    private void processChild(final int[] state, final NodoBFS nodeDFS) {
        final NodoBFS nodeDFSChild = NodoBFS.of(state);
        nodeDFSChild.setParent(nodeDFS);
        if(!this.nodeBFS.contains(nodeDFSChild) && !visited.contains(nodeDFSChild)) {
            this.nodeBFS.add(nodeDFSChild);
        }
    }
    private void printSolution(final NodoBFS solution, long timeElapsed) {
        boolean parentNull = false;
        NodoBFS actualNodeDFS = solution;
        final List<String> estados = new LinkedList<>();
        while(!parentNull) {
            estados.add(actualNodeDFS.toString());
            if(isNull(actualNodeDFS.getParent())) {
                parentNull = true;
            }
            actualNodeDFS = actualNodeDFS.getParent();
        }
        Collections.reverse(estados);
        System.out.println("Solution in: " + estados.size() + " levels [" + String.join(",", estados) + "] time: " + timeElapsed + "ms");
    }
}