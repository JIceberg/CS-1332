import java.util.NoSuchElementException;

/**
 * Your implementation of a non-circular DoublyLinkedList with a tail pointer.
 *
 * @author Jackson Isenberg
 * @version 1.0
 * @userid jisenberg3
 * @GTID 903556168
 *
 * Collaborators: N/A
 *
 * Resources: N/A
 */
public class DoublyLinkedList<T> {

    // Do not add new instance variables or modify existing ones.
    private DoublyLinkedListNode<T> head;
    private DoublyLinkedListNode<T> tail;
    private int size;

    // Do not add a constructor.

    /**
     * Adds the element to the specified index. Don't forget to consider whether
     * traversing the list from the head or tail is more efficient!
     *
     * Must be O(1) for indices 0 and size and O(n) for all other cases.
     *
     * @param index the index at which to add the new element
     * @param data  the data to add at the specified index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index > size
     * @throws java.lang.IllegalArgumentException  if data is null
     */
    public void addAtIndex(int index, T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null data to the list");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index
                    + " is not within range 0 to " + size);
        } else if (index == 0) {
            addToFront(data);
        } else if (index == size) {
            addToBack(data);
        } else if (index <= size / 2) {  // here we are going to iterate starting at the head
            DoublyLinkedListNode<T> curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.getNext();
            }
            DoublyLinkedListNode<T> prev = curr.getPrevious();
            DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(data, prev, curr);
            prev.setNext(newNode);
            curr.setPrevious(newNode);
            size++;
        } else {                         // here we are going to iterate starting at the tail
            DoublyLinkedListNode<T> curr = tail;
            for (int i = size - 1; i > index; i--) {
                curr = curr.getPrevious();
            }
            DoublyLinkedListNode<T> prev = curr.getPrevious();
            DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(data, prev, curr);
            prev.setNext(newNode);
            curr.setPrevious(newNode);
            size++;
        }
    }

    /**
     * Adds the element to the front of the list.
     *
     * Must be O(1).
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null data to the list");
        }
        if (head == null) {
            head = new DoublyLinkedListNode<>(data, null, tail);
            tail = head;
        } else if (tail == null) {
            tail = head;
            DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(data, null, tail);
            head.setPrevious(newNode);
            head = newNode;
        } else {
            DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(data, null, head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
    }

    /**
     * Adds the element to the back of the list.
     *
     * Must be O(1).
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null data to the list");
        }
        if (tail == null) {
            tail = new DoublyLinkedListNode<>(data, head, null);
            head = tail;
        } else if (head == null) {
            head = tail;
            DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(data, head, null);
            tail.setNext(newNode);
            tail = newNode;
        } else {
            DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(data, tail, null);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the element at the specified index. Don't forget to
     * consider whether traversing the list from the head or tail is more
     * efficient!
     *
     * Must be O(1) for indices 0 and size - 1 and O(n) for all other cases.
     *
     * @param index the index of the element to remove
     * @return the data formerly located at the specified index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index
                    + " is not within range 0 to " + (size - 1));
        } else if (index == 0) {
            return removeFromFront();
        } else if (index == size - 1) {
            return removeFromBack();
        } else if (index <= size / 2) {  // here we are going to iterate starting at the head
            DoublyLinkedListNode<T> curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.getNext();
            }
            DoublyLinkedListNode<T> prev = curr.getPrevious();
            DoublyLinkedListNode<T> next = curr.getNext();
            size--;
            prev.setNext(next);
            next.setPrevious(prev);
            return curr.getData();
        } else {                         // here we are going to iterate starting at the tail
            DoublyLinkedListNode<T> curr = tail;
            for (int i = size - 1; i > index; i--) {
                curr = curr.getPrevious();
            }
            DoublyLinkedListNode<T> prev = curr.getPrevious();
            DoublyLinkedListNode<T> next = curr.getNext();
            size--;
            prev.setNext(next);
            next.setPrevious(prev);
            return curr.getData();
        }
    }

    /**
     * Removes and returns the first element of the list.
     *
     * Must be O(1).
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        if (head == null || isEmpty()) {
            throw new NoSuchElementException("Cannot remove an element from an empty list");
        }
        T temp = head.getData();
        if (size != 1) {
            head = head.getNext();
            head.setPrevious(null);
            size--;
        } else {
            this.clear();
        }
        return temp;
    }

    /**
     * Removes and returns the last element of the list.
     *
     * Must be O(1).
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        if (tail == null || isEmpty()) {
            throw new NoSuchElementException("Cannot remove an element from an empty list");
        }
        T temp = tail.getData();
        if (size != 1) {
            tail = tail.getPrevious();
            tail.setNext(null);
            size--;
        } else {
            this.clear();
        }
        return temp;
    }

    /**
     * Returns the element at the specified index. Don't forget to consider
     * whether traversing the list from the head or tail is more efficient!
     *
     * Must be O(1) for indices 0 and size - 1 and O(n) for all other cases.
     *
     * @param index the index of the element to get
     * @return the data stored at the index in the list
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index
                    + " is not within range 0 to " + (size - 1));
        } else if (index == 0) {
            return head.getData();
        } else if (index == size - 1) {
            return tail.getData();
        } else if (index <= size / 2) {  // here we are going to iterate starting at the head
            DoublyLinkedListNode<T> curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.getNext();
            }
            return curr.getData();
        } else {                         // here we are going to iterate starting at the tail
            DoublyLinkedListNode<T> curr = tail;
            for (int i = size - 1; i > index; i--) {
                curr = curr.getPrevious();
            }
            return curr.getData();
        }
    }

    /**
     * Returns whether or not the list is empty.
     *
     * Must be O(1).
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0 || head == null && tail == null;
    }

    /**
     * Clears the list.
     *
     * Clears all data and resets the size.
     *
     * Must be O(1).
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Removes and returns the last copy of the given data from the list.
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the list.
     *
     * Must be O(1) if data is in the tail and O(n) for all other cases.
     *
     * @param data the data to be removed from the list
     * @return the data that was removed
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if data is not found
     */
    public T removeLastOccurrence(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot remove null data from the list");
        }
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty list");
        }
        DoublyLinkedListNode<T> curr = tail;
        while (!data.equals(curr.getData()) && curr != head) {
            curr = curr.getPrevious();
        }
        if (!data.equals(curr.getData())) {
            throw new NoSuchElementException("Cannot remove data not in list: " + data);
        }
        if (curr == head) {
            return removeFromFront();
        }
        if (curr == tail) {
            return removeFromBack();
        }
        DoublyLinkedListNode<T> prev = curr.getPrevious();
        DoublyLinkedListNode<T> next = curr.getNext();
        size--;
        prev.setNext(next);
        next.setPrevious(prev);
        return curr.getData();
    }

    /**
     * Returns an array representation of the linked list.
     *
     * Must be O(n) for all cases.
     *
     * @return an array of length size holding all of the objects in the
     * list in the same order
     */
    public Object[] toArray() {
        Object[] arr = new Object[size];
        DoublyLinkedListNode<T> curr = head;
        int index = 0;
        while (curr != null && index < size) {
            arr[index++] = curr.getData();
            curr = curr.getNext();
        }
        return arr;
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public DoublyLinkedListNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public DoublyLinkedListNode<T> getTail() {
        // DO NOT MODIFY!
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY!
        return size;
    }
}
