import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertFalse;

/**
 * Hope you're having a fantastic day! Keep up the good work.
 *
 * @author Justin Hinckley
 * @version 1.0
 */
public class BSTJustinTest {

    private static final int TIMEOUT = 200;
    private BST<Integer> tree;

    @Before
    public void setup() {
        tree = new BST<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, tree.size());
        assertNull(tree.getRoot());
    }

    // ======================================================================

    @Test(timeout = TIMEOUT)
    public void testAddABitMore() {
        tree.add(1);
        tree.add(0);
        tree.add(2);
        tree.add(55);
        tree.add(-1);
        tree.add(3);
        tree.add(-3);
        tree.add(-2);

        assertEquals(8, tree.size());

        assertEquals((Integer) 1, tree.getRoot().getData());
        assertEquals((Integer) 0, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 2, tree.getRoot().getRight().getData());
        assertEquals((Integer) 55, tree.getRoot().getRight().getRight().getData());
        assertEquals((Integer) (-1), tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 3, tree.getRoot().getRight().getRight().getLeft().getData());
        assertEquals((Integer) (-3), tree.getRoot().getLeft().getLeft().getLeft().getData());
        assertEquals((Integer) (-2), tree.getRoot().getLeft().getLeft().getLeft().getRight().getData());
    }

    @Test(timeout = TIMEOUT)
    public void testAddDupe() {
        tree.add(1);
        tree.add(0);
        tree.add(2);
        tree.add(new Integer(2));

        assertEquals(3, tree.size());

        assertEquals((Integer) 1, tree.getRoot().getData());
        assertEquals((Integer) 0, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 2, tree.getRoot().getRight().getData());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveReturnValue() {
        Integer temp = new Integer(2);
        tree.add(1);
        tree.add(0);
        tree.add(temp);

        assertSame(temp, tree.remove(2));
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveRoot() {
        tree.add(1);

        assertEquals((Integer) 1, tree.remove(1));
        assertEquals(tree.size(), 0);
        assertNull(tree.getRoot());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveNoChildren() {
        tree.add(1);
        tree.add(0);
        tree.add(2);

        assertEquals((Integer) 0, tree.remove(0));
        assertEquals(tree.size(), 2);
        assertEquals((Integer) 1, tree.getRoot().getData());
        assertEquals((Integer) 2, tree.getRoot().getRight().getData());
        assertNull(tree.getRoot().getLeft());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveLeftChild() {
        tree.add(1);
        tree.add(0);

        assertEquals((Integer) 1, tree.remove(1));
        assertEquals(1, tree.size());
        assertEquals((Integer) 0, tree.getRoot().getData());
        assertNull(tree.getRoot().getLeft());
        assertNull(tree.getRoot().getRight());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveHardSuccessor() {
        tree.add(1);
        tree.add(0);
        tree.add(10);
        tree.add(11);
        tree.add(9);
        tree.add(7);
        tree.add(8);

        assertEquals((Integer) 1, tree.remove(1));
        assertEquals(6, tree.size());
        assertEquals((Integer) 7, tree.getRoot().getData());
        assertEquals((Integer) 0, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 10, tree.getRoot().getRight().getData());
        assertEquals((Integer) 11, tree.getRoot().getRight().getRight().getData());
        assertEquals((Integer) 9, tree.getRoot().getRight().getLeft().getData());
        assertEquals((Integer) 8, tree.getRoot().getRight().getLeft().getLeft().getData());
        assertNull(tree.getRoot().getRight().getLeft().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getLeft().getLeft().getLeft());
    }

    @Test(timeout = TIMEOUT)
    public void testGetReturnValue() {
        Integer temp = new Integer(2);
        tree.add(1);
        tree.add(0);
        tree.add(temp);

        assertSame(temp, tree.get(2));
    }

    @Test(timeout = TIMEOUT)
    public void testContainsEmpty() {
        assertFalse(tree.contains(2));
    }

    @Test(timeout = TIMEOUT)
    public void testHeightEmpty() {
        assertEquals(-1, tree.height());
    }

    @Test(timeout = TIMEOUT)
    public void testHeightOneElem() {
        tree.add(1);
        assertEquals(0, tree.height());
    }

    @Test(timeout = TIMEOUT)
    public void testHeightTwoElem() {
        tree.add(1);
        tree.add(0);
        assertEquals(1, tree.height());
    }

    @Test(timeout = TIMEOUT)
    public void testHeightThreeElem() {
        tree.add(1);
        tree.add(0);
        tree.add(2);
        assertEquals(1, tree.height());
    }

    @Test(timeout = TIMEOUT)
    public void testKLargest0() {
        tree.add(1);
        tree.add(-1);
        tree.add(2);
        tree.add(4);
        tree.add(3);
        tree.add(0);
        assertEquals(Collections.emptyList(), tree.kLargest(0));
    }

    @Test(timeout = TIMEOUT)
    public void testKLargest1() {
        tree.add(1);
        tree.add(-1);
        tree.add(2);
        tree.add(4);
        tree.add(3);
        tree.add(0);
        assertEquals(Collections.singletonList(4), tree.kLargest(1));
    }

    @Test(timeout = TIMEOUT)
    public void testKLargestAll() {
        /*
            1
           / \
         -1   2
           \   \
            0   4
               /
              3
         */
        tree.add(1);
        tree.add(-1);
        tree.add(2);
        tree.add(4);
        tree.add(3);
        tree.add(0);
        assertEquals(Arrays.asList(-1, 0, 1, 2, 3, 4), tree.kLargest(6));
    }


    // ======================== EXCEPTION TESTS ===============================

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testConstructorExceptionNullParam() {
        BST<Integer> temp = new BST<>(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testConstructorExceptionNullElem() {
        BST<Integer> temp = new BST<>(Arrays.asList(1, 2, null, 3));
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddExceptionNullParam() {
        tree.add(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testRemoveExceptionNullParam() {
        tree.add(1);
        tree.remove(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveExceptionNotFound() {
        tree.add(1);
        tree.remove(2);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testGetExceptionNullParam() {
        tree.add(1);
        tree.get(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testGetExceptionNotFound() {
        tree.add(1);
        tree.get(2);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testGetExceptionEmpty() {
        tree.get(2);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testContainsExceptionNullParam() {
        tree.add(1);
        tree.contains(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testKLargestExceptionNotEnough() {
        tree.add(1);
        tree.kLargest(2);
    }
}