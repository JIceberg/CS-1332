import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

/**
 * This is Unit Test for HW3 in CS1332
 *
 * @Author Jeonghoon Lee
 * @version 1.0
 */
public class DequeJeonghoonTest {

    private static final int TIMEOUT = 200;
    private ArrayDeque<String> array;
    private LinkedDeque<String> linked;

    @Before
    public void setup() {
        array = new ArrayDeque<>();
        linked = new LinkedDeque<>();
    }

    @Test(timeout = TIMEOUT)
    public void testArrayInit() {
        assertEquals(0, array.size());
        assertArrayEquals(new String[ArrayDeque.INITIAL_CAPACITY], array.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayAddFirst() {
        int initCap = ArrayDeque.INITIAL_CAPACITY;
        String[] strArray = new String[initCap];

        array.addFirst("0a"); // _ _ _ _ _ _ _ _ _ _ 0a
        strArray[initCap - 1] = "0a";
        assertEquals(1, array.size());
        assertArrayEquals(strArray, array.getBackingArray());

        array.addFirst("1a"); // _ _ _ _ _ _ _ _ _ 1a 0a
        strArray[initCap - 2] = "1a";
        assertEquals(2, array.size());
        assertArrayEquals(strArray, array.getBackingArray());

        array.addFirst("2a"); // _ _ _ _ _ _ _ _ 2a 1a 0a
        strArray[initCap - 3] = "2a";
        assertEquals(3, array.size());
        assertArrayEquals(strArray, array.getBackingArray());

        array.addFirst("3a"); // _ _ _ _ _ _ _ 3a 2a 1a 0a
        strArray[initCap - 4] = "3a";
        assertEquals(4, array.size());
        assertArrayEquals(strArray, array.getBackingArray());

        for (int i = 4; i < 12; i++) {
            array.addFirst(i + "a");
        }

        strArray = new String[2 * initCap];
        for (int i = 0; i < 12; i++) {
            strArray[i] = (11 - i) + "a";
        }
        assertEquals(12, array.size());
        assertArrayEquals(strArray, array.getBackingArray());
        // 11a 10a 9a 8a 7a 6a 5a 4a 3a 2a 1a 0a _ _ _ _ _ _ _ _ _ _
        // See the HW3.pdf page5 example.
        //"In the example below, adding another element causes the deque to resize. The array capacity is doubled
        //and the front element moves to index 0"

        array.addFirst("12a"); // 11a 10a 9a 8a 7a 6a 5a 4a 3a 2a 1a 0a _ _ _ _ _ _ _ _ _ 12a
        strArray[(2 * initCap) - 1] = "12a";
        assertEquals(13, array.size());
        assertArrayEquals(strArray, array.getBackingArray());

        for (int i = 13; i < 23; i++) {
            array.addFirst(i + "a");
        }
        // 11a 10a 9a 8a 7a 6a 5a 4a 3a 2a 1a 0a 21a 20a 19a 18a 17a 16a 15a 14a 13a 12a
        // to                                   (21a was front)
        // 22a 21a 20a 19a 18a 17a 16a 15a 14a 13a 12a 11a 10a 9a 8a 7a 6a 5a 4a 3a 2a 1a 0a _ _ ...

        strArray = new String[2 * 2 * initCap];
        for (int i = 0; i < 23; i++) {
            strArray[i] = (22 - i) + "a";
        }
        assertEquals(23, array.size());
        assertArrayEquals(strArray, array.getBackingArray());

        array.addFirst("23a");
        // 22a 21a 20a 19a 18a 17a 16a 15a 14a 13a 12a 11a 10a 9a 8a 7a 6a 5a 4a 3a 2a 1a 0a _ _ ... _ _ 23a
        strArray[(2 * 2 * initCap) - 1] = "23a";
        assertEquals(24, array.size());
        assertArrayEquals(strArray, array.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayAddFirstException() {
        try {
            array.addFirst(null);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test(timeout = TIMEOUT)
    public void testArrayAddLast() {
        int initCap = ArrayDeque.INITIAL_CAPACITY;
        String[] strArray = new String[initCap];

        array.addLast("0a"); // 0a _ _ _ _ _ _ _ _ _ _
        strArray[0] = "0a";
        assertEquals(1, array.size());
        assertArrayEquals(strArray, array.getBackingArray());

        array.addLast("1a"); // 0a 1a _ _ _ _ _ _ _ _ _
        strArray[1] = "1a";
        assertEquals(2, array.size());
        assertArrayEquals(strArray, array.getBackingArray());

        array.addLast("2a"); // 0a 1a 2a _ _ _ _ _ _ _ _
        strArray[2] = "2a";
        assertEquals(3, array.size());
        assertArrayEquals(strArray, array.getBackingArray());

        array.addLast("3a"); // 0a 1a 2a 3a _ _ _ _ _ _ _
        strArray[3] = "3a";
        assertEquals(4, array.size());
        assertArrayEquals(strArray, array.getBackingArray());

        for (int i = 4; i < 12; i++) {
            array.addLast(i + "a");
        }

        strArray = new String[2 * initCap];
        for (int i = 0; i < 12; i++) {
            strArray[i] = (i) + "a";
        }
        assertEquals(12, array.size());
        assertArrayEquals(strArray, array.getBackingArray());
        // 0a 1a 2a 3a 4a 5a 6a 7a 8a 9a 10a 11a _ _ _ _ _ _ _ _ _ _ _
        // See the HW3.pdf page5 example.
        //"In the example below, adding another element causes the deque to resize. The array capacity is doubled
        //and the front element moves to index 0"

        array.addLast("12a"); // 0a 1a 2a 3a 4a 5a 6a 7a 8a 9a 10a 11a 12a _ _ _ _ _ _ _ _ _ _
        strArray[12] = "12a";
        assertEquals(13, array.size());
        assertArrayEquals(strArray, array.getBackingArray());

        //ASSUME THAT ADDFIRST/LAST METHOD WORKS PROPERLY.
        array.addFirst("-1a"); // 0a 1a 2a 3a 4a 5a 6a 7a 8a 9a 10a 11a 12a _ _ _ _ _ _ _ _ _ -1a <-Front
        array.addLast("13a"); // 0a 1a 2a 3a 4a 5a 6a 7a 8a 9a 10a 11a 12a 13a _ _ _ _ _ _ _ _ -1a <-Front
        strArray[21] = "-1a";
        strArray[13] = "13a";
        assertEquals(15, array.size());
        assertArrayEquals(strArray, array.getBackingArray());


        for (int i = 14; i < 23; i++) {
            array.addLast(i + "a");
        }
        // 0a 1a 2a 3a 4a 5a 6a 7a 8a 9a 10a 11a 12a 13a 14a 15a 16a 17a 18a 19a 20a 21a -1a <-Front
        // to                                                                   (-1a was front)
        // -1a 0a 1a 2a 3a 4a 5a 6a 7a 8a 9a 10a 11a 12a 13a 14a 15a 16a 17a 18a 19a 20a 21a 22a _ _ ...

        strArray = new String[2 * 2 * initCap];
        for (int i = 0; i < 24; i++) {
            strArray[i] = (i - 1) + "a";
        }
        assertEquals(24, array.size());
        assertArrayEquals(strArray, array.getBackingArray());

        array.addLast("23a");
        // -1a 0a 1a 2a 3a 4a 5a 6a 7a 8a 9a 10a 11a 12a 13a 14a 15a 16a 17a 18a 19a 20a 21a 22a 23a _ ...
        strArray[24] = "23a";
        assertEquals(25, array.size());
        assertArrayEquals(strArray, array.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayAddLastException() {
        try {
            array.addLast(null);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test(timeout = TIMEOUT)
    public void testArrayRemoveFirst() {
        for (int i = 0; i < 10; i++) {
            array.addLast(i + "a");
        }
        //0a 1a 2a 3a 4a 5a 6a 7a 8a 9a _ (Front == index 0)
        //ASSUME THAT ADDLAST METHOD WORKS PROPERLY.

        assertEquals("0a", array.removeFirst());
        //_ 1a 2a 3a 4a 5a 6a 7a 8a 9a _ (Front == index 1)
        Object[] temp = array.getBackingArray();
        assertNull(temp[0]);
        //Replace any spots that you remove from with null. Failure to do so can
        //result in loss of points. (FROM JAVA DOCS)
        assertEquals(9, array.size());

        assertEquals("1a", array.removeFirst());
        //_ _ 2a 3a 4a 5a 6a 7a 8a 9a _ (Front == index 2)
        temp = array.getBackingArray();
        assertNull(temp[0]);
        assertNull(temp[1]);
        assertEquals(8, array.size());

        assertEquals("2a", array.removeFirst());
        //_ _ _ 3a 4a 5a 6a 7a 8a 9a _ (Front == index 3)
        temp = array.getBackingArray();
        assertNull(temp[0]);
        assertNull(temp[1]);
        assertNull(temp[2]);
        assertEquals(7, array.size());

        array.addFirst("2a");
        //ASSUME THAT ADDFIRST METHOD WORKS PROPERLY. (For Checking Front variable)
        //_ _ 2a 3a 4a 5a 6a 7a 8a 9a _ (Front == index 2)

        assertEquals("2a", array.removeFirst());
        //_ _ _ 3a 4a 5a 6a 7a 8a 9a _ (Front == index 3)
        temp = array.getBackingArray();
        assertNull(temp[0]);
        assertNull(temp[1]);
        assertNull(temp[2]);
        assertEquals(7, array.size());

        for (int i = 0; i < 7; i++) {
            assertEquals((3 + i) + "a", array.removeFirst());
        }
        //_ _ _ _ _ _ _ _ _ _ _ EMPTY (Front SHOULD BE INDEX 10)
        assertEquals(0, array.size());
        temp = array.getBackingArray();
        for (int i = 0; i < 11; i++) {
            assertNull(temp[i]);
        }
        array.addFirst("0a");
        //_ _ _ _ _ _ _ _ _ 0a _
        temp = array.getBackingArray();
        //ASSUME THAT ADDFIRST METHOD WORKS PROPERLY. (For Checking Front variable)
        assertEquals("0a", temp[9]);
        // Front should be index 9
        // See HW3.pdf page5 example
        // From Page4 "after removing the last element in the deque, move the front variable like you normally
        // would. Do not explicitly reset it to 0. This effectively means that going from size 1 to size 0
        // @@SHOULD NOT BE A SPECIAL@@ CASE for your code."
    }

    @Test(timeout = TIMEOUT)
    public void testArrayRemoveFirstException() {
        try {
            array.removeFirst();
            fail();
        } catch (NoSuchElementException e) {

        }
    }

    @Test(timeout = TIMEOUT)
    public void testArrayRemoveLast() {
        for (int i = 0; i < 10; i++) {
            array.addLast(i + "a");
        }
        //0a 1a 2a 3a 4a 5a 6a 7a 8a 9a _ (Front == index 0)
        //ASSUME THAT ADDLAST METHOD WORKS PROPERLY.

        assertEquals("9a", array.removeLast());
        //0a 1a 2a 3a 4a 5a 6a 7a 8a _ _ (Front == index 0)
        Object[] temp = array.getBackingArray();
        assertNull(temp[9]);
        //Replace any spots that you remove from with null. Failure to do so can
        //result in loss of points. (FROM JAVA DOCS)
        assertEquals(9, array.size());

        assertEquals("8a", array.removeLast());
        //0a 1a 2a 3a 4a 5a 6a 7a _ _ _ (Front == index 0)
        temp = array.getBackingArray();
        assertNull(temp[8]);
        assertNull(temp[9]);
        assertEquals(8, array.size());

        assertEquals("7a", array.removeLast());
        //0a 1a 2a 3a 4a 5a 6a _ _ _ _ (Front == index 0)
        temp = array.getBackingArray();
        assertNull(temp[7]);
        assertNull(temp[8]);
        assertNull(temp[9]);
        assertEquals(7, array.size());

        array.addFirst("-1a");
        //ASSUME THAT ADDFIRST METHOD WORKS PROPERLY. (For Checking Front variable)
        //0a 1a 2a 3a 4a 5a 6a _ _ _ -1a (Front == index 10)

        assertEquals("6a", array.removeLast());
        //0a 1a 2a 3a 4a 5a _ _ _ _ -1a (Front == index 10)
        temp = array.getBackingArray();
        assertNull(temp[6]);
        assertNull(temp[7]);
        assertNull(temp[8]);
        assertNull(temp[9]);
        assertEquals("-1a", temp[10]);
        assertEquals(7, array.size());

        for (int i = 0; i < 7; i++) {
            assertEquals((5 - i) + "a", array.removeLast());
        }
        //_ _ _ _ _ _ _ _ _ _ _ EMPTY (Front SHOULD BE INDEX 10)
        assertEquals(0, array.size());
        temp = array.getBackingArray();
        for (int i = 0; i < 11; i++) {
            assertNull(temp[i]);
        }
        array.addFirst("0a");
        //_ _ _ _ _ _ _ _ _ 0a _
        temp = array.getBackingArray();
        //ASSUME THAT ADDFIRST METHOD WORKS PROPERLY. (For Checking Front variable)
        assertEquals("0a", temp[9]);
        // Front should be index 9
        // See HW3.pdf page5 example
        // From Page4 "after removing the last element in the deque, move the front variable like you normally
        // would. Do not explicitly reset it to 0. This effectively means that going from size 1 to size 0
        // @@SHOULD NOT BE A SPECIAL@@ CASE for your code."
    }

    @Test(timeout = TIMEOUT)
    public void testArrayRemoveLastException() {
        try {
            array.removeLast();
            fail();
        } catch (NoSuchElementException e) {

        }
    }

    @Test(timeout = TIMEOUT)
    public void testArrayGetFirst() {
        for (int i = 0; i < 4; i++) {
            array.addLast(i + "a");
        }
        //0a 1a 2a 3a _ _ _ _ _ _ _ (Front == index 0)
        //ASSUME THAT ADDLAST METHOD WORKS PROPERLY.
        assertEquals("0a", array.getFirst());

        array.addFirst("-1a");
        //0a 1a 2a 3a _ _ _ _ _ _ -1a (Front == index 10)
        //ASSUME THAT ADDFIRST METHOD WORKS PROPERLY.
        assertEquals("-1a", array.getFirst());

        array.addFirst("-2a");
        //0a 1a 2a 3a _ _ _ _ _ -2a -1a (Front == index 9)
        //ASSUME THAT ADDFIRST METHOD WORKS PROPERLY.
        assertEquals("-2a", array.getFirst());

        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        //_ 1a 2a 3a _ _ _ _ _ _ _ (Front == index 1)
        //ASSUME THAT REMOVEFIRST METHOD WORKS PROPERLY.
        assertEquals("1a", array.getFirst());

        for (int i = 0; i < 8; i++) {
            array.addLast((i + 4) + "a");
        }
        // 11a 1a 2a 3a 4a 5a 6a 7a 8a 9a 10a (Front == index 1)
        assertEquals("1a", array.getFirst());

        array.addLast("12a");
        // 1a 2a 3a 4a 5a 6a 7a 8a 9a 10a 11a 12a _ _ _ _ _ _ _ _ _ _ _(Front == index 0)
        assertEquals("1a", array.getFirst());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayGetFirstException() {
        try {
            array.getFirst();
            fail();
        } catch (NoSuchElementException e) {
        }
    }

    @Test(timeout = TIMEOUT)
    public void testArrayGetLast() {
        for (int i = 0; i < 4; i++) {
            array.addLast(i + "a");
        }
        //0a 1a 2a 3a _ _ _ _ _ _ _ (Front == index 0)
        //ASSUME THAT ADDLAST METHOD WORKS PROPERLY.
        assertEquals("3a", array.getLast());

        array.addFirst("-1a");
        //0a 1a 2a 3a _ _ _ _ _ _ -1a (Front == index 10)
        //ASSUME THAT ADDFIRST METHOD WORKS PROPERLY.
        assertEquals("3a", array.getLast());

        array.addFirst("-2a");
        //0a 1a 2a 3a _ _ _ _ _ -2a -1a (Front == index 9)
        //ASSUME THAT ADDFIRST METHOD WORKS PROPERLY.
        assertEquals("3a", array.getLast());

        array.removeLast();
        array.removeLast();
        array.removeLast();
        //0a _ _ _ _ _ _ _ _ -2a -1a (Front == index 9)
        //ASSUME THAT REMOVEFIRST METHOD WORKS PROPERLY.
        assertEquals("0a", array.getLast());

        for (int i = 0; i < 8; i++) {
            array.addLast((i + 1) + "a");
        }
        // 0a 1a 2a 3a 4a 5a 6a 7a 8a -2a -1a (Front == index 9)
        assertEquals("8a", array.getLast());

        array.addLast("9a");
        // -2a -1a 0a 1a 2a 3a 4a 5a 6a 7a 8a 9a _ _ _ _ _ _ _ _ _ _ _(Front == index 0)
        assertEquals("9a", array.getLast());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayGetLastException() {
        try {
            array.getLast();
            fail();
        } catch (NoSuchElementException e) {

        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////LINKED DEQUE TEST//////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////

    @Test(timeout = TIMEOUT)
    public void testLinkedInit() {
        assertEquals(0, linked.size());
        assertNull(linked.getHead());
        assertNull(linked.getTail());
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedAddFirst() {
        linked.addFirst("4a"); // head -> 4a <- tail
        assertEquals(1, linked.size());
        assertEquals("4a", linked.getHead().getData());
        assertNull(linked.getHead().getPrevious());
        assertNull(linked.getTail().getNext());
        assertSame(linked.getHead(), linked.getTail());

        linked.addFirst("3a"); // head -> 3a 4a <- tail
        assertEquals(2, linked.size());
        assertEquals("3a", linked.getHead().getData());
        assertEquals("4a", linked.getHead().getNext().getData());
        assertNull(linked.getHead().getPrevious());
        assertNull(linked.getTail().getNext());
        assertSame(linked.getHead(), linked.getTail().getPrevious());
        assertSame(linked.getHead().getNext(), linked.getTail());

        linked.addFirst("2a"); // head -> 2a 3a 4a <- tail
        assertEquals(3, linked.size());
        assertEquals("2a", linked.getHead().getData());
        assertEquals("3a", linked.getHead().getNext().getData());
        assertEquals("4a", linked.getHead().getNext().getNext().getData());
        assertNull(linked.getHead().getPrevious());
        assertNull(linked.getTail().getNext());
        assertSame(linked.getHead(), linked.getTail().getPrevious().getPrevious());
        assertSame(linked.getHead().getNext(), linked.getTail().getPrevious());
        assertSame(linked.getHead().getNext().getNext(), linked.getTail());
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedAddFirstException() {
        try {
            linked.addFirst(null);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedAddLast() {
        linked.addLast("4a"); // head -> 4a <- tail
        assertEquals(1, linked.size());
        assertEquals("4a", linked.getHead().getData());
        assertNull(linked.getHead().getPrevious());
        assertNull(linked.getTail().getNext());
        assertSame(linked.getHead(), linked.getTail());

        linked.addLast("3a"); // head -> 4a 3a <- tail
        assertEquals(2, linked.size());
        assertEquals("4a", linked.getHead().getData());
        assertEquals("3a", linked.getHead().getNext().getData());
        assertNull(linked.getHead().getPrevious());
        assertNull(linked.getTail().getNext());
        assertSame(linked.getHead(), linked.getTail().getPrevious());
        assertSame(linked.getHead().getNext(), linked.getTail());

        linked.addLast("2a"); // head -> 4a 3a 2a <- tail
        assertEquals(3, linked.size());
        assertEquals("4a", linked.getHead().getData());
        assertEquals("3a", linked.getHead().getNext().getData());
        assertEquals("2a", linked.getHead().getNext().getNext().getData());
        assertNull(linked.getHead().getPrevious());
        assertNull(linked.getTail().getNext());
        assertSame(linked.getHead(), linked.getTail().getPrevious().getPrevious());
        assertSame(linked.getHead().getNext(), linked.getTail().getPrevious());
        assertSame(linked.getHead().getNext().getNext(), linked.getTail());
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedAddLastException() {
        try {
            linked.addLast(null);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedRemoveFirst() {
        linked.addFirst("4a"); // head -> 4a <- tail
        linked.addFirst("3a"); // head -> 3a 4a <- tail
        linked.addFirst("2a"); // head -> 2a 3a 4a <- tail
        linked.addFirst("1a"); // head -> 1a 2a 3a 4a <- tail
        linked.addFirst("0a"); // head -> 0a 1a 2a 3a 4a <- tail
        // ASSUME THAT ADDFIRST METHOD WORKS PEROPERLY.

        assertEquals("0a", linked.removeFirst()); // head -> 1a 2a 3a 4a <- tail (returned: 0a)
        assertEquals(4, linked.size());
        assertEquals("1a", linked.getHead().getData());
        assertEquals("2a", linked.getHead().getNext().getData());
        assertEquals("3a", linked.getHead().getNext().getNext().getData());
        assertEquals("4a", linked.getHead().getNext().getNext().getNext().getData());
        assertNull(linked.getHead().getPrevious());
        assertNull(linked.getTail().getNext());
        assertSame(linked.getHead(), linked.getTail().getPrevious().getPrevious().getPrevious());
        assertSame(linked.getHead().getNext(), linked.getTail().getPrevious().getPrevious());
        assertSame(linked.getHead().getNext().getNext(), linked.getTail().getPrevious());
        assertSame(linked.getHead().getNext().getNext().getNext(), linked.getTail());
        //Check the links are properly connected

        assertEquals("1a", linked.removeFirst()); // head -> 2a 3a 4a <- tail (returned: 1a)
        assertEquals(3, linked.size());
        assertEquals("2a", linked.getHead().getData());
        assertEquals("3a", linked.getHead().getNext().getData());
        assertEquals("4a", linked.getHead().getNext().getNext().getData());
        assertNull(linked.getHead().getPrevious());
        assertNull(linked.getTail().getNext());
        assertSame(linked.getHead(), linked.getTail().getPrevious().getPrevious());
        assertSame(linked.getHead().getNext(), linked.getTail().getPrevious());
        assertSame(linked.getHead().getNext().getNext(), linked.getTail());
        //Check the links are properly connected

        assertEquals("2a", linked.removeFirst()); // head -> 3a 4a <- tail (returned: 2a)
        assertEquals(2, linked.size());
        assertEquals("3a", linked.getHead().getData());
        assertEquals("4a", linked.getHead().getNext().getData());
        assertNull(linked.getHead().getPrevious());
        assertNull(linked.getTail().getNext());
        assertSame(linked.getHead(), linked.getTail().getPrevious());
        assertSame(linked.getHead().getNext(), linked.getTail());
        //Check the links are properly connected

        assertEquals("3a", linked.removeFirst()); // head -> 4a <- tail (returned: 3a)
        assertEquals(1, linked.size());
        assertEquals("4a", linked.getHead().getData());
        assertNull(linked.getHead().getPrevious());
        assertNull(linked.getTail().getNext());
        assertSame(linked.getHead(), linked.getTail());
        //Check the links are properly connected

        assertEquals("4a", linked.removeFirst()); // head ->   <- tail (returned: 4a)
        assertEquals(0, linked.size());
        assertNull(linked.getHead());
        assertNull(linked.getTail());
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedRemoveFirstException() {
        try {
            linked.removeFirst();
            fail();
        } catch (NoSuchElementException e) {

        }
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedRemoveLast() {
        linked.addFirst("4a"); // head -> 4a <- tail
        linked.addFirst("3a"); // head -> 3a 4a <- tail
        linked.addFirst("2a"); // head -> 2a 3a 4a <- tail
        linked.addFirst("1a"); // head -> 1a 2a 3a 4a <- tail
        linked.addFirst("0a"); // head -> 0a 1a 2a 3a 4a <- tail
        // ASSUME THAT ADDFIRST METHOD WORKS PEROPERLY.

        assertEquals("4a", linked.removeLast()); // head -> 0a 1a 2a 3a <- tail (returned: 4a)
        assertEquals(4, linked.size());
        assertEquals("0a", linked.getHead().getData());
        assertEquals("1a", linked.getHead().getNext().getData());
        assertEquals("2a", linked.getHead().getNext().getNext().getData());
        assertEquals("3a", linked.getHead().getNext().getNext().getNext().getData());
        assertNull(linked.getHead().getPrevious());
        assertNull(linked.getTail().getNext());
        assertSame(linked.getHead(), linked.getTail().getPrevious().getPrevious().getPrevious());
        assertSame(linked.getHead().getNext(), linked.getTail().getPrevious().getPrevious());
        assertSame(linked.getHead().getNext().getNext(), linked.getTail().getPrevious());
        assertSame(linked.getHead().getNext().getNext().getNext(), linked.getTail());
        //Check the links are properly connected

        assertEquals("3a", linked.removeLast()); // head -> 0a 1a 2a <- tail (returned: 3a)
        assertEquals(3, linked.size());
        assertEquals("0a", linked.getHead().getData());
        assertEquals("1a", linked.getHead().getNext().getData());
        assertEquals("2a", linked.getHead().getNext().getNext().getData());
        assertNull(linked.getHead().getPrevious());
        assertNull(linked.getTail().getNext());
        assertSame(linked.getHead(), linked.getTail().getPrevious().getPrevious());
        assertSame(linked.getHead().getNext(), linked.getTail().getPrevious());
        assertSame(linked.getHead().getNext().getNext(), linked.getTail());
        //Check the links are properly connected

        assertEquals("2a", linked.removeLast()); // head -> 0a 1a <- tail (returned: 2a)
        assertEquals(2, linked.size());
        assertEquals("0a", linked.getHead().getData());
        assertEquals("1a", linked.getHead().getNext().getData());
        assertNull(linked.getHead().getPrevious());
        assertNull(linked.getTail().getNext());
        assertSame(linked.getHead(), linked.getTail().getPrevious());
        assertSame(linked.getHead().getNext(), linked.getTail());
        //Check the links are properly connected

        assertEquals("1a", linked.removeLast()); // head -> 0a <- tail (returned: 1a)
        assertEquals(1, linked.size());
        assertEquals("0a", linked.getHead().getData());
        assertNull(linked.getHead().getPrevious());
        assertNull(linked.getTail().getNext());
        assertSame(linked.getHead(), linked.getTail());
        //Check the links are properly connected

        assertEquals("0a", linked.removeLast()); // head ->   <- tail (returned: 0a)
        assertEquals(0, linked.size());
        assertNull(linked.getHead());
        assertNull(linked.getTail());
    }


    @Test(timeout = TIMEOUT)
    public void testLinkedRemoveLastException() {
        try {
            linked.removeLast();
            fail();
        } catch (NoSuchElementException e) {

        }
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedGetFirst() {
        linked.addFirst("4a"); // head -> 4a <- tail
        // ASSUME THAT ADDFIRST METHOD WORKS PEROPERLY.
        assertEquals("4a", linked.getFirst());
        assertEquals("4a", linked.getFirst());
        assertEquals(1, linked.size());
        assertEquals("4a", linked.getHead().getData());
        // Get method should not effects to any variable.

        linked.addFirst("3a"); // head -> 3a 4a <- tail
        // ASSUME THAT ADDFIRST METHOD WORKS PEROPERLY.
        assertEquals("3a", linked.getFirst());
        assertEquals("3a", linked.getFirst());
        assertEquals(2, linked.size());
        assertEquals("3a", linked.getHead().getData());
        // Get method should not effects to any variable.

        linked.addFirst("2a"); // head -> 2a 3a 4a <- tail
        // ASSUME THAT ADDFIRST METHOD WORKS PEROPERLY.
        assertEquals("2a", linked.getFirst());
        assertEquals("2a", linked.getFirst());
        assertEquals(3, linked.size());
        assertEquals("2a", linked.getHead().getData());
        // Get method should not effects to any variable.

        linked.addLast("5a"); // head -> 2a 3a 4a 5a <- tail
        // ASSUME THAT ADDLAST METHOD WORKS PEROPERLY.
        assertEquals("2a", linked.getFirst());
        assertEquals("2a", linked.getFirst());
        assertEquals(4, linked.size());
        assertEquals("2a", linked.getHead().getData());
        // Get method should not effects to any variable.

    }

    @Test(timeout = TIMEOUT)
    public void testLinkedGetFirstException() {
        try {
            linked.getFirst();
            fail();
        } catch (NoSuchElementException e) {

        }
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedGetLast() {
        linked.addFirst("4a"); // head -> 4a <- tail
        // ASSUME THAT ADDFIRST METHOD WORKS PEROPERLY.
        assertEquals("4a", linked.getLast());
        assertEquals("4a", linked.getLast());
        assertEquals(1, linked.size());
        assertEquals("4a", linked.getTail().getData());
        // Get method should not effects to any variable.

        linked.addFirst("3a"); // head -> 3a 4a <- tail
        // ASSUME THAT ADDFIRST METHOD WORKS PEROPERLY.
        assertEquals("4a", linked.getLast());
        assertEquals("4a", linked.getLast());
        assertEquals(2, linked.size());
        assertEquals("4a", linked.getTail().getData());
        // Get method should not effects to any variable.

        linked.addFirst("2a"); // head -> 2a 3a 4a <- tail
        // ASSUME THAT ADDFIRST METHOD WORKS PEROPERLY.
        assertEquals("4a", linked.getLast());
        assertEquals("4a", linked.getLast());
        assertEquals(3, linked.size());
        assertEquals("4a", linked.getTail().getData());
        // Get method should not effects to any variable.

        linked.addLast("5a"); // head -> 2a 3a 4a 5a <- tail
        // ASSUME THAT ADDLAST METHOD WORKS PEROPERLY.
        assertEquals("5a", linked.getLast());
        assertEquals("5a", linked.getLast());
        assertEquals(4, linked.size());
        assertEquals("5a", linked.getTail().getData());
        // Get method should not effects to any variable.

    }

    @Test(timeout = TIMEOUT)
    public void testLinkedGetLastException() {
        try {
            linked.getLast();
            fail();
        } catch (NoSuchElementException e) {

        }
    }
}