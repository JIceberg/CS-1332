import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Jeonghoon Lee
 * @version 1.0
 */
@SuppressWarnings("CheckStyle")
public class BSTJeonghoonTest {

    private static final int TIMEOUT = 200;
    private BST<Integer> tree;

    @Before
    public void setup() {
        tree = new BST<>();
    }

    @Test(timeout = TIMEOUT)
    public void testConstructor() {
        assertNull(tree.getRoot());
        assertEquals(0, tree.size());

        /*
              1
        */
        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        tree = new BST<>(testList);
        assertEquals(1, tree.size());
        assertEquals((Integer) 1, tree.getRoot().getData());
        assertNull(tree.getRoot().getLeft());
        assertNull(tree.getRoot().getRight());

        /*
              1
               \
                2
        */
        testList.add(2);
        tree = new BST<>(testList);
        assertEquals(2, tree.size());
        assertEquals((Integer) 1, tree.getRoot().getData());
        assertEquals((Integer) 2, tree.getRoot().getRight().getData());
        assertNull(tree.getRoot().getLeft());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight());


        /*
              1
             / \
            0   2
        */

        testList.add(0);
        tree = new BST<>(testList);
        assertEquals(3, tree.size());
        assertEquals((Integer) 1, tree.getRoot().getData());
        assertEquals((Integer) 2, tree.getRoot().getRight().getData());
        assertEquals((Integer) 0, tree.getRoot().getLeft().getData());
        assertNull(tree.getRoot().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight());

        /*
              1
             / \
            0   2
           /     \
         -1       4
                 / \
                3   5
        */
        testList.add(-1);
        testList.add(4);
        testList.add(3);
        testList.add(5);
        tree = new BST<>(testList);
        assertEquals(7, tree.size());
        assertEquals((Integer) 1, tree.getRoot().getData());
        assertEquals((Integer) 2, tree.getRoot().getRight().getData());
        assertEquals((Integer) 0, tree.getRoot().getLeft().getData());
        assertEquals((Integer) (-1), tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 4, tree.getRoot().getRight().getRight().getData());
        assertEquals((Integer) 3, tree.getRoot().getRight().getRight().getLeft().getData());
        assertEquals((Integer) 5, tree.getRoot().getRight().getRight().getRight().getData());
        assertNull(tree.getRoot().getLeft().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getLeft().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getRight().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getRight().getRight());

    }
    @Test(timeout = TIMEOUT)
    public void testConstructorException() {
        try {
            tree = new BST<>(null);
            fail();
        } catch (IllegalArgumentException e) {
        }
        // if data is null.

        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(null);

        try {
            tree = new BST<>(testList);
            fail();
        } catch (IllegalArgumentException e) {
        }
        //if any element in data is null (1, 2, 3, null)
    }

    @Test(timeout = TIMEOUT)
    public void testAdd() {

        /*
              10
        */
        tree.add(10);
        assertEquals((Integer) 10, tree.getRoot().getData());
        assertEquals(1, tree.size());
        assertNull(tree.getRoot().getLeft());
        assertNull(tree.getRoot().getRight());

        /*
              10
             /
            9
        */
        tree.add(9);
        assertEquals((Integer) 10, tree.getRoot().getData());
        assertEquals((Integer) 9, tree.getRoot().getLeft().getData());
        assertEquals(2, tree.size());
        assertNull(tree.getRoot().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getRight());
        assertNull(tree.getRoot().getRight());


        /*
              10
             /  \
            9   11
        */

        tree.add(11);
        assertEquals((Integer) 10, tree.getRoot().getData());
        assertEquals((Integer) 9, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 11, tree.getRoot().getRight().getData());
        assertEquals(3, tree.size());
        assertNull(tree.getRoot().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight());

        //Test: if insert same data as exist.

        /*
              10
             /  \
            9   11
        */

        tree.add(11);
        assertEquals((Integer) 10, tree.getRoot().getData());
        assertEquals((Integer) 9, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 11, tree.getRoot().getRight().getData());
        assertEquals(3, tree.size());
        assertNull(tree.getRoot().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight());




        /*
              10
             /  \
            9   11
           /      \
          5       15
         /\       /\
        3  7     12 17
           /      \
          6       14
        */

        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(6);
        tree.add(15);
        tree.add(12);
        tree.add(14);
        tree.add(17);

        assertEquals((Integer) 10, tree.getRoot().getData());
        assertEquals((Integer) 9, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 11, tree.getRoot().getRight().getData());
        assertEquals((Integer) 5, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 15, tree.getRoot().getRight().getRight().getData());
        assertEquals((Integer) 3, tree.getRoot().getLeft().getLeft().getLeft().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getLeft().getRight().getData());
        assertEquals((Integer) 12, tree.getRoot().getRight().getRight().getLeft().getData());
        assertEquals((Integer) 17, tree.getRoot().getRight().getRight().getRight().getData());
        assertEquals((Integer) 6, tree.getRoot().getLeft().getLeft().getRight().getLeft().getData());
        assertEquals((Integer) 14, tree.getRoot().getRight().getRight().getLeft().getRight().getData());

        assertEquals(11, tree.size());


        assertNull(tree.getRoot().getLeft().getLeft().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getRight());
        assertNull(tree.getRoot().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getLeft().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getLeft().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getLeft().getRight().getRight());
        assertNull(tree.getRoot().getRight().getRight().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getRight().getRight());

    }

    @Test(timeout = TIMEOUT)
    public void testAddException() {
        try {
            tree.add(null);
            //WE ASSUME THAT ADD METHOD WORKS PROPERLY.
            fail();
        } catch (IllegalArgumentException e) {
        }
        // if data is null.
    }

    @Test(timeout = TIMEOUT)
    public void testRemove() {

        /*
              10
             /  \
            9   11
           /      \
          5       15
         /\       /\
        3  7     12 17
           /      \
          6       14
        */
        Integer i10 = 10;
        Integer i9 = 9;
        Integer i11 = 11;
        Integer i5 = 5;
        Integer i3 = 3;
        Integer i7 = 7;
        Integer i6 = 6;
        Integer i15 = 15;
        Integer i12 = 12;
        Integer i13 = 13;
        Integer i14 = 14;
        Integer i17 = 17;
        Integer ii10 = 10;
        Integer ii9 = 9;
        Integer ii11 = 11;
        Integer ii5 = 5;
        Integer ii3 = 3;
        Integer ii7 = 7;
        Integer ii6 = 6;
        Integer ii15 = 15;
        Integer ii12 = 12;
        Integer ii13 = 13;
        Integer ii14 = 14;
        Integer ii17 = 17;
        tree.add(i10);
        tree.add(i9);
        tree.add(i11);
        tree.add(i5);
        tree.add(i3);
        tree.add(i7);
        tree.add(i6);
        tree.add(i15);
        tree.add(i12);
        tree.add(i14);
        tree.add(i17);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.

        /*
         * There are 3 cases to consider:
         * 1: The node containing the data is a leaf (no children). In this case,
         * simply remove it.
         * 2: The node containing the data has one child. In this case, simply
         * replace it with its child.
         * 3: The node containing the data has 2 children. Use the successor to
         * replace the data. You MUST use recursion to find and remove the
         * successor (you will likely need an additional helper method to
         * handle this case efficiently).
         */

        // case 1
        //The node containing the data is a leaf (no children).
        //In this case, simply remove it.


        /*
              10
             /  \
            9   11
           /      \
          5       15
         /\       /\
        3  7     12 17
           /      \
          6      (14) <-- will remove.
              10
             /  \
            9   11
           /      \
          5       15
         /\       /\
        3  7     12 17
           /
          6
        */


        assertSame(i14, tree.remove(ii14));
        /*
         * Do not return the same data that was passed in. Return the data that
         * was stored in the tree. (In JAVADOCS)
         */

        assertEquals((Integer) 10, tree.getRoot().getData());
        assertEquals((Integer) 9, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 11, tree.getRoot().getRight().getData());
        assertEquals((Integer) 5, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 15, tree.getRoot().getRight().getRight().getData());
        assertEquals((Integer) 3, tree.getRoot().getLeft().getLeft().getLeft().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getLeft().getRight().getData());
        assertEquals((Integer) 12, tree.getRoot().getRight().getRight().getLeft().getData());
        assertEquals((Integer) 17, tree.getRoot().getRight().getRight().getRight().getData());
        assertEquals((Integer) 6, tree.getRoot().getLeft().getLeft().getRight().getLeft().getData());

        assertEquals(10, tree.size());


        assertNull(tree.getRoot().getLeft().getLeft().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getRight());
        assertNull(tree.getRoot().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getLeft().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getRight().getRight());
        assertNull(tree.getRoot().getRight().getRight().getLeft().getRight());


        // case 2 (Right)
        //The node containing the data has one child.
        //In this case, simply replace it with its child.


        /*
              10
             /  \
            9   11 <-- will remove.
           /      \
          5       15
         /\       /\
        3  7     12 17
           /
          6
                       10
                      /  \
                     9   15
                    /    /\
                   5    12 17
                  /\
                 3  7
                   /
                  6
        */

        assertSame(i11, tree.remove(ii11));
        /*
         * Do not return the same data that was passed in. Return the data that
         * was stored in the tree. (In JAVADOCS)
         */

        assertEquals((Integer) 10, tree.getRoot().getData());
        assertEquals((Integer) 9, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 15, tree.getRoot().getRight().getData());
        assertEquals((Integer) 5, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 3, tree.getRoot().getLeft().getLeft().getLeft().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getLeft().getRight().getData());
        assertEquals((Integer) 6, tree.getRoot().getLeft().getLeft().getRight().getLeft().getData());
        assertEquals((Integer) 12, tree.getRoot().getRight().getLeft().getData());
        assertEquals((Integer) 17, tree.getRoot().getRight().getRight().getData());

        assertEquals(9, tree.size());


        assertNull(tree.getRoot().getLeft().getLeft().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getRight());
        assertNull(tree.getRoot().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getLeft().getLeft());
        assertNull(tree.getRoot().getRight().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getRight());


        // case 3
        //The node containing the data has 2 children. Use the successor to
        //replace the data. You MUST use recursion to find and remove the
        //successor (you will likely need an additional helper method to
        //handle this case efficiently).

        //Have Question about successor, please see @505 Piazza Post.
        //Instructor comment that
        //"Correct, an element's successor is the smallest data that is larger than it."


        /*
                       10
                      /  \
                     9   15
                    /    /\
     will remove ->5    12 17
                  /\
                 3  7
                   /
                 (6)
                       10
                      /  \
                     9   15
                    /    /\
                   6    12 17
                  /\
                 3  7
        */

        assertSame(i5, tree.remove(ii5));
        /*
         * Do not return the same data that was passed in. Return the data that
         * was stored in the tree. (In JAVADOCS)
         */

        assertEquals((Integer) 10, tree.getRoot().getData());
        assertEquals((Integer) 9, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 15, tree.getRoot().getRight().getData());
        assertEquals((Integer) 6, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 3, tree.getRoot().getLeft().getLeft().getLeft().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getLeft().getRight().getData());
        assertEquals((Integer) 12, tree.getRoot().getRight().getLeft().getData());
        assertEquals((Integer) 17, tree.getRoot().getRight().getRight().getData());

        assertEquals(8, tree.size());


        assertNull(tree.getRoot().getLeft().getLeft().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getRight());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getLeft());
        assertNull(tree.getRoot().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getLeft().getLeft());
        assertNull(tree.getRoot().getRight().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getRight());

        //Let's make it more harder. (CASE3)
        // case 3
        //The node containing the data has 2 children. Use the successor to
        //replace the data. You MUST use recursion to find and remove the
        //successor (you will likely need an additional helper method to
        //handle this case efficiently).

        //Have Question about successor, please see @505 Piazza Post.
        //Instructor comment that
        //"Correct, an element's successor is the smallest data that is larger than it."
        /*
                       10
                      /  \
                     9   15
                    /    /\
                   6    12 17
                  /\
                 3  7
                   to
                       10
                      /  \
                     9   15
                    /    /\
                   6    12 17
                  /\     \
                 3  7     13 <-- add
        */

        tree.add(i13);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.

        /*
                       10 < will remove this.
                      /  \
                     9   15
                    /    /\
                   6   (12) 17
                  /\     \
                 3  7     13
                 result will be
                       12
                      /  \
                     9   15
                    /    /\
                   6    13 17
                  /\
                 3  7
         */
        //test
        assertSame(i10, tree.remove(ii10));
        /*
         * Do not return the same data that was passed in. Return the data that
         * was stored in the tree. (In JAVADOCS)
         */

        assertEquals((Integer) 12, tree.getRoot().getData());
        assertEquals((Integer) 9, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 15, tree.getRoot().getRight().getData());
        assertEquals((Integer) 6, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 3, tree.getRoot().getLeft().getLeft().getLeft().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getLeft().getRight().getData());
        assertEquals((Integer) 13, tree.getRoot().getRight().getLeft().getData());
        assertEquals((Integer) 17, tree.getRoot().getRight().getRight().getData());

        assertEquals(8, tree.size());


        assertNull(tree.getRoot().getLeft().getLeft().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getRight());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getLeft());
        assertNull(tree.getRoot().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getLeft().getLeft());
        assertNull(tree.getRoot().getRight().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getRight());

        // case 3
        //The node containing the data has 2 children. Use the successor to
        //replace the data. You MUST use recursion to find and remove the
        //successor (you will likely need an additional helper method to
        //handle this case efficiently).

        //Have Question about successor()'s behavior, please see @505 Piazza Post.
        //Instructor comment that
        //"Correct, an element's successor is the smallest data that is larger than it."
        /*
                       12 < will remove this.
                      /  \
                     9   15
                    /    /\
                   6    13 17
                  /\
                 3  7
                 result will be
                       13
                      /  \
                     9   15
                    /     \
                   6      17
                  /\
                 3  7
         */
        assertSame(i12, tree.remove(ii12));
        /*
         * Do not return the same data that was passed in. Return the data that
         * was stored in the tree. (In JAVADOCS)
         */

        assertEquals((Integer) 13, tree.getRoot().getData());
        assertEquals((Integer) 9, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 15, tree.getRoot().getRight().getData());
        assertEquals((Integer) 6, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 3, tree.getRoot().getLeft().getLeft().getLeft().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getLeft().getRight().getData());
        assertEquals((Integer) 17, tree.getRoot().getRight().getRight().getData());

        assertEquals(7, tree.size());


        assertNull(tree.getRoot().getLeft().getLeft().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getRight());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getLeft());
        assertNull(tree.getRoot().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getRight());


        // case 2 (Left)
        //The node containing the data has one child.
        //In this case, simply replace it with its child.
        /*
                       13
                      /  \
     will remove ->  9   15
                    /     \
                   6      17
                  /\
                 3  7
                 result will be
                       13
                      /  \
                     6   15
                    /\     \
                   3  7    17
         */
        assertSame(i9, tree.remove(ii9));
        /*
         * Do not return the same data that was passed in. Return the data that
         * was stored in the tree. (In JAVADOCS)
         */

        assertEquals((Integer) 13, tree.getRoot().getData());
        assertEquals((Integer) 6, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 15, tree.getRoot().getRight().getData());
        assertEquals((Integer) 3, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getRight().getData());
        assertEquals((Integer) 17, tree.getRoot().getRight().getRight().getData());

        assertEquals(6, tree.size());


        assertNull(tree.getRoot().getLeft().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getRight().getLeft());
        assertNull(tree.getRoot().getLeft().getRight().getRight());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getRight());

        // case 3
        //The node containing the data has 2 children. Use the successor to
        //replace the data. You MUST use recursion to find and remove the
        //successor (you will likely need an additional helper method to
        //handle this case efficiently).

        //Have Question about successor()'s behavior, please see @505 Piazza Post.
        //Instructor comment that
        //"Correct, an element's successor is the smallest data that is larger than it."

        /*
        will remove -> 13
                      /  \
                     6   15
                    /\     \
                   3  7    17
                 result will be
                       15
                      /  \
                     6   17
                    /\
                   3  7
         */
        assertSame(i13, tree.remove(ii13));
        /*
         * Do not return the same data that was passed in. Return the data that
         * was stored in the tree. (In JAVADOCS)
         */

        assertEquals((Integer) 15, tree.getRoot().getData());
        assertEquals((Integer) 6, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 17, tree.getRoot().getRight().getData());
        assertEquals((Integer) 3, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getRight().getData());

        assertEquals(5, tree.size());

        assertNull(tree.getRoot().getLeft().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getRight().getLeft());
        assertNull(tree.getRoot().getLeft().getRight().getRight());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight());


        // case 3
        //The node containing the data has 2 children. Use the successor to
        //replace the data. You MUST use recursion to find and remove the
        //successor (you will likely need an additional helper method to
        //handle this case efficiently).

        //Have Question about successor()'s behavior, please see @505 Piazza Post.
        //Instructor comment that
        //"Correct, an element's successor is the smallest data that is larger than it."

        /*
         will remove-> 15
                      /  \
                     6   17
                    /\
                   3  7
                 result will be
                       17
                      /
                     6
                    /\
                   3  7
         */
        assertSame(i15, tree.remove(ii15));
        /*
         * Do not return the same data that was passed in. Return the data that
         * was stored in the tree. (In JAVADOCS)
         */

        assertEquals((Integer) 17, tree.getRoot().getData());
        assertEquals((Integer) 6, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 3, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getRight().getData());

        assertEquals(4, tree.size());

        assertNull(tree.getRoot().getLeft().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getRight().getLeft());
        assertNull(tree.getRoot().getLeft().getRight().getRight());
        assertNull(tree.getRoot().getRight());

        // case 3
        //The node containing the data has 2 children. Use the successor to
        //replace the data. You MUST use recursion to find and remove the
        //successor (you will likely need an additional helper method to
        //handle this case efficiently).

        //Have Question about successor()'s behavior, please see @505 Piazza Post.
        //Instructor comment that
        //"Correct, an element's successor is the smallest data that is larger than it."

        /*
                       17
                      /
        will remove->6
                    /\
                   3  7
                 result will be
                       17
                      /
                     7
                    /
                   3
         */
        assertSame(i6, tree.remove(ii6));
        /*
         * Do not return the same data that was passed in. Return the data that
         * was stored in the tree. (In JAVADOCS)
         */

        assertEquals((Integer) 17, tree.getRoot().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 3, tree.getRoot().getLeft().getLeft().getData());

        assertEquals(3, tree.size());

        assertNull(tree.getRoot().getLeft().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getRight());
        assertNull(tree.getRoot().getRight());

        // case 2 (Left)
        //The node containing the data has one child.
        //In this case, simply replace it with its child.
        /*
                       17
                      /
        will remove->7
                    /
                   3
                 result will be
                       17
                      /
                     3
         */
        assertSame(i7, tree.remove(ii7));
        /*
         * Do not return the same data that was passed in. Return the data that
         * was stored in the tree. (In JAVADOCS)
         */

        assertEquals((Integer) 17, tree.getRoot().getData());
        assertEquals((Integer) 3, tree.getRoot().getLeft().getData());

        assertEquals(2, tree.size());

        assertNull(tree.getRoot().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getRight());
        assertNull(tree.getRoot().getRight());


        // case 1
        //The node containing the data is a leaf (no children).
        //In this case, simply remove it.
        /*
                       17
                      /
        will remove->3
                 result will be
                       17
         */
        assertSame(i3, tree.remove(ii3));
        /*
         * Do not return the same data that was passed in. Return the data that
         * was stored in the tree. (In JAVADOCS)
         */

        assertEquals((Integer) 17, tree.getRoot().getData());

        assertEquals(1, tree.size());

        assertNull(tree.getRoot().getLeft());
        assertNull(tree.getRoot().getRight());

        // case 1
        //The node containing the data is a leaf (no children).
        //In this case, simply remove it.
        /*
         will remove >17
                 result will be
         */
        assertSame(i17, tree.remove(ii17));
        /*
         * Do not return the same data that was passed in. Return the data that
         * was stored in the tree. (In JAVADOCS)
         */

        assertEquals(0, tree.size());

        assertNull(tree.getRoot());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveException() {
        tree.add(1);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.
        try {
            tree.remove(null);
            fail();
        } catch (IllegalArgumentException e) {
        }
        //if data is null;

        try {
            tree.remove(2);
            fail();
        } catch (NoSuchElementException e) {
        }
        //if the data is not in the tree
        assertEquals(1, tree.size());
        assertEquals((Integer) 1, tree.getRoot().getData());
        assertNull(tree.getRoot().getLeft());
        assertNull(tree.getRoot().getRight());
        //Even it throws an exception, the tree still has an element
        //Therefore, size should be 1 and an element should be in there
    }

    @Test(timeout = TIMEOUT)
    public void testGet() {
        /*
              10
             /  \
            9   11
           /      \
          5       15
         /\       /\
        3  7     12 17
           /      \
          6       14
        */
        Integer i10 = 10;
        Integer i9 = 9;
        Integer i11 = 11;
        Integer i5 = 5;
        Integer i3 = 3;
        Integer i7 = 7;
        Integer i6 = 6;
        Integer i15 = 15;
        Integer i12 = 12;
        Integer i14 = 14;
        Integer i17 = 17;
        Integer ii10 = 10;
        Integer ii9 = 9;
        Integer ii11 = 11;
        Integer ii5 = 5;
        Integer ii3 = 3;
        Integer ii7 = 7;
        Integer ii6 = 6;
        Integer ii15 = 15;
        Integer ii12 = 12;
        Integer ii13 = 13;
        Integer ii14 = 14;
        Integer ii17 = 17;
        tree.add(i10);
        tree.add(i9);
        tree.add(i11);
        tree.add(i5);
        tree.add(i3);
        tree.add(i7);
        tree.add(i6);
        tree.add(i15);
        tree.add(i12);
        tree.add(i14);
        tree.add(i17);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.

        assertSame(i10, tree.get(ii10));
        assertSame(i9, tree.get(ii9));
        assertSame(i11, tree.get(ii11));
        assertSame(i5, tree.get(ii5));
        assertSame(i3, tree.get(ii3));
        assertSame(i7, tree.get(ii7));
        assertSame(i6, tree.get(ii6));
        assertSame(i15, tree.get(ii15));
        assertSame(i12, tree.get(ii12));
        assertSame(i14, tree.get(ii14));
        assertSame(i17, tree.get(ii17));

        /*
         * Do not return the same data that was passed in. Return the data that
         * was stored in the tree.
         */

        assertEquals((Integer) 10, tree.getRoot().getData());
        assertEquals((Integer) 9, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 11, tree.getRoot().getRight().getData());
        assertEquals((Integer) 5, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 15, tree.getRoot().getRight().getRight().getData());
        assertEquals((Integer) 3, tree.getRoot().getLeft().getLeft().getLeft().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getLeft().getRight().getData());
        assertEquals((Integer) 12, tree.getRoot().getRight().getRight().getLeft().getData());
        assertEquals((Integer) 17, tree.getRoot().getRight().getRight().getRight().getData());
        assertEquals((Integer) 6, tree.getRoot().getLeft().getLeft().getRight().getLeft().getData());
        assertEquals((Integer) 14, tree.getRoot().getRight().getRight().getLeft().getRight().getData());

        assertEquals(11, tree.size());

        assertNull(tree.getRoot().getLeft().getLeft().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getRight());
        assertNull(tree.getRoot().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getLeft().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getLeft().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getLeft().getRight().getRight());
        assertNull(tree.getRoot().getRight().getRight().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getRight().getRight());
        // get() method should not affect any element.
    }

    @Test(timeout = TIMEOUT)
    public void testGetException() {
        tree.add(1);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.
        try {
            tree.get(null);
            fail();
        } catch (IllegalArgumentException e) {
        }
        //if data is null;

        try {
            tree.remove(2);
            fail();
        } catch (NoSuchElementException e) {
        }
        //if cannot found data
        assertEquals(1, tree.size());
        assertEquals((Integer) 1, tree.getRoot().getData());
        assertNull(tree.getRoot().getLeft());
        assertNull(tree.getRoot().getRight());
        //Even it throws an exception, the tree still has an element
        //Therefore, size should be 1 and an element should be in there
    }

    @Test(timeout = TIMEOUT)
    public void testContains() {

        assertFalse(tree.contains(1));

        /*
              10
             /  \
            9   11
           /      \
          5       15
         /\       /\
        3  7     12 17
           /      \
          6       14
        */
        Integer i10 = 10;
        Integer i9 = 9;
        Integer i11 = 11;
        Integer i5 = 5;
        Integer i3 = 3;
        Integer i7 = 7;
        Integer i6 = 6;
        Integer i15 = 15;
        Integer i12 = 12;
        Integer i13 = 13;
        Integer i14 = 14;
        Integer i17 = 17;
        Integer ii10 = 10;
        Integer ii9 = 9;
        Integer ii11 = 11;
        Integer ii5 = 5;
        Integer ii3 = 3;
        Integer ii7 = 7;
        Integer ii6 = 6;
        Integer ii15 = 15;
        Integer ii12 = 12;
        Integer ii13 = 13;
        Integer ii14 = 14;
        Integer ii17 = 17;
        tree.add(i10);
        tree.add(i9);
        tree.add(i11);
        tree.add(i5);
        tree.add(i3);
        tree.add(i7);
        tree.add(i6);
        tree.add(i15);
        tree.add(i12);
        tree.add(i14);
        tree.add(i17);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.
        assertTrue(tree.contains(ii10));
        assertTrue(tree.contains(ii9));
        assertTrue(tree.contains(ii11));
        assertTrue(tree.contains(ii5));
        assertTrue(tree.contains(ii3));
        assertTrue(tree.contains(ii7));
        assertTrue(tree.contains(ii6));
        assertTrue(tree.contains(ii15));
        assertTrue(tree.contains(ii12));
        assertTrue(tree.contains(ii14));
        assertTrue(tree.contains(ii17));
        //USE value equality.
        assertFalse(tree.contains(20));
        assertFalse(tree.contains(1));
        assertFalse(tree.contains(2));
        assertFalse(tree.contains(4));
        assertFalse(tree.contains(8));


        assertEquals((Integer) 10, tree.getRoot().getData());
        assertEquals((Integer) 9, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 11, tree.getRoot().getRight().getData());
        assertEquals((Integer) 5, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 15, tree.getRoot().getRight().getRight().getData());
        assertEquals((Integer) 3, tree.getRoot().getLeft().getLeft().getLeft().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getLeft().getRight().getData());
        assertEquals((Integer) 12, tree.getRoot().getRight().getRight().getLeft().getData());
        assertEquals((Integer) 17, tree.getRoot().getRight().getRight().getRight().getData());
        assertEquals((Integer) 6, tree.getRoot().getLeft().getLeft().getRight().getLeft().getData());
        assertEquals((Integer) 14, tree.getRoot().getRight().getRight().getLeft().getRight().getData());

        assertEquals(11, tree.size());

        assertNull(tree.getRoot().getLeft().getLeft().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getLeft().getRight().getRight());
        assertNull(tree.getRoot().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getLeft().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getLeft().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getLeft().getRight().getRight());
        assertNull(tree.getRoot().getRight().getRight().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight().getRight().getRight());
        // contains() method should not affect any element.

    }

    @Test(timeout = TIMEOUT)
    public void testContainsException() {

        try {
            tree.contains(null);
            fail();
        } catch (IllegalArgumentException e) {
        }
        //if data is null;

        tree.add(1);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.

        try {
            tree.contains(null);
            fail();
        } catch (IllegalArgumentException e) {
        }
        //if data is null;
        assertEquals(1, tree.size());
        assertEquals((Integer) 1, tree.getRoot().getData());
        assertNull(tree.getRoot().getLeft());
        assertNull(tree.getRoot().getRight());
        //Even it throws an exception, the tree still has an element
        //Therefore, size should be 1 and an element should be in there
    }

    @Test(timeout = TIMEOUT)
    public void testPreorder() {
        /*
              10
             /  \
            9   11
           /      \
          5       15
         /\       /\
        3  7     12 17
           /      \
          6       14
        */
        tree.add(10);
        tree.add(9);
        tree.add(11);
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(6);
        tree.add(15);
        tree.add(12);
        tree.add(14);
        tree.add(17);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.

        List<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(9);
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(6);
        list.add(11);
        list.add(15);
        list.add(12);
        list.add(14);
        list.add(17);
        // list == [10, 9, 5, 3, 7, 6, 11, 15, 12, 14, 17]

        assertEquals(list, tree.preorder());

    }

    @Test(timeout = TIMEOUT)
    public void testInorder() {
        /*
              10
             /  \
            9   11
           /      \
          5       15
         /\       /\
        3  7     12 17
           /      \
          6       14
        */
        tree.add(10);
        tree.add(9);
        tree.add(11);
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(6);
        tree.add(15);
        tree.add(12);
        tree.add(14);
        tree.add(17);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.

        List<Integer> list = new LinkedList<>();

        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(14);
        list.add(15);
        list.add(17);


        // list == [3, 5, 6, 7, 8, 10, 11, 12, 14, 15, 17]

        assertEquals(list, tree.inorder());
    }

    @Test(timeout = TIMEOUT)
    public void testPostorder() {
        /*
              10
             /  \
            9   11
           /      \
          5       15
         /\       /\
        3  7     12 17
           /      \
          6       14
        */
        tree.add(10);
        tree.add(9);
        tree.add(11);
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(6);
        tree.add(15);
        tree.add(12);
        tree.add(14);
        tree.add(17);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.

        List<Integer> list = new LinkedList<>();

        list.add(3);
        list.add(6);
        list.add(7);
        list.add(5);
        list.add(9);
        list.add(14);
        list.add(12);
        list.add(17);
        list.add(15);
        list.add(11);
        list.add(10);


        // list == [3, 6, 7, 5, 9, 14, 12, 17, 15, 11, 10]

        assertEquals(list, tree.postorder());
    }

    @Test(timeout = TIMEOUT)
    public void testLevelorder() {
        /*
              10
             /  \
            9   11
           /      \
          5       15
         /\       /\
        3  7     12 17
           /      \
          6       14
        */
        tree.add(10);
        tree.add(9);
        tree.add(11);
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(6);
        tree.add(15);
        tree.add(12);
        tree.add(14);
        tree.add(17);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.

        List<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(9);
        list.add(11);
        list.add(5);
        list.add(15);
        list.add(3);
        list.add(7);
        list.add(12);
        list.add(17);
        list.add(6);
        list.add(14);


        // list == [10, 9, 11, 5, 15, 3, 7, 12, 17, 6, 14]

        assertEquals(list, tree.levelorder());
    }

    @Test(timeout = TIMEOUT)
    public void testHeight() {

        assertEquals(-1, tree.height());
        //-1 if the tree is empty (JAVA DOCS)

        tree.add(10);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.

        /*
                   10 <-- leaf
         */

        assertEquals(0, tree.height());
        //leaf node has a height of 0 and a null child has a height of -1.
        //A node's height is defined as max(left.height, right.height) + 1. A

        tree.add(5);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.
        /*
                   10 <-- root (height 1)
                  /
                 5 <-- leaf (height 0)
         */
        assertEquals(1, tree.height());

        //leaf node has a height of 0 and a null child has a height of -1.
        //A node's height is defined as max(left.height, right.height) + 1.
        tree.add(15);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.
        /*
                   10 <-- root (height 1)
                  /  \
                 5   15 <-- leaf (height 0)
         */
        assertEquals(1, tree.height());


        //leaf node has a height of 0 and a null child has a height of -1.
        //A node's height is defined as max(left.height, right.height) + 1.
        tree.add(12);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.
        /*
                         10 <-- root (height 2) { MAX[left height (0), right height (1)] + 1 == 2}
                        /  \
     leaf (height 0)-->5   15 <-- (height 1)
                           /
                          12 <-- leaf (height 0)
         */
        assertEquals(2, tree.height());

        //leaf node has a height of 0 and a null child has a height of -1.
        //A node's height is defined as max(left.height, right.height) + 1.
        tree.add(17);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.
        /*
                         10 <-- root (height 2) { MAX[left height (0), right height (1)] + 1 == 2}
                        /  \
     leaf (height 0)-->5   15 <-- (height 1)
                           /\
                          12 17 <-- leaf (height 0)
         */
        assertEquals(2, tree.height());

        //leaf node has a height of 0 and a null child has a height of -1.
        //A node's height is defined as max(left.height, right.height) + 1.
        tree.add(11);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.
        /*
                         10 <-- root (height 2) { MAX[left height (0), right height (2)] + 1 == 3}
                        /  \
     leaf (height 0)-->5   15 <-- (height 2){ MAX[left height (1), right height (0)] + 1 == 2}
                           /\
           (height 1)--> 12 17 <-- leaf (height 0)
                         /
      leaf (height 0)-->11
         */
        assertEquals(3, tree.height());

    }

    @Test(timeout = TIMEOUT)
    public void testClear() {
        /*
              10
             /  \
            9   11
           /      \
          5       15
         /\       /\
        3  7     12 17
           /      \
          6       14
        */
        tree.add(10);
        tree.add(9);
        tree.add(11);
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(6);
        tree.add(15);
        tree.add(12);
        tree.add(14);
        tree.add(17);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.

        tree.clear();
        assertEquals(0, tree.size());
        assertNull(tree.getRoot());

        tree.clear();
        assertEquals(0, tree.size());
        assertNull(tree.getRoot());
        //clear method just makes size to 0 and root to null.
        //It should not change anything else.
    }

    @Test(timeout = TIMEOUT)
    public void testKLargest() {
        List<Integer> list = new LinkedList<>();
        assertEquals(list, tree.kLargest(0));
        //Should not throw any exception
        //will return empty list.
        // k == n
        //Exception occur when k > n.



        /*
              10
             /  \
            9   11
           /      \
          5       15
         /\       /\
        3  7     12 17
           /      \
          6       14
        */
        tree.add(10);
        tree.add(9);
        tree.add(11);
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(6);
        tree.add(15);
        tree.add(12);
        tree.add(14);
        tree.add(17);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.

        assertEquals(list, tree.kLargest(-2));
        assertEquals(list, tree.kLargest(-1));
        assertEquals(list, tree.kLargest(0));

        //Should not throw any exception
        //See Piazza post @547
        //I could see only a answer that
        //"It shouldn't be regarded as an edge case. The list will simply be empty."
        // If any update there, please let me know.

        list.add(17);

        // list == [17]
        assertEquals(list, tree.kLargest(1));

        list.add(0, 15);

        // list == [15, 17]
        assertEquals(list, tree.kLargest(2));

        list.add(0, 14);

        // list == [14, 15, 17]
        assertEquals(list, tree.kLargest(3));

        list.add(0, 12);

        // list == [12, 14, 15, 17]
        assertEquals(list, tree.kLargest(4));

        list.add(0, 11);

        // list == [11, 12, 14, 15, 17]
        assertEquals(list, tree.kLargest(5));

        list.add(0, 10);

        // list == [10, 11, 12, 14, 15, 17]
        assertEquals(list, tree.kLargest(6));

        list.add(0, 9);

        // list == [9, 10, 11, 12, 14, 15, 17]
        assertEquals(list, tree.kLargest(7));

        list.add(0, 7);

        // list == [7, 9, 10, 11, 12, 14, 15, 17]
        assertEquals(list, tree.kLargest(8));

        list.add(0, 6);

        // list == [6, 7, 9, 10, 11, 12, 14, 15, 17]
        assertEquals(list, tree.kLargest(9));

        list.add(0, 5);

        // list == [5, 6, 7, 9, 10, 11, 12, 14, 15, 17]
        assertEquals(list, tree.kLargest(10));

        list.add(0, 3);

        // list == [3, 5, 6, 7, 9, 10, 11, 12, 14, 15, 17]
        assertEquals(list, tree.kLargest(11));

        // Test for skewed tree.

        tree = new BST<>();
        list = new LinkedList<>();
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(1);

        /*
                            5
                           /
                          4
                         /
                        3
                       /
                      2
                     /
                    1
         */

        list.add(0, 5);

        // list == [5]
        assertEquals(list, tree.kLargest(1));

        list.add(0, 4);

        // list == [4, 5]
        assertEquals(list, tree.kLargest(2));

        list.add(0, 3);

        // list == [3, 4, 5]
        assertEquals(list, tree.kLargest(3));

        list.add(0, 2);

        // list == [2, 3, 4, 5]
        assertEquals(list, tree.kLargest(4));

        list.add(0, 1);

        // list == [1, 2, 3, 4, 5]
        assertEquals(list, tree.kLargest(5));
    }


    @Test(timeout = TIMEOUT)
    public void testkLargestException() {

        tree.add(1);
        //WE ASSUME THAT ADD METHOD WORKS PROPERLY.
        assertEquals(1, tree.size());

        try {
            tree.kLargest(2);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }
}