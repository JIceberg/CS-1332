import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class DLLKrishTest {

    private static final int TIMEOUT = 200;
    private DoublyLinkedList<String> list;

    @Before
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndex() {
        list.addAtIndex(0, "a");

        // ensures that the head and the tail are the same after adding the
        // first item
        assertEquals(list.getHead().getData(), "a");
        assertNull(list.getHead().getNext());
        assertNull(list.getHead().getPrevious());

        assertEquals(list.getTail().getData(), "a");
        assertNull(list.getTail().getNext());
        assertNull(list.getHead().getPrevious());
        assertSame(list.getHead(), list.getTail());

        list.addAtIndex(1, "b");
        assertEquals(list.getHead().getData(), "a");
        assertNull(list.getHead().getPrevious());
        assertNotNull(list.getHead().getNext());

        assertSame(list.getHead(), list.getTail().getPrevious());
        assertSame(list.getHead().getNext(), list.getTail());

    }

    @Test(timeout = TIMEOUT)
    public void testAddAtBadIndex() {
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");

        try {
            list.addAtIndex(-1, "c");
            fail();
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            list.addAtIndex(3, "d");
            fail();
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test(timeout = TIMEOUT)
    public void testAddNull() {
        list.addToBack("a");
        list.addToBack("b");
        try {
            list.addAtIndex(1, null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        try {
            list.addToBack(null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        try {
            list.addToFront(null);
            fail();
        } catch (IllegalArgumentException e) {
        }

    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndexMore() {
        list.addAtIndex(0, "a"); // [a]
        list.addAtIndex(0, "b"); // [b, a]
        list.addAtIndex(1, "c"); // [b, c, a]
        list.addAtIndex(3, "d"); // [b, c, a, d]
        list.addAtIndex(0, "e"); // [e, b, c, a, d]
        list.addAtIndex(2, "f"); // [e, b, f, c, a, d]
        list.addAtIndex(4, "g"); // [e, b, f, c, g, a, d]

        assertEquals(7, list.size());
        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("e", cur.getData());

        DoublyLinkedListNode<String> prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("b", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("f", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("c", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("g", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("d", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);
    }

    @Test(timeout = TIMEOUT)
    public void testAddToFront() {
        list.addToFront("megaman");
        list.addToFront("sonic");
        list.addToFront("mario");

        assertEquals(3, list.size());

        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("mario", cur.getData());

        DoublyLinkedListNode<String> prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("sonic", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("megaman", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);
    }

    @Test(timeout = TIMEOUT)
    public void testAddToBack() {
        list.addToBack("mango");
        list.addToBack("peach");
        list.addToBack("strawberry");
        list.addToBack("guava");

        assertEquals(4, list.size());

        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("mango", cur.getData());

        DoublyLinkedListNode<String> prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("peach", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("strawberry", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("guava", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtBadIndex() {
        list.addToBack("first");
        list.addToBack("second");
        list.addToBack("third");

        try {
            list.removeAtIndex(-1);
            fail();
        } catch (IndexOutOfBoundsException e) { }

        try {
            list.removeAtIndex(3);
            fail();
        } catch (IndexOutOfBoundsException e) { }

        try {
            list.removeAtIndex(4);
            fail();
        } catch (IndexOutOfBoundsException e) { }

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromEmpty() {

        try {
            list.removeFromBack();
            fail();
        } catch (NoSuchElementException e) { }

        try {
            list.removeFromFront();
            fail();
        } catch (NoSuchElementException e) { }

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndex() {
        list.addToBack("hamilton");
        list.addToBack("jefferson");
        list.addToBack("washington");
        list.addToBack("lincoln");
        list.addToBack("adams");

        String firstRemoved = list.removeAtIndex(2);
        assertEquals("washington", firstRemoved);
        assertEquals(4, list.size());

        String secondRemoved = list.removeAtIndex(3);
        assertEquals("adams", secondRemoved);
        assertEquals(3, list.size());

        String thirdRemoved = list.removeAtIndex(0);
        assertEquals("hamilton", thirdRemoved);
        assertEquals(2, list.size());

        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("jefferson", cur.getData());

        DoublyLinkedListNode<String> prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("lincoln", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromFront() {
        list.addToBack("green");
        list.addToBack("red");
        list.addToFront("blue");
        // [blue, green, red]

        String firstRemoved = list.removeFromFront();
        assertEquals("blue", firstRemoved);
        // [green, red]

        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("green", cur.getData());

        DoublyLinkedListNode<String> prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("red", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);

        String secondRemoved = list.removeFromFront();
        assertEquals("green", secondRemoved);
        // [red]

        cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("red", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);

        String thirdRemoved = list.removeFromFront();
        assertEquals("red", thirdRemoved);
        cur = list.getHead();
        assertNull(cur);

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromBack() {
        list.addToFront("cheerios");
        list.addToFront("wheaties");
        list.addToBack("cinnamon toast crunch");

        String firstRemoved = list.removeFromBack();
        assertEquals("cinnamon toast crunch", firstRemoved);

        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("wheaties", cur.getData());

        DoublyLinkedListNode<String> prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("cheerios", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);

        String secondRemoved = list.removeFromBack();
        assertEquals("cheerios", secondRemoved);

        cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("wheaties", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);

        String thirdRemoved = list.removeFromFront();
        assertEquals("wheaties", thirdRemoved);
        cur = list.getHead();
        assertNull(cur);

    }

    @Test(timeout = TIMEOUT)
    public void testGet() {
        list.addAtIndex(0, "a"); // [a]
        list.addAtIndex(0, "b"); // [b, a]
        list.addAtIndex(1, "c"); // [b, c, a]
        list.addAtIndex(3, "d"); // [b, c, a, d]
        list.addAtIndex(0, "e"); // [e, b, c, a, d]
        list.addAtIndex(2, "f"); // [e, b, f, c, a, d]
        list.addAtIndex(4, "g"); // [e, b, f, c, g, a, d]

        assertEquals("e", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("f", list.get(2));
        assertEquals("c", list.get(3));
        assertEquals("g", list.get(4));
        assertEquals("a", list.get(5));
        assertEquals("d", list.get(6));
    }

    @Test(timeout = TIMEOUT)
    public void testGetAtBadIndex() {
        list.addAtIndex(0, "hello");
        list.addAtIndex(1, "goodbye");
        list.addAtIndex(1, "how are you");

        try {
            list.get(-1);
            fail();
        } catch (IndexOutOfBoundsException e) { }

        try {
            list.get(3);
            fail();
        } catch (IndexOutOfBoundsException e) { }
    }

    @Test(timeout = TIMEOUT)
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        list.addToFront("chocolate");
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());

        list.addToBack("candy");
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());

        assertEquals("chocolate", list.removeFromFront());
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());

        assertEquals("candy", list.removeFromBack());
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test(timeout = TIMEOUT)
    public void testClear() {
        list.addToBack("a");
        list.addToBack("b");

        assertEquals(2, list.size());
        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("a", cur.getData());

        DoublyLinkedListNode<String> prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("b", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);

        list.clear();
        assertEquals(0, list.size());
        cur = list.getHead();
        assertNull(cur);
    }


    @Test(timeout = TIMEOUT)
    public void testRemoveLastOccurrence() {

        String firstElem = "a";
        String secondElem = "b";
        String thirdElem = "a";

        list.addToBack(firstElem);
        list.addToBack(secondElem);
        list.addToBack(thirdElem);

        String removedLastA = list.removeLastOccurrence("a");
        assertEquals("a", removedLastA);
        assertSame(thirdElem, removedLastA);
        assertEquals(2, list.size());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveLastFromFront() {

        String firstElem = "a";
        String secondElem = "b";
        String thirdElem = "c";
        String fourthElem = "b";

        list.addToBack(firstElem);
        list.addToBack(secondElem);
        list.addToBack(thirdElem);
        list.addToBack(fourthElem);

        String removedLastA = list.removeLastOccurrence("a");
        assertEquals("a", removedLastA);
        assertSame(firstElem, removedLastA);
        assertEquals(3, list.size());

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveLastFromMiddle() {

        String firstElem = "a";
        String secondElem = "b";
        String thirdElem = "c";
        String fourthElem = "b";
        String fifthElem = "a";

        list.addToBack(firstElem);
        list.addToBack(secondElem);
        list.addToBack(thirdElem);
        list.addToBack(fourthElem);
        list.addToBack(fifthElem);

        String removedLastB = list.removeLastOccurrence("b");
        assertEquals("b", removedLastB);
        assertSame(fourthElem, removedLastB);
        assertEquals(4, list.size());
    }


    @Test(timeout = TIMEOUT)
    public void testRemoveLastBad() {

        // list is empty so the element cannot be found
        try {
            list.removeLastOccurrence("a");
            fail();
        } catch (NoSuchElementException e) { }

        String firstElem = "a";
        String secondElem = "b";
        String thirdElem = "a";

        list.addToBack(firstElem);
        list.addToBack(secondElem);
        list.addToBack(thirdElem);

        try {
            list.removeLastOccurrence("d");
            fail();
        } catch (NoSuchElementException e) { }

        try {
            list.removeLastOccurrence(null);
            fail();
        } catch (IllegalArgumentException e) { }

    }

    @Test(timeout = TIMEOUT)
    public void testToArray() {

        // list is empty so should produce empty array
        Object[] expectedBeforeAdd = new Object[0];
        assertArrayEquals(expectedBeforeAdd, list.toArray());

        list.addAtIndex(0, "a"); // [a]
        list.addAtIndex(0, "b"); // [b, a]
        list.addAtIndex(1, "c"); // [b, c, a]
        list.addAtIndex(3, "d"); // [b, c, a, d]
        list.addAtIndex(0, "e"); // [e, b, c, a, d]
        list.addAtIndex(2, "f"); // [e, b, f, c, a, d]
        list.addAtIndex(4, "g"); // [e, b, f, c, g, a, d]

        Object[] expected = new Object[7];
        expected[0] = "e";
        expected[1] = "b";
        expected[2] = "f";
        expected[3] = "c";
        expected[4] = "g";
        expected[5] = "a";
        expected[6] = "d";

        assertArrayEquals(expected, list.toArray());
        while (!list.isEmpty()) {
            list.removeFromBack();
        }

        assertArrayEquals(expectedBeforeAdd, list.toArray());
    }

}