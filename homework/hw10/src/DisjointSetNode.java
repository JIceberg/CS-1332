/**
 * Class to store a DisjointSetNode.  This class is used ONLY for the
 * DisjointSet class.
 *
 * DO NOT use this class for your implementation and DO NOT edit this class.
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public class DisjointSetNode<T> {

    private DisjointSetNode<T> parent;
    private T data;
    private int rank;

    /**
     * Creates a DisjointSetNode to be used with DisjointSet.
     *
     * @param data the data to be stored
     */
    public DisjointSetNode(T data) {
        this.parent = this;
        this.data = data;
        this.rank = 0;
    }

    /**
     * Gets the parent.
     *
     * @return the parent
     */
    public DisjointSetNode<T> getParent() {
        return parent;
    }

    /**
     * Gets the data.
     *
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * Gets the rank.
     *
     * @return the rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * Sets the parent.
     *
     * @param parent the new parent
     */
    public void setParent(DisjointSetNode<T> parent) {
        this.parent = parent;
    }

    /**
     * Sets the data.
     *
     * @param data the new data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Sets the rank.
     *
     * @param rank the new rank
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Rank: " + rank + ", Parent: "
            + parent.getData();
    }
}