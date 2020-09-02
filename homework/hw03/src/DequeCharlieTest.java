import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

/**
 * @author Charlie Jenkins cjenkins72@gatech.edu
 * @version 1.0
 */
public class DequeCharlieTest {
    private static final int TIMEOUT = 200;
    private ArrayDeque<String> array;
    private LinkedDeque<String> linked;

    @Before
    public void setup() {
        array = new ArrayDeque<>();
        linked = new LinkedDeque<>();
    }

    //Array Tests
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void addFirstArrayNull() {
        array.addFirst(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void addLastArrayNull() {
        array.addLast(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void removeFirstWhenEmpty() {
        array.removeFirst();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void removeLastWhenEmpty() {
        array.removeLast();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void getFirstWhenEmpty() {
        array.getFirst();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void getLastWhenEmpty() {
        array.getLast();
    }

    @Test(timeout = TIMEOUT)
    public void addFirstArray() {
        array.addFirst("1a");
        array.addFirst("0a");
        String[] testArray = new String[11];
        testArray[9] = "0a";
        testArray[10] = "1a";
        assertEquals(2, array.size());
        assertArrayEquals(testArray, array.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void addFirstArrayResize() {
        String[] testArray = new String[]{"1a", "2a", "3a", "4a", "5a", "6a", "7a", "8a", "9a", "10a", "11a", "12a", null, null, null, null, null, null, null, null, null, "0a"};
        for (int i = 12; i >= 0; i--) {
            array.addFirst(i + "a");
        }
        assertEquals(13, array.size());
        assertEquals(22, ((Object[]) array.getBackingArray()).length);
        assertArrayEquals(testArray, array.getBackingArray());
    }

    @Test()
    public void addLastArrayResize() {
        String[] testArray = new String[]{"0a", "1a", "2a", "3a", "4a", "5a", "6a", "7a", "8a", "9a", "10a", "11a", "12a", null, null, null, null, null, null, null, null, null};
        for (int i = 0; i < 13; i++) {
            array.addLast(i + "a");
        }
        assertEquals(13, array.size());
        assertEquals(22, ((Object[]) array.getBackingArray()).length);
        assertArrayEquals(testArray, array.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void addFirstArrayResizeTwice() {
        for (int i = 24; i >= 0; i--) {
            array.addFirst(i + "a");
        }
        assertEquals(25, array.size());
        assertEquals(44, ((Object[]) array.getBackingArray()).length);
    }

    @Test(timeout = TIMEOUT)
    public void manipulateAfterEmptyList() {
        array.addFirst("0a");
        array.removeLast();
        array.addFirst("0a"); //Put at index 9
        array.addLast("1a"); //Put at index 8
        array.addFirst("-1a"); //Put at index 10
        String[] testArray = new String[11];
        testArray[8] = "-1a";
        testArray[9] = "0a";
        testArray[10] = "1a";
        assertArrayEquals(testArray, array.getBackingArray());
        assertEquals("1a", array.getLast());
        assertEquals("-1a", array.getFirst());
    }

    @Test(timeout = TIMEOUT)
    public void manipulateAfterEmptyListLast() {
        array.addLast("0a");
        array.removeFirst(); //Leave hole at index 0, front is at index 1
        array.addLast("0a"); //Put at index 1
        array.addFirst("1a"); //Put at index 0
        array.addLast("-1a"); //Put at index 2
        String[] testArray = new String[11];
        testArray[0] = "1a";
        testArray[1] = "0a";
        testArray[2] = "-1a";
        assertArrayEquals(testArray, array.getBackingArray());
        assertEquals("-1a", array.getLast());
        assertEquals("1a", array.getFirst());
    }


    //Linked List Tests
    @Test(timeout = TIMEOUT)
    public void addFirstMultiple() {
        linked.addFirst("2a");
        linked.addFirst("1a");
        linked.addFirst("0a");
        LinkedNode<String> head = linked.getHead();
        assertNull(head.getPrevious());
        assertEquals("0a", head.getData());
        assertEquals("1a", head.getNext().getData());
        assertEquals("2a", head.getNext().getNext().getData());
        assertEquals(3, linked.size());
        assertSame(head.getNext().getNext(), linked.getTail());
        assertNull(head.getNext().getNext().getNext());
    }

    @Test(timeout = TIMEOUT)
    public void addLastMultiple() {
        linked.addLast("0a");
        linked.addLast("1a");
        linked.addLast("2a");
        LinkedNode<String> tail = linked.getTail();
        assertNull(tail.getNext());
        assertEquals("2a", tail.getData());
        assertEquals("1a", tail.getPrevious().getData());
        assertEquals("0a", tail.getPrevious().getPrevious().getData());
        assertEquals(3, linked.size());
        assertSame(tail.getPrevious().getPrevious(), linked.getHead());
        assertNull(tail.getPrevious().getPrevious().getPrevious());
    }

    @Test(timeout = TIMEOUT)
    public void removeFirst() {
        linked.addLast("0a");
        linked.addLast("1a");
        assertEquals("1a", linked.removeLast());
        assertEquals(1, linked.size());
        assertEquals("0a", linked.getTail().getData());
    }

    @Test(timeout = TIMEOUT)
    public void removeLast() {
        linked.addFirst("1a");
        linked.addFirst("0a");
        assertEquals("0a", linked.removeFirst());
        assertEquals(1, linked.size());
        assertEquals("1a", linked.getHead().getData());
    }

    @Test(timeout = TIMEOUT)
    public void removeFirstToEmpty() {
        linked.addLast("0a");
        assertEquals("0a", linked.removeLast());
        assertEquals(0, linked.size());
        assertNull(linked.getTail());
    }

    @Test(timeout = TIMEOUT)
    public void removeLastToEmpty() {
        linked.addFirst("1a");
        assertEquals("1a", linked.removeFirst());
        assertEquals(0, linked.size());
        assertNull(linked.getHead());
    }

    @Test(timeout = TIMEOUT)
    public void addLast() {
        linked.addLast("1a");
        assertEquals("1a", linked.getHead().getData());
        assertEquals("1a", linked.getTail().getData());
        assertEquals(1, linked.size());
        assertSame(linked.getHead(), linked.getTail());
    }

    @Test(timeout = TIMEOUT)
    public void addFirst() {
        linked.addFirst("1a");
        assertEquals("1a", linked.getHead().getData());
        assertEquals("1a", linked.getTail().getData());
        assertEquals(1, linked.size());
        assertSame(linked.getHead(), linked.getTail());
    }

    @Test(timeout = TIMEOUT)
    public void getFirst() {
        linked.addFirst("3a");
        linked.addFirst("2a");
        linked.addFirst("1a");
        linked.addFirst("0a");
        assertEquals("0a", linked.getFirst());
    }

    @Test(timeout = TIMEOUT)
    public void getLast() {
        linked.addLast("0a");
        linked.addLast("1a");
        linked.addLast("2a");
        linked.addLast("3a");
        assertEquals("3a", linked.getLast());
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void addFirstNull() {
        linked.addFirst(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void addLastNull() {
        linked.addLast(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void removeFirstNull() {
        linked.removeFirst();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void removeLastNull() {
        linked.removeLast();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void getFirstNull() {
        linked.getFirst();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void getLastNull() {
        linked.getLast();
    }
}