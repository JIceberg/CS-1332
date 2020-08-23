/**
 * Node class used for implementing the DoublyLinkedList.
 *
 * DO NOT MODIFY THIS FILE!!
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public class DoublyLinkedListNode<T> {

    private T data;
    private DoublyLinkedListNode<T> previous;
    private DoublyLinkedListNode<T> next;

    /**
     * Constructs a new DoublyLinkedListNode with the given data and node
     * references.
     *
     * @param data     the data stored in the new node
     * @param previous the previous node in the list
     * @param next     the next node in the list
     */
    DoublyLinkedListNode(T data, DoublyLinkedListNode<T> previous,
                         DoublyLinkedListNode<T> next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    /**
     * Constructs a new DoublyLinkedListNode with only the given data.
     *
     * @param data the data stored in the new node
     */
    DoublyLinkedListNode(T data) {
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
    DoublyLinkedListNode<T> getPrevious() {
        return previous;
    }

    /**
     * Gets the next node.
     *
     * @return the next node
     */
    DoublyLinkedListNode<T> getNext() {
        return next;
    }

    /**
     * Sets the previous node.
     *
     * @param previous the new previous node
     */
    void setPrevious(DoublyLinkedListNode<T> previous) {
        this.previous = previous;
    }

    /**
     * Sets the next node.
     *
     * @param next the new next node
     */
    void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return "Node containing: " + data;
    }
}