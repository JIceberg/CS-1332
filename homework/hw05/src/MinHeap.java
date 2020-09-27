import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 *
 * @author Jackson Isenberg
 * @version 1.2
 * @userid jisenberg3
 * @GTID 903556168
 *
 * Collaborators: N/A
 *
 * Resources: N/A
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap when created with the default
     * constructor.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    // Do not add new instance variables or modify existing ones.
    private T[] backingArray;
    private int size;

    /**
     * Constructs a new MinHeap.
     *
     * The backing array should have an initial capacity of INITIAL_CAPACITY.
     */
    public MinHeap() {
        clear();
    }

    /**
     * Creates a properly ordered heap from a set of initial values.
     *
     * You must use the BuildHeap algorithm that was taught in lecture! Simply
     * adding the data one by one using the add method will not get any credit.
     * As a reminder, this is the algorithm that involves building the heap
     * from the bottom up by repeated use of downHeap operations.
     *
     * Before doing the algorithm, first copy over the data from the
     * ArrayList to the backingArray (leaving index 0 of the backingArray
     * empty). The data in the backingArray should be in the same order as it
     * appears in the passed in ArrayList before you start the BuildHeap
     * algorithm.
     *
     * The backingArray should have capacity 2n + 1 where n is the
     * number of data in the passed in ArrayList (not INITIAL_CAPACITY).
     * Index 0 should remain empty, indices 1 to n should contain the data in
     * proper order, and the rest of the indices should be empty.
     *
     * @param data a list of data to initialize the heap with
     * @throws java.lang.IllegalArgumentException if data or any element in data
     *                                            is null
     */
    public MinHeap(ArrayList<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot build a heap with a null list");
        }

        backingArray = (T[]) new Comparable[data.size() * 2 + 1];
        size = data.size();

        for (int i = 1; i <= size; i++) {
            if (data.get(i - 1) == null) {
                throw new IllegalArgumentException("Cannot build a heap with a null element in the list");
            }
            backingArray[i] = data.get(i - 1);
        }

        for (int index = size; index > 1; index -= 2) {
            int i = index / 2;
            while (i != 0) {
                i = downHeap(i);
            }
        }
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * @param data the data to add
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null data to the heap");
        }
        size++;
        if (size < backingArray.length) {
            backingArray[size] = data;
            int index = size / 2;
            int dataIndex = size;
            T parent = backingArray[index];
            while (index > 0 && parent.compareTo(data) > 0) {
                backingArray[dataIndex] = parent;
                backingArray[index] = data;
                dataIndex = index;
                index /= 2;
                parent = backingArray[index];
            }
        } else {
            T[] newBackingArray = (T[]) new Comparable[backingArray.length * 2];
            newBackingArray[size] = data;
            int index = size / 2;
            int dataIndex = size;
            for (int i = size - 1; i > 0; i--) {
                if (i != index) {
                    newBackingArray[i] = backingArray[i];
                } else {
                    T parent = backingArray[index];
                    if (parent.compareTo(data) > 0) {
                        newBackingArray[dataIndex] = parent;
                        newBackingArray[i] = data;
                    } else {
                        newBackingArray[i] = backingArray[i];
                    }
                    dataIndex = index;
                    index /= 2;
                }
            }
            backingArray = newBackingArray;
        }
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * @return the data that was removed
     * @throws java.util.NoSuchElementException if the heap is empty
     */
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty heap");
        }
        T tmp = backingArray[1];
        backingArray[1] = backingArray[size];
        backingArray[size] = null;
        size--;

        // algorithm for down-heap
        int index = 1;
        while (index != 0) {
            index = downHeap(index);
        }

        return tmp;
    }

    /**
     * The down-heap algorithm.
     *
     * @param index the index from which we are comparing
     * @return the index of the child with which we had swapped
     */
    private int downHeap(int index) {
        T swapper = backingArray[index];
        int leftIndex = 2 * index;
        int rightIndex = 2 * index + 1;
        T leftChild = leftIndex >= backingArray.length ? null : backingArray[leftIndex];
        T rightChild = rightIndex >= backingArray.length ? null : backingArray[rightIndex];

        if (leftChild != null && rightChild != null) {
            if (leftChild.compareTo(swapper) < 0 && rightChild.compareTo(swapper) < 0) {
                if (leftChild.compareTo(rightChild) < 0) {
                    backingArray[leftIndex] = swapper;
                    backingArray[index] = leftChild;
                    return leftIndex;
                } else {
                    backingArray[rightIndex] = swapper;
                    backingArray[index] = rightChild;
                    return rightIndex;
                }
            } else if (leftChild.compareTo(swapper) < 0) {
                backingArray[leftIndex] = swapper;
                backingArray[index] = leftChild;
                return leftIndex;
            } else if (rightChild.compareTo(swapper) < 0) {
                backingArray[rightIndex] = swapper;
                backingArray[index] = rightChild;
                return rightIndex;
            }
        } else if (leftChild != null && leftChild.compareTo(swapper) < 0) {
            backingArray[leftIndex] = swapper;
            backingArray[index] = leftChild;
            return leftIndex;
        } else if (rightChild != null && rightChild.compareTo(swapper) < 0) {
            backingArray[rightIndex] = swapper;
            backingArray[index] = rightChild;
            return rightIndex;
        }

        return 0;
    }

    /**
     * Returns the minimum element in the heap.
     *
     * @return the minimum element
     * @throws java.util.NoSuchElementException if the heap is empty
     */
    public T getMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot retrieve data from an empty heap");
        }
        return backingArray[1];
    }

    /**
     * Returns whether or not the heap is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clears the heap.
     *
     * Resets the backing array to a new array of the initial capacity and
     * resets the size.
     */
    public void clear() {
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
