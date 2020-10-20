import org.junit.Before;
import org.junit.Test;


import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class AVLKrishTest {
    private static final int TIMEOUT = 200;
    private AVL<Integer> avl;
    private AVL<String> wordAvl;

    /**
     * Determines whether the two AVL nodes have the same data, height, BF,
     * and children
     * @param node1 the first node to compare
     * @param node2 the second node to compare
     * @param <T> the generic type of data contained in the AVL node
     * @return true if the nodes are equal, false else
     */
    public <T extends Comparable<? super T>> boolean nodeEquals(AVLNode<T> node1, AVLNode<T> node2) {
        return (node1.getData().compareTo(node2.getData()) == 0)
                && node1.getHeight() == node2.getHeight()
                && node1.getBalanceFactor() == node2.getBalanceFactor()
                && this.equalCheckNull(node1.getLeft(), node2.getLeft())
                && this.equalCheckNull(node1.getRight(), node2.getRight());
    }

    /**
     * Determines whether the two nodes are equal, given that either may be
     * null and two null values are equal
     * @param node1 the first node to be compared
     * @param node2 the second node to be compared
     * @param <T> the generic type of data in the AVL nodes
     * @return true if nodes are equal, else false
     */
    private <T extends Comparable<? super T>> boolean equalCheckNull(AVLNode<T> node1, AVLNode<T> node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null && node2 != null) {
            return false;
        } else if (node1 != null && node2 == null) {
            return false;
        } else {
            return this.nodeEquals(node1, node2);
        }
    }

    @Before
    public void setUp() {
        this.avl = new AVL<>();
        this.wordAvl = new AVL<>();
    }

    @Test(timeout = TIMEOUT)
    public void testEmptyConstructor() {
        assertNull(this.avl.getRoot());
        assertEquals(0, this.avl.size());
        assertEquals(-1, this.avl.height());
    }

    @Test(timeout = TIMEOUT)
    public void testAddRotateLeftNoSubtree() {
        this.avl.add(38);

        AVLNode<Integer> node38 = new AVLNode<>(38);

        assertTrue(this.nodeEquals(node38, this.avl.getRoot()));
        assertEquals(1, this.avl.size());

        /* After 38:
         *     38
         */

        this.avl.add(49);

        AVLNode<Integer> node38After49 = new AVLNode<>(38);
        node38After49.setHeight(1);
        node38After49.setBalanceFactor(-1);
        AVLNode<Integer> node49 = new AVLNode<>(49);
        node49.setHeight(0);
        node49.setBalanceFactor(0);
        node38After49.setRight(node49);

        assertTrue(this.nodeEquals(node38After49, this.avl.getRoot()));
        assertEquals(2, this.avl.size());

        /* After 49:
                38
                  \
                   49
         */

        this.avl.add(85);
        AVLNode<Integer> node49After85 = new AVLNode<>(49);
        node49After85.setHeight(1);
        node49After85.setBalanceFactor(0);
        AVLNode<Integer> node38After85 = new AVLNode<>(38);
        node38After85.setBalanceFactor(0);
        node38After85.setHeight(0);
        AVLNode<Integer> node85 = new AVLNode<>(85);
        node85.setBalanceFactor(0);
        node85.setHeight(0);
        node49After85.setLeft(node38After85);
        node49After85.setRight(node85);

        assertTrue(this.nodeEquals(node49After85, this.avl.getRoot()));
        assertEquals(3, this.avl.size());

        /*  After 85:
                49
               /  \
             38    85
         */
    }

    @Test(timeout = TIMEOUT)
    public void testAddRotateLeftSubtree() {
        this.avl.add(38);
        this.avl.add(10);
        this.avl.add(49);
        this.avl.add(41);
        this.avl.add(57);

        /*          38
                  /     \
                 10      49
                        /   \
                      41    57
         */

        this.avl.add(85);

        /*           49
                   /   \
                  38    57
                 /  \     \
                10  41    85
         */

        AVLNode<Integer> node49 = new AVLNode<>(49);
        node49.setBalanceFactor(0);
        node49.setHeight(2);

        AVLNode<Integer> node38 = new AVLNode<>(38);
        node38.setBalanceFactor(0);
        node38.setHeight(1);
        AVLNode<Integer> node57 = new AVLNode<>(57);
        node57.setBalanceFactor(-1);
        node57.setHeight(1);

        AVLNode<Integer> node10 = new AVLNode<>(10);
        node10.setHeight(0);
        node10.setBalanceFactor(0);

        AVLNode<Integer> node41 = new AVLNode<>(41);
        node41.setHeight(0);
        node41.setBalanceFactor(0);

        AVLNode<Integer> node85 = new AVLNode<>(85);
        node85.setHeight(0);
        node85.setBalanceFactor(0);

        node49.setLeft(node38);
        node49.setRight(node57);
        node38.setLeft(node10);
        node38.setRight(node41);
        node57.setRight(node85);

        assertEquals(6, this.avl.size());
        assertEquals(2, this.avl.height());
        assertTrue(this.nodeEquals(node49, this.avl.getRoot()));
    }

    @Test(timeout = TIMEOUT)
    public void testAddRotateRightNoSubtree() {

        /*
                85
               /
              49      ->  49
             /           /  \
            38          38   85
         */

        this.avl.add(85);
        AVLNode<Integer> node85 = new AVLNode<>(85);
        node85.setBalanceFactor(0);
        node85.setHeight(0);

        assertEquals(1, this.avl.size());
        assertTrue(this.nodeEquals(node85, this.avl.getRoot()));

        this.avl.add(49);
        AVLNode<Integer> node85After49 = new AVLNode<>(85);
        node85After49.setBalanceFactor(1);
        node85After49.setHeight(1);

        AVLNode<Integer> node49 = new AVLNode<>(49);
        node49.setBalanceFactor(0);
        node49.setHeight(0);
        node85After49.setLeft(node49);

        assertEquals(2, this.avl.size());
        assertTrue(this.nodeEquals(node85After49, this.avl.getRoot()));

        this.avl.add(38);
        AVLNode<Integer> node49After38 = new AVLNode<>(49);
        node49After38.setBalanceFactor(0);
        node49After38.setHeight(1);

        AVLNode<Integer> node38 = new AVLNode<>(38);
        node38.setBalanceFactor(0);
        node38.setHeight(0);

        AVLNode<Integer> node85After38 = new AVLNode<>(85);
        node85After38.setBalanceFactor(0);
        node85After38.setHeight(0);

        node49After38.setLeft(node38);
        node49After38.setRight(node85After38);

        assertEquals(3, this.avl.size());
        assertTrue(this.nodeEquals(node49After38, this.avl.getRoot()));
    }

    @Test(timeout = TIMEOUT)
    public void testAddRotateRightSubtree() {
        this.avl.add(85);
        this.avl.add(49);
        this.avl.add(100);
        this.avl.add(16);
        this.avl.add(60);

        /*          85
                   /  \
                  49  100
                 /  \
                16  60
         */

        this.avl.add(38);

        /*           49
                   /    \
                  16     85
                   \     /  \
                   38  60  100
         */
        AVLNode<Integer> node49 = new AVLNode<>(49);
        node49.setHeight(2);
        node49.setBalanceFactor(0);

        AVLNode<Integer> node16 = new AVLNode<>(16);
        node16.setHeight(1);
        node16.setBalanceFactor(-1);

        AVLNode<Integer> node85 = new AVLNode<>(85);
        node85.setHeight(1);
        node85.setBalanceFactor(0);
        AVLNode<Integer> node38 = new AVLNode<>(38);
        AVLNode<Integer> node60 = new AVLNode<>(60);
        AVLNode<Integer> node100 = new AVLNode<>(100);

        node49.setLeft(node16);
        node49.setRight(node85);
        node16.setRight(node38);
        node85.setLeft(node60);
        node85.setRight(node100);

        assertEquals(6, this.avl.size());
        assertEquals(2, this.avl.height());
        assertTrue(this.nodeEquals(node49, this.avl.getRoot()));
    }

    @Test(timeout = TIMEOUT)
    public void testAddRotateLeftRight() {

        this.avl.add(50);
        this.avl.add(30);
        this.avl.add(90);
        this.avl.add(15);
        this.avl.add(40);

        /*             50
                      /  \
                    30    90
                   /  \
                  15  40
         */

        this.avl.add(33);

        /*
                    40
                   /  \
                  30   50
                 /  \    \
                15  33   90
         */

        AVLNode<Integer> node15 = new AVLNode<>(15);
        AVLNode<Integer> node33 = new AVLNode<>(33);
        AVLNode<Integer> node90 = new AVLNode<>(90);

        AVLNode<Integer> node30 = new AVLNode<>(30);
        node30.setBalanceFactor(0);
        node30.setHeight(1);
        node30.setLeft(node15);
        node30.setRight(node33);

        AVLNode<Integer> node50 = new AVLNode<>(50);
        node50.setBalanceFactor(-1);
        node50.setHeight(1);
        node50.setRight(node90);

        AVLNode<Integer> node40 = new AVLNode<>(40);
        node40.setBalanceFactor(0);
        node40.setHeight(2);
        node40.setLeft(node30);
        node40.setRight(node50);

        assertEquals(6, this.avl.size());
        assertEquals(2, this.avl.height());
        assertTrue(this.nodeEquals(node40, this.avl.getRoot()));
    }

    @Test(timeout = TIMEOUT)
    public void testAddRotateRightLeft() {
        this.avl.add(120);
        this.avl.add(70);
        this.avl.add(150);
        this.avl.add(140);
        this.avl.add(210);

        /*          120
                   /   \
                  70   150
                      /   \
                     140  210
         */

        this.avl.add(130);

        /*      After right rotation:
                    120
                   /   \
                  70   140
                      /   \
                     130  150
                            \
                            210
         */

        /*      After left-right rotation:
                    140
                   /   \
                  120   150
                 /  \     \
                70  130   210
         */

        AVLNode<Integer> node70 = new AVLNode<>(70);
        AVLNode<Integer> node130 = new AVLNode<>(130);
        AVLNode<Integer> node210 = new AVLNode<>(210);

        AVLNode<Integer> node120 = new AVLNode<>(120);
        node120.setBalanceFactor(0);
        node120.setHeight(1);
        node120.setLeft(node70);
        node120.setRight(node130);

        AVLNode<Integer> node150 = new AVLNode<>(150);
        node150.setBalanceFactor(-1);
        node150.setHeight(1);
        node150.setRight(node210);

        AVLNode<Integer> node140 = new AVLNode<>(140);
        node140.setBalanceFactor(0);
        node140.setHeight(2);
        node140.setLeft(node120);
        node140.setRight(node150);

        assertEquals(6, this.avl.size());
        assertEquals(2, this.avl.height());
        assertTrue(this.nodeEquals(node140, this.avl.getRoot()));
    }

    @Test(timeout = TIMEOUT)
    public void testAddNull() {
        this.avl.add(120);
        this.avl.add(70);
        this.avl.add(150);
        try {
            this.avl.add(null);
            fail();
        } catch (IllegalArgumentException e) { }
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveRotateLeft() {
        this.avl.add(98);
        this.avl.add(15);
        this.avl.add(280);
        this.avl.add(625);

        assertEquals((Integer) 15, this.avl.remove(15));
        /*      280
               /   \
              98    625
         */

        AVLNode<Integer> node98 = new AVLNode<>(98);
        AVLNode<Integer> node625 = new AVLNode<>(625);

        AVLNode<Integer> node280 = new AVLNode<>(280);
        node280.setBalanceFactor(0);
        node280.setHeight(1);
        node280.setLeft(node98);
        node280.setRight(node625);

        assertEquals(3, this.avl.size());
        assertEquals(1, this.avl.height());
        assertTrue(this.nodeEquals(node280, this.avl.getRoot()));
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveRotateRight() {
        this.avl.add(280);
        this.avl.add(98);
        this.avl.add(625);
        this.avl.add(15);

        /*      280
               /   \
              98   625
             /
            15
         */

        assertEquals((Integer) 625, this.avl.remove(625));
        /*      98
               /   \
              15    280
         */

        AVLNode<Integer> node280 = new AVLNode<>(280);
        AVLNode<Integer> node15 = new AVLNode<>(15);

        AVLNode<Integer> node98 = new AVLNode<>(98);
        node98.setBalanceFactor(0);
        node98.setHeight(1);
        node98.setLeft(node15);
        node98.setRight(node280);

        assertEquals(3, this.avl.size());
        assertEquals(1, this.avl.height());
        assertTrue(this.nodeEquals(node98, this.avl.getRoot()));
    }

    @Test(timeout = TIMEOUT)
    public void testRemovePredLeftRight() {

        this.avl.add(50);
        this.avl.add(35);
        this.avl.add(70);
        this.avl.add(20);
        this.avl.add(60);
        this.avl.add(90);
        this.avl.add(55);
        this.avl.add(65);

        /*              50
                       /   \
                      35   70
                     /    /  \
                    20   60  90
                        /  \
                       55  65
         */

        assertEquals((Integer) 50, this.avl.remove(50));

        /*               60
                       /    \
                      35     70
                     /  \   /  \
                    20  55 65  90
         */

        AVLNode<Integer> node20 = new AVLNode<>(20);
        AVLNode<Integer> node55 = new AVLNode<>(55);
        AVLNode<Integer> node65 = new AVLNode<>(65);
        AVLNode<Integer> node90 = new AVLNode<>(90);

        AVLNode<Integer> node35 = new AVLNode<>(35);
        node35.setHeight(1);
        node35.setLeft(node20);
        node35.setRight(node55);

        AVLNode<Integer> node70 = new AVLNode<>(70);
        node70.setHeight(1);
        node70.setLeft(node65);
        node70.setRight(node90);

        AVLNode<Integer> node60 = new AVLNode<>(60);
        node60.setHeight(2);
        node60.setLeft(node35);
        node60.setRight(node70);

        assertEquals(2, this.avl.height());
        assertEquals(7, this.avl.size());
        assertTrue(this.nodeEquals(node60, this.avl.getRoot()));
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveRightLeft() {

        this.avl.add(50);
        this.avl.add(35);
        this.avl.add(70);
        this.avl.add(20);
        this.avl.add(40);
        this.avl.add(90);
        this.avl.add(38);
        this.avl.add(45);

        /*               50
                       /    \
                      35     70
                     /  \      \
                    20  40     90
                        / \
                       38 45
         */

        assertEquals((Integer) 90, this.avl.remove(90));

        /*           40
                   /    \
                  35     50
                 /  \   /  \
                20  38 45  70
         */

        AVLNode<Integer> node20 = new AVLNode<>(20);
        AVLNode<Integer> node38 = new AVLNode<>(38);
        AVLNode<Integer> node45 = new AVLNode<>(45);
        AVLNode<Integer> node70 = new AVLNode<>(70);

        AVLNode<Integer> node35 = new AVLNode<>(35);
        node35.setHeight(1);
        node35.setLeft(node20);
        node35.setRight(node38);

        AVLNode<Integer> node50 = new AVLNode<>(50);
        node50.setHeight(1);
        node50.setLeft(node45);
        node50.setRight(node70);

        AVLNode<Integer> node40 = new AVLNode<>(40);
        node40.setHeight(2);
        node40.setLeft(node35);
        node40.setRight(node50);

        assertEquals(2, this.avl.height());
        assertEquals(7, this.avl.size());
        assertTrue(this.nodeEquals(node40, this.avl.getRoot()));
    }

    // checked that if remove predecessor, that should be rotated if necessary

    @Test(timeout = TIMEOUT)
    public void testRemoveNull() {
        this.avl.add(60);
        this.avl.add(20);
        this.avl.add(100);

        try {
            this.avl.remove(null);
            fail();
        } catch (IllegalArgumentException e) { }
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveNotExists() {
        this.avl.add(60);
        this.avl.add(20);
        this.avl.add(100);

        try {
            this.avl.remove(50);
            fail();
        } catch (NoSuchElementException e) { }
    }

    @Test(timeout = TIMEOUT)
    public void testGet() {

        Integer i1 = 50;
        Integer i2 = 35;
        Integer i3 = 70;
        Integer i4 = 20;
        Integer i5 = 10;
        Integer i6 = 100;

        this.avl.add(i1);
        this.avl.add(i2);
        this.avl.add(i3);
        this.avl.add(i4);
        this.avl.add(i5);
        this.avl.add(i6);

        assertSame(i4, this.avl.remove(20));
        assertSame(i1, this.avl.remove(50));

        assertSame(i2, this.avl.get(35));
        assertSame(i3, this.avl.get(70));
        assertSame(i5, this.avl.get(10));
        assertSame(i6, this.avl.get(100));

        try {
            this.avl.get(20);
            fail();
        } catch (NoSuchElementException e) { }

        try {
            this.avl.get(50);
            fail();
        } catch (NoSuchElementException e) { }
    }

    @Test(timeout = TIMEOUT)
    public void testContains() {

        Integer i1 = 50;
        Integer i2 = 35;
        Integer i3 = 70;
        Integer i4 = 20;
        Integer i5 = 10;
        Integer i6 = 100;

        this.avl.add(i1);
        this.avl.add(i2);
        this.avl.add(i3);
        this.avl.add(i4);
        this.avl.add(i5);
        this.avl.add(i6);

        this.avl.remove(20);
        this.avl.remove(50);

        assertTrue(this.avl.contains(35));
        assertTrue(this.avl.contains(70));
        assertTrue(this.avl.contains(10));
        assertTrue(this.avl.contains(100));
        assertFalse(this.avl.contains(20));
        assertFalse(this.avl.contains(50));
        assertFalse(this.avl.contains(-10));
    }

    @Test(timeout = TIMEOUT)
    public void testContainsNull() {

        this.avl.add(10);
        this.avl.add(20);
        this.avl.add(30);

        try {
            this.avl.contains(null);
            fail();
        } catch (IllegalArgumentException e) { }
    }

    @Test(timeout = TIMEOUT)
    public void testClear() {
        this.avl.add(10);
        this.avl.add(20);
        this.avl.add(30);
        this.avl.add(55);
        this.avl.add(15);

        this.avl.remove(10);
        this.avl.remove(55);

        AVLNode<Integer> node15 = new AVLNode<>(15);
        AVLNode<Integer> node30 = new AVLNode<>(30);
        AVLNode<Integer> node20 = new AVLNode<>(20);
        node20.setHeight(1);
        node20.setLeft(node15);
        node20.setRight(node30);

        assertEquals(3, this.avl.size());
        assertEquals(1, this.avl.height());
        assertTrue(this.nodeEquals(node20, this.avl.getRoot()));

        this.avl.clear();
        assertEquals(0, this.avl.size());
        assertEquals(-1, this.avl.height());
        assertNull(this.avl.getRoot());
    }

    @Test(timeout = TIMEOUT)
    public void testWordSearch() {
        String l1 = "t";
        String l2 = "h";
        String l3 = "y";
        String l4 = "a";
        String l5 = "o";
        String l6 = "w";
        String l7 = "z";
        String l8 = "n";
        String l9 = "p";

        this.wordAvl.add(l1);
        this.wordAvl.add(l2);
        this.wordAvl.add(l3);
        this.wordAvl.add(l4);
        this.wordAvl.add(l5);
        this.wordAvl.add(l6);
        this.wordAvl.add(l7);
        this.wordAvl.add(l8);
        this.wordAvl.add(l9);

        /*
                t
              /   \
             h     y
            / \   / \
           a   o w   z
              / \
             n   p
         */

        String[] word1 = {"z", "y", "t", "h", "o", "n"};
        List<String> search1 = this.wordAvl.wordSearch(word1);
        assertEquals(6, search1.size());
        assertSame(l7, search1.get(0));
        assertSame(l3, search1.get(1));
        assertSame(l1, search1.get(2));
        assertSame(l2, search1.get(3));
        assertSame(l5, search1.get(4));
        assertSame(l8, search1.get(5));

        String[] word2 = {"p", "o", "h", "t", "y"};
        List<String> search2 = this.wordAvl.wordSearch(word2);
        assertEquals(5, search2.size());
        assertSame(l9, search2.get(0));
        assertSame(l5, search2.get(1));
        assertSame(l2, search2.get(2));
        assertSame(l1, search2.get(3));
        assertSame(l3, search2.get(4));

        try {
            String[] word3 = {"p", "y", "t", "h", "o", "n"};
            List<String> search3 = this.wordAvl.wordSearch(word3);
            fail();
        } catch (NoSuchElementException e) { }

        try {
            String[] word4 = {"p", "o", "t"};
            List<String> search4 = this.wordAvl.wordSearch(word4);
            fail();
        } catch (NoSuchElementException e) { }

        try {
            String[] word5 = {"p", "o", "n", "a"};
            List<String> search5 = this.wordAvl.wordSearch(word5);
            fail();
        } catch (NoSuchElementException e) { }

        try {
            String[] word6 = {"w", "y", "l", "t", "h", "e"};
            List<String> search6 = this.wordAvl.wordSearch(word6);
            fail();
        } catch (NoSuchElementException e) { }

    }

    @Test(timeout = TIMEOUT)
    public void testWordSearchNull() {
        try {
            this.avl.wordSearch(null);
            fail();
        } catch (IllegalArgumentException e) { }
    }

}