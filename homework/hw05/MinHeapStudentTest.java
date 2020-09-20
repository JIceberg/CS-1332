import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * This is a basic set of unit tests for MinHeap.
 *
 * Passing these tests doesn't guarantee any grade on these assignments. These
 * student JUnits that we provide should be thought of as a sanity check to
 * help you get started on the homework and writing JUnits in general.
 *
 * We highly encourage you to write your own set of JUnits for each homework
 * to cover edge cases you can think of for each data structure. Your code must
 * work correctly and efficiently in all cases, which is why it's important
 * to write comprehensive tests to cover as many cases as possible.
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public class MinHeapStudentTest {

    private static final int TIMEOUT = 200;
    private MinHeap<Integer> minHeap;

    @Before
    public void setUp() {
        minHeap = new MinHeap<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, minHeap.size());
        assertArrayEquals(new Comparable[MinHeap.INITIAL_CAPACITY],
                minHeap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeap() {
        /*
                 6
               /   \
              8     4
             / \
            2   1

            ->

                 1
               /   \
              2     4
             / \
            6   8
        */
        ArrayList<Integer> data = new ArrayList<>();
        data.add(6);
        data.add(8);
        data.add(4);
        data.add(2);
        data.add(1);
        minHeap = new MinHeap<>(data);

        assertEquals(5, minHeap.size());
        Integer[] expected = new Integer[11];
        expected[1] = 1;
        expected[2] = 2;
        expected[3] = 4;
        expected[4] = 6;
        expected[5] = 8;
        assertArrayEquals(expected, minHeap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAdd() {
        /*
                 1
               /   \
              2     4
             / \
            6   8
        */
        minHeap.add(4);
        minHeap.add(2);
        minHeap.add(6);
        minHeap.add(1);
        minHeap.add(8);

        assertEquals(5, minHeap.size());
        Integer[] expected = new Integer[MinHeap.INITIAL_CAPACITY];
        expected[1] = 1;
        expected[2] = 2;
        expected[3] = 6;
        expected[4] = 4;
        expected[5] = 8;
        assertArrayEquals(expected, minHeap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testRemove() {
        /*
                 1
               /   \
              2     4
             / \
            8   6

            ->

              6
             /
            8
        */
        minHeap.add(4);
        minHeap.add(8);
        minHeap.add(2);
        minHeap.add(6);
        minHeap.add(1);
        assertEquals((Integer) 1, minHeap.remove());
        assertEquals((Integer) 2, minHeap.remove());
        assertEquals((Integer) 4, minHeap.remove());

        assertEquals(2, minHeap.size());
        Integer[] expected = new Integer[MinHeap.INITIAL_CAPACITY];
        expected[1] = 6;
        expected[2] = 8;
        assertArrayEquals(expected, minHeap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testGetMin() {
        Integer temp = 1;

        /*
                 1
               /   \
              2     3
             / \
            4   5
         */
        minHeap.add(temp);
        for (int i = 2; i < 6; i++) {
            minHeap.add(i);
        }

        assertSame(temp, minHeap.getMin());
    }

    @Test(timeout = TIMEOUT)
    public void testIsEmptyAndClear() {
        // Should be empty at initialization
        assertTrue(minHeap.isEmpty());

        // Should not be empty after adding elements
        /*
                 1
               /   \
              2     3
             / \
            4   5
         */
        for (int i = 1; i < 6; i++) {
            minHeap.add(i);
        }
        assertFalse(minHeap.isEmpty());

        // Clearing the list should empty the array and reset size
        minHeap.clear();
        assertTrue(minHeap.isEmpty());
        assertEquals(0, minHeap.size());
        assertArrayEquals(new Comparable[MinHeap.INITIAL_CAPACITY],
                minHeap.getBackingArray());
    }
}