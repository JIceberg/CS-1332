import java.util.HashMap;
import java.util.Map;

/**
 * Class to store a DisjointSet data structure. This data structure has two
 * main functions: find and union. find will look for the root (parent) of a
 * DisjointSet. Calling find on two different T data will check if those two are
 * part of the same set. union will join two sets together if not already.
 *
 * Use this for Kruskal's Algorithm.
 *
 * DO NOT EDIT THIS CLASS!!!
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public class DisjointSet<T> {

    private Map<T, DisjointSetNode<T>> disjointSet;

    /**
     * Initializes the disjoint sets by lazily instantiating the HashMap
     */
    public DisjointSet() {
        disjointSet = new HashMap<>();
    }

    /**
     * Finds the root node of the disjoint set containing
     * the data in {@code data}.
     *
     * @param data the vertex containing the data to search for
     * @return the disjoint set's root data
     */
    public T find(Vertex<T> data) {
        return find(data.getData());
    }

    /**
     * Finds the root node of the disjoint set containing {@code data}.
     * Puts the data in the disjoint sets if it does not already exist
     *
     * @param data the data to search for
     * @return the disjoint set's root data
     */
    public T find(T data) {
        if (disjointSet.containsKey(data)) {
            return find(disjointSet.get(data)).getData();
        } else {
            disjointSet.put(data, new DisjointSetNode<>(data));
            return find(disjointSet.get(data)).getData();
        }
    }

    /**
     * Recursively finds the root of the DisjointSetNode. Performs path
     * compression such that all DisjointSetNodes along the path to the root
     * will all directly point to the root.
     *
     * @param curr the current DisjointSetNode to find the root of
     * @return the root of the current node
     */
    private DisjointSetNode<T> find(DisjointSetNode<T> curr) {
        DisjointSetNode<T> parent = curr.getParent();
        if (parent == curr) {
            return curr;
        } else {
            parent = find(curr.getParent());
            curr.setParent(parent);
            return parent;
        }
    }

    /**
     * Attempts to join the two data into the same set by pointing the parent
     * of one set to the parent of another set.
     *
     * @param first The first data to find the parent of
     * @param second The second data to find the parent of
     */
    public void union(T first, T second) {
        union(disjointSet.get(first), disjointSet.get(second));
    }

    /**
     * This is where the work is done for union().  This method finds the
     * roots of both passed in nodes and checks if they are the same root.
     * If not the same root, the the root with the least rank will point
     * the the node with higher rank using merge by rank.
     *
     * @param first The first DisjointSetNode to find the parent of
     * @param second The second DisjointSetNode to find the parent of
     */
    private void union(DisjointSetNode<T> first, DisjointSetNode<T> second) {
        // Finds parents
        DisjointSetNode<T> firstParent = find(first);
        DisjointSetNode<T> secondParent = find(second);

        // If parents are different (different sets)
        if (firstParent != secondParent) {
            if (firstParent.getRank() < secondParent.getRank()) {
                firstParent.setParent(secondParent);
            } else {
                secondParent.setParent(firstParent);
                if (firstParent.getRank() == secondParent.getRank()) {
                    firstParent.setRank(firstParent.getRank() + 1);
                }
            }
        }
    }
}