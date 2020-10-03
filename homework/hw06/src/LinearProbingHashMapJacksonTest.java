import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * A basic set of tests that checks for edge cases
 * in the remove and put relating to DEL markers and linear probing.
 *
 * @author Jackson Isenberg
 * @version 1.0
 */
public class LinearProbingHashMapJacksonTest {

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
        assertNull(map.put(-1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, "D"));
        assertNull(map.put(5, "E"));

        assertEquals(5, map.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY];
        expected[1] = new LinearProbingMapEntry<>(-1, "A");
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
    public void testRemoveAndPutSameKey() {
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

        // [_, (1, A), (2, B), (3, C), (4, F), (5, E), _, _, _, _, _, _, _]
        temp = "F";
        assertNull(map.put(4, temp));
        assertEquals(5, map.size());
        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[
                LinearProbingHashMap.INITIAL_CAPACITY];
        expected[1] = new LinearProbingMapEntry<>(1, "A");
        expected[2] = new LinearProbingMapEntry<>(2, "B");
        expected[3] = new LinearProbingMapEntry<>(3, "C");
        expected[4] = new LinearProbingMapEntry<>(4, "F");
        expected[5] = new LinearProbingMapEntry<>(5, "E");
        assertArrayEquals(expected, map.getTable());

        // [_, (1, A), (2, B), (3, C), (4, F)X, (5, E), _, _, _, _, _, _, _]
        assertSame(temp, map.remove(4));
        assertEquals(4, map.size());

        // [_, (1, A), (2, B), (3, G), (4, F)X, (5, E), _, _, _, _, _, _, _]
        assertSame("C", map.put(3, "G"));
        expected[3] = new LinearProbingMapEntry<>(3, "G");
        expected[4].setRemoved(true);
        assertArrayEquals(expected, map.getTable());
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveFromEmptyList() {
        map = new LinearProbingHashMap<>(0);
        map.remove(3);
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAndPutDifferentKey() {
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

        // [_, (1, A), (2, B), (3, C), (4, D)X, (5, E), (6, F), _, _, _, _, _, _]
        temp = "F";
        assertNull(map.put(6, temp));
        assertEquals(5, map.size());

        // [_, (1, A), (2, B), (3, C), (16, G), (5, E), (6, F), _, _, _, _, _, _]
        assertNull(map.put(16, "G"));
        assertEquals(6, map.size());

        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[
                LinearProbingHashMap.INITIAL_CAPACITY];
        expected[1] = new LinearProbingMapEntry<>(1, "A");
        expected[2] = new LinearProbingMapEntry<>(2, "B");
        expected[3] = new LinearProbingMapEntry<>(3, "C");
        expected[4] = new LinearProbingMapEntry<>(16, "G");
        expected[5] = new LinearProbingMapEntry<>(5, "E");
        expected[6] = new LinearProbingMapEntry<>(6, "F");
        assertArrayEquals(expected, map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAndPutSameKeyHash() {
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

        // [_, (1, A), (2, B), (3, C), (4, F), (5, E), _, _, _, _, _, _, _]
        temp = "F";
        assertNull(map.put(4, temp));
        assertEquals(5, map.size());
        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[
                LinearProbingHashMap.INITIAL_CAPACITY];
        expected[1] = new LinearProbingMapEntry<>(1, "A");
        expected[2] = new LinearProbingMapEntry<>(2, "B");
        expected[3] = new LinearProbingMapEntry<>(3, "C");
        expected[4] = new LinearProbingMapEntry<>(4, "F");
        expected[5] = new LinearProbingMapEntry<>(5, "E");
        assertArrayEquals(expected, map.getTable());

        // [_, (1, A), (2, B), (3, C), (4, F)X, (5, E), _, _, _, _, _, _, _]
        assertSame(temp, map.remove(4));
        assertEquals(4, map.size());

        // [_, (1, A), (2, B), (3, C)X, (4, F)X, (5, E), _, _, _, _, _, _, _]
        assertSame("C", map.remove(3));
        expected[3].setRemoved(true);
        expected[4].setRemoved(true);
        assertEquals(3, map.size());
        assertArrayEquals(expected, map.getTable());

        // [_, (1, A), (2, B), (16, G), (4, F)X, (5, E), _, _, _, _, _, _, _]
        assertNull(map.put(16, "G"));
        expected[3] = new LinearProbingMapEntry<>(16, "G");
        assertEquals(4, map.size());
        assertArrayEquals(expected, map.getTable());
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveDELEntry() {
        String temp = "B";

        assertNull(map.put(1, "A"));
        assertSame("A", map.put(1, temp));
        assertNull(map.put(14, "C"));
        assertSame(temp, map.remove(1));
        assertEquals(1, map.size());

        // [_, (1, B)X, (14, C), _, _, _, _, _, _, _, _, _, _]
        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[
                LinearProbingHashMap.INITIAL_CAPACITY];
        expected[1] = new LinearProbingMapEntry<>(1, "B");
        expected[2] = new LinearProbingMapEntry<>(14, "C");
        expected[1].setRemoved(true);
        assertArrayEquals(expected, map.getTable());

        map.remove(1);
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

        // [_, (1, A)X, (2, B), (3, C), (4, D), (5, E), _, _, _, _, _, _, _]
        assertSame("A", map.remove(1));

        assertFalse(map.containsKey(1));
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
}
