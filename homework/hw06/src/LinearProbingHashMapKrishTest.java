
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class LinearProbingHashMapKrishTest {

    private static final int TIMEOUT = 200;
    private LinearProbingHashMap<Integer, String> map;

    @Before
    public void setUp() {
        this.map = new LinearProbingHashMap<>();
    }


    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        LinearProbingMapEntry<Integer, String>[] emptyTable =
                new LinearProbingMapEntry[LinearProbingHashMap.INITIAL_CAPACITY];
        assertEquals(0, this.map.size());
        assertArrayEquals(emptyTable, this.map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testIntConstructor() {
        this.map = new LinearProbingHashMap<>(20);
        LinearProbingMapEntry<Integer, String>[] emptyTable =
                new LinearProbingMapEntry[20];
        assertEquals(0, this.map.size());
        assertArrayEquals(emptyTable, this.map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testPutNull() {
        try {
            this.map.put(null, "hello");
            fail();
        } catch (IllegalArgumentException e) { }

        try {
            this.map.put(2, null);
            fail();
        } catch (IllegalArgumentException e) { }

        try {
            this.map.put(null, null);
            fail();
        } catch (IllegalArgumentException e) { }

    }

    @Test(timeout = TIMEOUT)
    public void testPutSimple() {
        this.map.put(0, "hello");
        this.map.put(5, "there");
        this.map.put(16, "my friend");
        this.map.put(20, "how are you");
        this.map.put(-6, "today");

        LinearProbingMapEntry<Integer, String>[] table =
                new LinearProbingMapEntry[LinearProbingHashMap.INITIAL_CAPACITY];

        table[0] = new LinearProbingMapEntry<>(0, "hello");
        table[5] = new LinearProbingMapEntry<>(5, "there");
        table[3] = new LinearProbingMapEntry<>(16, "my friend");
        table[6] = new LinearProbingMapEntry<>(-6, "today");
        table[7] = new LinearProbingMapEntry<>(20, "how are you");

        assertEquals(5, this.map.size());
        assertArrayEquals(table, this.map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testPutResize() {
        for (int i = 0; i < 9; i++) {
            this.map.put(i, i + "a");
        }
        LinearProbingMapEntry<Integer, String>[] table =
                new LinearProbingMapEntry[LinearProbingHashMap.INITIAL_CAPACITY * 2 + 1];
        for (int i = 0; i < 9; i++) {
            table[i] = new LinearProbingMapEntry<>(i, i + "a");
        }
        assertArrayEquals(table, this.map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testPutCollisions() {
        this.map.put(1, "a");
        this.map.put(14, "b");
        this.map.put(3, "c");
        this.map.put(-3, "d");
        this.map.put(0, "e");
        this.map.put(4, "f");
        this.map.put(13, "g");
        this.map.put(25, "h");
        // no resize

        LinearProbingMapEntry<Integer, String>[] table =
                new LinearProbingMapEntry[LinearProbingHashMap.INITIAL_CAPACITY];
        table[0] = new LinearProbingMapEntry<>(0, "e");
        table[1] = new LinearProbingMapEntry<>(1, "a");
        table[2] = new LinearProbingMapEntry<>(14, "b");
        table[3] = new LinearProbingMapEntry<>(3, "c");
        table[4] = new LinearProbingMapEntry<>(-3, "d");
        table[5] = new LinearProbingMapEntry<>(4, "f");
        table[6] = new LinearProbingMapEntry<>(13, "g");
        table[12] = new LinearProbingMapEntry<>(25, "h");

        assertEquals(8, this.map.size());
        assertArrayEquals(table, this.map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testPutCollisionsResize() {
        this.map.put(1, "a");
        this.map.put(28, "b");
        this.map.put(2, "c");
        this.map.put(14, "d");
        this.map.put(41, "e");
        this.map.put(29, "f");
        this.map.put(3, "g");
        this.map.put(30, "h");
        this.map.put(57, "i");

        LinearProbingMapEntry<Integer, String>[] table =
                new LinearProbingMapEntry[LinearProbingHashMap.INITIAL_CAPACITY * 2 + 1];
        table[1] = new LinearProbingMapEntry<>(1, "a");
        table[2] = new LinearProbingMapEntry<>(28, "b");
        table[3] = new LinearProbingMapEntry<>(2, "c");
        table[4] = new LinearProbingMapEntry<>(29, "f");
        table[5] = new LinearProbingMapEntry<>(3, "g");
        table[6] = new LinearProbingMapEntry<>(30, "h");
        table[7] = new LinearProbingMapEntry<>(57, "i");
        table[14] = new LinearProbingMapEntry<>(14, "d");
        table[15] = new LinearProbingMapEntry<>(41, "e");

        assertEquals(9, this.map.size());
        assertArrayEquals(table, this.map.getTable());
    }

    private void mapWithDeletedEntries() {
        this.map.put(14, "a");
        this.map.put(2, "b");
        this.map.put(-3, "c");
        this.map.put(-17, "d");
        this.map.put(-6, "e");
        this.map.put(16, "a");
        this.map.put(3, "c");
        this.map.put(32, "d");
        this.map.put(45, "d");

        this.map.remove(2);
        this.map.remove(-17);
        this.map.remove(3);

    }

    @Test(timeout = TIMEOUT)
    public void testPutProbe() {
        this.mapWithDeletedEntries();
        this.map.put(19, "f");
        this.map.put(-17, "g");

        LinearProbingMapEntry<Integer, String>[] table =
                new LinearProbingMapEntry[LinearProbingHashMap.INITIAL_CAPACITY * 2 + 1];


        LinearProbingMapEntry<Integer, String> key2 =
                new LinearProbingMapEntry<>(2, "b");
        key2.setRemoved(true);
        table[2] = key2;

        table[3] = new LinearProbingMapEntry<>(-3, "c");
        LinearProbingMapEntry<Integer, String> key3 =
                new LinearProbingMapEntry<>(3, "c");
        key3.setRemoved(true);
        table[4] = key3;
        table[5] = new LinearProbingMapEntry<>(32, "d");
        table[6] = new LinearProbingMapEntry<>(-6, "e");

        table[14] = new LinearProbingMapEntry<>(14, "a");
        table[16] = new LinearProbingMapEntry<>(16, "a");
        table[17] = new LinearProbingMapEntry<>(-17, "g");
        table[18] = new LinearProbingMapEntry<>(45, "d");
        table[19] = new LinearProbingMapEntry<>(19, "f");

        assertArrayEquals(table, this.map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testPutDuplicate() {
        this.map.put(1, "a");
        this.map.put(28, "b");
        this.map.put(2, "c");
        this.map.put(14, "d");
        this.map.put(41, "e");
        this.map.remove(2);
        this.map.remove(1);

        assertEquals("b", this.map.put(28, "hi"));
        assertEquals("d", this.map.put(14, "there"));
        assertEquals("e", this.map.put(41, "friend"));

    }


    @Test(timeout = TIMEOUT)
    public void testRemove() {
        this.map.resizeBackingTable(7);
        this.map.put(16, "a");
        this.map.put(1, "b");
        this.map.put(15, "c");
        this.map.put(-5, "d");
        this.map.put(-20, "e");
        this.map.put(35, "f");

        this.map.remove(1);
        this.map.remove(-5);
        this.map.remove(35);

        LinearProbingMapEntry<Integer, String>[] table =
                new LinearProbingMapEntry[15];
        table[0] = new LinearProbingMapEntry<>(15, "c");
        LinearProbingMapEntry<Integer, String> key1 =
                new LinearProbingMapEntry<>(1, "b");
        key1.setRemoved(true);
        table[1] = key1;

        table[2] = new LinearProbingMapEntry<>(16, "a");

        LinearProbingMapEntry<Integer, String> keyMinus5 =
                new LinearProbingMapEntry<>(-5, "d");
        keyMinus5.setRemoved(true);
        table[5] = keyMinus5;
        table[6] = new LinearProbingMapEntry<>(-20, "e");
        LinearProbingMapEntry<Integer, String> key35 =
                new LinearProbingMapEntry<>(35, "f");
        key35.setRemoved(true);
        table[7] = key35;

        assertArrayEquals(table, this.map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveNotExists() {
        this.map.put(1, "a");
        this.map.put(2, "b");
        try {
            this.map.remove(4);
            fail();
        } catch (NoSuchElementException e) { }

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveTwice() {
        this.map.put(1, "a");
        this.map.put(2, "b");
        this.map.put(3, "c");
        this.map.remove(3);
        try {
            this.map.remove(3);
            fail();
        } catch (NoSuchElementException e) { }
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveNull() {
        try {
            this.map.remove(null);
        } catch (IllegalArgumentException e) { }
    }


    @Test(timeout = TIMEOUT)
    public void testGetNotExists() {
        this.mapWithDeletedEntries();

        try {
            this.map.get(1);
            fail();
        } catch (NoSuchElementException e) { }
    }


    @Test(timeout = TIMEOUT)
    public void testGetNull() {
        this.mapWithDeletedEntries();

        try {
            this.map.get(null);
        } catch (IllegalArgumentException e) { }
    }

    @Test(timeout = TIMEOUT)
    public void testGet() {
        this.mapWithDeletedEntries();
        assertEquals("a", this.map.get(14));
        assertEquals("c", this.map.get(-3));
        assertEquals("e", this.map.get(-6));
        assertEquals("a", this.map.get(16));
        assertEquals("d", this.map.get(32));
        assertEquals("d", this.map.get(45));
    }

    @Test(timeout = TIMEOUT)
    public void testGetDeleted() {
        this.mapWithDeletedEntries();
        try {
            this.map.get(2);
            fail();
        } catch (NoSuchElementException e) { }
        try {
            this.map.get(-17);
            fail();
        } catch (NoSuchElementException e) { }
        try {
            this.map.get(3);
            fail();
        } catch (NoSuchElementException e) { }
    }

    @Test(timeout = TIMEOUT)
    public void testContainsKey() {
        this.mapWithDeletedEntries();
        assertTrue(this.map.containsKey(14));
        assertTrue(this.map.containsKey(-3));
        assertTrue(this.map.containsKey(-6));
        assertTrue(this.map.containsKey(16));
        assertTrue(this.map.containsKey(32));
        assertTrue(this.map.containsKey(45));

        assertFalse(this.map.containsKey(2));
        assertFalse(this.map.containsKey(-17));
        assertFalse(this.map.containsKey(3));
    }

    @Test(timeout = TIMEOUT)
    public void testContainsKeyNull() {
        this.mapWithDeletedEntries();
        try {
            this.map.containsKey(null);
            fail();
        } catch (IllegalArgumentException e) { }
    }

    @Test(timeout = TIMEOUT)
    public void testKeySet() {
        this.mapWithDeletedEntries();
        Set<Integer> keys = new HashSet<>();
        keys.add(14);
        keys.add(-3);
        keys.add(-6);
        keys.add(16);
        keys.add(32);
        keys.add(45);
        assertEquals(keys, this.map.keySet());
    }

    @Test(timeout = TIMEOUT)
    public void testEmptyKeySet() {
        Set<Integer> keys = new HashSet<>();
        assertEquals(keys, this.map.keySet());
    }

    @Test(timeout = TIMEOUT)
    public void testValues() {
        this.mapWithDeletedEntries();
        List<String> values = new ArrayList<>();
        values.add("c");
        values.add("d");
        values.add("e");
        values.add("a");
        values.add("a");
        values.add("d");
        assertEquals(values, this.map.values());
    }

    @Test(timeout = TIMEOUT)
    public void testEmptyValues() {
        List<String> values = new ArrayList<>();
        assertEquals(values, this.map.values());
    }

    @Test(timeout = TIMEOUT)
    public void testResizeBackingTable() {
        this.map.put(1, "a");
        this.map.put(-6, "b");
        this.map.put(-27, "c");
        this.map.put(47, "d");
        this.map.put(2, "e");
        this.map.put(25, "f");

        this.map.remove(47);
        this.map.remove(25);

        this.map.resizeBackingTable(4);
        LinearProbingMapEntry<Integer, String>[] table =
                new LinearProbingMapEntry[4];

        table[0] = new LinearProbingMapEntry<>(-6, "b");
        table[1] = new LinearProbingMapEntry<>(1, "a");
        table[2] = new LinearProbingMapEntry<>(2, "e");
        table[3] = new LinearProbingMapEntry<>(-27, "c");

        assertArrayEquals(table, this.map.getTable());
    }

    @Test(timeout = TIMEOUT)
    public void testResizeTooSmall() {
        this.map.put(1, "a");
        this.map.put(6, "b");
        this.map.put(0, "c");
        this.map.put(7, "d");
        this.map.remove(7);

        try {
            this.map.resizeBackingTable(2);
        } catch (IllegalArgumentException e) { }
    }

    @Test(timeout = TIMEOUT)
    public void testSize() {
        this.map.resizeBackingTable(4);
        assertEquals(0, this.map.size());
        this.map.put(1, "a");
        assertEquals(1, this.map.size());
        this.map.put(6, "b");
        assertEquals(2, this.map.size());
        this.map.put(0, "c");

        this.map.remove(1);
        assertEquals(2, this.map.size());

        this.map.put(7, "d");
        assertEquals(3, this.map.size());
        this.map.put(2, "e");
        assertEquals(4, this.map.size());

        this.map.remove(6);
        assertEquals(3, this.map.size());
    }

    @Test(timeout = TIMEOUT)
    public void testClear() {

        this.map.resizeBackingTable(8);
        this.map.put(0, "a");
        this.map.put(1, "b");
        this.map.put(9, "c");
        this.map.put(-9, "d");
        this.map.remove(9);

        LinearProbingMapEntry<Integer, String>[] table =
                new LinearProbingMapEntry[8];
        table[0] = new LinearProbingMapEntry<>(0, "a");
        table[1] = new LinearProbingMapEntry<>(1, "b");
        LinearProbingMapEntry<Integer,String> key9 =
                new LinearProbingMapEntry<>(9, "c");
        key9.setRemoved(true);
        table[2] = key9;
        table[3] = new LinearProbingMapEntry<>(-9, "d");

        assertArrayEquals(table, this.map.getTable());
        assertEquals(3, this.map.size());

        this.map.clear();
        LinearProbingMapEntry<Integer, String>[] cleared =
                new LinearProbingMapEntry[LinearProbingHashMap.INITIAL_CAPACITY];
        assertArrayEquals(cleared, this.map.getTable());
        assertEquals(0, this.map.size());
    }

}