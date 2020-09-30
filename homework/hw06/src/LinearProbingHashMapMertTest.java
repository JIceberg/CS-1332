import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * This is a basic set of unit tests for LinearProbingHashMap.
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
public class LinearProbingHashMapMertTest {

    private static final int TIMEOUT = 200;
    private LinearProbingHashMap<Integer, String> map;

    @Before
    public void setUp() {
        map = new LinearProbingHashMap<>();

    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, map.size());
        assertArrayEquals(new LinearProbingMapEntry[
                LinearProbingHashMap.INITIAL_CAPACITY], map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testPut() {
        // [_, (1, A), (2, B), (3, C), (4, D), (5, E), _, _, _, _, _, _, _]
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, "D"));
        assertNull(map.put(5, "E"));

        assertEquals(5, map.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY];
        expected[1] = new LinearProbingMapEntry<>(1, "A");
        expected[2] = new LinearProbingMapEntry<>(2, "B");
        expected[3] = new LinearProbingMapEntry<>(3, "C");
        expected[4] = new LinearProbingMapEntry<>(4, "D");
        expected[5] = new LinearProbingMapEntry<>(5, "E");
        assertArrayEquals(expected, map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testRemove() {
        String temp = "D";

        // [_, (1, A), (2, B), (3, C), (4, D), (5, E), _, _, _, _, _, _, _]
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, temp));
        assertNull(map.put(5, "E"));

        // [_, (1, A), (2, B), (3, C), (4, D)X, (5, E), _, _, _, _, _, _, _]
        assertSame(temp, map.remove(4));
        assertEquals(4, map.size());
        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[
                LinearProbingHashMap.INITIAL_CAPACITY];
        expected[1] = new LinearProbingMapEntry<>(1, "A");
        expected[2] = new LinearProbingMapEntry<>(2, "B");
        expected[3] = new LinearProbingMapEntry<>(3, "C");
        expected[4] = new LinearProbingMapEntry<>(4, "D");
        expected[4].setRemoved(true);
        expected[5] = new LinearProbingMapEntry<>(5, "E");
        assertArrayEquals(expected, map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testGet() {
        // [_, (1, A), (2, B), (3, C), (4, D), (5, E), _, _, _, _, _, _, _]
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, "D"));
        assertNull(map.put(5, "E"));

        assertEquals("A", map.get(1));
        assertEquals("B", map.get(2));
        assertEquals("C", map.get(3));
        assertEquals("D", map.get(4));
        assertEquals("E", map.get(5));
    }

    @Test(timeout = TIMEOUT)
    public void testContainsKey() {
        // [_, (1, A), (2, B), (3, C), (4, D), (5, E), _, _, _, _, _, _, _]
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, "D"));
        assertNull(map.put(5, "E"));

        assertTrue(map.containsKey(3));
        assertFalse(map.containsKey(6));
    }

    @Test(timeout = TIMEOUT)
    public void testKeySet() {
        // [_, (1, A), (2, B), (3, C), (4, D), (5, E), _, _, _, _, _, _, _]
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, "D"));
        assertNull(map.put(5, "E"));

        Set<Integer> expected = new HashSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        assertEquals(expected, map.keySet());
    }

    @Test(timeout = TIMEOUT)
    public void testValues() {
        // [_, (1, A), (2, B), (3, C), (4, D), (5, E), _, _, _, _, _, _, _]
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, "D"));
        assertNull(map.put(5, "E"));

        List<String> expected = new LinkedList<>();
        expected.add("A");
        expected.add("B");
        expected.add("C");
        expected.add("D");
        expected.add("E");
        assertEquals(expected, map.values());
    }

    @Test(timeout = TIMEOUT)
    public void testResize() {
        // [_, (1, A), (2, B), (3, C), (4, D), (5, E), _, _, _, _, _, _, _]
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, "D"));
        assertNull(map.put(5, "E"));

        // [_, (1, A), (2, B), (3, C), (4, D), (5, E)]
        map.resizeBackingTable(6);
        assertEquals(5, map.size());
        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[6];
        expected[1] = new LinearProbingMapEntry<>(1, "A");
        expected[2] = new LinearProbingMapEntry<>(2, "B");
        expected[3] = new LinearProbingMapEntry<>(3, "C");
        expected[4] = new LinearProbingMapEntry<>(4, "D");
        expected[5] = new LinearProbingMapEntry<>(5, "E");
        assertArrayEquals(expected, map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testClear() {
        // [_, (1, A), (2, B), (3, C), (4, D), (5, E), _, _, _, _, _, _, _]
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, "D"));
        assertNull(map.put(5, "E"));

        map.clear();
        assertEquals(0, map.size());
        assertArrayEquals(new LinearProbingMapEntry[
                LinearProbingHashMap.INITIAL_CAPACITY], map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testPutKeyAlreadyInMap() {
        String temp = "A";

        assertNull(map.put(1, temp));
        // [_, (1, A), _, _, _, _, _, _, _, _, _, _, _]

        assertSame(temp, map.put(1, "AA"));
        // [_, (1, AA), _, _, _, _, _, _, _, _, _, _, _]

        LinearProbingMapEntry[] expected =  new LinearProbingMapEntry[
                LinearProbingHashMap.INITIAL_CAPACITY];
        expected[1] = new LinearProbingMapEntry<>(1, "AA");
        assertArrayEquals(expected, map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAndPut() {
        String temp1 = "A";
        String temp2 = "B";
        String temp3 = "C";
        String temp4 = "D";
        LinearProbingMapEntry[] expected =  new LinearProbingMapEntry[
                LinearProbingHashMap.INITIAL_CAPACITY];

        assertNull(map.put(1, temp1));
        assertNull(map.put(14, temp2));
        // [_, (1, A), (14, B), _, _, _, _, _, _, _, _, _, _]
        expected[1] = new LinearProbingMapEntry<>(1, "A");
        expected[2] = new LinearProbingMapEntry<>(14, "B");
        assertArrayEquals(expected, map.getTable());
        assertSame(temp1, map.get(1));
        assertSame(temp2, map.get(14));
        assertFalse(map.containsKey(0));

        assertSame(temp1, map.remove(1));
        assertSame(temp2, map.remove(14));
        // [_, (1, A)X, (14, B)X, _, _, _, _, _, _, _, _, _, _]
        expected[1].setRemoved(true);
        expected[2].setRemoved(true);
        assertArrayEquals(expected, map.getTable());
        assertFalse(map.containsKey(1));
        assertFalse(map.containsKey(14));

        assertNull(map.put(27, "C"));
        // [_, (27, C), (14, B)X, _, _, _, _, _, _, _, _, _, _]
        expected[1] = new LinearProbingMapEntry<>(27, "C");
        assertArrayEquals(expected, map.getTable());
        assertTrue(map.containsKey(27));
        assertSame(temp3, map.get(27));

        assertNull(map.put(14, "D"));
        // [_, (27, C), (14, D), _, _, _, _, _, _, _, _, _, _]
        expected[2] = new LinearProbingMapEntry<>(14, "D");
        assertArrayEquals(expected, map.getTable());
        assertTrue(map.containsKey(14));
        assertSame(temp4, map.get(14));
        assertFalse(map.containsKey(12));

        assertSame(temp3, map.remove(27));
        assertSame(temp4, map.remove(14));
        // [_, (27, C)X, (14, D)X, _, _, _, _, _, _, _, _, _, _]
        expected[1].setRemoved(true);
        expected[2].setRemoved(true);
        assertArrayEquals(expected, map.getTable());
        assertFalse(map.containsKey(27));
        assertFalse(map.containsKey(14));
    }

    @Test(timeout = TIMEOUT)
    public void testResizingAfterMaxLoadFactor() {
        String temp = "A";
        LinearProbingMapEntry[] expected =  new LinearProbingMapEntry[
                LinearProbingHashMap.INITIAL_CAPACITY];

        assertNull(map.put(1, temp));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, "D"));
        assertNull(map.put(5, "E"));
        assertNull(map.put(6, "F"));
        assertNull(map.put(7, "G"));
        assertNull(map.put(8, "H"));
        // [_, (1, A), (2, B), (3, C), (4, D), (5, E), (6, F), (7, G), (8, H), _, _, _, _]
        // Load Factor = 8 / 13 = 0.62
        expected[1] = new LinearProbingMapEntry<>(1, "A");
        expected[2] = new LinearProbingMapEntry<>(2, "B");
        expected[3] = new LinearProbingMapEntry<>(3, "C");
        expected[4] = new LinearProbingMapEntry<>(4, "D");
        expected[5] = new LinearProbingMapEntry<>(5, "E");
        expected[6] = new LinearProbingMapEntry<>(6, "F");
        expected[7] = new LinearProbingMapEntry<>(7, "G");
        expected[8] = new LinearProbingMapEntry<>(8, "H");
        assertArrayEquals(expected, map.getTable());

        assertSame(temp, map.remove(1));
        assertNull(map.put(9, "I"));
        assertNull(map.put(10, "J"));
        // Load Factor = 9 / 13 = 0.69
        // [_, _, (2, B), (3, C), (4, D), (5, E), (6, F), (7, G), (8, H), (9, I), (10, J), _, _,
        // _, _, _, _, _, _, _, _, _, _, _, _, _, _]
        expected =  new LinearProbingMapEntry[LinearProbingHashMap.INITIAL_CAPACITY * 2 + 1];
        expected[2] = new LinearProbingMapEntry<>(2, "B");
        expected[3] = new LinearProbingMapEntry<>(3, "C");
        expected[4] = new LinearProbingMapEntry<>(4, "D");
        expected[5] = new LinearProbingMapEntry<>(5, "E");
        expected[6] = new LinearProbingMapEntry<>(6, "F");
        expected[7] = new LinearProbingMapEntry<>(7, "G");
        expected[8] = new LinearProbingMapEntry<>(8, "H");
        expected[9] = new LinearProbingMapEntry<>(9, "I");
        expected[10] = new LinearProbingMapEntry<>(10, "J");
        assertArrayEquals(expected, map.getTable());
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testPutNullValue() {
        map.put(1, null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testPutNullKey() {
        map.put(null, "A");
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testRemoveNullKey() {
        map.remove(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveKeyNotInMap() {
        map.put(1, "A");
        map.put(14, "B");
        // [_, (1, A), (14, B), _, _, _, _, _, _, _, _, _, _]
        LinearProbingMapEntry[] expected =  new LinearProbingMapEntry[
                LinearProbingHashMap.INITIAL_CAPACITY];
        expected[1] = new LinearProbingMapEntry<>(1, "A");
        expected[2] = new LinearProbingMapEntry<>(14, "B");
        assertArrayEquals(expected, map.getTable());
        map.remove(2);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testGetNullKey() {
        map.remove(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testGetKeyNotInMap() {
        map.put(1, "A");
        map.put(14, "B");
        // [_, (1, A), (14, B), _, _, _, _, _, _, _, _, _, _]
        LinearProbingMapEntry[] expected =  new LinearProbingMapEntry[
                LinearProbingHashMap.INITIAL_CAPACITY];
        expected[1] = new LinearProbingMapEntry<>(1, "A");
        expected[2] = new LinearProbingMapEntry<>(14, "B");
        assertArrayEquals(expected, map.getTable());
        map.get(2);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testContainsNullKey() {
        map.containsKey(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testResizeToSmallerThanSize() {
        // [_, (1, A), (2, B), (3, C), (4, D), (5, E), _, _, _, _, _, _, _]
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, "D"));
        assertNull(map.put(5, "E"));
        map.resizeBackingTable(4);
    }
}