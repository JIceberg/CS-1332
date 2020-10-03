import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Assumes you have passed the tests the TA's provided
 *
 * @author Pratheek Lakkireddy
 * @version 1.0
 */
public class LinearProbingHashMapPratheekTest {

    private static final int TIMEOUT = 200;
    private LinearProbingHashMap<Integer, String> map;
    private LinearProbingHashMap<String, Integer> map1;

    @Before
    public void setUp() {
        map = new LinearProbingHashMap<>();
        map1 = new LinearProbingHashMap<>();
    }

    @Test (timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testPutKeyIllegal() {
        map.put(null, "A");
    }

    @Test (timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testPutValueIllegal() {
        map.put(1, null);
    }

    @Test (timeout = TIMEOUT)
    public void testPutReplace() {
        // [_, (1, B), (3, C), (4, D), (5, E), _, _, _, _, _, _, _]
        assertNull(map.put(1, "A"));
        assertEquals(map.put(1, "B"), "A");
        assertNull(map.put(2, "C"));
        assertNull(map.put(3, "D"));
        assertNull(map.put(4, "E"));

        assertEquals(4, map.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY];
        expected[1] = new LinearProbingMapEntry<>(1, "B");
        expected[2] = new LinearProbingMapEntry<>(2, "C");
        expected[3] = new LinearProbingMapEntry<>(3, "D");
        expected[4] = new LinearProbingMapEntry<>(4, "E");
        assertArrayEquals(expected, map.getTable());
    }

    @Test (timeout = TIMEOUT)
    public void testPutDel() {
        String temp = "C";

        // [_, (1, A), (2, B), (3, D), (4, E), _, _, _, _, _, _, _]
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, temp));
        map.remove(3);
        assertNull(map.put(3, "D"));
        assertNull(map.put(4, "E"));

        assertEquals(4, map.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY];
        expected[1] = new LinearProbingMapEntry<>(1, "A");
        expected[2] = new LinearProbingMapEntry<>(2, "B");
        expected[3] = new LinearProbingMapEntry<>(3, "D");
        expected[4] = new LinearProbingMapEntry<>(4, "E");
        assertArrayEquals(expected, map.getTable());
    }

    @Test (timeout = TIMEOUT)
    public void testSimpleProbe() {
        // [_, _, _, (01, 1), (02, 2), (03, 3), (04, 4), (Aa, 5), (06, 6),(A04, 7)_, _, _]

        assertNull(map1.put("01", 1));
        assertNull(map1.put("02", 2));
        assertNull(map1.put("03", 3));
        assertNull(map1.put("04", 4));
        assertNull(map1.put("Aa", 5));  // Aa hashed is 2112 - goes to index 6
        assertNull(map1.put("06", 6));
        assertNull(map1.put("A04", 7)); // A04 hashed is 64005 - goes to index 6

        assertEquals(7, map1.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY];
        expected[3] = new LinearProbingMapEntry<>("01", 1);
        expected[4] = new LinearProbingMapEntry<>("02", 2);
        expected[5] = new LinearProbingMapEntry<>("03", 3);
        expected[6] = new LinearProbingMapEntry<>("04", 4);
        expected[7] = new LinearProbingMapEntry<>("Aa", 5);
        expected[8] = new LinearProbingMapEntry<>("06", 6);
        expected[9] = new LinearProbingMapEntry<>("A04", 7);
        assertArrayEquals(expected, map1.getTable());
    }

    @Test (timeout = TIMEOUT)
    public void testDeletedProbe() {
        // [_, _, _, (01, 1), (02, 2), (03, 3), (04, 4), (05, 5), (A04, 7)_, _, _]

        assertNull(map1.put("01", 1));
        assertNull(map1.put("02", 2));
        assertNull(map1.put("03", 3));
        assertNull(map1.put("04", 4));
        assertNull(map1.put("05", 5));
        assertNull(map1.put("06", 6));
        map1.remove("06");
        assertNull(map1.put("A04", 7)); // A04 hashed is 64005 - goes to index 6

        assertEquals(6, map1.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY];
        expected[3] = new LinearProbingMapEntry<>("01", 1);
        expected[4] = new LinearProbingMapEntry<>("02", 2);
        expected[5] = new LinearProbingMapEntry<>("03", 3);
        expected[6] = new LinearProbingMapEntry<>("04", 4);
        expected[7] = new LinearProbingMapEntry<>("05", 5);
        expected[8] = new LinearProbingMapEntry<>("A04", 7);
        assertArrayEquals(expected, map1.getTable());
    }

    @Test (timeout = TIMEOUT)
    public void testNullBeforeDeletedProbe() {
        int temp = 6;
        // [_, _, _, (01, 1), (02, 2), (03, 3), (A03, 4), (05, 5), X(06, 6), (07, 7) _, _]

        assertNull(map1.put("01", 1));
        assertNull(map1.put("02", 2));
        assertNull(map1.put("03", 3));
        assertNull(map1.put("05", 5));
        assertNull(map1.put("06", 6));
        assertEquals(java.util.Optional.of(temp), java.util.Optional.of(map1.remove("06")));
        assertNull(map1.put("07", 7));
        assertNull(map1.put("A03", 4)); // A03 hashed is 64004 - goes to index 5

        assertEquals(6, map1.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY];
        expected[3] = new LinearProbingMapEntry<>("01", 1);
        expected[4] = new LinearProbingMapEntry<>("02", 2);
        expected[5] = new LinearProbingMapEntry<>("03", 3);
        expected[6] = new LinearProbingMapEntry<>("A03", 4);
        expected[7] = new LinearProbingMapEntry<>("05", 5);
        LinearProbingMapEntry entry = new LinearProbingMapEntry<>("06", 6);
        entry.setRemoved(true);
        expected[8] = entry;
        expected[9] = new LinearProbingMapEntry<>("07", 7);
        assertArrayEquals(expected, map1.getTable());
    }

    @Test (timeout = TIMEOUT)
    public void testNullAfterDeletedProbe() {
        int temp = 4;
        // [_, _, _, (01, 1), (02, 2), (03, 3), (A03, 4), _, _, _, _, _. _]

        assertNull(map1.put("01", 1));
        assertNull(map1.put("02", 2));
        assertNull(map1.put("03", 3));
        assertNull(map1.put("04", 4));
        assertEquals(java.util.Optional.of(temp), java.util.Optional.of(map1.remove("04")));
        assertNull(map1.put("A03", 4)); // A03 hashed is 64004 - goes to index 5

        assertEquals(4, map1.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY];
        expected[3] = new LinearProbingMapEntry<>("01", 1);
        expected[4] = new LinearProbingMapEntry<>("02", 2);
        expected[5] = new LinearProbingMapEntry<>("03", 3);
        expected[6] = new LinearProbingMapEntry<>("A03", 4);
        assertArrayEquals(expected, map1.getTable());
    }

    @Test (timeout = TIMEOUT)
    public void testProbeAddFirstDeletedNotFound() {
        int temp4 = 4, temp5 = 5, temp6 = 6;
        // [_, _, _, (01, 1), (02, 2), (03, 3), (A03, 4), X(05, 5), X(06, 6), (07, 7) _, _]

        assertNull(map1.put("01", 1));
        assertNull(map1.put("02", 2));
        assertNull(map1.put("03", 3));
        assertNull(map1.put("04", 4));
        assertEquals(java.util.Optional.of(temp4), java.util.Optional.of(map1.remove("04")));
        assertNull(map1.put("05", 5));
        assertEquals(java.util.Optional.of(temp5), java.util.Optional.of(map1.remove("05")));
        assertNull(map1.put("06", 6));
        assertEquals(java.util.Optional.of(temp6), java.util.Optional.of(map1.remove("06")));
        assertNull(map1.put("07", 7));
        assertNull(map1.put("A03", 4)); // A03 hashed is 64004 - goes to index 5

        assertEquals(5, map1.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY];
        expected[3] = new LinearProbingMapEntry<>("01", 1);
        expected[4] = new LinearProbingMapEntry<>("02", 2);
        expected[5] = new LinearProbingMapEntry<>("03", 3);
        expected[6] = new LinearProbingMapEntry<>("A03", 4);
        LinearProbingMapEntry entry5 = new LinearProbingMapEntry<>("05", 5);
        entry5.setRemoved(true);
        expected[7] = entry5;
        LinearProbingMapEntry entry6 = new LinearProbingMapEntry<>("06", 6);
        entry6.setRemoved(true);
        expected[8] = entry6;
        expected[9] = new LinearProbingMapEntry<>("07", 7);
        assertArrayEquals(expected, map1.getTable());
    }

    @Test (timeout = TIMEOUT)
    public void testProbeAddFirstDeletedFound() {
        int temp4 = 4, temp5 = 5, temp6 = 6;
        // [_, _, _, (01, 1), (02, 2), (03, 3), (A03, 4), X(05, 5), X(A03, 6), (07, 7) _, _]

        assertNull(map1.put("01", 1));
        assertNull(map1.put("02", 2));
        assertNull(map1.put("03", 3));
        assertNull(map1.put("04", 4));
        assertNull(map1.put("05", 5));
        assertNull(map1.put("A03", 6)); // A03 hashed is 64004 - goes to index 5
        assertNull(map1.put("07", 7));
        assertEquals(java.util.Optional.of(temp4), java.util.Optional.of(map1.remove("04")));
        assertEquals(java.util.Optional.of(temp5), java.util.Optional.of(map1.remove("05")));
        assertEquals(java.util.Optional.of(temp6), java.util.Optional.of(map1.remove("A03")));
        assertNull(map1.put("A03", 4)); // A03 hashed is 64004

        assertEquals(5, map1.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY];
        expected[3] = new LinearProbingMapEntry<>("01", 1);
        expected[4] = new LinearProbingMapEntry<>("02", 2);
        expected[5] = new LinearProbingMapEntry<>("03", 3);
        expected[6] = new LinearProbingMapEntry<>("A03", 4);
        LinearProbingMapEntry entry5 = new LinearProbingMapEntry<>("05", 5);
        entry5.setRemoved(true);
        expected[7] = entry5;
        LinearProbingMapEntry entry6 = new LinearProbingMapEntry<>("A03", 6);
        entry6.setRemoved(true);
        expected[8] = entry6;
        expected[9] = new LinearProbingMapEntry<>("07", 7);
        assertArrayEquals(expected, map1.getTable());
    }

    @Test (timeout = TIMEOUT)
    public void testProbeReplacePastDeleted() {
        int temp4 = 4, temp5 = 5, temp6 = 6;
        // [_, _, _, (01, 1), (02, 2), (03, 3), X(04, 4), X(05, 5), X(06, 6), (Aa, 4), _, _]

        assertNull(map1.put("01", 1));
        assertNull(map1.put("02", 2));
        assertNull(map1.put("03", 3));
        assertNull(map1.put("04", 4));
        assertNull(map1.put("05", 5));
        assertNull(map1.put("06", 6));
        assertNull(map1.put("Aa", 7));
        assertEquals(java.util.Optional.of(temp4), java.util.Optional.of(map1.remove("04")));
        assertEquals(java.util.Optional.of(temp5), java.util.Optional.of(map1.remove("05")));
        assertEquals(java.util.Optional.of(temp6), java.util.Optional.of(map1.remove("06")));
        assertEquals(java.util.Optional.of(7), java.util.Optional.of(map1.put("Aa", 4)));

        assertEquals(4, map1.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY];
        expected[3] = new LinearProbingMapEntry<>("01", 1);
        expected[4] = new LinearProbingMapEntry<>("02", 2);
        expected[5] = new LinearProbingMapEntry<>("03", 3);
        LinearProbingMapEntry entry4 = new LinearProbingMapEntry<>("04", 4);
        entry4.setRemoved(true);
        expected[6] = entry4;
        LinearProbingMapEntry entry5 = new LinearProbingMapEntry<>("05", 5);
        entry5.setRemoved(true);
        expected[7] = entry5;
        LinearProbingMapEntry entry6 = new LinearProbingMapEntry<>("06", 6);
        entry6.setRemoved(true);
        expected[8] = entry6;
        expected[9] = new LinearProbingMapEntry<>("Aa", 4);
        assertArrayEquals(expected, map1.getTable());
    }

    @Test (timeout = TIMEOUT)
    public void testRemoveLast() {
        assertNull(map.put(1, "A"));
        assertEquals("A", map.remove(1));

        assertEquals(0, map.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[LinearProbingHashMap.INITIAL_CAPACITY];
        LinearProbingMapEntry entry = new LinearProbingMapEntry<>(1, "A");
        entry.setRemoved(true);
        expected[1] = entry;
        assertArrayEquals(expected, map.getTable());
    }

    @Test (timeout = TIMEOUT)
    public void testRemoveFirstandLast() {
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, "D"));
        assertNull(map.put(5, "E"));

        assertEquals(5, map.size());
        assertEquals(map.remove(5), "E");
        assertEquals(4, map.size());
        assertEquals(map.remove(1), "A");
        assertEquals(3, map.size());
    }

    @Test (timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveRemoved() {
        assertNull(map.put(1, "A"));
        assertEquals("A", map.remove(1));
        map.remove(1);
    }

    @Test (timeout = TIMEOUT)
    public void testGetEverything() {
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, "D"));
        assertNull(map.put(5, "E"));

        assertEquals(5, map.size());
        assertEquals(map.get(1), "A");
        assertEquals(map.get(2), "B");
        assertEquals(map.get(3), "C");
        assertEquals(map.get(4), "D");
        assertEquals(map.get(5), "E");
    }

    @Test (timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testGetNotFound() {
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, "D"));
        assertNull(map.put(5, "E"));

        assertEquals(5, map.size());
        map.get(6);
    }

    @Test (timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testGetRemoved() {
        assertNull(map.put(1, "A"));
        assertEquals("A", map.remove(1));
        map.get(1);
    }

    @Test (timeout = TIMEOUT)
    public void testContains() {
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, "D"));
        assertNull(map.put(5, "E"));

        assertEquals(5, map.size());
        assertTrue(map.containsKey(1));
        assertTrue(map.containsKey(3));
        assertTrue(map.containsKey(4));
    }

    @Test (timeout = TIMEOUT)
    public void testContainsNotFound() {
        assertNull(map.put(1, "A"));
        assertNull(map.put(2, "B"));
        assertNull(map.put(3, "C"));
        assertNull(map.put(4, "D"));
        assertNull(map.put(5, "E"));

        assertEquals(5, map.size());
        assertFalse(map.containsKey(6));
    }

    @Test (timeout = TIMEOUT)
    public void testContainsRemoved() {
        assertNull(map.put(1, "A"));
        assertEquals("A", map.remove(1));
        assertFalse(map.containsKey(6));
    }

    @Test (timeout = TIMEOUT)
    public void testResizeThenRemove() {
        // [_, _, _, (01, 1), (02, 2), (03, 3), (04, 4), (05, 5), (06, 6), (Aa, 7), (08, 8), (09, 9)]

        assertNull(map1.put("01", 1));
        assertNull(map1.put("02", 2));
        assertNull(map1.put("03", 3));
        assertNull(map1.put("04", 4));
        assertNull(map1.put("05", 5));
        assertNull(map1.put("06", 6));
        assertNull(map1.put("Aa", 7)); // Aa hashed is 2112 - goes to index 6
        assertNull(map1.put("08", 8));
        assertNull(map1.put("09", 9));
        map1.remove("03");
        map1.remove("09");

        assertEquals(7, map1.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY * 2 + 1];
        expected[25] = new LinearProbingMapEntry<>("01", 1);
        expected[26] = new LinearProbingMapEntry<>("02", 2);
        LinearProbingMapEntry entry3 = new LinearProbingMapEntry<>("03", 3);
        entry3.setRemoved(true);
        expected[0] = entry3;
        expected[1] = new LinearProbingMapEntry<>("04", 4);
        expected[2] = new LinearProbingMapEntry<>("05", 5);
        expected[3] = new LinearProbingMapEntry<>("06", 6);
        expected[6] = new LinearProbingMapEntry<>("Aa", 7);
        expected[5] = new LinearProbingMapEntry<>("08", 8);
        LinearProbingMapEntry entry9 = new LinearProbingMapEntry<>("09", 9);
        entry9.setRemoved(true);
        expected[7] = entry9;
        assertArrayEquals(expected, map1.getTable());
    }

    @Test (timeout = TIMEOUT)
    public void testResizewithDels() {
        // [_, _, _, (01, 1), (02, 2), X(03, 3), (04, 4), (05, 5), (06, 6), (Aa, 7), (08, 8), X(09, 9)]

        assertNull(map1.put("01", 1));
        assertNull(map1.put("02", 2));
        assertNull(map1.put("03", 3));
        map1.remove("03");
        assertNull(map1.put("04", 4));
        assertNull(map1.put("05", 5));
        assertNull(map1.put("06", 6));
        assertNull(map1.put("Aa", 7)); // Aa hashed is 2112 - goes to index 6
        assertNull(map1.put("08", 8));
        assertNull(map1.put("09", 9));
        map1.remove("09");

        map1.resizeBackingTable(LinearProbingHashMap.INITIAL_CAPACITY * 2 + 1);

        assertEquals(7, map1.size());
        LinearProbingMapEntry[] expected =
                new LinearProbingMapEntry[
                        LinearProbingHashMap.INITIAL_CAPACITY * 2 + 1];
        expected[25] = new LinearProbingMapEntry<>("01", 1);
        expected[26] = new LinearProbingMapEntry<>("02", 2);
        expected[1] = new LinearProbingMapEntry<>("04", 4);
        expected[2] = new LinearProbingMapEntry<>("05", 5);
        expected[3] = new LinearProbingMapEntry<>("06", 6);
        expected[6] = new LinearProbingMapEntry<>("Aa", 7);
        expected[5] = new LinearProbingMapEntry<>("08", 8);
        assertArrayEquals(expected, map1.getTable());
    }
}