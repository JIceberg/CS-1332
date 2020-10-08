import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A few sample tests.
 *
 * @author Jackson Isenberg
 * @version 1.0
 */
public class AVLJacksonTest {

    private static final int TIMEOUT = 200;
    private AVL<Integer> tree;

    @Before
    public void setup() {
        tree = new AVL<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, tree.size());
        assertNull(tree.getRoot());
    }

    @Test(timeout = TIMEOUT)
    public void testConstructor() {
        /*
              1
             / \
            0   2
        */

        List<Integer> toAdd = new ArrayList<>();
        toAdd.add(1);
        toAdd.add(0);
        toAdd.add(2);
        tree = new AVL<>(toAdd);

        assertEquals(3, tree.size());

        AVLNode<Integer> root = tree.getRoot();
        assertEquals((Integer) 1, root.getData());
        assertEquals(1, root.getHeight());
        assertEquals(0, root.getBalanceFactor());
        AVLNode<Integer> left = root.getLeft();
        assertEquals((Integer) 0, left.getData());
        assertEquals(0, left.getHeight());
        assertEquals(0, left.getBalanceFactor());
        AVLNode<Integer> right = root.getRight();
        assertEquals((Integer) 2, right.getData());
        assertEquals(0, right.getHeight());
        assertEquals(0, right.getBalanceFactor());
    }

    @Test(timeout = TIMEOUT)
    public void testAdd() {
        // Right rotate
        /*
                2
               /
              1
             /
            0

            ->

              1
             / \
            0   2
         */

        tree.add(2);
        tree.add(1);
        tree.add(0);

        assertEquals(3, tree.size());

        AVLNode<Integer> root = tree.getRoot();
        assertEquals((Integer) 1, root.getData());
        assertEquals(1, root.getHeight());
        assertEquals(0, root.getBalanceFactor());
        AVLNode<Integer> left = root.getLeft();
        assertEquals((Integer) 0, left.getData());
        assertEquals(0, left.getHeight());
        assertEquals(0, left.getBalanceFactor());
        AVLNode<Integer> right = root.getRight();
        assertEquals((Integer) 2, right.getData());
        assertEquals(0, right.getHeight());
        assertEquals(0, right.getBalanceFactor());


        // Right left rotate
        /*
            0
             \
              2
             /
            1

            ->

              1
             / \
            0   2
         */

        tree = new AVL<>();
        tree.add(0);
        tree.add(2);
        tree.add(1);

        assertEquals(3, tree.size());

        assertEquals(3, tree.size());
        root = tree.getRoot();
        assertEquals((Integer) 1, root.getData());
        assertEquals(1, root.getHeight());
        assertEquals(0, root.getBalanceFactor());
        left = root.getLeft();
        assertEquals((Integer) 0, left.getData());
        assertEquals(0, left.getHeight());
        assertEquals(0, left.getBalanceFactor());
        right = root.getRight();
        assertEquals((Integer) 2, right.getData());
        assertEquals(0, right.getHeight());
        assertEquals(0, right.getBalanceFactor());

        // left rotate
        /*
            0
             \
              1
               \
                2

            ->

              1
             / \
            0   2
         */

        tree = new AVL<>();
        tree.add(0);
        tree.add(1);
        tree.add(2);

        assertEquals(3, tree.size());

        assertEquals(3, tree.size());
        root = tree.getRoot();
        assertEquals((Integer) 1, root.getData());
        assertEquals(1, root.getHeight());
        assertEquals(0, root.getBalanceFactor());
        left = root.getLeft();
        assertEquals((Integer) 0, left.getData());
        assertEquals(0, left.getHeight());
        assertEquals(0, left.getBalanceFactor());
        right = root.getRight();
        assertEquals((Integer) 2, right.getData());
        assertEquals(0, right.getHeight());
        assertEquals(0, right.getBalanceFactor());

        // left right rotate
        /*
              2
             /
            0
             \
              1

            ->

              1
             / \
            0   2
         */

        tree = new AVL<>();
        tree.add(2);
        tree.add(0);
        tree.add(1);

        assertEquals(3, tree.size());

        assertEquals(3, tree.size());
        root = tree.getRoot();
        assertEquals((Integer) 1, root.getData());
        assertEquals(1, root.getHeight());
        assertEquals(0, root.getBalanceFactor());
        left = root.getLeft();
        assertEquals((Integer) 0, left.getData());
        assertEquals(0, left.getHeight());
        assertEquals(0, left.getBalanceFactor());
        right = root.getRight();
        assertEquals((Integer) 2, right.getData());
        assertEquals(0, right.getHeight());
        assertEquals(0, right.getBalanceFactor());
    }

    @Test(timeout = TIMEOUT)
    public void testAddUnbalancedSubtree() {

        /*

                    201
                  /     \
                10      207
                 \      /
                 53   202

         */

        tree.add(201);
        tree.add(10);
        tree.add(207);
        tree.add(53);
        tree.add(202);
        assertEquals(5, tree.size());

        AVLNode<Integer> root = tree.getRoot();
        assertEquals((Integer) 201, root.getData());
        assertEquals(2, root.getHeight());
        assertEquals(0, root.getBalanceFactor());

        AVLNode<Integer> left = root.getLeft();
        assertEquals((Integer) 10, left.getData());
        assertEquals(1, left.getHeight());
        assertEquals(-1, left.getBalanceFactor());

        AVLNode<Integer> right = root.getRight();
        assertEquals((Integer) 207, right.getData());
        assertEquals(1, right.getHeight());
        assertEquals(1, right.getBalanceFactor());

        AVLNode<Integer> leftRight = left.getRight();
        assertEquals((Integer) 53, leftRight.getData());
        assertEquals(0, leftRight.getHeight());
        assertEquals(0, leftRight.getBalanceFactor());

        AVLNode<Integer> rightLeft = right.getLeft();
        assertEquals((Integer) 202, rightLeft.getData());
        assertEquals(0, rightLeft.getHeight());
        assertEquals(0, rightLeft.getBalanceFactor());

        tree.add(22);
        assertEquals(6, tree.size());

        root = tree.getRoot();
        assertEquals((Integer) 201, root.getData());
        assertEquals(2, root.getHeight());
        assertEquals(0, root.getBalanceFactor());

        left = root.getLeft();
        assertEquals((Integer) 22, left.getData());
        assertEquals(1, left.getHeight());
        assertEquals(0, left.getBalanceFactor());

        right = root.getRight();
        assertEquals((Integer) 207, right.getData());
        assertEquals(1, right.getHeight());
        assertEquals(1, right.getBalanceFactor());

        AVLNode<Integer> leftLeft = left.getLeft();
        assertEquals((Integer) 10, leftLeft.getData());
        assertEquals(0, leftLeft.getHeight());
        assertEquals(0, leftLeft.getBalanceFactor());

        leftRight = left.getRight();
        assertEquals((Integer) 53, leftRight.getData());
        assertEquals(0, leftRight.getHeight());
        assertEquals(0, leftRight.getBalanceFactor());

        rightLeft = right.getLeft();
        assertEquals((Integer) 202, rightLeft.getData());
        assertEquals(0, rightLeft.getHeight());
        assertEquals(0, rightLeft.getBalanceFactor());
    }

    @Test(timeout = TIMEOUT)
    public void testAddBalanced() {
        /*
                  4
                /   \
               1     5
              / \     \
             0   2     6
                  \
                   3
         */

        tree.add(4);
        tree.add(1);
        tree.add(5);
        tree.add(0);
        tree.add(2);
        tree.add(6);
        tree.add(3);
        assertEquals(7, tree.size());

        AVLNode<Integer> root = tree.getRoot();
        assertEquals((Integer) 4, root.getData());
        assertEquals(3, root.getHeight());
        assertEquals(1, root.getBalanceFactor());

        AVLNode<Integer> left = root.getLeft();
        assertEquals((Integer) 1, left.getData());
        assertEquals(2, left.getHeight());
        assertEquals(-1, left.getBalanceFactor());

        AVLNode<Integer> leftLeft = left.getLeft();
        assertEquals((Integer) 0, leftLeft.getData());
        assertEquals(0, leftLeft.getHeight());
        assertEquals(0, leftLeft.getBalanceFactor());

        AVLNode<Integer> leftRight = left.getRight();
        assertEquals((Integer) 2, leftRight.getData());
        assertEquals(1, leftRight.getHeight());
        assertEquals(-1, leftRight.getBalanceFactor());

        AVLNode<Integer> leftRightRight = leftRight.getRight();
        assertEquals((Integer) 3, leftRightRight.getData());
        assertEquals(0, leftRightRight.getHeight());
        assertEquals(0, leftRightRight.getBalanceFactor());

        AVLNode<Integer> right = root.getRight();
        assertEquals((Integer) 5, right.getData());
        assertEquals(1, right.getHeight());
        assertEquals(-1, right.getBalanceFactor());

        AVLNode<Integer> rightRight = right.getRight();
        assertEquals((Integer) 6, rightRight.getData());
        assertEquals(0, rightRight.getHeight());
        assertEquals(0, rightRight.getBalanceFactor());
    }

    @Test(timeout = TIMEOUT)
    public void testAddRemoveBalanced() {
        Integer temp = 1;
        /*
                  4
                /   \
               1     5
              / \     \
             0   2     6
                  \
                   3

              ->

                  4
                /   \
               1     5
              / \     \
             0   2     6
            /     \
          -1       3

              ->

                  4
                /   \
               0     5
              / \     \
            -1   2     6
                  \
                   3
         */

        tree.add(4);
        tree.add(temp);
        tree.add(5);
        tree.add(0);
        tree.add(2);
        tree.add(6);
        tree.add(3);
        assertEquals(7, tree.size());

        AVLNode<Integer> root = tree.getRoot();
        assertEquals((Integer) 4, root.getData());
        assertEquals(3, root.getHeight());
        assertEquals(1, root.getBalanceFactor());

        AVLNode<Integer> left = root.getLeft();
        assertEquals((Integer) 1, left.getData());
        assertEquals(2, left.getHeight());
        assertEquals(-1, left.getBalanceFactor());

        AVLNode<Integer> leftLeft = left.getLeft();
        assertEquals((Integer) 0, leftLeft.getData());
        assertEquals(0, leftLeft.getHeight());
        assertEquals(0, leftLeft.getBalanceFactor());

        AVLNode<Integer> leftRight = left.getRight();
        assertEquals((Integer) 2, leftRight.getData());
        assertEquals(1, leftRight.getHeight());
        assertEquals(-1, leftRight.getBalanceFactor());

        AVLNode<Integer> leftRightRight = leftRight.getRight();
        assertEquals((Integer) 3, leftRightRight.getData());
        assertEquals(0, leftRightRight.getHeight());
        assertEquals(0, leftRightRight.getBalanceFactor());

        AVLNode<Integer> right = root.getRight();
        assertEquals((Integer) 5, right.getData());
        assertEquals(1, right.getHeight());
        assertEquals(-1, right.getBalanceFactor());

        AVLNode<Integer> rightRight = right.getRight();
        assertEquals((Integer) 6, rightRight.getData());
        assertEquals(0, rightRight.getHeight());
        assertEquals(0, rightRight.getBalanceFactor());

        tree.add(-1);
        assertEquals(8, tree.size());

        root = tree.getRoot();
        assertEquals((Integer) 4, root.getData());
        assertEquals(3, root.getHeight());
        assertEquals(1, root.getBalanceFactor());

        left = root.getLeft();
        assertEquals((Integer) 1, left.getData());
        assertEquals(2, left.getHeight());
        assertEquals(0, left.getBalanceFactor());

        leftLeft = left.getLeft();
        assertEquals((Integer) 0, leftLeft.getData());
        assertEquals(1, leftLeft.getHeight());
        assertEquals(1, leftLeft.getBalanceFactor());

        AVLNode<Integer> leftLeftLeft = leftLeft.getLeft();
        assertEquals((Integer) (-1), leftLeftLeft.getData());
        assertEquals(0, leftLeftLeft.getHeight());
        assertEquals(0, leftLeftLeft.getBalanceFactor());

        leftRight = left.getRight();
        assertEquals((Integer) 2, leftRight.getData());
        assertEquals(1, leftRight.getHeight());
        assertEquals(-1, leftRight.getBalanceFactor());

        leftRightRight = leftRight.getRight();
        assertEquals((Integer) 3, leftRightRight.getData());
        assertEquals(0, leftRightRight.getHeight());
        assertEquals(0, leftRightRight.getBalanceFactor());

        right = root.getRight();
        assertEquals((Integer) 5, right.getData());
        assertEquals(1, right.getHeight());
        assertEquals(-1, right.getBalanceFactor());

        rightRight = right.getRight();
        assertEquals((Integer) 6, rightRight.getData());
        assertEquals(0, rightRight.getHeight());
        assertEquals(0, rightRight.getBalanceFactor());

        assertSame(temp, tree.remove(1));
        assertEquals(7, tree.size());
        assertEquals(3, tree.height());

        root = tree.getRoot();
        assertEquals((Integer) 4, root.getData());
        assertEquals(3, root.getHeight());
        assertEquals(1, root.getBalanceFactor());

        left = root.getLeft();
        assertEquals((Integer) 0, left.getData());
        assertEquals(2, left.getHeight());
        assertEquals(-1, left.getBalanceFactor());

        leftLeft = left.getLeft();
        assertEquals((Integer) (-1), leftLeft.getData());
        assertEquals(0, leftLeft.getHeight());
        assertEquals(0, leftLeft.getBalanceFactor());

        leftRight = left.getRight();
        assertEquals((Integer) 2, leftRight.getData());
        assertEquals(1, leftRight.getHeight());
        assertEquals(-1, leftRight.getBalanceFactor());

        leftRightRight = leftRight.getRight();
        assertEquals((Integer) 3, leftRightRight.getData());
        assertEquals(0, leftRightRight.getHeight());
        assertEquals(0, leftRightRight.getBalanceFactor());

        right = root.getRight();
        assertEquals((Integer) 5, right.getData());
        assertEquals(1, right.getHeight());
        assertEquals(-1, right.getBalanceFactor());

        rightRight = right.getRight();
        assertEquals((Integer) 6, rightRight.getData());
        assertEquals(0, rightRight.getHeight());
        assertEquals(0, rightRight.getBalanceFactor());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveRotateSubtree() {
        Integer temp = 5;

        /*
                    6
                  /   \
                 3     7
                / \     \
               1   5     9
              /
             0

             ->

                    6
                  /   \
                 1     7
                / \     \
               0   3     9
         */

        tree.add(6);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(temp);
        tree.add(9);
        tree.add(0);
        assertEquals(7, tree.size());

        AVLNode<Integer> root = tree.getRoot();
        assertEquals((Integer) 6, root.getData());
        assertEquals(3, root.getHeight());
        assertEquals(1, root.getBalanceFactor());

        AVLNode<Integer> left = root.getLeft();
        assertEquals((Integer) 3, left.getData());
        assertEquals(2, left.getHeight());
        assertEquals(1, left.getBalanceFactor());

        AVLNode<Integer> leftLeft = left.getLeft();
        assertEquals((Integer) 1, leftLeft.getData());
        assertEquals(1, leftLeft.getHeight());
        assertEquals(1, leftLeft.getBalanceFactor());

        AVLNode<Integer> leftLeftLeft = leftLeft.getLeft();
        assertEquals((Integer) 0, leftLeftLeft.getData());
        assertEquals(0, leftLeftLeft.getHeight());
        assertEquals(0, leftLeftLeft.getBalanceFactor());

        AVLNode<Integer> leftRight = left.getRight();
        assertEquals((Integer) 5, leftRight.getData());
        assertEquals(0, leftRight.getHeight());
        assertEquals(0, leftRight.getBalanceFactor());

        AVLNode<Integer> right = root.getRight();
        assertEquals((Integer) 7, right.getData());
        assertEquals(1, right.getHeight());
        assertEquals(-1, right.getBalanceFactor());

        AVLNode<Integer> rightRight = right.getRight();
        assertEquals((Integer) 9, rightRight.getData());
        assertEquals(0, rightRight.getHeight());
        assertEquals(0, rightRight.getBalanceFactor());

        assertSame(temp, tree.remove(5));
        assertEquals(6, tree.size());

        root = tree.getRoot();
        assertEquals((Integer) 6, root.getData());
        assertEquals(2, root.getHeight());
        assertEquals(0, root.getBalanceFactor());

        left = root.getLeft();
        assertEquals((Integer) 1, left.getData());
        assertEquals(1, left.getHeight());
        assertEquals(0, left.getBalanceFactor());

        leftLeft = left.getLeft();
        assertEquals((Integer) 0, leftLeft.getData());
        assertEquals(0, leftLeft.getHeight());
        assertEquals(0, leftLeft.getBalanceFactor());

        leftRight = left.getRight();
        assertEquals((Integer) 3, leftRight.getData());
        assertEquals(0, leftRight.getHeight());
        assertEquals(0, leftRight.getBalanceFactor());

        right = root.getRight();
        assertEquals((Integer) 7, right.getData());
        assertEquals(1, right.getHeight());
        assertEquals(-1, right.getBalanceFactor());

        rightRight = right.getRight();
        assertEquals((Integer) 9, rightRight.getData());
        assertEquals(0, rightRight.getHeight());
        assertEquals(0, rightRight.getBalanceFactor());
    }

    @Test(timeout = TIMEOUT)
    public void testRemovePredecessorUpdateHeight() {
        Integer temp = -352;

        /*
                  -109
                 /     \
              -352     169
             /   \        \
          -960  -161      261
             \
            -944

            ->

                  -109
                 /     \
              -944     169
             /   \        \
          -960  -161      261
         */


        tree.add(-109);
        tree.add(temp);
        tree.add(169);
        tree.add(-960);
        tree.add(-161);
        tree.add(261);
        tree.add(-944);
        assertEquals(7, tree.size());

        assertSame(temp, tree.remove(-352));
        assertEquals(6, tree.size());
        AVLNode<Integer> root = tree.getRoot();
        assertEquals((Integer) (-109), root.getData());
        assertEquals(2, root.getHeight());
        assertEquals(0, root.getBalanceFactor());
        AVLNode<Integer> left = root.getLeft();
        assertEquals((Integer) (-944), left.getData());
        assertEquals(1, left.getHeight());
        assertEquals(0, left.getBalanceFactor());
    }

    @Test(timeout = TIMEOUT)
    public void testRemove() {
        Integer temp = 1;

        /*
                  3
                /   \
              1      4
             / \
            0   2

            ->

                3
              /   \
            0      4
             \
              2
         */


        tree.add(3);
        tree.add(temp);
        tree.add(4);
        tree.add(0);
        tree.add(2);
        assertEquals(5, tree.size());

        assertSame(temp, tree.remove(1));
        assertEquals(4, tree.size());
        AVLNode<Integer> root = tree.getRoot();
        assertEquals((Integer) 3, root.getData());
        assertEquals(2, root.getHeight());
        assertEquals(1, root.getBalanceFactor());
        AVLNode<Integer> left = root.getLeft();
        assertEquals((Integer) 0, left.getData());
        assertEquals(1, left.getHeight());
        assertEquals(-1, left.getBalanceFactor());
        AVLNode<Integer> right = root.getRight();
        assertEquals((Integer) 4, right.getData());
        assertEquals(0, right.getHeight());
        assertEquals(0, right.getBalanceFactor());
        AVLNode<Integer> leftRight = left.getRight();
        assertEquals((Integer) 2, leftRight.getData());
        assertEquals(0, leftRight.getHeight());
        assertEquals(0, leftRight.getBalanceFactor());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveUnbalanced() {
        Integer temp = 5;

        /*
                  4
                /   \
              1      5
             / \      \
            0   2      6
                 \
                  3

            ->

                4
              /   \
             1     6
            / \
           0   2
                \
                 3

            ->

                2
              /   \
             1     4
            /     / \
           0     3   6

         */


        tree.add(4);
        tree.add(1);
        tree.add(temp);
        tree.add(0);
        tree.add(2);
        tree.add(6);
        tree.add(3);
        assertEquals(7, tree.size());

        assertSame(temp, tree.remove(5));
        assertEquals(6, tree.size());

        AVLNode<Integer> root = tree.getRoot();
        assertEquals((Integer) 2, root.getData());
        assertEquals(2, root.getHeight());
        assertEquals(0, root.getBalanceFactor());

        AVLNode<Integer> left = root.getLeft();
        assertEquals((Integer) 1, left.getData());
        assertEquals(1, left.getHeight());
        assertEquals(1, left.getBalanceFactor());

        AVLNode<Integer> leftLeft = left.getLeft();
        assertEquals((Integer) 0, leftLeft.getData());
        assertEquals(0, leftLeft.getHeight());
        assertEquals(0, leftLeft.getBalanceFactor());

        AVLNode<Integer> right = root.getRight();
        assertEquals((Integer) 4, right.getData());
        assertEquals(1, right.getHeight());
        assertEquals(0, right.getBalanceFactor());

        AVLNode<Integer> rightLeft = right.getLeft();
        assertEquals((Integer) 3, rightLeft.getData());
        assertEquals(0, rightLeft.getHeight());
        assertEquals(0, rightLeft.getBalanceFactor());

        AVLNode<Integer> rightRight = right.getRight();
        assertEquals((Integer) 6, rightRight.getData());
        assertEquals(0, rightRight.getHeight());
        assertEquals(0, rightRight.getBalanceFactor());
    }

    @Test(timeout = TIMEOUT)
    public void testGet() {
        Integer temp1 = 1;
        Integer temp0 = 0;
        Integer temp2 = 2;
        Integer temp3 = 3;

        /*
               1
             /   \
            0     2
                    \
                     3
         */

        tree.add(temp1);
        tree.add(temp0);
        tree.add(temp2);
        tree.add(temp3);
        assertEquals(4, tree.size());

        // We want to make sure the data we retrieve is the one from the tree,
        // not the data that was passed in.
        assertSame(temp0, tree.get(0));
        assertSame(temp1, tree.get(1));
        assertSame(temp2, tree.get(2));
        assertSame(temp3, tree.get(3));
    }

    @Test(timeout = TIMEOUT)
    public void testContains() {
        /*
               1
             /   \
            0     2
                    \
                     3
         */

        tree.add(1);
        tree.add(0);
        tree.add(2);
        tree.add(3);
        assertEquals(4, tree.size());

        assertTrue(tree.contains(0));
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));
    }

    @Test(timeout = TIMEOUT)
    public void testHeight() {
        /*
                     3
                   /   \
                 1      4
                / \
               0   2
         */

        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(0);
        tree.add(2);

        assertEquals(2, tree.height());
    }

    @Test(timeout = TIMEOUT)
    public void testClear() {
        /*
              1
             / \
            0   2
        */

        List<Integer> toAdd = new ArrayList<>();
        toAdd.add(1);
        toAdd.add(0);
        toAdd.add(2);
        tree = new AVL<>(toAdd);

        tree.clear();
        assertEquals(0, tree.size());
        assertNull(tree.getRoot());
    }

    @Test(timeout = TIMEOUT)
    public void testWordSearch() {
        AVL<String> letterTree = new AVL<>();

        String g = new String("g");
        String e = new String("e");
        String i = new String("i");
        String b = new String("b");
        String f = new String("f");
        String h = new String("h");
        String n = new String("n");

        /*
                g
              /   \
             e     i
            / \   / \
           b   f h   n
        */

        letterTree.add(g);
        letterTree.add(e);
        letterTree.add(i);
        letterTree.add(b);
        letterTree.add(f);
        letterTree.add(h);
        letterTree.add(n);
        assertEquals(7, letterTree.size());

        String[] word = new String[] {"b", "e", "g", "i", "n"};
        List<String> path = letterTree.wordSearch(word);
        assertEquals(5, path.size());

        // We want to ensure that the letters we retrieve are from the tree,
        // not from the word array that was passed in.
        assertSame(b, path.get(0));
        assertSame(e, path.get(1));
        assertSame(g, path.get(2));
        assertSame(i, path.get(3));
        assertSame(n, path.get(4));

        // test maintained order
        letterTree.clear();

        /*
                g
              /   \
             e     i
            / \   / \
           b   f h   n
        */

        letterTree.add(g);
        letterTree.add(e);
        letterTree.add(i);
        letterTree.add(b);
        letterTree.add(f);
        letterTree.add(h);
        letterTree.add(n);
        assertEquals(7, letterTree.size());

        word = new String[] {"n", "i", "g", "e", "b"};
        path = letterTree.wordSearch(word);
        assertEquals(5, path.size());

        // We want to ensure that the letters we retrieve are from the tree,
        // not from the word array that was passed in.
        assertSame(n, path.get(0));
        assertSame(i, path.get(1));
        assertSame(g, path.get(2));
        assertSame(e, path.get(3));
        assertSame(b, path.get(4));

        // test deepest common ancestor
        letterTree.clear();

        /*
                g
              /   \
             e     i
            / \   / \
           b   f h   n
        */

        letterTree.add(g);
        letterTree.add(e);
        letterTree.add(i);
        letterTree.add(b);
        letterTree.add(f);
        letterTree.add(h);
        letterTree.add(n);
        assertEquals(7, letterTree.size());

        word = new String[] {"b", "e", "f"};
        path = letterTree.wordSearch(word);
        assertEquals(3, path.size());

        // We want to ensure that the letters we retrieve are from the tree,
        // not from the word array that was passed in.
        assertSame(b, path.get(0));
        assertSame(e, path.get(1));
        assertSame(f, path.get(2));

        // test first letter equal to dca
        letterTree.clear();

        /*
                g
              /   \
             e     i
            / \   / \
           b   f h   n
        */

        letterTree.add(g);
        letterTree.add(e);
        letterTree.add(i);
        letterTree.add(b);
        letterTree.add(f);
        letterTree.add(h);
        letterTree.add(n);
        assertEquals(7, letterTree.size());

        word = new String[] {"g", "i", "n"};
        path = letterTree.wordSearch(word);
        assertEquals(3, path.size());

        // We want to ensure that the letters we retrieve are from the tree,
        // not from the word array that was passed in.
        assertSame(g, path.get(0));
        assertSame(i, path.get(1));
        assertSame(n, path.get(2));

        // test last letter equal to dca
        letterTree.clear();

        /*
                g
              /   \
             e     i
            / \   / \
           b   f h   n
        */

        letterTree.add(g);
        letterTree.add(e);
        letterTree.add(i);
        letterTree.add(b);
        letterTree.add(f);
        letterTree.add(h);
        letterTree.add(n);
        assertEquals(7, letterTree.size());

        word = new String[] {"h", "i"};
        path = letterTree.wordSearch(word);
        assertEquals(2, path.size());

        // We want to ensure that the letters we retrieve are from the tree,
        // not from the word array that was passed in.
        assertSame(h, path.get(0));
        assertSame(i, path.get(1));

        word = new String[] {"b", "e", "g"};
        path = letterTree.wordSearch(word);
        assertEquals(3, path.size());

        // We want to ensure that the letters we retrieve are from the tree,
        // not from the word array that was passed in.
        assertSame(b, path.get(0));
        assertSame(e, path.get(1));
        assertSame(g, path.get(2));

        // test word 0 length input

        word = new String[0];
        path = letterTree.wordSearch(word);
        assertEquals(0, path.size());

        // test only input dca

        word = new String[] {"g"};
        path = letterTree.wordSearch(word);
        assertEquals(1, path.size());

        // We want to ensure that the letters we retrieve are from the tree,
        // not from the word array that was passed in.
        assertSame(g, path.get(0));

        word = new String[] {"f"};
        path = letterTree.wordSearch(word);
        assertEquals(1, path.size());

        // We want to ensure that the letters we retrieve are from the tree,
        // not from the word array that was passed in.
        assertSame(f, path.get(0));
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testWordNotInTree() {
        AVL<String> letterTree = new AVL<>();

        String g = new String("g");
        String e = new String("e");
        String i = new String("i");
        String b = new String("b");
        String f = new String("f");
        String h = new String("h");
        String n = new String("n");

        /*
                g
              /   \
             e     i
            / \   / \
           b   f h   n
        */

        letterTree.add(g);
        letterTree.add(e);
        letterTree.add(i);
        letterTree.add(b);
        letterTree.add(f);
        letterTree.add(h);
        letterTree.add(n);
        assertEquals(7, letterTree.size());

        String[] word = new String[] {"f", "e", "g", "i", "h"};
        List<String> path = letterTree.wordSearch(word);
        assertEquals(5, path.size());

        // We want to ensure that the letters we retrieve are from the tree,
        // not from the word array that was passed in.
        assertSame(f, path.get(0));
        assertSame(e, path.get(1));
        assertSame(g, path.get(2));
        assertSame(i, path.get(3));
        assertSame(h, path.get(4));

        word = new String[] {"a"};
        path = letterTree.wordSearch(word);
        assertEquals(1, path.size());
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testObstructedWordPath() {
        AVL<String> letterTree = new AVL<>();

        String g = new String("g");
        String e = new String("e");
        String i = new String("i");
        String b = new String("b");
        String f = new String("f");
        String h = new String("h");
        String n = new String("n");

        /*
                g
              /   \
             e     i
            / \   / \
           b   f h   n
        */

        letterTree.add(g);
        letterTree.add(e);
        letterTree.add(i);
        letterTree.add(b);
        letterTree.add(f);
        letterTree.add(h);
        letterTree.add(n);
        assertEquals(7, letterTree.size());

        String[] word = new String[] {"n", "i", "b"};
        List<String> path = letterTree.wordSearch(word);
        assertEquals(3, path.size());
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testIncorrectWordPath() {
        AVL<String> letterTree = new AVL<>();

        String g = new String("g");
        String e = new String("e");
        String i = new String("i");
        String b = new String("b");
        String f = new String("f");
        String h = new String("h");
        String n = new String("n");

        /*
                g
              /   \
             e     i
            / \   / \
           b   f h   n
        */

        letterTree.add(g);
        letterTree.add(e);
        letterTree.add(i);
        letterTree.add(b);
        letterTree.add(f);
        letterTree.add(h);
        letterTree.add(n);
        assertEquals(7, letterTree.size());

        String[] word = new String[] {"b", "e", "j", "i", "n"};
        List<String> path = letterTree.wordSearch(word);
        assertEquals(5, path.size());
    }

}