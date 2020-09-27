import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Charlie Jenkins cjenkins72@gatech.edu
 * @version 1.0
 */
public class MinHeapCharlieTest {
    private static final int TIMEOUT = 200;
    private MinHeap<Integer> minHeap;

    @Before
    public void setUp() {
        minHeap = new MinHeap<>();
    }

    @Test
    public void removeOneChild() {
        minHeap.add(1);
        minHeap.add(2);
        assertEquals((Integer) 1, minHeap.remove());
        Integer[] testArray = new Integer[MinHeap.INITIAL_CAPACITY];
        testArray[1] = 2;
        assertArrayEquals(testArray, minHeap.getBackingArray());
    }

    @Test
    public void removeTwoChildren() {
        minHeap.add(1);
        minHeap.add(3);
        minHeap.add(2);
        assertEquals((Integer) 1, minHeap.remove());
        Integer[] testArray = new Integer[MinHeap.INITIAL_CAPACITY];
        testArray[1] = 2;
        testArray[2] = 3;
        assertArrayEquals(testArray, minHeap.getBackingArray());
    }

    @Test
    public void removeOddChildren() {
        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(3);
        minHeap.add(4);
        minHeap.add(5);
        minHeap.add(6);
        minHeap.add(7);
        assertEquals((Integer) 1, minHeap.remove());
        Integer[] testArray = new Integer[MinHeap.INITIAL_CAPACITY];
        testArray[1] = 2;
        testArray[2] = 4;
        testArray[3] = 3;
        testArray[4] = 7;
        testArray[5] = 5;
        testArray[6] = 6;
        assertArrayEquals(testArray, minHeap.getBackingArray());
    }

    @Test
    public void removeEvenChildren() {
        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(3);
        minHeap.add(4);
        minHeap.add(5);
        minHeap.add(6);
        minHeap.add(7);
        minHeap.add(8);
        assertEquals((Integer) 1, minHeap.remove());
        Integer[] testArray = new Integer[MinHeap.INITIAL_CAPACITY];
        testArray[1] = 2;
        testArray[2] = 4;
        testArray[3] = 3;
        testArray[4] = 8;
        testArray[5] = 5;
        testArray[6] = 6;
        testArray[7] = 7;
        assertArrayEquals(testArray, minHeap.getBackingArray());
    }

    @Test
    public void removeWithOneTerminatingDownheap() {
        minHeap.add(2);
        minHeap.add(3);
        minHeap.add(4);
        minHeap.add(6);
        minHeap.add(7);
        minHeap.add(5);
        assertEquals((Integer) 2, minHeap.remove());
        Integer[] testArray = new Integer[MinHeap.INITIAL_CAPACITY];
        testArray[1] = 3;
        testArray[2] = 5;
        testArray[3] = 4;
        testArray[4] = 6;
        testArray[5] = 7;
        assertArrayEquals(testArray, minHeap.getBackingArray());
    }

    @Test
    public void smallerRightChild() {
        minHeap.add(1);
        minHeap.add(3);
        minHeap.add(2);
        minHeap.add(5);
        minHeap.add(4);
        minHeap.add(7);
        minHeap.add(6);
        minHeap.add(8);
        assertEquals((Integer) 1, minHeap.remove());
        Integer[] testArray = new Integer[MinHeap.INITIAL_CAPACITY];
        testArray[1] = 2;
        testArray[2] = 3;
        testArray[3] = 6;
        testArray[4] = 5;
        testArray[5] = 4;
        testArray[6] = 7;
        testArray[7] = 8;
        assertArrayEquals(testArray, minHeap.getBackingArray());
    }

    @Test
    public void buildHeap() {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(8);
        array.add(7);
        array.add(6);
        array.add(5);
        array.add(4);
        array.add(3);
        array.add(2);
        array.add(1);
        minHeap = new MinHeap<>(array);
        Integer[] testArray = new Integer[array.size() * 2 + 1];
        testArray[1] = 1;
        testArray[2] = 4;
        testArray[3] = 2;
        testArray[4] = 5;
        testArray[5] = 8;
        testArray[6] = 3;
        testArray[7] = 6;
        testArray[8] = 7;
        assertArrayEquals(testArray, minHeap.getBackingArray());
    }
}