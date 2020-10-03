import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * A relatively comprehensive set of tests for HW 06 in CS 1332.
 * Should be used in conjunction with the TA tests.
 * Should cover MOST edge cases.
 *
 * @author Andy Jiang (ajiang48@gatech.edu)
 * @version 1.0
 *
 */

public class AndyJiangHashMapTest {

    private static final int TIMEOUT = 200;
    private LinearProbingHashMap<Integer, String> map;

    @Before
    public void setUp() {
        map = new LinearProbingHashMap<>();
    }

    //Constructor Tests
    @Test(timeout = TIMEOUT)
    public void testOtherConstructor() {
        map = new LinearProbingHashMap<>(17);
        assertEquals(0, map.size());
        assertArrayEquals(new LinearProbingMapEntry[17], map.getTable());
    }

    //Put Tests
    @Test(timeout = TIMEOUT)
    public void testNullKey() {
        try {
            map.put(null, "THWg");
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test(timeout = TIMEOUT)
    public void testNullValue() {
        try {
            map.put(1332, null);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test(timeout = TIMEOUT)
    public void testAddALot() {

        assertNull(map.put(1331, "Intro to Object Oriented Programming"));
        assertNull(map.put(1332, "Data Structures and Algorithms"));
        assertNull(map.put(1371, "Programming for Engineers"));
        assertNull(map.put(2340, "Objects and Design"));
        assertNull(map.put(3510, "Design and Analysis of Algorithms"));
        assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
        assertNull(map.put(4510, "Automata and Complexity"));
        assertNull(map.put(4641, "Machine Learning"));

        assertEquals(8, map.size());

        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[13];

        expected[0] = new LinearProbingMapEntry<>(2340, "Objects and Design");
        expected[1] = new LinearProbingMapEntry<>(3510, "Design and Analysis of Algorithms");
        expected[2] = new LinearProbingMapEntry<>(4510, "Automata and Complexity");
        expected[3] = new LinearProbingMapEntry<>(4641, "Machine Learning");
        expected[5] = new LinearProbingMapEntry<>(1331, "Intro to Object Oriented Programming");
        expected[6] = new LinearProbingMapEntry<>(1332, "Data Structures and Algorithms");
        expected[7] = new LinearProbingMapEntry<>(1371, "Programming for Engineers");
        expected[12] = new LinearProbingMapEntry<>(3600, "Introduction to Artificial Intelligence");

        assertArrayEquals(expected, map.getTable());

    }

    @Test(timeout = TIMEOUT)
    public void testAddResize() {

        assertNull(map.put(1331, "Intro to Object Oriented Programming"));
        assertNull(map.put(1332, "Data Structures and Algorithms"));
        assertNull(map.put(1371, "Programming for Engineers"));
        assertNull(map.put(2340, "Objects and Design"));
        assertNull(map.put(3510, "Design and Analysis of Algorithms"));
        assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
        assertNull(map.put(4510, "Automata and Complexity"));
        assertNull(map.put(4641, "Machine Learning"));

        assertNull(map.put(3240, "Languages and Computation"));

        assertEquals(9, map.size());

        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[27];

        expected[18] = new LinearProbingMapEntry<>(2340, "Objects and Design");
        expected[0] = new LinearProbingMapEntry<>(3510, "Design and Analysis of Algorithms");
        expected[1] = new LinearProbingMapEntry<>(4510, "Automata and Complexity");
        expected[24] = new LinearProbingMapEntry<>(4641, "Machine Learning");
        expected[8] = new LinearProbingMapEntry<>(1331, "Intro to Object Oriented Programming");
        expected[9] = new LinearProbingMapEntry<>(1332, "Data Structures and Algorithms");
        expected[21] = new LinearProbingMapEntry<>(1371, "Programming for Engineers");
        expected[10] = new LinearProbingMapEntry<>(3600, "Introduction to Artificial Intelligence");
        expected[2] = new LinearProbingMapEntry<>(3240, "Languages and Computation");

        assertArrayEquals(expected, map.getTable());

    }

    @Test(timeout = TIMEOUT)
    public void testReplace() {

        assertNull(map.put(1331, "Intro to Object Oriented Programming"));
        assertNull(map.put(1332, "Data Structures and Algorithms"));
        assertNull(map.put(1371, "Programming for Engineers"));
        assertNull(map.put(2340, "Objects and Design"));
        assertNull(map.put(3510, "Design and Analysis of Algorithms"));
        assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
        assertNull(map.put(4510, "Automata and Complexity"));
        assertNull(map.put(4641, "Machine Learning"));
        assertNull(map.put(3240, "Languages and Computation"));

        assertEquals("Data Structures and Algorithms", map.put(1332, "Algorithms and Data Structures"));

        assertEquals(9, map.size());

        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[27];

        expected[18] = new LinearProbingMapEntry<>(2340, "Objects and Design");
        expected[0] = new LinearProbingMapEntry<>(3510, "Design and Analysis of Algorithms");
        expected[1] = new LinearProbingMapEntry<>(4510, "Automata and Complexity");
        expected[24] = new LinearProbingMapEntry<>(4641, "Machine Learning");
        expected[8] = new LinearProbingMapEntry<>(1331, "Intro to Object Oriented Programming");
        expected[9] = new LinearProbingMapEntry<>(1332, "Algorithms and Data Structures");
        expected[21] = new LinearProbingMapEntry<>(1371, "Programming for Engineers");
        expected[10] = new LinearProbingMapEntry<>(3600, "Introduction to Artificial Intelligence");
        expected[2] = new LinearProbingMapEntry<>(3240, "Languages and Computation");

        assertArrayEquals(expected, map.getTable());

    }

    //Remove Tests
    @Test(timeout = TIMEOUT)
    public void testRemove() {

        assertNull(map.put(1331, "Intro to Object Oriented Programming"));
        assertNull(map.put(1332, "Data Structures and Algorithms"));
        assertNull(map.put(1371, "Programming for Engineers"));
        assertNull(map.put(2340, "Objects and Design"));
        assertNull(map.put(3510, "Design and Analysis of Algorithms"));
        assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
        assertNull(map.put(4510, "Automata and Complexity"));
        assertNull(map.put(4641, "Machine Learning"));
        assertNull(map.put(3240, "Languages and Computation"));

        assertEquals("Intro to Object Oriented Programming", map.remove(1331));
        assertTrue(map.getTable()[8].isRemoved());
        assertEquals(8, map.size());

        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[27];

        expected[18] = new LinearProbingMapEntry<>(2340, "Objects and Design");
        expected[0] = new LinearProbingMapEntry<>(3510, "Design and Analysis of Algorithms");
        expected[1] = new LinearProbingMapEntry<>(4510, "Automata and Complexity");
        expected[24] = new LinearProbingMapEntry<>(4641, "Machine Learning");
        expected[8] = new LinearProbingMapEntry<>(1331, "Intro to Object Oriented Programming");
        expected[8].setRemoved(true);
        expected[9] = new LinearProbingMapEntry<>(1332, "Data Structures and Algorithms");
        expected[21] = new LinearProbingMapEntry<>(1371, "Programming for Engineers");
        expected[10] = new LinearProbingMapEntry<>(3600, "Introduction to Artificial Intelligence");
        expected[2] = new LinearProbingMapEntry<>(3240, "Languages and Computation");

        assertArrayEquals(expected, map.getTable());

    }

    @Test(timeout = TIMEOUT)
    public void testNoSuchElement() {

        try {
            assertNull(map.put(1331, "Intro to Object Oriented Programming"));
            assertNull(map.put(1332, "Data Structures and Algorithms"));
            assertNull(map.put(1371, "Programming for Engineers"));
            assertNull(map.put(2340, "Objects and Design"));
            assertNull(map.put(3510, "Design and Analysis of Algorithms"));
            assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
            assertNull(map.put(4510, "Automata and Complexity"));
            assertNull(map.put(4641, "Machine Learning"));
            assertNull(map.put(3240, "Languages and Computation"));

            map.remove(0);

            fail();
        } catch (NoSuchElementException e) {

        }

    }

    @Test(timeout = TIMEOUT)
    public void testDoubleRemove() {

        try {
            assertNull(map.put(1331, "Intro to Object Oriented Programming"));
            assertNull(map.put(1332, "Data Structures and Algorithms"));
            assertNull(map.put(1371, "Programming for Engineers"));
            assertNull(map.put(2340, "Objects and Design"));
            assertNull(map.put(3510, "Design and Analysis of Algorithms"));
            assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
            assertNull(map.put(4510, "Automata and Complexity"));
            assertNull(map.put(4641, "Machine Learning"));
            assertNull(map.put(3240, "Languages and Computation"));

            assertEquals("Intro to Object Oriented Programming", map.remove(1331));
            assertTrue(map.getTable()[8].isRemoved());
            assertEquals(8, map.size());

            map.remove(1331);
            fail();
        } catch (NoSuchElementException e) {

        }

    }

    @Test(timeout = TIMEOUT)
    public void testAddAgain() {

        assertNull(map.put(1331, "Intro to Object Oriented Programming"));
        assertNull(map.put(1332, "Data Structures and Algorithms"));
        assertNull(map.put(1371, "Programming for Engineers"));
        assertNull(map.put(2340, "Objects and Design"));
        assertNull(map.put(3510, "Design and Analysis of Algorithms"));
        assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
        assertNull(map.put(4510, "Automata and Complexity"));
        assertNull(map.put(4641, "Machine Learning"));
        assertNull(map.put(3240, "Languages and Computation"));

        assertEquals("Intro to Object Oriented Programming", map.remove(1331));
        assertTrue(map.getTable()[8].isRemoved());
        assertEquals(8, map.size());

        assertNull(map.put(1331, "Introduction to Java"));
        assertFalse(map.getTable()[8].isRemoved());
        assertEquals(9, map.size());

        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[27];

        expected[18] = new LinearProbingMapEntry<>(2340, "Objects and Design");
        expected[0] = new LinearProbingMapEntry<>(3510, "Design and Analysis of Algorithms");
        expected[1] = new LinearProbingMapEntry<>(4510, "Automata and Complexity");
        expected[24] = new LinearProbingMapEntry<>(4641, "Machine Learning");
        expected[8] = new LinearProbingMapEntry<>(1331, "Introduction to Java");
        expected[9] = new LinearProbingMapEntry<>(1332, "Data Structures and Algorithms");
        expected[21] = new LinearProbingMapEntry<>(1371, "Programming for Engineers");
        expected[10] = new LinearProbingMapEntry<>(3600, "Introduction to Artificial Intelligence");
        expected[2] = new LinearProbingMapEntry<>(3240, "Languages and Computation");

        assertArrayEquals(expected, map.getTable());

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAndAdd() {

        assertNull(map.put(1331, "Intro to Object Oriented Programming"));
        assertNull(map.put(1332, "Data Structures and Algorithms"));
        assertNull(map.put(1371, "Programming for Engineers"));
        assertNull(map.put(2340, "Objects and Design"));
        assertNull(map.put(3510, "Design and Analysis of Algorithms"));
        assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
        assertNull(map.put(4510, "Automata and Complexity"));
        assertNull(map.put(4641, "Machine Learning"));
        assertNull(map.put(3240, "Languages and Computation"));

        assertEquals("Intro to Object Oriented Programming", map.remove(1331));
        assertTrue(map.getTable()[8].isRemoved());
        assertEquals(8, map.size());

        assertNull(map.put(8, "Tobias Oliver"));
        assertFalse(map.getTable()[8].isRemoved());
        assertEquals(9, map.size());

        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[27];

        expected[18] = new LinearProbingMapEntry<>(2340, "Objects and Design");
        expected[0] = new LinearProbingMapEntry<>(3510, "Design and Analysis of Algorithms");
        expected[1] = new LinearProbingMapEntry<>(4510, "Automata and Complexity");
        expected[24] = new LinearProbingMapEntry<>(4641, "Machine Learning");
        expected[8] = new LinearProbingMapEntry<>(8, "Tobias Oliver");
        expected[9] = new LinearProbingMapEntry<>(1332, "Data Structures and Algorithms");
        expected[21] = new LinearProbingMapEntry<>(1371, "Programming for Engineers");
        expected[10] = new LinearProbingMapEntry<>(3600, "Introduction to Artificial Intelligence");
        expected[2] = new LinearProbingMapEntry<>(3240, "Languages and Computation");

        assertArrayEquals(expected, map.getTable());

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAndAdd2() {

        assertNull(map.put(1331, "Intro to Object Oriented Programming"));
        assertNull(map.put(1332, "Data Structures and Algorithms"));
        assertNull(map.put(1371, "Programming for Engineers"));
        assertNull(map.put(2340, "Objects and Design"));
        assertNull(map.put(3510, "Design and Analysis of Algorithms"));
        assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
        assertNull(map.put(4510, "Automata and Complexity"));
        assertNull(map.put(4641, "Machine Learning"));
        assertNull(map.put(3240, "Languages and Computation"));

        assertNull(map.put(27, "Jordan Mason"));

        assertEquals("Design and Analysis of Algorithms", map.remove(3510));
        assertTrue(map.getTable()[0].isRemoved());
        assertEquals(9, map.size());

        assertEquals("Jordan Mason", map.put(27, "Pressley Harvin III"));

        assertEquals(9, map.size());

        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[27];

        expected[18] = new LinearProbingMapEntry<>(2340, "Objects and Design");
        expected[0] = new LinearProbingMapEntry<>(3510, "Design and Analysis of Algorithms");
        expected[0].setRemoved(true);
        expected[1] = new LinearProbingMapEntry<>(4510, "Automata and Complexity");
        expected[3] = new LinearProbingMapEntry<>(27, "Pressley Harvin III");
        expected[24] = new LinearProbingMapEntry<>(4641, "Machine Learning");
        expected[8] = new LinearProbingMapEntry<>(1331, "Intro to Object Oriented Programming");
        expected[9] = new LinearProbingMapEntry<>(1332, "Data Structures and Algorithms");
        expected[21] = new LinearProbingMapEntry<>(1371, "Programming for Engineers");
        expected[10] = new LinearProbingMapEntry<>(3600, "Introduction to Artificial Intelligence");
        expected[2] = new LinearProbingMapEntry<>(3240, "Languages and Computation");

        assertArrayEquals(expected, map.getTable());

    }

    //Get Tests
    @Test(timeout = TIMEOUT)
    public void testNullArg() {

        try {
            assertNull(map.put(1331, "Intro to Object Oriented Programming"));
            assertNull(map.put(1332, "Data Structures and Algorithms"));
            assertNull(map.put(1371, "Programming for Engineers"));
            assertNull(map.put(2340, "Objects and Design"));
            assertNull(map.put(3510, "Design and Analysis of Algorithms"));
            assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
            assertNull(map.put(4510, "Automata and Complexity"));
            assertNull(map.put(4641, "Machine Learning"));

            assertNull(map.put(3240, "Languages and Computation"));

            assertEquals(9, map.size());

            map.get(null);
            fail();

        } catch (IllegalArgumentException e) {

        }

    }

    @Test(timeout = TIMEOUT)
    public void testElementNotFound() {

        try {
            assertNull(map.put(1331, "Intro to Object Oriented Programming"));
            assertNull(map.put(1332, "Data Structures and Algorithms"));
            assertNull(map.put(1371, "Programming for Engineers"));
            assertNull(map.put(2340, "Objects and Design"));
            assertNull(map.put(3510, "Design and Analysis of Algorithms"));
            assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
            assertNull(map.put(4510, "Automata and Complexity"));
            assertNull(map.put(4641, "Machine Learning"));

            assertNull(map.put(3240, "Languages and Computation"));

            assertEquals(9, map.size());

            map.get(27);
            fail();
        } catch (NoSuchElementException e) {

        }

    }

    @Test(timeout = TIMEOUT)
    public void getTest() {

        assertNull(map.put(1331, "Intro to Object Oriented Programming"));
        assertNull(map.put(1332, "Data Structures and Algorithms"));
        assertNull(map.put(1371, "Programming for Engineers"));
        assertNull(map.put(2340, "Objects and Design"));
        assertNull(map.put(3510, "Design and Analysis of Algorithms"));
        assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
        assertNull(map.put(4510, "Automata and Complexity"));
        assertNull(map.put(4641, "Machine Learning"));
        assertNull(map.put(3240, "Languages and Computation"));

        assertEquals(9, map.size());

        assertEquals("Languages and Computation", map.get(3240));

        assertEquals(9, map.size());

    }

    @Test(timeout = TIMEOUT)
    public void getRemoved() {

        try {
            assertNull(map.put(1331, "Intro to Object Oriented Programming"));
            assertNull(map.put(1332, "Data Structures and Algorithms"));
            assertNull(map.put(1371, "Programming for Engineers"));
            assertNull(map.put(2340, "Objects and Design"));
            assertNull(map.put(3510, "Design and Analysis of Algorithms"));
            assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
            assertNull(map.put(4510, "Automata and Complexity"));
            assertNull(map.put(4641, "Machine Learning"));
            assertNull(map.put(3240, "Languages and Computation"));

            assertEquals(9, map.size());

            assertEquals("Languages and Computation", map.remove(3240));

            assertEquals(8, map.size());

            map.get(3240);
            fail();

        } catch (NoSuchElementException e) {

        }

    }

    //Contains Key Tests
    @Test(timeout = TIMEOUT)
    public void containsKeyBasicTest() {

        assertNull(map.put(1331, "Intro to Object Oriented Programming"));
        assertNull(map.put(1332, "Data Structures and Algorithms"));
        assertNull(map.put(1371, "Programming for Engineers"));
        assertNull(map.put(2340, "Objects and Design"));
        assertNull(map.put(3510, "Design and Analysis of Algorithms"));
        assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
        assertNull(map.put(4510, "Automata and Complexity"));
        assertNull(map.put(4641, "Machine Learning"));
        assertNull(map.put(3240, "Languages and Computation"));

        assertEquals(9, map.size());

        assertTrue(map.containsKey(3240));

        assertEquals(9, map.size());

    }

    @Test(timeout = TIMEOUT)
    public void containsRemovedKey() {

        assertNull(map.put(1331, "Intro to Object Oriented Programming"));
        assertNull(map.put(1332, "Data Structures and Algorithms"));
        assertNull(map.put(1371, "Programming for Engineers"));
        assertNull(map.put(2340, "Objects and Design"));
        assertNull(map.put(3510, "Design and Analysis of Algorithms"));
        assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
        assertNull(map.put(4510, "Automata and Complexity"));
        assertNull(map.put(4641, "Machine Learning"));
        assertNull(map.put(3240, "Languages and Computation"));

        assertEquals(9, map.size());

        assertEquals("Languages and Computation", map.remove(3240));

        assertEquals(8, map.size());

        assertFalse(map.containsKey(3240));

    }

    //Resize Tests
    @Test(timeout = TIMEOUT)
    public void resizeToLengthOfHashMap() {

        assertNull(map.put(1331, "Intro to Object Oriented Programming"));
        assertNull(map.put(1332, "Data Structures and Algorithms"));
        assertNull(map.put(1371, "Programming for Engineers"));
        assertNull(map.put(2340, "Objects and Design"));
        assertNull(map.put(3510, "Design and Analysis of Algorithms"));
        assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
        assertNull(map.put(4510, "Automata and Complexity"));
        assertNull(map.put(4641, "Machine Learning"));
        assertNull(map.put(3240, "Languages and Computation"));

        map.resizeBackingTable(9);

        assertEquals(9, map.size());

        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[9];

        expected[5] = new LinearProbingMapEntry<>(2340, "Objects and Design");
        expected[0] = new LinearProbingMapEntry<>(3510, "Design and Analysis of Algorithms");
        expected[1] = new LinearProbingMapEntry<>(4510, "Automata and Complexity");
        expected[7] = new LinearProbingMapEntry<>(4641, "Machine Learning");
        expected[8] = new LinearProbingMapEntry<>(1331, "Intro to Object Oriented Programming");
        expected[3] = new LinearProbingMapEntry<>(1332, "Data Structures and Algorithms");
        expected[6] = new LinearProbingMapEntry<>(1371, "Programming for Engineers");
        expected[4] = new LinearProbingMapEntry<>(3600, "Introduction to Artificial Intelligence");
        expected[2] = new LinearProbingMapEntry<>(3240, "Languages and Computation");

        assertArrayEquals(expected, map.getTable());

    }

    @Test(timeout = TIMEOUT)
    public void resizeTooLittle() {

        try {
            assertNull(map.put(1331, "Intro to Object Oriented Programming"));
            assertNull(map.put(1332, "Data Structures and Algorithms"));
            assertNull(map.put(1371, "Programming for Engineers"));
            assertNull(map.put(2340, "Objects and Design"));
            assertNull(map.put(3510, "Design and Analysis of Algorithms"));
            assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
            assertNull(map.put(4510, "Automata and Complexity"));
            assertNull(map.put(4641, "Machine Learning"));
            assertNull(map.put(3240, "Languages and Computation"));

            map.resizeBackingTable(3);
            fail();

        } catch (IllegalArgumentException e) {

        }

    }

    //Key Set Test
    @Test(timeout = TIMEOUT)
    public void testKeySetAdv() {

        assertNull(map.put(1331, "Intro to Object Oriented Programming"));
        assertNull(map.put(1332, "Data Structures and Algorithms"));
        assertNull(map.put(1371, "Programming for Engineers"));
        assertNull(map.put(2340, "Objects and Design"));
        assertNull(map.put(3510, "Design and Analysis of Algorithms"));
        assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
        assertNull(map.put(4510, "Automata and Complexity"));
        assertNull(map.put(4641, "Machine Learning"));
        assertNull(map.put(3240, "Languages and Computation"));

        assertNull(map.put(27, "Jordan Mason"));

        assertEquals("Design and Analysis of Algorithms", map.remove(3510));
        assertTrue(map.getTable()[0].isRemoved());
        assertEquals(9, map.size());

        assertEquals("Jordan Mason", map.put(27, "Pressley Harvin III"));

        assertEquals(9, map.size());

        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[27];

        expected[18] = new LinearProbingMapEntry<>(2340, "Objects and Design");
        expected[0] = new LinearProbingMapEntry<>(3510, "Design and Analysis of Algorithms");
        expected[0].setRemoved(true);
        expected[1] = new LinearProbingMapEntry<>(4510, "Automata and Complexity");
        expected[3] = new LinearProbingMapEntry<>(27, "Pressley Harvin III");
        expected[24] = new LinearProbingMapEntry<>(4641, "Machine Learning");
        expected[8] = new LinearProbingMapEntry<>(1331, "Intro to Object Oriented Programming");
        expected[9] = new LinearProbingMapEntry<>(1332, "Data Structures and Algorithms");
        expected[21] = new LinearProbingMapEntry<>(1371, "Programming for Engineers");
        expected[10] = new LinearProbingMapEntry<>(3600, "Introduction to Artificial Intelligence");
        expected[2] = new LinearProbingMapEntry<>(3240, "Languages and Computation");

        assertArrayEquals(expected, map.getTable());

        Set<Integer> expectedSet = new HashSet<>();

        expectedSet.add(4510);
        expectedSet.add(3240);
        expectedSet.add(27);
        expectedSet.add(1331);
        expectedSet.add(1332);
        expectedSet.add(3600);
        expectedSet.add(2340);
        expectedSet.add(1371);
        expectedSet.add(4641);

        assertEquals(expectedSet, map.keySet());

    }

    //Values Test
    @Test(timeout = TIMEOUT)
    public void testValuesAdv() {

        assertNull(map.put(1331, "Intro to Object Oriented Programming"));
        assertNull(map.put(1332, "Data Structures and Algorithms"));
        assertNull(map.put(1371, "Programming for Engineers"));
        assertNull(map.put(2340, "Objects and Design"));
        assertNull(map.put(3510, "Design and Analysis of Algorithms"));
        assertNull(map.put(3600, "Introduction to Artificial Intelligence"));
        assertNull(map.put(4510, "Automata and Complexity"));
        assertNull(map.put(4641, "Machine Learning"));
        assertNull(map.put(3240, "Languages and Computation"));

        assertNull(map.put(27, "Jordan Mason"));

        assertEquals("Design and Analysis of Algorithms", map.remove(3510));
        assertTrue(map.getTable()[0].isRemoved());
        assertEquals(9, map.size());

        assertEquals("Jordan Mason", map.put(27, "Pressley Harvin III"));

        assertEquals(9, map.size());

        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[27];

        expected[18] = new LinearProbingMapEntry<>(2340, "Objects and Design");
        expected[0] = new LinearProbingMapEntry<>(3510, "Design and Analysis of Algorithms");
        expected[0].setRemoved(true);
        expected[1] = new LinearProbingMapEntry<>(4510, "Automata and Complexity");
        expected[3] = new LinearProbingMapEntry<>(27, "Pressley Harvin III");
        expected[24] = new LinearProbingMapEntry<>(4641, "Machine Learning");
        expected[8] = new LinearProbingMapEntry<>(1331, "Intro to Object Oriented Programming");
        expected[9] = new LinearProbingMapEntry<>(1332, "Data Structures and Algorithms");
        expected[21] = new LinearProbingMapEntry<>(1371, "Programming for Engineers");
        expected[10] = new LinearProbingMapEntry<>(3600, "Introduction to Artificial Intelligence");
        expected[2] = new LinearProbingMapEntry<>(3240, "Languages and Computation");

        assertArrayEquals(expected, map.getTable());

        List<String> values = new ArrayList<>();

        values.add("Automata and Complexity");
        values.add("Languages and Computation");
        values.add("Pressley Harvin III");
        values.add("Intro to Object Oriented Programming");
        values.add("Data Structures and Algorithms");
        values.add("Introduction to Artificial Intelligence");
        values.add("Objects and Design");
        values.add("Programming for Engineers");
        values.add("Machine Learning");

        assertEquals(values, map.values());

    }

    //Another Edge Case :)
    @Test(timeout=TIMEOUT)
    public void smallStartingMap() {

        map = new LinearProbingHashMap<>(0);
        assertNull(map.put(10, "Jeff Sims"));
        assertNull(map.put(15, "Malachi Carter"));
        assertNull(map.put(21, "Jahmyr Gibbs"));

        assertEquals(3, map.size());

        LinearProbingMapEntry[] expected = new LinearProbingMapEntry[7];

        expected[0] = new LinearProbingMapEntry<>(21, "Jahmyr Gibbs");
        expected[1] = new LinearProbingMapEntry<>(15, "Malachi Carter");
        expected[3] = new LinearProbingMapEntry<>(10, "Jeff Sims");

        assertArrayEquals(expected, map.getTable());

    }

}