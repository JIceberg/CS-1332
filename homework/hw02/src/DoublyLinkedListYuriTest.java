import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

/**
 * I wrote all the test cases I could think of for edge cases and exception tests!
 * @author Yoo Ri Jhang
 * @version 1.0
 */
public class DoublyLinkedListYuriTest {

    private static final int TIMEOUT = 200;
    private DoublyLinkedList<String> list;

    @Before
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    // ADDATINDEX TEST CASES.................................................................................

    @Test(timeout = TIMEOUT)
    public void testAddAtIndexEmpty() { // adding to empty list
        // given empty initialized list
        // when adding first element
        list.addAtIndex(0, "0a");
        // then list is 0a
        assertEquals(1, list.size());   // size = 1

        assertEquals("0a", list.get(0));    // assuming your get works properly
        assertNotNull(list.getHead());  // head != null
        assertNotNull(list.getTail());  // tail != null
        assertSame(list.getHead(), list.getTail());   // head == tail b/c only one element
        assertNull(list.getHead().getPrevious());   // head previous should point to null
        assertNull(list.getHead().getNext());    // head next should point to null
    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndexFront() { // adding to front of list
        // given empty list
        // when filling list by adding element to the front
        for (int i = 2; i >= 0; i--) {
            list.addAtIndex(0, i + "a");
        }
        // then list is 0a 1a 2a
        assertEquals(3, list.size());   // size = 3

        DoublyLinkedListNode<String> cur = list.getHead();  // at head, index 0
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("0a", cur.getData());

        DoublyLinkedListNode<String> prev = cur;    // at index 1
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("1a", cur.getData());

        prev = cur;     // at tail, index 2
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("2a", cur.getData());

        cur = cur.getNext();
        assertNull(cur);
    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndexBack() {  // adding to front of list
        // given empty list
        // when filling list by adding element to the front
        for (int i = 0; i < 3; i++) {
            list.addAtIndex(list.size(), i + "a");
        }
        // then list is 0a 1a 2a
        assertEquals(3, list.size());   // size = 3

        DoublyLinkedListNode<String> cur = list.getHead();  // at head, index 0
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("0a", cur.getData());

        DoublyLinkedListNode<String> prev = cur;    // at index 1
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("1a", cur.getData());

        prev = cur;     // at tail, index 2
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("2a", cur.getData());

        cur = cur.getNext();
        assertNull(cur);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexException1b() {   // IndexOutofBoundsException test
        // given list 0a, 1a, 2a, 3a, 4a
        for (int i = 4; i >= 0; i--) {
            list.addAtIndex(0, i + "a");
        }
        // when index = list.size() + 1 ... this is just current size of list + 1
        list.addAtIndex(list.size() + 1, "NOT POSSIBLE");
        // then IndexOutOfBoundsException should be thrown b/c index > list.size()
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddAtIndexException2() {    // IllegalArgumentException test
        // given list 0a, 1a, 2a, 3a, 4a
        for (int i = 4; i >= 0; i--) {
            list.addAtIndex(0, i + "a");
        }
        // when index is valid and data = null
        list.addAtIndex(0, null);
        // then IllegalArgumentException should be thrown b/c data = null
    }



    // ADDTOFRONT TEST CASES..................................................................................

    @Test(timeout = TIMEOUT)
    public void testAddToFrontEmpty() { // adding to empty list
        // given empty initialized list
        // when filling list with first element
        list.addToFront("0a");
        // then list is 0a
        assertEquals(1, list.size());   // size = 1

        assertEquals("0a", list.get(0));    // assuming your get works properly
        assertNotNull(list.getHead());  // head != null
        assertNotNull(list.getTail());  // tail != null
        assertSame(list.getHead(), list.getTail());   // head == tail b/c only one element
        assertNull(list.getHead().getPrevious());   // head previous should point to null
        assertNull(list.getHead().getNext());    // head next should point to null
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddToFrontException() { // IllegalArgumentException test
        // given list 0a
        list.addToFront("0a");
        // when data = null
        list.addToFront(null);
        // then IllegalArgumentException should be thrown b/c data = null
    }



    // ADDTOBACK TEST CASES..................................................................................

    @Test(timeout = TIMEOUT)
    public void testAddToBackEmpty() { // adding to empty list
        // given empty initialized list
        // when filling list with first element
        list.addToBack("0a");
        // then list is 0a
        assertEquals(1, list.size());   // size = 1

        assertEquals("0a", list.get(0));    // assuming your get works properly
        assertNotNull(list.getHead());  // head != null
        assertNotNull(list.getTail());  // tail != null
        assertSame(list.getHead(), list.getTail());   // head == tail b/c only one element
        assertNull(list.getHead().getPrevious());   // head previous should point to null
        assertNull(list.getHead().getNext());    // head next should point to null
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddToBackException() { // IllegalArgumentException test
        // given list 0a
        list.addToBack("0a");
        // when data = null
        list.addToFront(null);
        // then IllegalArgumentException should be thrown b/c data = null
    }



    //  REMOVEATINDEX TEST CASES............................................................................

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testRemoveAtIndexException1a() {    // cannot remove from empty list
        // given empty list
        // when removing from index 0 of empty list
        list.removeAtIndex(0);
        // then IndexOutOfBoundsException should be thrown b/c you can't remove non-existing elements
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testRemoveAtIndexException1b() { // cannot remove from index < 0
        // given filled list 0a 1a 2a
        for (int i = 0; i < 3; i++) {
            list.addAtIndex(list.size(), i + "a");
        }
        // when removing from index -1
        list.removeAtIndex(-1);
        // then IndexOutOfBoundsException should be thrown b/c you can't remove index < 0
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testRemoveAtIndexException1c() {    // cannot remove from index >= size
        // given filled list 0a 1a 2a
        for (int i = 0; i < 3; i++) {
            list.addAtIndex(list.size(), i + "a");
        }
        // when removing from index list.size() which is index = 3
        list.removeAtIndex(3);
        // then IndexOutOfBoundsException should be thrown b/c you can't remove index >= list.size()
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndexBecomesEmpty() {    // list becomes empty after removing
        // given filled list 0a
        list.addToFront("0a");
        // when removing from 0 index
        list.removeAtIndex(0);
        // then list becomes empty... head and tail must both become null
        assertEquals(0, list.size());
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertSame(list.getHead(), list.getTail());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndexBecomesOneElement() {    // list has only one element after removing
        // given filled list 0a 1a
        list.addToBack("0a");
        list.addToBack("1a");
        // when removing from 0 index
        list.removeAtIndex(0);
        // then list has only element.... head = tail
        assertEquals(1, list.size());
        assertNotNull(list.getHead());
        assertNotNull(list.getTail());
        assertSame(list.getHead(), list.getTail());
        assertEquals("1a", list.get(0));
    }



    // REMOVEFROMFRONT TEST CASES..........................................................................

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveFromFrontException() {    // list is empty
        // given empty list
        // when removing from index 0 of empty list
        list.removeFromFront();
        // then NoSuchElementException should be thrown b/c you can't remove non-existing elements
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromFrontBecomesEmpty() {
        // given filled list 0a
        list.addToFront("0a");
        // when removing from 0 index
        list.removeFromFront();
        // then list becomes empty... head and tail must both become null
        assertEquals(0, list.size());
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertSame(list.getHead(), list.getTail());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromFrontBecomesOneElement() {
        // given filled list 0a 1a
        list.addToBack("0a");
        list.addToBack("1a");
        // when removing from 0 index
        list.removeFromFront();
        // then list only has one element... head and tail must both be the same and not null
        assertEquals(1, list.size());
        assertNotNull(list.getHead());
        assertNotNull(list.getTail());
        assertSame(list.getHead(), list.getTail());
        assertEquals("1a", list.get(0));
    }



    // REMOVEFROMBACK TEST CASES............................................................................

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveFromBackException() {    // list is empty
        // given empty list
        // when removing from index 0 of empty list
        list.removeFromBack();
        // then NoSuchElementException should be thrown b/c you can't remove non-existing elements
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromBackBecomesEmpty() {
        // given filled list 0a
        list.addToFront("0a");
        // when removing from 0 index
        list.removeFromBack();
        // then list becomes empty... head and tail must both become null
        assertEquals(0, list.size());
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertSame(list.getHead(), list.getTail());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromBackBecomesOneElement() {
        // given filled list 0a 1a
        list.addToBack("0a");
        list.addToBack("1a");
        // when removing from list.size() = 1 index
        list.removeFromBack();
        // then list only has one element... head and tail must be the same and not null
        assertEquals(1, list.size());
        assertNotNull(list.getHead());
        assertNotNull(list.getTail());
        assertSame(list.getHead(), list.getTail());
        assertEquals("0a", list.get(0));
    }



    // REMOVELASTOCCURENCE TEST CASES.......................................................................

    @Test(timeout = TIMEOUT)
    public void testRemoveAtLastOccurrenceEquals() {  // MUST USE .equals() IN THE METHOD IN YOUR CODE!!!!
        // given filled list 0a 1a 2a and data to be removed
        String temp = new String("1a");
        list.addToBack("0a");
        list.addToBack(temp);
        list.addToBack("2a");
        // when tail data is the last occurrence
        assertSame(temp, list.removeLastOccurrence(new String("1a")));
        // then list becomes 0a 1a, tail must be adjusted
        assertEquals(2, list.size());

        assertNotNull(list.getHead());  // head
        assertNull(list.getHead().getPrevious());
        assertEquals("0a", list.getHead().getData());

        assertNotNull(list.getTail()); // tail
        assertNull(list.getTail().getNext());
        assertSame(list.getHead(), list.getTail().getPrevious());
        assertEquals("2a", list.getTail().getData());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtLastOccurrenceTail() {  // tail data is last occurrence
        // given filled list 0a 1a 1a and data to be removed
        String temp = "1a";
        list.addToBack("0a");
        list.addToBack("1a");
        list.addToBack("1a");
        // when tail data is the last occurrence
        assertSame(temp, list.removeLastOccurrence("1a"));
        // then list becomes 0a 1a, tail must be adjusted
        assertEquals(2, list.size());

        assertNotNull(list.getHead());  // head
        assertNull(list.getHead().getPrevious());
        assertEquals("0a", list.getHead().getData());

        assertNotNull(list.getTail()); // tail
        assertNull(list.getTail().getNext());
        assertSame(list.getHead(), list.getTail().getPrevious());
        assertEquals("1a", list.getTail().getData());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtLastOccurrenceHead() { // head data is last occurrence
        // given filled list 0a 1a 1a and data to be removed
        String temp = "0a";
        list.addToBack("0a");
        list.addToBack("1a");
        list.addToBack("1a");
        // when tail data is the last occurrence
        assertSame(temp, list.removeLastOccurrence("0a"));
        // then list becomes 1a 1a, head must be adjusted
        assertEquals(2, list.size());

        assertNotNull(list.getHead());  // head
        assertNull(list.getHead().getPrevious());
        assertEquals("1a", list.getHead().getData());

        assertNotNull(list.getTail()); // tail
        assertNull(list.getTail().getNext());
        assertSame(list.getHead(), list.getTail().getPrevious());
        assertEquals("1a", list.getTail().getData());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtLastOccurrenceBecomeOneTail() {  // list becomes one element after removing from tail
        // given filled list 0a 1a 1a and data to be removed
        String temp = "1a";
        list.addToBack("0a");
        list.addToBack("1a");
        // when tail data is the last occurrence
        assertSame(temp, list.removeLastOccurrence("1a"));
        // then list becomes 0a 1a, tail must equal head
        assertEquals(1, list.size());
        assertNotNull(list.getHead());
        assertNotNull(list.getTail());
        assertSame(list.getHead(), list.getTail());
        assertEquals("0a", list.get(0));
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtLastOccurrenceBecomeOneHead() {  // list becomes one element after removing from head
        // given filled list 0a 1a 1a and data to be removed
        String temp = "0a";
        list.addToBack("0a");
        list.addToBack("1a");
        // when tail data is the last occurrence
        assertSame(temp, list.removeLastOccurrence("0a"));
        // then list becomes 0a 1a, tail must equal head
        assertEquals(1, list.size());
        assertNotNull(list.getHead());
        assertNotNull(list.getTail());
        assertSame(list.getHead(), list.getTail());
        assertEquals("1a", list.get(0));
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtLastOccurrenceBecomesEmpty() {  // list becomes empty after removal
        // given filled list 0a and data to be removed
        String temp = "0a";
        list.addToBack("0a");
        // when tail data is the last occurrence
        assertSame(temp, list.removeLastOccurrence("0a"));
        // then list becomes 0a 1a, head and tail must both be null
        assertEquals(0, list.size());
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertSame(list.getHead(), list.getTail());
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testRemoveAtLastOccurrenceException1() {    // data = null, IllegalArgumentException should be thrown
        // given filled list 0a 1a
        list.addToBack("0a");
        list.addToBack("1a");
        // when data = null
        list.removeLastOccurrence(null);
        // then IllegalArgumentException is thrown because null data doesn't occur anywhere and cannot be removed
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveAtLastOccurrenceException2() {
        // no occurrence of data, NoSuchElementException should be thrown
        // given filled list 0a 1a
        list.addToBack("0a");
        list.addToBack("1a");
        // when data = null
        list.removeLastOccurrence("NOT IN LIST");
        // then IllegalArgumentException is thrown because null data doesn't occur anywhere and cannot be removed
    }



    // GET TEST CASES.......................................................................................

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testGetException1a() {  // index < 0, IndexOutOfBoundsException should be thrown
        // given filled list 0a 1a
        list.addToBack("0a");
        list.addToBack("1a");
        // when index = -1
        list.get(-1);
        // then IndexOutOfBoundsException is thrown index = -1 < 0
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testGetException1b() {  // index >= 0, IndexOutOfBoundsException should be thrown
        // given filled list 0a 1a
        list.addToBack("0a");
        list.addToBack("1a");
        // when index = list.size() = 2
        list.get(2);
        // then IndexOutOfBoundsException is thrown index = 2 >= list.size()
    }
}