import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * My first JUnit. Probably messy.
 *
 * @author Andrew Roach
 * @version 1.0
 */
public class DoublyLinkedListJUnitAndrew {
    private static final int TIMEOUT = 200;
    private DoublyLinkedList<String> list;

    @Before
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test (timeout = TIMEOUT)
    public void clearUsingFront() {
        setupNormal("Front");

        list.clear();

        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.size());
    }

    @Test (timeout = TIMEOUT)
    public void clearUsingBack() {
        setupNormal("Back");

        list.clear();

        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.size());
    }

    @Test (timeout = TIMEOUT)
    public void clearUsingIndex() {
        setupNormal("Index");

        list.clear();

        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.size());
    }

    @Test (timeout = TIMEOUT)
    public void addToEmptyDLLUsingFront() {
        setupOneElement("Front");

        assertEquals(1, list.size());
        assertNotNull(list.getHead());
        assertNotNull(list.getTail());
    }

    @Test (timeout = TIMEOUT)
    public void addToEmptyDLLUsingBack() {
        setupOneElement("Back");

        assertEquals(1, list.size());
        assertNotNull(list.getHead());
        assertNotNull(list.getTail());
    }

    @Test (timeout = TIMEOUT)
    public void addToEmptyDLLUsingIndex() {
        setupOneElement("Index");

        assertEquals(1, list.size());
        assertNotNull(list.getHead());
        assertNotNull(list.getTail());
    }

    @Test (timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void removeFromFrontEmptyDLL() {
        setupNoElements();

        list.removeFromFront();
    }

    @Test (timeout = TIMEOUT)
    public void removeFromFrontOneElemDLLUsingFront() {
        setupOneElement("Front");

        list.removeFromFront();

        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.size());
    }

    @Test (timeout = TIMEOUT)
    public void removeFromFrontOneElemDLLUsingBack() {
        setupOneElement("Back");

        list.removeFromFront();

        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.size());
    }

    @Test (timeout = TIMEOUT)
    public void removeFromFrontOneElemDLLUsingIndex() {
        setupOneElement("Index");

        list.removeFromFront();

        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.size());
    }

    @Test (timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void removeFromBackEmptyDLL() {
        setupNoElements();

        list.removeFromBack();
    }

    @Test (timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void removeIndexEmptyDLL() {
        setupNoElements();

        list.removeAtIndex(0);
    }

    @Test (timeout = TIMEOUT)
    public void removeFromBackOneElemUsingIndex() {
        setupOneElement("Index");

        list.removeFromBack();

        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.size());
    }

    @Test (timeout = TIMEOUT)
    public void toArrayUsingIndex() {
        setupNormal("Index");

        String[] dataArr = {"a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7"};
        Object[] returnedArr = (list.toArray());

        assertEquals(dataArr.length, list.size());

        for (int i = 0; i < dataArr.length; i++) {
            assertNotNull(returnedArr[i]);
        }
    }

    @Test
    public void addAtIndexUsingIndex() {
        setupNormal("Index");

        String[] expectedArr1 = {"a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7"};
        checkDLLElements(expectedArr1);

        list.addAtIndex(4, "69");
        String[] expectedArr2 = {"a0", "a1", "a2", "a3", "69", "a4", "a5", "a6", "a7"};
        checkDLLElements(expectedArr2);

        list.addAtIndex(9, "end");
        String[] expectedArr3 = {"a0", "a1", "a2", "a3", "69", "a4", "a5", "a6", "a7", "end"};
        checkDLLElements(expectedArr3);

        list.addAtIndex(0, "beginning");
        String[] expectedArr4 = {"beginning", "a0", "a1", "a2", "a3", "69", "a4", "a5", "a6", "a7", "end"};
        checkDLLElements(expectedArr4);
    }

    @Test
    public void getUsingIndex() {
        setupNormal("Index");

        assertEquals("a2", list.get(2));
        assertEquals("a7", list.get(7));
    }

    @Test
    public void isEmptyUsingIndex() {
        setupOneElement("Index");

        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void isEmptyUsingFront() {
        setupOneElement("Front");

        assertFalse(list.isEmpty());
        list.removeAtIndex(0);
        assertTrue(list.isEmpty());
    }

    @Test (expected = NoSuchElementException.class)
    public void removeLastOccurrenceTest() {
        setupNormal("Index");

        list.removeLastOccurrence("a0");
        String[] expectedArr = {"a1", "a2", "a3", "a4", "a5", "a6", "a7"};
        checkDLLElements(expectedArr);

        list.removeLastOccurrence("a");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void removeAtIndexTest() {
        setupNormal("Index");

        assertEquals("a1", list.removeAtIndex(1));
        assertEquals(7, list.size());
        assertEquals("a7", list.removeAtIndex(6));
        list.removeAtIndex(6);
    }

    /**
     * This does nothing; nothing is added to DLL
     */
    private void setupNoElements() {

    }

    /**
     * This adds 1 element to the DLL
     *
     * @param command this tells method whether to call add to front, back, or at index
     */
    private void setupOneElement(String command) {
        if (command.equalsIgnoreCase("Index")) {
            list.addAtIndex(0, "a0");
        } else if (command.equalsIgnoreCase("Back")) {
            list.addToBack("a0");
        } else {
            list.addToFront("a0");
        }
    }

    /**
     * This adds 8 elements to the DLL
     *
     * @param command this tells method whether to call add to front, back, or at index
     */
    private void setupNormal(String command) {
        if (command.equalsIgnoreCase("Index")) {
            list.addAtIndex(0, "a4");
            list.addAtIndex(0, "a2");
            list.addAtIndex(0, "a1");
            list.addAtIndex(3, "a6");
            list.addAtIndex(3, "a5");
            list.addAtIndex(5, "a7");
            list.addAtIndex(0, "a0");
            list.addAtIndex(3, "a3");
        } else if (command.equalsIgnoreCase("Back")) {
            list.addToBack("a0");
            list.addToBack("a1");
            list.addToBack("a2");
            list.addToBack("a3");
            list.addToBack("a4");
            list.addToBack("a5");
            list.addToBack("a6");
            list.addToBack("a7");
        } else {
            list.addToFront("a7");
            list.addToFront("a6");
            list.addToFront("a5");
            list.addToFront("a4");
            list.addToFront("a3");
            list.addToFront("a2");
            list.addToFront("a1");
            list.addToFront("a0");
        }
    }

    /**
     * This traverses through the DLL and looks for data mismatches
     *
     * @param expectedArr this is the list of elements expected in the DLL
     */
    private void checkDLLElements(String[] expectedArr) {
        DoublyLinkedListNode<String> curr = list.getHead();

        int counter = 0;

        while (curr.getNext() != null) {
            assertEquals(expectedArr[counter], curr.getData());
            counter++;
            curr = curr.getNext();
        }
    }
}