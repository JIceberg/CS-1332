import org.junit.Test;
import org.junit.Before;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Yoo Ri Jhang
 * @version 1.0
 */
public class DequeTestYuri {

    private static final int TIMEOUT = 200;
    private ArrayDeque<String> array;
    private LinkedDeque<String> linked;

    @Before
    public void setup() {
        array = new ArrayDeque<>();
        linked = new LinkedDeque<>();
    }



    //.......................................ARRAY DEQUE TESTS.....................................................
    //ADDFIRST TESTS...................................................
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void addFirstArrayException() {   // should throw IllegalArgumentException
        array.addFirst(null);
    }

    @Test(timeout = TIMEOUT)
    public void addFirstArraySingleElement() {  // front index needs to be set to the end = 10
        array.addFirst("0a");   // _, _, _, _, _, _, _, _, _, _, 0a

        assertEquals(1, array.size());
        String[] expected = new String[ArrayDeque.INITIAL_CAPACITY];
        for (int i = 0; i < 10; i++) {
            expected[i] = null;
        }
        expected[10] = "0a";
        assertArrayEquals(expected, array.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void addFirstArrayWrapAround() {  // EDGE CASE: front = 0 so you must use mod() to wrap around
        for (int i = 11; i >= 1; i--) {
            array.addFirst(i + "a");   // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a, 10a, 11a
        }
        array.removeLast(); // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a, 10a, _ (front is still 0 but need to add at the last index)
        array.addFirst("0a");   // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a, 10a, 0a

        assertEquals(11, array.size());
        String[] expected = new String[ArrayDeque.INITIAL_CAPACITY];
        for (int i = 0; i < 11; i++) {
            expected[i] = (i + 1) % 11 + "a";
        }
        assertArrayEquals(expected, array.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void addFirstArrayFullCap() { // EDGE CASE: full capacity means new array of double initial cap size
        for (int i = 23; i >= 0; i--) {
            array.addFirst(i + "a");   // 0a, 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a, 10a, ..., 23a, ..., _
        }
        assertEquals(24, array.size());
        String[] expected = new String[44];
        for (int i = 0; i < 24; i++) {
            expected[(i + 43) % 44] = i + "a";
        }
        assertArrayEquals(expected, array.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void addFirstArrayFrontDifferent() { //
        array.addLast("0a");
        array.addLast("1a");    // 0a, 1a, _, _, _, _, _, _, _, _, _
        array.removeFirst();    // _, 1a, _, _, _, _, _, _, _, _, _

        array.addFirst("2a");   // 2a, 1a, _, _, _, _, _, _, _, _, _


        assertEquals(2, array.size());
        String[] expected = new String[11];
        expected[0] =  "2a";
        expected[1] = "1a";
        assertArrayEquals(expected, array.getBackingArray());
    }

    //ADDLAST TESTS...................................................
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void addLastArrayExceptionTest() {   // should throw IllegalArgumentException
        array.addLast(null);
    }

    @Test(timeout = TIMEOUT)
    public void addLastArraySingleElementTest() {  // front index needs to be 0
        array.addLast("0a");   // 0a, _, _, _, _, _, _, _, _, _, -

        assertEquals(1, array.size());
        String[] expected = new String[ArrayDeque.INITIAL_CAPACITY];
        expected[0] = "0a";
        for (int i = 1; i < 11; i++) {
            expected[i] = null;
        }
        assertArrayEquals(expected, array.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void addLastArrayWrapAround() {  // EDGE CASE: front = 1 (index 0 empty) so wrap around from back
        for (int i = 0; i < 11; i++) {
            array.addLast(i + "a");   // 0a, 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a, 10a
        }
        array.removeFirst();    // _, 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a, 10a ... front is now 1
        array.addLast("11a");   // 11a, 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a, 10a

        assertEquals(11, array.size());
        String[] expected = new String[ArrayDeque.INITIAL_CAPACITY];
        expected[0] = "11a";
        for (int i = 1; i < 11; i++) {
            expected[i] = i + "a";
        }
        assertArrayEquals(expected, array.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void addLastArrayFullCap() { // EDGE CASE: full capacity means new array of double initial cap size
        for (int i = 0; i < 24; i++) {
            array.addLast(i + "a");   // 0a, 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a, 10a, 11a, ..., 23a, ..., _
        }

        assertEquals(24, array.size());
        String[] expected = new String[44];
        for (int i = 0; i < 24; i++) {
            expected[i] = i + "a";
        }
        assertArrayEquals(expected, array.getBackingArray());
    }

    //REMOVEFIRST TESTS...................................................
    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void removeFirstArrayException() {
        array.removeFirst();
    }

    @Test(timeout = TIMEOUT)
    public void removeFirstArrayWrapAround() {   // EDGE CASE: removing both elements requires wrap around to 0 index
        array.addLast("0a");    // 0a, _, _, _, _, _, _, _, _, _, _
        array.addFirst("1a");   // 0a, _, _, _, _, _, _, _, _, _, 1a ... 1a is the front!!!

        array.removeFirst();    // 0a, _, _, _, _, _, _, _, _, _, _
        assertEquals(1, array.size());
        String[] expected = new String[11];
        expected[0] = "0a";
        assertArrayEquals(expected, array.getBackingArray());


        array.removeFirst();    // _, _, _, _, _, _, _, _, _, _, _
        assertEquals(0, array.size());
        expected = new String[11];
        assertArrayEquals(expected, array.getBackingArray());
    }

    //REMOVELAST TESTS...................................................
    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void removeLastArrayException() {
        array.removeLast();
    }

    @Test(timeout = TIMEOUT)
    public void removeLastArrayWrapAround() {    // EDGE CASE: removing both elements requires wrapping to last index
        array.addLast("0a");    // 0a, _, _, _, _, _, _, _, _, _, _
        array.addFirst("1a");   // 0a, _, _, _, _, _, _, _, _, _, 1a

        array.removeLast();    // _, _, _, _, _, _, _, _, _, _, 1a
        assertEquals(1, array.size());
        String[] expected = new String[11];
        expected[10] = "1a";
        assertArrayEquals(expected, array.getBackingArray());

        array.removeLast();    // _, _, _, _, _, _, _, _, _, _, _
        assertEquals(0, array.size());
        expected = new String[11];
        assertArrayEquals(expected, array.getBackingArray());
    }

    //GETFIRST TEST...................................................
    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void getFirstArrayException() {   // should throw NoSuchElementException
        array.getFirst();
    }

    //GETLAST TEST...................................................
    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void getLastArrayException() {    // should throw NoSuchElementException
        array.getLast();
    }



    //.......................................LINKED DEQUE TESTS.....................................................
    //ADDFIRST TESTS...................................................
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class) // should throw IllegalArgumentException
    public void addFirstLinkedException() {
        linked.addFirst(null);
    }

    @Test(timeout = TIMEOUT)
    public void addFirstLinkedSingleElement() { // head and tail should both be new element
        linked.addFirst("0a");
    }

    //ADDLAST TESTS...................................................
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class) // should throw IllegalArgumentException
    public void addLastLinkedException() {
        linked.addLast(null);
    }

    @Test(timeout = TIMEOUT)
    public void addLastLinkedSingleElement() { // head and tail should both be new element
        linked.addLast("0a");
    }

    //REMOVEFIRST TESTS...................................................
    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class) // should throw NoSuchElementException
    public void removeFirstLinkedException() {
        linked.removeFirst();
    }

    @Test(timeout = TIMEOUT)
    public void removeFirstLinkedBecomesEmpty() { // head and tail should both be null
        linked.addLast("0a");   // 0a

        assertEquals("0a", linked.removeFirst());   // _ EMPTY
        assertEquals(0, linked.size());
        assertNull(linked.getHead());
        assertNull(linked.getTail());
    }

    @Test(timeout = TIMEOUT)
    public void removeFirstLinkedBecomesOne() { // head and tail should both be the remaining element
        linked.addFirst("1a");
        linked.addFirst("0a");  // 0a 1a

        assertEquals("0a", linked.removeFirst());   // 1a
        assertEquals(1, linked.size());
        assertEquals("1a", linked.getHead().getData());
        assertEquals(linked.getHead(), linked.getTail());
        assertNull(linked.getHead().getPrevious());
        assertNull(linked.getHead().getNext());
    }

    //REMOVELAST TESTS...................................................
    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class) // should throw NoSuchElementException
    public void removeLastLinkedException() {
        linked.removeLast();
    }

    @Test(timeout = TIMEOUT)
    public void removeLastLinkedBecomesEmpty() { // head and tail should both be null
        linked.addLast("0a");   // 0a

        assertEquals("0a", linked.removeLast());    // _ EMPTY
        assertEquals(0, linked.size());
        assertNull(linked.getHead());
        assertNull(linked.getTail());
    }

    @Test(timeout = TIMEOUT)
    public void removeLastLinkedBecomesOne() { // head and tail should both be the remaining element
        linked.addFirst("1a");
        linked.addFirst("0a");  // 0a 1a

        assertEquals("1a", linked.removeLast());    // 0a
        assertEquals(1, linked.size());
        assertEquals("0a", linked.getHead().getData());
        assertEquals(linked.getHead(), linked.getTail());
        assertNull(linked.getHead().getPrevious());
        assertNull(linked.getHead().getNext());
    }

    //GETFIRST TESTS...................................................
    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class) // should throw NoSuchElementException
    public void getFirstLinkedException() {
        linked.getFirst();
    }

    @Test(timeout = TIMEOUT) // should throw NoSuchElementException
    public void getFirstLinkedTest() {
        linked.addFirst("2a");
        linked.addFirst("3a");
        linked.addLast("4a");
        linked.addFirst("1a");
        linked.addFirst("0a");

        assertEquals("0a", linked.getFirst());
        assertEquals(5, linked.size());
    }

    //GETLAST TESTS...................................................
    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class) // should throw NoSuchElementException
    public void getLastLinkedException() {
        linked.getLast();
    }

    @Test(timeout = TIMEOUT) // should throw NoSuchElementException
    public void getLastLinkedTest() {
        linked.addFirst("2a");
        linked.addFirst("3a");
        linked.addLast("4a");
        linked.addFirst("1a");
        linked.addFirst("0a");

        assertEquals("4a", linked.getLast());
        assertEquals(5, linked.size());
    }
}