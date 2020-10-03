import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Charlie Jenkins cjenkins72@gatech.edu
 * @version 1.0
 */
public class LinearProbingHashMapCharlieTest {
    private LinearProbingHashMap<Integer, String> map;

    @Before
    public void setUp() {
        map = new LinearProbingHashMap<>();
    }

    @Test
    public void duplicateNoSizeIncrease() {
        assertNull(map.put(0, "First"));
        assertEquals("First", map.put(0, "Second"));
        assertEquals(1, map.size());
        assertEquals("Second", map.getTable()[0].getValue());
    }

    @Test
    public void wrapAround() {
        assertNull(map.put(12, "First"));
        assertNull(map.put(25, "Second"));
        assertEquals(2, map.size());
        assertEquals("First", map.getTable()[12].getValue());
        assertEquals("Second", map.getTable()[0].getValue());
    }

    @Test
    public void removeAndReplace() {
        assertNull(map.put(0, "First"));
        map.remove(0);
        assertNull(map.put(0, "First"));
        assertEquals(1, map.size());
        assertEquals("First", map.getTable()[0].getValue());
    }

    @Test
    public void returnToRemoved() {
        assertNull(map.put(0, "First"));
        assertNull(map.put(13, "Second"));
        assertNull(map.put(26, "Third"));
        assertEquals("Second", map.remove(13));
        assertNull(map.put(39, "Fourth"));
        assertEquals(3, map.size());
        assertEquals("First", map.getTable()[0].getValue());
        assertEquals("Fourth", map.getTable()[1].getValue());
        assertEquals("Third", map.getTable()[2].getValue());
    }

    @Test
    public void skipRemovedToReplaceDuplicate() {
        assertNull(map.put(0, "First"));
        assertNull(map.put(13, "Second"));
        assertNull(map.put(26, "Third"));
        assertEquals("Second", map.remove(13));
        assertEquals("Third", map.put(26, "Fourth"));
        assertEquals(2, map.size());

        LinearProbingMapEntry<Integer, String>[] entries =
                (LinearProbingMapEntry<Integer, String>[]) new LinearProbingMapEntry[13];

        entries[0] = new LinearProbingMapEntry<>(0, "First");
        entries[1] = new LinearProbingMapEntry<>(13, "Second");
        entries[1].setRemoved(true);
        entries[2] = new LinearProbingMapEntry<>(26, "Fourth");
        assertArrayEquals(entries, map.getTable());
    }

    @Test
    public void negativeHash() {
        assertNull(map.put(-1, "First"));
        assertEquals(1, map.size());
        assertEquals("First", map.getTable()[1].getValue());
    }

    @Test
    public void ignoreLoadFactorDuringForcedResize() {
        map.put(0, "First");
        map.put(1, "Second");
        map.put(2, "Third");
        map.resizeBackingTable(3);

        assertEquals(3, map.size());

        LinearProbingMapEntry<Integer, String>[] entries =
                (LinearProbingMapEntry<Integer, String>[]) new LinearProbingMapEntry[3];

        entries[0] = new LinearProbingMapEntry<>(0, "First");
        entries[1] = new LinearProbingMapEntry<>(1, "Second");
        entries[2] = new LinearProbingMapEntry<>(2, "Third");
        assertArrayEquals(entries, map.getTable());
    }

    @Test
    public void resizeWithCollisions() {
        map.put(0, "First");
        map.put(13, "Second");
        map.put(26, "Third");
        map.resizeBackingTable(3);

        assertEquals(3, map.size());

        LinearProbingMapEntry<Integer, String>[] entries =
                (LinearProbingMapEntry<Integer, String>[]) new LinearProbingMapEntry[3];

        entries[0] = new LinearProbingMapEntry<>(0, "First");
        entries[1] = new LinearProbingMapEntry<>(13, "Second");
        entries[2] = new LinearProbingMapEntry<>(26, "Third");
        assertArrayEquals(entries, map.getTable());
    }

    @Test
    public void keySetWithDeletions() {
        map.put(0, "First");
        map.put(13, "Second");
        map.put(26, "Third");
        map.remove(13);
        assertEquals(2, map.size());

        Set<Integer> expected = new HashSet<>(2);
        expected.add(0);
        expected.add(26);

        assertEquals(expected, map.keySet());
    }

    @Test
    public void valuesWithDeletions() {
        assertNull(map.put(0, "First"));
        assertNull(map.put(13, "Second"));
        assertNull(map.put(26, "Third"));
        assertEquals("Second", map.remove(13));
        assertEquals(2, map.size());

        List<String> expected = new ArrayList<>(2);
        expected.add("First");
        expected.add("Third");

        assertEquals(expected, map.values());
    }

    @Test
    public void resizeWithPut() {
        assertNull(map.put(0,  "0"));
        assertNull(map.put(1,  "1"));
        assertNull(map.put(2,  "2"));
        assertNull(map.put(3,  "3"));
        assertNull(map.put(4,  "4"));
        assertNull(map.put(5,  "5"));
        assertNull(map.put(6,  "6"));
        assertNull(map.put(7,  "7"));
        assertEquals(13, map.getTable().length);
        assertNull(map.put(8,  "8"));
        assertEquals(27, map.getTable().length);
    }

    @Test
    public void stopAtDeletedMatchingKey() {
        assertNull(map.put(0, "First"));
        assertNull(map.put(13, "Second"));
        assertNull(map.put(26, "Third"));

        assertEquals("Second", map.remove(13));
        assertEquals("Third", map.remove(26));

        assertNull(map.put(13, "Fourth"));

        assertEquals("Fourth", map.getTable()[1].getValue());
    }

    @Test
    public void insertAtDeletedBeforeMatchingKey() {
        assertNull(map.put(0, "First"));
        assertNull(map.put(13, "Second"));
        assertNull(map.put(26, "Third"));

        assertEquals("Second", map.remove(13));
        assertEquals("Third", map.remove(26));

        assertNull(map.put(26, "Fourth"));

        assertEquals("Fourth", map.getTable()[1].getValue());
    }
}