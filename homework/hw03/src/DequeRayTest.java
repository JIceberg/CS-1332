import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * JUnit tests for Homework 3: Deque focusing on edge cases that are not covered
 * in tests provided by TAs.
 *
 * @author Ray
 * @version 1.0
 */

public class DequeRayTest {

    private static final int TIMEOUT = 200;
    private ArrayDeque<String> array;
    private LinkedDeque<String> linked;

    @Before
    public void setup() {
        array = new ArrayDeque<>();
        linked = new LinkedDeque<>();
    }

    @Test(timeout = TIMEOUT)
    public void testArrayDequeAddLastResize() {
        for (int i = 0; i < array.INITIAL_CAPACITY; ++i) {
            array.addLast(i + "a");
        }
        // 0a, 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a, 10a
        //front                                    last
        assertEquals(array.INITIAL_CAPACITY, array.size());

        String[] expected = new String[ArrayDeque.INITIAL_CAPACITY];
        for (int i = 0; i < array.INITIAL_CAPACITY; ++i) {
            expected[i] = i + "a";
        }
        assertArrayEquals(expected, array.getBackingArray());
        assertEquals("0a", array.getFirst());
        assertEquals("10a", array.getLast());

        array.addLast("11a");
        // 0a, 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a, 10a, 11a, ...
        //front                                         last
        assertEquals(array.INITIAL_CAPACITY + 1, array.size());
        assertEquals(array.INITIAL_CAPACITY * 2, ((Object[]) array.getBackingArray()).length);

        expected = new String[ArrayDeque.INITIAL_CAPACITY * 2];
        for (int i = 0; i < array.INITIAL_CAPACITY + 1; ++i) {
            expected[i] = i + "a";
        }
        assertArrayEquals(expected, array.getBackingArray());
        assertEquals("0a", array.getFirst());
        assertEquals("11a", array.getLast());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayDequeAddFirstResize() {
        for (int i = 0; i < array.INITIAL_CAPACITY; ++i) {
            array.addFirst(i + "a");
        }
        // 10a, 9a, 8a, 7a, 6a, 5a, 4a, 3a, 2a, 1a, 0a
        //front                                    last
        assertEquals(array.INITIAL_CAPACITY, array.size());

        String[] expected = new String[ArrayDeque.INITIAL_CAPACITY];
        for (int i = array.INITIAL_CAPACITY - 1; i >= 0; --i) {
            expected[i] = (array.INITIAL_CAPACITY - 1 - i) + "a";
        }
        assertArrayEquals(expected, array.getBackingArray());
        assertEquals("10a", array.getFirst());
        assertEquals("0a", array.getLast());

        array.addFirst("11a");
        // 11a, 10a, 9a, 8a, 7a, 6a, 5a, 4a, 3a, 2a, 1a, 0a, .....
        //front                                          last
        assertEquals(array.INITIAL_CAPACITY + 1, array.size());
        assertEquals(array.INITIAL_CAPACITY * 2, ((Object[]) array.getBackingArray()).length);

        expected = new String[ArrayDeque.INITIAL_CAPACITY * 2];
        for (int i = ArrayDeque.INITIAL_CAPACITY; i >= 0; --i) {
            expected[i] = (ArrayDeque.INITIAL_CAPACITY - i) + "a";
        }
        assertArrayEquals(expected, array.getBackingArray());
        assertEquals("11a", array.getFirst());
        assertEquals("0a", array.getLast());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayDequeRemoveFirstWrapAround() {
        array.addFirst("0a"); // _, _, _, _, _, _, _, _, _, _, 0a
        array.addLast("1a"); // 1a, _, _, _, _, _, _, _, _, _, 0a
        array.addLast("2a"); // 1a, 2a, _, _, _, _, _, _, _, _, 0a
        array.addLast("3a"); // 1a, 2a, 3a, _, _, _, _, _, _, _, 0a

        assertEquals(4, array.size());
        String[] expected = new String[ArrayDeque.INITIAL_CAPACITY];
        expected[0] = "1a";
        expected[1] = "2a";
        expected[2] = "3a";
        expected[ArrayDeque.INITIAL_CAPACITY - 1] = "0a";

        assertArrayEquals(expected, array.getBackingArray());
        assertEquals("0a", array.getFirst());
        assertEquals("3a", array.getLast());

        assertEquals("0a", array.removeFirst()); // 1a, 2a, 3a, _, _, _, _, _, _, _, _
        assertEquals("1a", array.getFirst());
        assertEquals("3a", array.getLast());
        assertEquals(3, array.size());
        expected[ArrayDeque.INITIAL_CAPACITY - 1] = null;
        assertArrayEquals(expected, array.getBackingArray());

        assertEquals("1a", array.removeFirst()); // _, 2a, 3a, _, _, _, _, _, _, _, _
        assertEquals("2a", array.getFirst());
        assertEquals("3a", array.getLast());
        assertEquals(2, array.size());
        expected[0] = null;
        assertArrayEquals(expected, array.getBackingArray());

        assertEquals("2a", array.removeFirst()); // _, _, 3a, _, _, _, _, _, _, _, _
        assertEquals("3a", array.getFirst());
        assertEquals("3a", array.getLast());
        assertEquals(1, array.size());
        expected[1] = null;
        assertArrayEquals(expected, array.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayDequeRemoveLastWrapAround() {
        array.addFirst("0a"); // _, _, _, _, _, _, _, _, _, _, 0a
        array.addFirst("1a"); // _, _, _, _, _, _, _, _, _, 1a, 0a
        array.addFirst("2a"); // _, _, _, _, _, _, _, _, 2a, 1a, 0a
        array.addLast("3a"); // 3a, _, _, _, _, _, _, _, 2a, 1a, 0a

        assertEquals(4, array.size());
        String[] expected = new String[ArrayDeque.INITIAL_CAPACITY];
        expected[0] = "3a";
        expected[ArrayDeque.INITIAL_CAPACITY - 1] = "0a";
        expected[ArrayDeque.INITIAL_CAPACITY - 2] = "1a";
        expected[ArrayDeque.INITIAL_CAPACITY - 3] = "2a";

        assertArrayEquals(expected, array.getBackingArray());
        assertEquals("2a", array.getFirst());
        assertEquals("3a", array.getLast());

        assertEquals("3a", array.removeLast()); // _, _, _, _, _, _, _, _, 2a, 1a, 0a
        assertEquals("2a", array.getFirst());
        assertEquals("0a", array.getLast());
        assertEquals(3, array.size());
        expected[0] = null;
        assertArrayEquals(expected, array.getBackingArray());

        assertEquals("0a", array.removeLast()); // _, _, _, _, _, _, _, _, 2a, 1a, _
        assertEquals("2a", array.getFirst());
        assertEquals("1a", array.getLast());
        assertEquals(2, array.size());
        expected[ArrayDeque.INITIAL_CAPACITY - 1] = null;
        assertArrayEquals(expected, array.getBackingArray());

        assertEquals("1a", array.removeLast()); // _, _, _, _, _, _, _, _, 2a, _, _
        assertEquals("2a", array.getFirst());
        assertEquals("2a", array.getLast());
        assertEquals(1, array.size());
        expected[ArrayDeque.INITIAL_CAPACITY - 2] = null;
        assertArrayEquals(expected, array.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayDequeRemoveLastBecomeEmpty() {
        array.addLast("0a"); // 0a, _, _, _, _, _, _, _, _, _, _
        array.addLast("1a"); // 0a, 1a, _, _, _, _, _, _, _, _, _

        assertEquals(2, array.size());
        String[] expected = new String[ArrayDeque.INITIAL_CAPACITY];
        expected[0] = "0a";
        expected[1] = "1a";
        assertArrayEquals(expected, array.getBackingArray());

        assertEquals("0a", array.removeFirst()); // _, 1a, _, _, _, _, _, _, _, _, _
        assertEquals(1, array.size());           //     f
        expected[0] = null;
        assertArrayEquals(expected, array.getBackingArray());

        assertEquals("1a", array.removeLast()); // _, _, _, _, _, _, _, _, _, _, _
        assertEquals(0, array.size());          //    f
        expected[1] = null;
        assertArrayEquals(expected, array.getBackingArray());

        array.addFirst("0a"); // 0a, _, _, _, _, _, _, _, _, _, _
        assertEquals(1, array.size());
        expected[0] = "0a";
        assertArrayEquals(expected, array.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayDequeRemoveFirstBecomeEmpty() {
        array.addLast("0a"); // 0a, _, _, _, _, _, _, _, _, _, _
        array.addLast("1a"); // 0a, 1a, _, _, _, _, _, _, _, _, _
        // f
        assertEquals(2, array.size());
        String[] expected = new String[ArrayDeque.INITIAL_CAPACITY];
        expected[0] = "0a";
        expected[1] = "1a";
        assertArrayEquals(expected, array.getBackingArray());

        assertEquals("0a", array.removeFirst()); // _, 1a, _, _, _, _, _, _, _, _, _
        assertEquals(1, array.size());           //     f
        expected[0] = null;
        assertArrayEquals(expected, array.getBackingArray());

        assertEquals("1a", array.removeFirst()); // _, _, _, _, _, _, _, _, _, _, _
        assertEquals(0, array.size());           //       f
        expected[1] = null;
        assertArrayEquals(expected, array.getBackingArray());

        array.addFirst("0a"); // _, 0a, _, _, _, _, _, _, _, _, _
        assertEquals(1, array.size());
        expected[1] = "0a";
        assertArrayEquals(expected, array.getBackingArray());
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testArrayDequeAddFirstNull() {
        array.addFirst(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testArrayDequeAddLastNull() {
        array.addLast(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testArrayDequeRemoveFirstWhenEmpty() {
        array.removeFirst();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testArrayDequeRemoveLastWhenEmpty() {
        array.removeLast();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testArrayDequeGetFirstWhenEmpty() {
        array.getFirst();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testArrayDequeGetLastWhenEmpty() {
        array.getLast();
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedDequeRemoveFirstBecomeEmpty() {
        linked.addLast("0a"); // 0a
        linked.addLast("1a"); // 0a, 1a

        assertEquals("0a", linked.removeFirst());
        assertEquals(linked.getHead(), linked.getTail());
        assertNull(linked.getHead().getNext());
        assertNull(linked.getHead().getPrevious());

        assertEquals("1a", linked.removeFirst());

        assertNull(linked.getHead());
        assertNull(linked.getTail());
        assertEquals(0, linked.size());
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedDequeRemoveLastBecomeEmpty() {
        linked.addLast("0a"); // 0a
        linked.addLast("1a"); // 0a, 1a

        assertEquals("1a", linked.removeLast());
        assertEquals(linked.getHead(), linked.getTail());
        assertNull(linked.getHead().getNext());
        assertNull(linked.getHead().getPrevious());

        assertEquals("0a", linked.removeLast());

        assertNull(linked.getHead());
        assertNull(linked.getTail());
        assertEquals(0, linked.size());
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testLinkedDequeAddFirstNull() {
        linked.addFirst(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testLinkedDequeAddLastNull() {
        linked.addLast(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testLinkedDequeRemoveFirstWhenEmpty() {
        linked.removeFirst();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testLinkedDequeRemoveLastWhenEmpty() {
        linked.removeLast();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testLinkedDequeGetFirstWhenEmpty() {
        linked.getFirst();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testLinkedDequeGetLastWhenEmpty() {
        linked.getLast();
    }
}