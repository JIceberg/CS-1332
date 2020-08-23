import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

/**
 * All I could think of.
 * (Credit to 1332 TAs original tests for my copy/pasted test bodies)
 *
 * @author Justin Hinckley
 * @version 2.0
 */
public class DoublyLinkedListJustinTest {

    private static final int TIMEOUT = 200;
    private DoublyLinkedList<String> list;

    @Before
    public void setUp() {
        list = new DoublyLinkedList<>();
    }


    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, list.size());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    // addatindex size 0
    @Test(timeout = TIMEOUT)
    public void testAddAtIndexSize0() {
        list.addAtIndex(0, "0a");

        assertEquals(1, list.size());

        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        DoublyLinkedListNode<String> taill = list.getTail();
        assertNotNull(taill);
        assertSame(cur, taill);
        assertNull(cur.getPrevious());
        assertNull(cur.getNext());
        assertEquals("0a", cur.getData());
    }

    // addatindex 0
    @Test(timeout = TIMEOUT)
    public void testAddAtIndexAt0() {
        list.addToFront("1a");
        list.addAtIndex(0, "0a");

        assertEquals(2, list.size());

        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        DoublyLinkedListNode<String> taill = list.getTail();
        assertNotNull(taill);

        assertNull(cur.getPrevious());
        assertNull(taill.getNext());
        assertSame(cur.getNext(), taill);
        assertSame(taill.getPrevious(), cur);
        assertEquals("0a", cur.getData());
        assertEquals("1a", taill.getData());
    }

    // atatindex size
    @Test(timeout = TIMEOUT)
    public void testAddAtIndexAtSize() {
        list.addToFront("1a");
        list.addToFront("0a");
        list.addAtIndex(2, "2a");

        assertEquals(3, list.size());

        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        DoublyLinkedListNode<String> taill = list.getTail();
        assertNotNull(taill);

        assertNull(cur.getPrevious());
        assertNull(taill.getNext());

        assertSame(taill.getPrevious(), cur.getNext());
        assertSame(cur.getNext().getNext(), taill);
        assertSame(taill.getPrevious().getPrevious(), cur);
        assertEquals("0a", cur.getData());
        assertEquals("1a", cur.getNext().getData());
        assertEquals("2a", taill.getData());
    }

    // remove size 1
    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndexSize1() {
        String temp = "0a";

        list.addToFront(temp);
        assertEquals(1, list.size());

        assertSame(temp, list.removeAtIndex(0));
        assertEquals(0, list.size());

        DoublyLinkedListNode<String> cur = list.getHead();
        DoublyLinkedListNode<String> tail = list.getTail();

        assertNull(cur);
        assertNull(tail);
    }

    // rem 0
    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndex0() {
        String temp = "0a";

        list.addToFront("2a");
        list.addToFront("1a");
        list.addToFront(temp);
        assertEquals(3, list.size());

        assertSame(temp, list.removeAtIndex(0));
        assertEquals(2, list.size());

        DoublyLinkedListNode<String> cur = list.getHead();
        DoublyLinkedListNode<String> tail = list.getTail();

        assertSame(cur.getNext(), tail);
        assertSame(tail.getPrevious(), cur);
        assertNotNull(cur);
        assertNotNull(tail);
        assertNull(cur.getPrevious());
        assertNull(tail.getNext());
        assertEquals("1a", cur.getData());
        assertEquals("2a", tail.getData());
    }

    // rem size
    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndexSize() {
        String temp = "2a";

        list.addToFront(temp);
        list.addToFront("1a");
        list.addToFront("0a");
        assertEquals(3, list.size());

        assertSame(temp, list.removeAtIndex(2));
        assertEquals(2, list.size());

        DoublyLinkedListNode<String> cur = list.getHead();
        DoublyLinkedListNode<String> tail = list.getTail();

        assertSame(cur.getNext(), tail);
        assertSame(tail.getPrevious(), cur);
        assertNotNull(cur);
        assertNotNull(tail);
        assertNull(cur.getPrevious());
        assertNull(tail.getNext());
        assertEquals("0a", cur.getData());
        assertEquals("1a", tail.getData());
    }

    // add 1000 elems to front
    @Test(timeout = TIMEOUT)
    public void testAddToFront1000Elems() {
        for (int i = 999; i >= 0; --i) {
            list.addToFront(i + "a");
        }

        assertEquals(1000, list.size());

        String[] expected = new String[1000];
        for (int i = 999; i >= 0; --i) {
            expected[i] = i + "a";
        }
        DoublyLinkedListNode<String> prev = null;
        DoublyLinkedListNode<String> cur = list.getHead();

        for (int i = 0; i < expected.length; ++i) {
            String x = expected[i];

            assertNotNull(cur);
            assertSame(prev, cur.getPrevious());
            assertEquals(x, cur.getData());

            if (i == expected.length - 1) {
                assertSame(list.getTail(), cur);
            }

            prev = cur;
            cur = cur.getNext();
        }
        assertNull(cur);
    }

    // last occurence when multiple data's exist in list
    @Test(timeout = TIMEOUT)
    public void testLastOccurrenceWithMultiples() {
        String temp = "2a";

        list.addAtIndex(0, "0a"); // 0a
        list.addAtIndex(1, "2a"); // 0a, 1a
        list.addAtIndex(2, "1a"); // 0a, 1a, 2a
        list.addAtIndex(3, temp); // 0a, 1a, 2a, 2a
        list.addAtIndex(4, "3a"); // 0a, 1a, 2a, 2a, 3a
        list.addAtIndex(5, "4a"); // 0a, 1a, 2a, 2a, 3a, 4a
        assertEquals(6, list.size());

        assertSame(temp, list.removeLastOccurrence("2a")); // 0a, 1a, 2a, 3a, 4a
        assertEquals(5, list.size());

        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("0a", cur.getData());

        DoublyLinkedListNode<String> prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("2a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("1a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("3a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("4a", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);
    }

    // last occurrence when data doesn't exist in list
    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testLastOccurrenceWhenNotExist() {
        list.addAtIndex(0, "0a"); // 0a
        list.addAtIndex(1, "1a"); // 0a, 1a
        list.addAtIndex(2, "1a"); // 0a, 1a, 2a
        list.addAtIndex(3, "3a"); // 0a, 1a, 2a, 2a
        list.addAtIndex(4, "3a"); // 0a, 1a, 2a, 2a, 3a
        list.addAtIndex(5, "4a"); // 0a, 1a, 2a, 2a, 3a, 4a
        assertEquals(6, list.size());

        list.removeLastOccurrence("2a"); // 0a, 1a, 2a, 3a, 4a
    }

    // checks whether last occurrence returns the parameter or actual node data
    @Test(timeout = TIMEOUT)
    public void testLastOccurrenceReturnValue() {
        list.addAtIndex(0, "0a"); // 0a
        list.addAtIndex(1, new String("2a")); // 0a, 1a
        list.addAtIndex(2, "1a"); // 0a, 1a, 2a
        String temp = new String("2a");
        list.addAtIndex(3, temp); // 0a, 1a, 2a, 2a
        list.addAtIndex(4, "3a"); // 0a, 1a, 2a, 2a, 3a
        list.addAtIndex(5, "4a"); // 0a, 1a, 2a, 2a, 3a, 4a
        assertEquals(6, list.size());

        assertSame(temp, list.removeLastOccurrence(new String("2a"))); // 0a, 1a, 2a, 3a, 4a
        // If you're here from an AssertionError, look at your return.
        // *HINT* If you're wondering why the TAs test worked for you, Java 'bundles' identical
        // String's together into same memory location so you have to manually create
        // new String() to get a different memory location.
        assertEquals(5, list.size());

        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("0a", cur.getData());

        DoublyLinkedListNode<String> prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("2a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("1a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("3a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("4a", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);
    }

    // giving bad high index to addatindex
    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexBadHighIndex() {
        list.addAtIndex(0, "2a"); // 2a
        list.addAtIndex(0, "1a"); // 1a, 2a
        list.addAtIndex(2, "4a"); // 1a, 2a, 4a
        list.addAtIndex(2, "3a"); // 1a, 2a, 3a, 4a
        list.addAtIndex(0, "0a"); // 0a, 1a, 2a, 3a, 4a
        list.addAtIndex(6, "doesntmatteryoullneverseemehopefully");
    }

    // giving bad low index to addatindex
    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexBadLowIndex() {
        list.addAtIndex(0, "2a"); // 2a
        list.addAtIndex(0, "1a"); // 1a, 2a
        list.addAtIndex(2, "4a"); // 1a, 2a, 4a
        list.addAtIndex(2, "3a"); // 1a, 2a, 3a, 4a
        list.addAtIndex(0, "0a"); // 0a, 1a, 2a, 3a, 4a
        list.addAtIndex(-1, "doesntmatteryoullneverseemehopefully");
    }

    // giving bad high index to removeatindex
    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testRemoveAtIndexBadHigh() {
        String temp = "2a";

        list.addAtIndex(0, "0a"); // 0a
        list.addAtIndex(1, "1a"); // 0a, 1a
        list.addAtIndex(2, temp); // 0a, 1a, 2a
        list.addAtIndex(3, "3a"); // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a"); // 0a, 1a, 2a, 3a, 4a
        list.addAtIndex(5, "5a"); // 0a, 1a, 2a, 3a, 4a, 5a
        list.removeAtIndex(6);
    }

    // giving bad low index to removeatindex
    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testRemoveAtIndexBadLow() {
        String temp = "2a";

        list.addAtIndex(0, "0a"); // 0a
        list.addAtIndex(1, "1a"); // 0a, 1a
        list.addAtIndex(2, temp); // 0a, 1a, 2a
        list.addAtIndex(3, "3a"); // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a"); // 0a, 1a, 2a, 3a, 4a
        list.addAtIndex(5, "5a"); // 0a, 1a, 2a, 3a, 4a, 5a
        list.removeAtIndex(-1);
    }

    // giving bad high index to get
    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testGetBadHigh() {
        list.addAtIndex(0, "0a"); // 0a
        list.addAtIndex(1, "1a"); // 0a, 1a
        list.addAtIndex(2, "2a"); // 0a, 1a, 2a
        list.addAtIndex(3, "3a"); // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a"); // 0a, 1a, 2a, 3a, 4a

        assertEquals("0a", list.get(5));
    }

    // giving bad low index to get
    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testGetBadLow() {
        list.addAtIndex(0, "0a"); // 0a
        list.addAtIndex(1, "1a"); // 0a, 1a
        list.addAtIndex(2, "2a"); // 0a, 1a, 2a
        list.addAtIndex(3, "3a"); // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a"); // 0a, 1a, 2a, 3a, 4a

        assertEquals("0a", list.get(-1));
    }

    // giving null to addatindex
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddAtIndexNull() {
        list.addAtIndex(0, null); // 0a, 1a, 2a, 3a, 4a
    }

    // giving null to addtofront
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddToFrontNull() {
        list.addToFront(null); // 0a, 1a, 2a, 3a, 4a
    }

    // giving null to addtoback
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddToBackNull() {
        list.addToBack(null); // 0a, 1a, 2a, 3a, 4a
    }

    // giving null to removelastoccurence
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testLastOccurrenceNull() {
        list.addToFront("0a"); // 0a
        list.removeLastOccurrence(null); // 0a, 1a, 2a, 3a, 4a
    }

    // removeatindex when empty
    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testRemoveAtIndexWhenEmpty() {
        list.addToFront("0a"); // 0a
        assertEquals(1, list.size());
        list.removeFromFront();

        list.removeAtIndex(0); // 0a, 1a, 3a, 4a, 5a
    }

    // removefromfront when empty
    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveFromFrontWhenEmpty() {
        list.addToFront("0a"); // 0a
        assertEquals(1, list.size());
        list.removeFromFront();

        list.removeFromFront(); // 0a, 1a, 3a, 4a, 5a
    }

    // removefromback when empty
    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveFromBackWhenEmpty() {
        list.addToFront("0a"); // 0a
        assertEquals(1, list.size());
        list.removeFromFront();

        list.removeFromBack(); // 0a, 1a, 3a, 4a, 5a
    }
}