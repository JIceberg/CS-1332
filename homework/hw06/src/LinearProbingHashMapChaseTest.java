import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.Assert.*;

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
public class LinearProbingHashMapChaseTest {

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
    public void testInitializationWithNoCapacity() {
        map = new LinearProbingHashMap<>(0);
        map.put(1, "A");
        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[1];
        expected[0] = new LinearProbingMapEntry<>(1, "A");
        assertArrayEquals(map.getTable(), expected);

        map.put(2, "B");
        expected = new LinearProbingMapEntry[3];
        expected[1] = new LinearProbingMapEntry<>(1, "A");
        expected[2] = new LinearProbingMapEntry<>(2, "B");
    }

    @Test(timeout = TIMEOUT)
    public void testGeneralHashing() {
        //[(asdfjkl;, Value 5), null, null, null, null, null, null, null, null, (Key1, Value1), (Key2, Value2), (Key3, Value3), (qweruiop, Value 6)]
        LinearProbingHashMap<String, String> hashmap = new LinearProbingHashMap<>();
        hashmap.put("Key1", "Value1");
        hashmap.put("Key2", "Value2");
        hashmap.put("Key3", "Value3");
        hashmap.put("asdfjkl;", "Value4");
        assertEquals("Value4", hashmap.put("asdfjkl;", "Value5"));
        hashmap.put("qweruiop", "Value6");

        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[LinearProbingHashMap.INITIAL_CAPACITY];
        expected[0] = new LinearProbingMapEntry<>("asdfjkl;", "Value5");
        expected[9] = new LinearProbingMapEntry<>("Key1", "Value1");
        expected[10] = new LinearProbingMapEntry<>("Key2", "Value2");
        expected[11] = new LinearProbingMapEntry<>("Key3", "Value3");
        expected[12] = new LinearProbingMapEntry<>("qweruiop", "Value6");
        assertArrayEquals(expected, hashmap.getTable());
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
    public void testHashedPut() {
        // [_, (1, A), (2, B), (3, C), (4, D), (5, E), _, _, _, _, _, _, _]
        assertNull(map.put(14, "A"));
        assertNull(map.put(27, "B"));
        assertNull(map.put(40, "C"));
        assertNull(map.put(53, "D"));
        assertNull(map.put(66, "E"));

        assertEquals(5, map.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY];
        expected[1] = new LinearProbingMapEntry<>(14, "A");
        expected[2] = new LinearProbingMapEntry<>(27, "B");
        expected[3] = new LinearProbingMapEntry<>(40, "C");
        expected[4] = new LinearProbingMapEntry<>(53, "D");
        expected[5] = new LinearProbingMapEntry<>(66, "E");
        assertArrayEquals(expected, map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testNegativePut() {
        // [_, (1, A), (2, B), (3, C), (4, D), (5, E), _, _, _, _, _, _, _]
        assertNull(map.put(-1, "A"));
        assertNull(map.put(-2, "B"));
        assertNull(map.put(-3, "C"));
        assertNull(map.put(-4, "D"));
        assertNull(map.put(-5, "E"));

        assertEquals(5, map.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY];
        expected[1] = new LinearProbingMapEntry<>(-1, "A");
        expected[2] = new LinearProbingMapEntry<>(-2, "B");
        expected[3] = new LinearProbingMapEntry<>(-3, "C");
        expected[4] = new LinearProbingMapEntry<>(-4, "D");
        expected[5] = new LinearProbingMapEntry<>(-5, "E");
        assertArrayEquals(expected, map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testNegativeProbingHashedPut() {
        // [_, (1, A), (2, B), (3, C), (4, D), (5, E), _, _, _, _, _, _, _]
        assertNull(map.put(-14, "A"));
        assertNull(map.put(-27, "B"));
        assertNull(map.put(-40, "C"));
        assertNull(map.put(-53, "D"));
        assertNull(map.put(-66, "E"));

        assertEquals(5, map.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY];
        expected[1] = new LinearProbingMapEntry<>(-14, "A");
        expected[2] = new LinearProbingMapEntry<>(-27, "B");
        expected[3] = new LinearProbingMapEntry<>(-40, "C");
        expected[4] = new LinearProbingMapEntry<>(-53, "D");
        expected[5] = new LinearProbingMapEntry<>(-66, "E");
        assertArrayEquals(expected, map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveKeyPutSameKey() {
        // [_, (1, A), (2, B), (3, C), _, _, _, _, _, _, _, _, _]
        String temp = "B";
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, temp));
        assertNull(map.put(3, "C"));

        // [_, (1, A), _, (3, C), _, _, _, _, _, _, _, _, _]
        assertEquals(temp, map.remove(2));
        assertEquals(2, map.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY];
        expected[1] = new LinearProbingMapEntry<>(1, "A");
        expected[2] = new LinearProbingMapEntry<>(2, temp);
        expected[2].setRemoved(true);
        expected[3] = new LinearProbingMapEntry<>(3, "C");
        assertArrayEquals(expected, map.getTable());

        // [_, (1, A), (2, B), (3, C), _, _, _, _, _, _, _, _, _]
        assertNull(map.put(2, temp));
        expected[2].setRemoved(false);
        assertArrayEquals(expected, map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveKeyPutDifferentKey() {
        // [_, (1, A), (2, B), (3, C), _, _, _, _, _, _, _, _, _]
        String B = "B";
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, B));
        assertNull(map.put(3, "C"));

        // [_, (1, A), _, (3, C), _, _, _, _, _, _, _, _, _]
        assertEquals(B, map.remove(2));
        assertEquals(2, map.size());

        // [_, (1, A), (14, test), (3, C), _, _, _, _, _, _, _, _, _]
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY];
        String test = "test";
        expected[1] = new LinearProbingMapEntry<>(1, "A");
        expected[2] = new LinearProbingMapEntry<>(14, test);
        expected[2].setRemoved(true);
        expected[3] = new LinearProbingMapEntry<>(3, "C");

        assertNull(map.put(14, test));
        expected[2].setRemoved(false);
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
    public void testNoSuchElementException() {
        // [_, (1, A), (2, B), (3, C), (4, D), (5, E), _, _, _, _, _, _, _]
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, "D"));
        assertNull(map.put(5, "E"));

        // [_, (1, A), (2, B), (3, C), _, (5, E), _, _, _, _, _, _, _]
        map.remove(4);
        try {
            map.get(4);
            fail();
        } catch (NoSuchElementException e) {
        }
        try {
            map.remove(4);
            fail();
        } catch (NoSuchElementException e) {
        }
    }

    @Test(timeout = TIMEOUT)
    public void testNoSuchElementExceptionWithRemovedKeys() {
        // [_, _, _, (3, C), (4, D), (5, E), (6, F), _, _, _, _, _, _, _]
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");
        map.put(6, "F");
        // [_, _, _, _, _, (5, E), (6, F), _, _, _, _, _, _, _]
        map.remove(3);
        map.remove(4);
        try {
            map.get(4);
            fail();
        } catch (NoSuchElementException e) {
        }
        try {
            map.remove(4);
            fail();
        } catch (NoSuchElementException e) {
        }
        map.remove(6);
        map.remove(5);
    }

    @Test(timeout = TIMEOUT)
    public void testIllegalArgumentException() {
        // [_, _, _, (3, C), (4, D), (5, E), (6, F), _, _, _, _, _, _, _]
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");
        map.put(6, "F");
        try {
            map.put(null, "test");
            fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            map.put(1, null);
            fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            map.remove(null);
            fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            map.get(null);
            fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            map.containsKey(null);
            fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            map.resizeBackingTable(3);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test(timeout = TIMEOUT)
    public void testResizeIllegalArgumentExceptionWithRemovedKey() {
        // [_, _, _, (3, C), (4, D), (5, E), (6, F), _, _, _, _, _, _, _]
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");
        map.put(6, "F");

        map.remove(3);

        try {
            map.resizeBackingTable(2);
            fail();
        } catch (IllegalArgumentException e) {
        }
        map.resizeBackingTable(3);
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
    public void testResizeWithRemovedKey() {
        // [_, (1, A), (2, B), (3, C), (4, D), (5, E), _, _, _, _, _, _, _]
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, "D"));
        assertNull(map.put(5, "E"));

        assertEquals(map.remove(2), "B");
        assertEquals(map.remove(3), "C");
        assertEquals(map.remove(4), "D");
        assertEquals(map.remove(5), "E");

        // [_, (1, A), _, _, _, _]
        map.resizeBackingTable(6);
        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[6];
        expected[1] = new LinearProbingMapEntry<>(1, "A");
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

    /**
    @Test(timeout = TIMEOUT)
    public void testStopTraversingAtTheRightTime() {
        // [_, (1, A), (14, B), (27, C), (40, D), (53, E), DontCallThisIndex, _, _, _, _, _, _]
        //This is a test to make sure you are stopping your traversals once you hit "size" amount of non-removed
        //  elements. It makes sure your traversal are efficient. If you are getting this test wrong, check to make
        //  sure you are stopping exactly when you need to (especially for put). Don't check if the next index is null
        // if you already have gone through "size" amount of non-removed elements.

        //Also, ignore the type of exception.
        assertNull(map.put(1, "A"));
        assertNull(map.put(14, "B"));
        assertNull(map.put(27, "C"));
        assertNull(map.put(40, "D"));
        assertNull(map.put(53, "E"));

        map.getTable()[6] = new DontCallMe();

        try {
            map.remove(66);
            fail();
        } catch (IllegalArgumentException e) {
            fail();
        } catch (NoSuchElementException ignored) {}

        try {
            assertFalse(map.containsKey(66));
        } catch (IllegalArgumentException e) {
            fail();
        }

        try {
            map.get(66);
            fail();
        } catch (IllegalArgumentException e) {
            fail();
        } catch (NoSuchElementException ignored) {}

        try {
            map.keySet();
        } catch (IllegalArgumentException e) {
            fail();
        }

        try {
            map.keySet();
        } catch (IllegalArgumentException e) {
            fail();
        }

        try {
            map.values();
        } catch (IllegalArgumentException e) {
            fail();
        }

        try {
            map.put(66, "F");
        } catch (IllegalArgumentException e) {
            fail();
        }

        map.remove(66);
        map.getTable()[6] = new DontCallMe();

        try {
            map.resizeBackingTable(8);
        } catch (IllegalArgumentException e) {
            fail();
        }


    }
    */
    private class DontCallMe extends LinearProbingMapEntry<Integer, String> {
        /**
         * Constructs a new LinearProbingMapEntry with the given key and value.
         * The removed flag is default set to false.
         */
        DontCallMe() {
            super(null, null);
        }

        @Override
        Integer getKey() {
            throw new IllegalArgumentException("DontCallMe");
        }

        @Override
        String getValue() {
            throw new IllegalArgumentException("DontCallMe");
        }

        @Override
        boolean isRemoved() {
            throw new IllegalArgumentException("DontCallMe");
        }

        @Override
        public String toString() {
            return "DontCallMe{}";
        }
    }
}
