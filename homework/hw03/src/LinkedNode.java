/**
 * Node class used for implementing your linked data structures.
 *
 * DO NOT MODIFY THIS FILE!!
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public class LinkedNode<T> {

    private T data;
    private LinkedNode<T> previous;
    private LinkedNode<T> next;

    /**
     * Constructs a new LinkedNode with the given data and node references.
     *
     * @param data     the data stored in the new node
     * @param previous the previous node in the structure
     * @param next     the next node in the structure
     */
    LinkedNode(T data, LinkedNode<T> previous, LinkedNode<T> next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    /**
     * Constructs a new LinkedNode with only the given data.
     *
     * @param data the data stored in the new node
     */
    LinkedNode(T data) {
        this(data, null, null);
    }

    /**
     * Gets the data.
     *
     * @return the data
     */
    T getData() {
        return data;
    }

    /**
     * Gets the previous node.
     *
     * @return the previous node
     */
    LinkedNode<T> getPrevious() {
        return previous;
    }

    /**
     * Gets the next node.
     *
     * @return the next node
     */
    LinkedNode<T> getNext() {
        return next;
    }

    /**
     * Sets the previous node.
     *
     * @param previous the new previous node
     */
    void setPrevious(LinkedNode<T> previous) {
        this.previous = previous;
    }

    /**
     * Sets the next node.
     *
     * @param next the new next node
     */
    void setNext(LinkedNode<T> next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return "Node containing: " + data;
    }
}