import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Hey we're almost to the end of data structures!
 *
 * (I found it hard to make tests for this one so not sure what else I should've
 * tested)
 *
 * @author Justin Hinckley
 * @version 1.0
 */
public class MinHeapJustinTest {

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

    // ============================ START ============================

    @Test(timeout = TIMEOUT)
    public void testAddPastDoublePoint() {
        minHeap.add(4);
        minHeap.add(2);
        minHeap.add(6);
        minHeap.add(1);
        minHeap.add(8);
        minHeap.add(7);
        minHeap.add(10);
        minHeap.add(9);
        minHeap.add(100);
        minHeap.add(101);
        minHeap.add(250);
        minHeap.add(175);

        assertEquals(12, minHeap.size());
        Integer[] expected = new Integer[MinHeap.INITIAL_CAPACITY];
        expected[1] = 1;
        expected[2] = 2;
        expected[3] = 6;
        expected[4] = 4;
        expected[5] = 8;
        expected[6] = 7;
        expected[7] = 10;
        expected[8] = 9;
        expected[9] = 100;
        expected[10] = 101;
        expected[11] = 250;
        expected[12] = 175;
        assertArrayEquals(expected, minHeap.getBackingArray());

        minHeap.add(3);

        assertEquals(13, minHeap.size());

        expected = new Integer[MinHeap.INITIAL_CAPACITY * 2];
        expected[1] = 1;
        expected[2] = 2;
        expected[3] = 3;
        expected[4] = 4;
        expected[5] = 8;
        expected[6] = 6;
        expected[7] = 10;
        expected[8] = 9;
        expected[9] = 100;
        expected[10] = 101;
        expected[11] = 250;
        expected[12] = 175;
        expected[13] = 7;
        assertArrayEquals(expected, minHeap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddPastDoublePointTwice() {
        Integer[] expected = new Integer[MinHeap.INITIAL_CAPACITY * 2 * 2];
        for (int i = 0; i < 26; ++i)  {
            minHeap.add(0);
            expected[i + 1] = 0;
        }

        assertArrayEquals(expected, minHeap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddPastDoublePointAndRemove() {
        Integer[] expected = new Integer[MinHeap.INITIAL_CAPACITY * 2];
        for (int i = 0; i < 13; ++i)  {
            minHeap.add(i);
            expected[i + 1] = i;
        }

        assertEquals((Integer) 0, minHeap.remove());
        expected = new Integer[MinHeap.INITIAL_CAPACITY * 2];
        expected[1] = 1;
        expected[2] = 3;
        expected[3] = 2;
        expected[4] = 7;
        expected[5] = 4;
        expected[6] = 5;
        expected[7] = 6;
        expected[8] = 12;
        expected[9] = 8;
        expected[10] = 9;
        expected[11] = 10;
        expected[12] = 11;

        assertEquals(12, minHeap.size());
        assertArrayEquals(expected, minHeap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testGetMin() {
        /*
                 1
               /   \
              2     3
             / \
            4   5
         */
        minHeap.add(1);
        for (int i = 2; i < 6; i++) {
            minHeap.add(i);
        }

        assertEquals((Integer) 1, minHeap.getMin());
        assertEquals(5, minHeap.size());
        minHeap.remove();
        assertEquals((Integer) 2, minHeap.getMin());
        assertEquals(4, minHeap.size());
        minHeap.remove();
        assertEquals((Integer) 3, minHeap.getMin());
        assertEquals(3, minHeap.size());
        minHeap.remove();
        assertEquals((Integer) 4, minHeap.getMin());
        assertEquals(2, minHeap.size());
        minHeap.remove();
        assertEquals((Integer) 5, minHeap.getMin());
        assertEquals(1, minHeap.size());
        minHeap.remove();
        assertEquals(0, minHeap.size());
    }

    // ============================ Exception Testing ============================

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testArgConstructorNullData() {
        minHeap = new MinHeap(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testArgConstructorNullElem() {
        ArrayList<Integer> param = new ArrayList<>();
        param.add(1);
        param.add(null);
        param.add(2);
        minHeap = new MinHeap(param);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddNullData() {
        minHeap.add(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveWhenEmpty() {
        minHeap.remove();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveWhenEmptyV2() {
        minHeap.add(9);
        minHeap.remove();

        minHeap.remove();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testGetMinWhenEmpty() {
        minHeap.getMin();
    }
}