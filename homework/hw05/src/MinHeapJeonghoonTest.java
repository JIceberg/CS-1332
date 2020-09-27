import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * CS1332 HW5 Test
 * @author Jeonghoon Lee
 * @version 1.0
 */
public class MinHeapJeonghoonTest {

    private static final int TIMEOUT = 200;
    private MinHeap<Integer> minHeap;

    @Before
    public void setUp() {
        minHeap = new MinHeap<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, minHeap.size());
        assertArrayEquals(new Comparable[MinHeap.INITIAL_CAPACITY], minHeap.getBackingArray());
        assertEquals(0, minHeap.size());
    }

    @Test(timeout = TIMEOUT)
    public void testConstructor2() {
        /*
                 1
                 data : [1]
            ->
                 1
                 backingArray : [null] [1] [null]
                 1. The backingArray should have capacity 2n + 1
                 where n is the number of data in the passed in ArrayList
                 (not INITIAL_CAPACITY).
                 2. leaving index 0 of the backingArray empty.
        */

        ArrayList<Integer> data = new ArrayList<>();
        data.add(1);
        minHeap = new MinHeap<>(data);
        assertEquals(1, minHeap.size());
        Integer[] list = new Integer[(2 * data.size()) + 1];
        list[1] = 1; // list : [null] [1] [null]
        assertArrayEquals(list, minHeap.getBackingArray());


        /*
                 1
                /
               2
                 data : [1] [2]
            ->
                 1
                /
               2
                 backingArray : [null] [1] [2] [null] [null]
                 1. The backingArray should have capacity 2n + 1
                 where n is the number of data in the passed in ArrayList
                 (not INITIAL_CAPACITY).
                 2. leaving index 0 of the backingArray empty.
        */

        data = new ArrayList<>();
        data.add(1);
        data.add(2);
        minHeap = new MinHeap<>(data);
        assertEquals(2, minHeap.size());


        list = new Integer[(2 * data.size()) + 1];
        list[1] = 1; // list : [null] [1] [2] [null] [null]
        list[2] = 2;
        assertArrayEquals(list, minHeap.getBackingArray());



        /*
                 2
                /
               1
                 data : [2] [1]
            ->
                 1
                /
               2
                 backingArray : [null] [1] [2] [null] [null]
                 1. The backingArray should have capacity 2n + 1
                 where n is the number of data in the passed in ArrayList
                 (not INITIAL_CAPACITY).
                 2. leaving index 0 of the backingArray empty.
        */

        data = new ArrayList<>();
        data.add(2);
        data.add(1);
        minHeap = new MinHeap<>(data);
        assertEquals(2, minHeap.size());

        list = new Integer[(2 * data.size()) + 1];
        list[1] = 1; // list : [null] [1] [2] [null] [null]
        list[2] = 2;
        assertArrayEquals(list, minHeap.getBackingArray());


        /*
                 2
                / \
               1   3
                 data : [2] [1] [3]
            ->
                 1
                / \
               2   3
                 backingArray : [null] [1] [2] [3] [null] [null] [null]
                 1. The backingArray should have capacity 2n + 1
                 where n is the number of data in the passed in ArrayList
                 (not INITIAL_CAPACITY).
                 2. leaving index 0 of the backingArray empty.
        */

        data = new ArrayList<>();
        data.add(2);
        data.add(1);
        data.add(3);
        minHeap = new MinHeap<>(data);
        assertEquals(3, minHeap.size());

        list = new Integer[(2 * data.size()) + 1];
        list[1] = 1; // list : [null] [1] [2] [3] [null] [null] [null]
        list[2] = 2;
        list[3] = 3;
        assertArrayEquals(list, minHeap.getBackingArray());


        /*
                 8
                / \
               7   (5)
              / \  /
             3  0 (2)
                 data : [8] [7] [5] [3] [0] [2]
            ->
                 8
                / \
              (7)  2
              /\   /
             3 (0) 5
            ->
                (8)
                / \
              (0)  2
              / \ /
             3  7 5
            ->
                 0
                / \
              (8)  2
              / \ /
            (3) 7 5
            ->
                 0
                / \
               3   2
              / \ /
             8  7 5
                 backingArray : [null] [0] [3] [2] [8] [7] [5] [null] [null] [null] [null] [null] [null]
                 1. The backingArray should have capacity 2n + 1
                 where n is the number of data in the passed in ArrayList
                 (not INITIAL_CAPACITY).
                 2. leaving index 0 of the backingArray empty.
        */

        data = new ArrayList<>();
        data.add(8);
        data.add(7);
        data.add(5);
        data.add(3);
        data.add(0);
        data.add(2);
        minHeap = new MinHeap<>(data);
        assertEquals(6, minHeap.size());

        list = new Integer[(2 * data.size()) + 1];
        list[1] = 0; // list : [null] [0] [3] [2] [8] [7] [5] [null] [null] [null] [null] [null] [null]
        list[2] = 3;
        list[3] = 2;
        list[4] = 8;
        list[5] = 7;
        list[6] = 5;
        assertArrayEquals(list, minHeap.getBackingArray());


        /*
                 8
                / \
               7   5
              / \ / \
            (3) 0 2  1
            /
          (-1)
                 data : [8] [7] [5] [3] [0] [2] [1] [-1]
            ->
                 8
                / \
               7  (5)
              / \ / \
            -1  0 2 (1)
            /
           3
            ->
                 8
                / \
              (7)  1
              / \ / \
           (-1) 0 2  5
            /
           3
            ->
                 8
                / \
              -1   1
              / \ / \
            (7) 0 2  5
            /
          (3)
          ->
                (8)
                / \
             (-1)  1
              / \ / \
             3  0 2  5
            /
           7
          ->
                -1
                / \
              (8)  1
              / \ / \
             3 (0)2  5
            /
           7
          ->
                 -1
                / \
               0   1
              / \ / \
             3  8 2  5
            /
           7
          backingArray : [null] [-1] [0] [1] [3] [8] [2] [5] [7] [null] [null] [null] [null] [null] [null] [null] [null]
          1. The backingArray should have capacity 2n + 1
             where n is the number of data in the passed in ArrayList
             (not INITIAL_CAPACITY).
          2. leaving index 0 of the backingArray empty.
        */

        data = new ArrayList<>();
        data.add(8);
        data.add(7);
        data.add(5);
        data.add(3);
        data.add(0);
        data.add(2);
        data.add(1);
        data.add(-1);
        minHeap = new MinHeap<>(data);
        assertEquals(8, minHeap.size());

        list = new Integer[(2 * data.size()) + 1];
        // list :[null] [-1] [0] [1] [3] [8] [2] [5] [7] [null] [null] [null] [null] [null] [null] [null] [null]
        list[1] = -1;
        list[2] = 0;
        list[3] = 1;
        list[4] = 3;
        list[5] = 8;
        list[6] = 2;
        list[7] = 5;
        list[8] = 7;
        assertArrayEquals(list, minHeap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testConstructorException() {
        try {
            minHeap = new MinHeap<>(null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        try {
            ArrayList<Integer> data = new ArrayList<>();
            data.add(1);
            data.add(null);
            data.add(3);

            minHeap = new MinHeap<>(data);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test(timeout = TIMEOUT)
    public void testAdd() {
        /*
                 5
        */
        minHeap.add(5);
        assertEquals(1, minHeap.size());
        Integer[] list = new Integer[MinHeap.INITIAL_CAPACITY];
        // [null] [5] [null] [null] [null] [null] [null] [null] [null] [null] [null] [null] [null]
        list[1] = 5;
        assertArrayEquals(list, minHeap.getBackingArray());

        /*
                 5
                /
               4
               ->
                 4
                /
               5
        */
        minHeap.add(4);
        assertEquals(2, minHeap.size());
        list = new Integer[MinHeap.INITIAL_CAPACITY];
        // [null] [4] [5] [null] [null] [null] [null] [null] [null] [null] [null] [null] [null]
        list[1] = 4;
        list[2] = 5;
        assertArrayEquals(list, minHeap.getBackingArray());

        /*
                 4
                / \
               5   3
               ->
                 3
                / \
               5   4
        */
        minHeap.add(3);
        assertEquals(3, minHeap.size());
        list = new Integer[MinHeap.INITIAL_CAPACITY];
        // [null] [3] [5] [4] [null] [null] [null] [null] [null] [null] [null] [null] [null]
        list[1] = 3;
        list[2] = 5;
        list[3] = 4;
        assertArrayEquals(list, minHeap.getBackingArray());

        /*
                 3
                / \
               5   4
              /
             2
               ->
                 3
                / \
              (5)  4
              /
            (2)
               ->
                (3)
                / \
              (2)  4
              /
             5
               ->
                 2
                / \
               3   4
              /
             5
        */
        minHeap.add(2);
        assertEquals(4, minHeap.size());
        list = new Integer[MinHeap.INITIAL_CAPACITY];
        // [null] [2] [3] [4] [5] [null] [null] [null] [null] [null] [null] [null] [null]
        list[1] = 2;
        list[2] = 3;
        list[3] = 4;
        list[4] = 5;
        assertArrayEquals(list, minHeap.getBackingArray());


        /*
                 2
                / \
               3   4
              / \
             5   1
             ->
                 2
                / \
              (3)  4
              / \
             5  (1)
             ->
                (2)
                / \
              (1)  4
              / \
             5   3
               ->
                 1
                / \
               2   4
              / \
             5   3
        */
        minHeap.add(1);

        assertEquals(5, minHeap.size());
        list = new Integer[MinHeap.INITIAL_CAPACITY];
        // [null] [1] [2] [4] [5] [3] [null] [null] [null] [null] [null] [null] [null]
        list[1] = 1;
        list[2] = 2;
        list[3] = 4;
        list[4] = 5;
        list[5] = 3;
        assertArrayEquals(list, minHeap.getBackingArray());


        /*
        Additional TEST
        ++
        minHeap.add(7);
        minHeap.add(0);
        minHeap.add(6);
        minHeap.add(-1);
        minHeap.add(-2);
        minHeap.add(-3);
        minHeap.add(-4);
        ++
                 -4
                 / \
               -2   -3
               /\    / \
              2 -1   1  4
             /\  /\  /
            6  5 3 0 7
            array : [null] [-4] [-2] [-3] [2] [-1] [1] [4] [6] [5] [3] [0] [7]
        */
        minHeap.add(7);
        minHeap.add(0);
        minHeap.add(6);
        minHeap.add(-1);
        minHeap.add(-2);
        minHeap.add(-3);
        minHeap.add(-4);
        assertEquals(12, minHeap.size());
        list = new Integer[MinHeap.INITIAL_CAPACITY];
        // [null] [-4] [-2] [-3] [2] [-1] [1] [4] [6] [5] [3] [0] [7]
        list[1] = -4;
        list[2] = -2;
        list[3] = -3;
        list[4] = 2;
        list[5] = -1;
        list[6] = 1;
        list[7] = 4;
        list[8] = 6;
        list[9] = 5;
        list[10] = 3;
        list[11] = 0;
        list[12] = 7;
        assertArrayEquals(list, minHeap.getBackingArray());

        /*
        * Adds an item to the heap. If the backing array is full (except for
        * index 0) and you're trying to add a new item, then double its capacity.
        * JavaDOCS
         ++
         minHeap.add(-5);
         ++
                ->
                 -5
                 / \
               -2   -4
               /\    / \
              2 -1  -3  4
             /\  /\  /\
            6  5 3 0 7 1
            array : [null] [-5] [-2] [-4] [2] [-1] [-3] [4] [6] [5] [3] [0] [7] [1] [null] x 12
         */
        minHeap.add(-5);
        assertEquals(13, minHeap.size());
        list = new Integer[2 * MinHeap.INITIAL_CAPACITY];
        // [null] [-5] [-2] [-4] [2] [-1] [-3] [4] [6] [5] [3] [0] [7] [1] [null] x 12
        list[1] = -5;
        list[2] = -2;
        list[3] = -4;
        list[4] = 2;
        list[5] = -1;
        list[6] = -3;
        list[7] = 4;
        list[8] = 6;
        list[9] = 5;
        list[10] = 3;
        list[11] = 0;
        list[12] = 7;
        list[13] = 1;

        assertArrayEquals(list, minHeap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddException() {
        try {
            minHeap.add(null);
            fail();
        } catch (IllegalArgumentException e) {

        }

        try {
            minHeap.add(1);
            minHeap.add(2);
            minHeap.add(null);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test(timeout = TIMEOUT)
    public void testRemove() {

        Integer intM5 = -5;
        Integer intM4 = -4;
        Integer intM3 = -3;
        Integer intM2 = -2;
        Integer intM1 = -1;
        Integer int7 = 7;
        Integer int6 = 6;
        Integer int5 = 5;
        Integer int4 = 4;
        Integer int3 = 3;
        Integer int2 = 2;
        Integer int1 = 1;
        Integer int0 = 0;


        /*
                 -5
                 / \
               -2   -4
               /\    / \
              2 -1  -3  4
             /\  /\  /\
            6  5 3 0 7 1
            array : [null] [-5] [-2] [-4] [2] [-1] [-3] [4] [6] [5] [3] [0] [7] [1] [null] x 12
         */

        minHeap.add(int5);
        minHeap.add(int4);
        minHeap.add(int3);
        minHeap.add(int2);
        minHeap.add(int1);
        minHeap.add(int7);
        minHeap.add(int0);
        minHeap.add(int6);
        minHeap.add(intM1);
        minHeap.add(intM2);
        minHeap.add(intM3);
        minHeap.add(intM4);
        minHeap.add(intM5);

        assertEquals(13, minHeap.size());
        Integer[] list = new Integer[2 * MinHeap.INITIAL_CAPACITY];
        // [null] [-5] [-2] [-4] [2] [-1] [-3] [4] [6] [5] [3] [0] [7] [1] [null] x 12
        list[1] = -5;
        list[2] = -2;
        list[3] = -4;
        list[4] = 2;
        list[5] = -1;
        list[6] = -3;
        list[7] = 4;
        list[8] = 6;
        list[9] = 5;
        list[10] = 3;
        list[11] = 0;
        list[12] = 7;
        list[13] = 1;
        assertArrayEquals(list, minHeap.getBackingArray());

        /*
                 -5
                 / \
               -2   -4
               /\    / \
              2 -1  -3  4
             /\  /\  /\
            6  5 3 0 7 1
            array : [null] [-5] [-2] [-4] [2] [-1] [-3] [4] [6] [5] [3] [0] [7] [1] [null] x 12
                  1*
                 / \
               -2   -4
               /\    / \
              2 -1  -3  4
             /\  /\  /\
            6  5 3 0 7 *
            array : [null] [1] [-2] [-4] [2] [-1] [-3] [4] [6] [5] [3] [0] [7] [null] [null] x 12
                 (1)
                 / \
               -2  (-4)
               /\    / \
              2 -1  -3  4
             /\  /\  /
            6  5 3 0 7
            -->
                 -4
                 / \
               -2   (1)
               /\    / \
              2 -1 (-3) 4
             /\  /\  /
            6  5 3 0 7
           -->
                  -4
                 /   \
               -2    -3
               /\    / \
              2 -1   1  4
             /\  /\  /
            6  5 3 0 7
            array : [null] [-4] [-2] [-3] [2] [-1] [1] [4] [6] [5] [3] [0] [7] [null] [null] x 12
         */

        assertSame(intM5, minHeap.remove());
        assertEquals(12, minHeap.size());
        list = new Integer[2 * MinHeap.INITIAL_CAPACITY];
        //array:  [null] [-4] [-2] [-3] [2] [-1] [1] [4] [6] [5] [3] [0] [7] [null] [null] x 12
        list[1] = -4;
        list[2] = -2;
        list[3] = -3;
        list[4] = 2;
        list[5] = -1;
        list[6] = 1;
        list[7] = 4;
        list[8] = 6;
        list[9] = 5;
        list[10] = 3;
        list[11] = 0;
        list[12] = 7;
        assertArrayEquals(list, minHeap.getBackingArray());

        /*
                  -4
                 /   \
               -2    -3
               /\    / \
              2 -1   1  4
             /\  /\  /
            6  5 3 0 7
            array : [null] [-4] [-2] [-3] [2] [-1] [1] [4] [6] [5] [3] [0] [7] [null] [null] x 12
                  7*
                 /   \
               -2    -3
               /\    / \
              2 -1   1  4
             /\  /\  /
            6  5 3 0 *
            array : [null] [7] [-2] [-3] [2] [-1] [1] [4] [6] [5] [3] [0] [null] [null] [null] x 12
            ->
                  (7)
                 /   \
               -2   (-3)
               /\    / \
              2 -1   1  4
             /\  /\
            6  5 3 0
            ->
                  -3
                 /   \
               -2    (7)
               /\    / \
              2 -1  (1) 4
             /\  /\
            6  5 3 0
            ->
                  -3
                 /   \
               -2    1
               /\    / \
              2 -1   7  4
             /\  /\
            6  5 3 0
            array : [null] [-3] [-2] [1] [2] [-1] [7] [4] [6] [5] [3] [0] [null] [null] [null] x 12
         */

        assertSame(intM4, minHeap.remove());
        assertEquals(11, minHeap.size());
        list = new Integer[2 * MinHeap.INITIAL_CAPACITY];
        //array : [null] [-3] [-2] [1] [2] [-1] [7] [4] [6] [5] [3] [0] [null] [null] [null] x 12
        list[1] = -3;
        list[2] = -2;
        list[3] = 1;
        list[4] = 2;
        list[5] = -1;
        list[6] = 7;
        list[7] = 4;
        list[8] = 6;
        list[9] = 5;
        list[10] = 3;
        list[11] = 0;
        assertArrayEquals(list, minHeap.getBackingArray());


        assertSame(intM3, minHeap.remove());
        assertSame(intM2, minHeap.remove());
        assertSame(intM1, minHeap.remove());
        assertSame(int0, minHeap.remove());
        assertSame(int1, minHeap.remove());
        assertSame(int2, minHeap.remove());
        assertSame(int3, minHeap.remove());
        assertSame(int4, minHeap.remove());
        assertSame(int5, minHeap.remove());
        assertSame(int6, minHeap.remove());
        assertSame(int7, minHeap.remove());

        assertEquals(0, minHeap.size());
        list = new Integer[2 * MinHeap.INITIAL_CAPACITY];
        assertArrayEquals(list, minHeap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveException() {
        try {
            minHeap.remove();
            fail();
        } catch (NoSuchElementException e) {

        }
    }

    @Test(timeout = TIMEOUT)
    public void testGetMin() {

        Integer int13 = 13;
        Integer int12 = 12;
        Integer int11 = 11;
        Integer int10 = 10;
        Integer int9 = 9;
        Integer int8 = 8;
        Integer int7 = 7;
        Integer int6 = 6;
        Integer int5 = 5;
        Integer int4 = 4;
        Integer int3 = 3;
        Integer int2 = 2;
        Integer int1 = 1;
        Integer int0 = 0;

        minHeap.add(int13);
        assertSame(int13, minHeap.getMin());

        minHeap.add(int12);
        assertSame(int12, minHeap.getMin());

        minHeap.add(int11);
        assertSame(int11, minHeap.getMin());

        minHeap.add(int10);
        assertSame(int10, minHeap.getMin());

        minHeap.add(int9);
        assertSame(int9, minHeap.getMin());

        minHeap.add(int8);
        assertSame(int8, minHeap.getMin());

        minHeap.add(int7);
        assertSame(int7, minHeap.getMin());

        minHeap.add(int6);
        assertSame(int6, minHeap.getMin());

        minHeap.add(int5);
        assertSame(int5, minHeap.getMin());

        minHeap.add(int4);
        assertSame(int4, minHeap.getMin());

        minHeap.add(int3);
        assertSame(int3, minHeap.getMin());

        minHeap.add(int2);
        assertSame(int2, minHeap.getMin());

        minHeap.add(int1);
        assertSame(int1, minHeap.getMin());

        minHeap.add(int0);
        assertSame(int0, minHeap.getMin());
    }

    @Test(timeout = TIMEOUT)
    public void testIsEmpty() {
        assertTrue(minHeap.isEmpty());
        assertEquals(0, minHeap.size());

        for (int i = 0; i < 13; i++) {
            minHeap.add(i);
        }

        assertFalse(minHeap.isEmpty());
        assertEquals(13, minHeap.size());

        for (int i = 0; i < 13; i++) {
            minHeap.remove();
        }

        assertTrue(minHeap.isEmpty());
        assertEquals(0, minHeap.size());
        assertArrayEquals(new Integer[2 * MinHeap.INITIAL_CAPACITY], minHeap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testClear() {
        for (int i = 0; i < 13; i++) {
            minHeap.add(i);
        }
        assertEquals(13, minHeap.size());
        minHeap.clear();

        assertEquals(0, minHeap.size());
        assertArrayEquals(new Integer[MinHeap.INITIAL_CAPACITY], minHeap.getBackingArray());

    }
}