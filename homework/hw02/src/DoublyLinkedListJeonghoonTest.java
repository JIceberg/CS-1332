import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * This is Unit Test for HW2 in CS1332
 *
 * @Author Jeonghoon Lee
 * @version 1.0
 */
public class DoublyLinkedListJeonghoonTest {

    private static final int TIMEOUT = 200;
    private DoublyLinkedList<String> list;

    @Before
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test(timeout = TIMEOUT)
    public void testAddIndex() {
        list.addAtIndex(0, "4a"); // 4a
        assertEquals("4a", list.getHead().getData());
        assertEquals("4a", list.getTail().getData());
        assertSame(list.getHead(), list.getTail());
        assertEquals(1, list.size());
        // check the head and tail are pointed to exact node.

        assertNull(list.getHead().getNext());
        assertNull(list.getTail().getPrevious());
        // check the head and tail 's next, and previous is null, bc there is only one node in data structure.

        list.addAtIndex(0, "2a"); // 2a 4a
        // adding the node to first index.

        assertEquals("4a", list.getHead().getNext().getData());
        assertEquals("2a", list.getHead().getData());
        assertSame(list.getHead().getNext(), list.getTail());
        assertSame(list.getHead(), list.getTail().getPrevious());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(2, list.size());
        //check the nodes are properly connected.

        list.addAtIndex(2, "5a"); // 2a 4a 5a
        //adding the node to index 2

        assertEquals("2a", list.getHead().getData());
        assertEquals("4a", list.getHead().getNext().getData());
        assertEquals("5a", list.getHead().getNext().getNext().getData());
        assertSame(list.getHead(), list.getTail().getPrevious().getPrevious());
        assertSame(list.getHead().getNext(), list.getTail().getPrevious());
        assertSame(list.getHead().getNext().getNext(), list.getTail());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(3, list.size());
        //check the nodes are properly connected.

        list.addAtIndex(1, "3a"); // 2a 3a 4a 5a
        //adding the node to index 1.

        assertEquals("2a", list.getHead().getData());
        assertEquals("3a", list.getHead().getNext().getData());
        assertEquals("4a", list.getHead().getNext().getNext().getData());
        assertEquals("5a", list.getHead().getNext().getNext().getNext().getData());
        assertSame(list.getHead(), list.getTail().getPrevious().getPrevious().getPrevious());
        assertSame(list.getHead().getNext(), list.getTail().getPrevious().getPrevious());
        assertSame(list.getHead().getNext().getNext(), list.getTail().getPrevious());
        assertSame(list.getHead().getNext().getNext().getNext(), list.getTail());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(4, list.size());
        //check the nodes are properly connected.

        list.addAtIndex(4, "6a"); // 2a 3a 4a 5a 6a
        //adding the node to end

        assertEquals("2a", list.getHead().getData());
        assertEquals("3a", list.getHead().getNext().getData());
        assertEquals("4a", list.getHead().getNext().getNext().getData());
        assertEquals("5a", list.getHead().getNext().getNext().getNext().getData());
        assertEquals("6a", list.getHead().getNext().getNext().getNext().getNext().getData());
        assertSame(list.getHead(), list.getTail().getPrevious().getPrevious().getPrevious().getPrevious());
        assertSame(list.getHead().getNext(), list.getTail().getPrevious().getPrevious().getPrevious());
        assertSame(list.getHead().getNext().getNext(), list.getTail().getPrevious().getPrevious());
        assertSame(list.getHead().getNext().getNext().getNext(), list.getTail().getPrevious());
        assertSame(list.getHead().getNext().getNext().getNext().getNext(), list.getTail());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(5, list.size());
        //check the nodes are properly connected.
    }

    @Test(timeout = TIMEOUT)
    public void testAddIndexException() {

        try {
            list.addAtIndex(0, null); // (null)[0]
            fail();
        } catch (IllegalArgumentException e) {
        }
        // test to adding null

        try {
            list.addAtIndex(1, "1a"); // (0)[?] (1a)[1]
            fail();
        } catch (IndexOutOfBoundsException e) {
        }

        list.addAtIndex(0, "0a"); // (0a)[0]
        list.addAtIndex(1, "1a"); // (0a)[0] (1a)[1]
        // we assume that the addAtIndexMethod works properly.
        // make a data structure for test.

        try {
            list.addAtIndex(-1, "-1a"); // (-1a)[?] (0a)[0] (1a)[1]
            fail();
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            list.addAtIndex(3, "3a"); // (0a)[0] (1a)[1] (?)[2] (3a)[3]
            fail();
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test(timeout = TIMEOUT)
    public void testAddToFront() {
        list.addToFront("6a"); // 6a
        assertEquals("6a", list.getHead().getData());
        assertEquals("6a", list.getTail().getData());
        assertSame(list.getHead(), list.getTail());
        assertEquals(1, list.size());
        // check the head and tail are pointed to exact node.

        assertNull(list.getHead().getNext());
        assertNull(list.getTail().getPrevious());
        // check the head and tail 's next, and previous is null, bc there is only one node in data structure.

        list.addToFront("5a"); // 5a 6a
        // adding the node to first index.

        assertEquals("6a", list.getHead().getNext().getData());
        assertEquals("5a", list.getHead().getData());
        assertSame(list.getHead().getNext(), list.getTail());
        assertSame(list.getHead(), list.getTail().getPrevious());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(2, list.size());
        //check the nodes are properly connected.

        list.addToFront("4a"); // 4a 5a 6a
        //adding the node to index 2

        assertEquals("4a", list.getHead().getData());
        assertEquals("5a", list.getHead().getNext().getData());
        assertEquals("6a", list.getHead().getNext().getNext().getData());
        assertSame(list.getHead(), list.getTail().getPrevious().getPrevious());
        assertSame(list.getHead().getNext(), list.getTail().getPrevious());
        assertSame(list.getHead().getNext().getNext(), list.getTail());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(3, list.size());
        //check the nodes are properly connected.

    }

    @Test(timeout = TIMEOUT)
    public void testAddFrontException() {

        try {
            list.addToFront(null); // (null)[0]
            fail();
        } catch (IllegalArgumentException e) {
        }
        // test: adding front to null data node, before a node is added

        list.addToFront("1a"); // (1a)[1]
        list.addToFront("0a"); // (0a)[0] (1a)[1]
        // make a data structure for test.

        try {
            list.addToFront(null); // (null)[0] (0a)[1] (1a)[2]
            fail();
        } catch (IllegalArgumentException e) {
        }
        //test: adding front to null data node, after a node is added
    }

    @Test(timeout = TIMEOUT)
    public void testAddToBack() {
        list.addToBack("1a"); // 1a
        assertEquals("1a", list.getHead().getData());
        assertEquals("1a", list.getTail().getData());
        assertSame(list.getHead(), list.getTail());
        assertEquals(1, list.size());
        // check the head and tail are pointed to exact node.

        assertNull(list.getHead().getNext());
        assertNull(list.getTail().getPrevious());
        // check the head and tail 's next, and previous is null, bc there is only one node in data structure.

        list.addToBack("2a"); // 1a 2a
        // adding the node to first index.

        assertEquals("2a", list.getHead().getNext().getData());
        assertEquals("1a", list.getHead().getData());
        assertSame(list.getHead().getNext(), list.getTail());
        assertSame(list.getHead(), list.getTail().getPrevious());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(2, list.size());
        //check the nodes are properly connected.

        list.addToBack("3a"); // 1a 2a 3a
        //adding the node to index 2

        assertEquals("1a", list.getHead().getData());
        assertEquals("2a", list.getHead().getNext().getData());
        assertEquals("3a", list.getHead().getNext().getNext().getData());
        assertSame(list.getHead(), list.getTail().getPrevious().getPrevious());
        assertSame(list.getHead().getNext(), list.getTail().getPrevious());
        assertSame(list.getHead().getNext().getNext(), list.getTail());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(3, list.size());
        //check the nodes are properly connected.
    }

    @Test(timeout = TIMEOUT)
    public void testAddBackException() {

        try {
            list.addToBack(null); // (null)[0]
            fail();
        } catch (IllegalArgumentException e) {
        }
        // test: adding back to null data node, before a node is added

        list.addToBack("0a"); // (0a)[0]
        list.addToBack("1a"); // (0a)[0] (1a)[1]
        // make a data structure for test.

        try {
            list.addToBack(null); // (0a)[0] (1a)[1] (null)[2]
            fail();
        } catch (IllegalArgumentException e) {
        }
        //test: adding back to null data node, after a node is added
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndex() {
        list.addAtIndex(0, "0a"); //0a
        list.addAtIndex(1, "1a"); //0a 1a
        list.addAtIndex(2, "2a"); //0a 1a 2a
        list.addAtIndex(3, "3a"); //0a 1a 2a 3a
        list.addAtIndex(4, "4a"); //0a 1a 2a 3a 4a
        // we assume that the addAtIndexMethod works properly.

        assertEquals("0a", list.removeAtIndex(0)); // 1a 2a 3a 4a
        //remove first node and check return value.
        assertEquals("1a", list.getHead().getData());
        assertEquals("2a", list.getHead().getNext().getData());
        assertEquals("3a", list.getHead().getNext().getNext().getData());
        assertEquals("4a", list.getHead().getNext().getNext().getNext().getData());
        assertSame(list.getHead(), list.getTail().getPrevious().getPrevious().getPrevious());
        assertSame(list.getHead().getNext(), list.getTail().getPrevious().getPrevious());
        assertSame(list.getHead().getNext().getNext(), list.getTail().getPrevious());
        assertSame(list.getHead().getNext().getNext().getNext(), list.getTail());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(4, list.size());
        // check all nodes connected properly.

        assertEquals("2a", list.removeAtIndex(1)); // 1a 3a 4a
        //remove second node and check return value.
        assertEquals("1a", list.getHead().getData());
        assertEquals("3a", list.getHead().getNext().getData());
        assertEquals("4a", list.getHead().getNext().getNext().getData());
        assertSame(list.getHead(), list.getTail().getPrevious().getPrevious());
        assertSame(list.getHead().getNext(), list.getTail().getPrevious());
        assertSame(list.getHead().getNext().getNext(), list.getTail());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(3, list.size());
        //check the nodes are properly connected.

        assertEquals("4a", list.removeAtIndex(2)); // 1a 3a
        //remove rightmost node and check return value.
        assertEquals("3a", list.getHead().getNext().getData());
        assertEquals("1a", list.getHead().getData());
        assertSame(list.getHead().getNext(), list.getTail());
        assertSame(list.getHead(), list.getTail().getPrevious());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(2, list.size());
        //check the nodes are properly connected.

        assertEquals("1a", list.removeAtIndex(0)); // 3a
        //remove first node from two nodes and check return value.
        assertEquals("3a", list.getHead().getData());
        assertEquals("3a", list.getTail().getData());
        assertSame(list.getHead(), list.getTail());
        assertEquals(1, list.size());
        // check the head and tail are pointed to exact node.
        assertNull(list.getHead().getNext());
        assertNull(list.getTail().getPrevious());
        // check the head and tail 's next, and previous is null, bc there is only one node in data structure.

        list.addToFront("2a"); //2a 3a
        assertEquals("3a", list.removeAtIndex(1)); // 2a
        //remove last node from two nodes and check return value.
        assertEquals("2a", list.getHead().getData());
        assertEquals("2a", list.getTail().getData());
        assertSame(list.getHead(), list.getTail());
        assertEquals(1, list.size());
        // check the head and tail are pointed to exact node.
        assertNull(list.getHead().getNext());
        assertNull(list.getTail().getPrevious());
        // check the head and tail 's next, and previous is null, bc there is only one node in data structure.

        assertEquals("2a", list.removeAtIndex(0)); // nada
        //remove a node from data structure and check return value.
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.size());
    }


    @Test(timeout = TIMEOUT)
    public void testRemoveAtBIndexException() {
        try {
            list.removeAtIndex(0);
            fail();
        } catch (IndexOutOfBoundsException e) {
        }
        // test: if data structure is empty

        list.addAtIndex(0, "0a"); //0a
        list.addAtIndex(1, "1a"); //0a 1a
        list.addAtIndex(2, "2a"); //0a 1a 2a
        // we assume that the addAtIndexMethod works properly.

        try {
            list.removeAtIndex(-1);
            fail();
        } catch (IndexOutOfBoundsException e) {
        }
        // test: if index is negative.

        try {
            list.removeAtIndex(3);
            fail();
        } catch (IndexOutOfBoundsException e) {
        }
        // test: if index is out of Bounds
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromFront() {
        list.addAtIndex(0, "0a"); //0a
        list.addAtIndex(1, "1a"); //0a 1a
        list.addAtIndex(2, "2a"); //0a 1a 2a
        // we assume that the addAtIndexMethod works properly.

        assertEquals("0a", list.removeFromFront()); // 1a 2a
        //remove a front node from 3 nodes and check return value.
        assertEquals("2a", list.getHead().getNext().getData());
        assertEquals("1a", list.getHead().getData());
        assertSame(list.getHead().getNext(), list.getTail());
        assertSame(list.getHead(), list.getTail().getPrevious());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(2, list.size());
        //check the nodes are properly connected.

        assertEquals("1a", list.removeFromFront()); // 2a
        //remove a front node from 2 nodes and check return value.
        assertEquals("2a", list.getHead().getData());
        assertEquals("2a", list.getTail().getData());
        assertSame(list.getHead(), list.getTail());
        assertEquals(1, list.size());
        // check the head and tail are pointed to exact node.
        assertNull(list.getHead().getNext());
        assertNull(list.getTail().getPrevious());
        // check the head and tail 's next, and previous are null, bc there is only one node in data structure.

        assertEquals("2a", list.removeFromFront()); // nada
        //remove a node from data structure and check return value.
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.size());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromFrontException() {
        try {
            list.removeFromFront();
            fail();
        } catch (NoSuchElementException e) {
        }
        // test: if data structure is empty
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromBack() {
        list.addAtIndex(0, "0a"); //0a
        list.addAtIndex(1, "1a"); //0a 1a
        list.addAtIndex(2, "2a"); //0a 1a 2a
        // we assume that the addAtIndexMethod works properly.

        assertEquals("2a", list.removeFromBack()); // 0a 1a
        //remove a front node from 3 nodes and check return value.
        assertEquals("1a", list.getHead().getNext().getData());
        assertEquals("0a", list.getHead().getData());
        assertSame(list.getHead().getNext(), list.getTail());
        assertSame(list.getHead(), list.getTail().getPrevious());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(2, list.size());
        //check the nodes are properly connected.

        assertEquals("1a", list.removeFromBack()); // 0a
        //remove a front node from 2 nodes and check return value.
        assertEquals("0a", list.getHead().getData());
        assertEquals("0a", list.getTail().getData());
        assertSame(list.getHead(), list.getTail());
        assertEquals(1, list.size());
        // check the head and tail are pointed to exact node.
        assertNull(list.getHead().getNext());
        assertNull(list.getTail().getPrevious());
        // check the head and tail 's next, and previous are null, bc there is only one node in data structure.

        assertEquals("0a", list.removeFromBack()); // nada
        //remove a node from data structure and check return value.
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.size());

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromBackException() {
        try {
            list.removeFromFront();
            fail();
        } catch (NoSuchElementException e) {
        }
        // test: if data structure is empty
    }

    @Test(timeout = TIMEOUT)
    public void testGet() {
        list.addAtIndex(0, "0a"); //0a
        list.addAtIndex(1, "1a"); //0a 1a
        list.addAtIndex(2, "2a"); //0a 1a 2a
        list.addAtIndex(3, "3a"); //0a 1a 2a 3a
        list.addAtIndex(4, "4a"); //0a 1a 2a 3a 4a
        // we assume that the addAtIndexMethod works properly.

        assertEquals("0a", list.get(0));
        assertEquals("1a", list.get(1));
        assertEquals("2a", list.get(2));
        assertEquals("3a", list.get(3));
        assertEquals("4a", list.get(4));
    }

    @Test(timeout = TIMEOUT)
    public void testGetException() {
        try {
            list.get(0);
            fail();
        } catch (IndexOutOfBoundsException e) {
        }
        // test: if data structure is empty

        list.addAtIndex(0, "0a"); //0a
        list.addAtIndex(1, "1a"); //0a 1a
        list.addAtIndex(2, "2a"); //0a 1a 2a
        // we assume that the addAtIndexMethod works properly.

        try {
            list.get(-1);
            fail();
        } catch (IndexOutOfBoundsException e) {
        }
        // test: if index is negative.

        try {
            list.get(3);
            fail();
        } catch (IndexOutOfBoundsException e) {
        }
        // test: if index is out of Bounds
    }

    @Test(timeout = TIMEOUT)
    public void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.addAtIndex(0, "0a"); //0a
        assertFalse(list.isEmpty());

        list.addAtIndex(1, "1a"); //0a 1a
        assertFalse(list.isEmpty());
        // we assume that the addAtIndexMethod works properly.
    }

    @Test(timeout = TIMEOUT)
    public void testClear() {
        list.clear();
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.size());
        //test1, if there is no node in data structure.


        list.addAtIndex(0, "0a"); //0a
        // we assume that the addAtIndexMethod works properly.
        assertEquals("0a", list.getHead().getData());
        assertEquals("0a", list.getTail().getData());
        assertSame(list.getHead(), list.getTail());
        assertEquals(1, list.size());
        //check the data properly stored
        list.clear();
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.size());
        //test2, if there is one node in data structure


        list.addAtIndex(0, "0a"); //0a
        list.addAtIndex(1, "1a"); //0a 1a
        // we assume that the addAtIndexMethod works properly.
        assertEquals("1a", list.getHead().getNext().getData());
        assertEquals("0a", list.getHead().getData());
        assertSame(list.getHead().getNext(), list.getTail());
        assertSame(list.getHead(), list.getTail().getPrevious());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(2, list.size());
        //check the data properly stored
        list.clear();
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.size());
        //test3, if there is two node in data structure
    }


    @Test(timeout = TIMEOUT)
    public void testRemoveLastOccurrence() {

        String str0 = "0a";
        String str1 = "1a";
        String str2 = "2a";
        String str3 = "3a";
        String str4 = "4a";

        list.addAtIndex(0, str0); //0a
        list.addAtIndex(1, str1); //0a 1a
        list.addAtIndex(2, str2); //0a 1a 2a
        list.addAtIndex(3, str3); //0a 1a 2a 3a
        list.addAtIndex(4, str4); //0a 1a 2a 3a 4a
        // we assume that the addAtIndexMethod works properly.

        String temp = list.removeLastOccurrence("1a"); //0a 2a 3a 4a
        assertEquals("1a", temp);
        assertSame(temp, str1);
        //check the return value is same as the value that stored in the index.
        assertEquals("0a", list.getHead().getData());
        assertEquals("2a", list.getHead().getNext().getData());
        assertEquals("3a", list.getHead().getNext().getNext().getData());
        assertEquals("4a", list.getHead().getNext().getNext().getNext().getData());
        assertSame(list.getHead(), list.getTail().getPrevious().getPrevious().getPrevious());
        assertSame(list.getHead().getNext(), list.getTail().getPrevious().getPrevious());
        assertSame(list.getHead().getNext().getNext(), list.getTail().getPrevious());
        assertSame(list.getHead().getNext().getNext().getNext(), list.getTail());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(4, list.size());
        // check all nodes connected properly.

        temp = list.removeLastOccurrence("0a"); //2a 3a 4a
        assertEquals("0a", temp);
        assertSame(temp, str0);
        //check the return value is same as the value that stored in the index.
        assertEquals("2a", list.getHead().getData());
        assertEquals("3a", list.getHead().getNext().getData());
        assertEquals("4a", list.getHead().getNext().getNext().getData());
        assertSame(list.getHead(), list.getTail().getPrevious().getPrevious());
        assertSame(list.getHead().getNext(), list.getTail().getPrevious());
        assertSame(list.getHead().getNext().getNext(), list.getTail());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(3, list.size());
        // check all nodes connected properly.

        temp = list.removeLastOccurrence("4a"); //2a 3a
        assertEquals("4a", temp);
        assertSame(temp, str4);
        //check the return value is same as the value that stored in the index.
        assertEquals("2a", list.getHead().getData());
        assertEquals("3a", list.getHead().getNext().getData());
        assertSame(list.getHead(), list.getTail().getPrevious());
        assertSame(list.getHead().getNext(), list.getTail());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(2, list.size());
        // check all nodes connected properly.

        temp = list.removeLastOccurrence("2a"); //3a
        assertEquals("2a", temp);
        assertSame(temp, str2);
        //check the return value is same as the value that stored in the index.
        assertEquals("3a", list.getHead().getData());
        assertSame(list.getHead(), list.getTail());
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        assertEquals(1, list.size());
        // check all nodes connected properly.

        temp = list.removeLastOccurrence("3a"); // nada
        assertEquals("3a", temp);
        assertSame(temp, str3);
        //check the return value is same as the value that stored in the index.
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.size());
        // check all nodes connected properly.
    }

    @Test(timeout = TIMEOUT)
    public void testLastOccurrenceException() {
        try {
            list.removeLastOccurrence("a0");
            fail();
        } catch (NoSuchElementException e) {
        }
        // test: if data structure is empty == cannot found data.

        list.addAtIndex(0, "0a"); //0a
        list.addAtIndex(1, "1a"); //0a 1a
        list.addAtIndex(2, "2a"); //0a 1a 2a
        // we assume that the addAtIndexMethod works properly.

        try {
            list.removeLastOccurrence("3a");
            fail();
        } catch (NoSuchElementException e) {
        }
        // test: if data is not found.

        try {
            list.removeLastOccurrence(null);
            fail();
        } catch (IllegalArgumentException e) {
        }
        // test: if the data is null.
    }

    @Test(timeout = TIMEOUT)
    public void testToArray() {

        String[] strList0 = new String[0];
        assertArrayEquals(strList0, list.toArray());

        list.addAtIndex(0, "0a"); //0a
        String[] strList1 = {"0a"};
        assertArrayEquals(strList1, list.toArray());
        // we assume that the addAtIndexMethod works properly.

        list.addAtIndex(1, "1a"); //0a 1a
        String[] strList2 = {"0a", "1a"};
        assertArrayEquals(strList2, list.toArray());
        // we assume that the addAtIndexMethod works properly.

        list.addAtIndex(2, "2a"); //0a 1a 2a
        String[] strList3 = {"0a", "1a", "2a"};
        assertArrayEquals(strList3, list.toArray());
        // we assume that the addAtIndexMethod works properly.
    }
}