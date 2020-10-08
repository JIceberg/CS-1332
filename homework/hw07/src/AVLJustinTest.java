import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 1. Keep in mind that while these tests may look comprehensive, the code's length is deceiving,
 *     quality is much better than quantity and by using randomness and sheer number of tests,
 *     the quality is very low. *The vast majority only test add() and remove() methods*
 * 2*. MOST importantly, these tests go against the very idea of unit testing, the most egregious
 *     is the fact that I must use my own code to allow these tests to be programmatically generated...
 *     essentially, this code is useless to test my own program, and will only be helpful if my code
 *     happens to include things that yours does not and isn't wrong itself.
 *
 * With that said, I did include exception testing like normal and one wordSearch test. In conclusion,
 * I made these because I got bored and you should use them at your own risk.
 *
 * Enjoy ;)
 *
 * @author Justin Hinckley
 * @version 1.0
 */
public class AVLJustinTest {

    private static final int TIMEOUT = 200;
    private AVL<Integer> tree;

    private boolean treesEqual(AVLNode<Integer> otherNode) {
        return treesEqualHelper(tree.getRoot(), otherNode);
    }

    private boolean treesEqualHelper(AVLNode<Integer> node, AVLNode<Integer> otherNode) {
        if (node == null) {
            return otherNode == null;
        } else {
            if (otherNode == null) {
                System.out.println("Not equal because expected is non-null but actual is null.");
                return false;
            }
            if (!(node.getData() == otherNode.getData() && node.getBalanceFactor() ==
                    otherNode.getBalanceFactor() && node.getHeight() == otherNode.getHeight())) {
                System.out.println("Not equal because expected and actual's data, BF, and/or height are different.");
                return false;
            }
            if (!(treesEqualHelper(node.getLeft(), otherNode.getLeft()))) {
                return false;
            }
            if (!(treesEqualHelper(node.getRight(), otherNode.getRight()))) {
                return false;
            }
            return true;
        }
    }

    @Before
    public void setup() {
        tree = new AVL<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, tree.size());
        assertNull(tree.getRoot());
    }



    // X=X=X=X=X=X=X=X=X=X Auto-generated Add/Remove Tests X=X=X=X=X=X=X=X=X=X


    // ========== Test #0: ==========
    @Test(timeout = TIMEOUT)
    public void test0() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer rand10 = new Integer(10);
        tree.add(rand10);

        // Validating last operation...
        otherTree = new AVLNode<>(rand10);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer rand120 = new Integer(120);
        tree.add(rand120);

        // Validating last operation...
        otherTree = new AVLNode<>(rand10);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = new AVLNode<>(rand120);var3.setHeight(0);var3.setBalanceFactor(0);
        AVLNode<Integer> var4 = null;
        var3.setLeft(var4);
        AVLNode<Integer> var5 = null;
        var3.setRight(var5);
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer rand207 = new Integer(207);
        tree.add(rand207);

        // Validating last operation...
        otherTree = new AVLNode<>(rand120);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(rand10);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(rand207);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        assertSame(rand120, tree.remove(rand120.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand10);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var12 = null;
        otherTree.setLeft(var12);
        AVLNode<Integer> var13 = new AVLNode<>(rand207);var13.setHeight(0);var13.setBalanceFactor(0);
        AVLNode<Integer> var14 = null;
        var13.setLeft(var14);
        AVLNode<Integer> var15 = null;
        var13.setRight(var15);
        otherTree.setRight(var13);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer rand201 = new Integer(201);
        tree.add(rand201);

        // Validating last operation...
        otherTree = new AVLNode<>(rand201);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var16 = new AVLNode<>(rand10);var16.setHeight(0);var16.setBalanceFactor(0);
        AVLNode<Integer> var17 = null;
        var16.setLeft(var17);
        AVLNode<Integer> var18 = null;
        var16.setRight(var18);
        otherTree.setLeft(var16);
        AVLNode<Integer> var19 = new AVLNode<>(rand207);var19.setHeight(0);var19.setBalanceFactor(0);
        AVLNode<Integer> var20 = null;
        var19.setLeft(var20);
        AVLNode<Integer> var21 = null;
        var19.setRight(var21);
        otherTree.setRight(var19);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer rand53 = new Integer(53);
        tree.add(rand53);

        // Validating last operation...
        otherTree = new AVLNode<>(rand201);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var22 = new AVLNode<>(rand10);var22.setHeight(1);var22.setBalanceFactor(-1);
        AVLNode<Integer> var23 = null;
        var22.setLeft(var23);
        AVLNode<Integer> var24 = new AVLNode<>(rand53);var24.setHeight(0);var24.setBalanceFactor(0);
        AVLNode<Integer> var25 = null;
        var24.setLeft(var25);
        AVLNode<Integer> var26 = null;
        var24.setRight(var26);
        var22.setRight(var24);
        otherTree.setLeft(var22);
        AVLNode<Integer> var27 = new AVLNode<>(rand207);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        otherTree.setRight(var27);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer randneg879 = new Integer(-879);
        tree.add(randneg879);

        // Validating last operation...
        otherTree = new AVLNode<>(rand201);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var30 = new AVLNode<>(rand10);var30.setHeight(1);var30.setBalanceFactor(0);
        AVLNode<Integer> var31 = new AVLNode<>(randneg879);var31.setHeight(0);var31.setBalanceFactor(0);
        AVLNode<Integer> var32 = null;
        var31.setLeft(var32);
        AVLNode<Integer> var33 = null;
        var31.setRight(var33);
        var30.setLeft(var31);
        AVLNode<Integer> var34 = new AVLNode<>(rand53);var34.setHeight(0);var34.setBalanceFactor(0);
        AVLNode<Integer> var35 = null;
        var34.setLeft(var35);
        AVLNode<Integer> var36 = null;
        var34.setRight(var36);
        var30.setRight(var34);
        otherTree.setLeft(var30);
        AVLNode<Integer> var37 = new AVLNode<>(rand207);var37.setHeight(0);var37.setBalanceFactor(0);
        AVLNode<Integer> var38 = null;
        var37.setLeft(var38);
        AVLNode<Integer> var39 = null;
        var37.setRight(var39);
        otherTree.setRight(var37);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer rand202 = new Integer(202);
        tree.add(rand202);

        // Validating last operation...
        otherTree = new AVLNode<>(rand201);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var40 = new AVLNode<>(rand10);var40.setHeight(1);var40.setBalanceFactor(0);
        AVLNode<Integer> var41 = new AVLNode<>(randneg879);var41.setHeight(0);var41.setBalanceFactor(0);
        AVLNode<Integer> var42 = null;
        var41.setLeft(var42);
        AVLNode<Integer> var43 = null;
        var41.setRight(var43);
        var40.setLeft(var41);
        AVLNode<Integer> var44 = new AVLNode<>(rand53);var44.setHeight(0);var44.setBalanceFactor(0);
        AVLNode<Integer> var45 = null;
        var44.setLeft(var45);
        AVLNode<Integer> var46 = null;
        var44.setRight(var46);
        var40.setRight(var44);
        otherTree.setLeft(var40);
        AVLNode<Integer> var47 = new AVLNode<>(rand207);var47.setHeight(1);var47.setBalanceFactor(1);
        AVLNode<Integer> var48 = new AVLNode<>(rand202);var48.setHeight(0);var48.setBalanceFactor(0);
        AVLNode<Integer> var49 = null;
        var48.setLeft(var49);
        AVLNode<Integer> var50 = null;
        var48.setRight(var50);
        var47.setLeft(var48);
        AVLNode<Integer> var51 = null;
        var47.setRight(var51);
        otherTree.setRight(var47);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        assertSame(randneg879, tree.remove(randneg879.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand201);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var52 = new AVLNode<>(rand10);var52.setHeight(1);var52.setBalanceFactor(-1);
        AVLNode<Integer> var53 = null;
        var52.setLeft(var53);
        AVLNode<Integer> var54 = new AVLNode<>(rand53);var54.setHeight(0);var54.setBalanceFactor(0);
        AVLNode<Integer> var55 = null;
        var54.setLeft(var55);
        AVLNode<Integer> var56 = null;
        var54.setRight(var56);
        var52.setRight(var54);
        otherTree.setLeft(var52);
        AVLNode<Integer> var57 = new AVLNode<>(rand207);var57.setHeight(1);var57.setBalanceFactor(1);
        AVLNode<Integer> var58 = new AVLNode<>(rand202);var58.setHeight(0);var58.setBalanceFactor(0);
        AVLNode<Integer> var59 = null;
        var58.setLeft(var59);
        AVLNode<Integer> var60 = null;
        var58.setRight(var60);
        var57.setLeft(var58);
        AVLNode<Integer> var61 = null;
        var57.setRight(var61);
        otherTree.setRight(var57);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer rand967 = new Integer(967);
        tree.add(rand967);

        // Validating last operation...
        otherTree = new AVLNode<>(rand201);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var62 = new AVLNode<>(rand10);var62.setHeight(1);var62.setBalanceFactor(-1);
        AVLNode<Integer> var63 = null;
        var62.setLeft(var63);
        AVLNode<Integer> var64 = new AVLNode<>(rand53);var64.setHeight(0);var64.setBalanceFactor(0);
        AVLNode<Integer> var65 = null;
        var64.setLeft(var65);
        AVLNode<Integer> var66 = null;
        var64.setRight(var66);
        var62.setRight(var64);
        otherTree.setLeft(var62);
        AVLNode<Integer> var67 = new AVLNode<>(rand207);var67.setHeight(1);var67.setBalanceFactor(0);
        AVLNode<Integer> var68 = new AVLNode<>(rand202);var68.setHeight(0);var68.setBalanceFactor(0);
        AVLNode<Integer> var69 = null;
        var68.setLeft(var69);
        AVLNode<Integer> var70 = null;
        var68.setRight(var70);
        var67.setLeft(var68);
        AVLNode<Integer> var71 = new AVLNode<>(rand967);var71.setHeight(0);var71.setBalanceFactor(0);
        AVLNode<Integer> var72 = null;
        var71.setLeft(var72);
        AVLNode<Integer> var73 = null;
        var71.setRight(var73);
        var67.setRight(var71);
        otherTree.setRight(var67);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer rand22 = new Integer(22);
        tree.add(rand22);

        // Validating last operation...
        otherTree = new AVLNode<>(rand201);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var74 = new AVLNode<>(rand22);var74.setHeight(1);var74.setBalanceFactor(0);
        AVLNode<Integer> var75 = new AVLNode<>(rand10);var75.setHeight(0);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = null;
        var75.setLeft(var76);
        AVLNode<Integer> var77 = null;
        var75.setRight(var77);
        var74.setLeft(var75);
        AVLNode<Integer> var78 = new AVLNode<>(rand53);var78.setHeight(0);var78.setBalanceFactor(0);
        AVLNode<Integer> var79 = null;
        var78.setLeft(var79);
        AVLNode<Integer> var80 = null;
        var78.setRight(var80);
        var74.setRight(var78);
        otherTree.setLeft(var74);
        AVLNode<Integer> var81 = new AVLNode<>(rand207);var81.setHeight(1);var81.setBalanceFactor(0);
        AVLNode<Integer> var82 = new AVLNode<>(rand202);var82.setHeight(0);var82.setBalanceFactor(0);
        AVLNode<Integer> var83 = null;
        var82.setLeft(var83);
        AVLNode<Integer> var84 = null;
        var82.setRight(var84);
        var81.setLeft(var82);
        AVLNode<Integer> var85 = new AVLNode<>(rand967);var85.setHeight(0);var85.setBalanceFactor(0);
        AVLNode<Integer> var86 = null;
        var85.setLeft(var86);
        AVLNode<Integer> var87 = null;
        var85.setRight(var87);
        var81.setRight(var85);
        otherTree.setRight(var81);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer rand873 = new Integer(873);
        tree.add(rand873);

        // Validating last operation...
        otherTree = new AVLNode<>(rand201);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var88 = new AVLNode<>(rand22);var88.setHeight(1);var88.setBalanceFactor(0);
        AVLNode<Integer> var89 = new AVLNode<>(rand10);var89.setHeight(0);var89.setBalanceFactor(0);
        AVLNode<Integer> var90 = null;
        var89.setLeft(var90);
        AVLNode<Integer> var91 = null;
        var89.setRight(var91);
        var88.setLeft(var89);
        AVLNode<Integer> var92 = new AVLNode<>(rand53);var92.setHeight(0);var92.setBalanceFactor(0);
        AVLNode<Integer> var93 = null;
        var92.setLeft(var93);
        AVLNode<Integer> var94 = null;
        var92.setRight(var94);
        var88.setRight(var92);
        otherTree.setLeft(var88);
        AVLNode<Integer> var95 = new AVLNode<>(rand207);var95.setHeight(2);var95.setBalanceFactor(-1);
        AVLNode<Integer> var96 = new AVLNode<>(rand202);var96.setHeight(0);var96.setBalanceFactor(0);
        AVLNode<Integer> var97 = null;
        var96.setLeft(var97);
        AVLNode<Integer> var98 = null;
        var96.setRight(var98);
        var95.setLeft(var96);
        AVLNode<Integer> var99 = new AVLNode<>(rand967);var99.setHeight(1);var99.setBalanceFactor(1);
        AVLNode<Integer> var100 = new AVLNode<>(rand873);var100.setHeight(0);var100.setBalanceFactor(0);
        AVLNode<Integer> var101 = null;
        var100.setLeft(var101);
        AVLNode<Integer> var102 = null;
        var100.setRight(var102);
        var99.setLeft(var100);
        AVLNode<Integer> var103 = null;
        var99.setRight(var103);
        var95.setRight(var99);
        otherTree.setRight(var95);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        assertSame(rand201, tree.remove(rand201.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand53);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var104 = new AVLNode<>(rand22);var104.setHeight(1);var104.setBalanceFactor(1);
        AVLNode<Integer> var105 = new AVLNode<>(rand10);var105.setHeight(0);var105.setBalanceFactor(0);
        AVLNode<Integer> var106 = null;
        var105.setLeft(var106);
        AVLNode<Integer> var107 = null;
        var105.setRight(var107);
        var104.setLeft(var105);
        AVLNode<Integer> var108 = null;
        var104.setRight(var108);
        otherTree.setLeft(var104);
        AVLNode<Integer> var109 = new AVLNode<>(rand207);var109.setHeight(2);var109.setBalanceFactor(-1);
        AVLNode<Integer> var110 = new AVLNode<>(rand202);var110.setHeight(0);var110.setBalanceFactor(0);
        AVLNode<Integer> var111 = null;
        var110.setLeft(var111);
        AVLNode<Integer> var112 = null;
        var110.setRight(var112);
        var109.setLeft(var110);
        AVLNode<Integer> var113 = new AVLNode<>(rand967);var113.setHeight(1);var113.setBalanceFactor(1);
        AVLNode<Integer> var114 = new AVLNode<>(rand873);var114.setHeight(0);var114.setBalanceFactor(0);
        AVLNode<Integer> var115 = null;
        var114.setLeft(var115);
        AVLNode<Integer> var116 = null;
        var114.setRight(var116);
        var113.setLeft(var114);
        AVLNode<Integer> var117 = null;
        var113.setRight(var117);
        var109.setRight(var113);
        otherTree.setRight(var109);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer randneg577 = new Integer(-577);
        tree.add(randneg577);

        // Validating last operation...
        otherTree = new AVLNode<>(rand53);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var118 = new AVLNode<>(rand10);var118.setHeight(1);var118.setBalanceFactor(0);
        AVLNode<Integer> var119 = new AVLNode<>(randneg577);var119.setHeight(0);var119.setBalanceFactor(0);
        AVLNode<Integer> var120 = null;
        var119.setLeft(var120);
        AVLNode<Integer> var121 = null;
        var119.setRight(var121);
        var118.setLeft(var119);
        AVLNode<Integer> var122 = new AVLNode<>(rand22);var122.setHeight(0);var122.setBalanceFactor(0);
        AVLNode<Integer> var123 = null;
        var122.setLeft(var123);
        AVLNode<Integer> var124 = null;
        var122.setRight(var124);
        var118.setRight(var122);
        otherTree.setLeft(var118);
        AVLNode<Integer> var125 = new AVLNode<>(rand207);var125.setHeight(2);var125.setBalanceFactor(-1);
        AVLNode<Integer> var126 = new AVLNode<>(rand202);var126.setHeight(0);var126.setBalanceFactor(0);
        AVLNode<Integer> var127 = null;
        var126.setLeft(var127);
        AVLNode<Integer> var128 = null;
        var126.setRight(var128);
        var125.setLeft(var126);
        AVLNode<Integer> var129 = new AVLNode<>(rand967);var129.setHeight(1);var129.setBalanceFactor(1);
        AVLNode<Integer> var130 = new AVLNode<>(rand873);var130.setHeight(0);var130.setBalanceFactor(0);
        AVLNode<Integer> var131 = null;
        var130.setLeft(var131);
        AVLNode<Integer> var132 = null;
        var130.setRight(var132);
        var129.setLeft(var130);
        AVLNode<Integer> var133 = null;
        var129.setRight(var133);
        var125.setRight(var129);
        otherTree.setRight(var125);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer randneg227 = new Integer(-227);
        tree.add(randneg227);

        // Validating last operation...
        otherTree = new AVLNode<>(rand53);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var134 = new AVLNode<>(rand10);var134.setHeight(2);var134.setBalanceFactor(1);
        AVLNode<Integer> var135 = new AVLNode<>(randneg577);var135.setHeight(1);var135.setBalanceFactor(-1);
        AVLNode<Integer> var136 = null;
        var135.setLeft(var136);
        AVLNode<Integer> var137 = new AVLNode<>(randneg227);var137.setHeight(0);var137.setBalanceFactor(0);
        AVLNode<Integer> var138 = null;
        var137.setLeft(var138);
        AVLNode<Integer> var139 = null;
        var137.setRight(var139);
        var135.setRight(var137);
        var134.setLeft(var135);
        AVLNode<Integer> var140 = new AVLNode<>(rand22);var140.setHeight(0);var140.setBalanceFactor(0);
        AVLNode<Integer> var141 = null;
        var140.setLeft(var141);
        AVLNode<Integer> var142 = null;
        var140.setRight(var142);
        var134.setRight(var140);
        otherTree.setLeft(var134);
        AVLNode<Integer> var143 = new AVLNode<>(rand207);var143.setHeight(2);var143.setBalanceFactor(-1);
        AVLNode<Integer> var144 = new AVLNode<>(rand202);var144.setHeight(0);var144.setBalanceFactor(0);
        AVLNode<Integer> var145 = null;
        var144.setLeft(var145);
        AVLNode<Integer> var146 = null;
        var144.setRight(var146);
        var143.setLeft(var144);
        AVLNode<Integer> var147 = new AVLNode<>(rand967);var147.setHeight(1);var147.setBalanceFactor(1);
        AVLNode<Integer> var148 = new AVLNode<>(rand873);var148.setHeight(0);var148.setBalanceFactor(0);
        AVLNode<Integer> var149 = null;
        var148.setLeft(var149);
        AVLNode<Integer> var150 = null;
        var148.setRight(var150);
        var147.setLeft(var148);
        AVLNode<Integer> var151 = null;
        var147.setRight(var151);
        var143.setRight(var147);
        otherTree.setRight(var143);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #1: ==========
    @Test(timeout = TIMEOUT)
    public void test1() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg993 = new Integer(-993);
        tree.add(randneg993);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg993);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer rand823 = new Integer(823);
        tree.add(rand823);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg993);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = new AVLNode<>(rand823);var3.setHeight(0);var3.setBalanceFactor(0);
        AVLNode<Integer> var4 = null;
        var3.setLeft(var4);
        AVLNode<Integer> var5 = null;
        var3.setRight(var5);
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer rand544 = new Integer(544);
        tree.add(rand544);

        // Validating last operation...
        otherTree = new AVLNode<>(rand544);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(randneg993);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(rand823);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer randneg650 = new Integer(-650);
        tree.add(randneg650);

        // Validating last operation...
        otherTree = new AVLNode<>(rand544);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var12 = new AVLNode<>(randneg993);var12.setHeight(1);var12.setBalanceFactor(-1);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = new AVLNode<>(randneg650);var14.setHeight(0);var14.setBalanceFactor(0);
        AVLNode<Integer> var15 = null;
        var14.setLeft(var15);
        AVLNode<Integer> var16 = null;
        var14.setRight(var16);
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var17 = new AVLNode<>(rand823);var17.setHeight(0);var17.setBalanceFactor(0);
        AVLNode<Integer> var18 = null;
        var17.setLeft(var18);
        AVLNode<Integer> var19 = null;
        var17.setRight(var19);
        otherTree.setRight(var17);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer randneg660 = new Integer(-660);
        tree.add(randneg660);

        // Validating last operation...
        otherTree = new AVLNode<>(rand544);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var20 = new AVLNode<>(randneg660);var20.setHeight(1);var20.setBalanceFactor(0);
        AVLNode<Integer> var21 = new AVLNode<>(randneg993);var21.setHeight(0);var21.setBalanceFactor(0);
        AVLNode<Integer> var22 = null;
        var21.setLeft(var22);
        AVLNode<Integer> var23 = null;
        var21.setRight(var23);
        var20.setLeft(var21);
        AVLNode<Integer> var24 = new AVLNode<>(randneg650);var24.setHeight(0);var24.setBalanceFactor(0);
        AVLNode<Integer> var25 = null;
        var24.setLeft(var25);
        AVLNode<Integer> var26 = null;
        var24.setRight(var26);
        var20.setRight(var24);
        otherTree.setLeft(var20);
        AVLNode<Integer> var27 = new AVLNode<>(rand823);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        otherTree.setRight(var27);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        assertSame(randneg993, tree.remove(randneg993.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand544);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var30 = new AVLNode<>(randneg660);var30.setHeight(1);var30.setBalanceFactor(-1);
        AVLNode<Integer> var31 = null;
        var30.setLeft(var31);
        AVLNode<Integer> var32 = new AVLNode<>(randneg650);var32.setHeight(0);var32.setBalanceFactor(0);
        AVLNode<Integer> var33 = null;
        var32.setLeft(var33);
        AVLNode<Integer> var34 = null;
        var32.setRight(var34);
        var30.setRight(var32);
        otherTree.setLeft(var30);
        AVLNode<Integer> var35 = new AVLNode<>(rand823);var35.setHeight(0);var35.setBalanceFactor(0);
        AVLNode<Integer> var36 = null;
        var35.setLeft(var36);
        AVLNode<Integer> var37 = null;
        var35.setRight(var37);
        otherTree.setRight(var35);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        assertSame(rand823, tree.remove(rand823.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg650);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var38 = new AVLNode<>(randneg660);var38.setHeight(0);var38.setBalanceFactor(0);
        AVLNode<Integer> var39 = null;
        var38.setLeft(var39);
        AVLNode<Integer> var40 = null;
        var38.setRight(var40);
        otherTree.setLeft(var38);
        AVLNode<Integer> var41 = new AVLNode<>(rand544);var41.setHeight(0);var41.setBalanceFactor(0);
        AVLNode<Integer> var42 = null;
        var41.setLeft(var42);
        AVLNode<Integer> var43 = null;
        var41.setRight(var43);
        otherTree.setRight(var41);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        assertSame(randneg650, tree.remove(randneg650.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg660);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var44 = null;
        otherTree.setLeft(var44);
        AVLNode<Integer> var45 = new AVLNode<>(rand544);var45.setHeight(0);var45.setBalanceFactor(0);
        AVLNode<Integer> var46 = null;
        var45.setLeft(var46);
        AVLNode<Integer> var47 = null;
        var45.setRight(var47);
        otherTree.setRight(var45);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        assertSame(randneg660, tree.remove(randneg660.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand544);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var48 = null;
        otherTree.setLeft(var48);
        AVLNode<Integer> var49 = null;
        otherTree.setRight(var49);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer randneg455 = new Integer(-455);
        tree.add(randneg455);

        // Validating last operation...
        otherTree = new AVLNode<>(rand544);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var50 = new AVLNode<>(randneg455);var50.setHeight(0);var50.setBalanceFactor(0);
        AVLNode<Integer> var51 = null;
        var50.setLeft(var51);
        AVLNode<Integer> var52 = null;
        var50.setRight(var52);
        otherTree.setLeft(var50);
        AVLNode<Integer> var53 = null;
        otherTree.setRight(var53);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer rand712 = new Integer(712);
        tree.add(rand712);

        // Validating last operation...
        otherTree = new AVLNode<>(rand544);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var54 = new AVLNode<>(randneg455);var54.setHeight(0);var54.setBalanceFactor(0);
        AVLNode<Integer> var55 = null;
        var54.setLeft(var55);
        AVLNode<Integer> var56 = null;
        var54.setRight(var56);
        otherTree.setLeft(var54);
        AVLNode<Integer> var57 = new AVLNode<>(rand712);var57.setHeight(0);var57.setBalanceFactor(0);
        AVLNode<Integer> var58 = null;
        var57.setLeft(var58);
        AVLNode<Integer> var59 = null;
        var57.setRight(var59);
        otherTree.setRight(var57);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer rand458 = new Integer(458);
        tree.add(rand458);

        // Validating last operation...
        otherTree = new AVLNode<>(rand544);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var60 = new AVLNode<>(randneg455);var60.setHeight(1);var60.setBalanceFactor(-1);
        AVLNode<Integer> var61 = null;
        var60.setLeft(var61);
        AVLNode<Integer> var62 = new AVLNode<>(rand458);var62.setHeight(0);var62.setBalanceFactor(0);
        AVLNode<Integer> var63 = null;
        var62.setLeft(var63);
        AVLNode<Integer> var64 = null;
        var62.setRight(var64);
        var60.setRight(var62);
        otherTree.setLeft(var60);
        AVLNode<Integer> var65 = new AVLNode<>(rand712);var65.setHeight(0);var65.setBalanceFactor(0);
        AVLNode<Integer> var66 = null;
        var65.setLeft(var66);
        AVLNode<Integer> var67 = null;
        var65.setRight(var67);
        otherTree.setRight(var65);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        assertSame(randneg455, tree.remove(randneg455.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand544);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var68 = new AVLNode<>(rand458);var68.setHeight(0);var68.setBalanceFactor(0);
        AVLNode<Integer> var69 = null;
        var68.setLeft(var69);
        AVLNode<Integer> var70 = null;
        var68.setRight(var70);
        otherTree.setLeft(var68);
        AVLNode<Integer> var71 = new AVLNode<>(rand712);var71.setHeight(0);var71.setBalanceFactor(0);
        AVLNode<Integer> var72 = null;
        var71.setLeft(var72);
        AVLNode<Integer> var73 = null;
        var71.setRight(var73);
        otherTree.setRight(var71);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer randneg285 = new Integer(-285);
        tree.add(randneg285);

        // Validating last operation...
        otherTree = new AVLNode<>(rand544);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var74 = new AVLNode<>(rand458);var74.setHeight(1);var74.setBalanceFactor(1);
        AVLNode<Integer> var75 = new AVLNode<>(randneg285);var75.setHeight(0);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = null;
        var75.setLeft(var76);
        AVLNode<Integer> var77 = null;
        var75.setRight(var77);
        var74.setLeft(var75);
        AVLNode<Integer> var78 = null;
        var74.setRight(var78);
        otherTree.setLeft(var74);
        AVLNode<Integer> var79 = new AVLNode<>(rand712);var79.setHeight(0);var79.setBalanceFactor(0);
        AVLNode<Integer> var80 = null;
        var79.setLeft(var80);
        AVLNode<Integer> var81 = null;
        var79.setRight(var81);
        otherTree.setRight(var79);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer rand904 = new Integer(904);
        tree.add(rand904);

        // Validating last operation...
        otherTree = new AVLNode<>(rand544);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var82 = new AVLNode<>(rand458);var82.setHeight(1);var82.setBalanceFactor(1);
        AVLNode<Integer> var83 = new AVLNode<>(randneg285);var83.setHeight(0);var83.setBalanceFactor(0);
        AVLNode<Integer> var84 = null;
        var83.setLeft(var84);
        AVLNode<Integer> var85 = null;
        var83.setRight(var85);
        var82.setLeft(var83);
        AVLNode<Integer> var86 = null;
        var82.setRight(var86);
        otherTree.setLeft(var82);
        AVLNode<Integer> var87 = new AVLNode<>(rand712);var87.setHeight(1);var87.setBalanceFactor(-1);
        AVLNode<Integer> var88 = null;
        var87.setLeft(var88);
        AVLNode<Integer> var89 = new AVLNode<>(rand904);var89.setHeight(0);var89.setBalanceFactor(0);
        AVLNode<Integer> var90 = null;
        var89.setLeft(var90);
        AVLNode<Integer> var91 = null;
        var89.setRight(var91);
        var87.setRight(var89);
        otherTree.setRight(var87);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #2: ==========
    @Test(timeout = TIMEOUT)
    public void test2() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg114 = new Integer(-114);
        tree.add(randneg114);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg114);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer rand978 = new Integer(978);
        tree.add(rand978);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg114);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = new AVLNode<>(rand978);var3.setHeight(0);var3.setBalanceFactor(0);
        AVLNode<Integer> var4 = null;
        var3.setLeft(var4);
        AVLNode<Integer> var5 = null;
        var3.setRight(var5);
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        assertSame(randneg114, tree.remove(randneg114.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand978);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = null;
        otherTree.setLeft(var6);
        AVLNode<Integer> var7 = null;
        otherTree.setRight(var7);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer randneg381 = new Integer(-381);
        tree.add(randneg381);

        // Validating last operation...
        otherTree = new AVLNode<>(rand978);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var8 = new AVLNode<>(randneg381);var8.setHeight(0);var8.setBalanceFactor(0);
        AVLNode<Integer> var9 = null;
        var8.setLeft(var9);
        AVLNode<Integer> var10 = null;
        var8.setRight(var10);
        otherTree.setLeft(var8);
        AVLNode<Integer> var11 = null;
        otherTree.setRight(var11);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        assertSame(randneg381, tree.remove(randneg381.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand978);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var12 = null;
        otherTree.setLeft(var12);
        AVLNode<Integer> var13 = null;
        otherTree.setRight(var13);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer rand880 = new Integer(880);
        tree.add(rand880);

        // Validating last operation...
        otherTree = new AVLNode<>(rand978);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var14 = new AVLNode<>(rand880);var14.setHeight(0);var14.setBalanceFactor(0);
        AVLNode<Integer> var15 = null;
        var14.setLeft(var15);
        AVLNode<Integer> var16 = null;
        var14.setRight(var16);
        otherTree.setLeft(var14);
        AVLNode<Integer> var17 = null;
        otherTree.setRight(var17);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer rand546 = new Integer(546);
        tree.add(rand546);

        // Validating last operation...
        otherTree = new AVLNode<>(rand880);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var18 = new AVLNode<>(rand546);var18.setHeight(0);var18.setBalanceFactor(0);
        AVLNode<Integer> var19 = null;
        var18.setLeft(var19);
        AVLNode<Integer> var20 = null;
        var18.setRight(var20);
        otherTree.setLeft(var18);
        AVLNode<Integer> var21 = new AVLNode<>(rand978);var21.setHeight(0);var21.setBalanceFactor(0);
        AVLNode<Integer> var22 = null;
        var21.setLeft(var22);
        AVLNode<Integer> var23 = null;
        var21.setRight(var23);
        otherTree.setRight(var21);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer randneg223 = new Integer(-223);
        tree.add(randneg223);

        // Validating last operation...
        otherTree = new AVLNode<>(rand880);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var24 = new AVLNode<>(rand546);var24.setHeight(1);var24.setBalanceFactor(1);
        AVLNode<Integer> var25 = new AVLNode<>(randneg223);var25.setHeight(0);var25.setBalanceFactor(0);
        AVLNode<Integer> var26 = null;
        var25.setLeft(var26);
        AVLNode<Integer> var27 = null;
        var25.setRight(var27);
        var24.setLeft(var25);
        AVLNode<Integer> var28 = null;
        var24.setRight(var28);
        otherTree.setLeft(var24);
        AVLNode<Integer> var29 = new AVLNode<>(rand978);var29.setHeight(0);var29.setBalanceFactor(0);
        AVLNode<Integer> var30 = null;
        var29.setLeft(var30);
        AVLNode<Integer> var31 = null;
        var29.setRight(var31);
        otherTree.setRight(var29);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer rand221 = new Integer(221);
        tree.add(rand221);

        // Validating last operation...
        otherTree = new AVLNode<>(rand880);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var32 = new AVLNode<>(rand221);var32.setHeight(1);var32.setBalanceFactor(0);
        AVLNode<Integer> var33 = new AVLNode<>(randneg223);var33.setHeight(0);var33.setBalanceFactor(0);
        AVLNode<Integer> var34 = null;
        var33.setLeft(var34);
        AVLNode<Integer> var35 = null;
        var33.setRight(var35);
        var32.setLeft(var33);
        AVLNode<Integer> var36 = new AVLNode<>(rand546);var36.setHeight(0);var36.setBalanceFactor(0);
        AVLNode<Integer> var37 = null;
        var36.setLeft(var37);
        AVLNode<Integer> var38 = null;
        var36.setRight(var38);
        var32.setRight(var36);
        otherTree.setLeft(var32);
        AVLNode<Integer> var39 = new AVLNode<>(rand978);var39.setHeight(0);var39.setBalanceFactor(0);
        AVLNode<Integer> var40 = null;
        var39.setLeft(var40);
        AVLNode<Integer> var41 = null;
        var39.setRight(var41);
        otherTree.setRight(var39);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer rand716 = new Integer(716);
        tree.add(rand716);

        // Validating last operation...
        otherTree = new AVLNode<>(rand546);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var42 = new AVLNode<>(rand221);var42.setHeight(1);var42.setBalanceFactor(1);
        AVLNode<Integer> var43 = new AVLNode<>(randneg223);var43.setHeight(0);var43.setBalanceFactor(0);
        AVLNode<Integer> var44 = null;
        var43.setLeft(var44);
        AVLNode<Integer> var45 = null;
        var43.setRight(var45);
        var42.setLeft(var43);
        AVLNode<Integer> var46 = null;
        var42.setRight(var46);
        otherTree.setLeft(var42);
        AVLNode<Integer> var47 = new AVLNode<>(rand880);var47.setHeight(1);var47.setBalanceFactor(0);
        AVLNode<Integer> var48 = new AVLNode<>(rand716);var48.setHeight(0);var48.setBalanceFactor(0);
        AVLNode<Integer> var49 = null;
        var48.setLeft(var49);
        AVLNode<Integer> var50 = null;
        var48.setRight(var50);
        var47.setLeft(var48);
        AVLNode<Integer> var51 = new AVLNode<>(rand978);var51.setHeight(0);var51.setBalanceFactor(0);
        AVLNode<Integer> var52 = null;
        var51.setLeft(var52);
        AVLNode<Integer> var53 = null;
        var51.setRight(var53);
        var47.setRight(var51);
        otherTree.setRight(var47);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer rand164 = new Integer(164);
        tree.add(rand164);

        // Validating last operation...
        otherTree = new AVLNode<>(rand546);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var54 = new AVLNode<>(rand164);var54.setHeight(1);var54.setBalanceFactor(0);
        AVLNode<Integer> var55 = new AVLNode<>(randneg223);var55.setHeight(0);var55.setBalanceFactor(0);
        AVLNode<Integer> var56 = null;
        var55.setLeft(var56);
        AVLNode<Integer> var57 = null;
        var55.setRight(var57);
        var54.setLeft(var55);
        AVLNode<Integer> var58 = new AVLNode<>(rand221);var58.setHeight(0);var58.setBalanceFactor(0);
        AVLNode<Integer> var59 = null;
        var58.setLeft(var59);
        AVLNode<Integer> var60 = null;
        var58.setRight(var60);
        var54.setRight(var58);
        otherTree.setLeft(var54);
        AVLNode<Integer> var61 = new AVLNode<>(rand880);var61.setHeight(1);var61.setBalanceFactor(0);
        AVLNode<Integer> var62 = new AVLNode<>(rand716);var62.setHeight(0);var62.setBalanceFactor(0);
        AVLNode<Integer> var63 = null;
        var62.setLeft(var63);
        AVLNode<Integer> var64 = null;
        var62.setRight(var64);
        var61.setLeft(var62);
        AVLNode<Integer> var65 = new AVLNode<>(rand978);var65.setHeight(0);var65.setBalanceFactor(0);
        AVLNode<Integer> var66 = null;
        var65.setLeft(var66);
        AVLNode<Integer> var67 = null;
        var65.setRight(var67);
        var61.setRight(var65);
        otherTree.setRight(var61);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer randneg418 = new Integer(-418);
        tree.add(randneg418);

        // Validating last operation...
        otherTree = new AVLNode<>(rand546);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var68 = new AVLNode<>(rand164);var68.setHeight(2);var68.setBalanceFactor(1);
        AVLNode<Integer> var69 = new AVLNode<>(randneg223);var69.setHeight(1);var69.setBalanceFactor(1);
        AVLNode<Integer> var70 = new AVLNode<>(randneg418);var70.setHeight(0);var70.setBalanceFactor(0);
        AVLNode<Integer> var71 = null;
        var70.setLeft(var71);
        AVLNode<Integer> var72 = null;
        var70.setRight(var72);
        var69.setLeft(var70);
        AVLNode<Integer> var73 = null;
        var69.setRight(var73);
        var68.setLeft(var69);
        AVLNode<Integer> var74 = new AVLNode<>(rand221);var74.setHeight(0);var74.setBalanceFactor(0);
        AVLNode<Integer> var75 = null;
        var74.setLeft(var75);
        AVLNode<Integer> var76 = null;
        var74.setRight(var76);
        var68.setRight(var74);
        otherTree.setLeft(var68);
        AVLNode<Integer> var77 = new AVLNode<>(rand880);var77.setHeight(1);var77.setBalanceFactor(0);
        AVLNode<Integer> var78 = new AVLNode<>(rand716);var78.setHeight(0);var78.setBalanceFactor(0);
        AVLNode<Integer> var79 = null;
        var78.setLeft(var79);
        AVLNode<Integer> var80 = null;
        var78.setRight(var80);
        var77.setLeft(var78);
        AVLNode<Integer> var81 = new AVLNode<>(rand978);var81.setHeight(0);var81.setBalanceFactor(0);
        AVLNode<Integer> var82 = null;
        var81.setLeft(var82);
        AVLNode<Integer> var83 = null;
        var81.setRight(var83);
        var77.setRight(var81);
        otherTree.setRight(var77);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer rand430 = new Integer(430);
        tree.add(rand430);

        // Validating last operation...
        otherTree = new AVLNode<>(rand546);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var84 = new AVLNode<>(rand164);var84.setHeight(2);var84.setBalanceFactor(0);
        AVLNode<Integer> var85 = new AVLNode<>(randneg223);var85.setHeight(1);var85.setBalanceFactor(1);
        AVLNode<Integer> var86 = new AVLNode<>(randneg418);var86.setHeight(0);var86.setBalanceFactor(0);
        AVLNode<Integer> var87 = null;
        var86.setLeft(var87);
        AVLNode<Integer> var88 = null;
        var86.setRight(var88);
        var85.setLeft(var86);
        AVLNode<Integer> var89 = null;
        var85.setRight(var89);
        var84.setLeft(var85);
        AVLNode<Integer> var90 = new AVLNode<>(rand221);var90.setHeight(1);var90.setBalanceFactor(-1);
        AVLNode<Integer> var91 = null;
        var90.setLeft(var91);
        AVLNode<Integer> var92 = new AVLNode<>(rand430);var92.setHeight(0);var92.setBalanceFactor(0);
        AVLNode<Integer> var93 = null;
        var92.setLeft(var93);
        AVLNode<Integer> var94 = null;
        var92.setRight(var94);
        var90.setRight(var92);
        var84.setRight(var90);
        otherTree.setLeft(var84);
        AVLNode<Integer> var95 = new AVLNode<>(rand880);var95.setHeight(1);var95.setBalanceFactor(0);
        AVLNode<Integer> var96 = new AVLNode<>(rand716);var96.setHeight(0);var96.setBalanceFactor(0);
        AVLNode<Integer> var97 = null;
        var96.setLeft(var97);
        AVLNode<Integer> var98 = null;
        var96.setRight(var98);
        var95.setLeft(var96);
        AVLNode<Integer> var99 = new AVLNode<>(rand978);var99.setHeight(0);var99.setBalanceFactor(0);
        AVLNode<Integer> var100 = null;
        var99.setLeft(var100);
        AVLNode<Integer> var101 = null;
        var99.setRight(var101);
        var95.setRight(var99);
        otherTree.setRight(var95);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer randneg555 = new Integer(-555);
        tree.add(randneg555);

        // Validating last operation...
        otherTree = new AVLNode<>(rand546);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var102 = new AVLNode<>(rand164);var102.setHeight(2);var102.setBalanceFactor(0);
        AVLNode<Integer> var103 = new AVLNode<>(randneg418);var103.setHeight(1);var103.setBalanceFactor(0);
        AVLNode<Integer> var104 = new AVLNode<>(randneg555);var104.setHeight(0);var104.setBalanceFactor(0);
        AVLNode<Integer> var105 = null;
        var104.setLeft(var105);
        AVLNode<Integer> var106 = null;
        var104.setRight(var106);
        var103.setLeft(var104);
        AVLNode<Integer> var107 = new AVLNode<>(randneg223);var107.setHeight(0);var107.setBalanceFactor(0);
        AVLNode<Integer> var108 = null;
        var107.setLeft(var108);
        AVLNode<Integer> var109 = null;
        var107.setRight(var109);
        var103.setRight(var107);
        var102.setLeft(var103);
        AVLNode<Integer> var110 = new AVLNode<>(rand221);var110.setHeight(1);var110.setBalanceFactor(-1);
        AVLNode<Integer> var111 = null;
        var110.setLeft(var111);
        AVLNode<Integer> var112 = new AVLNode<>(rand430);var112.setHeight(0);var112.setBalanceFactor(0);
        AVLNode<Integer> var113 = null;
        var112.setLeft(var113);
        AVLNode<Integer> var114 = null;
        var112.setRight(var114);
        var110.setRight(var112);
        var102.setRight(var110);
        otherTree.setLeft(var102);
        AVLNode<Integer> var115 = new AVLNode<>(rand880);var115.setHeight(1);var115.setBalanceFactor(0);
        AVLNode<Integer> var116 = new AVLNode<>(rand716);var116.setHeight(0);var116.setBalanceFactor(0);
        AVLNode<Integer> var117 = null;
        var116.setLeft(var117);
        AVLNode<Integer> var118 = null;
        var116.setRight(var118);
        var115.setLeft(var116);
        AVLNode<Integer> var119 = new AVLNode<>(rand978);var119.setHeight(0);var119.setBalanceFactor(0);
        AVLNode<Integer> var120 = null;
        var119.setLeft(var120);
        AVLNode<Integer> var121 = null;
        var119.setRight(var121);
        var115.setRight(var119);
        otherTree.setRight(var115);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer randneg199 = new Integer(-199);
        tree.add(randneg199);

        // Validating last operation...
        otherTree = new AVLNode<>(rand164);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var122 = new AVLNode<>(randneg418);var122.setHeight(2);var122.setBalanceFactor(-1);
        AVLNode<Integer> var123 = new AVLNode<>(randneg555);var123.setHeight(0);var123.setBalanceFactor(0);
        AVLNode<Integer> var124 = null;
        var123.setLeft(var124);
        AVLNode<Integer> var125 = null;
        var123.setRight(var125);
        var122.setLeft(var123);
        AVLNode<Integer> var126 = new AVLNode<>(randneg223);var126.setHeight(1);var126.setBalanceFactor(-1);
        AVLNode<Integer> var127 = null;
        var126.setLeft(var127);
        AVLNode<Integer> var128 = new AVLNode<>(randneg199);var128.setHeight(0);var128.setBalanceFactor(0);
        AVLNode<Integer> var129 = null;
        var128.setLeft(var129);
        AVLNode<Integer> var130 = null;
        var128.setRight(var130);
        var126.setRight(var128);
        var122.setRight(var126);
        otherTree.setLeft(var122);
        AVLNode<Integer> var131 = new AVLNode<>(rand546);var131.setHeight(2);var131.setBalanceFactor(0);
        AVLNode<Integer> var132 = new AVLNode<>(rand221);var132.setHeight(1);var132.setBalanceFactor(-1);
        AVLNode<Integer> var133 = null;
        var132.setLeft(var133);
        AVLNode<Integer> var134 = new AVLNode<>(rand430);var134.setHeight(0);var134.setBalanceFactor(0);
        AVLNode<Integer> var135 = null;
        var134.setLeft(var135);
        AVLNode<Integer> var136 = null;
        var134.setRight(var136);
        var132.setRight(var134);
        var131.setLeft(var132);
        AVLNode<Integer> var137 = new AVLNode<>(rand880);var137.setHeight(1);var137.setBalanceFactor(0);
        AVLNode<Integer> var138 = new AVLNode<>(rand716);var138.setHeight(0);var138.setBalanceFactor(0);
        AVLNode<Integer> var139 = null;
        var138.setLeft(var139);
        AVLNode<Integer> var140 = null;
        var138.setRight(var140);
        var137.setLeft(var138);
        AVLNode<Integer> var141 = new AVLNode<>(rand978);var141.setHeight(0);var141.setBalanceFactor(0);
        AVLNode<Integer> var142 = null;
        var141.setLeft(var142);
        AVLNode<Integer> var143 = null;
        var141.setRight(var143);
        var137.setRight(var141);
        var131.setRight(var137);
        otherTree.setRight(var131);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #3: ==========
    @Test(timeout = TIMEOUT)
    public void test3() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg284 = new Integer(-284);
        tree.add(randneg284);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg284);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer rand836 = new Integer(836);
        tree.add(rand836);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg284);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = new AVLNode<>(rand836);var3.setHeight(0);var3.setBalanceFactor(0);
        AVLNode<Integer> var4 = null;
        var3.setLeft(var4);
        AVLNode<Integer> var5 = null;
        var3.setRight(var5);
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer randneg950 = new Integer(-950);
        tree.add(randneg950);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg284);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(randneg950);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(rand836);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer randneg194 = new Integer(-194);
        tree.add(randneg194);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg284);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var12 = new AVLNode<>(randneg950);var12.setHeight(0);var12.setBalanceFactor(0);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = null;
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var15 = new AVLNode<>(rand836);var15.setHeight(1);var15.setBalanceFactor(1);
        AVLNode<Integer> var16 = new AVLNode<>(randneg194);var16.setHeight(0);var16.setBalanceFactor(0);
        AVLNode<Integer> var17 = null;
        var16.setLeft(var17);
        AVLNode<Integer> var18 = null;
        var16.setRight(var18);
        var15.setLeft(var16);
        AVLNode<Integer> var19 = null;
        var15.setRight(var19);
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer randneg205 = new Integer(-205);
        tree.add(randneg205);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg284);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var20 = new AVLNode<>(randneg950);var20.setHeight(0);var20.setBalanceFactor(0);
        AVLNode<Integer> var21 = null;
        var20.setLeft(var21);
        AVLNode<Integer> var22 = null;
        var20.setRight(var22);
        otherTree.setLeft(var20);
        AVLNode<Integer> var23 = new AVLNode<>(randneg194);var23.setHeight(1);var23.setBalanceFactor(0);
        AVLNode<Integer> var24 = new AVLNode<>(randneg205);var24.setHeight(0);var24.setBalanceFactor(0);
        AVLNode<Integer> var25 = null;
        var24.setLeft(var25);
        AVLNode<Integer> var26 = null;
        var24.setRight(var26);
        var23.setLeft(var24);
        AVLNode<Integer> var27 = new AVLNode<>(rand836);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        var23.setRight(var27);
        otherTree.setRight(var23);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer rand994 = new Integer(994);
        tree.add(rand994);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg194);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var30 = new AVLNode<>(randneg284);var30.setHeight(1);var30.setBalanceFactor(0);
        AVLNode<Integer> var31 = new AVLNode<>(randneg950);var31.setHeight(0);var31.setBalanceFactor(0);
        AVLNode<Integer> var32 = null;
        var31.setLeft(var32);
        AVLNode<Integer> var33 = null;
        var31.setRight(var33);
        var30.setLeft(var31);
        AVLNode<Integer> var34 = new AVLNode<>(randneg205);var34.setHeight(0);var34.setBalanceFactor(0);
        AVLNode<Integer> var35 = null;
        var34.setLeft(var35);
        AVLNode<Integer> var36 = null;
        var34.setRight(var36);
        var30.setRight(var34);
        otherTree.setLeft(var30);
        AVLNode<Integer> var37 = new AVLNode<>(rand836);var37.setHeight(1);var37.setBalanceFactor(-1);
        AVLNode<Integer> var38 = null;
        var37.setLeft(var38);
        AVLNode<Integer> var39 = new AVLNode<>(rand994);var39.setHeight(0);var39.setBalanceFactor(0);
        AVLNode<Integer> var40 = null;
        var39.setLeft(var40);
        AVLNode<Integer> var41 = null;
        var39.setRight(var41);
        var37.setRight(var39);
        otherTree.setRight(var37);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer rand924 = new Integer(924);
        tree.add(rand924);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg194);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var42 = new AVLNode<>(randneg284);var42.setHeight(1);var42.setBalanceFactor(0);
        AVLNode<Integer> var43 = new AVLNode<>(randneg950);var43.setHeight(0);var43.setBalanceFactor(0);
        AVLNode<Integer> var44 = null;
        var43.setLeft(var44);
        AVLNode<Integer> var45 = null;
        var43.setRight(var45);
        var42.setLeft(var43);
        AVLNode<Integer> var46 = new AVLNode<>(randneg205);var46.setHeight(0);var46.setBalanceFactor(0);
        AVLNode<Integer> var47 = null;
        var46.setLeft(var47);
        AVLNode<Integer> var48 = null;
        var46.setRight(var48);
        var42.setRight(var46);
        otherTree.setLeft(var42);
        AVLNode<Integer> var49 = new AVLNode<>(rand924);var49.setHeight(1);var49.setBalanceFactor(0);
        AVLNode<Integer> var50 = new AVLNode<>(rand836);var50.setHeight(0);var50.setBalanceFactor(0);
        AVLNode<Integer> var51 = null;
        var50.setLeft(var51);
        AVLNode<Integer> var52 = null;
        var50.setRight(var52);
        var49.setLeft(var50);
        AVLNode<Integer> var53 = new AVLNode<>(rand994);var53.setHeight(0);var53.setBalanceFactor(0);
        AVLNode<Integer> var54 = null;
        var53.setLeft(var54);
        AVLNode<Integer> var55 = null;
        var53.setRight(var55);
        var49.setRight(var53);
        otherTree.setRight(var49);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        assertSame(rand924, tree.remove(rand924.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg194);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var56 = new AVLNode<>(randneg284);var56.setHeight(1);var56.setBalanceFactor(0);
        AVLNode<Integer> var57 = new AVLNode<>(randneg950);var57.setHeight(0);var57.setBalanceFactor(0);
        AVLNode<Integer> var58 = null;
        var57.setLeft(var58);
        AVLNode<Integer> var59 = null;
        var57.setRight(var59);
        var56.setLeft(var57);
        AVLNode<Integer> var60 = new AVLNode<>(randneg205);var60.setHeight(0);var60.setBalanceFactor(0);
        AVLNode<Integer> var61 = null;
        var60.setLeft(var61);
        AVLNode<Integer> var62 = null;
        var60.setRight(var62);
        var56.setRight(var60);
        otherTree.setLeft(var56);
        AVLNode<Integer> var63 = new AVLNode<>(rand836);var63.setHeight(1);var63.setBalanceFactor(-1);
        AVLNode<Integer> var64 = null;
        var63.setLeft(var64);
        AVLNode<Integer> var65 = new AVLNode<>(rand994);var65.setHeight(0);var65.setBalanceFactor(0);
        AVLNode<Integer> var66 = null;
        var65.setLeft(var66);
        AVLNode<Integer> var67 = null;
        var65.setRight(var67);
        var63.setRight(var65);
        otherTree.setRight(var63);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer rand986 = new Integer(986);
        tree.add(rand986);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg194);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var68 = new AVLNode<>(randneg284);var68.setHeight(1);var68.setBalanceFactor(0);
        AVLNode<Integer> var69 = new AVLNode<>(randneg950);var69.setHeight(0);var69.setBalanceFactor(0);
        AVLNode<Integer> var70 = null;
        var69.setLeft(var70);
        AVLNode<Integer> var71 = null;
        var69.setRight(var71);
        var68.setLeft(var69);
        AVLNode<Integer> var72 = new AVLNode<>(randneg205);var72.setHeight(0);var72.setBalanceFactor(0);
        AVLNode<Integer> var73 = null;
        var72.setLeft(var73);
        AVLNode<Integer> var74 = null;
        var72.setRight(var74);
        var68.setRight(var72);
        otherTree.setLeft(var68);
        AVLNode<Integer> var75 = new AVLNode<>(rand986);var75.setHeight(1);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = new AVLNode<>(rand836);var76.setHeight(0);var76.setBalanceFactor(0);
        AVLNode<Integer> var77 = null;
        var76.setLeft(var77);
        AVLNode<Integer> var78 = null;
        var76.setRight(var78);
        var75.setLeft(var76);
        AVLNode<Integer> var79 = new AVLNode<>(rand994);var79.setHeight(0);var79.setBalanceFactor(0);
        AVLNode<Integer> var80 = null;
        var79.setLeft(var80);
        AVLNode<Integer> var81 = null;
        var79.setRight(var81);
        var75.setRight(var79);
        otherTree.setRight(var75);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer rand256 = new Integer(256);
        tree.add(rand256);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg194);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var82 = new AVLNode<>(randneg284);var82.setHeight(1);var82.setBalanceFactor(0);
        AVLNode<Integer> var83 = new AVLNode<>(randneg950);var83.setHeight(0);var83.setBalanceFactor(0);
        AVLNode<Integer> var84 = null;
        var83.setLeft(var84);
        AVLNode<Integer> var85 = null;
        var83.setRight(var85);
        var82.setLeft(var83);
        AVLNode<Integer> var86 = new AVLNode<>(randneg205);var86.setHeight(0);var86.setBalanceFactor(0);
        AVLNode<Integer> var87 = null;
        var86.setLeft(var87);
        AVLNode<Integer> var88 = null;
        var86.setRight(var88);
        var82.setRight(var86);
        otherTree.setLeft(var82);
        AVLNode<Integer> var89 = new AVLNode<>(rand986);var89.setHeight(2);var89.setBalanceFactor(1);
        AVLNode<Integer> var90 = new AVLNode<>(rand836);var90.setHeight(1);var90.setBalanceFactor(1);
        AVLNode<Integer> var91 = new AVLNode<>(rand256);var91.setHeight(0);var91.setBalanceFactor(0);
        AVLNode<Integer> var92 = null;
        var91.setLeft(var92);
        AVLNode<Integer> var93 = null;
        var91.setRight(var93);
        var90.setLeft(var91);
        AVLNode<Integer> var94 = null;
        var90.setRight(var94);
        var89.setLeft(var90);
        AVLNode<Integer> var95 = new AVLNode<>(rand994);var95.setHeight(0);var95.setBalanceFactor(0);
        AVLNode<Integer> var96 = null;
        var95.setLeft(var96);
        AVLNode<Integer> var97 = null;
        var95.setRight(var97);
        var89.setRight(var95);
        otherTree.setRight(var89);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer rand195 = new Integer(195);
        tree.add(rand195);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg194);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var98 = new AVLNode<>(randneg284);var98.setHeight(1);var98.setBalanceFactor(0);
        AVLNode<Integer> var99 = new AVLNode<>(randneg950);var99.setHeight(0);var99.setBalanceFactor(0);
        AVLNode<Integer> var100 = null;
        var99.setLeft(var100);
        AVLNode<Integer> var101 = null;
        var99.setRight(var101);
        var98.setLeft(var99);
        AVLNode<Integer> var102 = new AVLNode<>(randneg205);var102.setHeight(0);var102.setBalanceFactor(0);
        AVLNode<Integer> var103 = null;
        var102.setLeft(var103);
        AVLNode<Integer> var104 = null;
        var102.setRight(var104);
        var98.setRight(var102);
        otherTree.setLeft(var98);
        AVLNode<Integer> var105 = new AVLNode<>(rand986);var105.setHeight(2);var105.setBalanceFactor(1);
        AVLNode<Integer> var106 = new AVLNode<>(rand256);var106.setHeight(1);var106.setBalanceFactor(0);
        AVLNode<Integer> var107 = new AVLNode<>(rand195);var107.setHeight(0);var107.setBalanceFactor(0);
        AVLNode<Integer> var108 = null;
        var107.setLeft(var108);
        AVLNode<Integer> var109 = null;
        var107.setRight(var109);
        var106.setLeft(var107);
        AVLNode<Integer> var110 = new AVLNode<>(rand836);var110.setHeight(0);var110.setBalanceFactor(0);
        AVLNode<Integer> var111 = null;
        var110.setLeft(var111);
        AVLNode<Integer> var112 = null;
        var110.setRight(var112);
        var106.setRight(var110);
        var105.setLeft(var106);
        AVLNode<Integer> var113 = new AVLNode<>(rand994);var113.setHeight(0);var113.setBalanceFactor(0);
        AVLNode<Integer> var114 = null;
        var113.setLeft(var114);
        AVLNode<Integer> var115 = null;
        var113.setRight(var115);
        var105.setRight(var113);
        otherTree.setRight(var105);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer randneg377 = new Integer(-377);
        tree.add(randneg377);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg194);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var116 = new AVLNode<>(randneg284);var116.setHeight(2);var116.setBalanceFactor(1);
        AVLNode<Integer> var117 = new AVLNode<>(randneg950);var117.setHeight(1);var117.setBalanceFactor(-1);
        AVLNode<Integer> var118 = null;
        var117.setLeft(var118);
        AVLNode<Integer> var119 = new AVLNode<>(randneg377);var119.setHeight(0);var119.setBalanceFactor(0);
        AVLNode<Integer> var120 = null;
        var119.setLeft(var120);
        AVLNode<Integer> var121 = null;
        var119.setRight(var121);
        var117.setRight(var119);
        var116.setLeft(var117);
        AVLNode<Integer> var122 = new AVLNode<>(randneg205);var122.setHeight(0);var122.setBalanceFactor(0);
        AVLNode<Integer> var123 = null;
        var122.setLeft(var123);
        AVLNode<Integer> var124 = null;
        var122.setRight(var124);
        var116.setRight(var122);
        otherTree.setLeft(var116);
        AVLNode<Integer> var125 = new AVLNode<>(rand986);var125.setHeight(2);var125.setBalanceFactor(1);
        AVLNode<Integer> var126 = new AVLNode<>(rand256);var126.setHeight(1);var126.setBalanceFactor(0);
        AVLNode<Integer> var127 = new AVLNode<>(rand195);var127.setHeight(0);var127.setBalanceFactor(0);
        AVLNode<Integer> var128 = null;
        var127.setLeft(var128);
        AVLNode<Integer> var129 = null;
        var127.setRight(var129);
        var126.setLeft(var127);
        AVLNode<Integer> var130 = new AVLNode<>(rand836);var130.setHeight(0);var130.setBalanceFactor(0);
        AVLNode<Integer> var131 = null;
        var130.setLeft(var131);
        AVLNode<Integer> var132 = null;
        var130.setRight(var132);
        var126.setRight(var130);
        var125.setLeft(var126);
        AVLNode<Integer> var133 = new AVLNode<>(rand994);var133.setHeight(0);var133.setBalanceFactor(0);
        AVLNode<Integer> var134 = null;
        var133.setLeft(var134);
        AVLNode<Integer> var135 = null;
        var133.setRight(var135);
        var125.setRight(var133);
        otherTree.setRight(var125);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer rand49 = new Integer(49);
        tree.add(rand49);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg194);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var136 = new AVLNode<>(randneg284);var136.setHeight(2);var136.setBalanceFactor(1);
        AVLNode<Integer> var137 = new AVLNode<>(randneg950);var137.setHeight(1);var137.setBalanceFactor(-1);
        AVLNode<Integer> var138 = null;
        var137.setLeft(var138);
        AVLNode<Integer> var139 = new AVLNode<>(randneg377);var139.setHeight(0);var139.setBalanceFactor(0);
        AVLNode<Integer> var140 = null;
        var139.setLeft(var140);
        AVLNode<Integer> var141 = null;
        var139.setRight(var141);
        var137.setRight(var139);
        var136.setLeft(var137);
        AVLNode<Integer> var142 = new AVLNode<>(randneg205);var142.setHeight(0);var142.setBalanceFactor(0);
        AVLNode<Integer> var143 = null;
        var142.setLeft(var143);
        AVLNode<Integer> var144 = null;
        var142.setRight(var144);
        var136.setRight(var142);
        otherTree.setLeft(var136);
        AVLNode<Integer> var145 = new AVLNode<>(rand256);var145.setHeight(2);var145.setBalanceFactor(0);
        AVLNode<Integer> var146 = new AVLNode<>(rand195);var146.setHeight(1);var146.setBalanceFactor(1);
        AVLNode<Integer> var147 = new AVLNode<>(rand49);var147.setHeight(0);var147.setBalanceFactor(0);
        AVLNode<Integer> var148 = null;
        var147.setLeft(var148);
        AVLNode<Integer> var149 = null;
        var147.setRight(var149);
        var146.setLeft(var147);
        AVLNode<Integer> var150 = null;
        var146.setRight(var150);
        var145.setLeft(var146);
        AVLNode<Integer> var151 = new AVLNode<>(rand986);var151.setHeight(1);var151.setBalanceFactor(0);
        AVLNode<Integer> var152 = new AVLNode<>(rand836);var152.setHeight(0);var152.setBalanceFactor(0);
        AVLNode<Integer> var153 = null;
        var152.setLeft(var153);
        AVLNode<Integer> var154 = null;
        var152.setRight(var154);
        var151.setLeft(var152);
        AVLNode<Integer> var155 = new AVLNode<>(rand994);var155.setHeight(0);var155.setBalanceFactor(0);
        AVLNode<Integer> var156 = null;
        var155.setLeft(var156);
        AVLNode<Integer> var157 = null;
        var155.setRight(var157);
        var151.setRight(var155);
        var145.setRight(var151);
        otherTree.setRight(var145);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer rand802 = new Integer(802);
        tree.add(rand802);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg194);otherTree.setHeight(4);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var158 = new AVLNode<>(randneg284);var158.setHeight(2);var158.setBalanceFactor(1);
        AVLNode<Integer> var159 = new AVLNode<>(randneg950);var159.setHeight(1);var159.setBalanceFactor(-1);
        AVLNode<Integer> var160 = null;
        var159.setLeft(var160);
        AVLNode<Integer> var161 = new AVLNode<>(randneg377);var161.setHeight(0);var161.setBalanceFactor(0);
        AVLNode<Integer> var162 = null;
        var161.setLeft(var162);
        AVLNode<Integer> var163 = null;
        var161.setRight(var163);
        var159.setRight(var161);
        var158.setLeft(var159);
        AVLNode<Integer> var164 = new AVLNode<>(randneg205);var164.setHeight(0);var164.setBalanceFactor(0);
        AVLNode<Integer> var165 = null;
        var164.setLeft(var165);
        AVLNode<Integer> var166 = null;
        var164.setRight(var166);
        var158.setRight(var164);
        otherTree.setLeft(var158);
        AVLNode<Integer> var167 = new AVLNode<>(rand256);var167.setHeight(3);var167.setBalanceFactor(-1);
        AVLNode<Integer> var168 = new AVLNode<>(rand195);var168.setHeight(1);var168.setBalanceFactor(1);
        AVLNode<Integer> var169 = new AVLNode<>(rand49);var169.setHeight(0);var169.setBalanceFactor(0);
        AVLNode<Integer> var170 = null;
        var169.setLeft(var170);
        AVLNode<Integer> var171 = null;
        var169.setRight(var171);
        var168.setLeft(var169);
        AVLNode<Integer> var172 = null;
        var168.setRight(var172);
        var167.setLeft(var168);
        AVLNode<Integer> var173 = new AVLNode<>(rand986);var173.setHeight(2);var173.setBalanceFactor(1);
        AVLNode<Integer> var174 = new AVLNode<>(rand836);var174.setHeight(1);var174.setBalanceFactor(1);
        AVLNode<Integer> var175 = new AVLNode<>(rand802);var175.setHeight(0);var175.setBalanceFactor(0);
        AVLNode<Integer> var176 = null;
        var175.setLeft(var176);
        AVLNode<Integer> var177 = null;
        var175.setRight(var177);
        var174.setLeft(var175);
        AVLNode<Integer> var178 = null;
        var174.setRight(var178);
        var173.setLeft(var174);
        AVLNode<Integer> var179 = new AVLNode<>(rand994);var179.setHeight(0);var179.setBalanceFactor(0);
        AVLNode<Integer> var180 = null;
        var179.setLeft(var180);
        AVLNode<Integer> var181 = null;
        var179.setRight(var181);
        var173.setRight(var179);
        var167.setRight(var173);
        otherTree.setRight(var167);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer rand104 = new Integer(104);
        tree.add(rand104);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg194);otherTree.setHeight(4);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var182 = new AVLNode<>(randneg284);var182.setHeight(2);var182.setBalanceFactor(1);
        AVLNode<Integer> var183 = new AVLNode<>(randneg950);var183.setHeight(1);var183.setBalanceFactor(-1);
        AVLNode<Integer> var184 = null;
        var183.setLeft(var184);
        AVLNode<Integer> var185 = new AVLNode<>(randneg377);var185.setHeight(0);var185.setBalanceFactor(0);
        AVLNode<Integer> var186 = null;
        var185.setLeft(var186);
        AVLNode<Integer> var187 = null;
        var185.setRight(var187);
        var183.setRight(var185);
        var182.setLeft(var183);
        AVLNode<Integer> var188 = new AVLNode<>(randneg205);var188.setHeight(0);var188.setBalanceFactor(0);
        AVLNode<Integer> var189 = null;
        var188.setLeft(var189);
        AVLNode<Integer> var190 = null;
        var188.setRight(var190);
        var182.setRight(var188);
        otherTree.setLeft(var182);
        AVLNode<Integer> var191 = new AVLNode<>(rand256);var191.setHeight(3);var191.setBalanceFactor(-1);
        AVLNode<Integer> var192 = new AVLNode<>(rand104);var192.setHeight(1);var192.setBalanceFactor(0);
        AVLNode<Integer> var193 = new AVLNode<>(rand49);var193.setHeight(0);var193.setBalanceFactor(0);
        AVLNode<Integer> var194 = null;
        var193.setLeft(var194);
        AVLNode<Integer> var195 = null;
        var193.setRight(var195);
        var192.setLeft(var193);
        AVLNode<Integer> var196 = new AVLNode<>(rand195);var196.setHeight(0);var196.setBalanceFactor(0);
        AVLNode<Integer> var197 = null;
        var196.setLeft(var197);
        AVLNode<Integer> var198 = null;
        var196.setRight(var198);
        var192.setRight(var196);
        var191.setLeft(var192);
        AVLNode<Integer> var199 = new AVLNode<>(rand986);var199.setHeight(2);var199.setBalanceFactor(1);
        AVLNode<Integer> var200 = new AVLNode<>(rand836);var200.setHeight(1);var200.setBalanceFactor(1);
        AVLNode<Integer> var201 = new AVLNode<>(rand802);var201.setHeight(0);var201.setBalanceFactor(0);
        AVLNode<Integer> var202 = null;
        var201.setLeft(var202);
        AVLNode<Integer> var203 = null;
        var201.setRight(var203);
        var200.setLeft(var201);
        AVLNode<Integer> var204 = null;
        var200.setRight(var204);
        var199.setLeft(var200);
        AVLNode<Integer> var205 = new AVLNode<>(rand994);var205.setHeight(0);var205.setBalanceFactor(0);
        AVLNode<Integer> var206 = null;
        var205.setLeft(var206);
        AVLNode<Integer> var207 = null;
        var205.setRight(var207);
        var199.setRight(var205);
        var191.setRight(var199);
        otherTree.setRight(var191);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #4: ==========
    @Test(timeout = TIMEOUT)
    public void test4() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer rand261 = new Integer(261);
        tree.add(rand261);

        // Validating last operation...
        otherTree = new AVLNode<>(rand261);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer rand169 = new Integer(169);
        tree.add(rand169);

        // Validating last operation...
        otherTree = new AVLNode<>(rand261);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var2 = new AVLNode<>(rand169);var2.setHeight(0);var2.setBalanceFactor(0);
        AVLNode<Integer> var3 = null;
        var2.setLeft(var3);
        AVLNode<Integer> var4 = null;
        var2.setRight(var4);
        otherTree.setLeft(var2);
        AVLNode<Integer> var5 = null;
        otherTree.setRight(var5);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer randneg109 = new Integer(-109);
        tree.add(randneg109);

        // Validating last operation...
        otherTree = new AVLNode<>(rand169);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(randneg109);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(rand261);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer rand50 = new Integer(50);
        tree.add(rand50);

        // Validating last operation...
        otherTree = new AVLNode<>(rand169);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var12 = new AVLNode<>(randneg109);var12.setHeight(1);var12.setBalanceFactor(-1);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = new AVLNode<>(rand50);var14.setHeight(0);var14.setBalanceFactor(0);
        AVLNode<Integer> var15 = null;
        var14.setLeft(var15);
        AVLNode<Integer> var16 = null;
        var14.setRight(var16);
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var17 = new AVLNode<>(rand261);var17.setHeight(0);var17.setBalanceFactor(0);
        AVLNode<Integer> var18 = null;
        var17.setLeft(var18);
        AVLNode<Integer> var19 = null;
        var17.setRight(var19);
        otherTree.setRight(var17);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer randneg960 = new Integer(-960);
        tree.add(randneg960);

        // Validating last operation...
        otherTree = new AVLNode<>(rand169);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var20 = new AVLNode<>(randneg109);var20.setHeight(1);var20.setBalanceFactor(0);
        AVLNode<Integer> var21 = new AVLNode<>(randneg960);var21.setHeight(0);var21.setBalanceFactor(0);
        AVLNode<Integer> var22 = null;
        var21.setLeft(var22);
        AVLNode<Integer> var23 = null;
        var21.setRight(var23);
        var20.setLeft(var21);
        AVLNode<Integer> var24 = new AVLNode<>(rand50);var24.setHeight(0);var24.setBalanceFactor(0);
        AVLNode<Integer> var25 = null;
        var24.setLeft(var25);
        AVLNode<Integer> var26 = null;
        var24.setRight(var26);
        var20.setRight(var24);
        otherTree.setLeft(var20);
        AVLNode<Integer> var27 = new AVLNode<>(rand261);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        otherTree.setRight(var27);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer randneg352 = new Integer(-352);
        tree.add(randneg352);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg109);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var30 = new AVLNode<>(randneg960);var30.setHeight(1);var30.setBalanceFactor(-1);
        AVLNode<Integer> var31 = null;
        var30.setLeft(var31);
        AVLNode<Integer> var32 = new AVLNode<>(randneg352);var32.setHeight(0);var32.setBalanceFactor(0);
        AVLNode<Integer> var33 = null;
        var32.setLeft(var33);
        AVLNode<Integer> var34 = null;
        var32.setRight(var34);
        var30.setRight(var32);
        otherTree.setLeft(var30);
        AVLNode<Integer> var35 = new AVLNode<>(rand169);var35.setHeight(1);var35.setBalanceFactor(0);
        AVLNode<Integer> var36 = new AVLNode<>(rand50);var36.setHeight(0);var36.setBalanceFactor(0);
        AVLNode<Integer> var37 = null;
        var36.setLeft(var37);
        AVLNode<Integer> var38 = null;
        var36.setRight(var38);
        var35.setLeft(var36);
        AVLNode<Integer> var39 = new AVLNode<>(rand261);var39.setHeight(0);var39.setBalanceFactor(0);
        AVLNode<Integer> var40 = null;
        var39.setLeft(var40);
        AVLNode<Integer> var41 = null;
        var39.setRight(var41);
        var35.setRight(var39);
        otherTree.setRight(var35);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer randneg694 = new Integer(-694);
        tree.add(randneg694);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg109);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var42 = new AVLNode<>(randneg694);var42.setHeight(1);var42.setBalanceFactor(0);
        AVLNode<Integer> var43 = new AVLNode<>(randneg960);var43.setHeight(0);var43.setBalanceFactor(0);
        AVLNode<Integer> var44 = null;
        var43.setLeft(var44);
        AVLNode<Integer> var45 = null;
        var43.setRight(var45);
        var42.setLeft(var43);
        AVLNode<Integer> var46 = new AVLNode<>(randneg352);var46.setHeight(0);var46.setBalanceFactor(0);
        AVLNode<Integer> var47 = null;
        var46.setLeft(var47);
        AVLNode<Integer> var48 = null;
        var46.setRight(var48);
        var42.setRight(var46);
        otherTree.setLeft(var42);
        AVLNode<Integer> var49 = new AVLNode<>(rand169);var49.setHeight(1);var49.setBalanceFactor(0);
        AVLNode<Integer> var50 = new AVLNode<>(rand50);var50.setHeight(0);var50.setBalanceFactor(0);
        AVLNode<Integer> var51 = null;
        var50.setLeft(var51);
        AVLNode<Integer> var52 = null;
        var50.setRight(var52);
        var49.setLeft(var50);
        AVLNode<Integer> var53 = new AVLNode<>(rand261);var53.setHeight(0);var53.setBalanceFactor(0);
        AVLNode<Integer> var54 = null;
        var53.setLeft(var54);
        AVLNode<Integer> var55 = null;
        var53.setRight(var55);
        var49.setRight(var53);
        otherTree.setRight(var49);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        assertSame(randneg694, tree.remove(randneg694.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg109);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var56 = new AVLNode<>(randneg960);var56.setHeight(1);var56.setBalanceFactor(-1);
        AVLNode<Integer> var57 = null;
        var56.setLeft(var57);
        AVLNode<Integer> var58 = new AVLNode<>(randneg352);var58.setHeight(0);var58.setBalanceFactor(0);
        AVLNode<Integer> var59 = null;
        var58.setLeft(var59);
        AVLNode<Integer> var60 = null;
        var58.setRight(var60);
        var56.setRight(var58);
        otherTree.setLeft(var56);
        AVLNode<Integer> var61 = new AVLNode<>(rand169);var61.setHeight(1);var61.setBalanceFactor(0);
        AVLNode<Integer> var62 = new AVLNode<>(rand50);var62.setHeight(0);var62.setBalanceFactor(0);
        AVLNode<Integer> var63 = null;
        var62.setLeft(var63);
        AVLNode<Integer> var64 = null;
        var62.setRight(var64);
        var61.setLeft(var62);
        AVLNode<Integer> var65 = new AVLNode<>(rand261);var65.setHeight(0);var65.setBalanceFactor(0);
        AVLNode<Integer> var66 = null;
        var65.setLeft(var66);
        AVLNode<Integer> var67 = null;
        var65.setRight(var67);
        var61.setRight(var65);
        otherTree.setRight(var61);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer randneg161 = new Integer(-161);
        tree.add(randneg161);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg109);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var68 = new AVLNode<>(randneg352);var68.setHeight(1);var68.setBalanceFactor(0);
        AVLNode<Integer> var69 = new AVLNode<>(randneg960);var69.setHeight(0);var69.setBalanceFactor(0);
        AVLNode<Integer> var70 = null;
        var69.setLeft(var70);
        AVLNode<Integer> var71 = null;
        var69.setRight(var71);
        var68.setLeft(var69);
        AVLNode<Integer> var72 = new AVLNode<>(randneg161);var72.setHeight(0);var72.setBalanceFactor(0);
        AVLNode<Integer> var73 = null;
        var72.setLeft(var73);
        AVLNode<Integer> var74 = null;
        var72.setRight(var74);
        var68.setRight(var72);
        otherTree.setLeft(var68);
        AVLNode<Integer> var75 = new AVLNode<>(rand169);var75.setHeight(1);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = new AVLNode<>(rand50);var76.setHeight(0);var76.setBalanceFactor(0);
        AVLNode<Integer> var77 = null;
        var76.setLeft(var77);
        AVLNode<Integer> var78 = null;
        var76.setRight(var78);
        var75.setLeft(var76);
        AVLNode<Integer> var79 = new AVLNode<>(rand261);var79.setHeight(0);var79.setBalanceFactor(0);
        AVLNode<Integer> var80 = null;
        var79.setLeft(var80);
        AVLNode<Integer> var81 = null;
        var79.setRight(var81);
        var75.setRight(var79);
        otherTree.setRight(var75);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer randneg944 = new Integer(-944);
        tree.add(randneg944);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg109);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var82 = new AVLNode<>(randneg352);var82.setHeight(2);var82.setBalanceFactor(1);
        AVLNode<Integer> var83 = new AVLNode<>(randneg960);var83.setHeight(1);var83.setBalanceFactor(-1);
        AVLNode<Integer> var84 = null;
        var83.setLeft(var84);
        AVLNode<Integer> var85 = new AVLNode<>(randneg944);var85.setHeight(0);var85.setBalanceFactor(0);
        AVLNode<Integer> var86 = null;
        var85.setLeft(var86);
        AVLNode<Integer> var87 = null;
        var85.setRight(var87);
        var83.setRight(var85);
        var82.setLeft(var83);
        AVLNode<Integer> var88 = new AVLNode<>(randneg161);var88.setHeight(0);var88.setBalanceFactor(0);
        AVLNode<Integer> var89 = null;
        var88.setLeft(var89);
        AVLNode<Integer> var90 = null;
        var88.setRight(var90);
        var82.setRight(var88);
        otherTree.setLeft(var82);
        AVLNode<Integer> var91 = new AVLNode<>(rand169);var91.setHeight(1);var91.setBalanceFactor(0);
        AVLNode<Integer> var92 = new AVLNode<>(rand50);var92.setHeight(0);var92.setBalanceFactor(0);
        AVLNode<Integer> var93 = null;
        var92.setLeft(var93);
        AVLNode<Integer> var94 = null;
        var92.setRight(var94);
        var91.setLeft(var92);
        AVLNode<Integer> var95 = new AVLNode<>(rand261);var95.setHeight(0);var95.setBalanceFactor(0);
        AVLNode<Integer> var96 = null;
        var95.setLeft(var96);
        AVLNode<Integer> var97 = null;
        var95.setRight(var97);
        var91.setRight(var95);
        otherTree.setRight(var91);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        assertSame(rand50, tree.remove(rand50.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg109);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var98 = new AVLNode<>(randneg352);var98.setHeight(2);var98.setBalanceFactor(1);
        AVLNode<Integer> var99 = new AVLNode<>(randneg960);var99.setHeight(1);var99.setBalanceFactor(-1);
        AVLNode<Integer> var100 = null;
        var99.setLeft(var100);
        AVLNode<Integer> var101 = new AVLNode<>(randneg944);var101.setHeight(0);var101.setBalanceFactor(0);
        AVLNode<Integer> var102 = null;
        var101.setLeft(var102);
        AVLNode<Integer> var103 = null;
        var101.setRight(var103);
        var99.setRight(var101);
        var98.setLeft(var99);
        AVLNode<Integer> var104 = new AVLNode<>(randneg161);var104.setHeight(0);var104.setBalanceFactor(0);
        AVLNode<Integer> var105 = null;
        var104.setLeft(var105);
        AVLNode<Integer> var106 = null;
        var104.setRight(var106);
        var98.setRight(var104);
        otherTree.setLeft(var98);
        AVLNode<Integer> var107 = new AVLNode<>(rand169);var107.setHeight(1);var107.setBalanceFactor(-1);
        AVLNode<Integer> var108 = null;
        var107.setLeft(var108);
        AVLNode<Integer> var109 = new AVLNode<>(rand261);var109.setHeight(0);var109.setBalanceFactor(0);
        AVLNode<Integer> var110 = null;
        var109.setLeft(var110);
        AVLNode<Integer> var111 = null;
        var109.setRight(var111);
        var107.setRight(var109);
        otherTree.setRight(var107);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        assertSame(randneg352, tree.remove(randneg352.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg109);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var112 = new AVLNode<>(randneg944);var112.setHeight(1);var112.setBalanceFactor(0);
        AVLNode<Integer> var113 = new AVLNode<>(randneg960);var113.setHeight(0);var113.setBalanceFactor(0);
        AVLNode<Integer> var114 = null;
        var113.setLeft(var114);
        AVLNode<Integer> var115 = null;
        var113.setRight(var115);
        var112.setLeft(var113);
        AVLNode<Integer> var116 = new AVLNode<>(randneg161);var116.setHeight(0);var116.setBalanceFactor(0);
        AVLNode<Integer> var117 = null;
        var116.setLeft(var117);
        AVLNode<Integer> var118 = null;
        var116.setRight(var118);
        var112.setRight(var116);
        otherTree.setLeft(var112);
        AVLNode<Integer> var119 = new AVLNode<>(rand169);var119.setHeight(1);var119.setBalanceFactor(-1);
        AVLNode<Integer> var120 = null;
        var119.setLeft(var120);
        AVLNode<Integer> var121 = new AVLNode<>(rand261);var121.setHeight(0);var121.setBalanceFactor(0);
        AVLNode<Integer> var122 = null;
        var121.setLeft(var122);
        AVLNode<Integer> var123 = null;
        var121.setRight(var123);
        var119.setRight(var121);
        otherTree.setRight(var119);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        assertSame(rand169, tree.remove(rand169.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg109);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var124 = new AVLNode<>(randneg944);var124.setHeight(1);var124.setBalanceFactor(0);
        AVLNode<Integer> var125 = new AVLNode<>(randneg960);var125.setHeight(0);var125.setBalanceFactor(0);
        AVLNode<Integer> var126 = null;
        var125.setLeft(var126);
        AVLNode<Integer> var127 = null;
        var125.setRight(var127);
        var124.setLeft(var125);
        AVLNode<Integer> var128 = new AVLNode<>(randneg161);var128.setHeight(0);var128.setBalanceFactor(0);
        AVLNode<Integer> var129 = null;
        var128.setLeft(var129);
        AVLNode<Integer> var130 = null;
        var128.setRight(var130);
        var124.setRight(var128);
        otherTree.setLeft(var124);
        AVLNode<Integer> var131 = new AVLNode<>(rand261);var131.setHeight(0);var131.setBalanceFactor(0);
        AVLNode<Integer> var132 = null;
        var131.setLeft(var132);
        AVLNode<Integer> var133 = null;
        var131.setRight(var133);
        otherTree.setRight(var131);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer rand625 = new Integer(625);
        tree.add(rand625);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg109);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var134 = new AVLNode<>(randneg944);var134.setHeight(1);var134.setBalanceFactor(0);
        AVLNode<Integer> var135 = new AVLNode<>(randneg960);var135.setHeight(0);var135.setBalanceFactor(0);
        AVLNode<Integer> var136 = null;
        var135.setLeft(var136);
        AVLNode<Integer> var137 = null;
        var135.setRight(var137);
        var134.setLeft(var135);
        AVLNode<Integer> var138 = new AVLNode<>(randneg161);var138.setHeight(0);var138.setBalanceFactor(0);
        AVLNode<Integer> var139 = null;
        var138.setLeft(var139);
        AVLNode<Integer> var140 = null;
        var138.setRight(var140);
        var134.setRight(var138);
        otherTree.setLeft(var134);
        AVLNode<Integer> var141 = new AVLNode<>(rand261);var141.setHeight(1);var141.setBalanceFactor(-1);
        AVLNode<Integer> var142 = null;
        var141.setLeft(var142);
        AVLNode<Integer> var143 = new AVLNode<>(rand625);var143.setHeight(0);var143.setBalanceFactor(0);
        AVLNode<Integer> var144 = null;
        var143.setLeft(var144);
        AVLNode<Integer> var145 = null;
        var143.setRight(var145);
        var141.setRight(var143);
        otherTree.setRight(var141);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer rand10 = new Integer(10);
        tree.add(rand10);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg109);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var146 = new AVLNode<>(randneg944);var146.setHeight(1);var146.setBalanceFactor(0);
        AVLNode<Integer> var147 = new AVLNode<>(randneg960);var147.setHeight(0);var147.setBalanceFactor(0);
        AVLNode<Integer> var148 = null;
        var147.setLeft(var148);
        AVLNode<Integer> var149 = null;
        var147.setRight(var149);
        var146.setLeft(var147);
        AVLNode<Integer> var150 = new AVLNode<>(randneg161);var150.setHeight(0);var150.setBalanceFactor(0);
        AVLNode<Integer> var151 = null;
        var150.setLeft(var151);
        AVLNode<Integer> var152 = null;
        var150.setRight(var152);
        var146.setRight(var150);
        otherTree.setLeft(var146);
        AVLNode<Integer> var153 = new AVLNode<>(rand261);var153.setHeight(1);var153.setBalanceFactor(0);
        AVLNode<Integer> var154 = new AVLNode<>(rand10);var154.setHeight(0);var154.setBalanceFactor(0);
        AVLNode<Integer> var155 = null;
        var154.setLeft(var155);
        AVLNode<Integer> var156 = null;
        var154.setRight(var156);
        var153.setLeft(var154);
        AVLNode<Integer> var157 = new AVLNode<>(rand625);var157.setHeight(0);var157.setBalanceFactor(0);
        AVLNode<Integer> var158 = null;
        var157.setLeft(var158);
        AVLNode<Integer> var159 = null;
        var157.setRight(var159);
        var153.setRight(var157);
        otherTree.setRight(var153);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #5: ==========
    @Test(timeout = TIMEOUT)
    public void test5() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer rand338 = new Integer(338);
        tree.add(rand338);

        // Validating last operation...
        otherTree = new AVLNode<>(rand338);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer rand882 = new Integer(882);
        tree.add(rand882);

        // Validating last operation...
        otherTree = new AVLNode<>(rand338);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = new AVLNode<>(rand882);var3.setHeight(0);var3.setBalanceFactor(0);
        AVLNode<Integer> var4 = null;
        var3.setLeft(var4);
        AVLNode<Integer> var5 = null;
        var3.setRight(var5);
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer rand914 = new Integer(914);
        tree.add(rand914);

        // Validating last operation...
        otherTree = new AVLNode<>(rand882);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(rand338);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(rand914);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        assertSame(rand914, tree.remove(rand914.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand882);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var12 = new AVLNode<>(rand338);var12.setHeight(0);var12.setBalanceFactor(0);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = null;
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var15 = null;
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer rand999 = new Integer(999);
        tree.add(rand999);

        // Validating last operation...
        otherTree = new AVLNode<>(rand882);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var16 = new AVLNode<>(rand338);var16.setHeight(0);var16.setBalanceFactor(0);
        AVLNode<Integer> var17 = null;
        var16.setLeft(var17);
        AVLNode<Integer> var18 = null;
        var16.setRight(var18);
        otherTree.setLeft(var16);
        AVLNode<Integer> var19 = new AVLNode<>(rand999);var19.setHeight(0);var19.setBalanceFactor(0);
        AVLNode<Integer> var20 = null;
        var19.setLeft(var20);
        AVLNode<Integer> var21 = null;
        var19.setRight(var21);
        otherTree.setRight(var19);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer randneg545 = new Integer(-545);
        tree.add(randneg545);

        // Validating last operation...
        otherTree = new AVLNode<>(rand882);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var22 = new AVLNode<>(rand338);var22.setHeight(1);var22.setBalanceFactor(1);
        AVLNode<Integer> var23 = new AVLNode<>(randneg545);var23.setHeight(0);var23.setBalanceFactor(0);
        AVLNode<Integer> var24 = null;
        var23.setLeft(var24);
        AVLNode<Integer> var25 = null;
        var23.setRight(var25);
        var22.setLeft(var23);
        AVLNode<Integer> var26 = null;
        var22.setRight(var26);
        otherTree.setLeft(var22);
        AVLNode<Integer> var27 = new AVLNode<>(rand999);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        otherTree.setRight(var27);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer rand756 = new Integer(756);
        tree.add(rand756);

        // Validating last operation...
        otherTree = new AVLNode<>(rand882);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var30 = new AVLNode<>(rand338);var30.setHeight(1);var30.setBalanceFactor(0);
        AVLNode<Integer> var31 = new AVLNode<>(randneg545);var31.setHeight(0);var31.setBalanceFactor(0);
        AVLNode<Integer> var32 = null;
        var31.setLeft(var32);
        AVLNode<Integer> var33 = null;
        var31.setRight(var33);
        var30.setLeft(var31);
        AVLNode<Integer> var34 = new AVLNode<>(rand756);var34.setHeight(0);var34.setBalanceFactor(0);
        AVLNode<Integer> var35 = null;
        var34.setLeft(var35);
        AVLNode<Integer> var36 = null;
        var34.setRight(var36);
        var30.setRight(var34);
        otherTree.setLeft(var30);
        AVLNode<Integer> var37 = new AVLNode<>(rand999);var37.setHeight(0);var37.setBalanceFactor(0);
        AVLNode<Integer> var38 = null;
        var37.setLeft(var38);
        AVLNode<Integer> var39 = null;
        var37.setRight(var39);
        otherTree.setRight(var37);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer rand443 = new Integer(443);
        tree.add(rand443);

        // Validating last operation...
        otherTree = new AVLNode<>(rand756);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var40 = new AVLNode<>(rand338);var40.setHeight(1);var40.setBalanceFactor(0);
        AVLNode<Integer> var41 = new AVLNode<>(randneg545);var41.setHeight(0);var41.setBalanceFactor(0);
        AVLNode<Integer> var42 = null;
        var41.setLeft(var42);
        AVLNode<Integer> var43 = null;
        var41.setRight(var43);
        var40.setLeft(var41);
        AVLNode<Integer> var44 = new AVLNode<>(rand443);var44.setHeight(0);var44.setBalanceFactor(0);
        AVLNode<Integer> var45 = null;
        var44.setLeft(var45);
        AVLNode<Integer> var46 = null;
        var44.setRight(var46);
        var40.setRight(var44);
        otherTree.setLeft(var40);
        AVLNode<Integer> var47 = new AVLNode<>(rand882);var47.setHeight(1);var47.setBalanceFactor(-1);
        AVLNode<Integer> var48 = null;
        var47.setLeft(var48);
        AVLNode<Integer> var49 = new AVLNode<>(rand999);var49.setHeight(0);var49.setBalanceFactor(0);
        AVLNode<Integer> var50 = null;
        var49.setLeft(var50);
        AVLNode<Integer> var51 = null;
        var49.setRight(var51);
        var47.setRight(var49);
        otherTree.setRight(var47);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        assertSame(randneg545, tree.remove(randneg545.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand756);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var52 = new AVLNode<>(rand338);var52.setHeight(1);var52.setBalanceFactor(-1);
        AVLNode<Integer> var53 = null;
        var52.setLeft(var53);
        AVLNode<Integer> var54 = new AVLNode<>(rand443);var54.setHeight(0);var54.setBalanceFactor(0);
        AVLNode<Integer> var55 = null;
        var54.setLeft(var55);
        AVLNode<Integer> var56 = null;
        var54.setRight(var56);
        var52.setRight(var54);
        otherTree.setLeft(var52);
        AVLNode<Integer> var57 = new AVLNode<>(rand882);var57.setHeight(1);var57.setBalanceFactor(-1);
        AVLNode<Integer> var58 = null;
        var57.setLeft(var58);
        AVLNode<Integer> var59 = new AVLNode<>(rand999);var59.setHeight(0);var59.setBalanceFactor(0);
        AVLNode<Integer> var60 = null;
        var59.setLeft(var60);
        AVLNode<Integer> var61 = null;
        var59.setRight(var61);
        var57.setRight(var59);
        otherTree.setRight(var57);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer rand907 = new Integer(907);
        tree.add(rand907);

        // Validating last operation...
        otherTree = new AVLNode<>(rand756);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var62 = new AVLNode<>(rand338);var62.setHeight(1);var62.setBalanceFactor(-1);
        AVLNode<Integer> var63 = null;
        var62.setLeft(var63);
        AVLNode<Integer> var64 = new AVLNode<>(rand443);var64.setHeight(0);var64.setBalanceFactor(0);
        AVLNode<Integer> var65 = null;
        var64.setLeft(var65);
        AVLNode<Integer> var66 = null;
        var64.setRight(var66);
        var62.setRight(var64);
        otherTree.setLeft(var62);
        AVLNode<Integer> var67 = new AVLNode<>(rand907);var67.setHeight(1);var67.setBalanceFactor(0);
        AVLNode<Integer> var68 = new AVLNode<>(rand882);var68.setHeight(0);var68.setBalanceFactor(0);
        AVLNode<Integer> var69 = null;
        var68.setLeft(var69);
        AVLNode<Integer> var70 = null;
        var68.setRight(var70);
        var67.setLeft(var68);
        AVLNode<Integer> var71 = new AVLNode<>(rand999);var71.setHeight(0);var71.setBalanceFactor(0);
        AVLNode<Integer> var72 = null;
        var71.setLeft(var72);
        AVLNode<Integer> var73 = null;
        var71.setRight(var73);
        var67.setRight(var71);
        otherTree.setRight(var67);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer randneg893 = new Integer(-893);
        tree.add(randneg893);

        // Validating last operation...
        otherTree = new AVLNode<>(rand756);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var74 = new AVLNode<>(rand338);var74.setHeight(1);var74.setBalanceFactor(0);
        AVLNode<Integer> var75 = new AVLNode<>(randneg893);var75.setHeight(0);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = null;
        var75.setLeft(var76);
        AVLNode<Integer> var77 = null;
        var75.setRight(var77);
        var74.setLeft(var75);
        AVLNode<Integer> var78 = new AVLNode<>(rand443);var78.setHeight(0);var78.setBalanceFactor(0);
        AVLNode<Integer> var79 = null;
        var78.setLeft(var79);
        AVLNode<Integer> var80 = null;
        var78.setRight(var80);
        var74.setRight(var78);
        otherTree.setLeft(var74);
        AVLNode<Integer> var81 = new AVLNode<>(rand907);var81.setHeight(1);var81.setBalanceFactor(0);
        AVLNode<Integer> var82 = new AVLNode<>(rand882);var82.setHeight(0);var82.setBalanceFactor(0);
        AVLNode<Integer> var83 = null;
        var82.setLeft(var83);
        AVLNode<Integer> var84 = null;
        var82.setRight(var84);
        var81.setLeft(var82);
        AVLNode<Integer> var85 = new AVLNode<>(rand999);var85.setHeight(0);var85.setBalanceFactor(0);
        AVLNode<Integer> var86 = null;
        var85.setLeft(var86);
        AVLNode<Integer> var87 = null;
        var85.setRight(var87);
        var81.setRight(var85);
        otherTree.setRight(var81);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer rand130 = new Integer(130);
        tree.add(rand130);

        // Validating last operation...
        otherTree = new AVLNode<>(rand756);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var88 = new AVLNode<>(rand338);var88.setHeight(2);var88.setBalanceFactor(1);
        AVLNode<Integer> var89 = new AVLNode<>(randneg893);var89.setHeight(1);var89.setBalanceFactor(-1);
        AVLNode<Integer> var90 = null;
        var89.setLeft(var90);
        AVLNode<Integer> var91 = new AVLNode<>(rand130);var91.setHeight(0);var91.setBalanceFactor(0);
        AVLNode<Integer> var92 = null;
        var91.setLeft(var92);
        AVLNode<Integer> var93 = null;
        var91.setRight(var93);
        var89.setRight(var91);
        var88.setLeft(var89);
        AVLNode<Integer> var94 = new AVLNode<>(rand443);var94.setHeight(0);var94.setBalanceFactor(0);
        AVLNode<Integer> var95 = null;
        var94.setLeft(var95);
        AVLNode<Integer> var96 = null;
        var94.setRight(var96);
        var88.setRight(var94);
        otherTree.setLeft(var88);
        AVLNode<Integer> var97 = new AVLNode<>(rand907);var97.setHeight(1);var97.setBalanceFactor(0);
        AVLNode<Integer> var98 = new AVLNode<>(rand882);var98.setHeight(0);var98.setBalanceFactor(0);
        AVLNode<Integer> var99 = null;
        var98.setLeft(var99);
        AVLNode<Integer> var100 = null;
        var98.setRight(var100);
        var97.setLeft(var98);
        AVLNode<Integer> var101 = new AVLNode<>(rand999);var101.setHeight(0);var101.setBalanceFactor(0);
        AVLNode<Integer> var102 = null;
        var101.setLeft(var102);
        AVLNode<Integer> var103 = null;
        var101.setRight(var103);
        var97.setRight(var101);
        otherTree.setRight(var97);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer rand975 = new Integer(975);
        tree.add(rand975);

        // Validating last operation...
        otherTree = new AVLNode<>(rand756);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var104 = new AVLNode<>(rand338);var104.setHeight(2);var104.setBalanceFactor(1);
        AVLNode<Integer> var105 = new AVLNode<>(randneg893);var105.setHeight(1);var105.setBalanceFactor(-1);
        AVLNode<Integer> var106 = null;
        var105.setLeft(var106);
        AVLNode<Integer> var107 = new AVLNode<>(rand130);var107.setHeight(0);var107.setBalanceFactor(0);
        AVLNode<Integer> var108 = null;
        var107.setLeft(var108);
        AVLNode<Integer> var109 = null;
        var107.setRight(var109);
        var105.setRight(var107);
        var104.setLeft(var105);
        AVLNode<Integer> var110 = new AVLNode<>(rand443);var110.setHeight(0);var110.setBalanceFactor(0);
        AVLNode<Integer> var111 = null;
        var110.setLeft(var111);
        AVLNode<Integer> var112 = null;
        var110.setRight(var112);
        var104.setRight(var110);
        otherTree.setLeft(var104);
        AVLNode<Integer> var113 = new AVLNode<>(rand907);var113.setHeight(2);var113.setBalanceFactor(-1);
        AVLNode<Integer> var114 = new AVLNode<>(rand882);var114.setHeight(0);var114.setBalanceFactor(0);
        AVLNode<Integer> var115 = null;
        var114.setLeft(var115);
        AVLNode<Integer> var116 = null;
        var114.setRight(var116);
        var113.setLeft(var114);
        AVLNode<Integer> var117 = new AVLNode<>(rand999);var117.setHeight(1);var117.setBalanceFactor(1);
        AVLNode<Integer> var118 = new AVLNode<>(rand975);var118.setHeight(0);var118.setBalanceFactor(0);
        AVLNode<Integer> var119 = null;
        var118.setLeft(var119);
        AVLNode<Integer> var120 = null;
        var118.setRight(var120);
        var117.setLeft(var118);
        AVLNode<Integer> var121 = null;
        var117.setRight(var121);
        var113.setRight(var117);
        otherTree.setRight(var113);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer randneg86 = new Integer(-86);
        tree.add(randneg86);

        // Validating last operation...
        otherTree = new AVLNode<>(rand756);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var122 = new AVLNode<>(rand338);var122.setHeight(2);var122.setBalanceFactor(1);
        AVLNode<Integer> var123 = new AVLNode<>(randneg86);var123.setHeight(1);var123.setBalanceFactor(0);
        AVLNode<Integer> var124 = new AVLNode<>(randneg893);var124.setHeight(0);var124.setBalanceFactor(0);
        AVLNode<Integer> var125 = null;
        var124.setLeft(var125);
        AVLNode<Integer> var126 = null;
        var124.setRight(var126);
        var123.setLeft(var124);
        AVLNode<Integer> var127 = new AVLNode<>(rand130);var127.setHeight(0);var127.setBalanceFactor(0);
        AVLNode<Integer> var128 = null;
        var127.setLeft(var128);
        AVLNode<Integer> var129 = null;
        var127.setRight(var129);
        var123.setRight(var127);
        var122.setLeft(var123);
        AVLNode<Integer> var130 = new AVLNode<>(rand443);var130.setHeight(0);var130.setBalanceFactor(0);
        AVLNode<Integer> var131 = null;
        var130.setLeft(var131);
        AVLNode<Integer> var132 = null;
        var130.setRight(var132);
        var122.setRight(var130);
        otherTree.setLeft(var122);
        AVLNode<Integer> var133 = new AVLNode<>(rand907);var133.setHeight(2);var133.setBalanceFactor(-1);
        AVLNode<Integer> var134 = new AVLNode<>(rand882);var134.setHeight(0);var134.setBalanceFactor(0);
        AVLNode<Integer> var135 = null;
        var134.setLeft(var135);
        AVLNode<Integer> var136 = null;
        var134.setRight(var136);
        var133.setLeft(var134);
        AVLNode<Integer> var137 = new AVLNode<>(rand999);var137.setHeight(1);var137.setBalanceFactor(1);
        AVLNode<Integer> var138 = new AVLNode<>(rand975);var138.setHeight(0);var138.setBalanceFactor(0);
        AVLNode<Integer> var139 = null;
        var138.setLeft(var139);
        AVLNode<Integer> var140 = null;
        var138.setRight(var140);
        var137.setLeft(var138);
        AVLNode<Integer> var141 = null;
        var137.setRight(var141);
        var133.setRight(var137);
        otherTree.setRight(var133);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer randneg879 = new Integer(-879);
        tree.add(randneg879);

        // Validating last operation...
        otherTree = new AVLNode<>(rand756);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var142 = new AVLNode<>(randneg86);var142.setHeight(2);var142.setBalanceFactor(0);
        AVLNode<Integer> var143 = new AVLNode<>(randneg893);var143.setHeight(1);var143.setBalanceFactor(-1);
        AVLNode<Integer> var144 = null;
        var143.setLeft(var144);
        AVLNode<Integer> var145 = new AVLNode<>(randneg879);var145.setHeight(0);var145.setBalanceFactor(0);
        AVLNode<Integer> var146 = null;
        var145.setLeft(var146);
        AVLNode<Integer> var147 = null;
        var145.setRight(var147);
        var143.setRight(var145);
        var142.setLeft(var143);
        AVLNode<Integer> var148 = new AVLNode<>(rand338);var148.setHeight(1);var148.setBalanceFactor(0);
        AVLNode<Integer> var149 = new AVLNode<>(rand130);var149.setHeight(0);var149.setBalanceFactor(0);
        AVLNode<Integer> var150 = null;
        var149.setLeft(var150);
        AVLNode<Integer> var151 = null;
        var149.setRight(var151);
        var148.setLeft(var149);
        AVLNode<Integer> var152 = new AVLNode<>(rand443);var152.setHeight(0);var152.setBalanceFactor(0);
        AVLNode<Integer> var153 = null;
        var152.setLeft(var153);
        AVLNode<Integer> var154 = null;
        var152.setRight(var154);
        var148.setRight(var152);
        var142.setRight(var148);
        otherTree.setLeft(var142);
        AVLNode<Integer> var155 = new AVLNode<>(rand907);var155.setHeight(2);var155.setBalanceFactor(-1);
        AVLNode<Integer> var156 = new AVLNode<>(rand882);var156.setHeight(0);var156.setBalanceFactor(0);
        AVLNode<Integer> var157 = null;
        var156.setLeft(var157);
        AVLNode<Integer> var158 = null;
        var156.setRight(var158);
        var155.setLeft(var156);
        AVLNode<Integer> var159 = new AVLNode<>(rand999);var159.setHeight(1);var159.setBalanceFactor(1);
        AVLNode<Integer> var160 = new AVLNode<>(rand975);var160.setHeight(0);var160.setBalanceFactor(0);
        AVLNode<Integer> var161 = null;
        var160.setLeft(var161);
        AVLNode<Integer> var162 = null;
        var160.setRight(var162);
        var159.setLeft(var160);
        AVLNode<Integer> var163 = null;
        var159.setRight(var163);
        var155.setRight(var159);
        otherTree.setRight(var155);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #6: ==========
    @Test(timeout = TIMEOUT)
    public void test6() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg796 = new Integer(-796);
        tree.add(randneg796);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg796);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer randneg708 = new Integer(-708);
        tree.add(randneg708);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg796);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = new AVLNode<>(randneg708);var3.setHeight(0);var3.setBalanceFactor(0);
        AVLNode<Integer> var4 = null;
        var3.setLeft(var4);
        AVLNode<Integer> var5 = null;
        var3.setRight(var5);
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer rand768 = new Integer(768);
        tree.add(rand768);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg708);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(randneg796);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(rand768);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer rand987 = new Integer(987);
        tree.add(rand987);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg708);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var12 = new AVLNode<>(randneg796);var12.setHeight(0);var12.setBalanceFactor(0);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = null;
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var15 = new AVLNode<>(rand768);var15.setHeight(1);var15.setBalanceFactor(-1);
        AVLNode<Integer> var16 = null;
        var15.setLeft(var16);
        AVLNode<Integer> var17 = new AVLNode<>(rand987);var17.setHeight(0);var17.setBalanceFactor(0);
        AVLNode<Integer> var18 = null;
        var17.setLeft(var18);
        AVLNode<Integer> var19 = null;
        var17.setRight(var19);
        var15.setRight(var17);
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer randneg389 = new Integer(-389);
        tree.add(randneg389);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg708);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var20 = new AVLNode<>(randneg796);var20.setHeight(0);var20.setBalanceFactor(0);
        AVLNode<Integer> var21 = null;
        var20.setLeft(var21);
        AVLNode<Integer> var22 = null;
        var20.setRight(var22);
        otherTree.setLeft(var20);
        AVLNode<Integer> var23 = new AVLNode<>(rand768);var23.setHeight(1);var23.setBalanceFactor(0);
        AVLNode<Integer> var24 = new AVLNode<>(randneg389);var24.setHeight(0);var24.setBalanceFactor(0);
        AVLNode<Integer> var25 = null;
        var24.setLeft(var25);
        AVLNode<Integer> var26 = null;
        var24.setRight(var26);
        var23.setLeft(var24);
        AVLNode<Integer> var27 = new AVLNode<>(rand987);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        var23.setRight(var27);
        otherTree.setRight(var23);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer rand821 = new Integer(821);
        tree.add(rand821);

        // Validating last operation...
        otherTree = new AVLNode<>(rand768);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var30 = new AVLNode<>(randneg708);var30.setHeight(1);var30.setBalanceFactor(0);
        AVLNode<Integer> var31 = new AVLNode<>(randneg796);var31.setHeight(0);var31.setBalanceFactor(0);
        AVLNode<Integer> var32 = null;
        var31.setLeft(var32);
        AVLNode<Integer> var33 = null;
        var31.setRight(var33);
        var30.setLeft(var31);
        AVLNode<Integer> var34 = new AVLNode<>(randneg389);var34.setHeight(0);var34.setBalanceFactor(0);
        AVLNode<Integer> var35 = null;
        var34.setLeft(var35);
        AVLNode<Integer> var36 = null;
        var34.setRight(var36);
        var30.setRight(var34);
        otherTree.setLeft(var30);
        AVLNode<Integer> var37 = new AVLNode<>(rand987);var37.setHeight(1);var37.setBalanceFactor(1);
        AVLNode<Integer> var38 = new AVLNode<>(rand821);var38.setHeight(0);var38.setBalanceFactor(0);
        AVLNode<Integer> var39 = null;
        var38.setLeft(var39);
        AVLNode<Integer> var40 = null;
        var38.setRight(var40);
        var37.setLeft(var38);
        AVLNode<Integer> var41 = null;
        var37.setRight(var41);
        otherTree.setRight(var37);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer rand637 = new Integer(637);
        tree.add(rand637);

        // Validating last operation...
        otherTree = new AVLNode<>(rand768);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var42 = new AVLNode<>(randneg708);var42.setHeight(2);var42.setBalanceFactor(-1);
        AVLNode<Integer> var43 = new AVLNode<>(randneg796);var43.setHeight(0);var43.setBalanceFactor(0);
        AVLNode<Integer> var44 = null;
        var43.setLeft(var44);
        AVLNode<Integer> var45 = null;
        var43.setRight(var45);
        var42.setLeft(var43);
        AVLNode<Integer> var46 = new AVLNode<>(randneg389);var46.setHeight(1);var46.setBalanceFactor(-1);
        AVLNode<Integer> var47 = null;
        var46.setLeft(var47);
        AVLNode<Integer> var48 = new AVLNode<>(rand637);var48.setHeight(0);var48.setBalanceFactor(0);
        AVLNode<Integer> var49 = null;
        var48.setLeft(var49);
        AVLNode<Integer> var50 = null;
        var48.setRight(var50);
        var46.setRight(var48);
        var42.setRight(var46);
        otherTree.setLeft(var42);
        AVLNode<Integer> var51 = new AVLNode<>(rand987);var51.setHeight(1);var51.setBalanceFactor(1);
        AVLNode<Integer> var52 = new AVLNode<>(rand821);var52.setHeight(0);var52.setBalanceFactor(0);
        AVLNode<Integer> var53 = null;
        var52.setLeft(var53);
        AVLNode<Integer> var54 = null;
        var52.setRight(var54);
        var51.setLeft(var52);
        AVLNode<Integer> var55 = null;
        var51.setRight(var55);
        otherTree.setRight(var51);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer randneg738 = new Integer(-738);
        tree.add(randneg738);

        // Validating last operation...
        otherTree = new AVLNode<>(rand768);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var56 = new AVLNode<>(randneg708);var56.setHeight(2);var56.setBalanceFactor(0);
        AVLNode<Integer> var57 = new AVLNode<>(randneg796);var57.setHeight(1);var57.setBalanceFactor(-1);
        AVLNode<Integer> var58 = null;
        var57.setLeft(var58);
        AVLNode<Integer> var59 = new AVLNode<>(randneg738);var59.setHeight(0);var59.setBalanceFactor(0);
        AVLNode<Integer> var60 = null;
        var59.setLeft(var60);
        AVLNode<Integer> var61 = null;
        var59.setRight(var61);
        var57.setRight(var59);
        var56.setLeft(var57);
        AVLNode<Integer> var62 = new AVLNode<>(randneg389);var62.setHeight(1);var62.setBalanceFactor(-1);
        AVLNode<Integer> var63 = null;
        var62.setLeft(var63);
        AVLNode<Integer> var64 = new AVLNode<>(rand637);var64.setHeight(0);var64.setBalanceFactor(0);
        AVLNode<Integer> var65 = null;
        var64.setLeft(var65);
        AVLNode<Integer> var66 = null;
        var64.setRight(var66);
        var62.setRight(var64);
        var56.setRight(var62);
        otherTree.setLeft(var56);
        AVLNode<Integer> var67 = new AVLNode<>(rand987);var67.setHeight(1);var67.setBalanceFactor(1);
        AVLNode<Integer> var68 = new AVLNode<>(rand821);var68.setHeight(0);var68.setBalanceFactor(0);
        AVLNode<Integer> var69 = null;
        var68.setLeft(var69);
        AVLNode<Integer> var70 = null;
        var68.setRight(var70);
        var67.setLeft(var68);
        AVLNode<Integer> var71 = null;
        var67.setRight(var71);
        otherTree.setRight(var67);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer randneg973 = new Integer(-973);
        tree.add(randneg973);

        // Validating last operation...
        otherTree = new AVLNode<>(rand768);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var72 = new AVLNode<>(randneg708);var72.setHeight(2);var72.setBalanceFactor(0);
        AVLNode<Integer> var73 = new AVLNode<>(randneg796);var73.setHeight(1);var73.setBalanceFactor(0);
        AVLNode<Integer> var74 = new AVLNode<>(randneg973);var74.setHeight(0);var74.setBalanceFactor(0);
        AVLNode<Integer> var75 = null;
        var74.setLeft(var75);
        AVLNode<Integer> var76 = null;
        var74.setRight(var76);
        var73.setLeft(var74);
        AVLNode<Integer> var77 = new AVLNode<>(randneg738);var77.setHeight(0);var77.setBalanceFactor(0);
        AVLNode<Integer> var78 = null;
        var77.setLeft(var78);
        AVLNode<Integer> var79 = null;
        var77.setRight(var79);
        var73.setRight(var77);
        var72.setLeft(var73);
        AVLNode<Integer> var80 = new AVLNode<>(randneg389);var80.setHeight(1);var80.setBalanceFactor(-1);
        AVLNode<Integer> var81 = null;
        var80.setLeft(var81);
        AVLNode<Integer> var82 = new AVLNode<>(rand637);var82.setHeight(0);var82.setBalanceFactor(0);
        AVLNode<Integer> var83 = null;
        var82.setLeft(var83);
        AVLNode<Integer> var84 = null;
        var82.setRight(var84);
        var80.setRight(var82);
        var72.setRight(var80);
        otherTree.setLeft(var72);
        AVLNode<Integer> var85 = new AVLNode<>(rand987);var85.setHeight(1);var85.setBalanceFactor(1);
        AVLNode<Integer> var86 = new AVLNode<>(rand821);var86.setHeight(0);var86.setBalanceFactor(0);
        AVLNode<Integer> var87 = null;
        var86.setLeft(var87);
        AVLNode<Integer> var88 = null;
        var86.setRight(var88);
        var85.setLeft(var86);
        AVLNode<Integer> var89 = null;
        var85.setRight(var89);
        otherTree.setRight(var85);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer randneg58 = new Integer(-58);
        tree.add(randneg58);

        // Validating last operation...
        otherTree = new AVLNode<>(rand768);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var90 = new AVLNode<>(randneg708);var90.setHeight(2);var90.setBalanceFactor(0);
        AVLNode<Integer> var91 = new AVLNode<>(randneg796);var91.setHeight(1);var91.setBalanceFactor(0);
        AVLNode<Integer> var92 = new AVLNode<>(randneg973);var92.setHeight(0);var92.setBalanceFactor(0);
        AVLNode<Integer> var93 = null;
        var92.setLeft(var93);
        AVLNode<Integer> var94 = null;
        var92.setRight(var94);
        var91.setLeft(var92);
        AVLNode<Integer> var95 = new AVLNode<>(randneg738);var95.setHeight(0);var95.setBalanceFactor(0);
        AVLNode<Integer> var96 = null;
        var95.setLeft(var96);
        AVLNode<Integer> var97 = null;
        var95.setRight(var97);
        var91.setRight(var95);
        var90.setLeft(var91);
        AVLNode<Integer> var98 = new AVLNode<>(randneg58);var98.setHeight(1);var98.setBalanceFactor(0);
        AVLNode<Integer> var99 = new AVLNode<>(randneg389);var99.setHeight(0);var99.setBalanceFactor(0);
        AVLNode<Integer> var100 = null;
        var99.setLeft(var100);
        AVLNode<Integer> var101 = null;
        var99.setRight(var101);
        var98.setLeft(var99);
        AVLNode<Integer> var102 = new AVLNode<>(rand637);var102.setHeight(0);var102.setBalanceFactor(0);
        AVLNode<Integer> var103 = null;
        var102.setLeft(var103);
        AVLNode<Integer> var104 = null;
        var102.setRight(var104);
        var98.setRight(var102);
        var90.setRight(var98);
        otherTree.setLeft(var90);
        AVLNode<Integer> var105 = new AVLNode<>(rand987);var105.setHeight(1);var105.setBalanceFactor(1);
        AVLNode<Integer> var106 = new AVLNode<>(rand821);var106.setHeight(0);var106.setBalanceFactor(0);
        AVLNode<Integer> var107 = null;
        var106.setLeft(var107);
        AVLNode<Integer> var108 = null;
        var106.setRight(var108);
        var105.setLeft(var106);
        AVLNode<Integer> var109 = null;
        var105.setRight(var109);
        otherTree.setRight(var105);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        assertSame(randneg973, tree.remove(randneg973.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand768);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var110 = new AVLNode<>(randneg708);var110.setHeight(2);var110.setBalanceFactor(0);
        AVLNode<Integer> var111 = new AVLNode<>(randneg796);var111.setHeight(1);var111.setBalanceFactor(-1);
        AVLNode<Integer> var112 = null;
        var111.setLeft(var112);
        AVLNode<Integer> var113 = new AVLNode<>(randneg738);var113.setHeight(0);var113.setBalanceFactor(0);
        AVLNode<Integer> var114 = null;
        var113.setLeft(var114);
        AVLNode<Integer> var115 = null;
        var113.setRight(var115);
        var111.setRight(var113);
        var110.setLeft(var111);
        AVLNode<Integer> var116 = new AVLNode<>(randneg58);var116.setHeight(1);var116.setBalanceFactor(0);
        AVLNode<Integer> var117 = new AVLNode<>(randneg389);var117.setHeight(0);var117.setBalanceFactor(0);
        AVLNode<Integer> var118 = null;
        var117.setLeft(var118);
        AVLNode<Integer> var119 = null;
        var117.setRight(var119);
        var116.setLeft(var117);
        AVLNode<Integer> var120 = new AVLNode<>(rand637);var120.setHeight(0);var120.setBalanceFactor(0);
        AVLNode<Integer> var121 = null;
        var120.setLeft(var121);
        AVLNode<Integer> var122 = null;
        var120.setRight(var122);
        var116.setRight(var120);
        var110.setRight(var116);
        otherTree.setLeft(var110);
        AVLNode<Integer> var123 = new AVLNode<>(rand987);var123.setHeight(1);var123.setBalanceFactor(1);
        AVLNode<Integer> var124 = new AVLNode<>(rand821);var124.setHeight(0);var124.setBalanceFactor(0);
        AVLNode<Integer> var125 = null;
        var124.setLeft(var125);
        AVLNode<Integer> var126 = null;
        var124.setRight(var126);
        var123.setLeft(var124);
        AVLNode<Integer> var127 = null;
        var123.setRight(var127);
        otherTree.setRight(var123);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer rand552 = new Integer(552);
        tree.add(rand552);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg58);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var128 = new AVLNode<>(randneg708);var128.setHeight(2);var128.setBalanceFactor(1);
        AVLNode<Integer> var129 = new AVLNode<>(randneg796);var129.setHeight(1);var129.setBalanceFactor(-1);
        AVLNode<Integer> var130 = null;
        var129.setLeft(var130);
        AVLNode<Integer> var131 = new AVLNode<>(randneg738);var131.setHeight(0);var131.setBalanceFactor(0);
        AVLNode<Integer> var132 = null;
        var131.setLeft(var132);
        AVLNode<Integer> var133 = null;
        var131.setRight(var133);
        var129.setRight(var131);
        var128.setLeft(var129);
        AVLNode<Integer> var134 = new AVLNode<>(randneg389);var134.setHeight(0);var134.setBalanceFactor(0);
        AVLNode<Integer> var135 = null;
        var134.setLeft(var135);
        AVLNode<Integer> var136 = null;
        var134.setRight(var136);
        var128.setRight(var134);
        otherTree.setLeft(var128);
        AVLNode<Integer> var137 = new AVLNode<>(rand768);var137.setHeight(2);var137.setBalanceFactor(0);
        AVLNode<Integer> var138 = new AVLNode<>(rand637);var138.setHeight(1);var138.setBalanceFactor(1);
        AVLNode<Integer> var139 = new AVLNode<>(rand552);var139.setHeight(0);var139.setBalanceFactor(0);
        AVLNode<Integer> var140 = null;
        var139.setLeft(var140);
        AVLNode<Integer> var141 = null;
        var139.setRight(var141);
        var138.setLeft(var139);
        AVLNode<Integer> var142 = null;
        var138.setRight(var142);
        var137.setLeft(var138);
        AVLNode<Integer> var143 = new AVLNode<>(rand987);var143.setHeight(1);var143.setBalanceFactor(1);
        AVLNode<Integer> var144 = new AVLNode<>(rand821);var144.setHeight(0);var144.setBalanceFactor(0);
        AVLNode<Integer> var145 = null;
        var144.setLeft(var145);
        AVLNode<Integer> var146 = null;
        var144.setRight(var146);
        var143.setLeft(var144);
        AVLNode<Integer> var147 = null;
        var143.setRight(var147);
        var137.setRight(var143);
        otherTree.setRight(var137);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer randneg866 = new Integer(-866);
        tree.add(randneg866);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg58);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var148 = new AVLNode<>(randneg708);var148.setHeight(2);var148.setBalanceFactor(1);
        AVLNode<Integer> var149 = new AVLNode<>(randneg796);var149.setHeight(1);var149.setBalanceFactor(0);
        AVLNode<Integer> var150 = new AVLNode<>(randneg866);var150.setHeight(0);var150.setBalanceFactor(0);
        AVLNode<Integer> var151 = null;
        var150.setLeft(var151);
        AVLNode<Integer> var152 = null;
        var150.setRight(var152);
        var149.setLeft(var150);
        AVLNode<Integer> var153 = new AVLNode<>(randneg738);var153.setHeight(0);var153.setBalanceFactor(0);
        AVLNode<Integer> var154 = null;
        var153.setLeft(var154);
        AVLNode<Integer> var155 = null;
        var153.setRight(var155);
        var149.setRight(var153);
        var148.setLeft(var149);
        AVLNode<Integer> var156 = new AVLNode<>(randneg389);var156.setHeight(0);var156.setBalanceFactor(0);
        AVLNode<Integer> var157 = null;
        var156.setLeft(var157);
        AVLNode<Integer> var158 = null;
        var156.setRight(var158);
        var148.setRight(var156);
        otherTree.setLeft(var148);
        AVLNode<Integer> var159 = new AVLNode<>(rand768);var159.setHeight(2);var159.setBalanceFactor(0);
        AVLNode<Integer> var160 = new AVLNode<>(rand637);var160.setHeight(1);var160.setBalanceFactor(1);
        AVLNode<Integer> var161 = new AVLNode<>(rand552);var161.setHeight(0);var161.setBalanceFactor(0);
        AVLNode<Integer> var162 = null;
        var161.setLeft(var162);
        AVLNode<Integer> var163 = null;
        var161.setRight(var163);
        var160.setLeft(var161);
        AVLNode<Integer> var164 = null;
        var160.setRight(var164);
        var159.setLeft(var160);
        AVLNode<Integer> var165 = new AVLNode<>(rand987);var165.setHeight(1);var165.setBalanceFactor(1);
        AVLNode<Integer> var166 = new AVLNode<>(rand821);var166.setHeight(0);var166.setBalanceFactor(0);
        AVLNode<Integer> var167 = null;
        var166.setLeft(var167);
        AVLNode<Integer> var168 = null;
        var166.setRight(var168);
        var165.setLeft(var166);
        AVLNode<Integer> var169 = null;
        var165.setRight(var169);
        var159.setRight(var165);
        otherTree.setRight(var159);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer rand374 = new Integer(374);
        tree.add(rand374);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg58);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var170 = new AVLNode<>(randneg708);var170.setHeight(2);var170.setBalanceFactor(1);
        AVLNode<Integer> var171 = new AVLNode<>(randneg796);var171.setHeight(1);var171.setBalanceFactor(0);
        AVLNode<Integer> var172 = new AVLNode<>(randneg866);var172.setHeight(0);var172.setBalanceFactor(0);
        AVLNode<Integer> var173 = null;
        var172.setLeft(var173);
        AVLNode<Integer> var174 = null;
        var172.setRight(var174);
        var171.setLeft(var172);
        AVLNode<Integer> var175 = new AVLNode<>(randneg738);var175.setHeight(0);var175.setBalanceFactor(0);
        AVLNode<Integer> var176 = null;
        var175.setLeft(var176);
        AVLNode<Integer> var177 = null;
        var175.setRight(var177);
        var171.setRight(var175);
        var170.setLeft(var171);
        AVLNode<Integer> var178 = new AVLNode<>(randneg389);var178.setHeight(0);var178.setBalanceFactor(0);
        AVLNode<Integer> var179 = null;
        var178.setLeft(var179);
        AVLNode<Integer> var180 = null;
        var178.setRight(var180);
        var170.setRight(var178);
        otherTree.setLeft(var170);
        AVLNode<Integer> var181 = new AVLNode<>(rand768);var181.setHeight(2);var181.setBalanceFactor(0);
        AVLNode<Integer> var182 = new AVLNode<>(rand552);var182.setHeight(1);var182.setBalanceFactor(0);
        AVLNode<Integer> var183 = new AVLNode<>(rand374);var183.setHeight(0);var183.setBalanceFactor(0);
        AVLNode<Integer> var184 = null;
        var183.setLeft(var184);
        AVLNode<Integer> var185 = null;
        var183.setRight(var185);
        var182.setLeft(var183);
        AVLNode<Integer> var186 = new AVLNode<>(rand637);var186.setHeight(0);var186.setBalanceFactor(0);
        AVLNode<Integer> var187 = null;
        var186.setLeft(var187);
        AVLNode<Integer> var188 = null;
        var186.setRight(var188);
        var182.setRight(var186);
        var181.setLeft(var182);
        AVLNode<Integer> var189 = new AVLNode<>(rand987);var189.setHeight(1);var189.setBalanceFactor(1);
        AVLNode<Integer> var190 = new AVLNode<>(rand821);var190.setHeight(0);var190.setBalanceFactor(0);
        AVLNode<Integer> var191 = null;
        var190.setLeft(var191);
        AVLNode<Integer> var192 = null;
        var190.setRight(var192);
        var189.setLeft(var190);
        AVLNode<Integer> var193 = null;
        var189.setRight(var193);
        var181.setRight(var189);
        otherTree.setRight(var181);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        assertSame(rand552, tree.remove(rand552.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg58);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var194 = new AVLNode<>(randneg708);var194.setHeight(2);var194.setBalanceFactor(1);
        AVLNode<Integer> var195 = new AVLNode<>(randneg796);var195.setHeight(1);var195.setBalanceFactor(0);
        AVLNode<Integer> var196 = new AVLNode<>(randneg866);var196.setHeight(0);var196.setBalanceFactor(0);
        AVLNode<Integer> var197 = null;
        var196.setLeft(var197);
        AVLNode<Integer> var198 = null;
        var196.setRight(var198);
        var195.setLeft(var196);
        AVLNode<Integer> var199 = new AVLNode<>(randneg738);var199.setHeight(0);var199.setBalanceFactor(0);
        AVLNode<Integer> var200 = null;
        var199.setLeft(var200);
        AVLNode<Integer> var201 = null;
        var199.setRight(var201);
        var195.setRight(var199);
        var194.setLeft(var195);
        AVLNode<Integer> var202 = new AVLNode<>(randneg389);var202.setHeight(0);var202.setBalanceFactor(0);
        AVLNode<Integer> var203 = null;
        var202.setLeft(var203);
        AVLNode<Integer> var204 = null;
        var202.setRight(var204);
        var194.setRight(var202);
        otherTree.setLeft(var194);
        AVLNode<Integer> var205 = new AVLNode<>(rand768);var205.setHeight(2);var205.setBalanceFactor(0);
        AVLNode<Integer> var206 = new AVLNode<>(rand374);var206.setHeight(1);var206.setBalanceFactor(-1);
        AVLNode<Integer> var207 = null;
        var206.setLeft(var207);
        AVLNode<Integer> var208 = new AVLNode<>(rand637);var208.setHeight(0);var208.setBalanceFactor(0);
        AVLNode<Integer> var209 = null;
        var208.setLeft(var209);
        AVLNode<Integer> var210 = null;
        var208.setRight(var210);
        var206.setRight(var208);
        var205.setLeft(var206);
        AVLNode<Integer> var211 = new AVLNode<>(rand987);var211.setHeight(1);var211.setBalanceFactor(1);
        AVLNode<Integer> var212 = new AVLNode<>(rand821);var212.setHeight(0);var212.setBalanceFactor(0);
        AVLNode<Integer> var213 = null;
        var212.setLeft(var213);
        AVLNode<Integer> var214 = null;
        var212.setRight(var214);
        var211.setLeft(var212);
        AVLNode<Integer> var215 = null;
        var211.setRight(var215);
        var205.setRight(var211);
        otherTree.setRight(var205);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #7: ==========
    @Test(timeout = TIMEOUT)
    public void test7() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg218 = new Integer(-218);
        tree.add(randneg218);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg218);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer randneg924 = new Integer(-924);
        tree.add(randneg924);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg218);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var2 = new AVLNode<>(randneg924);var2.setHeight(0);var2.setBalanceFactor(0);
        AVLNode<Integer> var3 = null;
        var2.setLeft(var3);
        AVLNode<Integer> var4 = null;
        var2.setRight(var4);
        otherTree.setLeft(var2);
        AVLNode<Integer> var5 = null;
        otherTree.setRight(var5);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer rand732 = new Integer(732);
        tree.add(rand732);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg218);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(randneg924);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(rand732);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer rand323 = new Integer(323);
        tree.add(rand323);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg218);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var12 = new AVLNode<>(randneg924);var12.setHeight(0);var12.setBalanceFactor(0);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = null;
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var15 = new AVLNode<>(rand732);var15.setHeight(1);var15.setBalanceFactor(1);
        AVLNode<Integer> var16 = new AVLNode<>(rand323);var16.setHeight(0);var16.setBalanceFactor(0);
        AVLNode<Integer> var17 = null;
        var16.setLeft(var17);
        AVLNode<Integer> var18 = null;
        var16.setRight(var18);
        var15.setLeft(var16);
        AVLNode<Integer> var19 = null;
        var15.setRight(var19);
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer rand50 = new Integer(50);
        tree.add(rand50);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg218);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var20 = new AVLNode<>(randneg924);var20.setHeight(0);var20.setBalanceFactor(0);
        AVLNode<Integer> var21 = null;
        var20.setLeft(var21);
        AVLNode<Integer> var22 = null;
        var20.setRight(var22);
        otherTree.setLeft(var20);
        AVLNode<Integer> var23 = new AVLNode<>(rand323);var23.setHeight(1);var23.setBalanceFactor(0);
        AVLNode<Integer> var24 = new AVLNode<>(rand50);var24.setHeight(0);var24.setBalanceFactor(0);
        AVLNode<Integer> var25 = null;
        var24.setLeft(var25);
        AVLNode<Integer> var26 = null;
        var24.setRight(var26);
        var23.setLeft(var24);
        AVLNode<Integer> var27 = new AVLNode<>(rand732);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        var23.setRight(var27);
        otherTree.setRight(var23);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer rand554 = new Integer(554);
        tree.add(rand554);

        // Validating last operation...
        otherTree = new AVLNode<>(rand323);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var30 = new AVLNode<>(randneg218);var30.setHeight(1);var30.setBalanceFactor(0);
        AVLNode<Integer> var31 = new AVLNode<>(randneg924);var31.setHeight(0);var31.setBalanceFactor(0);
        AVLNode<Integer> var32 = null;
        var31.setLeft(var32);
        AVLNode<Integer> var33 = null;
        var31.setRight(var33);
        var30.setLeft(var31);
        AVLNode<Integer> var34 = new AVLNode<>(rand50);var34.setHeight(0);var34.setBalanceFactor(0);
        AVLNode<Integer> var35 = null;
        var34.setLeft(var35);
        AVLNode<Integer> var36 = null;
        var34.setRight(var36);
        var30.setRight(var34);
        otherTree.setLeft(var30);
        AVLNode<Integer> var37 = new AVLNode<>(rand732);var37.setHeight(1);var37.setBalanceFactor(1);
        AVLNode<Integer> var38 = new AVLNode<>(rand554);var38.setHeight(0);var38.setBalanceFactor(0);
        AVLNode<Integer> var39 = null;
        var38.setLeft(var39);
        AVLNode<Integer> var40 = null;
        var38.setRight(var40);
        var37.setLeft(var38);
        AVLNode<Integer> var41 = null;
        var37.setRight(var41);
        otherTree.setRight(var37);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer randneg410 = new Integer(-410);
        tree.add(randneg410);

        // Validating last operation...
        otherTree = new AVLNode<>(rand323);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var42 = new AVLNode<>(randneg218);var42.setHeight(2);var42.setBalanceFactor(1);
        AVLNode<Integer> var43 = new AVLNode<>(randneg924);var43.setHeight(1);var43.setBalanceFactor(-1);
        AVLNode<Integer> var44 = null;
        var43.setLeft(var44);
        AVLNode<Integer> var45 = new AVLNode<>(randneg410);var45.setHeight(0);var45.setBalanceFactor(0);
        AVLNode<Integer> var46 = null;
        var45.setLeft(var46);
        AVLNode<Integer> var47 = null;
        var45.setRight(var47);
        var43.setRight(var45);
        var42.setLeft(var43);
        AVLNode<Integer> var48 = new AVLNode<>(rand50);var48.setHeight(0);var48.setBalanceFactor(0);
        AVLNode<Integer> var49 = null;
        var48.setLeft(var49);
        AVLNode<Integer> var50 = null;
        var48.setRight(var50);
        var42.setRight(var48);
        otherTree.setLeft(var42);
        AVLNode<Integer> var51 = new AVLNode<>(rand732);var51.setHeight(1);var51.setBalanceFactor(1);
        AVLNode<Integer> var52 = new AVLNode<>(rand554);var52.setHeight(0);var52.setBalanceFactor(0);
        AVLNode<Integer> var53 = null;
        var52.setLeft(var53);
        AVLNode<Integer> var54 = null;
        var52.setRight(var54);
        var51.setLeft(var52);
        AVLNode<Integer> var55 = null;
        var51.setRight(var55);
        otherTree.setRight(var51);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer randneg656 = new Integer(-656);
        tree.add(randneg656);

        // Validating last operation...
        otherTree = new AVLNode<>(rand323);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var56 = new AVLNode<>(randneg218);var56.setHeight(2);var56.setBalanceFactor(1);
        AVLNode<Integer> var57 = new AVLNode<>(randneg656);var57.setHeight(1);var57.setBalanceFactor(0);
        AVLNode<Integer> var58 = new AVLNode<>(randneg924);var58.setHeight(0);var58.setBalanceFactor(0);
        AVLNode<Integer> var59 = null;
        var58.setLeft(var59);
        AVLNode<Integer> var60 = null;
        var58.setRight(var60);
        var57.setLeft(var58);
        AVLNode<Integer> var61 = new AVLNode<>(randneg410);var61.setHeight(0);var61.setBalanceFactor(0);
        AVLNode<Integer> var62 = null;
        var61.setLeft(var62);
        AVLNode<Integer> var63 = null;
        var61.setRight(var63);
        var57.setRight(var61);
        var56.setLeft(var57);
        AVLNode<Integer> var64 = new AVLNode<>(rand50);var64.setHeight(0);var64.setBalanceFactor(0);
        AVLNode<Integer> var65 = null;
        var64.setLeft(var65);
        AVLNode<Integer> var66 = null;
        var64.setRight(var66);
        var56.setRight(var64);
        otherTree.setLeft(var56);
        AVLNode<Integer> var67 = new AVLNode<>(rand732);var67.setHeight(1);var67.setBalanceFactor(1);
        AVLNode<Integer> var68 = new AVLNode<>(rand554);var68.setHeight(0);var68.setBalanceFactor(0);
        AVLNode<Integer> var69 = null;
        var68.setLeft(var69);
        AVLNode<Integer> var70 = null;
        var68.setRight(var70);
        var67.setLeft(var68);
        AVLNode<Integer> var71 = null;
        var67.setRight(var71);
        otherTree.setRight(var67);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        assertSame(rand554, tree.remove(rand554.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg218);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var72 = new AVLNode<>(randneg656);var72.setHeight(1);var72.setBalanceFactor(0);
        AVLNode<Integer> var73 = new AVLNode<>(randneg924);var73.setHeight(0);var73.setBalanceFactor(0);
        AVLNode<Integer> var74 = null;
        var73.setLeft(var74);
        AVLNode<Integer> var75 = null;
        var73.setRight(var75);
        var72.setLeft(var73);
        AVLNode<Integer> var76 = new AVLNode<>(randneg410);var76.setHeight(0);var76.setBalanceFactor(0);
        AVLNode<Integer> var77 = null;
        var76.setLeft(var77);
        AVLNode<Integer> var78 = null;
        var76.setRight(var78);
        var72.setRight(var76);
        otherTree.setLeft(var72);
        AVLNode<Integer> var79 = new AVLNode<>(rand323);var79.setHeight(1);var79.setBalanceFactor(0);
        AVLNode<Integer> var80 = new AVLNode<>(rand50);var80.setHeight(0);var80.setBalanceFactor(0);
        AVLNode<Integer> var81 = null;
        var80.setLeft(var81);
        AVLNode<Integer> var82 = null;
        var80.setRight(var82);
        var79.setLeft(var80);
        AVLNode<Integer> var83 = new AVLNode<>(rand732);var83.setHeight(0);var83.setBalanceFactor(0);
        AVLNode<Integer> var84 = null;
        var83.setLeft(var84);
        AVLNode<Integer> var85 = null;
        var83.setRight(var85);
        var79.setRight(var83);
        otherTree.setRight(var79);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer randneg279 = new Integer(-279);
        tree.add(randneg279);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg218);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var86 = new AVLNode<>(randneg656);var86.setHeight(2);var86.setBalanceFactor(-1);
        AVLNode<Integer> var87 = new AVLNode<>(randneg924);var87.setHeight(0);var87.setBalanceFactor(0);
        AVLNode<Integer> var88 = null;
        var87.setLeft(var88);
        AVLNode<Integer> var89 = null;
        var87.setRight(var89);
        var86.setLeft(var87);
        AVLNode<Integer> var90 = new AVLNode<>(randneg410);var90.setHeight(1);var90.setBalanceFactor(-1);
        AVLNode<Integer> var91 = null;
        var90.setLeft(var91);
        AVLNode<Integer> var92 = new AVLNode<>(randneg279);var92.setHeight(0);var92.setBalanceFactor(0);
        AVLNode<Integer> var93 = null;
        var92.setLeft(var93);
        AVLNode<Integer> var94 = null;
        var92.setRight(var94);
        var90.setRight(var92);
        var86.setRight(var90);
        otherTree.setLeft(var86);
        AVLNode<Integer> var95 = new AVLNode<>(rand323);var95.setHeight(1);var95.setBalanceFactor(0);
        AVLNode<Integer> var96 = new AVLNode<>(rand50);var96.setHeight(0);var96.setBalanceFactor(0);
        AVLNode<Integer> var97 = null;
        var96.setLeft(var97);
        AVLNode<Integer> var98 = null;
        var96.setRight(var98);
        var95.setLeft(var96);
        AVLNode<Integer> var99 = new AVLNode<>(rand732);var99.setHeight(0);var99.setBalanceFactor(0);
        AVLNode<Integer> var100 = null;
        var99.setLeft(var100);
        AVLNode<Integer> var101 = null;
        var99.setRight(var101);
        var95.setRight(var99);
        otherTree.setRight(var95);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        assertSame(randneg656, tree.remove(randneg656.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg218);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var102 = new AVLNode<>(randneg410);var102.setHeight(1);var102.setBalanceFactor(0);
        AVLNode<Integer> var103 = new AVLNode<>(randneg924);var103.setHeight(0);var103.setBalanceFactor(0);
        AVLNode<Integer> var104 = null;
        var103.setLeft(var104);
        AVLNode<Integer> var105 = null;
        var103.setRight(var105);
        var102.setLeft(var103);
        AVLNode<Integer> var106 = new AVLNode<>(randneg279);var106.setHeight(0);var106.setBalanceFactor(0);
        AVLNode<Integer> var107 = null;
        var106.setLeft(var107);
        AVLNode<Integer> var108 = null;
        var106.setRight(var108);
        var102.setRight(var106);
        otherTree.setLeft(var102);
        AVLNode<Integer> var109 = new AVLNode<>(rand323);var109.setHeight(1);var109.setBalanceFactor(0);
        AVLNode<Integer> var110 = new AVLNode<>(rand50);var110.setHeight(0);var110.setBalanceFactor(0);
        AVLNode<Integer> var111 = null;
        var110.setLeft(var111);
        AVLNode<Integer> var112 = null;
        var110.setRight(var112);
        var109.setLeft(var110);
        AVLNode<Integer> var113 = new AVLNode<>(rand732);var113.setHeight(0);var113.setBalanceFactor(0);
        AVLNode<Integer> var114 = null;
        var113.setLeft(var114);
        AVLNode<Integer> var115 = null;
        var113.setRight(var115);
        var109.setRight(var113);
        otherTree.setRight(var109);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer randneg16 = new Integer(-16);
        tree.add(randneg16);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg218);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var116 = new AVLNode<>(randneg410);var116.setHeight(1);var116.setBalanceFactor(0);
        AVLNode<Integer> var117 = new AVLNode<>(randneg924);var117.setHeight(0);var117.setBalanceFactor(0);
        AVLNode<Integer> var118 = null;
        var117.setLeft(var118);
        AVLNode<Integer> var119 = null;
        var117.setRight(var119);
        var116.setLeft(var117);
        AVLNode<Integer> var120 = new AVLNode<>(randneg279);var120.setHeight(0);var120.setBalanceFactor(0);
        AVLNode<Integer> var121 = null;
        var120.setLeft(var121);
        AVLNode<Integer> var122 = null;
        var120.setRight(var122);
        var116.setRight(var120);
        otherTree.setLeft(var116);
        AVLNode<Integer> var123 = new AVLNode<>(rand323);var123.setHeight(2);var123.setBalanceFactor(1);
        AVLNode<Integer> var124 = new AVLNode<>(rand50);var124.setHeight(1);var124.setBalanceFactor(1);
        AVLNode<Integer> var125 = new AVLNode<>(randneg16);var125.setHeight(0);var125.setBalanceFactor(0);
        AVLNode<Integer> var126 = null;
        var125.setLeft(var126);
        AVLNode<Integer> var127 = null;
        var125.setRight(var127);
        var124.setLeft(var125);
        AVLNode<Integer> var128 = null;
        var124.setRight(var128);
        var123.setLeft(var124);
        AVLNode<Integer> var129 = new AVLNode<>(rand732);var129.setHeight(0);var129.setBalanceFactor(0);
        AVLNode<Integer> var130 = null;
        var129.setLeft(var130);
        AVLNode<Integer> var131 = null;
        var129.setRight(var131);
        var123.setRight(var129);
        otherTree.setRight(var123);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        assertSame(rand50, tree.remove(rand50.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg218);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var132 = new AVLNode<>(randneg410);var132.setHeight(1);var132.setBalanceFactor(0);
        AVLNode<Integer> var133 = new AVLNode<>(randneg924);var133.setHeight(0);var133.setBalanceFactor(0);
        AVLNode<Integer> var134 = null;
        var133.setLeft(var134);
        AVLNode<Integer> var135 = null;
        var133.setRight(var135);
        var132.setLeft(var133);
        AVLNode<Integer> var136 = new AVLNode<>(randneg279);var136.setHeight(0);var136.setBalanceFactor(0);
        AVLNode<Integer> var137 = null;
        var136.setLeft(var137);
        AVLNode<Integer> var138 = null;
        var136.setRight(var138);
        var132.setRight(var136);
        otherTree.setLeft(var132);
        AVLNode<Integer> var139 = new AVLNode<>(rand323);var139.setHeight(1);var139.setBalanceFactor(0);
        AVLNode<Integer> var140 = new AVLNode<>(randneg16);var140.setHeight(0);var140.setBalanceFactor(0);
        AVLNode<Integer> var141 = null;
        var140.setLeft(var141);
        AVLNode<Integer> var142 = null;
        var140.setRight(var142);
        var139.setLeft(var140);
        AVLNode<Integer> var143 = new AVLNode<>(rand732);var143.setHeight(0);var143.setBalanceFactor(0);
        AVLNode<Integer> var144 = null;
        var143.setLeft(var144);
        AVLNode<Integer> var145 = null;
        var143.setRight(var145);
        var139.setRight(var143);
        otherTree.setRight(var139);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer randneg596 = new Integer(-596);
        tree.add(randneg596);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg218);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var146 = new AVLNode<>(randneg410);var146.setHeight(2);var146.setBalanceFactor(1);
        AVLNode<Integer> var147 = new AVLNode<>(randneg924);var147.setHeight(1);var147.setBalanceFactor(-1);
        AVLNode<Integer> var148 = null;
        var147.setLeft(var148);
        AVLNode<Integer> var149 = new AVLNode<>(randneg596);var149.setHeight(0);var149.setBalanceFactor(0);
        AVLNode<Integer> var150 = null;
        var149.setLeft(var150);
        AVLNode<Integer> var151 = null;
        var149.setRight(var151);
        var147.setRight(var149);
        var146.setLeft(var147);
        AVLNode<Integer> var152 = new AVLNode<>(randneg279);var152.setHeight(0);var152.setBalanceFactor(0);
        AVLNode<Integer> var153 = null;
        var152.setLeft(var153);
        AVLNode<Integer> var154 = null;
        var152.setRight(var154);
        var146.setRight(var152);
        otherTree.setLeft(var146);
        AVLNode<Integer> var155 = new AVLNode<>(rand323);var155.setHeight(1);var155.setBalanceFactor(0);
        AVLNode<Integer> var156 = new AVLNode<>(randneg16);var156.setHeight(0);var156.setBalanceFactor(0);
        AVLNode<Integer> var157 = null;
        var156.setLeft(var157);
        AVLNode<Integer> var158 = null;
        var156.setRight(var158);
        var155.setLeft(var156);
        AVLNode<Integer> var159 = new AVLNode<>(rand732);var159.setHeight(0);var159.setBalanceFactor(0);
        AVLNode<Integer> var160 = null;
        var159.setLeft(var160);
        AVLNode<Integer> var161 = null;
        var159.setRight(var161);
        var155.setRight(var159);
        otherTree.setRight(var155);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer randneg190 = new Integer(-190);
        tree.add(randneg190);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg218);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var162 = new AVLNode<>(randneg410);var162.setHeight(2);var162.setBalanceFactor(1);
        AVLNode<Integer> var163 = new AVLNode<>(randneg924);var163.setHeight(1);var163.setBalanceFactor(-1);
        AVLNode<Integer> var164 = null;
        var163.setLeft(var164);
        AVLNode<Integer> var165 = new AVLNode<>(randneg596);var165.setHeight(0);var165.setBalanceFactor(0);
        AVLNode<Integer> var166 = null;
        var165.setLeft(var166);
        AVLNode<Integer> var167 = null;
        var165.setRight(var167);
        var163.setRight(var165);
        var162.setLeft(var163);
        AVLNode<Integer> var168 = new AVLNode<>(randneg279);var168.setHeight(0);var168.setBalanceFactor(0);
        AVLNode<Integer> var169 = null;
        var168.setLeft(var169);
        AVLNode<Integer> var170 = null;
        var168.setRight(var170);
        var162.setRight(var168);
        otherTree.setLeft(var162);
        AVLNode<Integer> var171 = new AVLNode<>(rand323);var171.setHeight(2);var171.setBalanceFactor(1);
        AVLNode<Integer> var172 = new AVLNode<>(randneg16);var172.setHeight(1);var172.setBalanceFactor(1);
        AVLNode<Integer> var173 = new AVLNode<>(randneg190);var173.setHeight(0);var173.setBalanceFactor(0);
        AVLNode<Integer> var174 = null;
        var173.setLeft(var174);
        AVLNode<Integer> var175 = null;
        var173.setRight(var175);
        var172.setLeft(var173);
        AVLNode<Integer> var176 = null;
        var172.setRight(var176);
        var171.setLeft(var172);
        AVLNode<Integer> var177 = new AVLNode<>(rand732);var177.setHeight(0);var177.setBalanceFactor(0);
        AVLNode<Integer> var178 = null;
        var177.setLeft(var178);
        AVLNode<Integer> var179 = null;
        var177.setRight(var179);
        var171.setRight(var177);
        otherTree.setRight(var171);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #8: ==========
    @Test(timeout = TIMEOUT)
    public void test8() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg838 = new Integer(-838);
        tree.add(randneg838);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg838);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer rand406 = new Integer(406);
        tree.add(rand406);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg838);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = new AVLNode<>(rand406);var3.setHeight(0);var3.setBalanceFactor(0);
        AVLNode<Integer> var4 = null;
        var3.setLeft(var4);
        AVLNode<Integer> var5 = null;
        var3.setRight(var5);
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer randneg195 = new Integer(-195);
        tree.add(randneg195);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg195);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(randneg838);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(rand406);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer randneg184 = new Integer(-184);
        tree.add(randneg184);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg195);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var12 = new AVLNode<>(randneg838);var12.setHeight(0);var12.setBalanceFactor(0);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = null;
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var15 = new AVLNode<>(rand406);var15.setHeight(1);var15.setBalanceFactor(1);
        AVLNode<Integer> var16 = new AVLNode<>(randneg184);var16.setHeight(0);var16.setBalanceFactor(0);
        AVLNode<Integer> var17 = null;
        var16.setLeft(var17);
        AVLNode<Integer> var18 = null;
        var16.setRight(var18);
        var15.setLeft(var16);
        AVLNode<Integer> var19 = null;
        var15.setRight(var19);
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer rand976 = new Integer(976);
        tree.add(rand976);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg195);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var20 = new AVLNode<>(randneg838);var20.setHeight(0);var20.setBalanceFactor(0);
        AVLNode<Integer> var21 = null;
        var20.setLeft(var21);
        AVLNode<Integer> var22 = null;
        var20.setRight(var22);
        otherTree.setLeft(var20);
        AVLNode<Integer> var23 = new AVLNode<>(rand406);var23.setHeight(1);var23.setBalanceFactor(0);
        AVLNode<Integer> var24 = new AVLNode<>(randneg184);var24.setHeight(0);var24.setBalanceFactor(0);
        AVLNode<Integer> var25 = null;
        var24.setLeft(var25);
        AVLNode<Integer> var26 = null;
        var24.setRight(var26);
        var23.setLeft(var24);
        AVLNode<Integer> var27 = new AVLNode<>(rand976);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        var23.setRight(var27);
        otherTree.setRight(var23);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer rand50 = new Integer(50);
        tree.add(rand50);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg184);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var30 = new AVLNode<>(randneg195);var30.setHeight(1);var30.setBalanceFactor(1);
        AVLNode<Integer> var31 = new AVLNode<>(randneg838);var31.setHeight(0);var31.setBalanceFactor(0);
        AVLNode<Integer> var32 = null;
        var31.setLeft(var32);
        AVLNode<Integer> var33 = null;
        var31.setRight(var33);
        var30.setLeft(var31);
        AVLNode<Integer> var34 = null;
        var30.setRight(var34);
        otherTree.setLeft(var30);
        AVLNode<Integer> var35 = new AVLNode<>(rand406);var35.setHeight(1);var35.setBalanceFactor(0);
        AVLNode<Integer> var36 = new AVLNode<>(rand50);var36.setHeight(0);var36.setBalanceFactor(0);
        AVLNode<Integer> var37 = null;
        var36.setLeft(var37);
        AVLNode<Integer> var38 = null;
        var36.setRight(var38);
        var35.setLeft(var36);
        AVLNode<Integer> var39 = new AVLNode<>(rand976);var39.setHeight(0);var39.setBalanceFactor(0);
        AVLNode<Integer> var40 = null;
        var39.setLeft(var40);
        AVLNode<Integer> var41 = null;
        var39.setRight(var41);
        var35.setRight(var39);
        otherTree.setRight(var35);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer randneg232 = new Integer(-232);
        tree.add(randneg232);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg184);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var42 = new AVLNode<>(randneg232);var42.setHeight(1);var42.setBalanceFactor(0);
        AVLNode<Integer> var43 = new AVLNode<>(randneg838);var43.setHeight(0);var43.setBalanceFactor(0);
        AVLNode<Integer> var44 = null;
        var43.setLeft(var44);
        AVLNode<Integer> var45 = null;
        var43.setRight(var45);
        var42.setLeft(var43);
        AVLNode<Integer> var46 = new AVLNode<>(randneg195);var46.setHeight(0);var46.setBalanceFactor(0);
        AVLNode<Integer> var47 = null;
        var46.setLeft(var47);
        AVLNode<Integer> var48 = null;
        var46.setRight(var48);
        var42.setRight(var46);
        otherTree.setLeft(var42);
        AVLNode<Integer> var49 = new AVLNode<>(rand406);var49.setHeight(1);var49.setBalanceFactor(0);
        AVLNode<Integer> var50 = new AVLNode<>(rand50);var50.setHeight(0);var50.setBalanceFactor(0);
        AVLNode<Integer> var51 = null;
        var50.setLeft(var51);
        AVLNode<Integer> var52 = null;
        var50.setRight(var52);
        var49.setLeft(var50);
        AVLNode<Integer> var53 = new AVLNode<>(rand976);var53.setHeight(0);var53.setBalanceFactor(0);
        AVLNode<Integer> var54 = null;
        var53.setLeft(var54);
        AVLNode<Integer> var55 = null;
        var53.setRight(var55);
        var49.setRight(var53);
        otherTree.setRight(var49);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer randneg381 = new Integer(-381);
        tree.add(randneg381);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg184);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var56 = new AVLNode<>(randneg232);var56.setHeight(2);var56.setBalanceFactor(1);
        AVLNode<Integer> var57 = new AVLNode<>(randneg838);var57.setHeight(1);var57.setBalanceFactor(-1);
        AVLNode<Integer> var58 = null;
        var57.setLeft(var58);
        AVLNode<Integer> var59 = new AVLNode<>(randneg381);var59.setHeight(0);var59.setBalanceFactor(0);
        AVLNode<Integer> var60 = null;
        var59.setLeft(var60);
        AVLNode<Integer> var61 = null;
        var59.setRight(var61);
        var57.setRight(var59);
        var56.setLeft(var57);
        AVLNode<Integer> var62 = new AVLNode<>(randneg195);var62.setHeight(0);var62.setBalanceFactor(0);
        AVLNode<Integer> var63 = null;
        var62.setLeft(var63);
        AVLNode<Integer> var64 = null;
        var62.setRight(var64);
        var56.setRight(var62);
        otherTree.setLeft(var56);
        AVLNode<Integer> var65 = new AVLNode<>(rand406);var65.setHeight(1);var65.setBalanceFactor(0);
        AVLNode<Integer> var66 = new AVLNode<>(rand50);var66.setHeight(0);var66.setBalanceFactor(0);
        AVLNode<Integer> var67 = null;
        var66.setLeft(var67);
        AVLNode<Integer> var68 = null;
        var66.setRight(var68);
        var65.setLeft(var66);
        AVLNode<Integer> var69 = new AVLNode<>(rand976);var69.setHeight(0);var69.setBalanceFactor(0);
        AVLNode<Integer> var70 = null;
        var69.setLeft(var70);
        AVLNode<Integer> var71 = null;
        var69.setRight(var71);
        var65.setRight(var69);
        otherTree.setRight(var65);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer randneg780 = new Integer(-780);
        tree.add(randneg780);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg184);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var72 = new AVLNode<>(randneg232);var72.setHeight(2);var72.setBalanceFactor(1);
        AVLNode<Integer> var73 = new AVLNode<>(randneg780);var73.setHeight(1);var73.setBalanceFactor(0);
        AVLNode<Integer> var74 = new AVLNode<>(randneg838);var74.setHeight(0);var74.setBalanceFactor(0);
        AVLNode<Integer> var75 = null;
        var74.setLeft(var75);
        AVLNode<Integer> var76 = null;
        var74.setRight(var76);
        var73.setLeft(var74);
        AVLNode<Integer> var77 = new AVLNode<>(randneg381);var77.setHeight(0);var77.setBalanceFactor(0);
        AVLNode<Integer> var78 = null;
        var77.setLeft(var78);
        AVLNode<Integer> var79 = null;
        var77.setRight(var79);
        var73.setRight(var77);
        var72.setLeft(var73);
        AVLNode<Integer> var80 = new AVLNode<>(randneg195);var80.setHeight(0);var80.setBalanceFactor(0);
        AVLNode<Integer> var81 = null;
        var80.setLeft(var81);
        AVLNode<Integer> var82 = null;
        var80.setRight(var82);
        var72.setRight(var80);
        otherTree.setLeft(var72);
        AVLNode<Integer> var83 = new AVLNode<>(rand406);var83.setHeight(1);var83.setBalanceFactor(0);
        AVLNode<Integer> var84 = new AVLNode<>(rand50);var84.setHeight(0);var84.setBalanceFactor(0);
        AVLNode<Integer> var85 = null;
        var84.setLeft(var85);
        AVLNode<Integer> var86 = null;
        var84.setRight(var86);
        var83.setLeft(var84);
        AVLNode<Integer> var87 = new AVLNode<>(rand976);var87.setHeight(0);var87.setBalanceFactor(0);
        AVLNode<Integer> var88 = null;
        var87.setLeft(var88);
        AVLNode<Integer> var89 = null;
        var87.setRight(var89);
        var83.setRight(var87);
        otherTree.setRight(var83);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer rand375 = new Integer(375);
        tree.add(rand375);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg184);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var90 = new AVLNode<>(randneg232);var90.setHeight(2);var90.setBalanceFactor(1);
        AVLNode<Integer> var91 = new AVLNode<>(randneg780);var91.setHeight(1);var91.setBalanceFactor(0);
        AVLNode<Integer> var92 = new AVLNode<>(randneg838);var92.setHeight(0);var92.setBalanceFactor(0);
        AVLNode<Integer> var93 = null;
        var92.setLeft(var93);
        AVLNode<Integer> var94 = null;
        var92.setRight(var94);
        var91.setLeft(var92);
        AVLNode<Integer> var95 = new AVLNode<>(randneg381);var95.setHeight(0);var95.setBalanceFactor(0);
        AVLNode<Integer> var96 = null;
        var95.setLeft(var96);
        AVLNode<Integer> var97 = null;
        var95.setRight(var97);
        var91.setRight(var95);
        var90.setLeft(var91);
        AVLNode<Integer> var98 = new AVLNode<>(randneg195);var98.setHeight(0);var98.setBalanceFactor(0);
        AVLNode<Integer> var99 = null;
        var98.setLeft(var99);
        AVLNode<Integer> var100 = null;
        var98.setRight(var100);
        var90.setRight(var98);
        otherTree.setLeft(var90);
        AVLNode<Integer> var101 = new AVLNode<>(rand406);var101.setHeight(2);var101.setBalanceFactor(1);
        AVLNode<Integer> var102 = new AVLNode<>(rand50);var102.setHeight(1);var102.setBalanceFactor(-1);
        AVLNode<Integer> var103 = null;
        var102.setLeft(var103);
        AVLNode<Integer> var104 = new AVLNode<>(rand375);var104.setHeight(0);var104.setBalanceFactor(0);
        AVLNode<Integer> var105 = null;
        var104.setLeft(var105);
        AVLNode<Integer> var106 = null;
        var104.setRight(var106);
        var102.setRight(var104);
        var101.setLeft(var102);
        AVLNode<Integer> var107 = new AVLNode<>(rand976);var107.setHeight(0);var107.setBalanceFactor(0);
        AVLNode<Integer> var108 = null;
        var107.setLeft(var108);
        AVLNode<Integer> var109 = null;
        var107.setRight(var109);
        var101.setRight(var107);
        otherTree.setRight(var101);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer randneg434 = new Integer(-434);
        tree.add(randneg434);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg184);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var110 = new AVLNode<>(randneg381);var110.setHeight(2);var110.setBalanceFactor(0);
        AVLNode<Integer> var111 = new AVLNode<>(randneg780);var111.setHeight(1);var111.setBalanceFactor(0);
        AVLNode<Integer> var112 = new AVLNode<>(randneg838);var112.setHeight(0);var112.setBalanceFactor(0);
        AVLNode<Integer> var113 = null;
        var112.setLeft(var113);
        AVLNode<Integer> var114 = null;
        var112.setRight(var114);
        var111.setLeft(var112);
        AVLNode<Integer> var115 = new AVLNode<>(randneg434);var115.setHeight(0);var115.setBalanceFactor(0);
        AVLNode<Integer> var116 = null;
        var115.setLeft(var116);
        AVLNode<Integer> var117 = null;
        var115.setRight(var117);
        var111.setRight(var115);
        var110.setLeft(var111);
        AVLNode<Integer> var118 = new AVLNode<>(randneg232);var118.setHeight(1);var118.setBalanceFactor(-1);
        AVLNode<Integer> var119 = null;
        var118.setLeft(var119);
        AVLNode<Integer> var120 = new AVLNode<>(randneg195);var120.setHeight(0);var120.setBalanceFactor(0);
        AVLNode<Integer> var121 = null;
        var120.setLeft(var121);
        AVLNode<Integer> var122 = null;
        var120.setRight(var122);
        var118.setRight(var120);
        var110.setRight(var118);
        otherTree.setLeft(var110);
        AVLNode<Integer> var123 = new AVLNode<>(rand406);var123.setHeight(2);var123.setBalanceFactor(1);
        AVLNode<Integer> var124 = new AVLNode<>(rand50);var124.setHeight(1);var124.setBalanceFactor(-1);
        AVLNode<Integer> var125 = null;
        var124.setLeft(var125);
        AVLNode<Integer> var126 = new AVLNode<>(rand375);var126.setHeight(0);var126.setBalanceFactor(0);
        AVLNode<Integer> var127 = null;
        var126.setLeft(var127);
        AVLNode<Integer> var128 = null;
        var126.setRight(var128);
        var124.setRight(var126);
        var123.setLeft(var124);
        AVLNode<Integer> var129 = new AVLNode<>(rand976);var129.setHeight(0);var129.setBalanceFactor(0);
        AVLNode<Integer> var130 = null;
        var129.setLeft(var130);
        AVLNode<Integer> var131 = null;
        var129.setRight(var131);
        var123.setRight(var129);
        otherTree.setRight(var123);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer randneg978 = new Integer(-978);
        tree.add(randneg978);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg184);otherTree.setHeight(4);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var132 = new AVLNode<>(randneg381);var132.setHeight(3);var132.setBalanceFactor(1);
        AVLNode<Integer> var133 = new AVLNode<>(randneg780);var133.setHeight(2);var133.setBalanceFactor(1);
        AVLNode<Integer> var134 = new AVLNode<>(randneg838);var134.setHeight(1);var134.setBalanceFactor(1);
        AVLNode<Integer> var135 = new AVLNode<>(randneg978);var135.setHeight(0);var135.setBalanceFactor(0);
        AVLNode<Integer> var136 = null;
        var135.setLeft(var136);
        AVLNode<Integer> var137 = null;
        var135.setRight(var137);
        var134.setLeft(var135);
        AVLNode<Integer> var138 = null;
        var134.setRight(var138);
        var133.setLeft(var134);
        AVLNode<Integer> var139 = new AVLNode<>(randneg434);var139.setHeight(0);var139.setBalanceFactor(0);
        AVLNode<Integer> var140 = null;
        var139.setLeft(var140);
        AVLNode<Integer> var141 = null;
        var139.setRight(var141);
        var133.setRight(var139);
        var132.setLeft(var133);
        AVLNode<Integer> var142 = new AVLNode<>(randneg232);var142.setHeight(1);var142.setBalanceFactor(-1);
        AVLNode<Integer> var143 = null;
        var142.setLeft(var143);
        AVLNode<Integer> var144 = new AVLNode<>(randneg195);var144.setHeight(0);var144.setBalanceFactor(0);
        AVLNode<Integer> var145 = null;
        var144.setLeft(var145);
        AVLNode<Integer> var146 = null;
        var144.setRight(var146);
        var142.setRight(var144);
        var132.setRight(var142);
        otherTree.setLeft(var132);
        AVLNode<Integer> var147 = new AVLNode<>(rand406);var147.setHeight(2);var147.setBalanceFactor(1);
        AVLNode<Integer> var148 = new AVLNode<>(rand50);var148.setHeight(1);var148.setBalanceFactor(-1);
        AVLNode<Integer> var149 = null;
        var148.setLeft(var149);
        AVLNode<Integer> var150 = new AVLNode<>(rand375);var150.setHeight(0);var150.setBalanceFactor(0);
        AVLNode<Integer> var151 = null;
        var150.setLeft(var151);
        AVLNode<Integer> var152 = null;
        var150.setRight(var152);
        var148.setRight(var150);
        var147.setLeft(var148);
        AVLNode<Integer> var153 = new AVLNode<>(rand976);var153.setHeight(0);var153.setBalanceFactor(0);
        AVLNode<Integer> var154 = null;
        var153.setLeft(var154);
        AVLNode<Integer> var155 = null;
        var153.setRight(var155);
        var147.setRight(var153);
        otherTree.setRight(var147);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer randneg673 = new Integer(-673);
        tree.add(randneg673);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg184);otherTree.setHeight(4);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var156 = new AVLNode<>(randneg381);var156.setHeight(3);var156.setBalanceFactor(1);
        AVLNode<Integer> var157 = new AVLNode<>(randneg780);var157.setHeight(2);var157.setBalanceFactor(0);
        AVLNode<Integer> var158 = new AVLNode<>(randneg838);var158.setHeight(1);var158.setBalanceFactor(1);
        AVLNode<Integer> var159 = new AVLNode<>(randneg978);var159.setHeight(0);var159.setBalanceFactor(0);
        AVLNode<Integer> var160 = null;
        var159.setLeft(var160);
        AVLNode<Integer> var161 = null;
        var159.setRight(var161);
        var158.setLeft(var159);
        AVLNode<Integer> var162 = null;
        var158.setRight(var162);
        var157.setLeft(var158);
        AVLNode<Integer> var163 = new AVLNode<>(randneg434);var163.setHeight(1);var163.setBalanceFactor(1);
        AVLNode<Integer> var164 = new AVLNode<>(randneg673);var164.setHeight(0);var164.setBalanceFactor(0);
        AVLNode<Integer> var165 = null;
        var164.setLeft(var165);
        AVLNode<Integer> var166 = null;
        var164.setRight(var166);
        var163.setLeft(var164);
        AVLNode<Integer> var167 = null;
        var163.setRight(var167);
        var157.setRight(var163);
        var156.setLeft(var157);
        AVLNode<Integer> var168 = new AVLNode<>(randneg232);var168.setHeight(1);var168.setBalanceFactor(-1);
        AVLNode<Integer> var169 = null;
        var168.setLeft(var169);
        AVLNode<Integer> var170 = new AVLNode<>(randneg195);var170.setHeight(0);var170.setBalanceFactor(0);
        AVLNode<Integer> var171 = null;
        var170.setLeft(var171);
        AVLNode<Integer> var172 = null;
        var170.setRight(var172);
        var168.setRight(var170);
        var156.setRight(var168);
        otherTree.setLeft(var156);
        AVLNode<Integer> var173 = new AVLNode<>(rand406);var173.setHeight(2);var173.setBalanceFactor(1);
        AVLNode<Integer> var174 = new AVLNode<>(rand50);var174.setHeight(1);var174.setBalanceFactor(-1);
        AVLNode<Integer> var175 = null;
        var174.setLeft(var175);
        AVLNode<Integer> var176 = new AVLNode<>(rand375);var176.setHeight(0);var176.setBalanceFactor(0);
        AVLNode<Integer> var177 = null;
        var176.setLeft(var177);
        AVLNode<Integer> var178 = null;
        var176.setRight(var178);
        var174.setRight(var176);
        var173.setLeft(var174);
        AVLNode<Integer> var179 = new AVLNode<>(rand976);var179.setHeight(0);var179.setBalanceFactor(0);
        AVLNode<Integer> var180 = null;
        var179.setLeft(var180);
        AVLNode<Integer> var181 = null;
        var179.setRight(var181);
        var173.setRight(var179);
        otherTree.setRight(var173);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer randneg556 = new Integer(-556);
        tree.add(randneg556);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg184);otherTree.setHeight(4);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var182 = new AVLNode<>(randneg381);var182.setHeight(3);var182.setBalanceFactor(1);
        AVLNode<Integer> var183 = new AVLNode<>(randneg780);var183.setHeight(2);var183.setBalanceFactor(0);
        AVLNode<Integer> var184 = new AVLNode<>(randneg838);var184.setHeight(1);var184.setBalanceFactor(1);
        AVLNode<Integer> var185 = new AVLNode<>(randneg978);var185.setHeight(0);var185.setBalanceFactor(0);
        AVLNode<Integer> var186 = null;
        var185.setLeft(var186);
        AVLNode<Integer> var187 = null;
        var185.setRight(var187);
        var184.setLeft(var185);
        AVLNode<Integer> var188 = null;
        var184.setRight(var188);
        var183.setLeft(var184);
        AVLNode<Integer> var189 = new AVLNode<>(randneg556);var189.setHeight(1);var189.setBalanceFactor(0);
        AVLNode<Integer> var190 = new AVLNode<>(randneg673);var190.setHeight(0);var190.setBalanceFactor(0);
        AVLNode<Integer> var191 = null;
        var190.setLeft(var191);
        AVLNode<Integer> var192 = null;
        var190.setRight(var192);
        var189.setLeft(var190);
        AVLNode<Integer> var193 = new AVLNode<>(randneg434);var193.setHeight(0);var193.setBalanceFactor(0);
        AVLNode<Integer> var194 = null;
        var193.setLeft(var194);
        AVLNode<Integer> var195 = null;
        var193.setRight(var195);
        var189.setRight(var193);
        var183.setRight(var189);
        var182.setLeft(var183);
        AVLNode<Integer> var196 = new AVLNode<>(randneg232);var196.setHeight(1);var196.setBalanceFactor(-1);
        AVLNode<Integer> var197 = null;
        var196.setLeft(var197);
        AVLNode<Integer> var198 = new AVLNode<>(randneg195);var198.setHeight(0);var198.setBalanceFactor(0);
        AVLNode<Integer> var199 = null;
        var198.setLeft(var199);
        AVLNode<Integer> var200 = null;
        var198.setRight(var200);
        var196.setRight(var198);
        var182.setRight(var196);
        otherTree.setLeft(var182);
        AVLNode<Integer> var201 = new AVLNode<>(rand406);var201.setHeight(2);var201.setBalanceFactor(1);
        AVLNode<Integer> var202 = new AVLNode<>(rand50);var202.setHeight(1);var202.setBalanceFactor(-1);
        AVLNode<Integer> var203 = null;
        var202.setLeft(var203);
        AVLNode<Integer> var204 = new AVLNode<>(rand375);var204.setHeight(0);var204.setBalanceFactor(0);
        AVLNode<Integer> var205 = null;
        var204.setLeft(var205);
        AVLNode<Integer> var206 = null;
        var204.setRight(var206);
        var202.setRight(var204);
        var201.setLeft(var202);
        AVLNode<Integer> var207 = new AVLNode<>(rand976);var207.setHeight(0);var207.setBalanceFactor(0);
        AVLNode<Integer> var208 = null;
        var207.setLeft(var208);
        AVLNode<Integer> var209 = null;
        var207.setRight(var209);
        var201.setRight(var207);
        otherTree.setRight(var201);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer randneg161 = new Integer(-161);
        tree.add(randneg161);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg184);otherTree.setHeight(4);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var210 = new AVLNode<>(randneg381);var210.setHeight(3);var210.setBalanceFactor(1);
        AVLNode<Integer> var211 = new AVLNode<>(randneg780);var211.setHeight(2);var211.setBalanceFactor(0);
        AVLNode<Integer> var212 = new AVLNode<>(randneg838);var212.setHeight(1);var212.setBalanceFactor(1);
        AVLNode<Integer> var213 = new AVLNode<>(randneg978);var213.setHeight(0);var213.setBalanceFactor(0);
        AVLNode<Integer> var214 = null;
        var213.setLeft(var214);
        AVLNode<Integer> var215 = null;
        var213.setRight(var215);
        var212.setLeft(var213);
        AVLNode<Integer> var216 = null;
        var212.setRight(var216);
        var211.setLeft(var212);
        AVLNode<Integer> var217 = new AVLNode<>(randneg556);var217.setHeight(1);var217.setBalanceFactor(0);
        AVLNode<Integer> var218 = new AVLNode<>(randneg673);var218.setHeight(0);var218.setBalanceFactor(0);
        AVLNode<Integer> var219 = null;
        var218.setLeft(var219);
        AVLNode<Integer> var220 = null;
        var218.setRight(var220);
        var217.setLeft(var218);
        AVLNode<Integer> var221 = new AVLNode<>(randneg434);var221.setHeight(0);var221.setBalanceFactor(0);
        AVLNode<Integer> var222 = null;
        var221.setLeft(var222);
        AVLNode<Integer> var223 = null;
        var221.setRight(var223);
        var217.setRight(var221);
        var211.setRight(var217);
        var210.setLeft(var211);
        AVLNode<Integer> var224 = new AVLNode<>(randneg232);var224.setHeight(1);var224.setBalanceFactor(-1);
        AVLNode<Integer> var225 = null;
        var224.setLeft(var225);
        AVLNode<Integer> var226 = new AVLNode<>(randneg195);var226.setHeight(0);var226.setBalanceFactor(0);
        AVLNode<Integer> var227 = null;
        var226.setLeft(var227);
        AVLNode<Integer> var228 = null;
        var226.setRight(var228);
        var224.setRight(var226);
        var210.setRight(var224);
        otherTree.setLeft(var210);
        AVLNode<Integer> var229 = new AVLNode<>(rand406);var229.setHeight(2);var229.setBalanceFactor(1);
        AVLNode<Integer> var230 = new AVLNode<>(rand50);var230.setHeight(1);var230.setBalanceFactor(0);
        AVLNode<Integer> var231 = new AVLNode<>(randneg161);var231.setHeight(0);var231.setBalanceFactor(0);
        AVLNode<Integer> var232 = null;
        var231.setLeft(var232);
        AVLNode<Integer> var233 = null;
        var231.setRight(var233);
        var230.setLeft(var231);
        AVLNode<Integer> var234 = new AVLNode<>(rand375);var234.setHeight(0);var234.setBalanceFactor(0);
        AVLNode<Integer> var235 = null;
        var234.setLeft(var235);
        AVLNode<Integer> var236 = null;
        var234.setRight(var236);
        var230.setRight(var234);
        var229.setLeft(var230);
        AVLNode<Integer> var237 = new AVLNode<>(rand976);var237.setHeight(0);var237.setBalanceFactor(0);
        AVLNode<Integer> var238 = null;
        var237.setLeft(var238);
        AVLNode<Integer> var239 = null;
        var237.setRight(var239);
        var229.setRight(var237);
        otherTree.setRight(var229);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #9: ==========
    @Test(timeout = TIMEOUT)
    public void test9() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer rand705 = new Integer(705);
        tree.add(rand705);

        // Validating last operation...
        otherTree = new AVLNode<>(rand705);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        assertSame(rand705, tree.remove(rand705.intValue()));

        // Validating last operation...
        otherTree = null;
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer randneg978 = new Integer(-978);
        tree.add(randneg978);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg978);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = null;
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer randneg185 = new Integer(-185);
        tree.add(randneg185);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg978);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var4 = null;
        otherTree.setLeft(var4);
        AVLNode<Integer> var5 = new AVLNode<>(randneg185);var5.setHeight(0);var5.setBalanceFactor(0);
        AVLNode<Integer> var6 = null;
        var5.setLeft(var6);
        AVLNode<Integer> var7 = null;
        var5.setRight(var7);
        otherTree.setRight(var5);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer rand799 = new Integer(799);
        tree.add(rand799);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg185);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var8 = new AVLNode<>(randneg978);var8.setHeight(0);var8.setBalanceFactor(0);
        AVLNode<Integer> var9 = null;
        var8.setLeft(var9);
        AVLNode<Integer> var10 = null;
        var8.setRight(var10);
        otherTree.setLeft(var8);
        AVLNode<Integer> var11 = new AVLNode<>(rand799);var11.setHeight(0);var11.setBalanceFactor(0);
        AVLNode<Integer> var12 = null;
        var11.setLeft(var12);
        AVLNode<Integer> var13 = null;
        var11.setRight(var13);
        otherTree.setRight(var11);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer rand579 = new Integer(579);
        tree.add(rand579);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg185);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var14 = new AVLNode<>(randneg978);var14.setHeight(0);var14.setBalanceFactor(0);
        AVLNode<Integer> var15 = null;
        var14.setLeft(var15);
        AVLNode<Integer> var16 = null;
        var14.setRight(var16);
        otherTree.setLeft(var14);
        AVLNode<Integer> var17 = new AVLNode<>(rand799);var17.setHeight(1);var17.setBalanceFactor(1);
        AVLNode<Integer> var18 = new AVLNode<>(rand579);var18.setHeight(0);var18.setBalanceFactor(0);
        AVLNode<Integer> var19 = null;
        var18.setLeft(var19);
        AVLNode<Integer> var20 = null;
        var18.setRight(var20);
        var17.setLeft(var18);
        AVLNode<Integer> var21 = null;
        var17.setRight(var21);
        otherTree.setRight(var17);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        assertSame(randneg185, tree.remove(randneg185.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand579);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var22 = new AVLNode<>(randneg978);var22.setHeight(0);var22.setBalanceFactor(0);
        AVLNode<Integer> var23 = null;
        var22.setLeft(var23);
        AVLNode<Integer> var24 = null;
        var22.setRight(var24);
        otherTree.setLeft(var22);
        AVLNode<Integer> var25 = new AVLNode<>(rand799);var25.setHeight(0);var25.setBalanceFactor(0);
        AVLNode<Integer> var26 = null;
        var25.setLeft(var26);
        AVLNode<Integer> var27 = null;
        var25.setRight(var27);
        otherTree.setRight(var25);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        assertSame(rand799, tree.remove(rand799.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand579);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var28 = new AVLNode<>(randneg978);var28.setHeight(0);var28.setBalanceFactor(0);
        AVLNode<Integer> var29 = null;
        var28.setLeft(var29);
        AVLNode<Integer> var30 = null;
        var28.setRight(var30);
        otherTree.setLeft(var28);
        AVLNode<Integer> var31 = null;
        otherTree.setRight(var31);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer randneg953 = new Integer(-953);
        tree.add(randneg953);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg953);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var32 = new AVLNode<>(randneg978);var32.setHeight(0);var32.setBalanceFactor(0);
        AVLNode<Integer> var33 = null;
        var32.setLeft(var33);
        AVLNode<Integer> var34 = null;
        var32.setRight(var34);
        otherTree.setLeft(var32);
        AVLNode<Integer> var35 = new AVLNode<>(rand579);var35.setHeight(0);var35.setBalanceFactor(0);
        AVLNode<Integer> var36 = null;
        var35.setLeft(var36);
        AVLNode<Integer> var37 = null;
        var35.setRight(var37);
        otherTree.setRight(var35);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer rand226 = new Integer(226);
        tree.add(rand226);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg953);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var38 = new AVLNode<>(randneg978);var38.setHeight(0);var38.setBalanceFactor(0);
        AVLNode<Integer> var39 = null;
        var38.setLeft(var39);
        AVLNode<Integer> var40 = null;
        var38.setRight(var40);
        otherTree.setLeft(var38);
        AVLNode<Integer> var41 = new AVLNode<>(rand579);var41.setHeight(1);var41.setBalanceFactor(1);
        AVLNode<Integer> var42 = new AVLNode<>(rand226);var42.setHeight(0);var42.setBalanceFactor(0);
        AVLNode<Integer> var43 = null;
        var42.setLeft(var43);
        AVLNode<Integer> var44 = null;
        var42.setRight(var44);
        var41.setLeft(var42);
        AVLNode<Integer> var45 = null;
        var41.setRight(var45);
        otherTree.setRight(var41);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer rand592 = new Integer(592);
        tree.add(rand592);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg953);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var46 = new AVLNode<>(randneg978);var46.setHeight(0);var46.setBalanceFactor(0);
        AVLNode<Integer> var47 = null;
        var46.setLeft(var47);
        AVLNode<Integer> var48 = null;
        var46.setRight(var48);
        otherTree.setLeft(var46);
        AVLNode<Integer> var49 = new AVLNode<>(rand579);var49.setHeight(1);var49.setBalanceFactor(0);
        AVLNode<Integer> var50 = new AVLNode<>(rand226);var50.setHeight(0);var50.setBalanceFactor(0);
        AVLNode<Integer> var51 = null;
        var50.setLeft(var51);
        AVLNode<Integer> var52 = null;
        var50.setRight(var52);
        var49.setLeft(var50);
        AVLNode<Integer> var53 = new AVLNode<>(rand592);var53.setHeight(0);var53.setBalanceFactor(0);
        AVLNode<Integer> var54 = null;
        var53.setLeft(var54);
        AVLNode<Integer> var55 = null;
        var53.setRight(var55);
        var49.setRight(var53);
        otherTree.setRight(var49);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer rand851 = new Integer(851);
        tree.add(rand851);

        // Validating last operation...
        otherTree = new AVLNode<>(rand579);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var56 = new AVLNode<>(randneg953);var56.setHeight(1);var56.setBalanceFactor(0);
        AVLNode<Integer> var57 = new AVLNode<>(randneg978);var57.setHeight(0);var57.setBalanceFactor(0);
        AVLNode<Integer> var58 = null;
        var57.setLeft(var58);
        AVLNode<Integer> var59 = null;
        var57.setRight(var59);
        var56.setLeft(var57);
        AVLNode<Integer> var60 = new AVLNode<>(rand226);var60.setHeight(0);var60.setBalanceFactor(0);
        AVLNode<Integer> var61 = null;
        var60.setLeft(var61);
        AVLNode<Integer> var62 = null;
        var60.setRight(var62);
        var56.setRight(var60);
        otherTree.setLeft(var56);
        AVLNode<Integer> var63 = new AVLNode<>(rand592);var63.setHeight(1);var63.setBalanceFactor(-1);
        AVLNode<Integer> var64 = null;
        var63.setLeft(var64);
        AVLNode<Integer> var65 = new AVLNode<>(rand851);var65.setHeight(0);var65.setBalanceFactor(0);
        AVLNode<Integer> var66 = null;
        var65.setLeft(var66);
        AVLNode<Integer> var67 = null;
        var65.setRight(var67);
        var63.setRight(var65);
        otherTree.setRight(var63);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer rand558 = new Integer(558);
        tree.add(rand558);

        // Validating last operation...
        otherTree = new AVLNode<>(rand579);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var68 = new AVLNode<>(randneg953);var68.setHeight(2);var68.setBalanceFactor(-1);
        AVLNode<Integer> var69 = new AVLNode<>(randneg978);var69.setHeight(0);var69.setBalanceFactor(0);
        AVLNode<Integer> var70 = null;
        var69.setLeft(var70);
        AVLNode<Integer> var71 = null;
        var69.setRight(var71);
        var68.setLeft(var69);
        AVLNode<Integer> var72 = new AVLNode<>(rand226);var72.setHeight(1);var72.setBalanceFactor(-1);
        AVLNode<Integer> var73 = null;
        var72.setLeft(var73);
        AVLNode<Integer> var74 = new AVLNode<>(rand558);var74.setHeight(0);var74.setBalanceFactor(0);
        AVLNode<Integer> var75 = null;
        var74.setLeft(var75);
        AVLNode<Integer> var76 = null;
        var74.setRight(var76);
        var72.setRight(var74);
        var68.setRight(var72);
        otherTree.setLeft(var68);
        AVLNode<Integer> var77 = new AVLNode<>(rand592);var77.setHeight(1);var77.setBalanceFactor(-1);
        AVLNode<Integer> var78 = null;
        var77.setLeft(var78);
        AVLNode<Integer> var79 = new AVLNode<>(rand851);var79.setHeight(0);var79.setBalanceFactor(0);
        AVLNode<Integer> var80 = null;
        var79.setLeft(var80);
        AVLNode<Integer> var81 = null;
        var79.setRight(var81);
        var77.setRight(var79);
        otherTree.setRight(var77);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer rand737 = new Integer(737);
        tree.add(rand737);

        // Validating last operation...
        otherTree = new AVLNode<>(rand579);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var82 = new AVLNode<>(randneg953);var82.setHeight(2);var82.setBalanceFactor(-1);
        AVLNode<Integer> var83 = new AVLNode<>(randneg978);var83.setHeight(0);var83.setBalanceFactor(0);
        AVLNode<Integer> var84 = null;
        var83.setLeft(var84);
        AVLNode<Integer> var85 = null;
        var83.setRight(var85);
        var82.setLeft(var83);
        AVLNode<Integer> var86 = new AVLNode<>(rand226);var86.setHeight(1);var86.setBalanceFactor(-1);
        AVLNode<Integer> var87 = null;
        var86.setLeft(var87);
        AVLNode<Integer> var88 = new AVLNode<>(rand558);var88.setHeight(0);var88.setBalanceFactor(0);
        AVLNode<Integer> var89 = null;
        var88.setLeft(var89);
        AVLNode<Integer> var90 = null;
        var88.setRight(var90);
        var86.setRight(var88);
        var82.setRight(var86);
        otherTree.setLeft(var82);
        AVLNode<Integer> var91 = new AVLNode<>(rand737);var91.setHeight(1);var91.setBalanceFactor(0);
        AVLNode<Integer> var92 = new AVLNode<>(rand592);var92.setHeight(0);var92.setBalanceFactor(0);
        AVLNode<Integer> var93 = null;
        var92.setLeft(var93);
        AVLNode<Integer> var94 = null;
        var92.setRight(var94);
        var91.setLeft(var92);
        AVLNode<Integer> var95 = new AVLNode<>(rand851);var95.setHeight(0);var95.setBalanceFactor(0);
        AVLNode<Integer> var96 = null;
        var95.setLeft(var96);
        AVLNode<Integer> var97 = null;
        var95.setRight(var97);
        var91.setRight(var95);
        otherTree.setRight(var91);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer rand409 = new Integer(409);
        tree.add(rand409);

        // Validating last operation...
        otherTree = new AVLNode<>(rand579);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var98 = new AVLNode<>(randneg953);var98.setHeight(2);var98.setBalanceFactor(-1);
        AVLNode<Integer> var99 = new AVLNode<>(randneg978);var99.setHeight(0);var99.setBalanceFactor(0);
        AVLNode<Integer> var100 = null;
        var99.setLeft(var100);
        AVLNode<Integer> var101 = null;
        var99.setRight(var101);
        var98.setLeft(var99);
        AVLNode<Integer> var102 = new AVLNode<>(rand409);var102.setHeight(1);var102.setBalanceFactor(0);
        AVLNode<Integer> var103 = new AVLNode<>(rand226);var103.setHeight(0);var103.setBalanceFactor(0);
        AVLNode<Integer> var104 = null;
        var103.setLeft(var104);
        AVLNode<Integer> var105 = null;
        var103.setRight(var105);
        var102.setLeft(var103);
        AVLNode<Integer> var106 = new AVLNode<>(rand558);var106.setHeight(0);var106.setBalanceFactor(0);
        AVLNode<Integer> var107 = null;
        var106.setLeft(var107);
        AVLNode<Integer> var108 = null;
        var106.setRight(var108);
        var102.setRight(var106);
        var98.setRight(var102);
        otherTree.setLeft(var98);
        AVLNode<Integer> var109 = new AVLNode<>(rand737);var109.setHeight(1);var109.setBalanceFactor(0);
        AVLNode<Integer> var110 = new AVLNode<>(rand592);var110.setHeight(0);var110.setBalanceFactor(0);
        AVLNode<Integer> var111 = null;
        var110.setLeft(var111);
        AVLNode<Integer> var112 = null;
        var110.setRight(var112);
        var109.setLeft(var110);
        AVLNode<Integer> var113 = new AVLNode<>(rand851);var113.setHeight(0);var113.setBalanceFactor(0);
        AVLNode<Integer> var114 = null;
        var113.setLeft(var114);
        AVLNode<Integer> var115 = null;
        var113.setRight(var115);
        var109.setRight(var113);
        otherTree.setRight(var109);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #10: ==========
    @Test(timeout = TIMEOUT)
    public void test10() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg564 = new Integer(-564);
        tree.add(randneg564);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg564);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer randneg521 = new Integer(-521);
        tree.add(randneg521);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg564);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = new AVLNode<>(randneg521);var3.setHeight(0);var3.setBalanceFactor(0);
        AVLNode<Integer> var4 = null;
        var3.setLeft(var4);
        AVLNode<Integer> var5 = null;
        var3.setRight(var5);
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        assertSame(randneg564, tree.remove(randneg564.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg521);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = null;
        otherTree.setLeft(var6);
        AVLNode<Integer> var7 = null;
        otherTree.setRight(var7);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer randneg82 = new Integer(-82);
        tree.add(randneg82);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg521);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var8 = null;
        otherTree.setLeft(var8);
        AVLNode<Integer> var9 = new AVLNode<>(randneg82);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer rand150 = new Integer(150);
        tree.add(rand150);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg82);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var12 = new AVLNode<>(randneg521);var12.setHeight(0);var12.setBalanceFactor(0);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = null;
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var15 = new AVLNode<>(rand150);var15.setHeight(0);var15.setBalanceFactor(0);
        AVLNode<Integer> var16 = null;
        var15.setLeft(var16);
        AVLNode<Integer> var17 = null;
        var15.setRight(var17);
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer randneg23 = new Integer(-23);
        tree.add(randneg23);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg82);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var18 = new AVLNode<>(randneg521);var18.setHeight(0);var18.setBalanceFactor(0);
        AVLNode<Integer> var19 = null;
        var18.setLeft(var19);
        AVLNode<Integer> var20 = null;
        var18.setRight(var20);
        otherTree.setLeft(var18);
        AVLNode<Integer> var21 = new AVLNode<>(rand150);var21.setHeight(1);var21.setBalanceFactor(1);
        AVLNode<Integer> var22 = new AVLNode<>(randneg23);var22.setHeight(0);var22.setBalanceFactor(0);
        AVLNode<Integer> var23 = null;
        var22.setLeft(var23);
        AVLNode<Integer> var24 = null;
        var22.setRight(var24);
        var21.setLeft(var22);
        AVLNode<Integer> var25 = null;
        var21.setRight(var25);
        otherTree.setRight(var21);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        assertSame(rand150, tree.remove(rand150.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg82);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var26 = new AVLNode<>(randneg521);var26.setHeight(0);var26.setBalanceFactor(0);
        AVLNode<Integer> var27 = null;
        var26.setLeft(var27);
        AVLNode<Integer> var28 = null;
        var26.setRight(var28);
        otherTree.setLeft(var26);
        AVLNode<Integer> var29 = new AVLNode<>(randneg23);var29.setHeight(0);var29.setBalanceFactor(0);
        AVLNode<Integer> var30 = null;
        var29.setLeft(var30);
        AVLNode<Integer> var31 = null;
        var29.setRight(var31);
        otherTree.setRight(var29);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer randneg127 = new Integer(-127);
        tree.add(randneg127);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg82);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var32 = new AVLNode<>(randneg521);var32.setHeight(1);var32.setBalanceFactor(-1);
        AVLNode<Integer> var33 = null;
        var32.setLeft(var33);
        AVLNode<Integer> var34 = new AVLNode<>(randneg127);var34.setHeight(0);var34.setBalanceFactor(0);
        AVLNode<Integer> var35 = null;
        var34.setLeft(var35);
        AVLNode<Integer> var36 = null;
        var34.setRight(var36);
        var32.setRight(var34);
        otherTree.setLeft(var32);
        AVLNode<Integer> var37 = new AVLNode<>(randneg23);var37.setHeight(0);var37.setBalanceFactor(0);
        AVLNode<Integer> var38 = null;
        var37.setLeft(var38);
        AVLNode<Integer> var39 = null;
        var37.setRight(var39);
        otherTree.setRight(var37);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer randneg728 = new Integer(-728);
        tree.add(randneg728);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg82);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var40 = new AVLNode<>(randneg521);var40.setHeight(1);var40.setBalanceFactor(0);
        AVLNode<Integer> var41 = new AVLNode<>(randneg728);var41.setHeight(0);var41.setBalanceFactor(0);
        AVLNode<Integer> var42 = null;
        var41.setLeft(var42);
        AVLNode<Integer> var43 = null;
        var41.setRight(var43);
        var40.setLeft(var41);
        AVLNode<Integer> var44 = new AVLNode<>(randneg127);var44.setHeight(0);var44.setBalanceFactor(0);
        AVLNode<Integer> var45 = null;
        var44.setLeft(var45);
        AVLNode<Integer> var46 = null;
        var44.setRight(var46);
        var40.setRight(var44);
        otherTree.setLeft(var40);
        AVLNode<Integer> var47 = new AVLNode<>(randneg23);var47.setHeight(0);var47.setBalanceFactor(0);
        AVLNode<Integer> var48 = null;
        var47.setLeft(var48);
        AVLNode<Integer> var49 = null;
        var47.setRight(var49);
        otherTree.setRight(var47);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer randneg903 = new Integer(-903);
        tree.add(randneg903);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg521);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var50 = new AVLNode<>(randneg728);var50.setHeight(1);var50.setBalanceFactor(1);
        AVLNode<Integer> var51 = new AVLNode<>(randneg903);var51.setHeight(0);var51.setBalanceFactor(0);
        AVLNode<Integer> var52 = null;
        var51.setLeft(var52);
        AVLNode<Integer> var53 = null;
        var51.setRight(var53);
        var50.setLeft(var51);
        AVLNode<Integer> var54 = null;
        var50.setRight(var54);
        otherTree.setLeft(var50);
        AVLNode<Integer> var55 = new AVLNode<>(randneg82);var55.setHeight(1);var55.setBalanceFactor(0);
        AVLNode<Integer> var56 = new AVLNode<>(randneg127);var56.setHeight(0);var56.setBalanceFactor(0);
        AVLNode<Integer> var57 = null;
        var56.setLeft(var57);
        AVLNode<Integer> var58 = null;
        var56.setRight(var58);
        var55.setLeft(var56);
        AVLNode<Integer> var59 = new AVLNode<>(randneg23);var59.setHeight(0);var59.setBalanceFactor(0);
        AVLNode<Integer> var60 = null;
        var59.setLeft(var60);
        AVLNode<Integer> var61 = null;
        var59.setRight(var61);
        var55.setRight(var59);
        otherTree.setRight(var55);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer randneg777 = new Integer(-777);
        tree.add(randneg777);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg521);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var62 = new AVLNode<>(randneg777);var62.setHeight(1);var62.setBalanceFactor(0);
        AVLNode<Integer> var63 = new AVLNode<>(randneg903);var63.setHeight(0);var63.setBalanceFactor(0);
        AVLNode<Integer> var64 = null;
        var63.setLeft(var64);
        AVLNode<Integer> var65 = null;
        var63.setRight(var65);
        var62.setLeft(var63);
        AVLNode<Integer> var66 = new AVLNode<>(randneg728);var66.setHeight(0);var66.setBalanceFactor(0);
        AVLNode<Integer> var67 = null;
        var66.setLeft(var67);
        AVLNode<Integer> var68 = null;
        var66.setRight(var68);
        var62.setRight(var66);
        otherTree.setLeft(var62);
        AVLNode<Integer> var69 = new AVLNode<>(randneg82);var69.setHeight(1);var69.setBalanceFactor(0);
        AVLNode<Integer> var70 = new AVLNode<>(randneg127);var70.setHeight(0);var70.setBalanceFactor(0);
        AVLNode<Integer> var71 = null;
        var70.setLeft(var71);
        AVLNode<Integer> var72 = null;
        var70.setRight(var72);
        var69.setLeft(var70);
        AVLNode<Integer> var73 = new AVLNode<>(randneg23);var73.setHeight(0);var73.setBalanceFactor(0);
        AVLNode<Integer> var74 = null;
        var73.setLeft(var74);
        AVLNode<Integer> var75 = null;
        var73.setRight(var75);
        var69.setRight(var73);
        otherTree.setRight(var69);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer rand984 = new Integer(984);
        tree.add(rand984);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg521);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var76 = new AVLNode<>(randneg777);var76.setHeight(1);var76.setBalanceFactor(0);
        AVLNode<Integer> var77 = new AVLNode<>(randneg903);var77.setHeight(0);var77.setBalanceFactor(0);
        AVLNode<Integer> var78 = null;
        var77.setLeft(var78);
        AVLNode<Integer> var79 = null;
        var77.setRight(var79);
        var76.setLeft(var77);
        AVLNode<Integer> var80 = new AVLNode<>(randneg728);var80.setHeight(0);var80.setBalanceFactor(0);
        AVLNode<Integer> var81 = null;
        var80.setLeft(var81);
        AVLNode<Integer> var82 = null;
        var80.setRight(var82);
        var76.setRight(var80);
        otherTree.setLeft(var76);
        AVLNode<Integer> var83 = new AVLNode<>(randneg82);var83.setHeight(2);var83.setBalanceFactor(-1);
        AVLNode<Integer> var84 = new AVLNode<>(randneg127);var84.setHeight(0);var84.setBalanceFactor(0);
        AVLNode<Integer> var85 = null;
        var84.setLeft(var85);
        AVLNode<Integer> var86 = null;
        var84.setRight(var86);
        var83.setLeft(var84);
        AVLNode<Integer> var87 = new AVLNode<>(randneg23);var87.setHeight(1);var87.setBalanceFactor(-1);
        AVLNode<Integer> var88 = null;
        var87.setLeft(var88);
        AVLNode<Integer> var89 = new AVLNode<>(rand984);var89.setHeight(0);var89.setBalanceFactor(0);
        AVLNode<Integer> var90 = null;
        var89.setLeft(var90);
        AVLNode<Integer> var91 = null;
        var89.setRight(var91);
        var87.setRight(var89);
        var83.setRight(var87);
        otherTree.setRight(var83);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer rand134 = new Integer(134);
        tree.add(rand134);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg521);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var92 = new AVLNode<>(randneg777);var92.setHeight(1);var92.setBalanceFactor(0);
        AVLNode<Integer> var93 = new AVLNode<>(randneg903);var93.setHeight(0);var93.setBalanceFactor(0);
        AVLNode<Integer> var94 = null;
        var93.setLeft(var94);
        AVLNode<Integer> var95 = null;
        var93.setRight(var95);
        var92.setLeft(var93);
        AVLNode<Integer> var96 = new AVLNode<>(randneg728);var96.setHeight(0);var96.setBalanceFactor(0);
        AVLNode<Integer> var97 = null;
        var96.setLeft(var97);
        AVLNode<Integer> var98 = null;
        var96.setRight(var98);
        var92.setRight(var96);
        otherTree.setLeft(var92);
        AVLNode<Integer> var99 = new AVLNode<>(randneg82);var99.setHeight(2);var99.setBalanceFactor(-1);
        AVLNode<Integer> var100 = new AVLNode<>(randneg127);var100.setHeight(0);var100.setBalanceFactor(0);
        AVLNode<Integer> var101 = null;
        var100.setLeft(var101);
        AVLNode<Integer> var102 = null;
        var100.setRight(var102);
        var99.setLeft(var100);
        AVLNode<Integer> var103 = new AVLNode<>(rand134);var103.setHeight(1);var103.setBalanceFactor(0);
        AVLNode<Integer> var104 = new AVLNode<>(randneg23);var104.setHeight(0);var104.setBalanceFactor(0);
        AVLNode<Integer> var105 = null;
        var104.setLeft(var105);
        AVLNode<Integer> var106 = null;
        var104.setRight(var106);
        var103.setLeft(var104);
        AVLNode<Integer> var107 = new AVLNode<>(rand984);var107.setHeight(0);var107.setBalanceFactor(0);
        AVLNode<Integer> var108 = null;
        var107.setLeft(var108);
        AVLNode<Integer> var109 = null;
        var107.setRight(var109);
        var103.setRight(var107);
        var99.setRight(var103);
        otherTree.setRight(var99);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer rand269 = new Integer(269);
        tree.add(rand269);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg521);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var110 = new AVLNode<>(randneg777);var110.setHeight(1);var110.setBalanceFactor(0);
        AVLNode<Integer> var111 = new AVLNode<>(randneg903);var111.setHeight(0);var111.setBalanceFactor(0);
        AVLNode<Integer> var112 = null;
        var111.setLeft(var112);
        AVLNode<Integer> var113 = null;
        var111.setRight(var113);
        var110.setLeft(var111);
        AVLNode<Integer> var114 = new AVLNode<>(randneg728);var114.setHeight(0);var114.setBalanceFactor(0);
        AVLNode<Integer> var115 = null;
        var114.setLeft(var115);
        AVLNode<Integer> var116 = null;
        var114.setRight(var116);
        var110.setRight(var114);
        otherTree.setLeft(var110);
        AVLNode<Integer> var117 = new AVLNode<>(rand134);var117.setHeight(2);var117.setBalanceFactor(0);
        AVLNode<Integer> var118 = new AVLNode<>(randneg82);var118.setHeight(1);var118.setBalanceFactor(0);
        AVLNode<Integer> var119 = new AVLNode<>(randneg127);var119.setHeight(0);var119.setBalanceFactor(0);
        AVLNode<Integer> var120 = null;
        var119.setLeft(var120);
        AVLNode<Integer> var121 = null;
        var119.setRight(var121);
        var118.setLeft(var119);
        AVLNode<Integer> var122 = new AVLNode<>(randneg23);var122.setHeight(0);var122.setBalanceFactor(0);
        AVLNode<Integer> var123 = null;
        var122.setLeft(var123);
        AVLNode<Integer> var124 = null;
        var122.setRight(var124);
        var118.setRight(var122);
        var117.setLeft(var118);
        AVLNode<Integer> var125 = new AVLNode<>(rand984);var125.setHeight(1);var125.setBalanceFactor(1);
        AVLNode<Integer> var126 = new AVLNode<>(rand269);var126.setHeight(0);var126.setBalanceFactor(0);
        AVLNode<Integer> var127 = null;
        var126.setLeft(var127);
        AVLNode<Integer> var128 = null;
        var126.setRight(var128);
        var125.setLeft(var126);
        AVLNode<Integer> var129 = null;
        var125.setRight(var129);
        var117.setRight(var125);
        otherTree.setRight(var117);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer rand876 = new Integer(876);
        tree.add(rand876);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg521);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var130 = new AVLNode<>(randneg777);var130.setHeight(1);var130.setBalanceFactor(0);
        AVLNode<Integer> var131 = new AVLNode<>(randneg903);var131.setHeight(0);var131.setBalanceFactor(0);
        AVLNode<Integer> var132 = null;
        var131.setLeft(var132);
        AVLNode<Integer> var133 = null;
        var131.setRight(var133);
        var130.setLeft(var131);
        AVLNode<Integer> var134 = new AVLNode<>(randneg728);var134.setHeight(0);var134.setBalanceFactor(0);
        AVLNode<Integer> var135 = null;
        var134.setLeft(var135);
        AVLNode<Integer> var136 = null;
        var134.setRight(var136);
        var130.setRight(var134);
        otherTree.setLeft(var130);
        AVLNode<Integer> var137 = new AVLNode<>(rand134);var137.setHeight(2);var137.setBalanceFactor(0);
        AVLNode<Integer> var138 = new AVLNode<>(randneg82);var138.setHeight(1);var138.setBalanceFactor(0);
        AVLNode<Integer> var139 = new AVLNode<>(randneg127);var139.setHeight(0);var139.setBalanceFactor(0);
        AVLNode<Integer> var140 = null;
        var139.setLeft(var140);
        AVLNode<Integer> var141 = null;
        var139.setRight(var141);
        var138.setLeft(var139);
        AVLNode<Integer> var142 = new AVLNode<>(randneg23);var142.setHeight(0);var142.setBalanceFactor(0);
        AVLNode<Integer> var143 = null;
        var142.setLeft(var143);
        AVLNode<Integer> var144 = null;
        var142.setRight(var144);
        var138.setRight(var142);
        var137.setLeft(var138);
        AVLNode<Integer> var145 = new AVLNode<>(rand876);var145.setHeight(1);var145.setBalanceFactor(0);
        AVLNode<Integer> var146 = new AVLNode<>(rand269);var146.setHeight(0);var146.setBalanceFactor(0);
        AVLNode<Integer> var147 = null;
        var146.setLeft(var147);
        AVLNode<Integer> var148 = null;
        var146.setRight(var148);
        var145.setLeft(var146);
        AVLNode<Integer> var149 = new AVLNode<>(rand984);var149.setHeight(0);var149.setBalanceFactor(0);
        AVLNode<Integer> var150 = null;
        var149.setLeft(var150);
        AVLNode<Integer> var151 = null;
        var149.setRight(var151);
        var145.setRight(var149);
        var137.setRight(var145);
        otherTree.setRight(var137);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #11: ==========
    @Test(timeout = TIMEOUT)
    public void test11() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer rand990 = new Integer(990);
        tree.add(rand990);

        // Validating last operation...
        otherTree = new AVLNode<>(rand990);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer rand508 = new Integer(508);
        tree.add(rand508);

        // Validating last operation...
        otherTree = new AVLNode<>(rand990);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var2 = new AVLNode<>(rand508);var2.setHeight(0);var2.setBalanceFactor(0);
        AVLNode<Integer> var3 = null;
        var2.setLeft(var3);
        AVLNode<Integer> var4 = null;
        var2.setRight(var4);
        otherTree.setLeft(var2);
        AVLNode<Integer> var5 = null;
        otherTree.setRight(var5);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer randneg621 = new Integer(-621);
        tree.add(randneg621);

        // Validating last operation...
        otherTree = new AVLNode<>(rand508);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(randneg621);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(rand990);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer randneg61 = new Integer(-61);
        tree.add(randneg61);

        // Validating last operation...
        otherTree = new AVLNode<>(rand508);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var12 = new AVLNode<>(randneg621);var12.setHeight(1);var12.setBalanceFactor(-1);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = new AVLNode<>(randneg61);var14.setHeight(0);var14.setBalanceFactor(0);
        AVLNode<Integer> var15 = null;
        var14.setLeft(var15);
        AVLNode<Integer> var16 = null;
        var14.setRight(var16);
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var17 = new AVLNode<>(rand990);var17.setHeight(0);var17.setBalanceFactor(0);
        AVLNode<Integer> var18 = null;
        var17.setLeft(var18);
        AVLNode<Integer> var19 = null;
        var17.setRight(var19);
        otherTree.setRight(var17);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        assertSame(randneg61, tree.remove(randneg61.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand508);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var20 = new AVLNode<>(randneg621);var20.setHeight(0);var20.setBalanceFactor(0);
        AVLNode<Integer> var21 = null;
        var20.setLeft(var21);
        AVLNode<Integer> var22 = null;
        var20.setRight(var22);
        otherTree.setLeft(var20);
        AVLNode<Integer> var23 = new AVLNode<>(rand990);var23.setHeight(0);var23.setBalanceFactor(0);
        AVLNode<Integer> var24 = null;
        var23.setLeft(var24);
        AVLNode<Integer> var25 = null;
        var23.setRight(var25);
        otherTree.setRight(var23);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        assertSame(rand508, tree.remove(rand508.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg621);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var26 = null;
        otherTree.setLeft(var26);
        AVLNode<Integer> var27 = new AVLNode<>(rand990);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        otherTree.setRight(var27);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer randneg849 = new Integer(-849);
        tree.add(randneg849);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg621);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var30 = new AVLNode<>(randneg849);var30.setHeight(0);var30.setBalanceFactor(0);
        AVLNode<Integer> var31 = null;
        var30.setLeft(var31);
        AVLNode<Integer> var32 = null;
        var30.setRight(var32);
        otherTree.setLeft(var30);
        AVLNode<Integer> var33 = new AVLNode<>(rand990);var33.setHeight(0);var33.setBalanceFactor(0);
        AVLNode<Integer> var34 = null;
        var33.setLeft(var34);
        AVLNode<Integer> var35 = null;
        var33.setRight(var35);
        otherTree.setRight(var33);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer rand669 = new Integer(669);
        tree.add(rand669);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg621);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var36 = new AVLNode<>(randneg849);var36.setHeight(0);var36.setBalanceFactor(0);
        AVLNode<Integer> var37 = null;
        var36.setLeft(var37);
        AVLNode<Integer> var38 = null;
        var36.setRight(var38);
        otherTree.setLeft(var36);
        AVLNode<Integer> var39 = new AVLNode<>(rand990);var39.setHeight(1);var39.setBalanceFactor(1);
        AVLNode<Integer> var40 = new AVLNode<>(rand669);var40.setHeight(0);var40.setBalanceFactor(0);
        AVLNode<Integer> var41 = null;
        var40.setLeft(var41);
        AVLNode<Integer> var42 = null;
        var40.setRight(var42);
        var39.setLeft(var40);
        AVLNode<Integer> var43 = null;
        var39.setRight(var43);
        otherTree.setRight(var39);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer rand755 = new Integer(755);
        tree.add(rand755);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg621);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var44 = new AVLNode<>(randneg849);var44.setHeight(0);var44.setBalanceFactor(0);
        AVLNode<Integer> var45 = null;
        var44.setLeft(var45);
        AVLNode<Integer> var46 = null;
        var44.setRight(var46);
        otherTree.setLeft(var44);
        AVLNode<Integer> var47 = new AVLNode<>(rand755);var47.setHeight(1);var47.setBalanceFactor(0);
        AVLNode<Integer> var48 = new AVLNode<>(rand669);var48.setHeight(0);var48.setBalanceFactor(0);
        AVLNode<Integer> var49 = null;
        var48.setLeft(var49);
        AVLNode<Integer> var50 = null;
        var48.setRight(var50);
        var47.setLeft(var48);
        AVLNode<Integer> var51 = new AVLNode<>(rand990);var51.setHeight(0);var51.setBalanceFactor(0);
        AVLNode<Integer> var52 = null;
        var51.setLeft(var52);
        AVLNode<Integer> var53 = null;
        var51.setRight(var53);
        var47.setRight(var51);
        otherTree.setRight(var47);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        assertSame(rand990, tree.remove(rand990.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg621);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var54 = new AVLNode<>(randneg849);var54.setHeight(0);var54.setBalanceFactor(0);
        AVLNode<Integer> var55 = null;
        var54.setLeft(var55);
        AVLNode<Integer> var56 = null;
        var54.setRight(var56);
        otherTree.setLeft(var54);
        AVLNode<Integer> var57 = new AVLNode<>(rand755);var57.setHeight(1);var57.setBalanceFactor(1);
        AVLNode<Integer> var58 = new AVLNode<>(rand669);var58.setHeight(0);var58.setBalanceFactor(0);
        AVLNode<Integer> var59 = null;
        var58.setLeft(var59);
        AVLNode<Integer> var60 = null;
        var58.setRight(var60);
        var57.setLeft(var58);
        AVLNode<Integer> var61 = null;
        var57.setRight(var61);
        otherTree.setRight(var57);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer rand668 = new Integer(668);
        tree.add(rand668);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg621);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var62 = new AVLNode<>(randneg849);var62.setHeight(0);var62.setBalanceFactor(0);
        AVLNode<Integer> var63 = null;
        var62.setLeft(var63);
        AVLNode<Integer> var64 = null;
        var62.setRight(var64);
        otherTree.setLeft(var62);
        AVLNode<Integer> var65 = new AVLNode<>(rand669);var65.setHeight(1);var65.setBalanceFactor(0);
        AVLNode<Integer> var66 = new AVLNode<>(rand668);var66.setHeight(0);var66.setBalanceFactor(0);
        AVLNode<Integer> var67 = null;
        var66.setLeft(var67);
        AVLNode<Integer> var68 = null;
        var66.setRight(var68);
        var65.setLeft(var66);
        AVLNode<Integer> var69 = new AVLNode<>(rand755);var69.setHeight(0);var69.setBalanceFactor(0);
        AVLNode<Integer> var70 = null;
        var69.setLeft(var70);
        AVLNode<Integer> var71 = null;
        var69.setRight(var71);
        var65.setRight(var69);
        otherTree.setRight(var65);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer randneg946 = new Integer(-946);
        tree.add(randneg946);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg621);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var72 = new AVLNode<>(randneg849);var72.setHeight(1);var72.setBalanceFactor(1);
        AVLNode<Integer> var73 = new AVLNode<>(randneg946);var73.setHeight(0);var73.setBalanceFactor(0);
        AVLNode<Integer> var74 = null;
        var73.setLeft(var74);
        AVLNode<Integer> var75 = null;
        var73.setRight(var75);
        var72.setLeft(var73);
        AVLNode<Integer> var76 = null;
        var72.setRight(var76);
        otherTree.setLeft(var72);
        AVLNode<Integer> var77 = new AVLNode<>(rand669);var77.setHeight(1);var77.setBalanceFactor(0);
        AVLNode<Integer> var78 = new AVLNode<>(rand668);var78.setHeight(0);var78.setBalanceFactor(0);
        AVLNode<Integer> var79 = null;
        var78.setLeft(var79);
        AVLNode<Integer> var80 = null;
        var78.setRight(var80);
        var77.setLeft(var78);
        AVLNode<Integer> var81 = new AVLNode<>(rand755);var81.setHeight(0);var81.setBalanceFactor(0);
        AVLNode<Integer> var82 = null;
        var81.setLeft(var82);
        AVLNode<Integer> var83 = null;
        var81.setRight(var83);
        var77.setRight(var81);
        otherTree.setRight(var77);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer rand311 = new Integer(311);
        tree.add(rand311);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg621);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var84 = new AVLNode<>(randneg849);var84.setHeight(1);var84.setBalanceFactor(1);
        AVLNode<Integer> var85 = new AVLNode<>(randneg946);var85.setHeight(0);var85.setBalanceFactor(0);
        AVLNode<Integer> var86 = null;
        var85.setLeft(var86);
        AVLNode<Integer> var87 = null;
        var85.setRight(var87);
        var84.setLeft(var85);
        AVLNode<Integer> var88 = null;
        var84.setRight(var88);
        otherTree.setLeft(var84);
        AVLNode<Integer> var89 = new AVLNode<>(rand669);var89.setHeight(2);var89.setBalanceFactor(1);
        AVLNode<Integer> var90 = new AVLNode<>(rand668);var90.setHeight(1);var90.setBalanceFactor(1);
        AVLNode<Integer> var91 = new AVLNode<>(rand311);var91.setHeight(0);var91.setBalanceFactor(0);
        AVLNode<Integer> var92 = null;
        var91.setLeft(var92);
        AVLNode<Integer> var93 = null;
        var91.setRight(var93);
        var90.setLeft(var91);
        AVLNode<Integer> var94 = null;
        var90.setRight(var94);
        var89.setLeft(var90);
        AVLNode<Integer> var95 = new AVLNode<>(rand755);var95.setHeight(0);var95.setBalanceFactor(0);
        AVLNode<Integer> var96 = null;
        var95.setLeft(var96);
        AVLNode<Integer> var97 = null;
        var95.setRight(var97);
        var89.setRight(var95);
        otherTree.setRight(var89);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer randneg142 = new Integer(-142);
        tree.add(randneg142);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg621);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var98 = new AVLNode<>(randneg849);var98.setHeight(1);var98.setBalanceFactor(1);
        AVLNode<Integer> var99 = new AVLNode<>(randneg946);var99.setHeight(0);var99.setBalanceFactor(0);
        AVLNode<Integer> var100 = null;
        var99.setLeft(var100);
        AVLNode<Integer> var101 = null;
        var99.setRight(var101);
        var98.setLeft(var99);
        AVLNode<Integer> var102 = null;
        var98.setRight(var102);
        otherTree.setLeft(var98);
        AVLNode<Integer> var103 = new AVLNode<>(rand669);var103.setHeight(2);var103.setBalanceFactor(1);
        AVLNode<Integer> var104 = new AVLNode<>(rand311);var104.setHeight(1);var104.setBalanceFactor(0);
        AVLNode<Integer> var105 = new AVLNode<>(randneg142);var105.setHeight(0);var105.setBalanceFactor(0);
        AVLNode<Integer> var106 = null;
        var105.setLeft(var106);
        AVLNode<Integer> var107 = null;
        var105.setRight(var107);
        var104.setLeft(var105);
        AVLNode<Integer> var108 = new AVLNode<>(rand668);var108.setHeight(0);var108.setBalanceFactor(0);
        AVLNode<Integer> var109 = null;
        var108.setLeft(var109);
        AVLNode<Integer> var110 = null;
        var108.setRight(var110);
        var104.setRight(var108);
        var103.setLeft(var104);
        AVLNode<Integer> var111 = new AVLNode<>(rand755);var111.setHeight(0);var111.setBalanceFactor(0);
        AVLNode<Integer> var112 = null;
        var111.setLeft(var112);
        AVLNode<Integer> var113 = null;
        var111.setRight(var113);
        var103.setRight(var111);
        otherTree.setRight(var103);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer randneg601 = new Integer(-601);
        tree.add(randneg601);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg621);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var114 = new AVLNode<>(randneg849);var114.setHeight(1);var114.setBalanceFactor(1);
        AVLNode<Integer> var115 = new AVLNode<>(randneg946);var115.setHeight(0);var115.setBalanceFactor(0);
        AVLNode<Integer> var116 = null;
        var115.setLeft(var116);
        AVLNode<Integer> var117 = null;
        var115.setRight(var117);
        var114.setLeft(var115);
        AVLNode<Integer> var118 = null;
        var114.setRight(var118);
        otherTree.setLeft(var114);
        AVLNode<Integer> var119 = new AVLNode<>(rand311);var119.setHeight(2);var119.setBalanceFactor(0);
        AVLNode<Integer> var120 = new AVLNode<>(randneg142);var120.setHeight(1);var120.setBalanceFactor(1);
        AVLNode<Integer> var121 = new AVLNode<>(randneg601);var121.setHeight(0);var121.setBalanceFactor(0);
        AVLNode<Integer> var122 = null;
        var121.setLeft(var122);
        AVLNode<Integer> var123 = null;
        var121.setRight(var123);
        var120.setLeft(var121);
        AVLNode<Integer> var124 = null;
        var120.setRight(var124);
        var119.setLeft(var120);
        AVLNode<Integer> var125 = new AVLNode<>(rand669);var125.setHeight(1);var125.setBalanceFactor(0);
        AVLNode<Integer> var126 = new AVLNode<>(rand668);var126.setHeight(0);var126.setBalanceFactor(0);
        AVLNode<Integer> var127 = null;
        var126.setLeft(var127);
        AVLNode<Integer> var128 = null;
        var126.setRight(var128);
        var125.setLeft(var126);
        AVLNode<Integer> var129 = new AVLNode<>(rand755);var129.setHeight(0);var129.setBalanceFactor(0);
        AVLNode<Integer> var130 = null;
        var129.setLeft(var130);
        AVLNode<Integer> var131 = null;
        var129.setRight(var131);
        var125.setRight(var129);
        var119.setRight(var125);
        otherTree.setRight(var119);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #12: ==========
    @Test(timeout = TIMEOUT)
    public void test12() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg449 = new Integer(-449);
        tree.add(randneg449);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg449);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer randneg159 = new Integer(-159);
        tree.add(randneg159);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg449);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = new AVLNode<>(randneg159);var3.setHeight(0);var3.setBalanceFactor(0);
        AVLNode<Integer> var4 = null;
        var3.setLeft(var4);
        AVLNode<Integer> var5 = null;
        var3.setRight(var5);
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer rand846 = new Integer(846);
        tree.add(rand846);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg159);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(randneg449);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(rand846);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer rand58 = new Integer(58);
        tree.add(rand58);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg159);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var12 = new AVLNode<>(randneg449);var12.setHeight(0);var12.setBalanceFactor(0);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = null;
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var15 = new AVLNode<>(rand846);var15.setHeight(1);var15.setBalanceFactor(1);
        AVLNode<Integer> var16 = new AVLNode<>(rand58);var16.setHeight(0);var16.setBalanceFactor(0);
        AVLNode<Integer> var17 = null;
        var16.setLeft(var17);
        AVLNode<Integer> var18 = null;
        var16.setRight(var18);
        var15.setLeft(var16);
        AVLNode<Integer> var19 = null;
        var15.setRight(var19);
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer randneg819 = new Integer(-819);
        tree.add(randneg819);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg159);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var20 = new AVLNode<>(randneg449);var20.setHeight(1);var20.setBalanceFactor(1);
        AVLNode<Integer> var21 = new AVLNode<>(randneg819);var21.setHeight(0);var21.setBalanceFactor(0);
        AVLNode<Integer> var22 = null;
        var21.setLeft(var22);
        AVLNode<Integer> var23 = null;
        var21.setRight(var23);
        var20.setLeft(var21);
        AVLNode<Integer> var24 = null;
        var20.setRight(var24);
        otherTree.setLeft(var20);
        AVLNode<Integer> var25 = new AVLNode<>(rand846);var25.setHeight(1);var25.setBalanceFactor(1);
        AVLNode<Integer> var26 = new AVLNode<>(rand58);var26.setHeight(0);var26.setBalanceFactor(0);
        AVLNode<Integer> var27 = null;
        var26.setLeft(var27);
        AVLNode<Integer> var28 = null;
        var26.setRight(var28);
        var25.setLeft(var26);
        AVLNode<Integer> var29 = null;
        var25.setRight(var29);
        otherTree.setRight(var25);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer randneg257 = new Integer(-257);
        tree.add(randneg257);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg159);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var30 = new AVLNode<>(randneg449);var30.setHeight(1);var30.setBalanceFactor(0);
        AVLNode<Integer> var31 = new AVLNode<>(randneg819);var31.setHeight(0);var31.setBalanceFactor(0);
        AVLNode<Integer> var32 = null;
        var31.setLeft(var32);
        AVLNode<Integer> var33 = null;
        var31.setRight(var33);
        var30.setLeft(var31);
        AVLNode<Integer> var34 = new AVLNode<>(randneg257);var34.setHeight(0);var34.setBalanceFactor(0);
        AVLNode<Integer> var35 = null;
        var34.setLeft(var35);
        AVLNode<Integer> var36 = null;
        var34.setRight(var36);
        var30.setRight(var34);
        otherTree.setLeft(var30);
        AVLNode<Integer> var37 = new AVLNode<>(rand846);var37.setHeight(1);var37.setBalanceFactor(1);
        AVLNode<Integer> var38 = new AVLNode<>(rand58);var38.setHeight(0);var38.setBalanceFactor(0);
        AVLNode<Integer> var39 = null;
        var38.setLeft(var39);
        AVLNode<Integer> var40 = null;
        var38.setRight(var40);
        var37.setLeft(var38);
        AVLNode<Integer> var41 = null;
        var37.setRight(var41);
        otherTree.setRight(var37);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer rand656 = new Integer(656);
        tree.add(rand656);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg159);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var42 = new AVLNode<>(randneg449);var42.setHeight(1);var42.setBalanceFactor(0);
        AVLNode<Integer> var43 = new AVLNode<>(randneg819);var43.setHeight(0);var43.setBalanceFactor(0);
        AVLNode<Integer> var44 = null;
        var43.setLeft(var44);
        AVLNode<Integer> var45 = null;
        var43.setRight(var45);
        var42.setLeft(var43);
        AVLNode<Integer> var46 = new AVLNode<>(randneg257);var46.setHeight(0);var46.setBalanceFactor(0);
        AVLNode<Integer> var47 = null;
        var46.setLeft(var47);
        AVLNode<Integer> var48 = null;
        var46.setRight(var48);
        var42.setRight(var46);
        otherTree.setLeft(var42);
        AVLNode<Integer> var49 = new AVLNode<>(rand656);var49.setHeight(1);var49.setBalanceFactor(0);
        AVLNode<Integer> var50 = new AVLNode<>(rand58);var50.setHeight(0);var50.setBalanceFactor(0);
        AVLNode<Integer> var51 = null;
        var50.setLeft(var51);
        AVLNode<Integer> var52 = null;
        var50.setRight(var52);
        var49.setLeft(var50);
        AVLNode<Integer> var53 = new AVLNode<>(rand846);var53.setHeight(0);var53.setBalanceFactor(0);
        AVLNode<Integer> var54 = null;
        var53.setLeft(var54);
        AVLNode<Integer> var55 = null;
        var53.setRight(var55);
        var49.setRight(var53);
        otherTree.setRight(var49);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        assertSame(rand58, tree.remove(rand58.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg159);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var56 = new AVLNode<>(randneg449);var56.setHeight(1);var56.setBalanceFactor(0);
        AVLNode<Integer> var57 = new AVLNode<>(randneg819);var57.setHeight(0);var57.setBalanceFactor(0);
        AVLNode<Integer> var58 = null;
        var57.setLeft(var58);
        AVLNode<Integer> var59 = null;
        var57.setRight(var59);
        var56.setLeft(var57);
        AVLNode<Integer> var60 = new AVLNode<>(randneg257);var60.setHeight(0);var60.setBalanceFactor(0);
        AVLNode<Integer> var61 = null;
        var60.setLeft(var61);
        AVLNode<Integer> var62 = null;
        var60.setRight(var62);
        var56.setRight(var60);
        otherTree.setLeft(var56);
        AVLNode<Integer> var63 = new AVLNode<>(rand656);var63.setHeight(1);var63.setBalanceFactor(-1);
        AVLNode<Integer> var64 = null;
        var63.setLeft(var64);
        AVLNode<Integer> var65 = new AVLNode<>(rand846);var65.setHeight(0);var65.setBalanceFactor(0);
        AVLNode<Integer> var66 = null;
        var65.setLeft(var66);
        AVLNode<Integer> var67 = null;
        var65.setRight(var67);
        var63.setRight(var65);
        otherTree.setRight(var63);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer rand872 = new Integer(872);
        tree.add(rand872);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg159);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var68 = new AVLNode<>(randneg449);var68.setHeight(1);var68.setBalanceFactor(0);
        AVLNode<Integer> var69 = new AVLNode<>(randneg819);var69.setHeight(0);var69.setBalanceFactor(0);
        AVLNode<Integer> var70 = null;
        var69.setLeft(var70);
        AVLNode<Integer> var71 = null;
        var69.setRight(var71);
        var68.setLeft(var69);
        AVLNode<Integer> var72 = new AVLNode<>(randneg257);var72.setHeight(0);var72.setBalanceFactor(0);
        AVLNode<Integer> var73 = null;
        var72.setLeft(var73);
        AVLNode<Integer> var74 = null;
        var72.setRight(var74);
        var68.setRight(var72);
        otherTree.setLeft(var68);
        AVLNode<Integer> var75 = new AVLNode<>(rand846);var75.setHeight(1);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = new AVLNode<>(rand656);var76.setHeight(0);var76.setBalanceFactor(0);
        AVLNode<Integer> var77 = null;
        var76.setLeft(var77);
        AVLNode<Integer> var78 = null;
        var76.setRight(var78);
        var75.setLeft(var76);
        AVLNode<Integer> var79 = new AVLNode<>(rand872);var79.setHeight(0);var79.setBalanceFactor(0);
        AVLNode<Integer> var80 = null;
        var79.setLeft(var80);
        AVLNode<Integer> var81 = null;
        var79.setRight(var81);
        var75.setRight(var79);
        otherTree.setRight(var75);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer rand644 = new Integer(644);
        tree.add(rand644);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg159);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var82 = new AVLNode<>(randneg449);var82.setHeight(1);var82.setBalanceFactor(0);
        AVLNode<Integer> var83 = new AVLNode<>(randneg819);var83.setHeight(0);var83.setBalanceFactor(0);
        AVLNode<Integer> var84 = null;
        var83.setLeft(var84);
        AVLNode<Integer> var85 = null;
        var83.setRight(var85);
        var82.setLeft(var83);
        AVLNode<Integer> var86 = new AVLNode<>(randneg257);var86.setHeight(0);var86.setBalanceFactor(0);
        AVLNode<Integer> var87 = null;
        var86.setLeft(var87);
        AVLNode<Integer> var88 = null;
        var86.setRight(var88);
        var82.setRight(var86);
        otherTree.setLeft(var82);
        AVLNode<Integer> var89 = new AVLNode<>(rand846);var89.setHeight(2);var89.setBalanceFactor(1);
        AVLNode<Integer> var90 = new AVLNode<>(rand656);var90.setHeight(1);var90.setBalanceFactor(1);
        AVLNode<Integer> var91 = new AVLNode<>(rand644);var91.setHeight(0);var91.setBalanceFactor(0);
        AVLNode<Integer> var92 = null;
        var91.setLeft(var92);
        AVLNode<Integer> var93 = null;
        var91.setRight(var93);
        var90.setLeft(var91);
        AVLNode<Integer> var94 = null;
        var90.setRight(var94);
        var89.setLeft(var90);
        AVLNode<Integer> var95 = new AVLNode<>(rand872);var95.setHeight(0);var95.setBalanceFactor(0);
        AVLNode<Integer> var96 = null;
        var95.setLeft(var96);
        AVLNode<Integer> var97 = null;
        var95.setRight(var97);
        var89.setRight(var95);
        otherTree.setRight(var89);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        assertSame(rand644, tree.remove(rand644.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg159);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var98 = new AVLNode<>(randneg449);var98.setHeight(1);var98.setBalanceFactor(0);
        AVLNode<Integer> var99 = new AVLNode<>(randneg819);var99.setHeight(0);var99.setBalanceFactor(0);
        AVLNode<Integer> var100 = null;
        var99.setLeft(var100);
        AVLNode<Integer> var101 = null;
        var99.setRight(var101);
        var98.setLeft(var99);
        AVLNode<Integer> var102 = new AVLNode<>(randneg257);var102.setHeight(0);var102.setBalanceFactor(0);
        AVLNode<Integer> var103 = null;
        var102.setLeft(var103);
        AVLNode<Integer> var104 = null;
        var102.setRight(var104);
        var98.setRight(var102);
        otherTree.setLeft(var98);
        AVLNode<Integer> var105 = new AVLNode<>(rand846);var105.setHeight(1);var105.setBalanceFactor(0);
        AVLNode<Integer> var106 = new AVLNode<>(rand656);var106.setHeight(0);var106.setBalanceFactor(0);
        AVLNode<Integer> var107 = null;
        var106.setLeft(var107);
        AVLNode<Integer> var108 = null;
        var106.setRight(var108);
        var105.setLeft(var106);
        AVLNode<Integer> var109 = new AVLNode<>(rand872);var109.setHeight(0);var109.setBalanceFactor(0);
        AVLNode<Integer> var110 = null;
        var109.setLeft(var110);
        AVLNode<Integer> var111 = null;
        var109.setRight(var111);
        var105.setRight(var109);
        otherTree.setRight(var105);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer rand371 = new Integer(371);
        tree.add(rand371);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg159);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var112 = new AVLNode<>(randneg449);var112.setHeight(1);var112.setBalanceFactor(0);
        AVLNode<Integer> var113 = new AVLNode<>(randneg819);var113.setHeight(0);var113.setBalanceFactor(0);
        AVLNode<Integer> var114 = null;
        var113.setLeft(var114);
        AVLNode<Integer> var115 = null;
        var113.setRight(var115);
        var112.setLeft(var113);
        AVLNode<Integer> var116 = new AVLNode<>(randneg257);var116.setHeight(0);var116.setBalanceFactor(0);
        AVLNode<Integer> var117 = null;
        var116.setLeft(var117);
        AVLNode<Integer> var118 = null;
        var116.setRight(var118);
        var112.setRight(var116);
        otherTree.setLeft(var112);
        AVLNode<Integer> var119 = new AVLNode<>(rand846);var119.setHeight(2);var119.setBalanceFactor(1);
        AVLNode<Integer> var120 = new AVLNode<>(rand656);var120.setHeight(1);var120.setBalanceFactor(1);
        AVLNode<Integer> var121 = new AVLNode<>(rand371);var121.setHeight(0);var121.setBalanceFactor(0);
        AVLNode<Integer> var122 = null;
        var121.setLeft(var122);
        AVLNode<Integer> var123 = null;
        var121.setRight(var123);
        var120.setLeft(var121);
        AVLNode<Integer> var124 = null;
        var120.setRight(var124);
        var119.setLeft(var120);
        AVLNode<Integer> var125 = new AVLNode<>(rand872);var125.setHeight(0);var125.setBalanceFactor(0);
        AVLNode<Integer> var126 = null;
        var125.setLeft(var126);
        AVLNode<Integer> var127 = null;
        var125.setRight(var127);
        var119.setRight(var125);
        otherTree.setRight(var119);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer randneg401 = new Integer(-401);
        tree.add(randneg401);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg159);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var128 = new AVLNode<>(randneg449);var128.setHeight(2);var128.setBalanceFactor(-1);
        AVLNode<Integer> var129 = new AVLNode<>(randneg819);var129.setHeight(0);var129.setBalanceFactor(0);
        AVLNode<Integer> var130 = null;
        var129.setLeft(var130);
        AVLNode<Integer> var131 = null;
        var129.setRight(var131);
        var128.setLeft(var129);
        AVLNode<Integer> var132 = new AVLNode<>(randneg257);var132.setHeight(1);var132.setBalanceFactor(1);
        AVLNode<Integer> var133 = new AVLNode<>(randneg401);var133.setHeight(0);var133.setBalanceFactor(0);
        AVLNode<Integer> var134 = null;
        var133.setLeft(var134);
        AVLNode<Integer> var135 = null;
        var133.setRight(var135);
        var132.setLeft(var133);
        AVLNode<Integer> var136 = null;
        var132.setRight(var136);
        var128.setRight(var132);
        otherTree.setLeft(var128);
        AVLNode<Integer> var137 = new AVLNode<>(rand846);var137.setHeight(2);var137.setBalanceFactor(1);
        AVLNode<Integer> var138 = new AVLNode<>(rand656);var138.setHeight(1);var138.setBalanceFactor(1);
        AVLNode<Integer> var139 = new AVLNode<>(rand371);var139.setHeight(0);var139.setBalanceFactor(0);
        AVLNode<Integer> var140 = null;
        var139.setLeft(var140);
        AVLNode<Integer> var141 = null;
        var139.setRight(var141);
        var138.setLeft(var139);
        AVLNode<Integer> var142 = null;
        var138.setRight(var142);
        var137.setLeft(var138);
        AVLNode<Integer> var143 = new AVLNode<>(rand872);var143.setHeight(0);var143.setBalanceFactor(0);
        AVLNode<Integer> var144 = null;
        var143.setLeft(var144);
        AVLNode<Integer> var145 = null;
        var143.setRight(var145);
        var137.setRight(var143);
        otherTree.setRight(var137);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer randneg192 = new Integer(-192);
        tree.add(randneg192);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg159);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var146 = new AVLNode<>(randneg449);var146.setHeight(2);var146.setBalanceFactor(-1);
        AVLNode<Integer> var147 = new AVLNode<>(randneg819);var147.setHeight(0);var147.setBalanceFactor(0);
        AVLNode<Integer> var148 = null;
        var147.setLeft(var148);
        AVLNode<Integer> var149 = null;
        var147.setRight(var149);
        var146.setLeft(var147);
        AVLNode<Integer> var150 = new AVLNode<>(randneg257);var150.setHeight(1);var150.setBalanceFactor(0);
        AVLNode<Integer> var151 = new AVLNode<>(randneg401);var151.setHeight(0);var151.setBalanceFactor(0);
        AVLNode<Integer> var152 = null;
        var151.setLeft(var152);
        AVLNode<Integer> var153 = null;
        var151.setRight(var153);
        var150.setLeft(var151);
        AVLNode<Integer> var154 = new AVLNode<>(randneg192);var154.setHeight(0);var154.setBalanceFactor(0);
        AVLNode<Integer> var155 = null;
        var154.setLeft(var155);
        AVLNode<Integer> var156 = null;
        var154.setRight(var156);
        var150.setRight(var154);
        var146.setRight(var150);
        otherTree.setLeft(var146);
        AVLNode<Integer> var157 = new AVLNode<>(rand846);var157.setHeight(2);var157.setBalanceFactor(1);
        AVLNode<Integer> var158 = new AVLNode<>(rand656);var158.setHeight(1);var158.setBalanceFactor(1);
        AVLNode<Integer> var159 = new AVLNode<>(rand371);var159.setHeight(0);var159.setBalanceFactor(0);
        AVLNode<Integer> var160 = null;
        var159.setLeft(var160);
        AVLNode<Integer> var161 = null;
        var159.setRight(var161);
        var158.setLeft(var159);
        AVLNode<Integer> var162 = null;
        var158.setRight(var162);
        var157.setLeft(var158);
        AVLNode<Integer> var163 = new AVLNode<>(rand872);var163.setHeight(0);var163.setBalanceFactor(0);
        AVLNode<Integer> var164 = null;
        var163.setLeft(var164);
        AVLNode<Integer> var165 = null;
        var163.setRight(var165);
        var157.setRight(var163);
        otherTree.setRight(var157);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer randneg222 = new Integer(-222);
        tree.add(randneg222);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg159);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var166 = new AVLNode<>(randneg257);var166.setHeight(2);var166.setBalanceFactor(0);
        AVLNode<Integer> var167 = new AVLNode<>(randneg449);var167.setHeight(1);var167.setBalanceFactor(0);
        AVLNode<Integer> var168 = new AVLNode<>(randneg819);var168.setHeight(0);var168.setBalanceFactor(0);
        AVLNode<Integer> var169 = null;
        var168.setLeft(var169);
        AVLNode<Integer> var170 = null;
        var168.setRight(var170);
        var167.setLeft(var168);
        AVLNode<Integer> var171 = new AVLNode<>(randneg401);var171.setHeight(0);var171.setBalanceFactor(0);
        AVLNode<Integer> var172 = null;
        var171.setLeft(var172);
        AVLNode<Integer> var173 = null;
        var171.setRight(var173);
        var167.setRight(var171);
        var166.setLeft(var167);
        AVLNode<Integer> var174 = new AVLNode<>(randneg192);var174.setHeight(1);var174.setBalanceFactor(1);
        AVLNode<Integer> var175 = new AVLNode<>(randneg222);var175.setHeight(0);var175.setBalanceFactor(0);
        AVLNode<Integer> var176 = null;
        var175.setLeft(var176);
        AVLNode<Integer> var177 = null;
        var175.setRight(var177);
        var174.setLeft(var175);
        AVLNode<Integer> var178 = null;
        var174.setRight(var178);
        var166.setRight(var174);
        otherTree.setLeft(var166);
        AVLNode<Integer> var179 = new AVLNode<>(rand846);var179.setHeight(2);var179.setBalanceFactor(1);
        AVLNode<Integer> var180 = new AVLNode<>(rand656);var180.setHeight(1);var180.setBalanceFactor(1);
        AVLNode<Integer> var181 = new AVLNode<>(rand371);var181.setHeight(0);var181.setBalanceFactor(0);
        AVLNode<Integer> var182 = null;
        var181.setLeft(var182);
        AVLNode<Integer> var183 = null;
        var181.setRight(var183);
        var180.setLeft(var181);
        AVLNode<Integer> var184 = null;
        var180.setRight(var184);
        var179.setLeft(var180);
        AVLNode<Integer> var185 = new AVLNode<>(rand872);var185.setHeight(0);var185.setBalanceFactor(0);
        AVLNode<Integer> var186 = null;
        var185.setLeft(var186);
        AVLNode<Integer> var187 = null;
        var185.setRight(var187);
        var179.setRight(var185);
        otherTree.setRight(var179);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #13: ==========
    @Test(timeout = TIMEOUT)
    public void test13() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer rand895 = new Integer(895);
        tree.add(rand895);

        // Validating last operation...
        otherTree = new AVLNode<>(rand895);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer randneg673 = new Integer(-673);
        tree.add(randneg673);

        // Validating last operation...
        otherTree = new AVLNode<>(rand895);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var2 = new AVLNode<>(randneg673);var2.setHeight(0);var2.setBalanceFactor(0);
        AVLNode<Integer> var3 = null;
        var2.setLeft(var3);
        AVLNode<Integer> var4 = null;
        var2.setRight(var4);
        otherTree.setLeft(var2);
        AVLNode<Integer> var5 = null;
        otherTree.setRight(var5);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        assertSame(randneg673, tree.remove(randneg673.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand895);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = null;
        otherTree.setLeft(var6);
        AVLNode<Integer> var7 = null;
        otherTree.setRight(var7);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer rand390 = new Integer(390);
        tree.add(rand390);

        // Validating last operation...
        otherTree = new AVLNode<>(rand895);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var8 = new AVLNode<>(rand390);var8.setHeight(0);var8.setBalanceFactor(0);
        AVLNode<Integer> var9 = null;
        var8.setLeft(var9);
        AVLNode<Integer> var10 = null;
        var8.setRight(var10);
        otherTree.setLeft(var8);
        AVLNode<Integer> var11 = null;
        otherTree.setRight(var11);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        assertSame(rand895, tree.remove(rand895.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand390);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var12 = null;
        otherTree.setLeft(var12);
        AVLNode<Integer> var13 = null;
        otherTree.setRight(var13);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        assertSame(rand390, tree.remove(rand390.intValue()));

        // Validating last operation...
        otherTree = null;
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer randneg29 = new Integer(-29);
        tree.add(randneg29);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg29);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var14 = null;
        otherTree.setLeft(var14);
        AVLNode<Integer> var15 = null;
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer randneg713 = new Integer(-713);
        tree.add(randneg713);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg29);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var16 = new AVLNode<>(randneg713);var16.setHeight(0);var16.setBalanceFactor(0);
        AVLNode<Integer> var17 = null;
        var16.setLeft(var17);
        AVLNode<Integer> var18 = null;
        var16.setRight(var18);
        otherTree.setLeft(var16);
        AVLNode<Integer> var19 = null;
        otherTree.setRight(var19);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        assertSame(randneg713, tree.remove(randneg713.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg29);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var20 = null;
        otherTree.setLeft(var20);
        AVLNode<Integer> var21 = null;
        otherTree.setRight(var21);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer randneg352 = new Integer(-352);
        tree.add(randneg352);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg29);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var22 = new AVLNode<>(randneg352);var22.setHeight(0);var22.setBalanceFactor(0);
        AVLNode<Integer> var23 = null;
        var22.setLeft(var23);
        AVLNode<Integer> var24 = null;
        var22.setRight(var24);
        otherTree.setLeft(var22);
        AVLNode<Integer> var25 = null;
        otherTree.setRight(var25);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer randneg798 = new Integer(-798);
        tree.add(randneg798);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg352);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var26 = new AVLNode<>(randneg798);var26.setHeight(0);var26.setBalanceFactor(0);
        AVLNode<Integer> var27 = null;
        var26.setLeft(var27);
        AVLNode<Integer> var28 = null;
        var26.setRight(var28);
        otherTree.setLeft(var26);
        AVLNode<Integer> var29 = new AVLNode<>(randneg29);var29.setHeight(0);var29.setBalanceFactor(0);
        AVLNode<Integer> var30 = null;
        var29.setLeft(var30);
        AVLNode<Integer> var31 = null;
        var29.setRight(var31);
        otherTree.setRight(var29);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        assertSame(randneg29, tree.remove(randneg29.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg352);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var32 = new AVLNode<>(randneg798);var32.setHeight(0);var32.setBalanceFactor(0);
        AVLNode<Integer> var33 = null;
        var32.setLeft(var33);
        AVLNode<Integer> var34 = null;
        var32.setRight(var34);
        otherTree.setLeft(var32);
        AVLNode<Integer> var35 = null;
        otherTree.setRight(var35);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        assertSame(randneg352, tree.remove(randneg352.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg798);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var36 = null;
        otherTree.setLeft(var36);
        AVLNode<Integer> var37 = null;
        otherTree.setRight(var37);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer randneg794 = new Integer(-794);
        tree.add(randneg794);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg798);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var38 = null;
        otherTree.setLeft(var38);
        AVLNode<Integer> var39 = new AVLNode<>(randneg794);var39.setHeight(0);var39.setBalanceFactor(0);
        AVLNode<Integer> var40 = null;
        var39.setLeft(var40);
        AVLNode<Integer> var41 = null;
        var39.setRight(var41);
        otherTree.setRight(var39);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer randneg634 = new Integer(-634);
        tree.add(randneg634);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg794);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var42 = new AVLNode<>(randneg798);var42.setHeight(0);var42.setBalanceFactor(0);
        AVLNode<Integer> var43 = null;
        var42.setLeft(var43);
        AVLNode<Integer> var44 = null;
        var42.setRight(var44);
        otherTree.setLeft(var42);
        AVLNode<Integer> var45 = new AVLNode<>(randneg634);var45.setHeight(0);var45.setBalanceFactor(0);
        AVLNode<Integer> var46 = null;
        var45.setLeft(var46);
        AVLNode<Integer> var47 = null;
        var45.setRight(var47);
        otherTree.setRight(var45);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #14: ==========
    @Test(timeout = TIMEOUT)
    public void test14() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer rand546 = new Integer(546);
        tree.add(rand546);

        // Validating last operation...
        otherTree = new AVLNode<>(rand546);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer randneg565 = new Integer(-565);
        tree.add(randneg565);

        // Validating last operation...
        otherTree = new AVLNode<>(rand546);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var2 = new AVLNode<>(randneg565);var2.setHeight(0);var2.setBalanceFactor(0);
        AVLNode<Integer> var3 = null;
        var2.setLeft(var3);
        AVLNode<Integer> var4 = null;
        var2.setRight(var4);
        otherTree.setLeft(var2);
        AVLNode<Integer> var5 = null;
        otherTree.setRight(var5);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer randneg685 = new Integer(-685);
        tree.add(randneg685);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg565);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(randneg685);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(rand546);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer randneg17 = new Integer(-17);
        tree.add(randneg17);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg565);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var12 = new AVLNode<>(randneg685);var12.setHeight(0);var12.setBalanceFactor(0);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = null;
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var15 = new AVLNode<>(rand546);var15.setHeight(1);var15.setBalanceFactor(1);
        AVLNode<Integer> var16 = new AVLNode<>(randneg17);var16.setHeight(0);var16.setBalanceFactor(0);
        AVLNode<Integer> var17 = null;
        var16.setLeft(var17);
        AVLNode<Integer> var18 = null;
        var16.setRight(var18);
        var15.setLeft(var16);
        AVLNode<Integer> var19 = null;
        var15.setRight(var19);
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer randneg366 = new Integer(-366);
        tree.add(randneg366);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg565);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var20 = new AVLNode<>(randneg685);var20.setHeight(0);var20.setBalanceFactor(0);
        AVLNode<Integer> var21 = null;
        var20.setLeft(var21);
        AVLNode<Integer> var22 = null;
        var20.setRight(var22);
        otherTree.setLeft(var20);
        AVLNode<Integer> var23 = new AVLNode<>(randneg17);var23.setHeight(1);var23.setBalanceFactor(0);
        AVLNode<Integer> var24 = new AVLNode<>(randneg366);var24.setHeight(0);var24.setBalanceFactor(0);
        AVLNode<Integer> var25 = null;
        var24.setLeft(var25);
        AVLNode<Integer> var26 = null;
        var24.setRight(var26);
        var23.setLeft(var24);
        AVLNode<Integer> var27 = new AVLNode<>(rand546);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        var23.setRight(var27);
        otherTree.setRight(var23);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        assertSame(randneg565, tree.remove(randneg565.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg17);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var30 = new AVLNode<>(randneg685);var30.setHeight(1);var30.setBalanceFactor(-1);
        AVLNode<Integer> var31 = null;
        var30.setLeft(var31);
        AVLNode<Integer> var32 = new AVLNode<>(randneg366);var32.setHeight(0);var32.setBalanceFactor(0);
        AVLNode<Integer> var33 = null;
        var32.setLeft(var33);
        AVLNode<Integer> var34 = null;
        var32.setRight(var34);
        var30.setRight(var32);
        otherTree.setLeft(var30);
        AVLNode<Integer> var35 = new AVLNode<>(rand546);var35.setHeight(0);var35.setBalanceFactor(0);
        AVLNode<Integer> var36 = null;
        var35.setLeft(var36);
        AVLNode<Integer> var37 = null;
        var35.setRight(var37);
        otherTree.setRight(var35);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer randneg723 = new Integer(-723);
        tree.add(randneg723);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg17);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var38 = new AVLNode<>(randneg685);var38.setHeight(1);var38.setBalanceFactor(0);
        AVLNode<Integer> var39 = new AVLNode<>(randneg723);var39.setHeight(0);var39.setBalanceFactor(0);
        AVLNode<Integer> var40 = null;
        var39.setLeft(var40);
        AVLNode<Integer> var41 = null;
        var39.setRight(var41);
        var38.setLeft(var39);
        AVLNode<Integer> var42 = new AVLNode<>(randneg366);var42.setHeight(0);var42.setBalanceFactor(0);
        AVLNode<Integer> var43 = null;
        var42.setLeft(var43);
        AVLNode<Integer> var44 = null;
        var42.setRight(var44);
        var38.setRight(var42);
        otherTree.setLeft(var38);
        AVLNode<Integer> var45 = new AVLNode<>(rand546);var45.setHeight(0);var45.setBalanceFactor(0);
        AVLNode<Integer> var46 = null;
        var45.setLeft(var46);
        AVLNode<Integer> var47 = null;
        var45.setRight(var47);
        otherTree.setRight(var45);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer randneg202 = new Integer(-202);
        tree.add(randneg202);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg366);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var48 = new AVLNode<>(randneg685);var48.setHeight(1);var48.setBalanceFactor(1);
        AVLNode<Integer> var49 = new AVLNode<>(randneg723);var49.setHeight(0);var49.setBalanceFactor(0);
        AVLNode<Integer> var50 = null;
        var49.setLeft(var50);
        AVLNode<Integer> var51 = null;
        var49.setRight(var51);
        var48.setLeft(var49);
        AVLNode<Integer> var52 = null;
        var48.setRight(var52);
        otherTree.setLeft(var48);
        AVLNode<Integer> var53 = new AVLNode<>(randneg17);var53.setHeight(1);var53.setBalanceFactor(0);
        AVLNode<Integer> var54 = new AVLNode<>(randneg202);var54.setHeight(0);var54.setBalanceFactor(0);
        AVLNode<Integer> var55 = null;
        var54.setLeft(var55);
        AVLNode<Integer> var56 = null;
        var54.setRight(var56);
        var53.setLeft(var54);
        AVLNode<Integer> var57 = new AVLNode<>(rand546);var57.setHeight(0);var57.setBalanceFactor(0);
        AVLNode<Integer> var58 = null;
        var57.setLeft(var58);
        AVLNode<Integer> var59 = null;
        var57.setRight(var59);
        var53.setRight(var57);
        otherTree.setRight(var53);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        assertSame(rand546, tree.remove(rand546.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg366);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var60 = new AVLNode<>(randneg685);var60.setHeight(1);var60.setBalanceFactor(1);
        AVLNode<Integer> var61 = new AVLNode<>(randneg723);var61.setHeight(0);var61.setBalanceFactor(0);
        AVLNode<Integer> var62 = null;
        var61.setLeft(var62);
        AVLNode<Integer> var63 = null;
        var61.setRight(var63);
        var60.setLeft(var61);
        AVLNode<Integer> var64 = null;
        var60.setRight(var64);
        otherTree.setLeft(var60);
        AVLNode<Integer> var65 = new AVLNode<>(randneg17);var65.setHeight(1);var65.setBalanceFactor(1);
        AVLNode<Integer> var66 = new AVLNode<>(randneg202);var66.setHeight(0);var66.setBalanceFactor(0);
        AVLNode<Integer> var67 = null;
        var66.setLeft(var67);
        AVLNode<Integer> var68 = null;
        var66.setRight(var68);
        var65.setLeft(var66);
        AVLNode<Integer> var69 = null;
        var65.setRight(var69);
        otherTree.setRight(var65);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        assertSame(randneg17, tree.remove(randneg17.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg366);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var70 = new AVLNode<>(randneg685);var70.setHeight(1);var70.setBalanceFactor(1);
        AVLNode<Integer> var71 = new AVLNode<>(randneg723);var71.setHeight(0);var71.setBalanceFactor(0);
        AVLNode<Integer> var72 = null;
        var71.setLeft(var72);
        AVLNode<Integer> var73 = null;
        var71.setRight(var73);
        var70.setLeft(var71);
        AVLNode<Integer> var74 = null;
        var70.setRight(var74);
        otherTree.setLeft(var70);
        AVLNode<Integer> var75 = new AVLNode<>(randneg202);var75.setHeight(0);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = null;
        var75.setLeft(var76);
        AVLNode<Integer> var77 = null;
        var75.setRight(var77);
        otherTree.setRight(var75);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer rand176 = new Integer(176);
        tree.add(rand176);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg366);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var78 = new AVLNode<>(randneg685);var78.setHeight(1);var78.setBalanceFactor(1);
        AVLNode<Integer> var79 = new AVLNode<>(randneg723);var79.setHeight(0);var79.setBalanceFactor(0);
        AVLNode<Integer> var80 = null;
        var79.setLeft(var80);
        AVLNode<Integer> var81 = null;
        var79.setRight(var81);
        var78.setLeft(var79);
        AVLNode<Integer> var82 = null;
        var78.setRight(var82);
        otherTree.setLeft(var78);
        AVLNode<Integer> var83 = new AVLNode<>(randneg202);var83.setHeight(1);var83.setBalanceFactor(-1);
        AVLNode<Integer> var84 = null;
        var83.setLeft(var84);
        AVLNode<Integer> var85 = new AVLNode<>(rand176);var85.setHeight(0);var85.setBalanceFactor(0);
        AVLNode<Integer> var86 = null;
        var85.setLeft(var86);
        AVLNode<Integer> var87 = null;
        var85.setRight(var87);
        var83.setRight(var85);
        otherTree.setRight(var83);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer rand760 = new Integer(760);
        tree.add(rand760);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg366);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var88 = new AVLNode<>(randneg685);var88.setHeight(1);var88.setBalanceFactor(1);
        AVLNode<Integer> var89 = new AVLNode<>(randneg723);var89.setHeight(0);var89.setBalanceFactor(0);
        AVLNode<Integer> var90 = null;
        var89.setLeft(var90);
        AVLNode<Integer> var91 = null;
        var89.setRight(var91);
        var88.setLeft(var89);
        AVLNode<Integer> var92 = null;
        var88.setRight(var92);
        otherTree.setLeft(var88);
        AVLNode<Integer> var93 = new AVLNode<>(rand176);var93.setHeight(1);var93.setBalanceFactor(0);
        AVLNode<Integer> var94 = new AVLNode<>(randneg202);var94.setHeight(0);var94.setBalanceFactor(0);
        AVLNode<Integer> var95 = null;
        var94.setLeft(var95);
        AVLNode<Integer> var96 = null;
        var94.setRight(var96);
        var93.setLeft(var94);
        AVLNode<Integer> var97 = new AVLNode<>(rand760);var97.setHeight(0);var97.setBalanceFactor(0);
        AVLNode<Integer> var98 = null;
        var97.setLeft(var98);
        AVLNode<Integer> var99 = null;
        var97.setRight(var99);
        var93.setRight(var97);
        otherTree.setRight(var93);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer randneg809 = new Integer(-809);
        tree.add(randneg809);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg366);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var100 = new AVLNode<>(randneg723);var100.setHeight(1);var100.setBalanceFactor(0);
        AVLNode<Integer> var101 = new AVLNode<>(randneg809);var101.setHeight(0);var101.setBalanceFactor(0);
        AVLNode<Integer> var102 = null;
        var101.setLeft(var102);
        AVLNode<Integer> var103 = null;
        var101.setRight(var103);
        var100.setLeft(var101);
        AVLNode<Integer> var104 = new AVLNode<>(randneg685);var104.setHeight(0);var104.setBalanceFactor(0);
        AVLNode<Integer> var105 = null;
        var104.setLeft(var105);
        AVLNode<Integer> var106 = null;
        var104.setRight(var106);
        var100.setRight(var104);
        otherTree.setLeft(var100);
        AVLNode<Integer> var107 = new AVLNode<>(rand176);var107.setHeight(1);var107.setBalanceFactor(0);
        AVLNode<Integer> var108 = new AVLNode<>(randneg202);var108.setHeight(0);var108.setBalanceFactor(0);
        AVLNode<Integer> var109 = null;
        var108.setLeft(var109);
        AVLNode<Integer> var110 = null;
        var108.setRight(var110);
        var107.setLeft(var108);
        AVLNode<Integer> var111 = new AVLNode<>(rand760);var111.setHeight(0);var111.setBalanceFactor(0);
        AVLNode<Integer> var112 = null;
        var111.setLeft(var112);
        AVLNode<Integer> var113 = null;
        var111.setRight(var113);
        var107.setRight(var111);
        otherTree.setRight(var107);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        assertSame(rand176, tree.remove(rand176.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg366);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var114 = new AVLNode<>(randneg723);var114.setHeight(1);var114.setBalanceFactor(0);
        AVLNode<Integer> var115 = new AVLNode<>(randneg809);var115.setHeight(0);var115.setBalanceFactor(0);
        AVLNode<Integer> var116 = null;
        var115.setLeft(var116);
        AVLNode<Integer> var117 = null;
        var115.setRight(var117);
        var114.setLeft(var115);
        AVLNode<Integer> var118 = new AVLNode<>(randneg685);var118.setHeight(0);var118.setBalanceFactor(0);
        AVLNode<Integer> var119 = null;
        var118.setLeft(var119);
        AVLNode<Integer> var120 = null;
        var118.setRight(var120);
        var114.setRight(var118);
        otherTree.setLeft(var114);
        AVLNode<Integer> var121 = new AVLNode<>(randneg202);var121.setHeight(1);var121.setBalanceFactor(-1);
        AVLNode<Integer> var122 = null;
        var121.setLeft(var122);
        AVLNode<Integer> var123 = new AVLNode<>(rand760);var123.setHeight(0);var123.setBalanceFactor(0);
        AVLNode<Integer> var124 = null;
        var123.setLeft(var124);
        AVLNode<Integer> var125 = null;
        var123.setRight(var125);
        var121.setRight(var123);
        otherTree.setRight(var121);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer rand633 = new Integer(633);
        tree.add(rand633);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg366);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var126 = new AVLNode<>(randneg723);var126.setHeight(1);var126.setBalanceFactor(0);
        AVLNode<Integer> var127 = new AVLNode<>(randneg809);var127.setHeight(0);var127.setBalanceFactor(0);
        AVLNode<Integer> var128 = null;
        var127.setLeft(var128);
        AVLNode<Integer> var129 = null;
        var127.setRight(var129);
        var126.setLeft(var127);
        AVLNode<Integer> var130 = new AVLNode<>(randneg685);var130.setHeight(0);var130.setBalanceFactor(0);
        AVLNode<Integer> var131 = null;
        var130.setLeft(var131);
        AVLNode<Integer> var132 = null;
        var130.setRight(var132);
        var126.setRight(var130);
        otherTree.setLeft(var126);
        AVLNode<Integer> var133 = new AVLNode<>(rand633);var133.setHeight(1);var133.setBalanceFactor(0);
        AVLNode<Integer> var134 = new AVLNode<>(randneg202);var134.setHeight(0);var134.setBalanceFactor(0);
        AVLNode<Integer> var135 = null;
        var134.setLeft(var135);
        AVLNode<Integer> var136 = null;
        var134.setRight(var136);
        var133.setLeft(var134);
        AVLNode<Integer> var137 = new AVLNode<>(rand760);var137.setHeight(0);var137.setBalanceFactor(0);
        AVLNode<Integer> var138 = null;
        var137.setLeft(var138);
        AVLNode<Integer> var139 = null;
        var137.setRight(var139);
        var133.setRight(var137);
        otherTree.setRight(var133);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #15: ==========
    @Test(timeout = TIMEOUT)
    public void test15() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg633 = new Integer(-633);
        tree.add(randneg633);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg633);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        assertSame(randneg633, tree.remove(randneg633.intValue()));

        // Validating last operation...
        otherTree = null;
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer rand203 = new Integer(203);
        tree.add(rand203);

        // Validating last operation...
        otherTree = new AVLNode<>(rand203);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = null;
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer rand143 = new Integer(143);
        tree.add(rand143);

        // Validating last operation...
        otherTree = new AVLNode<>(rand203);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var4 = new AVLNode<>(rand143);var4.setHeight(0);var4.setBalanceFactor(0);
        AVLNode<Integer> var5 = null;
        var4.setLeft(var5);
        AVLNode<Integer> var6 = null;
        var4.setRight(var6);
        otherTree.setLeft(var4);
        AVLNode<Integer> var7 = null;
        otherTree.setRight(var7);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        assertSame(rand203, tree.remove(rand203.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand143);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var8 = null;
        otherTree.setLeft(var8);
        AVLNode<Integer> var9 = null;
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        assertSame(rand143, tree.remove(rand143.intValue()));

        // Validating last operation...
        otherTree = null;
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer rand935 = new Integer(935);
        tree.add(rand935);

        // Validating last operation...
        otherTree = new AVLNode<>(rand935);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        otherTree.setLeft(var10);
        AVLNode<Integer> var11 = null;
        otherTree.setRight(var11);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer randneg30 = new Integer(-30);
        tree.add(randneg30);

        // Validating last operation...
        otherTree = new AVLNode<>(rand935);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var12 = new AVLNode<>(randneg30);var12.setHeight(0);var12.setBalanceFactor(0);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = null;
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var15 = null;
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer randneg106 = new Integer(-106);
        tree.add(randneg106);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg30);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var16 = new AVLNode<>(randneg106);var16.setHeight(0);var16.setBalanceFactor(0);
        AVLNode<Integer> var17 = null;
        var16.setLeft(var17);
        AVLNode<Integer> var18 = null;
        var16.setRight(var18);
        otherTree.setLeft(var16);
        AVLNode<Integer> var19 = new AVLNode<>(rand935);var19.setHeight(0);var19.setBalanceFactor(0);
        AVLNode<Integer> var20 = null;
        var19.setLeft(var20);
        AVLNode<Integer> var21 = null;
        var19.setRight(var21);
        otherTree.setRight(var19);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer randneg343 = new Integer(-343);
        tree.add(randneg343);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg30);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var22 = new AVLNode<>(randneg106);var22.setHeight(1);var22.setBalanceFactor(1);
        AVLNode<Integer> var23 = new AVLNode<>(randneg343);var23.setHeight(0);var23.setBalanceFactor(0);
        AVLNode<Integer> var24 = null;
        var23.setLeft(var24);
        AVLNode<Integer> var25 = null;
        var23.setRight(var25);
        var22.setLeft(var23);
        AVLNode<Integer> var26 = null;
        var22.setRight(var26);
        otherTree.setLeft(var22);
        AVLNode<Integer> var27 = new AVLNode<>(rand935);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        otherTree.setRight(var27);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        assertSame(randneg30, tree.remove(randneg30.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg106);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var30 = new AVLNode<>(randneg343);var30.setHeight(0);var30.setBalanceFactor(0);
        AVLNode<Integer> var31 = null;
        var30.setLeft(var31);
        AVLNode<Integer> var32 = null;
        var30.setRight(var32);
        otherTree.setLeft(var30);
        AVLNode<Integer> var33 = new AVLNode<>(rand935);var33.setHeight(0);var33.setBalanceFactor(0);
        AVLNode<Integer> var34 = null;
        var33.setLeft(var34);
        AVLNode<Integer> var35 = null;
        var33.setRight(var35);
        otherTree.setRight(var33);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        assertSame(rand935, tree.remove(rand935.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg106);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var36 = new AVLNode<>(randneg343);var36.setHeight(0);var36.setBalanceFactor(0);
        AVLNode<Integer> var37 = null;
        var36.setLeft(var37);
        AVLNode<Integer> var38 = null;
        var36.setRight(var38);
        otherTree.setLeft(var36);
        AVLNode<Integer> var39 = null;
        otherTree.setRight(var39);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer randneg47 = new Integer(-47);
        tree.add(randneg47);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg106);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var40 = new AVLNode<>(randneg343);var40.setHeight(0);var40.setBalanceFactor(0);
        AVLNode<Integer> var41 = null;
        var40.setLeft(var41);
        AVLNode<Integer> var42 = null;
        var40.setRight(var42);
        otherTree.setLeft(var40);
        AVLNode<Integer> var43 = new AVLNode<>(randneg47);var43.setHeight(0);var43.setBalanceFactor(0);
        AVLNode<Integer> var44 = null;
        var43.setLeft(var44);
        AVLNode<Integer> var45 = null;
        var43.setRight(var45);
        otherTree.setRight(var43);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer randneg498 = new Integer(-498);
        tree.add(randneg498);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg106);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var46 = new AVLNode<>(randneg343);var46.setHeight(1);var46.setBalanceFactor(1);
        AVLNode<Integer> var47 = new AVLNode<>(randneg498);var47.setHeight(0);var47.setBalanceFactor(0);
        AVLNode<Integer> var48 = null;
        var47.setLeft(var48);
        AVLNode<Integer> var49 = null;
        var47.setRight(var49);
        var46.setLeft(var47);
        AVLNode<Integer> var50 = null;
        var46.setRight(var50);
        otherTree.setLeft(var46);
        AVLNode<Integer> var51 = new AVLNode<>(randneg47);var51.setHeight(0);var51.setBalanceFactor(0);
        AVLNode<Integer> var52 = null;
        var51.setLeft(var52);
        AVLNode<Integer> var53 = null;
        var51.setRight(var53);
        otherTree.setRight(var51);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer rand117 = new Integer(117);
        tree.add(rand117);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg106);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var54 = new AVLNode<>(randneg343);var54.setHeight(1);var54.setBalanceFactor(1);
        AVLNode<Integer> var55 = new AVLNode<>(randneg498);var55.setHeight(0);var55.setBalanceFactor(0);
        AVLNode<Integer> var56 = null;
        var55.setLeft(var56);
        AVLNode<Integer> var57 = null;
        var55.setRight(var57);
        var54.setLeft(var55);
        AVLNode<Integer> var58 = null;
        var54.setRight(var58);
        otherTree.setLeft(var54);
        AVLNode<Integer> var59 = new AVLNode<>(randneg47);var59.setHeight(1);var59.setBalanceFactor(-1);
        AVLNode<Integer> var60 = null;
        var59.setLeft(var60);
        AVLNode<Integer> var61 = new AVLNode<>(rand117);var61.setHeight(0);var61.setBalanceFactor(0);
        AVLNode<Integer> var62 = null;
        var61.setLeft(var62);
        AVLNode<Integer> var63 = null;
        var61.setRight(var63);
        var59.setRight(var61);
        otherTree.setRight(var59);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #16: ==========
    @Test(timeout = TIMEOUT)
    public void test16() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer rand835 = new Integer(835);
        tree.add(rand835);

        // Validating last operation...
        otherTree = new AVLNode<>(rand835);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer rand343 = new Integer(343);
        tree.add(rand343);

        // Validating last operation...
        otherTree = new AVLNode<>(rand835);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var2 = new AVLNode<>(rand343);var2.setHeight(0);var2.setBalanceFactor(0);
        AVLNode<Integer> var3 = null;
        var2.setLeft(var3);
        AVLNode<Integer> var4 = null;
        var2.setRight(var4);
        otherTree.setLeft(var2);
        AVLNode<Integer> var5 = null;
        otherTree.setRight(var5);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer randneg175 = new Integer(-175);
        tree.add(randneg175);

        // Validating last operation...
        otherTree = new AVLNode<>(rand343);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(randneg175);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(rand835);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        assertSame(rand343, tree.remove(rand343.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg175);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var12 = null;
        otherTree.setLeft(var12);
        AVLNode<Integer> var13 = new AVLNode<>(rand835);var13.setHeight(0);var13.setBalanceFactor(0);
        AVLNode<Integer> var14 = null;
        var13.setLeft(var14);
        AVLNode<Integer> var15 = null;
        var13.setRight(var15);
        otherTree.setRight(var13);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer rand955 = new Integer(955);
        tree.add(rand955);

        // Validating last operation...
        otherTree = new AVLNode<>(rand835);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var16 = new AVLNode<>(randneg175);var16.setHeight(0);var16.setBalanceFactor(0);
        AVLNode<Integer> var17 = null;
        var16.setLeft(var17);
        AVLNode<Integer> var18 = null;
        var16.setRight(var18);
        otherTree.setLeft(var16);
        AVLNode<Integer> var19 = new AVLNode<>(rand955);var19.setHeight(0);var19.setBalanceFactor(0);
        AVLNode<Integer> var20 = null;
        var19.setLeft(var20);
        AVLNode<Integer> var21 = null;
        var19.setRight(var21);
        otherTree.setRight(var19);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer rand237 = new Integer(237);
        tree.add(rand237);

        // Validating last operation...
        otherTree = new AVLNode<>(rand835);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var22 = new AVLNode<>(randneg175);var22.setHeight(1);var22.setBalanceFactor(-1);
        AVLNode<Integer> var23 = null;
        var22.setLeft(var23);
        AVLNode<Integer> var24 = new AVLNode<>(rand237);var24.setHeight(0);var24.setBalanceFactor(0);
        AVLNode<Integer> var25 = null;
        var24.setLeft(var25);
        AVLNode<Integer> var26 = null;
        var24.setRight(var26);
        var22.setRight(var24);
        otherTree.setLeft(var22);
        AVLNode<Integer> var27 = new AVLNode<>(rand955);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        otherTree.setRight(var27);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer randneg461 = new Integer(-461);
        tree.add(randneg461);

        // Validating last operation...
        otherTree = new AVLNode<>(rand835);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var30 = new AVLNode<>(randneg175);var30.setHeight(1);var30.setBalanceFactor(0);
        AVLNode<Integer> var31 = new AVLNode<>(randneg461);var31.setHeight(0);var31.setBalanceFactor(0);
        AVLNode<Integer> var32 = null;
        var31.setLeft(var32);
        AVLNode<Integer> var33 = null;
        var31.setRight(var33);
        var30.setLeft(var31);
        AVLNode<Integer> var34 = new AVLNode<>(rand237);var34.setHeight(0);var34.setBalanceFactor(0);
        AVLNode<Integer> var35 = null;
        var34.setLeft(var35);
        AVLNode<Integer> var36 = null;
        var34.setRight(var36);
        var30.setRight(var34);
        otherTree.setLeft(var30);
        AVLNode<Integer> var37 = new AVLNode<>(rand955);var37.setHeight(0);var37.setBalanceFactor(0);
        AVLNode<Integer> var38 = null;
        var37.setLeft(var38);
        AVLNode<Integer> var39 = null;
        var37.setRight(var39);
        otherTree.setRight(var37);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer rand180 = new Integer(180);
        tree.add(rand180);

        // Validating last operation...
        otherTree = new AVLNode<>(rand237);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var40 = new AVLNode<>(randneg175);var40.setHeight(1);var40.setBalanceFactor(0);
        AVLNode<Integer> var41 = new AVLNode<>(randneg461);var41.setHeight(0);var41.setBalanceFactor(0);
        AVLNode<Integer> var42 = null;
        var41.setLeft(var42);
        AVLNode<Integer> var43 = null;
        var41.setRight(var43);
        var40.setLeft(var41);
        AVLNode<Integer> var44 = new AVLNode<>(rand180);var44.setHeight(0);var44.setBalanceFactor(0);
        AVLNode<Integer> var45 = null;
        var44.setLeft(var45);
        AVLNode<Integer> var46 = null;
        var44.setRight(var46);
        var40.setRight(var44);
        otherTree.setLeft(var40);
        AVLNode<Integer> var47 = new AVLNode<>(rand835);var47.setHeight(1);var47.setBalanceFactor(-1);
        AVLNode<Integer> var48 = null;
        var47.setLeft(var48);
        AVLNode<Integer> var49 = new AVLNode<>(rand955);var49.setHeight(0);var49.setBalanceFactor(0);
        AVLNode<Integer> var50 = null;
        var49.setLeft(var50);
        AVLNode<Integer> var51 = null;
        var49.setRight(var51);
        var47.setRight(var49);
        otherTree.setRight(var47);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer rand978 = new Integer(978);
        tree.add(rand978);

        // Validating last operation...
        otherTree = new AVLNode<>(rand237);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var52 = new AVLNode<>(randneg175);var52.setHeight(1);var52.setBalanceFactor(0);
        AVLNode<Integer> var53 = new AVLNode<>(randneg461);var53.setHeight(0);var53.setBalanceFactor(0);
        AVLNode<Integer> var54 = null;
        var53.setLeft(var54);
        AVLNode<Integer> var55 = null;
        var53.setRight(var55);
        var52.setLeft(var53);
        AVLNode<Integer> var56 = new AVLNode<>(rand180);var56.setHeight(0);var56.setBalanceFactor(0);
        AVLNode<Integer> var57 = null;
        var56.setLeft(var57);
        AVLNode<Integer> var58 = null;
        var56.setRight(var58);
        var52.setRight(var56);
        otherTree.setLeft(var52);
        AVLNode<Integer> var59 = new AVLNode<>(rand955);var59.setHeight(1);var59.setBalanceFactor(0);
        AVLNode<Integer> var60 = new AVLNode<>(rand835);var60.setHeight(0);var60.setBalanceFactor(0);
        AVLNode<Integer> var61 = null;
        var60.setLeft(var61);
        AVLNode<Integer> var62 = null;
        var60.setRight(var62);
        var59.setLeft(var60);
        AVLNode<Integer> var63 = new AVLNode<>(rand978);var63.setHeight(0);var63.setBalanceFactor(0);
        AVLNode<Integer> var64 = null;
        var63.setLeft(var64);
        AVLNode<Integer> var65 = null;
        var63.setRight(var65);
        var59.setRight(var63);
        otherTree.setRight(var59);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer rand297 = new Integer(297);
        tree.add(rand297);

        // Validating last operation...
        otherTree = new AVLNode<>(rand237);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var66 = new AVLNode<>(randneg175);var66.setHeight(1);var66.setBalanceFactor(0);
        AVLNode<Integer> var67 = new AVLNode<>(randneg461);var67.setHeight(0);var67.setBalanceFactor(0);
        AVLNode<Integer> var68 = null;
        var67.setLeft(var68);
        AVLNode<Integer> var69 = null;
        var67.setRight(var69);
        var66.setLeft(var67);
        AVLNode<Integer> var70 = new AVLNode<>(rand180);var70.setHeight(0);var70.setBalanceFactor(0);
        AVLNode<Integer> var71 = null;
        var70.setLeft(var71);
        AVLNode<Integer> var72 = null;
        var70.setRight(var72);
        var66.setRight(var70);
        otherTree.setLeft(var66);
        AVLNode<Integer> var73 = new AVLNode<>(rand955);var73.setHeight(2);var73.setBalanceFactor(1);
        AVLNode<Integer> var74 = new AVLNode<>(rand835);var74.setHeight(1);var74.setBalanceFactor(1);
        AVLNode<Integer> var75 = new AVLNode<>(rand297);var75.setHeight(0);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = null;
        var75.setLeft(var76);
        AVLNode<Integer> var77 = null;
        var75.setRight(var77);
        var74.setLeft(var75);
        AVLNode<Integer> var78 = null;
        var74.setRight(var78);
        var73.setLeft(var74);
        AVLNode<Integer> var79 = new AVLNode<>(rand978);var79.setHeight(0);var79.setBalanceFactor(0);
        AVLNode<Integer> var80 = null;
        var79.setLeft(var80);
        AVLNode<Integer> var81 = null;
        var79.setRight(var81);
        var73.setRight(var79);
        otherTree.setRight(var73);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer randneg267 = new Integer(-267);
        tree.add(randneg267);

        // Validating last operation...
        otherTree = new AVLNode<>(rand237);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var82 = new AVLNode<>(randneg175);var82.setHeight(2);var82.setBalanceFactor(1);
        AVLNode<Integer> var83 = new AVLNode<>(randneg461);var83.setHeight(1);var83.setBalanceFactor(-1);
        AVLNode<Integer> var84 = null;
        var83.setLeft(var84);
        AVLNode<Integer> var85 = new AVLNode<>(randneg267);var85.setHeight(0);var85.setBalanceFactor(0);
        AVLNode<Integer> var86 = null;
        var85.setLeft(var86);
        AVLNode<Integer> var87 = null;
        var85.setRight(var87);
        var83.setRight(var85);
        var82.setLeft(var83);
        AVLNode<Integer> var88 = new AVLNode<>(rand180);var88.setHeight(0);var88.setBalanceFactor(0);
        AVLNode<Integer> var89 = null;
        var88.setLeft(var89);
        AVLNode<Integer> var90 = null;
        var88.setRight(var90);
        var82.setRight(var88);
        otherTree.setLeft(var82);
        AVLNode<Integer> var91 = new AVLNode<>(rand955);var91.setHeight(2);var91.setBalanceFactor(1);
        AVLNode<Integer> var92 = new AVLNode<>(rand835);var92.setHeight(1);var92.setBalanceFactor(1);
        AVLNode<Integer> var93 = new AVLNode<>(rand297);var93.setHeight(0);var93.setBalanceFactor(0);
        AVLNode<Integer> var94 = null;
        var93.setLeft(var94);
        AVLNode<Integer> var95 = null;
        var93.setRight(var95);
        var92.setLeft(var93);
        AVLNode<Integer> var96 = null;
        var92.setRight(var96);
        var91.setLeft(var92);
        AVLNode<Integer> var97 = new AVLNode<>(rand978);var97.setHeight(0);var97.setBalanceFactor(0);
        AVLNode<Integer> var98 = null;
        var97.setLeft(var98);
        AVLNode<Integer> var99 = null;
        var97.setRight(var99);
        var91.setRight(var97);
        otherTree.setRight(var91);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer randneg787 = new Integer(-787);
        tree.add(randneg787);

        // Validating last operation...
        otherTree = new AVLNode<>(rand237);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var100 = new AVLNode<>(randneg175);var100.setHeight(2);var100.setBalanceFactor(1);
        AVLNode<Integer> var101 = new AVLNode<>(randneg461);var101.setHeight(1);var101.setBalanceFactor(0);
        AVLNode<Integer> var102 = new AVLNode<>(randneg787);var102.setHeight(0);var102.setBalanceFactor(0);
        AVLNode<Integer> var103 = null;
        var102.setLeft(var103);
        AVLNode<Integer> var104 = null;
        var102.setRight(var104);
        var101.setLeft(var102);
        AVLNode<Integer> var105 = new AVLNode<>(randneg267);var105.setHeight(0);var105.setBalanceFactor(0);
        AVLNode<Integer> var106 = null;
        var105.setLeft(var106);
        AVLNode<Integer> var107 = null;
        var105.setRight(var107);
        var101.setRight(var105);
        var100.setLeft(var101);
        AVLNode<Integer> var108 = new AVLNode<>(rand180);var108.setHeight(0);var108.setBalanceFactor(0);
        AVLNode<Integer> var109 = null;
        var108.setLeft(var109);
        AVLNode<Integer> var110 = null;
        var108.setRight(var110);
        var100.setRight(var108);
        otherTree.setLeft(var100);
        AVLNode<Integer> var111 = new AVLNode<>(rand955);var111.setHeight(2);var111.setBalanceFactor(1);
        AVLNode<Integer> var112 = new AVLNode<>(rand835);var112.setHeight(1);var112.setBalanceFactor(1);
        AVLNode<Integer> var113 = new AVLNode<>(rand297);var113.setHeight(0);var113.setBalanceFactor(0);
        AVLNode<Integer> var114 = null;
        var113.setLeft(var114);
        AVLNode<Integer> var115 = null;
        var113.setRight(var115);
        var112.setLeft(var113);
        AVLNode<Integer> var116 = null;
        var112.setRight(var116);
        var111.setLeft(var112);
        AVLNode<Integer> var117 = new AVLNode<>(rand978);var117.setHeight(0);var117.setBalanceFactor(0);
        AVLNode<Integer> var118 = null;
        var117.setLeft(var118);
        AVLNode<Integer> var119 = null;
        var117.setRight(var119);
        var111.setRight(var117);
        otherTree.setRight(var111);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer rand121 = new Integer(121);
        tree.add(rand121);

        // Validating last operation...
        otherTree = new AVLNode<>(rand237);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var120 = new AVLNode<>(randneg175);var120.setHeight(2);var120.setBalanceFactor(0);
        AVLNode<Integer> var121 = new AVLNode<>(randneg461);var121.setHeight(1);var121.setBalanceFactor(0);
        AVLNode<Integer> var122 = new AVLNode<>(randneg787);var122.setHeight(0);var122.setBalanceFactor(0);
        AVLNode<Integer> var123 = null;
        var122.setLeft(var123);
        AVLNode<Integer> var124 = null;
        var122.setRight(var124);
        var121.setLeft(var122);
        AVLNode<Integer> var125 = new AVLNode<>(randneg267);var125.setHeight(0);var125.setBalanceFactor(0);
        AVLNode<Integer> var126 = null;
        var125.setLeft(var126);
        AVLNode<Integer> var127 = null;
        var125.setRight(var127);
        var121.setRight(var125);
        var120.setLeft(var121);
        AVLNode<Integer> var128 = new AVLNode<>(rand180);var128.setHeight(1);var128.setBalanceFactor(1);
        AVLNode<Integer> var129 = new AVLNode<>(rand121);var129.setHeight(0);var129.setBalanceFactor(0);
        AVLNode<Integer> var130 = null;
        var129.setLeft(var130);
        AVLNode<Integer> var131 = null;
        var129.setRight(var131);
        var128.setLeft(var129);
        AVLNode<Integer> var132 = null;
        var128.setRight(var132);
        var120.setRight(var128);
        otherTree.setLeft(var120);
        AVLNode<Integer> var133 = new AVLNode<>(rand955);var133.setHeight(2);var133.setBalanceFactor(1);
        AVLNode<Integer> var134 = new AVLNode<>(rand835);var134.setHeight(1);var134.setBalanceFactor(1);
        AVLNode<Integer> var135 = new AVLNode<>(rand297);var135.setHeight(0);var135.setBalanceFactor(0);
        AVLNode<Integer> var136 = null;
        var135.setLeft(var136);
        AVLNode<Integer> var137 = null;
        var135.setRight(var137);
        var134.setLeft(var135);
        AVLNode<Integer> var138 = null;
        var134.setRight(var138);
        var133.setLeft(var134);
        AVLNode<Integer> var139 = new AVLNode<>(rand978);var139.setHeight(0);var139.setBalanceFactor(0);
        AVLNode<Integer> var140 = null;
        var139.setLeft(var140);
        AVLNode<Integer> var141 = null;
        var139.setRight(var141);
        var133.setRight(var139);
        otherTree.setRight(var133);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer rand575 = new Integer(575);
        tree.add(rand575);

        // Validating last operation...
        otherTree = new AVLNode<>(rand237);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var142 = new AVLNode<>(randneg175);var142.setHeight(2);var142.setBalanceFactor(0);
        AVLNode<Integer> var143 = new AVLNode<>(randneg461);var143.setHeight(1);var143.setBalanceFactor(0);
        AVLNode<Integer> var144 = new AVLNode<>(randneg787);var144.setHeight(0);var144.setBalanceFactor(0);
        AVLNode<Integer> var145 = null;
        var144.setLeft(var145);
        AVLNode<Integer> var146 = null;
        var144.setRight(var146);
        var143.setLeft(var144);
        AVLNode<Integer> var147 = new AVLNode<>(randneg267);var147.setHeight(0);var147.setBalanceFactor(0);
        AVLNode<Integer> var148 = null;
        var147.setLeft(var148);
        AVLNode<Integer> var149 = null;
        var147.setRight(var149);
        var143.setRight(var147);
        var142.setLeft(var143);
        AVLNode<Integer> var150 = new AVLNode<>(rand180);var150.setHeight(1);var150.setBalanceFactor(1);
        AVLNode<Integer> var151 = new AVLNode<>(rand121);var151.setHeight(0);var151.setBalanceFactor(0);
        AVLNode<Integer> var152 = null;
        var151.setLeft(var152);
        AVLNode<Integer> var153 = null;
        var151.setRight(var153);
        var150.setLeft(var151);
        AVLNode<Integer> var154 = null;
        var150.setRight(var154);
        var142.setRight(var150);
        otherTree.setLeft(var142);
        AVLNode<Integer> var155 = new AVLNode<>(rand955);var155.setHeight(2);var155.setBalanceFactor(1);
        AVLNode<Integer> var156 = new AVLNode<>(rand575);var156.setHeight(1);var156.setBalanceFactor(0);
        AVLNode<Integer> var157 = new AVLNode<>(rand297);var157.setHeight(0);var157.setBalanceFactor(0);
        AVLNode<Integer> var158 = null;
        var157.setLeft(var158);
        AVLNode<Integer> var159 = null;
        var157.setRight(var159);
        var156.setLeft(var157);
        AVLNode<Integer> var160 = new AVLNode<>(rand835);var160.setHeight(0);var160.setBalanceFactor(0);
        AVLNode<Integer> var161 = null;
        var160.setLeft(var161);
        AVLNode<Integer> var162 = null;
        var160.setRight(var162);
        var156.setRight(var160);
        var155.setLeft(var156);
        AVLNode<Integer> var163 = new AVLNode<>(rand978);var163.setHeight(0);var163.setBalanceFactor(0);
        AVLNode<Integer> var164 = null;
        var163.setLeft(var164);
        AVLNode<Integer> var165 = null;
        var163.setRight(var165);
        var155.setRight(var163);
        otherTree.setRight(var155);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer rand719 = new Integer(719);
        tree.add(rand719);

        // Validating last operation...
        otherTree = new AVLNode<>(rand237);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var166 = new AVLNode<>(randneg175);var166.setHeight(2);var166.setBalanceFactor(0);
        AVLNode<Integer> var167 = new AVLNode<>(randneg461);var167.setHeight(1);var167.setBalanceFactor(0);
        AVLNode<Integer> var168 = new AVLNode<>(randneg787);var168.setHeight(0);var168.setBalanceFactor(0);
        AVLNode<Integer> var169 = null;
        var168.setLeft(var169);
        AVLNode<Integer> var170 = null;
        var168.setRight(var170);
        var167.setLeft(var168);
        AVLNode<Integer> var171 = new AVLNode<>(randneg267);var171.setHeight(0);var171.setBalanceFactor(0);
        AVLNode<Integer> var172 = null;
        var171.setLeft(var172);
        AVLNode<Integer> var173 = null;
        var171.setRight(var173);
        var167.setRight(var171);
        var166.setLeft(var167);
        AVLNode<Integer> var174 = new AVLNode<>(rand180);var174.setHeight(1);var174.setBalanceFactor(1);
        AVLNode<Integer> var175 = new AVLNode<>(rand121);var175.setHeight(0);var175.setBalanceFactor(0);
        AVLNode<Integer> var176 = null;
        var175.setLeft(var176);
        AVLNode<Integer> var177 = null;
        var175.setRight(var177);
        var174.setLeft(var175);
        AVLNode<Integer> var178 = null;
        var174.setRight(var178);
        var166.setRight(var174);
        otherTree.setLeft(var166);
        AVLNode<Integer> var179 = new AVLNode<>(rand835);var179.setHeight(2);var179.setBalanceFactor(0);
        AVLNode<Integer> var180 = new AVLNode<>(rand575);var180.setHeight(1);var180.setBalanceFactor(0);
        AVLNode<Integer> var181 = new AVLNode<>(rand297);var181.setHeight(0);var181.setBalanceFactor(0);
        AVLNode<Integer> var182 = null;
        var181.setLeft(var182);
        AVLNode<Integer> var183 = null;
        var181.setRight(var183);
        var180.setLeft(var181);
        AVLNode<Integer> var184 = new AVLNode<>(rand719);var184.setHeight(0);var184.setBalanceFactor(0);
        AVLNode<Integer> var185 = null;
        var184.setLeft(var185);
        AVLNode<Integer> var186 = null;
        var184.setRight(var186);
        var180.setRight(var184);
        var179.setLeft(var180);
        AVLNode<Integer> var187 = new AVLNode<>(rand955);var187.setHeight(1);var187.setBalanceFactor(-1);
        AVLNode<Integer> var188 = null;
        var187.setLeft(var188);
        AVLNode<Integer> var189 = new AVLNode<>(rand978);var189.setHeight(0);var189.setBalanceFactor(0);
        AVLNode<Integer> var190 = null;
        var189.setLeft(var190);
        AVLNode<Integer> var191 = null;
        var189.setRight(var191);
        var187.setRight(var189);
        var179.setRight(var187);
        otherTree.setRight(var179);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #17: ==========
    @Test(timeout = TIMEOUT)
    public void test17() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg38 = new Integer(-38);
        tree.add(randneg38);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg38);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer randneg571 = new Integer(-571);
        tree.add(randneg571);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg38);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var2 = new AVLNode<>(randneg571);var2.setHeight(0);var2.setBalanceFactor(0);
        AVLNode<Integer> var3 = null;
        var2.setLeft(var3);
        AVLNode<Integer> var4 = null;
        var2.setRight(var4);
        otherTree.setLeft(var2);
        AVLNode<Integer> var5 = null;
        otherTree.setRight(var5);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer randneg558 = new Integer(-558);
        tree.add(randneg558);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg558);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(randneg571);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(randneg38);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        assertSame(randneg38, tree.remove(randneg38.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg558);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var12 = new AVLNode<>(randneg571);var12.setHeight(0);var12.setBalanceFactor(0);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = null;
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var15 = null;
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer randneg665 = new Integer(-665);
        tree.add(randneg665);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg571);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var16 = new AVLNode<>(randneg665);var16.setHeight(0);var16.setBalanceFactor(0);
        AVLNode<Integer> var17 = null;
        var16.setLeft(var17);
        AVLNode<Integer> var18 = null;
        var16.setRight(var18);
        otherTree.setLeft(var16);
        AVLNode<Integer> var19 = new AVLNode<>(randneg558);var19.setHeight(0);var19.setBalanceFactor(0);
        AVLNode<Integer> var20 = null;
        var19.setLeft(var20);
        AVLNode<Integer> var21 = null;
        var19.setRight(var21);
        otherTree.setRight(var19);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer randneg447 = new Integer(-447);
        tree.add(randneg447);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg571);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var22 = new AVLNode<>(randneg665);var22.setHeight(0);var22.setBalanceFactor(0);
        AVLNode<Integer> var23 = null;
        var22.setLeft(var23);
        AVLNode<Integer> var24 = null;
        var22.setRight(var24);
        otherTree.setLeft(var22);
        AVLNode<Integer> var25 = new AVLNode<>(randneg558);var25.setHeight(1);var25.setBalanceFactor(-1);
        AVLNode<Integer> var26 = null;
        var25.setLeft(var26);
        AVLNode<Integer> var27 = new AVLNode<>(randneg447);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        var25.setRight(var27);
        otherTree.setRight(var25);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer randneg226 = new Integer(-226);
        tree.add(randneg226);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg571);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var30 = new AVLNode<>(randneg665);var30.setHeight(0);var30.setBalanceFactor(0);
        AVLNode<Integer> var31 = null;
        var30.setLeft(var31);
        AVLNode<Integer> var32 = null;
        var30.setRight(var32);
        otherTree.setLeft(var30);
        AVLNode<Integer> var33 = new AVLNode<>(randneg447);var33.setHeight(1);var33.setBalanceFactor(0);
        AVLNode<Integer> var34 = new AVLNode<>(randneg558);var34.setHeight(0);var34.setBalanceFactor(0);
        AVLNode<Integer> var35 = null;
        var34.setLeft(var35);
        AVLNode<Integer> var36 = null;
        var34.setRight(var36);
        var33.setLeft(var34);
        AVLNode<Integer> var37 = new AVLNode<>(randneg226);var37.setHeight(0);var37.setBalanceFactor(0);
        AVLNode<Integer> var38 = null;
        var37.setLeft(var38);
        AVLNode<Integer> var39 = null;
        var37.setRight(var39);
        var33.setRight(var37);
        otherTree.setRight(var33);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer randneg746 = new Integer(-746);
        tree.add(randneg746);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg571);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var40 = new AVLNode<>(randneg665);var40.setHeight(1);var40.setBalanceFactor(1);
        AVLNode<Integer> var41 = new AVLNode<>(randneg746);var41.setHeight(0);var41.setBalanceFactor(0);
        AVLNode<Integer> var42 = null;
        var41.setLeft(var42);
        AVLNode<Integer> var43 = null;
        var41.setRight(var43);
        var40.setLeft(var41);
        AVLNode<Integer> var44 = null;
        var40.setRight(var44);
        otherTree.setLeft(var40);
        AVLNode<Integer> var45 = new AVLNode<>(randneg447);var45.setHeight(1);var45.setBalanceFactor(0);
        AVLNode<Integer> var46 = new AVLNode<>(randneg558);var46.setHeight(0);var46.setBalanceFactor(0);
        AVLNode<Integer> var47 = null;
        var46.setLeft(var47);
        AVLNode<Integer> var48 = null;
        var46.setRight(var48);
        var45.setLeft(var46);
        AVLNode<Integer> var49 = new AVLNode<>(randneg226);var49.setHeight(0);var49.setBalanceFactor(0);
        AVLNode<Integer> var50 = null;
        var49.setLeft(var50);
        AVLNode<Integer> var51 = null;
        var49.setRight(var51);
        var45.setRight(var49);
        otherTree.setRight(var45);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        assertSame(randneg558, tree.remove(randneg558.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg571);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var52 = new AVLNode<>(randneg665);var52.setHeight(1);var52.setBalanceFactor(1);
        AVLNode<Integer> var53 = new AVLNode<>(randneg746);var53.setHeight(0);var53.setBalanceFactor(0);
        AVLNode<Integer> var54 = null;
        var53.setLeft(var54);
        AVLNode<Integer> var55 = null;
        var53.setRight(var55);
        var52.setLeft(var53);
        AVLNode<Integer> var56 = null;
        var52.setRight(var56);
        otherTree.setLeft(var52);
        AVLNode<Integer> var57 = new AVLNode<>(randneg447);var57.setHeight(1);var57.setBalanceFactor(-1);
        AVLNode<Integer> var58 = null;
        var57.setLeft(var58);
        AVLNode<Integer> var59 = new AVLNode<>(randneg226);var59.setHeight(0);var59.setBalanceFactor(0);
        AVLNode<Integer> var60 = null;
        var59.setLeft(var60);
        AVLNode<Integer> var61 = null;
        var59.setRight(var61);
        var57.setRight(var59);
        otherTree.setRight(var57);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer randneg278 = new Integer(-278);
        tree.add(randneg278);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg571);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var62 = new AVLNode<>(randneg665);var62.setHeight(1);var62.setBalanceFactor(1);
        AVLNode<Integer> var63 = new AVLNode<>(randneg746);var63.setHeight(0);var63.setBalanceFactor(0);
        AVLNode<Integer> var64 = null;
        var63.setLeft(var64);
        AVLNode<Integer> var65 = null;
        var63.setRight(var65);
        var62.setLeft(var63);
        AVLNode<Integer> var66 = null;
        var62.setRight(var66);
        otherTree.setLeft(var62);
        AVLNode<Integer> var67 = new AVLNode<>(randneg278);var67.setHeight(1);var67.setBalanceFactor(0);
        AVLNode<Integer> var68 = new AVLNode<>(randneg447);var68.setHeight(0);var68.setBalanceFactor(0);
        AVLNode<Integer> var69 = null;
        var68.setLeft(var69);
        AVLNode<Integer> var70 = null;
        var68.setRight(var70);
        var67.setLeft(var68);
        AVLNode<Integer> var71 = new AVLNode<>(randneg226);var71.setHeight(0);var71.setBalanceFactor(0);
        AVLNode<Integer> var72 = null;
        var71.setLeft(var72);
        AVLNode<Integer> var73 = null;
        var71.setRight(var73);
        var67.setRight(var71);
        otherTree.setRight(var67);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer rand14 = new Integer(14);
        tree.add(rand14);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg571);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var74 = new AVLNode<>(randneg665);var74.setHeight(1);var74.setBalanceFactor(1);
        AVLNode<Integer> var75 = new AVLNode<>(randneg746);var75.setHeight(0);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = null;
        var75.setLeft(var76);
        AVLNode<Integer> var77 = null;
        var75.setRight(var77);
        var74.setLeft(var75);
        AVLNode<Integer> var78 = null;
        var74.setRight(var78);
        otherTree.setLeft(var74);
        AVLNode<Integer> var79 = new AVLNode<>(randneg278);var79.setHeight(2);var79.setBalanceFactor(-1);
        AVLNode<Integer> var80 = new AVLNode<>(randneg447);var80.setHeight(0);var80.setBalanceFactor(0);
        AVLNode<Integer> var81 = null;
        var80.setLeft(var81);
        AVLNode<Integer> var82 = null;
        var80.setRight(var82);
        var79.setLeft(var80);
        AVLNode<Integer> var83 = new AVLNode<>(randneg226);var83.setHeight(1);var83.setBalanceFactor(-1);
        AVLNode<Integer> var84 = null;
        var83.setLeft(var84);
        AVLNode<Integer> var85 = new AVLNode<>(rand14);var85.setHeight(0);var85.setBalanceFactor(0);
        AVLNode<Integer> var86 = null;
        var85.setLeft(var86);
        AVLNode<Integer> var87 = null;
        var85.setRight(var87);
        var83.setRight(var85);
        var79.setRight(var83);
        otherTree.setRight(var79);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer rand542 = new Integer(542);
        tree.add(rand542);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg571);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var88 = new AVLNode<>(randneg665);var88.setHeight(1);var88.setBalanceFactor(1);
        AVLNode<Integer> var89 = new AVLNode<>(randneg746);var89.setHeight(0);var89.setBalanceFactor(0);
        AVLNode<Integer> var90 = null;
        var89.setLeft(var90);
        AVLNode<Integer> var91 = null;
        var89.setRight(var91);
        var88.setLeft(var89);
        AVLNode<Integer> var92 = null;
        var88.setRight(var92);
        otherTree.setLeft(var88);
        AVLNode<Integer> var93 = new AVLNode<>(randneg278);var93.setHeight(2);var93.setBalanceFactor(-1);
        AVLNode<Integer> var94 = new AVLNode<>(randneg447);var94.setHeight(0);var94.setBalanceFactor(0);
        AVLNode<Integer> var95 = null;
        var94.setLeft(var95);
        AVLNode<Integer> var96 = null;
        var94.setRight(var96);
        var93.setLeft(var94);
        AVLNode<Integer> var97 = new AVLNode<>(rand14);var97.setHeight(1);var97.setBalanceFactor(0);
        AVLNode<Integer> var98 = new AVLNode<>(randneg226);var98.setHeight(0);var98.setBalanceFactor(0);
        AVLNode<Integer> var99 = null;
        var98.setLeft(var99);
        AVLNode<Integer> var100 = null;
        var98.setRight(var100);
        var97.setLeft(var98);
        AVLNode<Integer> var101 = new AVLNode<>(rand542);var101.setHeight(0);var101.setBalanceFactor(0);
        AVLNode<Integer> var102 = null;
        var101.setLeft(var102);
        AVLNode<Integer> var103 = null;
        var101.setRight(var103);
        var97.setRight(var101);
        var93.setRight(var97);
        otherTree.setRight(var93);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        assertSame(randneg665, tree.remove(randneg665.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg278);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var104 = new AVLNode<>(randneg571);var104.setHeight(1);var104.setBalanceFactor(0);
        AVLNode<Integer> var105 = new AVLNode<>(randneg746);var105.setHeight(0);var105.setBalanceFactor(0);
        AVLNode<Integer> var106 = null;
        var105.setLeft(var106);
        AVLNode<Integer> var107 = null;
        var105.setRight(var107);
        var104.setLeft(var105);
        AVLNode<Integer> var108 = new AVLNode<>(randneg447);var108.setHeight(0);var108.setBalanceFactor(0);
        AVLNode<Integer> var109 = null;
        var108.setLeft(var109);
        AVLNode<Integer> var110 = null;
        var108.setRight(var110);
        var104.setRight(var108);
        otherTree.setLeft(var104);
        AVLNode<Integer> var111 = new AVLNode<>(rand14);var111.setHeight(1);var111.setBalanceFactor(0);
        AVLNode<Integer> var112 = new AVLNode<>(randneg226);var112.setHeight(0);var112.setBalanceFactor(0);
        AVLNode<Integer> var113 = null;
        var112.setLeft(var113);
        AVLNode<Integer> var114 = null;
        var112.setRight(var114);
        var111.setLeft(var112);
        AVLNode<Integer> var115 = new AVLNode<>(rand542);var115.setHeight(0);var115.setBalanceFactor(0);
        AVLNode<Integer> var116 = null;
        var115.setLeft(var116);
        AVLNode<Integer> var117 = null;
        var115.setRight(var117);
        var111.setRight(var115);
        otherTree.setRight(var111);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer randneg59 = new Integer(-59);
        tree.add(randneg59);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg278);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var118 = new AVLNode<>(randneg571);var118.setHeight(1);var118.setBalanceFactor(0);
        AVLNode<Integer> var119 = new AVLNode<>(randneg746);var119.setHeight(0);var119.setBalanceFactor(0);
        AVLNode<Integer> var120 = null;
        var119.setLeft(var120);
        AVLNode<Integer> var121 = null;
        var119.setRight(var121);
        var118.setLeft(var119);
        AVLNode<Integer> var122 = new AVLNode<>(randneg447);var122.setHeight(0);var122.setBalanceFactor(0);
        AVLNode<Integer> var123 = null;
        var122.setLeft(var123);
        AVLNode<Integer> var124 = null;
        var122.setRight(var124);
        var118.setRight(var122);
        otherTree.setLeft(var118);
        AVLNode<Integer> var125 = new AVLNode<>(rand14);var125.setHeight(2);var125.setBalanceFactor(1);
        AVLNode<Integer> var126 = new AVLNode<>(randneg226);var126.setHeight(1);var126.setBalanceFactor(-1);
        AVLNode<Integer> var127 = null;
        var126.setLeft(var127);
        AVLNode<Integer> var128 = new AVLNode<>(randneg59);var128.setHeight(0);var128.setBalanceFactor(0);
        AVLNode<Integer> var129 = null;
        var128.setLeft(var129);
        AVLNode<Integer> var130 = null;
        var128.setRight(var130);
        var126.setRight(var128);
        var125.setLeft(var126);
        AVLNode<Integer> var131 = new AVLNode<>(rand542);var131.setHeight(0);var131.setBalanceFactor(0);
        AVLNode<Integer> var132 = null;
        var131.setLeft(var132);
        AVLNode<Integer> var133 = null;
        var131.setRight(var133);
        var125.setRight(var131);
        otherTree.setRight(var125);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        assertSame(randneg59, tree.remove(randneg59.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg278);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var134 = new AVLNode<>(randneg571);var134.setHeight(1);var134.setBalanceFactor(0);
        AVLNode<Integer> var135 = new AVLNode<>(randneg746);var135.setHeight(0);var135.setBalanceFactor(0);
        AVLNode<Integer> var136 = null;
        var135.setLeft(var136);
        AVLNode<Integer> var137 = null;
        var135.setRight(var137);
        var134.setLeft(var135);
        AVLNode<Integer> var138 = new AVLNode<>(randneg447);var138.setHeight(0);var138.setBalanceFactor(0);
        AVLNode<Integer> var139 = null;
        var138.setLeft(var139);
        AVLNode<Integer> var140 = null;
        var138.setRight(var140);
        var134.setRight(var138);
        otherTree.setLeft(var134);
        AVLNode<Integer> var141 = new AVLNode<>(rand14);var141.setHeight(1);var141.setBalanceFactor(0);
        AVLNode<Integer> var142 = new AVLNode<>(randneg226);var142.setHeight(0);var142.setBalanceFactor(0);
        AVLNode<Integer> var143 = null;
        var142.setLeft(var143);
        AVLNode<Integer> var144 = null;
        var142.setRight(var144);
        var141.setLeft(var142);
        AVLNode<Integer> var145 = new AVLNode<>(rand542);var145.setHeight(0);var145.setBalanceFactor(0);
        AVLNode<Integer> var146 = null;
        var145.setLeft(var146);
        AVLNode<Integer> var147 = null;
        var145.setRight(var147);
        var141.setRight(var145);
        otherTree.setRight(var141);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #18: ==========
    @Test(timeout = TIMEOUT)
    public void test18() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg507 = new Integer(-507);
        tree.add(randneg507);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg507);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        assertSame(randneg507, tree.remove(randneg507.intValue()));

        // Validating last operation...
        otherTree = null;
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer rand116 = new Integer(116);
        tree.add(rand116);

        // Validating last operation...
        otherTree = new AVLNode<>(rand116);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = null;
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        assertSame(rand116, tree.remove(rand116.intValue()));

        // Validating last operation...
        otherTree = null;
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer randneg497 = new Integer(-497);
        tree.add(randneg497);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg497);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var4 = null;
        otherTree.setLeft(var4);
        AVLNode<Integer> var5 = null;
        otherTree.setRight(var5);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer randneg705 = new Integer(-705);
        tree.add(randneg705);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg497);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var6 = new AVLNode<>(randneg705);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = null;
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer rand93 = new Integer(93);
        tree.add(rand93);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg497);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var10 = new AVLNode<>(randneg705);var10.setHeight(0);var10.setBalanceFactor(0);
        AVLNode<Integer> var11 = null;
        var10.setLeft(var11);
        AVLNode<Integer> var12 = null;
        var10.setRight(var12);
        otherTree.setLeft(var10);
        AVLNode<Integer> var13 = new AVLNode<>(rand93);var13.setHeight(0);var13.setBalanceFactor(0);
        AVLNode<Integer> var14 = null;
        var13.setLeft(var14);
        AVLNode<Integer> var15 = null;
        var13.setRight(var15);
        otherTree.setRight(var13);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer randneg496 = new Integer(-496);
        tree.add(randneg496);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg497);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var16 = new AVLNode<>(randneg705);var16.setHeight(0);var16.setBalanceFactor(0);
        AVLNode<Integer> var17 = null;
        var16.setLeft(var17);
        AVLNode<Integer> var18 = null;
        var16.setRight(var18);
        otherTree.setLeft(var16);
        AVLNode<Integer> var19 = new AVLNode<>(rand93);var19.setHeight(1);var19.setBalanceFactor(1);
        AVLNode<Integer> var20 = new AVLNode<>(randneg496);var20.setHeight(0);var20.setBalanceFactor(0);
        AVLNode<Integer> var21 = null;
        var20.setLeft(var21);
        AVLNode<Integer> var22 = null;
        var20.setRight(var22);
        var19.setLeft(var20);
        AVLNode<Integer> var23 = null;
        var19.setRight(var23);
        otherTree.setRight(var19);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer rand671 = new Integer(671);
        tree.add(rand671);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg497);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var24 = new AVLNode<>(randneg705);var24.setHeight(0);var24.setBalanceFactor(0);
        AVLNode<Integer> var25 = null;
        var24.setLeft(var25);
        AVLNode<Integer> var26 = null;
        var24.setRight(var26);
        otherTree.setLeft(var24);
        AVLNode<Integer> var27 = new AVLNode<>(rand93);var27.setHeight(1);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = new AVLNode<>(randneg496);var28.setHeight(0);var28.setBalanceFactor(0);
        AVLNode<Integer> var29 = null;
        var28.setLeft(var29);
        AVLNode<Integer> var30 = null;
        var28.setRight(var30);
        var27.setLeft(var28);
        AVLNode<Integer> var31 = new AVLNode<>(rand671);var31.setHeight(0);var31.setBalanceFactor(0);
        AVLNode<Integer> var32 = null;
        var31.setLeft(var32);
        AVLNode<Integer> var33 = null;
        var31.setRight(var33);
        var27.setRight(var31);
        otherTree.setRight(var27);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        assertSame(rand671, tree.remove(rand671.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg497);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var34 = new AVLNode<>(randneg705);var34.setHeight(0);var34.setBalanceFactor(0);
        AVLNode<Integer> var35 = null;
        var34.setLeft(var35);
        AVLNode<Integer> var36 = null;
        var34.setRight(var36);
        otherTree.setLeft(var34);
        AVLNode<Integer> var37 = new AVLNode<>(rand93);var37.setHeight(1);var37.setBalanceFactor(1);
        AVLNode<Integer> var38 = new AVLNode<>(randneg496);var38.setHeight(0);var38.setBalanceFactor(0);
        AVLNode<Integer> var39 = null;
        var38.setLeft(var39);
        AVLNode<Integer> var40 = null;
        var38.setRight(var40);
        var37.setLeft(var38);
        AVLNode<Integer> var41 = null;
        var37.setRight(var41);
        otherTree.setRight(var37);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer randneg879 = new Integer(-879);
        tree.add(randneg879);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg497);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var42 = new AVLNode<>(randneg705);var42.setHeight(1);var42.setBalanceFactor(1);
        AVLNode<Integer> var43 = new AVLNode<>(randneg879);var43.setHeight(0);var43.setBalanceFactor(0);
        AVLNode<Integer> var44 = null;
        var43.setLeft(var44);
        AVLNode<Integer> var45 = null;
        var43.setRight(var45);
        var42.setLeft(var43);
        AVLNode<Integer> var46 = null;
        var42.setRight(var46);
        otherTree.setLeft(var42);
        AVLNode<Integer> var47 = new AVLNode<>(rand93);var47.setHeight(1);var47.setBalanceFactor(1);
        AVLNode<Integer> var48 = new AVLNode<>(randneg496);var48.setHeight(0);var48.setBalanceFactor(0);
        AVLNode<Integer> var49 = null;
        var48.setLeft(var49);
        AVLNode<Integer> var50 = null;
        var48.setRight(var50);
        var47.setLeft(var48);
        AVLNode<Integer> var51 = null;
        var47.setRight(var51);
        otherTree.setRight(var47);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        assertSame(rand93, tree.remove(rand93.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg497);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var52 = new AVLNode<>(randneg705);var52.setHeight(1);var52.setBalanceFactor(1);
        AVLNode<Integer> var53 = new AVLNode<>(randneg879);var53.setHeight(0);var53.setBalanceFactor(0);
        AVLNode<Integer> var54 = null;
        var53.setLeft(var54);
        AVLNode<Integer> var55 = null;
        var53.setRight(var55);
        var52.setLeft(var53);
        AVLNode<Integer> var56 = null;
        var52.setRight(var56);
        otherTree.setLeft(var52);
        AVLNode<Integer> var57 = new AVLNode<>(randneg496);var57.setHeight(0);var57.setBalanceFactor(0);
        AVLNode<Integer> var58 = null;
        var57.setLeft(var58);
        AVLNode<Integer> var59 = null;
        var57.setRight(var59);
        otherTree.setRight(var57);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer rand973 = new Integer(973);
        tree.add(rand973);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg497);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var60 = new AVLNode<>(randneg705);var60.setHeight(1);var60.setBalanceFactor(1);
        AVLNode<Integer> var61 = new AVLNode<>(randneg879);var61.setHeight(0);var61.setBalanceFactor(0);
        AVLNode<Integer> var62 = null;
        var61.setLeft(var62);
        AVLNode<Integer> var63 = null;
        var61.setRight(var63);
        var60.setLeft(var61);
        AVLNode<Integer> var64 = null;
        var60.setRight(var64);
        otherTree.setLeft(var60);
        AVLNode<Integer> var65 = new AVLNode<>(randneg496);var65.setHeight(1);var65.setBalanceFactor(-1);
        AVLNode<Integer> var66 = null;
        var65.setLeft(var66);
        AVLNode<Integer> var67 = new AVLNode<>(rand973);var67.setHeight(0);var67.setBalanceFactor(0);
        AVLNode<Integer> var68 = null;
        var67.setLeft(var68);
        AVLNode<Integer> var69 = null;
        var67.setRight(var69);
        var65.setRight(var67);
        otherTree.setRight(var65);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer rand759 = new Integer(759);
        tree.add(rand759);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg497);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var70 = new AVLNode<>(randneg705);var70.setHeight(1);var70.setBalanceFactor(1);
        AVLNode<Integer> var71 = new AVLNode<>(randneg879);var71.setHeight(0);var71.setBalanceFactor(0);
        AVLNode<Integer> var72 = null;
        var71.setLeft(var72);
        AVLNode<Integer> var73 = null;
        var71.setRight(var73);
        var70.setLeft(var71);
        AVLNode<Integer> var74 = null;
        var70.setRight(var74);
        otherTree.setLeft(var70);
        AVLNode<Integer> var75 = new AVLNode<>(rand759);var75.setHeight(1);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = new AVLNode<>(randneg496);var76.setHeight(0);var76.setBalanceFactor(0);
        AVLNode<Integer> var77 = null;
        var76.setLeft(var77);
        AVLNode<Integer> var78 = null;
        var76.setRight(var78);
        var75.setLeft(var76);
        AVLNode<Integer> var79 = new AVLNode<>(rand973);var79.setHeight(0);var79.setBalanceFactor(0);
        AVLNode<Integer> var80 = null;
        var79.setLeft(var80);
        AVLNode<Integer> var81 = null;
        var79.setRight(var81);
        var75.setRight(var79);
        otherTree.setRight(var75);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer randneg509 = new Integer(-509);
        tree.add(randneg509);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg497);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var82 = new AVLNode<>(randneg705);var82.setHeight(1);var82.setBalanceFactor(0);
        AVLNode<Integer> var83 = new AVLNode<>(randneg879);var83.setHeight(0);var83.setBalanceFactor(0);
        AVLNode<Integer> var84 = null;
        var83.setLeft(var84);
        AVLNode<Integer> var85 = null;
        var83.setRight(var85);
        var82.setLeft(var83);
        AVLNode<Integer> var86 = new AVLNode<>(randneg509);var86.setHeight(0);var86.setBalanceFactor(0);
        AVLNode<Integer> var87 = null;
        var86.setLeft(var87);
        AVLNode<Integer> var88 = null;
        var86.setRight(var88);
        var82.setRight(var86);
        otherTree.setLeft(var82);
        AVLNode<Integer> var89 = new AVLNode<>(rand759);var89.setHeight(1);var89.setBalanceFactor(0);
        AVLNode<Integer> var90 = new AVLNode<>(randneg496);var90.setHeight(0);var90.setBalanceFactor(0);
        AVLNode<Integer> var91 = null;
        var90.setLeft(var91);
        AVLNode<Integer> var92 = null;
        var90.setRight(var92);
        var89.setLeft(var90);
        AVLNode<Integer> var93 = new AVLNode<>(rand973);var93.setHeight(0);var93.setBalanceFactor(0);
        AVLNode<Integer> var94 = null;
        var93.setLeft(var94);
        AVLNode<Integer> var95 = null;
        var93.setRight(var95);
        var89.setRight(var93);
        otherTree.setRight(var89);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #19: ==========
    @Test(timeout = TIMEOUT)
    public void test19() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer rand394 = new Integer(394);
        tree.add(rand394);

        // Validating last operation...
        otherTree = new AVLNode<>(rand394);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer randneg271 = new Integer(-271);
        tree.add(randneg271);

        // Validating last operation...
        otherTree = new AVLNode<>(rand394);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var2 = new AVLNode<>(randneg271);var2.setHeight(0);var2.setBalanceFactor(0);
        AVLNode<Integer> var3 = null;
        var2.setLeft(var3);
        AVLNode<Integer> var4 = null;
        var2.setRight(var4);
        otherTree.setLeft(var2);
        AVLNode<Integer> var5 = null;
        otherTree.setRight(var5);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer rand474 = new Integer(474);
        tree.add(rand474);

        // Validating last operation...
        otherTree = new AVLNode<>(rand394);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(randneg271);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(rand474);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer rand633 = new Integer(633);
        tree.add(rand633);

        // Validating last operation...
        otherTree = new AVLNode<>(rand394);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var12 = new AVLNode<>(randneg271);var12.setHeight(0);var12.setBalanceFactor(0);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = null;
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var15 = new AVLNode<>(rand474);var15.setHeight(1);var15.setBalanceFactor(-1);
        AVLNode<Integer> var16 = null;
        var15.setLeft(var16);
        AVLNode<Integer> var17 = new AVLNode<>(rand633);var17.setHeight(0);var17.setBalanceFactor(0);
        AVLNode<Integer> var18 = null;
        var17.setLeft(var18);
        AVLNode<Integer> var19 = null;
        var17.setRight(var19);
        var15.setRight(var17);
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer rand950 = new Integer(950);
        tree.add(rand950);

        // Validating last operation...
        otherTree = new AVLNode<>(rand394);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var20 = new AVLNode<>(randneg271);var20.setHeight(0);var20.setBalanceFactor(0);
        AVLNode<Integer> var21 = null;
        var20.setLeft(var21);
        AVLNode<Integer> var22 = null;
        var20.setRight(var22);
        otherTree.setLeft(var20);
        AVLNode<Integer> var23 = new AVLNode<>(rand633);var23.setHeight(1);var23.setBalanceFactor(0);
        AVLNode<Integer> var24 = new AVLNode<>(rand474);var24.setHeight(0);var24.setBalanceFactor(0);
        AVLNode<Integer> var25 = null;
        var24.setLeft(var25);
        AVLNode<Integer> var26 = null;
        var24.setRight(var26);
        var23.setLeft(var24);
        AVLNode<Integer> var27 = new AVLNode<>(rand950);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        var23.setRight(var27);
        otherTree.setRight(var23);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer rand846 = new Integer(846);
        tree.add(rand846);

        // Validating last operation...
        otherTree = new AVLNode<>(rand633);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var30 = new AVLNode<>(rand394);var30.setHeight(1);var30.setBalanceFactor(0);
        AVLNode<Integer> var31 = new AVLNode<>(randneg271);var31.setHeight(0);var31.setBalanceFactor(0);
        AVLNode<Integer> var32 = null;
        var31.setLeft(var32);
        AVLNode<Integer> var33 = null;
        var31.setRight(var33);
        var30.setLeft(var31);
        AVLNode<Integer> var34 = new AVLNode<>(rand474);var34.setHeight(0);var34.setBalanceFactor(0);
        AVLNode<Integer> var35 = null;
        var34.setLeft(var35);
        AVLNode<Integer> var36 = null;
        var34.setRight(var36);
        var30.setRight(var34);
        otherTree.setLeft(var30);
        AVLNode<Integer> var37 = new AVLNode<>(rand950);var37.setHeight(1);var37.setBalanceFactor(1);
        AVLNode<Integer> var38 = new AVLNode<>(rand846);var38.setHeight(0);var38.setBalanceFactor(0);
        AVLNode<Integer> var39 = null;
        var38.setLeft(var39);
        AVLNode<Integer> var40 = null;
        var38.setRight(var40);
        var37.setLeft(var38);
        AVLNode<Integer> var41 = null;
        var37.setRight(var41);
        otherTree.setRight(var37);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer randneg959 = new Integer(-959);
        tree.add(randneg959);

        // Validating last operation...
        otherTree = new AVLNode<>(rand633);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var42 = new AVLNode<>(rand394);var42.setHeight(2);var42.setBalanceFactor(1);
        AVLNode<Integer> var43 = new AVLNode<>(randneg271);var43.setHeight(1);var43.setBalanceFactor(1);
        AVLNode<Integer> var44 = new AVLNode<>(randneg959);var44.setHeight(0);var44.setBalanceFactor(0);
        AVLNode<Integer> var45 = null;
        var44.setLeft(var45);
        AVLNode<Integer> var46 = null;
        var44.setRight(var46);
        var43.setLeft(var44);
        AVLNode<Integer> var47 = null;
        var43.setRight(var47);
        var42.setLeft(var43);
        AVLNode<Integer> var48 = new AVLNode<>(rand474);var48.setHeight(0);var48.setBalanceFactor(0);
        AVLNode<Integer> var49 = null;
        var48.setLeft(var49);
        AVLNode<Integer> var50 = null;
        var48.setRight(var50);
        var42.setRight(var48);
        otherTree.setLeft(var42);
        AVLNode<Integer> var51 = new AVLNode<>(rand950);var51.setHeight(1);var51.setBalanceFactor(1);
        AVLNode<Integer> var52 = new AVLNode<>(rand846);var52.setHeight(0);var52.setBalanceFactor(0);
        AVLNode<Integer> var53 = null;
        var52.setLeft(var53);
        AVLNode<Integer> var54 = null;
        var52.setRight(var54);
        var51.setLeft(var52);
        AVLNode<Integer> var55 = null;
        var51.setRight(var55);
        otherTree.setRight(var51);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        assertSame(rand846, tree.remove(rand846.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand394);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var56 = new AVLNode<>(randneg271);var56.setHeight(1);var56.setBalanceFactor(1);
        AVLNode<Integer> var57 = new AVLNode<>(randneg959);var57.setHeight(0);var57.setBalanceFactor(0);
        AVLNode<Integer> var58 = null;
        var57.setLeft(var58);
        AVLNode<Integer> var59 = null;
        var57.setRight(var59);
        var56.setLeft(var57);
        AVLNode<Integer> var60 = null;
        var56.setRight(var60);
        otherTree.setLeft(var56);
        AVLNode<Integer> var61 = new AVLNode<>(rand633);var61.setHeight(1);var61.setBalanceFactor(0);
        AVLNode<Integer> var62 = new AVLNode<>(rand474);var62.setHeight(0);var62.setBalanceFactor(0);
        AVLNode<Integer> var63 = null;
        var62.setLeft(var63);
        AVLNode<Integer> var64 = null;
        var62.setRight(var64);
        var61.setLeft(var62);
        AVLNode<Integer> var65 = new AVLNode<>(rand950);var65.setHeight(0);var65.setBalanceFactor(0);
        AVLNode<Integer> var66 = null;
        var65.setLeft(var66);
        AVLNode<Integer> var67 = null;
        var65.setRight(var67);
        var61.setRight(var65);
        otherTree.setRight(var61);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer randneg337 = new Integer(-337);
        tree.add(randneg337);

        // Validating last operation...
        otherTree = new AVLNode<>(rand394);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var68 = new AVLNode<>(randneg337);var68.setHeight(1);var68.setBalanceFactor(0);
        AVLNode<Integer> var69 = new AVLNode<>(randneg959);var69.setHeight(0);var69.setBalanceFactor(0);
        AVLNode<Integer> var70 = null;
        var69.setLeft(var70);
        AVLNode<Integer> var71 = null;
        var69.setRight(var71);
        var68.setLeft(var69);
        AVLNode<Integer> var72 = new AVLNode<>(randneg271);var72.setHeight(0);var72.setBalanceFactor(0);
        AVLNode<Integer> var73 = null;
        var72.setLeft(var73);
        AVLNode<Integer> var74 = null;
        var72.setRight(var74);
        var68.setRight(var72);
        otherTree.setLeft(var68);
        AVLNode<Integer> var75 = new AVLNode<>(rand633);var75.setHeight(1);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = new AVLNode<>(rand474);var76.setHeight(0);var76.setBalanceFactor(0);
        AVLNode<Integer> var77 = null;
        var76.setLeft(var77);
        AVLNode<Integer> var78 = null;
        var76.setRight(var78);
        var75.setLeft(var76);
        AVLNode<Integer> var79 = new AVLNode<>(rand950);var79.setHeight(0);var79.setBalanceFactor(0);
        AVLNode<Integer> var80 = null;
        var79.setLeft(var80);
        AVLNode<Integer> var81 = null;
        var79.setRight(var81);
        var75.setRight(var79);
        otherTree.setRight(var75);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer rand721 = new Integer(721);
        tree.add(rand721);

        // Validating last operation...
        otherTree = new AVLNode<>(rand394);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var82 = new AVLNode<>(randneg337);var82.setHeight(1);var82.setBalanceFactor(0);
        AVLNode<Integer> var83 = new AVLNode<>(randneg959);var83.setHeight(0);var83.setBalanceFactor(0);
        AVLNode<Integer> var84 = null;
        var83.setLeft(var84);
        AVLNode<Integer> var85 = null;
        var83.setRight(var85);
        var82.setLeft(var83);
        AVLNode<Integer> var86 = new AVLNode<>(randneg271);var86.setHeight(0);var86.setBalanceFactor(0);
        AVLNode<Integer> var87 = null;
        var86.setLeft(var87);
        AVLNode<Integer> var88 = null;
        var86.setRight(var88);
        var82.setRight(var86);
        otherTree.setLeft(var82);
        AVLNode<Integer> var89 = new AVLNode<>(rand633);var89.setHeight(2);var89.setBalanceFactor(-1);
        AVLNode<Integer> var90 = new AVLNode<>(rand474);var90.setHeight(0);var90.setBalanceFactor(0);
        AVLNode<Integer> var91 = null;
        var90.setLeft(var91);
        AVLNode<Integer> var92 = null;
        var90.setRight(var92);
        var89.setLeft(var90);
        AVLNode<Integer> var93 = new AVLNode<>(rand950);var93.setHeight(1);var93.setBalanceFactor(1);
        AVLNode<Integer> var94 = new AVLNode<>(rand721);var94.setHeight(0);var94.setBalanceFactor(0);
        AVLNode<Integer> var95 = null;
        var94.setLeft(var95);
        AVLNode<Integer> var96 = null;
        var94.setRight(var96);
        var93.setLeft(var94);
        AVLNode<Integer> var97 = null;
        var93.setRight(var97);
        var89.setRight(var93);
        otherTree.setRight(var89);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer randneg537 = new Integer(-537);
        tree.add(randneg537);

        // Validating last operation...
        otherTree = new AVLNode<>(rand394);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var98 = new AVLNode<>(randneg337);var98.setHeight(2);var98.setBalanceFactor(1);
        AVLNode<Integer> var99 = new AVLNode<>(randneg959);var99.setHeight(1);var99.setBalanceFactor(-1);
        AVLNode<Integer> var100 = null;
        var99.setLeft(var100);
        AVLNode<Integer> var101 = new AVLNode<>(randneg537);var101.setHeight(0);var101.setBalanceFactor(0);
        AVLNode<Integer> var102 = null;
        var101.setLeft(var102);
        AVLNode<Integer> var103 = null;
        var101.setRight(var103);
        var99.setRight(var101);
        var98.setLeft(var99);
        AVLNode<Integer> var104 = new AVLNode<>(randneg271);var104.setHeight(0);var104.setBalanceFactor(0);
        AVLNode<Integer> var105 = null;
        var104.setLeft(var105);
        AVLNode<Integer> var106 = null;
        var104.setRight(var106);
        var98.setRight(var104);
        otherTree.setLeft(var98);
        AVLNode<Integer> var107 = new AVLNode<>(rand633);var107.setHeight(2);var107.setBalanceFactor(-1);
        AVLNode<Integer> var108 = new AVLNode<>(rand474);var108.setHeight(0);var108.setBalanceFactor(0);
        AVLNode<Integer> var109 = null;
        var108.setLeft(var109);
        AVLNode<Integer> var110 = null;
        var108.setRight(var110);
        var107.setLeft(var108);
        AVLNode<Integer> var111 = new AVLNode<>(rand950);var111.setHeight(1);var111.setBalanceFactor(1);
        AVLNode<Integer> var112 = new AVLNode<>(rand721);var112.setHeight(0);var112.setBalanceFactor(0);
        AVLNode<Integer> var113 = null;
        var112.setLeft(var113);
        AVLNode<Integer> var114 = null;
        var112.setRight(var114);
        var111.setLeft(var112);
        AVLNode<Integer> var115 = null;
        var111.setRight(var115);
        var107.setRight(var111);
        otherTree.setRight(var107);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer randneg40 = new Integer(-40);
        tree.add(randneg40);

        // Validating last operation...
        otherTree = new AVLNode<>(rand394);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var116 = new AVLNode<>(randneg337);var116.setHeight(2);var116.setBalanceFactor(0);
        AVLNode<Integer> var117 = new AVLNode<>(randneg959);var117.setHeight(1);var117.setBalanceFactor(-1);
        AVLNode<Integer> var118 = null;
        var117.setLeft(var118);
        AVLNode<Integer> var119 = new AVLNode<>(randneg537);var119.setHeight(0);var119.setBalanceFactor(0);
        AVLNode<Integer> var120 = null;
        var119.setLeft(var120);
        AVLNode<Integer> var121 = null;
        var119.setRight(var121);
        var117.setRight(var119);
        var116.setLeft(var117);
        AVLNode<Integer> var122 = new AVLNode<>(randneg271);var122.setHeight(1);var122.setBalanceFactor(-1);
        AVLNode<Integer> var123 = null;
        var122.setLeft(var123);
        AVLNode<Integer> var124 = new AVLNode<>(randneg40);var124.setHeight(0);var124.setBalanceFactor(0);
        AVLNode<Integer> var125 = null;
        var124.setLeft(var125);
        AVLNode<Integer> var126 = null;
        var124.setRight(var126);
        var122.setRight(var124);
        var116.setRight(var122);
        otherTree.setLeft(var116);
        AVLNode<Integer> var127 = new AVLNode<>(rand633);var127.setHeight(2);var127.setBalanceFactor(-1);
        AVLNode<Integer> var128 = new AVLNode<>(rand474);var128.setHeight(0);var128.setBalanceFactor(0);
        AVLNode<Integer> var129 = null;
        var128.setLeft(var129);
        AVLNode<Integer> var130 = null;
        var128.setRight(var130);
        var127.setLeft(var128);
        AVLNode<Integer> var131 = new AVLNode<>(rand950);var131.setHeight(1);var131.setBalanceFactor(1);
        AVLNode<Integer> var132 = new AVLNode<>(rand721);var132.setHeight(0);var132.setBalanceFactor(0);
        AVLNode<Integer> var133 = null;
        var132.setLeft(var133);
        AVLNode<Integer> var134 = null;
        var132.setRight(var134);
        var131.setLeft(var132);
        AVLNode<Integer> var135 = null;
        var131.setRight(var135);
        var127.setRight(var131);
        otherTree.setRight(var127);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer rand627 = new Integer(627);
        tree.add(rand627);

        // Validating last operation...
        otherTree = new AVLNode<>(rand394);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var136 = new AVLNode<>(randneg337);var136.setHeight(2);var136.setBalanceFactor(0);
        AVLNode<Integer> var137 = new AVLNode<>(randneg959);var137.setHeight(1);var137.setBalanceFactor(-1);
        AVLNode<Integer> var138 = null;
        var137.setLeft(var138);
        AVLNode<Integer> var139 = new AVLNode<>(randneg537);var139.setHeight(0);var139.setBalanceFactor(0);
        AVLNode<Integer> var140 = null;
        var139.setLeft(var140);
        AVLNode<Integer> var141 = null;
        var139.setRight(var141);
        var137.setRight(var139);
        var136.setLeft(var137);
        AVLNode<Integer> var142 = new AVLNode<>(randneg271);var142.setHeight(1);var142.setBalanceFactor(-1);
        AVLNode<Integer> var143 = null;
        var142.setLeft(var143);
        AVLNode<Integer> var144 = new AVLNode<>(randneg40);var144.setHeight(0);var144.setBalanceFactor(0);
        AVLNode<Integer> var145 = null;
        var144.setLeft(var145);
        AVLNode<Integer> var146 = null;
        var144.setRight(var146);
        var142.setRight(var144);
        var136.setRight(var142);
        otherTree.setLeft(var136);
        AVLNode<Integer> var147 = new AVLNode<>(rand633);var147.setHeight(2);var147.setBalanceFactor(0);
        AVLNode<Integer> var148 = new AVLNode<>(rand474);var148.setHeight(1);var148.setBalanceFactor(-1);
        AVLNode<Integer> var149 = null;
        var148.setLeft(var149);
        AVLNode<Integer> var150 = new AVLNode<>(rand627);var150.setHeight(0);var150.setBalanceFactor(0);
        AVLNode<Integer> var151 = null;
        var150.setLeft(var151);
        AVLNode<Integer> var152 = null;
        var150.setRight(var152);
        var148.setRight(var150);
        var147.setLeft(var148);
        AVLNode<Integer> var153 = new AVLNode<>(rand950);var153.setHeight(1);var153.setBalanceFactor(1);
        AVLNode<Integer> var154 = new AVLNode<>(rand721);var154.setHeight(0);var154.setBalanceFactor(0);
        AVLNode<Integer> var155 = null;
        var154.setLeft(var155);
        AVLNode<Integer> var156 = null;
        var154.setRight(var156);
        var153.setLeft(var154);
        AVLNode<Integer> var157 = null;
        var153.setRight(var157);
        var147.setRight(var153);
        otherTree.setRight(var147);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        assertSame(randneg537, tree.remove(randneg537.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand394);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var158 = new AVLNode<>(randneg337);var158.setHeight(2);var158.setBalanceFactor(-1);
        AVLNode<Integer> var159 = new AVLNode<>(randneg959);var159.setHeight(0);var159.setBalanceFactor(0);
        AVLNode<Integer> var160 = null;
        var159.setLeft(var160);
        AVLNode<Integer> var161 = null;
        var159.setRight(var161);
        var158.setLeft(var159);
        AVLNode<Integer> var162 = new AVLNode<>(randneg271);var162.setHeight(1);var162.setBalanceFactor(-1);
        AVLNode<Integer> var163 = null;
        var162.setLeft(var163);
        AVLNode<Integer> var164 = new AVLNode<>(randneg40);var164.setHeight(0);var164.setBalanceFactor(0);
        AVLNode<Integer> var165 = null;
        var164.setLeft(var165);
        AVLNode<Integer> var166 = null;
        var164.setRight(var166);
        var162.setRight(var164);
        var158.setRight(var162);
        otherTree.setLeft(var158);
        AVLNode<Integer> var167 = new AVLNode<>(rand633);var167.setHeight(2);var167.setBalanceFactor(0);
        AVLNode<Integer> var168 = new AVLNode<>(rand474);var168.setHeight(1);var168.setBalanceFactor(-1);
        AVLNode<Integer> var169 = null;
        var168.setLeft(var169);
        AVLNode<Integer> var170 = new AVLNode<>(rand627);var170.setHeight(0);var170.setBalanceFactor(0);
        AVLNode<Integer> var171 = null;
        var170.setLeft(var171);
        AVLNode<Integer> var172 = null;
        var170.setRight(var172);
        var168.setRight(var170);
        var167.setLeft(var168);
        AVLNode<Integer> var173 = new AVLNode<>(rand950);var173.setHeight(1);var173.setBalanceFactor(1);
        AVLNode<Integer> var174 = new AVLNode<>(rand721);var174.setHeight(0);var174.setBalanceFactor(0);
        AVLNode<Integer> var175 = null;
        var174.setLeft(var175);
        AVLNode<Integer> var176 = null;
        var174.setRight(var176);
        var173.setLeft(var174);
        AVLNode<Integer> var177 = null;
        var173.setRight(var177);
        var167.setRight(var173);
        otherTree.setRight(var167);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer rand273 = new Integer(273);
        tree.add(rand273);

        // Validating last operation...
        otherTree = new AVLNode<>(rand394);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var178 = new AVLNode<>(randneg337);var178.setHeight(2);var178.setBalanceFactor(-1);
        AVLNode<Integer> var179 = new AVLNode<>(randneg959);var179.setHeight(0);var179.setBalanceFactor(0);
        AVLNode<Integer> var180 = null;
        var179.setLeft(var180);
        AVLNode<Integer> var181 = null;
        var179.setRight(var181);
        var178.setLeft(var179);
        AVLNode<Integer> var182 = new AVLNode<>(randneg40);var182.setHeight(1);var182.setBalanceFactor(0);
        AVLNode<Integer> var183 = new AVLNode<>(randneg271);var183.setHeight(0);var183.setBalanceFactor(0);
        AVLNode<Integer> var184 = null;
        var183.setLeft(var184);
        AVLNode<Integer> var185 = null;
        var183.setRight(var185);
        var182.setLeft(var183);
        AVLNode<Integer> var186 = new AVLNode<>(rand273);var186.setHeight(0);var186.setBalanceFactor(0);
        AVLNode<Integer> var187 = null;
        var186.setLeft(var187);
        AVLNode<Integer> var188 = null;
        var186.setRight(var188);
        var182.setRight(var186);
        var178.setRight(var182);
        otherTree.setLeft(var178);
        AVLNode<Integer> var189 = new AVLNode<>(rand633);var189.setHeight(2);var189.setBalanceFactor(0);
        AVLNode<Integer> var190 = new AVLNode<>(rand474);var190.setHeight(1);var190.setBalanceFactor(-1);
        AVLNode<Integer> var191 = null;
        var190.setLeft(var191);
        AVLNode<Integer> var192 = new AVLNode<>(rand627);var192.setHeight(0);var192.setBalanceFactor(0);
        AVLNode<Integer> var193 = null;
        var192.setLeft(var193);
        AVLNode<Integer> var194 = null;
        var192.setRight(var194);
        var190.setRight(var192);
        var189.setLeft(var190);
        AVLNode<Integer> var195 = new AVLNode<>(rand950);var195.setHeight(1);var195.setBalanceFactor(1);
        AVLNode<Integer> var196 = new AVLNode<>(rand721);var196.setHeight(0);var196.setBalanceFactor(0);
        AVLNode<Integer> var197 = null;
        var196.setLeft(var197);
        AVLNode<Integer> var198 = null;
        var196.setRight(var198);
        var195.setLeft(var196);
        AVLNode<Integer> var199 = null;
        var195.setRight(var199);
        var189.setRight(var195);
        otherTree.setRight(var189);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #20: ==========
    @Test(timeout = TIMEOUT)
    public void test20() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg965 = new Integer(-965);
        tree.add(randneg965);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg965);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        assertSame(randneg965, tree.remove(randneg965.intValue()));

        // Validating last operation...
        otherTree = null;
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer randneg804 = new Integer(-804);
        tree.add(randneg804);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg804);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = null;
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer randneg393 = new Integer(-393);
        tree.add(randneg393);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg804);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var4 = null;
        otherTree.setLeft(var4);
        AVLNode<Integer> var5 = new AVLNode<>(randneg393);var5.setHeight(0);var5.setBalanceFactor(0);
        AVLNode<Integer> var6 = null;
        var5.setLeft(var6);
        AVLNode<Integer> var7 = null;
        var5.setRight(var7);
        otherTree.setRight(var5);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        assertSame(randneg393, tree.remove(randneg393.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg804);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var8 = null;
        otherTree.setLeft(var8);
        AVLNode<Integer> var9 = null;
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer randneg583 = new Integer(-583);
        tree.add(randneg583);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg804);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var10 = null;
        otherTree.setLeft(var10);
        AVLNode<Integer> var11 = new AVLNode<>(randneg583);var11.setHeight(0);var11.setBalanceFactor(0);
        AVLNode<Integer> var12 = null;
        var11.setLeft(var12);
        AVLNode<Integer> var13 = null;
        var11.setRight(var13);
        otherTree.setRight(var11);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer rand386 = new Integer(386);
        tree.add(rand386);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg583);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var14 = new AVLNode<>(randneg804);var14.setHeight(0);var14.setBalanceFactor(0);
        AVLNode<Integer> var15 = null;
        var14.setLeft(var15);
        AVLNode<Integer> var16 = null;
        var14.setRight(var16);
        otherTree.setLeft(var14);
        AVLNode<Integer> var17 = new AVLNode<>(rand386);var17.setHeight(0);var17.setBalanceFactor(0);
        AVLNode<Integer> var18 = null;
        var17.setLeft(var18);
        AVLNode<Integer> var19 = null;
        var17.setRight(var19);
        otherTree.setRight(var17);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        assertSame(rand386, tree.remove(rand386.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg583);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var20 = new AVLNode<>(randneg804);var20.setHeight(0);var20.setBalanceFactor(0);
        AVLNode<Integer> var21 = null;
        var20.setLeft(var21);
        AVLNode<Integer> var22 = null;
        var20.setRight(var22);
        otherTree.setLeft(var20);
        AVLNode<Integer> var23 = null;
        otherTree.setRight(var23);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer rand40 = new Integer(40);
        tree.add(rand40);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg583);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var24 = new AVLNode<>(randneg804);var24.setHeight(0);var24.setBalanceFactor(0);
        AVLNode<Integer> var25 = null;
        var24.setLeft(var25);
        AVLNode<Integer> var26 = null;
        var24.setRight(var26);
        otherTree.setLeft(var24);
        AVLNode<Integer> var27 = new AVLNode<>(rand40);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        otherTree.setRight(var27);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer rand105 = new Integer(105);
        tree.add(rand105);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg583);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var30 = new AVLNode<>(randneg804);var30.setHeight(0);var30.setBalanceFactor(0);
        AVLNode<Integer> var31 = null;
        var30.setLeft(var31);
        AVLNode<Integer> var32 = null;
        var30.setRight(var32);
        otherTree.setLeft(var30);
        AVLNode<Integer> var33 = new AVLNode<>(rand40);var33.setHeight(1);var33.setBalanceFactor(-1);
        AVLNode<Integer> var34 = null;
        var33.setLeft(var34);
        AVLNode<Integer> var35 = new AVLNode<>(rand105);var35.setHeight(0);var35.setBalanceFactor(0);
        AVLNode<Integer> var36 = null;
        var35.setLeft(var36);
        AVLNode<Integer> var37 = null;
        var35.setRight(var37);
        var33.setRight(var35);
        otherTree.setRight(var33);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer rand821 = new Integer(821);
        tree.add(rand821);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg583);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var38 = new AVLNode<>(randneg804);var38.setHeight(0);var38.setBalanceFactor(0);
        AVLNode<Integer> var39 = null;
        var38.setLeft(var39);
        AVLNode<Integer> var40 = null;
        var38.setRight(var40);
        otherTree.setLeft(var38);
        AVLNode<Integer> var41 = new AVLNode<>(rand105);var41.setHeight(1);var41.setBalanceFactor(0);
        AVLNode<Integer> var42 = new AVLNode<>(rand40);var42.setHeight(0);var42.setBalanceFactor(0);
        AVLNode<Integer> var43 = null;
        var42.setLeft(var43);
        AVLNode<Integer> var44 = null;
        var42.setRight(var44);
        var41.setLeft(var42);
        AVLNode<Integer> var45 = new AVLNode<>(rand821);var45.setHeight(0);var45.setBalanceFactor(0);
        AVLNode<Integer> var46 = null;
        var45.setLeft(var46);
        AVLNode<Integer> var47 = null;
        var45.setRight(var47);
        var41.setRight(var45);
        otherTree.setRight(var41);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer randneg408 = new Integer(-408);
        tree.add(randneg408);

        // Validating last operation...
        otherTree = new AVLNode<>(rand40);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var48 = new AVLNode<>(randneg583);var48.setHeight(1);var48.setBalanceFactor(0);
        AVLNode<Integer> var49 = new AVLNode<>(randneg804);var49.setHeight(0);var49.setBalanceFactor(0);
        AVLNode<Integer> var50 = null;
        var49.setLeft(var50);
        AVLNode<Integer> var51 = null;
        var49.setRight(var51);
        var48.setLeft(var49);
        AVLNode<Integer> var52 = new AVLNode<>(randneg408);var52.setHeight(0);var52.setBalanceFactor(0);
        AVLNode<Integer> var53 = null;
        var52.setLeft(var53);
        AVLNode<Integer> var54 = null;
        var52.setRight(var54);
        var48.setRight(var52);
        otherTree.setLeft(var48);
        AVLNode<Integer> var55 = new AVLNode<>(rand105);var55.setHeight(1);var55.setBalanceFactor(-1);
        AVLNode<Integer> var56 = null;
        var55.setLeft(var56);
        AVLNode<Integer> var57 = new AVLNode<>(rand821);var57.setHeight(0);var57.setBalanceFactor(0);
        AVLNode<Integer> var58 = null;
        var57.setLeft(var58);
        AVLNode<Integer> var59 = null;
        var57.setRight(var59);
        var55.setRight(var57);
        otherTree.setRight(var55);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer rand51 = new Integer(51);
        tree.add(rand51);

        // Validating last operation...
        otherTree = new AVLNode<>(rand40);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var60 = new AVLNode<>(randneg583);var60.setHeight(1);var60.setBalanceFactor(0);
        AVLNode<Integer> var61 = new AVLNode<>(randneg804);var61.setHeight(0);var61.setBalanceFactor(0);
        AVLNode<Integer> var62 = null;
        var61.setLeft(var62);
        AVLNode<Integer> var63 = null;
        var61.setRight(var63);
        var60.setLeft(var61);
        AVLNode<Integer> var64 = new AVLNode<>(randneg408);var64.setHeight(0);var64.setBalanceFactor(0);
        AVLNode<Integer> var65 = null;
        var64.setLeft(var65);
        AVLNode<Integer> var66 = null;
        var64.setRight(var66);
        var60.setRight(var64);
        otherTree.setLeft(var60);
        AVLNode<Integer> var67 = new AVLNode<>(rand105);var67.setHeight(1);var67.setBalanceFactor(0);
        AVLNode<Integer> var68 = new AVLNode<>(rand51);var68.setHeight(0);var68.setBalanceFactor(0);
        AVLNode<Integer> var69 = null;
        var68.setLeft(var69);
        AVLNode<Integer> var70 = null;
        var68.setRight(var70);
        var67.setLeft(var68);
        AVLNode<Integer> var71 = new AVLNode<>(rand821);var71.setHeight(0);var71.setBalanceFactor(0);
        AVLNode<Integer> var72 = null;
        var71.setLeft(var72);
        AVLNode<Integer> var73 = null;
        var71.setRight(var73);
        var67.setRight(var71);
        otherTree.setRight(var67);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer rand180 = new Integer(180);
        tree.add(rand180);

        // Validating last operation...
        otherTree = new AVLNode<>(rand40);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var74 = new AVLNode<>(randneg583);var74.setHeight(1);var74.setBalanceFactor(0);
        AVLNode<Integer> var75 = new AVLNode<>(randneg804);var75.setHeight(0);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = null;
        var75.setLeft(var76);
        AVLNode<Integer> var77 = null;
        var75.setRight(var77);
        var74.setLeft(var75);
        AVLNode<Integer> var78 = new AVLNode<>(randneg408);var78.setHeight(0);var78.setBalanceFactor(0);
        AVLNode<Integer> var79 = null;
        var78.setLeft(var79);
        AVLNode<Integer> var80 = null;
        var78.setRight(var80);
        var74.setRight(var78);
        otherTree.setLeft(var74);
        AVLNode<Integer> var81 = new AVLNode<>(rand105);var81.setHeight(2);var81.setBalanceFactor(-1);
        AVLNode<Integer> var82 = new AVLNode<>(rand51);var82.setHeight(0);var82.setBalanceFactor(0);
        AVLNode<Integer> var83 = null;
        var82.setLeft(var83);
        AVLNode<Integer> var84 = null;
        var82.setRight(var84);
        var81.setLeft(var82);
        AVLNode<Integer> var85 = new AVLNode<>(rand821);var85.setHeight(1);var85.setBalanceFactor(1);
        AVLNode<Integer> var86 = new AVLNode<>(rand180);var86.setHeight(0);var86.setBalanceFactor(0);
        AVLNode<Integer> var87 = null;
        var86.setLeft(var87);
        AVLNode<Integer> var88 = null;
        var86.setRight(var88);
        var85.setLeft(var86);
        AVLNode<Integer> var89 = null;
        var85.setRight(var89);
        var81.setRight(var85);
        otherTree.setRight(var81);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer randneg140 = new Integer(-140);
        tree.add(randneg140);

        // Validating last operation...
        otherTree = new AVLNode<>(rand40);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var90 = new AVLNode<>(randneg583);var90.setHeight(2);var90.setBalanceFactor(-1);
        AVLNode<Integer> var91 = new AVLNode<>(randneg804);var91.setHeight(0);var91.setBalanceFactor(0);
        AVLNode<Integer> var92 = null;
        var91.setLeft(var92);
        AVLNode<Integer> var93 = null;
        var91.setRight(var93);
        var90.setLeft(var91);
        AVLNode<Integer> var94 = new AVLNode<>(randneg408);var94.setHeight(1);var94.setBalanceFactor(-1);
        AVLNode<Integer> var95 = null;
        var94.setLeft(var95);
        AVLNode<Integer> var96 = new AVLNode<>(randneg140);var96.setHeight(0);var96.setBalanceFactor(0);
        AVLNode<Integer> var97 = null;
        var96.setLeft(var97);
        AVLNode<Integer> var98 = null;
        var96.setRight(var98);
        var94.setRight(var96);
        var90.setRight(var94);
        otherTree.setLeft(var90);
        AVLNode<Integer> var99 = new AVLNode<>(rand105);var99.setHeight(2);var99.setBalanceFactor(-1);
        AVLNode<Integer> var100 = new AVLNode<>(rand51);var100.setHeight(0);var100.setBalanceFactor(0);
        AVLNode<Integer> var101 = null;
        var100.setLeft(var101);
        AVLNode<Integer> var102 = null;
        var100.setRight(var102);
        var99.setLeft(var100);
        AVLNode<Integer> var103 = new AVLNode<>(rand821);var103.setHeight(1);var103.setBalanceFactor(1);
        AVLNode<Integer> var104 = new AVLNode<>(rand180);var104.setHeight(0);var104.setBalanceFactor(0);
        AVLNode<Integer> var105 = null;
        var104.setLeft(var105);
        AVLNode<Integer> var106 = null;
        var104.setRight(var106);
        var103.setLeft(var104);
        AVLNode<Integer> var107 = null;
        var103.setRight(var107);
        var99.setRight(var103);
        otherTree.setRight(var99);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #21: ==========
    @Test(timeout = TIMEOUT)
    public void test21() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer rand161 = new Integer(161);
        tree.add(rand161);

        // Validating last operation...
        otherTree = new AVLNode<>(rand161);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer randneg871 = new Integer(-871);
        tree.add(randneg871);

        // Validating last operation...
        otherTree = new AVLNode<>(rand161);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var2 = new AVLNode<>(randneg871);var2.setHeight(0);var2.setBalanceFactor(0);
        AVLNode<Integer> var3 = null;
        var2.setLeft(var3);
        AVLNode<Integer> var4 = null;
        var2.setRight(var4);
        otherTree.setLeft(var2);
        AVLNode<Integer> var5 = null;
        otherTree.setRight(var5);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        assertSame(rand161, tree.remove(rand161.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg871);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = null;
        otherTree.setLeft(var6);
        AVLNode<Integer> var7 = null;
        otherTree.setRight(var7);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer randneg647 = new Integer(-647);
        tree.add(randneg647);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg871);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var8 = null;
        otherTree.setLeft(var8);
        AVLNode<Integer> var9 = new AVLNode<>(randneg647);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer randneg113 = new Integer(-113);
        tree.add(randneg113);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg647);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var12 = new AVLNode<>(randneg871);var12.setHeight(0);var12.setBalanceFactor(0);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = null;
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var15 = new AVLNode<>(randneg113);var15.setHeight(0);var15.setBalanceFactor(0);
        AVLNode<Integer> var16 = null;
        var15.setLeft(var16);
        AVLNode<Integer> var17 = null;
        var15.setRight(var17);
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer rand512 = new Integer(512);
        tree.add(rand512);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg647);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var18 = new AVLNode<>(randneg871);var18.setHeight(0);var18.setBalanceFactor(0);
        AVLNode<Integer> var19 = null;
        var18.setLeft(var19);
        AVLNode<Integer> var20 = null;
        var18.setRight(var20);
        otherTree.setLeft(var18);
        AVLNode<Integer> var21 = new AVLNode<>(randneg113);var21.setHeight(1);var21.setBalanceFactor(-1);
        AVLNode<Integer> var22 = null;
        var21.setLeft(var22);
        AVLNode<Integer> var23 = new AVLNode<>(rand512);var23.setHeight(0);var23.setBalanceFactor(0);
        AVLNode<Integer> var24 = null;
        var23.setLeft(var24);
        AVLNode<Integer> var25 = null;
        var23.setRight(var25);
        var21.setRight(var23);
        otherTree.setRight(var21);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer rand603 = new Integer(603);
        tree.add(rand603);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg647);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var26 = new AVLNode<>(randneg871);var26.setHeight(0);var26.setBalanceFactor(0);
        AVLNode<Integer> var27 = null;
        var26.setLeft(var27);
        AVLNode<Integer> var28 = null;
        var26.setRight(var28);
        otherTree.setLeft(var26);
        AVLNode<Integer> var29 = new AVLNode<>(rand512);var29.setHeight(1);var29.setBalanceFactor(0);
        AVLNode<Integer> var30 = new AVLNode<>(randneg113);var30.setHeight(0);var30.setBalanceFactor(0);
        AVLNode<Integer> var31 = null;
        var30.setLeft(var31);
        AVLNode<Integer> var32 = null;
        var30.setRight(var32);
        var29.setLeft(var30);
        AVLNode<Integer> var33 = new AVLNode<>(rand603);var33.setHeight(0);var33.setBalanceFactor(0);
        AVLNode<Integer> var34 = null;
        var33.setLeft(var34);
        AVLNode<Integer> var35 = null;
        var33.setRight(var35);
        var29.setRight(var33);
        otherTree.setRight(var29);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer randneg395 = new Integer(-395);
        tree.add(randneg395);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg113);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var36 = new AVLNode<>(randneg647);var36.setHeight(1);var36.setBalanceFactor(0);
        AVLNode<Integer> var37 = new AVLNode<>(randneg871);var37.setHeight(0);var37.setBalanceFactor(0);
        AVLNode<Integer> var38 = null;
        var37.setLeft(var38);
        AVLNode<Integer> var39 = null;
        var37.setRight(var39);
        var36.setLeft(var37);
        AVLNode<Integer> var40 = new AVLNode<>(randneg395);var40.setHeight(0);var40.setBalanceFactor(0);
        AVLNode<Integer> var41 = null;
        var40.setLeft(var41);
        AVLNode<Integer> var42 = null;
        var40.setRight(var42);
        var36.setRight(var40);
        otherTree.setLeft(var36);
        AVLNode<Integer> var43 = new AVLNode<>(rand512);var43.setHeight(1);var43.setBalanceFactor(-1);
        AVLNode<Integer> var44 = null;
        var43.setLeft(var44);
        AVLNode<Integer> var45 = new AVLNode<>(rand603);var45.setHeight(0);var45.setBalanceFactor(0);
        AVLNode<Integer> var46 = null;
        var45.setLeft(var46);
        AVLNode<Integer> var47 = null;
        var45.setRight(var47);
        var43.setRight(var45);
        otherTree.setRight(var43);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer rand227 = new Integer(227);
        tree.add(rand227);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg113);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var48 = new AVLNode<>(randneg647);var48.setHeight(1);var48.setBalanceFactor(0);
        AVLNode<Integer> var49 = new AVLNode<>(randneg871);var49.setHeight(0);var49.setBalanceFactor(0);
        AVLNode<Integer> var50 = null;
        var49.setLeft(var50);
        AVLNode<Integer> var51 = null;
        var49.setRight(var51);
        var48.setLeft(var49);
        AVLNode<Integer> var52 = new AVLNode<>(randneg395);var52.setHeight(0);var52.setBalanceFactor(0);
        AVLNode<Integer> var53 = null;
        var52.setLeft(var53);
        AVLNode<Integer> var54 = null;
        var52.setRight(var54);
        var48.setRight(var52);
        otherTree.setLeft(var48);
        AVLNode<Integer> var55 = new AVLNode<>(rand512);var55.setHeight(1);var55.setBalanceFactor(0);
        AVLNode<Integer> var56 = new AVLNode<>(rand227);var56.setHeight(0);var56.setBalanceFactor(0);
        AVLNode<Integer> var57 = null;
        var56.setLeft(var57);
        AVLNode<Integer> var58 = null;
        var56.setRight(var58);
        var55.setLeft(var56);
        AVLNode<Integer> var59 = new AVLNode<>(rand603);var59.setHeight(0);var59.setBalanceFactor(0);
        AVLNode<Integer> var60 = null;
        var59.setLeft(var60);
        AVLNode<Integer> var61 = null;
        var59.setRight(var61);
        var55.setRight(var59);
        otherTree.setRight(var55);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer rand410 = new Integer(410);
        tree.add(rand410);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg113);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var62 = new AVLNode<>(randneg647);var62.setHeight(1);var62.setBalanceFactor(0);
        AVLNode<Integer> var63 = new AVLNode<>(randneg871);var63.setHeight(0);var63.setBalanceFactor(0);
        AVLNode<Integer> var64 = null;
        var63.setLeft(var64);
        AVLNode<Integer> var65 = null;
        var63.setRight(var65);
        var62.setLeft(var63);
        AVLNode<Integer> var66 = new AVLNode<>(randneg395);var66.setHeight(0);var66.setBalanceFactor(0);
        AVLNode<Integer> var67 = null;
        var66.setLeft(var67);
        AVLNode<Integer> var68 = null;
        var66.setRight(var68);
        var62.setRight(var66);
        otherTree.setLeft(var62);
        AVLNode<Integer> var69 = new AVLNode<>(rand512);var69.setHeight(2);var69.setBalanceFactor(1);
        AVLNode<Integer> var70 = new AVLNode<>(rand227);var70.setHeight(1);var70.setBalanceFactor(-1);
        AVLNode<Integer> var71 = null;
        var70.setLeft(var71);
        AVLNode<Integer> var72 = new AVLNode<>(rand410);var72.setHeight(0);var72.setBalanceFactor(0);
        AVLNode<Integer> var73 = null;
        var72.setLeft(var73);
        AVLNode<Integer> var74 = null;
        var72.setRight(var74);
        var70.setRight(var72);
        var69.setLeft(var70);
        AVLNode<Integer> var75 = new AVLNode<>(rand603);var75.setHeight(0);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = null;
        var75.setLeft(var76);
        AVLNode<Integer> var77 = null;
        var75.setRight(var77);
        var69.setRight(var75);
        otherTree.setRight(var69);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer randneg723 = new Integer(-723);
        tree.add(randneg723);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg113);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var78 = new AVLNode<>(randneg647);var78.setHeight(2);var78.setBalanceFactor(1);
        AVLNode<Integer> var79 = new AVLNode<>(randneg871);var79.setHeight(1);var79.setBalanceFactor(-1);
        AVLNode<Integer> var80 = null;
        var79.setLeft(var80);
        AVLNode<Integer> var81 = new AVLNode<>(randneg723);var81.setHeight(0);var81.setBalanceFactor(0);
        AVLNode<Integer> var82 = null;
        var81.setLeft(var82);
        AVLNode<Integer> var83 = null;
        var81.setRight(var83);
        var79.setRight(var81);
        var78.setLeft(var79);
        AVLNode<Integer> var84 = new AVLNode<>(randneg395);var84.setHeight(0);var84.setBalanceFactor(0);
        AVLNode<Integer> var85 = null;
        var84.setLeft(var85);
        AVLNode<Integer> var86 = null;
        var84.setRight(var86);
        var78.setRight(var84);
        otherTree.setLeft(var78);
        AVLNode<Integer> var87 = new AVLNode<>(rand512);var87.setHeight(2);var87.setBalanceFactor(1);
        AVLNode<Integer> var88 = new AVLNode<>(rand227);var88.setHeight(1);var88.setBalanceFactor(-1);
        AVLNode<Integer> var89 = null;
        var88.setLeft(var89);
        AVLNode<Integer> var90 = new AVLNode<>(rand410);var90.setHeight(0);var90.setBalanceFactor(0);
        AVLNode<Integer> var91 = null;
        var90.setLeft(var91);
        AVLNode<Integer> var92 = null;
        var90.setRight(var92);
        var88.setRight(var90);
        var87.setLeft(var88);
        AVLNode<Integer> var93 = new AVLNode<>(rand603);var93.setHeight(0);var93.setBalanceFactor(0);
        AVLNode<Integer> var94 = null;
        var93.setLeft(var94);
        AVLNode<Integer> var95 = null;
        var93.setRight(var95);
        var87.setRight(var93);
        otherTree.setRight(var87);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer rand574 = new Integer(574);
        tree.add(rand574);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg113);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var96 = new AVLNode<>(randneg647);var96.setHeight(2);var96.setBalanceFactor(1);
        AVLNode<Integer> var97 = new AVLNode<>(randneg871);var97.setHeight(1);var97.setBalanceFactor(-1);
        AVLNode<Integer> var98 = null;
        var97.setLeft(var98);
        AVLNode<Integer> var99 = new AVLNode<>(randneg723);var99.setHeight(0);var99.setBalanceFactor(0);
        AVLNode<Integer> var100 = null;
        var99.setLeft(var100);
        AVLNode<Integer> var101 = null;
        var99.setRight(var101);
        var97.setRight(var99);
        var96.setLeft(var97);
        AVLNode<Integer> var102 = new AVLNode<>(randneg395);var102.setHeight(0);var102.setBalanceFactor(0);
        AVLNode<Integer> var103 = null;
        var102.setLeft(var103);
        AVLNode<Integer> var104 = null;
        var102.setRight(var104);
        var96.setRight(var102);
        otherTree.setLeft(var96);
        AVLNode<Integer> var105 = new AVLNode<>(rand512);var105.setHeight(2);var105.setBalanceFactor(0);
        AVLNode<Integer> var106 = new AVLNode<>(rand227);var106.setHeight(1);var106.setBalanceFactor(-1);
        AVLNode<Integer> var107 = null;
        var106.setLeft(var107);
        AVLNode<Integer> var108 = new AVLNode<>(rand410);var108.setHeight(0);var108.setBalanceFactor(0);
        AVLNode<Integer> var109 = null;
        var108.setLeft(var109);
        AVLNode<Integer> var110 = null;
        var108.setRight(var110);
        var106.setRight(var108);
        var105.setLeft(var106);
        AVLNode<Integer> var111 = new AVLNode<>(rand603);var111.setHeight(1);var111.setBalanceFactor(1);
        AVLNode<Integer> var112 = new AVLNode<>(rand574);var112.setHeight(0);var112.setBalanceFactor(0);
        AVLNode<Integer> var113 = null;
        var112.setLeft(var113);
        AVLNode<Integer> var114 = null;
        var112.setRight(var114);
        var111.setLeft(var112);
        AVLNode<Integer> var115 = null;
        var111.setRight(var115);
        var105.setRight(var111);
        otherTree.setRight(var105);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        assertSame(randneg723, tree.remove(randneg723.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg113);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var116 = new AVLNode<>(randneg647);var116.setHeight(1);var116.setBalanceFactor(0);
        AVLNode<Integer> var117 = new AVLNode<>(randneg871);var117.setHeight(0);var117.setBalanceFactor(0);
        AVLNode<Integer> var118 = null;
        var117.setLeft(var118);
        AVLNode<Integer> var119 = null;
        var117.setRight(var119);
        var116.setLeft(var117);
        AVLNode<Integer> var120 = new AVLNode<>(randneg395);var120.setHeight(0);var120.setBalanceFactor(0);
        AVLNode<Integer> var121 = null;
        var120.setLeft(var121);
        AVLNode<Integer> var122 = null;
        var120.setRight(var122);
        var116.setRight(var120);
        otherTree.setLeft(var116);
        AVLNode<Integer> var123 = new AVLNode<>(rand512);var123.setHeight(2);var123.setBalanceFactor(0);
        AVLNode<Integer> var124 = new AVLNode<>(rand227);var124.setHeight(1);var124.setBalanceFactor(-1);
        AVLNode<Integer> var125 = null;
        var124.setLeft(var125);
        AVLNode<Integer> var126 = new AVLNode<>(rand410);var126.setHeight(0);var126.setBalanceFactor(0);
        AVLNode<Integer> var127 = null;
        var126.setLeft(var127);
        AVLNode<Integer> var128 = null;
        var126.setRight(var128);
        var124.setRight(var126);
        var123.setLeft(var124);
        AVLNode<Integer> var129 = new AVLNode<>(rand603);var129.setHeight(1);var129.setBalanceFactor(1);
        AVLNode<Integer> var130 = new AVLNode<>(rand574);var130.setHeight(0);var130.setBalanceFactor(0);
        AVLNode<Integer> var131 = null;
        var130.setLeft(var131);
        AVLNode<Integer> var132 = null;
        var130.setRight(var132);
        var129.setLeft(var130);
        AVLNode<Integer> var133 = null;
        var129.setRight(var133);
        var123.setRight(var129);
        otherTree.setRight(var123);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer randneg230 = new Integer(-230);
        tree.add(randneg230);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg113);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var134 = new AVLNode<>(randneg647);var134.setHeight(2);var134.setBalanceFactor(-1);
        AVLNode<Integer> var135 = new AVLNode<>(randneg871);var135.setHeight(0);var135.setBalanceFactor(0);
        AVLNode<Integer> var136 = null;
        var135.setLeft(var136);
        AVLNode<Integer> var137 = null;
        var135.setRight(var137);
        var134.setLeft(var135);
        AVLNode<Integer> var138 = new AVLNode<>(randneg395);var138.setHeight(1);var138.setBalanceFactor(-1);
        AVLNode<Integer> var139 = null;
        var138.setLeft(var139);
        AVLNode<Integer> var140 = new AVLNode<>(randneg230);var140.setHeight(0);var140.setBalanceFactor(0);
        AVLNode<Integer> var141 = null;
        var140.setLeft(var141);
        AVLNode<Integer> var142 = null;
        var140.setRight(var142);
        var138.setRight(var140);
        var134.setRight(var138);
        otherTree.setLeft(var134);
        AVLNode<Integer> var143 = new AVLNode<>(rand512);var143.setHeight(2);var143.setBalanceFactor(0);
        AVLNode<Integer> var144 = new AVLNode<>(rand227);var144.setHeight(1);var144.setBalanceFactor(-1);
        AVLNode<Integer> var145 = null;
        var144.setLeft(var145);
        AVLNode<Integer> var146 = new AVLNode<>(rand410);var146.setHeight(0);var146.setBalanceFactor(0);
        AVLNode<Integer> var147 = null;
        var146.setLeft(var147);
        AVLNode<Integer> var148 = null;
        var146.setRight(var148);
        var144.setRight(var146);
        var143.setLeft(var144);
        AVLNode<Integer> var149 = new AVLNode<>(rand603);var149.setHeight(1);var149.setBalanceFactor(1);
        AVLNode<Integer> var150 = new AVLNode<>(rand574);var150.setHeight(0);var150.setBalanceFactor(0);
        AVLNode<Integer> var151 = null;
        var150.setLeft(var151);
        AVLNode<Integer> var152 = null;
        var150.setRight(var152);
        var149.setLeft(var150);
        AVLNode<Integer> var153 = null;
        var149.setRight(var153);
        var143.setRight(var149);
        otherTree.setRight(var143);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer randneg489 = new Integer(-489);
        tree.add(randneg489);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg113);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var154 = new AVLNode<>(randneg647);var154.setHeight(2);var154.setBalanceFactor(-1);
        AVLNode<Integer> var155 = new AVLNode<>(randneg871);var155.setHeight(0);var155.setBalanceFactor(0);
        AVLNode<Integer> var156 = null;
        var155.setLeft(var156);
        AVLNode<Integer> var157 = null;
        var155.setRight(var157);
        var154.setLeft(var155);
        AVLNode<Integer> var158 = new AVLNode<>(randneg395);var158.setHeight(1);var158.setBalanceFactor(0);
        AVLNode<Integer> var159 = new AVLNode<>(randneg489);var159.setHeight(0);var159.setBalanceFactor(0);
        AVLNode<Integer> var160 = null;
        var159.setLeft(var160);
        AVLNode<Integer> var161 = null;
        var159.setRight(var161);
        var158.setLeft(var159);
        AVLNode<Integer> var162 = new AVLNode<>(randneg230);var162.setHeight(0);var162.setBalanceFactor(0);
        AVLNode<Integer> var163 = null;
        var162.setLeft(var163);
        AVLNode<Integer> var164 = null;
        var162.setRight(var164);
        var158.setRight(var162);
        var154.setRight(var158);
        otherTree.setLeft(var154);
        AVLNode<Integer> var165 = new AVLNode<>(rand512);var165.setHeight(2);var165.setBalanceFactor(0);
        AVLNode<Integer> var166 = new AVLNode<>(rand227);var166.setHeight(1);var166.setBalanceFactor(-1);
        AVLNode<Integer> var167 = null;
        var166.setLeft(var167);
        AVLNode<Integer> var168 = new AVLNode<>(rand410);var168.setHeight(0);var168.setBalanceFactor(0);
        AVLNode<Integer> var169 = null;
        var168.setLeft(var169);
        AVLNode<Integer> var170 = null;
        var168.setRight(var170);
        var166.setRight(var168);
        var165.setLeft(var166);
        AVLNode<Integer> var171 = new AVLNode<>(rand603);var171.setHeight(1);var171.setBalanceFactor(1);
        AVLNode<Integer> var172 = new AVLNode<>(rand574);var172.setHeight(0);var172.setBalanceFactor(0);
        AVLNode<Integer> var173 = null;
        var172.setLeft(var173);
        AVLNode<Integer> var174 = null;
        var172.setRight(var174);
        var171.setLeft(var172);
        AVLNode<Integer> var175 = null;
        var171.setRight(var175);
        var165.setRight(var171);
        otherTree.setRight(var165);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #22: ==========
    @Test(timeout = TIMEOUT)
    public void test22() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer rand120 = new Integer(120);
        tree.add(rand120);

        // Validating last operation...
        otherTree = new AVLNode<>(rand120);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer randneg966 = new Integer(-966);
        tree.add(randneg966);

        // Validating last operation...
        otherTree = new AVLNode<>(rand120);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var2 = new AVLNode<>(randneg966);var2.setHeight(0);var2.setBalanceFactor(0);
        AVLNode<Integer> var3 = null;
        var2.setLeft(var3);
        AVLNode<Integer> var4 = null;
        var2.setRight(var4);
        otherTree.setLeft(var2);
        AVLNode<Integer> var5 = null;
        otherTree.setRight(var5);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer randneg971 = new Integer(-971);
        tree.add(randneg971);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg966);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(randneg971);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(rand120);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer rand704 = new Integer(704);
        tree.add(rand704);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg966);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var12 = new AVLNode<>(randneg971);var12.setHeight(0);var12.setBalanceFactor(0);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = null;
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var15 = new AVLNode<>(rand120);var15.setHeight(1);var15.setBalanceFactor(-1);
        AVLNode<Integer> var16 = null;
        var15.setLeft(var16);
        AVLNode<Integer> var17 = new AVLNode<>(rand704);var17.setHeight(0);var17.setBalanceFactor(0);
        AVLNode<Integer> var18 = null;
        var17.setLeft(var18);
        AVLNode<Integer> var19 = null;
        var17.setRight(var19);
        var15.setRight(var17);
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer randneg165 = new Integer(-165);
        tree.add(randneg165);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg966);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var20 = new AVLNode<>(randneg971);var20.setHeight(0);var20.setBalanceFactor(0);
        AVLNode<Integer> var21 = null;
        var20.setLeft(var21);
        AVLNode<Integer> var22 = null;
        var20.setRight(var22);
        otherTree.setLeft(var20);
        AVLNode<Integer> var23 = new AVLNode<>(rand120);var23.setHeight(1);var23.setBalanceFactor(0);
        AVLNode<Integer> var24 = new AVLNode<>(randneg165);var24.setHeight(0);var24.setBalanceFactor(0);
        AVLNode<Integer> var25 = null;
        var24.setLeft(var25);
        AVLNode<Integer> var26 = null;
        var24.setRight(var26);
        var23.setLeft(var24);
        AVLNode<Integer> var27 = new AVLNode<>(rand704);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        var23.setRight(var27);
        otherTree.setRight(var23);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer randneg407 = new Integer(-407);
        tree.add(randneg407);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg165);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var30 = new AVLNode<>(randneg966);var30.setHeight(1);var30.setBalanceFactor(0);
        AVLNode<Integer> var31 = new AVLNode<>(randneg971);var31.setHeight(0);var31.setBalanceFactor(0);
        AVLNode<Integer> var32 = null;
        var31.setLeft(var32);
        AVLNode<Integer> var33 = null;
        var31.setRight(var33);
        var30.setLeft(var31);
        AVLNode<Integer> var34 = new AVLNode<>(randneg407);var34.setHeight(0);var34.setBalanceFactor(0);
        AVLNode<Integer> var35 = null;
        var34.setLeft(var35);
        AVLNode<Integer> var36 = null;
        var34.setRight(var36);
        var30.setRight(var34);
        otherTree.setLeft(var30);
        AVLNode<Integer> var37 = new AVLNode<>(rand120);var37.setHeight(1);var37.setBalanceFactor(-1);
        AVLNode<Integer> var38 = null;
        var37.setLeft(var38);
        AVLNode<Integer> var39 = new AVLNode<>(rand704);var39.setHeight(0);var39.setBalanceFactor(0);
        AVLNode<Integer> var40 = null;
        var39.setLeft(var40);
        AVLNode<Integer> var41 = null;
        var39.setRight(var41);
        var37.setRight(var39);
        otherTree.setRight(var37);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer rand385 = new Integer(385);
        tree.add(rand385);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg165);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var42 = new AVLNode<>(randneg966);var42.setHeight(1);var42.setBalanceFactor(0);
        AVLNode<Integer> var43 = new AVLNode<>(randneg971);var43.setHeight(0);var43.setBalanceFactor(0);
        AVLNode<Integer> var44 = null;
        var43.setLeft(var44);
        AVLNode<Integer> var45 = null;
        var43.setRight(var45);
        var42.setLeft(var43);
        AVLNode<Integer> var46 = new AVLNode<>(randneg407);var46.setHeight(0);var46.setBalanceFactor(0);
        AVLNode<Integer> var47 = null;
        var46.setLeft(var47);
        AVLNode<Integer> var48 = null;
        var46.setRight(var48);
        var42.setRight(var46);
        otherTree.setLeft(var42);
        AVLNode<Integer> var49 = new AVLNode<>(rand385);var49.setHeight(1);var49.setBalanceFactor(0);
        AVLNode<Integer> var50 = new AVLNode<>(rand120);var50.setHeight(0);var50.setBalanceFactor(0);
        AVLNode<Integer> var51 = null;
        var50.setLeft(var51);
        AVLNode<Integer> var52 = null;
        var50.setRight(var52);
        var49.setLeft(var50);
        AVLNode<Integer> var53 = new AVLNode<>(rand704);var53.setHeight(0);var53.setBalanceFactor(0);
        AVLNode<Integer> var54 = null;
        var53.setLeft(var54);
        AVLNode<Integer> var55 = null;
        var53.setRight(var55);
        var49.setRight(var53);
        otherTree.setRight(var49);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        assertSame(randneg971, tree.remove(randneg971.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg165);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var56 = new AVLNode<>(randneg966);var56.setHeight(1);var56.setBalanceFactor(-1);
        AVLNode<Integer> var57 = null;
        var56.setLeft(var57);
        AVLNode<Integer> var58 = new AVLNode<>(randneg407);var58.setHeight(0);var58.setBalanceFactor(0);
        AVLNode<Integer> var59 = null;
        var58.setLeft(var59);
        AVLNode<Integer> var60 = null;
        var58.setRight(var60);
        var56.setRight(var58);
        otherTree.setLeft(var56);
        AVLNode<Integer> var61 = new AVLNode<>(rand385);var61.setHeight(1);var61.setBalanceFactor(0);
        AVLNode<Integer> var62 = new AVLNode<>(rand120);var62.setHeight(0);var62.setBalanceFactor(0);
        AVLNode<Integer> var63 = null;
        var62.setLeft(var63);
        AVLNode<Integer> var64 = null;
        var62.setRight(var64);
        var61.setLeft(var62);
        AVLNode<Integer> var65 = new AVLNode<>(rand704);var65.setHeight(0);var65.setBalanceFactor(0);
        AVLNode<Integer> var66 = null;
        var65.setLeft(var66);
        AVLNode<Integer> var67 = null;
        var65.setRight(var67);
        var61.setRight(var65);
        otherTree.setRight(var61);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer randneg827 = new Integer(-827);
        tree.add(randneg827);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg165);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var68 = new AVLNode<>(randneg827);var68.setHeight(1);var68.setBalanceFactor(0);
        AVLNode<Integer> var69 = new AVLNode<>(randneg966);var69.setHeight(0);var69.setBalanceFactor(0);
        AVLNode<Integer> var70 = null;
        var69.setLeft(var70);
        AVLNode<Integer> var71 = null;
        var69.setRight(var71);
        var68.setLeft(var69);
        AVLNode<Integer> var72 = new AVLNode<>(randneg407);var72.setHeight(0);var72.setBalanceFactor(0);
        AVLNode<Integer> var73 = null;
        var72.setLeft(var73);
        AVLNode<Integer> var74 = null;
        var72.setRight(var74);
        var68.setRight(var72);
        otherTree.setLeft(var68);
        AVLNode<Integer> var75 = new AVLNode<>(rand385);var75.setHeight(1);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = new AVLNode<>(rand120);var76.setHeight(0);var76.setBalanceFactor(0);
        AVLNode<Integer> var77 = null;
        var76.setLeft(var77);
        AVLNode<Integer> var78 = null;
        var76.setRight(var78);
        var75.setLeft(var76);
        AVLNode<Integer> var79 = new AVLNode<>(rand704);var79.setHeight(0);var79.setBalanceFactor(0);
        AVLNode<Integer> var80 = null;
        var79.setLeft(var80);
        AVLNode<Integer> var81 = null;
        var79.setRight(var81);
        var75.setRight(var79);
        otherTree.setRight(var75);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer rand565 = new Integer(565);
        tree.add(rand565);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg165);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var82 = new AVLNode<>(randneg827);var82.setHeight(1);var82.setBalanceFactor(0);
        AVLNode<Integer> var83 = new AVLNode<>(randneg966);var83.setHeight(0);var83.setBalanceFactor(0);
        AVLNode<Integer> var84 = null;
        var83.setLeft(var84);
        AVLNode<Integer> var85 = null;
        var83.setRight(var85);
        var82.setLeft(var83);
        AVLNode<Integer> var86 = new AVLNode<>(randneg407);var86.setHeight(0);var86.setBalanceFactor(0);
        AVLNode<Integer> var87 = null;
        var86.setLeft(var87);
        AVLNode<Integer> var88 = null;
        var86.setRight(var88);
        var82.setRight(var86);
        otherTree.setLeft(var82);
        AVLNode<Integer> var89 = new AVLNode<>(rand385);var89.setHeight(2);var89.setBalanceFactor(-1);
        AVLNode<Integer> var90 = new AVLNode<>(rand120);var90.setHeight(0);var90.setBalanceFactor(0);
        AVLNode<Integer> var91 = null;
        var90.setLeft(var91);
        AVLNode<Integer> var92 = null;
        var90.setRight(var92);
        var89.setLeft(var90);
        AVLNode<Integer> var93 = new AVLNode<>(rand704);var93.setHeight(1);var93.setBalanceFactor(1);
        AVLNode<Integer> var94 = new AVLNode<>(rand565);var94.setHeight(0);var94.setBalanceFactor(0);
        AVLNode<Integer> var95 = null;
        var94.setLeft(var95);
        AVLNode<Integer> var96 = null;
        var94.setRight(var96);
        var93.setLeft(var94);
        AVLNode<Integer> var97 = null;
        var93.setRight(var97);
        var89.setRight(var93);
        otherTree.setRight(var89);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer randneg667 = new Integer(-667);
        tree.add(randneg667);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg165);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var98 = new AVLNode<>(randneg827);var98.setHeight(2);var98.setBalanceFactor(-1);
        AVLNode<Integer> var99 = new AVLNode<>(randneg966);var99.setHeight(0);var99.setBalanceFactor(0);
        AVLNode<Integer> var100 = null;
        var99.setLeft(var100);
        AVLNode<Integer> var101 = null;
        var99.setRight(var101);
        var98.setLeft(var99);
        AVLNode<Integer> var102 = new AVLNode<>(randneg407);var102.setHeight(1);var102.setBalanceFactor(1);
        AVLNode<Integer> var103 = new AVLNode<>(randneg667);var103.setHeight(0);var103.setBalanceFactor(0);
        AVLNode<Integer> var104 = null;
        var103.setLeft(var104);
        AVLNode<Integer> var105 = null;
        var103.setRight(var105);
        var102.setLeft(var103);
        AVLNode<Integer> var106 = null;
        var102.setRight(var106);
        var98.setRight(var102);
        otherTree.setLeft(var98);
        AVLNode<Integer> var107 = new AVLNode<>(rand385);var107.setHeight(2);var107.setBalanceFactor(-1);
        AVLNode<Integer> var108 = new AVLNode<>(rand120);var108.setHeight(0);var108.setBalanceFactor(0);
        AVLNode<Integer> var109 = null;
        var108.setLeft(var109);
        AVLNode<Integer> var110 = null;
        var108.setRight(var110);
        var107.setLeft(var108);
        AVLNode<Integer> var111 = new AVLNode<>(rand704);var111.setHeight(1);var111.setBalanceFactor(1);
        AVLNode<Integer> var112 = new AVLNode<>(rand565);var112.setHeight(0);var112.setBalanceFactor(0);
        AVLNode<Integer> var113 = null;
        var112.setLeft(var113);
        AVLNode<Integer> var114 = null;
        var112.setRight(var114);
        var111.setLeft(var112);
        AVLNode<Integer> var115 = null;
        var111.setRight(var115);
        var107.setRight(var111);
        otherTree.setRight(var107);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        assertSame(randneg165, tree.remove(randneg165.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg407);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var116 = new AVLNode<>(randneg827);var116.setHeight(1);var116.setBalanceFactor(0);
        AVLNode<Integer> var117 = new AVLNode<>(randneg966);var117.setHeight(0);var117.setBalanceFactor(0);
        AVLNode<Integer> var118 = null;
        var117.setLeft(var118);
        AVLNode<Integer> var119 = null;
        var117.setRight(var119);
        var116.setLeft(var117);
        AVLNode<Integer> var120 = new AVLNode<>(randneg667);var120.setHeight(0);var120.setBalanceFactor(0);
        AVLNode<Integer> var121 = null;
        var120.setLeft(var121);
        AVLNode<Integer> var122 = null;
        var120.setRight(var122);
        var116.setRight(var120);
        otherTree.setLeft(var116);
        AVLNode<Integer> var123 = new AVLNode<>(rand385);var123.setHeight(2);var123.setBalanceFactor(-1);
        AVLNode<Integer> var124 = new AVLNode<>(rand120);var124.setHeight(0);var124.setBalanceFactor(0);
        AVLNode<Integer> var125 = null;
        var124.setLeft(var125);
        AVLNode<Integer> var126 = null;
        var124.setRight(var126);
        var123.setLeft(var124);
        AVLNode<Integer> var127 = new AVLNode<>(rand704);var127.setHeight(1);var127.setBalanceFactor(1);
        AVLNode<Integer> var128 = new AVLNode<>(rand565);var128.setHeight(0);var128.setBalanceFactor(0);
        AVLNode<Integer> var129 = null;
        var128.setLeft(var129);
        AVLNode<Integer> var130 = null;
        var128.setRight(var130);
        var127.setLeft(var128);
        AVLNode<Integer> var131 = null;
        var127.setRight(var131);
        var123.setRight(var127);
        otherTree.setRight(var123);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        assertSame(randneg827, tree.remove(randneg827.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg407);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var132 = new AVLNode<>(randneg966);var132.setHeight(1);var132.setBalanceFactor(-1);
        AVLNode<Integer> var133 = null;
        var132.setLeft(var133);
        AVLNode<Integer> var134 = new AVLNode<>(randneg667);var134.setHeight(0);var134.setBalanceFactor(0);
        AVLNode<Integer> var135 = null;
        var134.setLeft(var135);
        AVLNode<Integer> var136 = null;
        var134.setRight(var136);
        var132.setRight(var134);
        otherTree.setLeft(var132);
        AVLNode<Integer> var137 = new AVLNode<>(rand385);var137.setHeight(2);var137.setBalanceFactor(-1);
        AVLNode<Integer> var138 = new AVLNode<>(rand120);var138.setHeight(0);var138.setBalanceFactor(0);
        AVLNode<Integer> var139 = null;
        var138.setLeft(var139);
        AVLNode<Integer> var140 = null;
        var138.setRight(var140);
        var137.setLeft(var138);
        AVLNode<Integer> var141 = new AVLNode<>(rand704);var141.setHeight(1);var141.setBalanceFactor(1);
        AVLNode<Integer> var142 = new AVLNode<>(rand565);var142.setHeight(0);var142.setBalanceFactor(0);
        AVLNode<Integer> var143 = null;
        var142.setLeft(var143);
        AVLNode<Integer> var144 = null;
        var142.setRight(var144);
        var141.setLeft(var142);
        AVLNode<Integer> var145 = null;
        var141.setRight(var145);
        var137.setRight(var141);
        otherTree.setRight(var137);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        assertSame(rand385, tree.remove(rand385.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg407);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var146 = new AVLNode<>(randneg966);var146.setHeight(1);var146.setBalanceFactor(-1);
        AVLNode<Integer> var147 = null;
        var146.setLeft(var147);
        AVLNode<Integer> var148 = new AVLNode<>(randneg667);var148.setHeight(0);var148.setBalanceFactor(0);
        AVLNode<Integer> var149 = null;
        var148.setLeft(var149);
        AVLNode<Integer> var150 = null;
        var148.setRight(var150);
        var146.setRight(var148);
        otherTree.setLeft(var146);
        AVLNode<Integer> var151 = new AVLNode<>(rand565);var151.setHeight(1);var151.setBalanceFactor(0);
        AVLNode<Integer> var152 = new AVLNode<>(rand120);var152.setHeight(0);var152.setBalanceFactor(0);
        AVLNode<Integer> var153 = null;
        var152.setLeft(var153);
        AVLNode<Integer> var154 = null;
        var152.setRight(var154);
        var151.setLeft(var152);
        AVLNode<Integer> var155 = new AVLNode<>(rand704);var155.setHeight(0);var155.setBalanceFactor(0);
        AVLNode<Integer> var156 = null;
        var155.setLeft(var156);
        AVLNode<Integer> var157 = null;
        var155.setRight(var157);
        var151.setRight(var155);
        otherTree.setRight(var151);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        assertSame(randneg966, tree.remove(randneg966.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg407);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var158 = new AVLNode<>(randneg667);var158.setHeight(0);var158.setBalanceFactor(0);
        AVLNode<Integer> var159 = null;
        var158.setLeft(var159);
        AVLNode<Integer> var160 = null;
        var158.setRight(var160);
        otherTree.setLeft(var158);
        AVLNode<Integer> var161 = new AVLNode<>(rand565);var161.setHeight(1);var161.setBalanceFactor(0);
        AVLNode<Integer> var162 = new AVLNode<>(rand120);var162.setHeight(0);var162.setBalanceFactor(0);
        AVLNode<Integer> var163 = null;
        var162.setLeft(var163);
        AVLNode<Integer> var164 = null;
        var162.setRight(var164);
        var161.setLeft(var162);
        AVLNode<Integer> var165 = new AVLNode<>(rand704);var165.setHeight(0);var165.setBalanceFactor(0);
        AVLNode<Integer> var166 = null;
        var165.setLeft(var166);
        AVLNode<Integer> var167 = null;
        var165.setRight(var167);
        var161.setRight(var165);
        otherTree.setRight(var161);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #23: ==========
    @Test(timeout = TIMEOUT)
    public void test23() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer rand419 = new Integer(419);
        tree.add(rand419);

        // Validating last operation...
        otherTree = new AVLNode<>(rand419);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        assertSame(rand419, tree.remove(rand419.intValue()));

        // Validating last operation...
        otherTree = null;
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer randneg163 = new Integer(-163);
        tree.add(randneg163);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg163);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = null;
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        assertSame(randneg163, tree.remove(randneg163.intValue()));

        // Validating last operation...
        otherTree = null;
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer randneg292 = new Integer(-292);
        tree.add(randneg292);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg292);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var4 = null;
        otherTree.setLeft(var4);
        AVLNode<Integer> var5 = null;
        otherTree.setRight(var5);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        assertSame(randneg292, tree.remove(randneg292.intValue()));

        // Validating last operation...
        otherTree = null;
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer randneg155 = new Integer(-155);
        tree.add(randneg155);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg155);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = null;
        otherTree.setLeft(var6);
        AVLNode<Integer> var7 = null;
        otherTree.setRight(var7);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer rand551 = new Integer(551);
        tree.add(rand551);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg155);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var8 = null;
        otherTree.setLeft(var8);
        AVLNode<Integer> var9 = new AVLNode<>(rand551);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer randneg825 = new Integer(-825);
        tree.add(randneg825);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg155);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var12 = new AVLNode<>(randneg825);var12.setHeight(0);var12.setBalanceFactor(0);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = null;
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var15 = new AVLNode<>(rand551);var15.setHeight(0);var15.setBalanceFactor(0);
        AVLNode<Integer> var16 = null;
        var15.setLeft(var16);
        AVLNode<Integer> var17 = null;
        var15.setRight(var17);
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer randneg291 = new Integer(-291);
        tree.add(randneg291);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg155);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var18 = new AVLNode<>(randneg825);var18.setHeight(1);var18.setBalanceFactor(-1);
        AVLNode<Integer> var19 = null;
        var18.setLeft(var19);
        AVLNode<Integer> var20 = new AVLNode<>(randneg291);var20.setHeight(0);var20.setBalanceFactor(0);
        AVLNode<Integer> var21 = null;
        var20.setLeft(var21);
        AVLNode<Integer> var22 = null;
        var20.setRight(var22);
        var18.setRight(var20);
        otherTree.setLeft(var18);
        AVLNode<Integer> var23 = new AVLNode<>(rand551);var23.setHeight(0);var23.setBalanceFactor(0);
        AVLNode<Integer> var24 = null;
        var23.setLeft(var24);
        AVLNode<Integer> var25 = null;
        var23.setRight(var25);
        otherTree.setRight(var23);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer randneg258 = new Integer(-258);
        tree.add(randneg258);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg155);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var26 = new AVLNode<>(randneg291);var26.setHeight(1);var26.setBalanceFactor(0);
        AVLNode<Integer> var27 = new AVLNode<>(randneg825);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        var26.setLeft(var27);
        AVLNode<Integer> var30 = new AVLNode<>(randneg258);var30.setHeight(0);var30.setBalanceFactor(0);
        AVLNode<Integer> var31 = null;
        var30.setLeft(var31);
        AVLNode<Integer> var32 = null;
        var30.setRight(var32);
        var26.setRight(var30);
        otherTree.setLeft(var26);
        AVLNode<Integer> var33 = new AVLNode<>(rand551);var33.setHeight(0);var33.setBalanceFactor(0);
        AVLNode<Integer> var34 = null;
        var33.setLeft(var34);
        AVLNode<Integer> var35 = null;
        var33.setRight(var35);
        otherTree.setRight(var33);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer rand822 = new Integer(822);
        tree.add(rand822);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg155);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var36 = new AVLNode<>(randneg291);var36.setHeight(1);var36.setBalanceFactor(0);
        AVLNode<Integer> var37 = new AVLNode<>(randneg825);var37.setHeight(0);var37.setBalanceFactor(0);
        AVLNode<Integer> var38 = null;
        var37.setLeft(var38);
        AVLNode<Integer> var39 = null;
        var37.setRight(var39);
        var36.setLeft(var37);
        AVLNode<Integer> var40 = new AVLNode<>(randneg258);var40.setHeight(0);var40.setBalanceFactor(0);
        AVLNode<Integer> var41 = null;
        var40.setLeft(var41);
        AVLNode<Integer> var42 = null;
        var40.setRight(var42);
        var36.setRight(var40);
        otherTree.setLeft(var36);
        AVLNode<Integer> var43 = new AVLNode<>(rand551);var43.setHeight(1);var43.setBalanceFactor(-1);
        AVLNode<Integer> var44 = null;
        var43.setLeft(var44);
        AVLNode<Integer> var45 = new AVLNode<>(rand822);var45.setHeight(0);var45.setBalanceFactor(0);
        AVLNode<Integer> var46 = null;
        var45.setLeft(var46);
        AVLNode<Integer> var47 = null;
        var45.setRight(var47);
        var43.setRight(var45);
        otherTree.setRight(var43);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer rand820 = new Integer(820);
        tree.add(rand820);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg155);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var48 = new AVLNode<>(randneg291);var48.setHeight(1);var48.setBalanceFactor(0);
        AVLNode<Integer> var49 = new AVLNode<>(randneg825);var49.setHeight(0);var49.setBalanceFactor(0);
        AVLNode<Integer> var50 = null;
        var49.setLeft(var50);
        AVLNode<Integer> var51 = null;
        var49.setRight(var51);
        var48.setLeft(var49);
        AVLNode<Integer> var52 = new AVLNode<>(randneg258);var52.setHeight(0);var52.setBalanceFactor(0);
        AVLNode<Integer> var53 = null;
        var52.setLeft(var53);
        AVLNode<Integer> var54 = null;
        var52.setRight(var54);
        var48.setRight(var52);
        otherTree.setLeft(var48);
        AVLNode<Integer> var55 = new AVLNode<>(rand820);var55.setHeight(1);var55.setBalanceFactor(0);
        AVLNode<Integer> var56 = new AVLNode<>(rand551);var56.setHeight(0);var56.setBalanceFactor(0);
        AVLNode<Integer> var57 = null;
        var56.setLeft(var57);
        AVLNode<Integer> var58 = null;
        var56.setRight(var58);
        var55.setLeft(var56);
        AVLNode<Integer> var59 = new AVLNode<>(rand822);var59.setHeight(0);var59.setBalanceFactor(0);
        AVLNode<Integer> var60 = null;
        var59.setLeft(var60);
        AVLNode<Integer> var61 = null;
        var59.setRight(var61);
        var55.setRight(var59);
        otherTree.setRight(var55);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer randneg126 = new Integer(-126);
        tree.add(randneg126);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg155);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var62 = new AVLNode<>(randneg291);var62.setHeight(1);var62.setBalanceFactor(0);
        AVLNode<Integer> var63 = new AVLNode<>(randneg825);var63.setHeight(0);var63.setBalanceFactor(0);
        AVLNode<Integer> var64 = null;
        var63.setLeft(var64);
        AVLNode<Integer> var65 = null;
        var63.setRight(var65);
        var62.setLeft(var63);
        AVLNode<Integer> var66 = new AVLNode<>(randneg258);var66.setHeight(0);var66.setBalanceFactor(0);
        AVLNode<Integer> var67 = null;
        var66.setLeft(var67);
        AVLNode<Integer> var68 = null;
        var66.setRight(var68);
        var62.setRight(var66);
        otherTree.setLeft(var62);
        AVLNode<Integer> var69 = new AVLNode<>(rand820);var69.setHeight(2);var69.setBalanceFactor(1);
        AVLNode<Integer> var70 = new AVLNode<>(rand551);var70.setHeight(1);var70.setBalanceFactor(1);
        AVLNode<Integer> var71 = new AVLNode<>(randneg126);var71.setHeight(0);var71.setBalanceFactor(0);
        AVLNode<Integer> var72 = null;
        var71.setLeft(var72);
        AVLNode<Integer> var73 = null;
        var71.setRight(var73);
        var70.setLeft(var71);
        AVLNode<Integer> var74 = null;
        var70.setRight(var74);
        var69.setLeft(var70);
        AVLNode<Integer> var75 = new AVLNode<>(rand822);var75.setHeight(0);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = null;
        var75.setLeft(var76);
        AVLNode<Integer> var77 = null;
        var75.setRight(var77);
        var69.setRight(var75);
        otherTree.setRight(var69);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer rand134 = new Integer(134);
        tree.add(rand134);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg155);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var78 = new AVLNode<>(randneg291);var78.setHeight(1);var78.setBalanceFactor(0);
        AVLNode<Integer> var79 = new AVLNode<>(randneg825);var79.setHeight(0);var79.setBalanceFactor(0);
        AVLNode<Integer> var80 = null;
        var79.setLeft(var80);
        AVLNode<Integer> var81 = null;
        var79.setRight(var81);
        var78.setLeft(var79);
        AVLNode<Integer> var82 = new AVLNode<>(randneg258);var82.setHeight(0);var82.setBalanceFactor(0);
        AVLNode<Integer> var83 = null;
        var82.setLeft(var83);
        AVLNode<Integer> var84 = null;
        var82.setRight(var84);
        var78.setRight(var82);
        otherTree.setLeft(var78);
        AVLNode<Integer> var85 = new AVLNode<>(rand820);var85.setHeight(2);var85.setBalanceFactor(1);
        AVLNode<Integer> var86 = new AVLNode<>(rand134);var86.setHeight(1);var86.setBalanceFactor(0);
        AVLNode<Integer> var87 = new AVLNode<>(randneg126);var87.setHeight(0);var87.setBalanceFactor(0);
        AVLNode<Integer> var88 = null;
        var87.setLeft(var88);
        AVLNode<Integer> var89 = null;
        var87.setRight(var89);
        var86.setLeft(var87);
        AVLNode<Integer> var90 = new AVLNode<>(rand551);var90.setHeight(0);var90.setBalanceFactor(0);
        AVLNode<Integer> var91 = null;
        var90.setLeft(var91);
        AVLNode<Integer> var92 = null;
        var90.setRight(var92);
        var86.setRight(var90);
        var85.setLeft(var86);
        AVLNode<Integer> var93 = new AVLNode<>(rand822);var93.setHeight(0);var93.setBalanceFactor(0);
        AVLNode<Integer> var94 = null;
        var93.setLeft(var94);
        AVLNode<Integer> var95 = null;
        var93.setRight(var95);
        var85.setRight(var93);
        otherTree.setRight(var85);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #24: ==========
    @Test(timeout = TIMEOUT)
    public void test24() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg932 = new Integer(-932);
        tree.add(randneg932);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg932);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer randneg549 = new Integer(-549);
        tree.add(randneg549);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg932);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = new AVLNode<>(randneg549);var3.setHeight(0);var3.setBalanceFactor(0);
        AVLNode<Integer> var4 = null;
        var3.setLeft(var4);
        AVLNode<Integer> var5 = null;
        var3.setRight(var5);
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer randneg782 = new Integer(-782);
        tree.add(randneg782);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg782);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(randneg932);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(randneg549);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer rand267 = new Integer(267);
        tree.add(rand267);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg782);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var12 = new AVLNode<>(randneg932);var12.setHeight(0);var12.setBalanceFactor(0);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = null;
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var15 = new AVLNode<>(randneg549);var15.setHeight(1);var15.setBalanceFactor(-1);
        AVLNode<Integer> var16 = null;
        var15.setLeft(var16);
        AVLNode<Integer> var17 = new AVLNode<>(rand267);var17.setHeight(0);var17.setBalanceFactor(0);
        AVLNode<Integer> var18 = null;
        var17.setLeft(var18);
        AVLNode<Integer> var19 = null;
        var17.setRight(var19);
        var15.setRight(var17);
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer rand574 = new Integer(574);
        tree.add(rand574);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg782);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var20 = new AVLNode<>(randneg932);var20.setHeight(0);var20.setBalanceFactor(0);
        AVLNode<Integer> var21 = null;
        var20.setLeft(var21);
        AVLNode<Integer> var22 = null;
        var20.setRight(var22);
        otherTree.setLeft(var20);
        AVLNode<Integer> var23 = new AVLNode<>(rand267);var23.setHeight(1);var23.setBalanceFactor(0);
        AVLNode<Integer> var24 = new AVLNode<>(randneg549);var24.setHeight(0);var24.setBalanceFactor(0);
        AVLNode<Integer> var25 = null;
        var24.setLeft(var25);
        AVLNode<Integer> var26 = null;
        var24.setRight(var26);
        var23.setLeft(var24);
        AVLNode<Integer> var27 = new AVLNode<>(rand574);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        var23.setRight(var27);
        otherTree.setRight(var23);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer randneg222 = new Integer(-222);
        tree.add(randneg222);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg549);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var30 = new AVLNode<>(randneg782);var30.setHeight(1);var30.setBalanceFactor(1);
        AVLNode<Integer> var31 = new AVLNode<>(randneg932);var31.setHeight(0);var31.setBalanceFactor(0);
        AVLNode<Integer> var32 = null;
        var31.setLeft(var32);
        AVLNode<Integer> var33 = null;
        var31.setRight(var33);
        var30.setLeft(var31);
        AVLNode<Integer> var34 = null;
        var30.setRight(var34);
        otherTree.setLeft(var30);
        AVLNode<Integer> var35 = new AVLNode<>(rand267);var35.setHeight(1);var35.setBalanceFactor(0);
        AVLNode<Integer> var36 = new AVLNode<>(randneg222);var36.setHeight(0);var36.setBalanceFactor(0);
        AVLNode<Integer> var37 = null;
        var36.setLeft(var37);
        AVLNode<Integer> var38 = null;
        var36.setRight(var38);
        var35.setLeft(var36);
        AVLNode<Integer> var39 = new AVLNode<>(rand574);var39.setHeight(0);var39.setBalanceFactor(0);
        AVLNode<Integer> var40 = null;
        var39.setLeft(var40);
        AVLNode<Integer> var41 = null;
        var39.setRight(var41);
        var35.setRight(var39);
        otherTree.setRight(var35);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer randneg243 = new Integer(-243);
        tree.add(randneg243);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg549);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var42 = new AVLNode<>(randneg782);var42.setHeight(1);var42.setBalanceFactor(1);
        AVLNode<Integer> var43 = new AVLNode<>(randneg932);var43.setHeight(0);var43.setBalanceFactor(0);
        AVLNode<Integer> var44 = null;
        var43.setLeft(var44);
        AVLNode<Integer> var45 = null;
        var43.setRight(var45);
        var42.setLeft(var43);
        AVLNode<Integer> var46 = null;
        var42.setRight(var46);
        otherTree.setLeft(var42);
        AVLNode<Integer> var47 = new AVLNode<>(rand267);var47.setHeight(2);var47.setBalanceFactor(1);
        AVLNode<Integer> var48 = new AVLNode<>(randneg222);var48.setHeight(1);var48.setBalanceFactor(1);
        AVLNode<Integer> var49 = new AVLNode<>(randneg243);var49.setHeight(0);var49.setBalanceFactor(0);
        AVLNode<Integer> var50 = null;
        var49.setLeft(var50);
        AVLNode<Integer> var51 = null;
        var49.setRight(var51);
        var48.setLeft(var49);
        AVLNode<Integer> var52 = null;
        var48.setRight(var52);
        var47.setLeft(var48);
        AVLNode<Integer> var53 = new AVLNode<>(rand574);var53.setHeight(0);var53.setBalanceFactor(0);
        AVLNode<Integer> var54 = null;
        var53.setLeft(var54);
        AVLNode<Integer> var55 = null;
        var53.setRight(var55);
        var47.setRight(var53);
        otherTree.setRight(var47);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        assertSame(randneg932, tree.remove(randneg932.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg222);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var56 = new AVLNode<>(randneg549);var56.setHeight(1);var56.setBalanceFactor(0);
        AVLNode<Integer> var57 = new AVLNode<>(randneg782);var57.setHeight(0);var57.setBalanceFactor(0);
        AVLNode<Integer> var58 = null;
        var57.setLeft(var58);
        AVLNode<Integer> var59 = null;
        var57.setRight(var59);
        var56.setLeft(var57);
        AVLNode<Integer> var60 = new AVLNode<>(randneg243);var60.setHeight(0);var60.setBalanceFactor(0);
        AVLNode<Integer> var61 = null;
        var60.setLeft(var61);
        AVLNode<Integer> var62 = null;
        var60.setRight(var62);
        var56.setRight(var60);
        otherTree.setLeft(var56);
        AVLNode<Integer> var63 = new AVLNode<>(rand267);var63.setHeight(1);var63.setBalanceFactor(-1);
        AVLNode<Integer> var64 = null;
        var63.setLeft(var64);
        AVLNode<Integer> var65 = new AVLNode<>(rand574);var65.setHeight(0);var65.setBalanceFactor(0);
        AVLNode<Integer> var66 = null;
        var65.setLeft(var66);
        AVLNode<Integer> var67 = null;
        var65.setRight(var67);
        var63.setRight(var65);
        otherTree.setRight(var63);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        assertSame(randneg549, tree.remove(randneg549.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg222);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var68 = new AVLNode<>(randneg782);var68.setHeight(1);var68.setBalanceFactor(-1);
        AVLNode<Integer> var69 = null;
        var68.setLeft(var69);
        AVLNode<Integer> var70 = new AVLNode<>(randneg243);var70.setHeight(0);var70.setBalanceFactor(0);
        AVLNode<Integer> var71 = null;
        var70.setLeft(var71);
        AVLNode<Integer> var72 = null;
        var70.setRight(var72);
        var68.setRight(var70);
        otherTree.setLeft(var68);
        AVLNode<Integer> var73 = new AVLNode<>(rand267);var73.setHeight(1);var73.setBalanceFactor(-1);
        AVLNode<Integer> var74 = null;
        var73.setLeft(var74);
        AVLNode<Integer> var75 = new AVLNode<>(rand574);var75.setHeight(0);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = null;
        var75.setLeft(var76);
        AVLNode<Integer> var77 = null;
        var75.setRight(var77);
        var73.setRight(var75);
        otherTree.setRight(var73);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer randneg898 = new Integer(-898);
        tree.add(randneg898);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg222);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var78 = new AVLNode<>(randneg782);var78.setHeight(1);var78.setBalanceFactor(0);
        AVLNode<Integer> var79 = new AVLNode<>(randneg898);var79.setHeight(0);var79.setBalanceFactor(0);
        AVLNode<Integer> var80 = null;
        var79.setLeft(var80);
        AVLNode<Integer> var81 = null;
        var79.setRight(var81);
        var78.setLeft(var79);
        AVLNode<Integer> var82 = new AVLNode<>(randneg243);var82.setHeight(0);var82.setBalanceFactor(0);
        AVLNode<Integer> var83 = null;
        var82.setLeft(var83);
        AVLNode<Integer> var84 = null;
        var82.setRight(var84);
        var78.setRight(var82);
        otherTree.setLeft(var78);
        AVLNode<Integer> var85 = new AVLNode<>(rand267);var85.setHeight(1);var85.setBalanceFactor(-1);
        AVLNode<Integer> var86 = null;
        var85.setLeft(var86);
        AVLNode<Integer> var87 = new AVLNode<>(rand574);var87.setHeight(0);var87.setBalanceFactor(0);
        AVLNode<Integer> var88 = null;
        var87.setLeft(var88);
        AVLNode<Integer> var89 = null;
        var87.setRight(var89);
        var85.setRight(var87);
        otherTree.setRight(var85);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer rand418 = new Integer(418);
        tree.add(rand418);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg222);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var90 = new AVLNode<>(randneg782);var90.setHeight(1);var90.setBalanceFactor(0);
        AVLNode<Integer> var91 = new AVLNode<>(randneg898);var91.setHeight(0);var91.setBalanceFactor(0);
        AVLNode<Integer> var92 = null;
        var91.setLeft(var92);
        AVLNode<Integer> var93 = null;
        var91.setRight(var93);
        var90.setLeft(var91);
        AVLNode<Integer> var94 = new AVLNode<>(randneg243);var94.setHeight(0);var94.setBalanceFactor(0);
        AVLNode<Integer> var95 = null;
        var94.setLeft(var95);
        AVLNode<Integer> var96 = null;
        var94.setRight(var96);
        var90.setRight(var94);
        otherTree.setLeft(var90);
        AVLNode<Integer> var97 = new AVLNode<>(rand418);var97.setHeight(1);var97.setBalanceFactor(0);
        AVLNode<Integer> var98 = new AVLNode<>(rand267);var98.setHeight(0);var98.setBalanceFactor(0);
        AVLNode<Integer> var99 = null;
        var98.setLeft(var99);
        AVLNode<Integer> var100 = null;
        var98.setRight(var100);
        var97.setLeft(var98);
        AVLNode<Integer> var101 = new AVLNode<>(rand574);var101.setHeight(0);var101.setBalanceFactor(0);
        AVLNode<Integer> var102 = null;
        var101.setLeft(var102);
        AVLNode<Integer> var103 = null;
        var101.setRight(var103);
        var97.setRight(var101);
        otherTree.setRight(var97);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer rand897 = new Integer(897);
        tree.add(rand897);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg222);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var104 = new AVLNode<>(randneg782);var104.setHeight(1);var104.setBalanceFactor(0);
        AVLNode<Integer> var105 = new AVLNode<>(randneg898);var105.setHeight(0);var105.setBalanceFactor(0);
        AVLNode<Integer> var106 = null;
        var105.setLeft(var106);
        AVLNode<Integer> var107 = null;
        var105.setRight(var107);
        var104.setLeft(var105);
        AVLNode<Integer> var108 = new AVLNode<>(randneg243);var108.setHeight(0);var108.setBalanceFactor(0);
        AVLNode<Integer> var109 = null;
        var108.setLeft(var109);
        AVLNode<Integer> var110 = null;
        var108.setRight(var110);
        var104.setRight(var108);
        otherTree.setLeft(var104);
        AVLNode<Integer> var111 = new AVLNode<>(rand418);var111.setHeight(2);var111.setBalanceFactor(-1);
        AVLNode<Integer> var112 = new AVLNode<>(rand267);var112.setHeight(0);var112.setBalanceFactor(0);
        AVLNode<Integer> var113 = null;
        var112.setLeft(var113);
        AVLNode<Integer> var114 = null;
        var112.setRight(var114);
        var111.setLeft(var112);
        AVLNode<Integer> var115 = new AVLNode<>(rand574);var115.setHeight(1);var115.setBalanceFactor(-1);
        AVLNode<Integer> var116 = null;
        var115.setLeft(var116);
        AVLNode<Integer> var117 = new AVLNode<>(rand897);var117.setHeight(0);var117.setBalanceFactor(0);
        AVLNode<Integer> var118 = null;
        var117.setLeft(var118);
        AVLNode<Integer> var119 = null;
        var117.setRight(var119);
        var115.setRight(var117);
        var111.setRight(var115);
        otherTree.setRight(var111);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer rand138 = new Integer(138);
        tree.add(rand138);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg222);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var120 = new AVLNode<>(randneg782);var120.setHeight(1);var120.setBalanceFactor(0);
        AVLNode<Integer> var121 = new AVLNode<>(randneg898);var121.setHeight(0);var121.setBalanceFactor(0);
        AVLNode<Integer> var122 = null;
        var121.setLeft(var122);
        AVLNode<Integer> var123 = null;
        var121.setRight(var123);
        var120.setLeft(var121);
        AVLNode<Integer> var124 = new AVLNode<>(randneg243);var124.setHeight(0);var124.setBalanceFactor(0);
        AVLNode<Integer> var125 = null;
        var124.setLeft(var125);
        AVLNode<Integer> var126 = null;
        var124.setRight(var126);
        var120.setRight(var124);
        otherTree.setLeft(var120);
        AVLNode<Integer> var127 = new AVLNode<>(rand418);var127.setHeight(2);var127.setBalanceFactor(0);
        AVLNode<Integer> var128 = new AVLNode<>(rand267);var128.setHeight(1);var128.setBalanceFactor(1);
        AVLNode<Integer> var129 = new AVLNode<>(rand138);var129.setHeight(0);var129.setBalanceFactor(0);
        AVLNode<Integer> var130 = null;
        var129.setLeft(var130);
        AVLNode<Integer> var131 = null;
        var129.setRight(var131);
        var128.setLeft(var129);
        AVLNode<Integer> var132 = null;
        var128.setRight(var132);
        var127.setLeft(var128);
        AVLNode<Integer> var133 = new AVLNode<>(rand574);var133.setHeight(1);var133.setBalanceFactor(-1);
        AVLNode<Integer> var134 = null;
        var133.setLeft(var134);
        AVLNode<Integer> var135 = new AVLNode<>(rand897);var135.setHeight(0);var135.setBalanceFactor(0);
        AVLNode<Integer> var136 = null;
        var135.setLeft(var136);
        AVLNode<Integer> var137 = null;
        var135.setRight(var137);
        var133.setRight(var135);
        var127.setRight(var133);
        otherTree.setRight(var127);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        assertSame(randneg898, tree.remove(randneg898.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg222);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var138 = new AVLNode<>(randneg782);var138.setHeight(1);var138.setBalanceFactor(-1);
        AVLNode<Integer> var139 = null;
        var138.setLeft(var139);
        AVLNode<Integer> var140 = new AVLNode<>(randneg243);var140.setHeight(0);var140.setBalanceFactor(0);
        AVLNode<Integer> var141 = null;
        var140.setLeft(var141);
        AVLNode<Integer> var142 = null;
        var140.setRight(var142);
        var138.setRight(var140);
        otherTree.setLeft(var138);
        AVLNode<Integer> var143 = new AVLNode<>(rand418);var143.setHeight(2);var143.setBalanceFactor(0);
        AVLNode<Integer> var144 = new AVLNode<>(rand267);var144.setHeight(1);var144.setBalanceFactor(1);
        AVLNode<Integer> var145 = new AVLNode<>(rand138);var145.setHeight(0);var145.setBalanceFactor(0);
        AVLNode<Integer> var146 = null;
        var145.setLeft(var146);
        AVLNode<Integer> var147 = null;
        var145.setRight(var147);
        var144.setLeft(var145);
        AVLNode<Integer> var148 = null;
        var144.setRight(var148);
        var143.setLeft(var144);
        AVLNode<Integer> var149 = new AVLNode<>(rand574);var149.setHeight(1);var149.setBalanceFactor(-1);
        AVLNode<Integer> var150 = null;
        var149.setLeft(var150);
        AVLNode<Integer> var151 = new AVLNode<>(rand897);var151.setHeight(0);var151.setBalanceFactor(0);
        AVLNode<Integer> var152 = null;
        var151.setLeft(var152);
        AVLNode<Integer> var153 = null;
        var151.setRight(var153);
        var149.setRight(var151);
        var143.setRight(var149);
        otherTree.setRight(var143);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer randneg736 = new Integer(-736);
        tree.add(randneg736);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg222);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var154 = new AVLNode<>(randneg736);var154.setHeight(1);var154.setBalanceFactor(0);
        AVLNode<Integer> var155 = new AVLNode<>(randneg782);var155.setHeight(0);var155.setBalanceFactor(0);
        AVLNode<Integer> var156 = null;
        var155.setLeft(var156);
        AVLNode<Integer> var157 = null;
        var155.setRight(var157);
        var154.setLeft(var155);
        AVLNode<Integer> var158 = new AVLNode<>(randneg243);var158.setHeight(0);var158.setBalanceFactor(0);
        AVLNode<Integer> var159 = null;
        var158.setLeft(var159);
        AVLNode<Integer> var160 = null;
        var158.setRight(var160);
        var154.setRight(var158);
        otherTree.setLeft(var154);
        AVLNode<Integer> var161 = new AVLNode<>(rand418);var161.setHeight(2);var161.setBalanceFactor(0);
        AVLNode<Integer> var162 = new AVLNode<>(rand267);var162.setHeight(1);var162.setBalanceFactor(1);
        AVLNode<Integer> var163 = new AVLNode<>(rand138);var163.setHeight(0);var163.setBalanceFactor(0);
        AVLNode<Integer> var164 = null;
        var163.setLeft(var164);
        AVLNode<Integer> var165 = null;
        var163.setRight(var165);
        var162.setLeft(var163);
        AVLNode<Integer> var166 = null;
        var162.setRight(var166);
        var161.setLeft(var162);
        AVLNode<Integer> var167 = new AVLNode<>(rand574);var167.setHeight(1);var167.setBalanceFactor(-1);
        AVLNode<Integer> var168 = null;
        var167.setLeft(var168);
        AVLNode<Integer> var169 = new AVLNode<>(rand897);var169.setHeight(0);var169.setBalanceFactor(0);
        AVLNode<Integer> var170 = null;
        var169.setLeft(var170);
        AVLNode<Integer> var171 = null;
        var169.setRight(var171);
        var167.setRight(var169);
        var161.setRight(var167);
        otherTree.setRight(var161);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #25: ==========
    @Test(timeout = TIMEOUT)
    public void test25() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg262 = new Integer(-262);
        tree.add(randneg262);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg262);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer randneg156 = new Integer(-156);
        tree.add(randneg156);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg262);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = new AVLNode<>(randneg156);var3.setHeight(0);var3.setBalanceFactor(0);
        AVLNode<Integer> var4 = null;
        var3.setLeft(var4);
        AVLNode<Integer> var5 = null;
        var3.setRight(var5);
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        assertSame(randneg156, tree.remove(randneg156.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg262);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = null;
        otherTree.setLeft(var6);
        AVLNode<Integer> var7 = null;
        otherTree.setRight(var7);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        assertSame(randneg262, tree.remove(randneg262.intValue()));

        // Validating last operation...
        otherTree = null;
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer randneg377 = new Integer(-377);
        tree.add(randneg377);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg377);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var8 = null;
        otherTree.setLeft(var8);
        AVLNode<Integer> var9 = null;
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        assertSame(randneg377, tree.remove(randneg377.intValue()));

        // Validating last operation...
        otherTree = null;
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer randneg193 = new Integer(-193);
        tree.add(randneg193);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg193);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        otherTree.setLeft(var10);
        AVLNode<Integer> var11 = null;
        otherTree.setRight(var11);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer rand948 = new Integer(948);
        tree.add(rand948);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg193);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var12 = null;
        otherTree.setLeft(var12);
        AVLNode<Integer> var13 = new AVLNode<>(rand948);var13.setHeight(0);var13.setBalanceFactor(0);
        AVLNode<Integer> var14 = null;
        var13.setLeft(var14);
        AVLNode<Integer> var15 = null;
        var13.setRight(var15);
        otherTree.setRight(var13);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        assertSame(randneg193, tree.remove(randneg193.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand948);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var16 = null;
        otherTree.setLeft(var16);
        AVLNode<Integer> var17 = null;
        otherTree.setRight(var17);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        assertSame(rand948, tree.remove(rand948.intValue()));

        // Validating last operation...
        otherTree = null;
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer rand720 = new Integer(720);
        tree.add(rand720);

        // Validating last operation...
        otherTree = new AVLNode<>(rand720);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var18 = null;
        otherTree.setLeft(var18);
        AVLNode<Integer> var19 = null;
        otherTree.setRight(var19);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        assertSame(rand720, tree.remove(rand720.intValue()));

        // Validating last operation...
        otherTree = null;
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer randneg456 = new Integer(-456);
        tree.add(randneg456);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg456);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var20 = null;
        otherTree.setLeft(var20);
        AVLNode<Integer> var21 = null;
        otherTree.setRight(var21);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        assertSame(randneg456, tree.remove(randneg456.intValue()));

        // Validating last operation...
        otherTree = null;
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer randneg664 = new Integer(-664);
        tree.add(randneg664);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg664);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var22 = null;
        otherTree.setLeft(var22);
        AVLNode<Integer> var23 = null;
        otherTree.setRight(var23);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #26: ==========
    @Test(timeout = TIMEOUT)
    public void test26() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg841 = new Integer(-841);
        tree.add(randneg841);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg841);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer rand157 = new Integer(157);
        tree.add(rand157);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg841);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = new AVLNode<>(rand157);var3.setHeight(0);var3.setBalanceFactor(0);
        AVLNode<Integer> var4 = null;
        var3.setLeft(var4);
        AVLNode<Integer> var5 = null;
        var3.setRight(var5);
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        assertSame(randneg841, tree.remove(randneg841.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand157);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = null;
        otherTree.setLeft(var6);
        AVLNode<Integer> var7 = null;
        otherTree.setRight(var7);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer randneg692 = new Integer(-692);
        tree.add(randneg692);

        // Validating last operation...
        otherTree = new AVLNode<>(rand157);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var8 = new AVLNode<>(randneg692);var8.setHeight(0);var8.setBalanceFactor(0);
        AVLNode<Integer> var9 = null;
        var8.setLeft(var9);
        AVLNode<Integer> var10 = null;
        var8.setRight(var10);
        otherTree.setLeft(var8);
        AVLNode<Integer> var11 = null;
        otherTree.setRight(var11);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer randneg563 = new Integer(-563);
        tree.add(randneg563);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg563);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var12 = new AVLNode<>(randneg692);var12.setHeight(0);var12.setBalanceFactor(0);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = null;
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var15 = new AVLNode<>(rand157);var15.setHeight(0);var15.setBalanceFactor(0);
        AVLNode<Integer> var16 = null;
        var15.setLeft(var16);
        AVLNode<Integer> var17 = null;
        var15.setRight(var17);
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer randneg947 = new Integer(-947);
        tree.add(randneg947);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg563);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var18 = new AVLNode<>(randneg692);var18.setHeight(1);var18.setBalanceFactor(1);
        AVLNode<Integer> var19 = new AVLNode<>(randneg947);var19.setHeight(0);var19.setBalanceFactor(0);
        AVLNode<Integer> var20 = null;
        var19.setLeft(var20);
        AVLNode<Integer> var21 = null;
        var19.setRight(var21);
        var18.setLeft(var19);
        AVLNode<Integer> var22 = null;
        var18.setRight(var22);
        otherTree.setLeft(var18);
        AVLNode<Integer> var23 = new AVLNode<>(rand157);var23.setHeight(0);var23.setBalanceFactor(0);
        AVLNode<Integer> var24 = null;
        var23.setLeft(var24);
        AVLNode<Integer> var25 = null;
        var23.setRight(var25);
        otherTree.setRight(var23);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer rand360 = new Integer(360);
        tree.add(rand360);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg563);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var26 = new AVLNode<>(randneg692);var26.setHeight(1);var26.setBalanceFactor(1);
        AVLNode<Integer> var27 = new AVLNode<>(randneg947);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        var26.setLeft(var27);
        AVLNode<Integer> var30 = null;
        var26.setRight(var30);
        otherTree.setLeft(var26);
        AVLNode<Integer> var31 = new AVLNode<>(rand157);var31.setHeight(1);var31.setBalanceFactor(-1);
        AVLNode<Integer> var32 = null;
        var31.setLeft(var32);
        AVLNode<Integer> var33 = new AVLNode<>(rand360);var33.setHeight(0);var33.setBalanceFactor(0);
        AVLNode<Integer> var34 = null;
        var33.setLeft(var34);
        AVLNode<Integer> var35 = null;
        var33.setRight(var35);
        var31.setRight(var33);
        otherTree.setRight(var31);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        assertSame(randneg947, tree.remove(randneg947.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg563);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var36 = new AVLNode<>(randneg692);var36.setHeight(0);var36.setBalanceFactor(0);
        AVLNode<Integer> var37 = null;
        var36.setLeft(var37);
        AVLNode<Integer> var38 = null;
        var36.setRight(var38);
        otherTree.setLeft(var36);
        AVLNode<Integer> var39 = new AVLNode<>(rand157);var39.setHeight(1);var39.setBalanceFactor(-1);
        AVLNode<Integer> var40 = null;
        var39.setLeft(var40);
        AVLNode<Integer> var41 = new AVLNode<>(rand360);var41.setHeight(0);var41.setBalanceFactor(0);
        AVLNode<Integer> var42 = null;
        var41.setLeft(var42);
        AVLNode<Integer> var43 = null;
        var41.setRight(var43);
        var39.setRight(var41);
        otherTree.setRight(var39);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer rand836 = new Integer(836);
        tree.add(rand836);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg563);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var44 = new AVLNode<>(randneg692);var44.setHeight(0);var44.setBalanceFactor(0);
        AVLNode<Integer> var45 = null;
        var44.setLeft(var45);
        AVLNode<Integer> var46 = null;
        var44.setRight(var46);
        otherTree.setLeft(var44);
        AVLNode<Integer> var47 = new AVLNode<>(rand360);var47.setHeight(1);var47.setBalanceFactor(0);
        AVLNode<Integer> var48 = new AVLNode<>(rand157);var48.setHeight(0);var48.setBalanceFactor(0);
        AVLNode<Integer> var49 = null;
        var48.setLeft(var49);
        AVLNode<Integer> var50 = null;
        var48.setRight(var50);
        var47.setLeft(var48);
        AVLNode<Integer> var51 = new AVLNode<>(rand836);var51.setHeight(0);var51.setBalanceFactor(0);
        AVLNode<Integer> var52 = null;
        var51.setLeft(var52);
        AVLNode<Integer> var53 = null;
        var51.setRight(var53);
        var47.setRight(var51);
        otherTree.setRight(var47);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer rand222 = new Integer(222);
        tree.add(rand222);

        // Validating last operation...
        otherTree = new AVLNode<>(rand157);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var54 = new AVLNode<>(randneg563);var54.setHeight(1);var54.setBalanceFactor(1);
        AVLNode<Integer> var55 = new AVLNode<>(randneg692);var55.setHeight(0);var55.setBalanceFactor(0);
        AVLNode<Integer> var56 = null;
        var55.setLeft(var56);
        AVLNode<Integer> var57 = null;
        var55.setRight(var57);
        var54.setLeft(var55);
        AVLNode<Integer> var58 = null;
        var54.setRight(var58);
        otherTree.setLeft(var54);
        AVLNode<Integer> var59 = new AVLNode<>(rand360);var59.setHeight(1);var59.setBalanceFactor(0);
        AVLNode<Integer> var60 = new AVLNode<>(rand222);var60.setHeight(0);var60.setBalanceFactor(0);
        AVLNode<Integer> var61 = null;
        var60.setLeft(var61);
        AVLNode<Integer> var62 = null;
        var60.setRight(var62);
        var59.setLeft(var60);
        AVLNode<Integer> var63 = new AVLNode<>(rand836);var63.setHeight(0);var63.setBalanceFactor(0);
        AVLNode<Integer> var64 = null;
        var63.setLeft(var64);
        AVLNode<Integer> var65 = null;
        var63.setRight(var65);
        var59.setRight(var63);
        otherTree.setRight(var59);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        assertSame(randneg563, tree.remove(randneg563.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand157);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var66 = new AVLNode<>(randneg692);var66.setHeight(0);var66.setBalanceFactor(0);
        AVLNode<Integer> var67 = null;
        var66.setLeft(var67);
        AVLNode<Integer> var68 = null;
        var66.setRight(var68);
        otherTree.setLeft(var66);
        AVLNode<Integer> var69 = new AVLNode<>(rand360);var69.setHeight(1);var69.setBalanceFactor(0);
        AVLNode<Integer> var70 = new AVLNode<>(rand222);var70.setHeight(0);var70.setBalanceFactor(0);
        AVLNode<Integer> var71 = null;
        var70.setLeft(var71);
        AVLNode<Integer> var72 = null;
        var70.setRight(var72);
        var69.setLeft(var70);
        AVLNode<Integer> var73 = new AVLNode<>(rand836);var73.setHeight(0);var73.setBalanceFactor(0);
        AVLNode<Integer> var74 = null;
        var73.setLeft(var74);
        AVLNode<Integer> var75 = null;
        var73.setRight(var75);
        var69.setRight(var73);
        otherTree.setRight(var69);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer rand558 = new Integer(558);
        tree.add(rand558);

        // Validating last operation...
        otherTree = new AVLNode<>(rand360);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var76 = new AVLNode<>(rand157);var76.setHeight(1);var76.setBalanceFactor(0);
        AVLNode<Integer> var77 = new AVLNode<>(randneg692);var77.setHeight(0);var77.setBalanceFactor(0);
        AVLNode<Integer> var78 = null;
        var77.setLeft(var78);
        AVLNode<Integer> var79 = null;
        var77.setRight(var79);
        var76.setLeft(var77);
        AVLNode<Integer> var80 = new AVLNode<>(rand222);var80.setHeight(0);var80.setBalanceFactor(0);
        AVLNode<Integer> var81 = null;
        var80.setLeft(var81);
        AVLNode<Integer> var82 = null;
        var80.setRight(var82);
        var76.setRight(var80);
        otherTree.setLeft(var76);
        AVLNode<Integer> var83 = new AVLNode<>(rand836);var83.setHeight(1);var83.setBalanceFactor(1);
        AVLNode<Integer> var84 = new AVLNode<>(rand558);var84.setHeight(0);var84.setBalanceFactor(0);
        AVLNode<Integer> var85 = null;
        var84.setLeft(var85);
        AVLNode<Integer> var86 = null;
        var84.setRight(var86);
        var83.setLeft(var84);
        AVLNode<Integer> var87 = null;
        var83.setRight(var87);
        otherTree.setRight(var83);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        assertSame(rand360, tree.remove(rand360.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand222);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var88 = new AVLNode<>(rand157);var88.setHeight(1);var88.setBalanceFactor(1);
        AVLNode<Integer> var89 = new AVLNode<>(randneg692);var89.setHeight(0);var89.setBalanceFactor(0);
        AVLNode<Integer> var90 = null;
        var89.setLeft(var90);
        AVLNode<Integer> var91 = null;
        var89.setRight(var91);
        var88.setLeft(var89);
        AVLNode<Integer> var92 = null;
        var88.setRight(var92);
        otherTree.setLeft(var88);
        AVLNode<Integer> var93 = new AVLNode<>(rand836);var93.setHeight(1);var93.setBalanceFactor(1);
        AVLNode<Integer> var94 = new AVLNode<>(rand558);var94.setHeight(0);var94.setBalanceFactor(0);
        AVLNode<Integer> var95 = null;
        var94.setLeft(var95);
        AVLNode<Integer> var96 = null;
        var94.setRight(var96);
        var93.setLeft(var94);
        AVLNode<Integer> var97 = null;
        var93.setRight(var97);
        otherTree.setRight(var93);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer rand259 = new Integer(259);
        tree.add(rand259);

        // Validating last operation...
        otherTree = new AVLNode<>(rand222);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var98 = new AVLNode<>(rand157);var98.setHeight(1);var98.setBalanceFactor(1);
        AVLNode<Integer> var99 = new AVLNode<>(randneg692);var99.setHeight(0);var99.setBalanceFactor(0);
        AVLNode<Integer> var100 = null;
        var99.setLeft(var100);
        AVLNode<Integer> var101 = null;
        var99.setRight(var101);
        var98.setLeft(var99);
        AVLNode<Integer> var102 = null;
        var98.setRight(var102);
        otherTree.setLeft(var98);
        AVLNode<Integer> var103 = new AVLNode<>(rand558);var103.setHeight(1);var103.setBalanceFactor(0);
        AVLNode<Integer> var104 = new AVLNode<>(rand259);var104.setHeight(0);var104.setBalanceFactor(0);
        AVLNode<Integer> var105 = null;
        var104.setLeft(var105);
        AVLNode<Integer> var106 = null;
        var104.setRight(var106);
        var103.setLeft(var104);
        AVLNode<Integer> var107 = new AVLNode<>(rand836);var107.setHeight(0);var107.setBalanceFactor(0);
        AVLNode<Integer> var108 = null;
        var107.setLeft(var108);
        AVLNode<Integer> var109 = null;
        var107.setRight(var109);
        var103.setRight(var107);
        otherTree.setRight(var103);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer rand389 = new Integer(389);
        tree.add(rand389);

        // Validating last operation...
        otherTree = new AVLNode<>(rand222);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var110 = new AVLNode<>(rand157);var110.setHeight(1);var110.setBalanceFactor(1);
        AVLNode<Integer> var111 = new AVLNode<>(randneg692);var111.setHeight(0);var111.setBalanceFactor(0);
        AVLNode<Integer> var112 = null;
        var111.setLeft(var112);
        AVLNode<Integer> var113 = null;
        var111.setRight(var113);
        var110.setLeft(var111);
        AVLNode<Integer> var114 = null;
        var110.setRight(var114);
        otherTree.setLeft(var110);
        AVLNode<Integer> var115 = new AVLNode<>(rand558);var115.setHeight(2);var115.setBalanceFactor(1);
        AVLNode<Integer> var116 = new AVLNode<>(rand259);var116.setHeight(1);var116.setBalanceFactor(-1);
        AVLNode<Integer> var117 = null;
        var116.setLeft(var117);
        AVLNode<Integer> var118 = new AVLNode<>(rand389);var118.setHeight(0);var118.setBalanceFactor(0);
        AVLNode<Integer> var119 = null;
        var118.setLeft(var119);
        AVLNode<Integer> var120 = null;
        var118.setRight(var120);
        var116.setRight(var118);
        var115.setLeft(var116);
        AVLNode<Integer> var121 = new AVLNode<>(rand836);var121.setHeight(0);var121.setBalanceFactor(0);
        AVLNode<Integer> var122 = null;
        var121.setLeft(var122);
        AVLNode<Integer> var123 = null;
        var121.setRight(var123);
        var115.setRight(var121);
        otherTree.setRight(var115);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #27: ==========
    @Test(timeout = TIMEOUT)
    public void test27() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg859 = new Integer(-859);
        tree.add(randneg859);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg859);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        assertSame(randneg859, tree.remove(randneg859.intValue()));

        // Validating last operation...
        otherTree = null;
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer rand796 = new Integer(796);
        tree.add(rand796);

        // Validating last operation...
        otherTree = new AVLNode<>(rand796);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = null;
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer rand311 = new Integer(311);
        tree.add(rand311);

        // Validating last operation...
        otherTree = new AVLNode<>(rand796);otherTree.setHeight(1);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var4 = new AVLNode<>(rand311);var4.setHeight(0);var4.setBalanceFactor(0);
        AVLNode<Integer> var5 = null;
        var4.setLeft(var5);
        AVLNode<Integer> var6 = null;
        var4.setRight(var6);
        otherTree.setLeft(var4);
        AVLNode<Integer> var7 = null;
        otherTree.setRight(var7);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer randneg863 = new Integer(-863);
        tree.add(randneg863);

        // Validating last operation...
        otherTree = new AVLNode<>(rand311);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var8 = new AVLNode<>(randneg863);var8.setHeight(0);var8.setBalanceFactor(0);
        AVLNode<Integer> var9 = null;
        var8.setLeft(var9);
        AVLNode<Integer> var10 = null;
        var8.setRight(var10);
        otherTree.setLeft(var8);
        AVLNode<Integer> var11 = new AVLNode<>(rand796);var11.setHeight(0);var11.setBalanceFactor(0);
        AVLNode<Integer> var12 = null;
        var11.setLeft(var12);
        AVLNode<Integer> var13 = null;
        var11.setRight(var13);
        otherTree.setRight(var11);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer rand228 = new Integer(228);
        tree.add(rand228);

        // Validating last operation...
        otherTree = new AVLNode<>(rand311);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var14 = new AVLNode<>(randneg863);var14.setHeight(1);var14.setBalanceFactor(-1);
        AVLNode<Integer> var15 = null;
        var14.setLeft(var15);
        AVLNode<Integer> var16 = new AVLNode<>(rand228);var16.setHeight(0);var16.setBalanceFactor(0);
        AVLNode<Integer> var17 = null;
        var16.setLeft(var17);
        AVLNode<Integer> var18 = null;
        var16.setRight(var18);
        var14.setRight(var16);
        otherTree.setLeft(var14);
        AVLNode<Integer> var19 = new AVLNode<>(rand796);var19.setHeight(0);var19.setBalanceFactor(0);
        AVLNode<Integer> var20 = null;
        var19.setLeft(var20);
        AVLNode<Integer> var21 = null;
        var19.setRight(var21);
        otherTree.setRight(var19);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer randneg206 = new Integer(-206);
        tree.add(randneg206);

        // Validating last operation...
        otherTree = new AVLNode<>(rand311);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var22 = new AVLNode<>(randneg206);var22.setHeight(1);var22.setBalanceFactor(0);
        AVLNode<Integer> var23 = new AVLNode<>(randneg863);var23.setHeight(0);var23.setBalanceFactor(0);
        AVLNode<Integer> var24 = null;
        var23.setLeft(var24);
        AVLNode<Integer> var25 = null;
        var23.setRight(var25);
        var22.setLeft(var23);
        AVLNode<Integer> var26 = new AVLNode<>(rand228);var26.setHeight(0);var26.setBalanceFactor(0);
        AVLNode<Integer> var27 = null;
        var26.setLeft(var27);
        AVLNode<Integer> var28 = null;
        var26.setRight(var28);
        var22.setRight(var26);
        otherTree.setLeft(var22);
        AVLNode<Integer> var29 = new AVLNode<>(rand796);var29.setHeight(0);var29.setBalanceFactor(0);
        AVLNode<Integer> var30 = null;
        var29.setLeft(var30);
        AVLNode<Integer> var31 = null;
        var29.setRight(var31);
        otherTree.setRight(var29);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        assertSame(rand311, tree.remove(rand311.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand228);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var32 = new AVLNode<>(randneg206);var32.setHeight(1);var32.setBalanceFactor(1);
        AVLNode<Integer> var33 = new AVLNode<>(randneg863);var33.setHeight(0);var33.setBalanceFactor(0);
        AVLNode<Integer> var34 = null;
        var33.setLeft(var34);
        AVLNode<Integer> var35 = null;
        var33.setRight(var35);
        var32.setLeft(var33);
        AVLNode<Integer> var36 = null;
        var32.setRight(var36);
        otherTree.setLeft(var32);
        AVLNode<Integer> var37 = new AVLNode<>(rand796);var37.setHeight(0);var37.setBalanceFactor(0);
        AVLNode<Integer> var38 = null;
        var37.setLeft(var38);
        AVLNode<Integer> var39 = null;
        var37.setRight(var39);
        otherTree.setRight(var37);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer randneg531 = new Integer(-531);
        tree.add(randneg531);

        // Validating last operation...
        otherTree = new AVLNode<>(rand228);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var40 = new AVLNode<>(randneg531);var40.setHeight(1);var40.setBalanceFactor(0);
        AVLNode<Integer> var41 = new AVLNode<>(randneg863);var41.setHeight(0);var41.setBalanceFactor(0);
        AVLNode<Integer> var42 = null;
        var41.setLeft(var42);
        AVLNode<Integer> var43 = null;
        var41.setRight(var43);
        var40.setLeft(var41);
        AVLNode<Integer> var44 = new AVLNode<>(randneg206);var44.setHeight(0);var44.setBalanceFactor(0);
        AVLNode<Integer> var45 = null;
        var44.setLeft(var45);
        AVLNode<Integer> var46 = null;
        var44.setRight(var46);
        var40.setRight(var44);
        otherTree.setLeft(var40);
        AVLNode<Integer> var47 = new AVLNode<>(rand796);var47.setHeight(0);var47.setBalanceFactor(0);
        AVLNode<Integer> var48 = null;
        var47.setLeft(var48);
        AVLNode<Integer> var49 = null;
        var47.setRight(var49);
        otherTree.setRight(var47);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        assertSame(randneg863, tree.remove(randneg863.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand228);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var50 = new AVLNode<>(randneg531);var50.setHeight(1);var50.setBalanceFactor(-1);
        AVLNode<Integer> var51 = null;
        var50.setLeft(var51);
        AVLNode<Integer> var52 = new AVLNode<>(randneg206);var52.setHeight(0);var52.setBalanceFactor(0);
        AVLNode<Integer> var53 = null;
        var52.setLeft(var53);
        AVLNode<Integer> var54 = null;
        var52.setRight(var54);
        var50.setRight(var52);
        otherTree.setLeft(var50);
        AVLNode<Integer> var55 = new AVLNode<>(rand796);var55.setHeight(0);var55.setBalanceFactor(0);
        AVLNode<Integer> var56 = null;
        var55.setLeft(var56);
        AVLNode<Integer> var57 = null;
        var55.setRight(var57);
        otherTree.setRight(var55);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer rand841 = new Integer(841);
        tree.add(rand841);

        // Validating last operation...
        otherTree = new AVLNode<>(rand228);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var58 = new AVLNode<>(randneg531);var58.setHeight(1);var58.setBalanceFactor(-1);
        AVLNode<Integer> var59 = null;
        var58.setLeft(var59);
        AVLNode<Integer> var60 = new AVLNode<>(randneg206);var60.setHeight(0);var60.setBalanceFactor(0);
        AVLNode<Integer> var61 = null;
        var60.setLeft(var61);
        AVLNode<Integer> var62 = null;
        var60.setRight(var62);
        var58.setRight(var60);
        otherTree.setLeft(var58);
        AVLNode<Integer> var63 = new AVLNode<>(rand796);var63.setHeight(1);var63.setBalanceFactor(-1);
        AVLNode<Integer> var64 = null;
        var63.setLeft(var64);
        AVLNode<Integer> var65 = new AVLNode<>(rand841);var65.setHeight(0);var65.setBalanceFactor(0);
        AVLNode<Integer> var66 = null;
        var65.setLeft(var66);
        AVLNode<Integer> var67 = null;
        var65.setRight(var67);
        var63.setRight(var65);
        otherTree.setRight(var63);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer randneg300 = new Integer(-300);
        tree.add(randneg300);

        // Validating last operation...
        otherTree = new AVLNode<>(rand228);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var68 = new AVLNode<>(randneg300);var68.setHeight(1);var68.setBalanceFactor(0);
        AVLNode<Integer> var69 = new AVLNode<>(randneg531);var69.setHeight(0);var69.setBalanceFactor(0);
        AVLNode<Integer> var70 = null;
        var69.setLeft(var70);
        AVLNode<Integer> var71 = null;
        var69.setRight(var71);
        var68.setLeft(var69);
        AVLNode<Integer> var72 = new AVLNode<>(randneg206);var72.setHeight(0);var72.setBalanceFactor(0);
        AVLNode<Integer> var73 = null;
        var72.setLeft(var73);
        AVLNode<Integer> var74 = null;
        var72.setRight(var74);
        var68.setRight(var72);
        otherTree.setLeft(var68);
        AVLNode<Integer> var75 = new AVLNode<>(rand796);var75.setHeight(1);var75.setBalanceFactor(-1);
        AVLNode<Integer> var76 = null;
        var75.setLeft(var76);
        AVLNode<Integer> var77 = new AVLNode<>(rand841);var77.setHeight(0);var77.setBalanceFactor(0);
        AVLNode<Integer> var78 = null;
        var77.setLeft(var78);
        AVLNode<Integer> var79 = null;
        var77.setRight(var79);
        var75.setRight(var77);
        otherTree.setRight(var75);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer rand112 = new Integer(112);
        tree.add(rand112);

        // Validating last operation...
        otherTree = new AVLNode<>(rand228);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var80 = new AVLNode<>(randneg300);var80.setHeight(2);var80.setBalanceFactor(-1);
        AVLNode<Integer> var81 = new AVLNode<>(randneg531);var81.setHeight(0);var81.setBalanceFactor(0);
        AVLNode<Integer> var82 = null;
        var81.setLeft(var82);
        AVLNode<Integer> var83 = null;
        var81.setRight(var83);
        var80.setLeft(var81);
        AVLNode<Integer> var84 = new AVLNode<>(randneg206);var84.setHeight(1);var84.setBalanceFactor(-1);
        AVLNode<Integer> var85 = null;
        var84.setLeft(var85);
        AVLNode<Integer> var86 = new AVLNode<>(rand112);var86.setHeight(0);var86.setBalanceFactor(0);
        AVLNode<Integer> var87 = null;
        var86.setLeft(var87);
        AVLNode<Integer> var88 = null;
        var86.setRight(var88);
        var84.setRight(var86);
        var80.setRight(var84);
        otherTree.setLeft(var80);
        AVLNode<Integer> var89 = new AVLNode<>(rand796);var89.setHeight(1);var89.setBalanceFactor(-1);
        AVLNode<Integer> var90 = null;
        var89.setLeft(var90);
        AVLNode<Integer> var91 = new AVLNode<>(rand841);var91.setHeight(0);var91.setBalanceFactor(0);
        AVLNode<Integer> var92 = null;
        var91.setLeft(var92);
        AVLNode<Integer> var93 = null;
        var91.setRight(var93);
        var89.setRight(var91);
        otherTree.setRight(var89);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer rand220 = new Integer(220);
        tree.add(rand220);

        // Validating last operation...
        otherTree = new AVLNode<>(rand228);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var94 = new AVLNode<>(randneg300);var94.setHeight(2);var94.setBalanceFactor(-1);
        AVLNode<Integer> var95 = new AVLNode<>(randneg531);var95.setHeight(0);var95.setBalanceFactor(0);
        AVLNode<Integer> var96 = null;
        var95.setLeft(var96);
        AVLNode<Integer> var97 = null;
        var95.setRight(var97);
        var94.setLeft(var95);
        AVLNode<Integer> var98 = new AVLNode<>(rand112);var98.setHeight(1);var98.setBalanceFactor(0);
        AVLNode<Integer> var99 = new AVLNode<>(randneg206);var99.setHeight(0);var99.setBalanceFactor(0);
        AVLNode<Integer> var100 = null;
        var99.setLeft(var100);
        AVLNode<Integer> var101 = null;
        var99.setRight(var101);
        var98.setLeft(var99);
        AVLNode<Integer> var102 = new AVLNode<>(rand220);var102.setHeight(0);var102.setBalanceFactor(0);
        AVLNode<Integer> var103 = null;
        var102.setLeft(var103);
        AVLNode<Integer> var104 = null;
        var102.setRight(var104);
        var98.setRight(var102);
        var94.setRight(var98);
        otherTree.setLeft(var94);
        AVLNode<Integer> var105 = new AVLNode<>(rand796);var105.setHeight(1);var105.setBalanceFactor(-1);
        AVLNode<Integer> var106 = null;
        var105.setLeft(var106);
        AVLNode<Integer> var107 = new AVLNode<>(rand841);var107.setHeight(0);var107.setBalanceFactor(0);
        AVLNode<Integer> var108 = null;
        var107.setLeft(var108);
        AVLNode<Integer> var109 = null;
        var107.setRight(var109);
        var105.setRight(var107);
        otherTree.setRight(var105);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer rand173 = new Integer(173);
        tree.add(rand173);

        // Validating last operation...
        otherTree = new AVLNode<>(rand228);otherTree.setHeight(3);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var110 = new AVLNode<>(rand112);var110.setHeight(2);var110.setBalanceFactor(0);
        AVLNode<Integer> var111 = new AVLNode<>(randneg300);var111.setHeight(1);var111.setBalanceFactor(0);
        AVLNode<Integer> var112 = new AVLNode<>(randneg531);var112.setHeight(0);var112.setBalanceFactor(0);
        AVLNode<Integer> var113 = null;
        var112.setLeft(var113);
        AVLNode<Integer> var114 = null;
        var112.setRight(var114);
        var111.setLeft(var112);
        AVLNode<Integer> var115 = new AVLNode<>(randneg206);var115.setHeight(0);var115.setBalanceFactor(0);
        AVLNode<Integer> var116 = null;
        var115.setLeft(var116);
        AVLNode<Integer> var117 = null;
        var115.setRight(var117);
        var111.setRight(var115);
        var110.setLeft(var111);
        AVLNode<Integer> var118 = new AVLNode<>(rand220);var118.setHeight(1);var118.setBalanceFactor(1);
        AVLNode<Integer> var119 = new AVLNode<>(rand173);var119.setHeight(0);var119.setBalanceFactor(0);
        AVLNode<Integer> var120 = null;
        var119.setLeft(var120);
        AVLNode<Integer> var121 = null;
        var119.setRight(var121);
        var118.setLeft(var119);
        AVLNode<Integer> var122 = null;
        var118.setRight(var122);
        var110.setRight(var118);
        otherTree.setLeft(var110);
        AVLNode<Integer> var123 = new AVLNode<>(rand796);var123.setHeight(1);var123.setBalanceFactor(-1);
        AVLNode<Integer> var124 = null;
        var123.setLeft(var124);
        AVLNode<Integer> var125 = new AVLNode<>(rand841);var125.setHeight(0);var125.setBalanceFactor(0);
        AVLNode<Integer> var126 = null;
        var125.setLeft(var126);
        AVLNode<Integer> var127 = null;
        var125.setRight(var127);
        var123.setRight(var125);
        otherTree.setRight(var123);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #28: ==========
    @Test(timeout = TIMEOUT)
    public void test28() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg410 = new Integer(-410);
        tree.add(randneg410);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg410);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer rand486 = new Integer(486);
        tree.add(rand486);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg410);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = new AVLNode<>(rand486);var3.setHeight(0);var3.setBalanceFactor(0);
        AVLNode<Integer> var4 = null;
        var3.setLeft(var4);
        AVLNode<Integer> var5 = null;
        var3.setRight(var5);
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer randneg349 = new Integer(-349);
        tree.add(randneg349);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg349);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(randneg410);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(rand486);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer randneg91 = new Integer(-91);
        tree.add(randneg91);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg349);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var12 = new AVLNode<>(randneg410);var12.setHeight(0);var12.setBalanceFactor(0);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = null;
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var15 = new AVLNode<>(rand486);var15.setHeight(1);var15.setBalanceFactor(1);
        AVLNode<Integer> var16 = new AVLNode<>(randneg91);var16.setHeight(0);var16.setBalanceFactor(0);
        AVLNode<Integer> var17 = null;
        var16.setLeft(var17);
        AVLNode<Integer> var18 = null;
        var16.setRight(var18);
        var15.setLeft(var16);
        AVLNode<Integer> var19 = null;
        var15.setRight(var19);
        otherTree.setRight(var15);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        Integer randneg315 = new Integer(-315);
        tree.add(randneg315);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg349);otherTree.setHeight(2);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var20 = new AVLNode<>(randneg410);var20.setHeight(0);var20.setBalanceFactor(0);
        AVLNode<Integer> var21 = null;
        var20.setLeft(var21);
        AVLNode<Integer> var22 = null;
        var20.setRight(var22);
        otherTree.setLeft(var20);
        AVLNode<Integer> var23 = new AVLNode<>(randneg91);var23.setHeight(1);var23.setBalanceFactor(0);
        AVLNode<Integer> var24 = new AVLNode<>(randneg315);var24.setHeight(0);var24.setBalanceFactor(0);
        AVLNode<Integer> var25 = null;
        var24.setLeft(var25);
        AVLNode<Integer> var26 = null;
        var24.setRight(var26);
        var23.setLeft(var24);
        AVLNode<Integer> var27 = new AVLNode<>(rand486);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        var23.setRight(var27);
        otherTree.setRight(var23);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer rand125 = new Integer(125);
        tree.add(rand125);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg91);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var30 = new AVLNode<>(randneg349);var30.setHeight(1);var30.setBalanceFactor(0);
        AVLNode<Integer> var31 = new AVLNode<>(randneg410);var31.setHeight(0);var31.setBalanceFactor(0);
        AVLNode<Integer> var32 = null;
        var31.setLeft(var32);
        AVLNode<Integer> var33 = null;
        var31.setRight(var33);
        var30.setLeft(var31);
        AVLNode<Integer> var34 = new AVLNode<>(randneg315);var34.setHeight(0);var34.setBalanceFactor(0);
        AVLNode<Integer> var35 = null;
        var34.setLeft(var35);
        AVLNode<Integer> var36 = null;
        var34.setRight(var36);
        var30.setRight(var34);
        otherTree.setLeft(var30);
        AVLNode<Integer> var37 = new AVLNode<>(rand486);var37.setHeight(1);var37.setBalanceFactor(1);
        AVLNode<Integer> var38 = new AVLNode<>(rand125);var38.setHeight(0);var38.setBalanceFactor(0);
        AVLNode<Integer> var39 = null;
        var38.setLeft(var39);
        AVLNode<Integer> var40 = null;
        var38.setRight(var40);
        var37.setLeft(var38);
        AVLNode<Integer> var41 = null;
        var37.setRight(var41);
        otherTree.setRight(var37);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        assertSame(rand125, tree.remove(rand125.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg91);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var42 = new AVLNode<>(randneg349);var42.setHeight(1);var42.setBalanceFactor(0);
        AVLNode<Integer> var43 = new AVLNode<>(randneg410);var43.setHeight(0);var43.setBalanceFactor(0);
        AVLNode<Integer> var44 = null;
        var43.setLeft(var44);
        AVLNode<Integer> var45 = null;
        var43.setRight(var45);
        var42.setLeft(var43);
        AVLNode<Integer> var46 = new AVLNode<>(randneg315);var46.setHeight(0);var46.setBalanceFactor(0);
        AVLNode<Integer> var47 = null;
        var46.setLeft(var47);
        AVLNode<Integer> var48 = null;
        var46.setRight(var48);
        var42.setRight(var46);
        otherTree.setLeft(var42);
        AVLNode<Integer> var49 = new AVLNode<>(rand486);var49.setHeight(0);var49.setBalanceFactor(0);
        AVLNode<Integer> var50 = null;
        var49.setLeft(var50);
        AVLNode<Integer> var51 = null;
        var49.setRight(var51);
        otherTree.setRight(var49);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer randneg607 = new Integer(-607);
        tree.add(randneg607);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg349);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var52 = new AVLNode<>(randneg410);var52.setHeight(1);var52.setBalanceFactor(1);
        AVLNode<Integer> var53 = new AVLNode<>(randneg607);var53.setHeight(0);var53.setBalanceFactor(0);
        AVLNode<Integer> var54 = null;
        var53.setLeft(var54);
        AVLNode<Integer> var55 = null;
        var53.setRight(var55);
        var52.setLeft(var53);
        AVLNode<Integer> var56 = null;
        var52.setRight(var56);
        otherTree.setLeft(var52);
        AVLNode<Integer> var57 = new AVLNode<>(randneg91);var57.setHeight(1);var57.setBalanceFactor(0);
        AVLNode<Integer> var58 = new AVLNode<>(randneg315);var58.setHeight(0);var58.setBalanceFactor(0);
        AVLNode<Integer> var59 = null;
        var58.setLeft(var59);
        AVLNode<Integer> var60 = null;
        var58.setRight(var60);
        var57.setLeft(var58);
        AVLNode<Integer> var61 = new AVLNode<>(rand486);var61.setHeight(0);var61.setBalanceFactor(0);
        AVLNode<Integer> var62 = null;
        var61.setLeft(var62);
        AVLNode<Integer> var63 = null;
        var61.setRight(var63);
        var57.setRight(var61);
        otherTree.setRight(var57);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        Integer randneg880 = new Integer(-880);
        tree.add(randneg880);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg349);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var64 = new AVLNode<>(randneg607);var64.setHeight(1);var64.setBalanceFactor(0);
        AVLNode<Integer> var65 = new AVLNode<>(randneg880);var65.setHeight(0);var65.setBalanceFactor(0);
        AVLNode<Integer> var66 = null;
        var65.setLeft(var66);
        AVLNode<Integer> var67 = null;
        var65.setRight(var67);
        var64.setLeft(var65);
        AVLNode<Integer> var68 = new AVLNode<>(randneg410);var68.setHeight(0);var68.setBalanceFactor(0);
        AVLNode<Integer> var69 = null;
        var68.setLeft(var69);
        AVLNode<Integer> var70 = null;
        var68.setRight(var70);
        var64.setRight(var68);
        otherTree.setLeft(var64);
        AVLNode<Integer> var71 = new AVLNode<>(randneg91);var71.setHeight(1);var71.setBalanceFactor(0);
        AVLNode<Integer> var72 = new AVLNode<>(randneg315);var72.setHeight(0);var72.setBalanceFactor(0);
        AVLNode<Integer> var73 = null;
        var72.setLeft(var73);
        AVLNode<Integer> var74 = null;
        var72.setRight(var74);
        var71.setLeft(var72);
        AVLNode<Integer> var75 = new AVLNode<>(rand486);var75.setHeight(0);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = null;
        var75.setLeft(var76);
        AVLNode<Integer> var77 = null;
        var75.setRight(var77);
        var71.setRight(var75);
        otherTree.setRight(var71);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        Integer randneg148 = new Integer(-148);
        tree.add(randneg148);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg349);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var78 = new AVLNode<>(randneg607);var78.setHeight(1);var78.setBalanceFactor(0);
        AVLNode<Integer> var79 = new AVLNode<>(randneg880);var79.setHeight(0);var79.setBalanceFactor(0);
        AVLNode<Integer> var80 = null;
        var79.setLeft(var80);
        AVLNode<Integer> var81 = null;
        var79.setRight(var81);
        var78.setLeft(var79);
        AVLNode<Integer> var82 = new AVLNode<>(randneg410);var82.setHeight(0);var82.setBalanceFactor(0);
        AVLNode<Integer> var83 = null;
        var82.setLeft(var83);
        AVLNode<Integer> var84 = null;
        var82.setRight(var84);
        var78.setRight(var82);
        otherTree.setLeft(var78);
        AVLNode<Integer> var85 = new AVLNode<>(randneg91);var85.setHeight(2);var85.setBalanceFactor(1);
        AVLNode<Integer> var86 = new AVLNode<>(randneg315);var86.setHeight(1);var86.setBalanceFactor(-1);
        AVLNode<Integer> var87 = null;
        var86.setLeft(var87);
        AVLNode<Integer> var88 = new AVLNode<>(randneg148);var88.setHeight(0);var88.setBalanceFactor(0);
        AVLNode<Integer> var89 = null;
        var88.setLeft(var89);
        AVLNode<Integer> var90 = null;
        var88.setRight(var90);
        var86.setRight(var88);
        var85.setLeft(var86);
        AVLNode<Integer> var91 = new AVLNode<>(rand486);var91.setHeight(0);var91.setBalanceFactor(0);
        AVLNode<Integer> var92 = null;
        var91.setLeft(var92);
        AVLNode<Integer> var93 = null;
        var91.setRight(var93);
        var85.setRight(var91);
        otherTree.setRight(var85);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer randneg913 = new Integer(-913);
        tree.add(randneg913);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg349);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var94 = new AVLNode<>(randneg607);var94.setHeight(2);var94.setBalanceFactor(1);
        AVLNode<Integer> var95 = new AVLNode<>(randneg880);var95.setHeight(1);var95.setBalanceFactor(1);
        AVLNode<Integer> var96 = new AVLNode<>(randneg913);var96.setHeight(0);var96.setBalanceFactor(0);
        AVLNode<Integer> var97 = null;
        var96.setLeft(var97);
        AVLNode<Integer> var98 = null;
        var96.setRight(var98);
        var95.setLeft(var96);
        AVLNode<Integer> var99 = null;
        var95.setRight(var99);
        var94.setLeft(var95);
        AVLNode<Integer> var100 = new AVLNode<>(randneg410);var100.setHeight(0);var100.setBalanceFactor(0);
        AVLNode<Integer> var101 = null;
        var100.setLeft(var101);
        AVLNode<Integer> var102 = null;
        var100.setRight(var102);
        var94.setRight(var100);
        otherTree.setLeft(var94);
        AVLNode<Integer> var103 = new AVLNode<>(randneg91);var103.setHeight(2);var103.setBalanceFactor(1);
        AVLNode<Integer> var104 = new AVLNode<>(randneg315);var104.setHeight(1);var104.setBalanceFactor(-1);
        AVLNode<Integer> var105 = null;
        var104.setLeft(var105);
        AVLNode<Integer> var106 = new AVLNode<>(randneg148);var106.setHeight(0);var106.setBalanceFactor(0);
        AVLNode<Integer> var107 = null;
        var106.setLeft(var107);
        AVLNode<Integer> var108 = null;
        var106.setRight(var108);
        var104.setRight(var106);
        var103.setLeft(var104);
        AVLNode<Integer> var109 = new AVLNode<>(rand486);var109.setHeight(0);var109.setBalanceFactor(0);
        AVLNode<Integer> var110 = null;
        var109.setLeft(var110);
        AVLNode<Integer> var111 = null;
        var109.setRight(var111);
        var103.setRight(var109);
        otherTree.setRight(var103);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        assertSame(randneg607, tree.remove(randneg607.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg349);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var112 = new AVLNode<>(randneg880);var112.setHeight(1);var112.setBalanceFactor(0);
        AVLNode<Integer> var113 = new AVLNode<>(randneg913);var113.setHeight(0);var113.setBalanceFactor(0);
        AVLNode<Integer> var114 = null;
        var113.setLeft(var114);
        AVLNode<Integer> var115 = null;
        var113.setRight(var115);
        var112.setLeft(var113);
        AVLNode<Integer> var116 = new AVLNode<>(randneg410);var116.setHeight(0);var116.setBalanceFactor(0);
        AVLNode<Integer> var117 = null;
        var116.setLeft(var117);
        AVLNode<Integer> var118 = null;
        var116.setRight(var118);
        var112.setRight(var116);
        otherTree.setLeft(var112);
        AVLNode<Integer> var119 = new AVLNode<>(randneg91);var119.setHeight(2);var119.setBalanceFactor(1);
        AVLNode<Integer> var120 = new AVLNode<>(randneg315);var120.setHeight(1);var120.setBalanceFactor(-1);
        AVLNode<Integer> var121 = null;
        var120.setLeft(var121);
        AVLNode<Integer> var122 = new AVLNode<>(randneg148);var122.setHeight(0);var122.setBalanceFactor(0);
        AVLNode<Integer> var123 = null;
        var122.setLeft(var123);
        AVLNode<Integer> var124 = null;
        var122.setRight(var124);
        var120.setRight(var122);
        var119.setLeft(var120);
        AVLNode<Integer> var125 = new AVLNode<>(rand486);var125.setHeight(0);var125.setBalanceFactor(0);
        AVLNode<Integer> var126 = null;
        var125.setLeft(var126);
        AVLNode<Integer> var127 = null;
        var125.setRight(var127);
        var119.setRight(var125);
        otherTree.setRight(var119);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer randneg517 = new Integer(-517);
        tree.add(randneg517);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg349);otherTree.setHeight(3);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var128 = new AVLNode<>(randneg880);var128.setHeight(2);var128.setBalanceFactor(-1);
        AVLNode<Integer> var129 = new AVLNode<>(randneg913);var129.setHeight(0);var129.setBalanceFactor(0);
        AVLNode<Integer> var130 = null;
        var129.setLeft(var130);
        AVLNode<Integer> var131 = null;
        var129.setRight(var131);
        var128.setLeft(var129);
        AVLNode<Integer> var132 = new AVLNode<>(randneg410);var132.setHeight(1);var132.setBalanceFactor(1);
        AVLNode<Integer> var133 = new AVLNode<>(randneg517);var133.setHeight(0);var133.setBalanceFactor(0);
        AVLNode<Integer> var134 = null;
        var133.setLeft(var134);
        AVLNode<Integer> var135 = null;
        var133.setRight(var135);
        var132.setLeft(var133);
        AVLNode<Integer> var136 = null;
        var132.setRight(var136);
        var128.setRight(var132);
        otherTree.setLeft(var128);
        AVLNode<Integer> var137 = new AVLNode<>(randneg91);var137.setHeight(2);var137.setBalanceFactor(1);
        AVLNode<Integer> var138 = new AVLNode<>(randneg315);var138.setHeight(1);var138.setBalanceFactor(-1);
        AVLNode<Integer> var139 = null;
        var138.setLeft(var139);
        AVLNode<Integer> var140 = new AVLNode<>(randneg148);var140.setHeight(0);var140.setBalanceFactor(0);
        AVLNode<Integer> var141 = null;
        var140.setLeft(var141);
        AVLNode<Integer> var142 = null;
        var140.setRight(var142);
        var138.setRight(var140);
        var137.setLeft(var138);
        AVLNode<Integer> var143 = new AVLNode<>(rand486);var143.setHeight(0);var143.setBalanceFactor(0);
        AVLNode<Integer> var144 = null;
        var143.setLeft(var144);
        AVLNode<Integer> var145 = null;
        var143.setRight(var145);
        var137.setRight(var143);
        otherTree.setRight(var137);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        assertSame(randneg349, tree.remove(randneg349.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg410);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var146 = new AVLNode<>(randneg880);var146.setHeight(1);var146.setBalanceFactor(0);
        AVLNode<Integer> var147 = new AVLNode<>(randneg913);var147.setHeight(0);var147.setBalanceFactor(0);
        AVLNode<Integer> var148 = null;
        var147.setLeft(var148);
        AVLNode<Integer> var149 = null;
        var147.setRight(var149);
        var146.setLeft(var147);
        AVLNode<Integer> var150 = new AVLNode<>(randneg517);var150.setHeight(0);var150.setBalanceFactor(0);
        AVLNode<Integer> var151 = null;
        var150.setLeft(var151);
        AVLNode<Integer> var152 = null;
        var150.setRight(var152);
        var146.setRight(var150);
        otherTree.setLeft(var146);
        AVLNode<Integer> var153 = new AVLNode<>(randneg91);var153.setHeight(2);var153.setBalanceFactor(1);
        AVLNode<Integer> var154 = new AVLNode<>(randneg315);var154.setHeight(1);var154.setBalanceFactor(-1);
        AVLNode<Integer> var155 = null;
        var154.setLeft(var155);
        AVLNode<Integer> var156 = new AVLNode<>(randneg148);var156.setHeight(0);var156.setBalanceFactor(0);
        AVLNode<Integer> var157 = null;
        var156.setLeft(var157);
        AVLNode<Integer> var158 = null;
        var156.setRight(var158);
        var154.setRight(var156);
        var153.setLeft(var154);
        AVLNode<Integer> var159 = new AVLNode<>(rand486);var159.setHeight(0);var159.setBalanceFactor(0);
        AVLNode<Integer> var160 = null;
        var159.setLeft(var160);
        AVLNode<Integer> var161 = null;
        var159.setRight(var161);
        var153.setRight(var159);
        otherTree.setRight(var153);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        assertSame(rand486, tree.remove(rand486.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(randneg410);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var162 = new AVLNode<>(randneg880);var162.setHeight(1);var162.setBalanceFactor(0);
        AVLNode<Integer> var163 = new AVLNode<>(randneg913);var163.setHeight(0);var163.setBalanceFactor(0);
        AVLNode<Integer> var164 = null;
        var163.setLeft(var164);
        AVLNode<Integer> var165 = null;
        var163.setRight(var165);
        var162.setLeft(var163);
        AVLNode<Integer> var166 = new AVLNode<>(randneg517);var166.setHeight(0);var166.setBalanceFactor(0);
        AVLNode<Integer> var167 = null;
        var166.setLeft(var167);
        AVLNode<Integer> var168 = null;
        var166.setRight(var168);
        var162.setRight(var166);
        otherTree.setLeft(var162);
        AVLNode<Integer> var169 = new AVLNode<>(randneg148);var169.setHeight(1);var169.setBalanceFactor(0);
        AVLNode<Integer> var170 = new AVLNode<>(randneg315);var170.setHeight(0);var170.setBalanceFactor(0);
        AVLNode<Integer> var171 = null;
        var170.setLeft(var171);
        AVLNode<Integer> var172 = null;
        var170.setRight(var172);
        var169.setLeft(var170);
        AVLNode<Integer> var173 = new AVLNode<>(randneg91);var173.setHeight(0);var173.setBalanceFactor(0);
        AVLNode<Integer> var174 = null;
        var173.setLeft(var174);
        AVLNode<Integer> var175 = null;
        var173.setRight(var175);
        var169.setRight(var173);
        otherTree.setRight(var169);
        assertTrue(treesEqual(otherTree));
    }



    // ========== Test #29: ==========
    @Test(timeout = TIMEOUT)
    public void test29() {
        AVLNode<Integer> otherTree;

        // Operation 0
        Integer randneg142 = new Integer(-142);
        tree.add(randneg142);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg142);otherTree.setHeight(0);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var0 = null;
        otherTree.setLeft(var0);
        AVLNode<Integer> var1 = null;
        otherTree.setRight(var1);
        assertTrue(treesEqual(otherTree));


        // Operation 1
        Integer rand834 = new Integer(834);
        tree.add(rand834);

        // Validating last operation...
        otherTree = new AVLNode<>(randneg142);otherTree.setHeight(1);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var2 = null;
        otherTree.setLeft(var2);
        AVLNode<Integer> var3 = new AVLNode<>(rand834);var3.setHeight(0);var3.setBalanceFactor(0);
        AVLNode<Integer> var4 = null;
        var3.setLeft(var4);
        AVLNode<Integer> var5 = null;
        var3.setRight(var5);
        otherTree.setRight(var3);
        assertTrue(treesEqual(otherTree));


        // Operation 2
        Integer rand614 = new Integer(614);
        tree.add(rand614);

        // Validating last operation...
        otherTree = new AVLNode<>(rand614);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var6 = new AVLNode<>(randneg142);var6.setHeight(0);var6.setBalanceFactor(0);
        AVLNode<Integer> var7 = null;
        var6.setLeft(var7);
        AVLNode<Integer> var8 = null;
        var6.setRight(var8);
        otherTree.setLeft(var6);
        AVLNode<Integer> var9 = new AVLNode<>(rand834);var9.setHeight(0);var9.setBalanceFactor(0);
        AVLNode<Integer> var10 = null;
        var9.setLeft(var10);
        AVLNode<Integer> var11 = null;
        var9.setRight(var11);
        otherTree.setRight(var9);
        assertTrue(treesEqual(otherTree));


        // Operation 3
        Integer rand592 = new Integer(592);
        tree.add(rand592);

        // Validating last operation...
        otherTree = new AVLNode<>(rand614);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var12 = new AVLNode<>(randneg142);var12.setHeight(1);var12.setBalanceFactor(-1);
        AVLNode<Integer> var13 = null;
        var12.setLeft(var13);
        AVLNode<Integer> var14 = new AVLNode<>(rand592);var14.setHeight(0);var14.setBalanceFactor(0);
        AVLNode<Integer> var15 = null;
        var14.setLeft(var15);
        AVLNode<Integer> var16 = null;
        var14.setRight(var16);
        var12.setRight(var14);
        otherTree.setLeft(var12);
        AVLNode<Integer> var17 = new AVLNode<>(rand834);var17.setHeight(0);var17.setBalanceFactor(0);
        AVLNode<Integer> var18 = null;
        var17.setLeft(var18);
        AVLNode<Integer> var19 = null;
        var17.setRight(var19);
        otherTree.setRight(var17);
        assertTrue(treesEqual(otherTree));


        // Operation 4
        assertSame(randneg142, tree.remove(randneg142.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand614);otherTree.setHeight(1);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var20 = new AVLNode<>(rand592);var20.setHeight(0);var20.setBalanceFactor(0);
        AVLNode<Integer> var21 = null;
        var20.setLeft(var21);
        AVLNode<Integer> var22 = null;
        var20.setRight(var22);
        otherTree.setLeft(var20);
        AVLNode<Integer> var23 = new AVLNode<>(rand834);var23.setHeight(0);var23.setBalanceFactor(0);
        AVLNode<Integer> var24 = null;
        var23.setLeft(var24);
        AVLNode<Integer> var25 = null;
        var23.setRight(var25);
        otherTree.setRight(var23);
        assertTrue(treesEqual(otherTree));


        // Operation 5
        Integer rand115 = new Integer(115);
        tree.add(rand115);

        // Validating last operation...
        otherTree = new AVLNode<>(rand614);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var26 = new AVLNode<>(rand592);var26.setHeight(1);var26.setBalanceFactor(1);
        AVLNode<Integer> var27 = new AVLNode<>(rand115);var27.setHeight(0);var27.setBalanceFactor(0);
        AVLNode<Integer> var28 = null;
        var27.setLeft(var28);
        AVLNode<Integer> var29 = null;
        var27.setRight(var29);
        var26.setLeft(var27);
        AVLNode<Integer> var30 = null;
        var26.setRight(var30);
        otherTree.setLeft(var26);
        AVLNode<Integer> var31 = new AVLNode<>(rand834);var31.setHeight(0);var31.setBalanceFactor(0);
        AVLNode<Integer> var32 = null;
        var31.setLeft(var32);
        AVLNode<Integer> var33 = null;
        var31.setRight(var33);
        otherTree.setRight(var31);
        assertTrue(treesEqual(otherTree));


        // Operation 6
        Integer rand304 = new Integer(304);
        tree.add(rand304);

        // Validating last operation...
        otherTree = new AVLNode<>(rand614);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var34 = new AVLNode<>(rand304);var34.setHeight(1);var34.setBalanceFactor(0);
        AVLNode<Integer> var35 = new AVLNode<>(rand115);var35.setHeight(0);var35.setBalanceFactor(0);
        AVLNode<Integer> var36 = null;
        var35.setLeft(var36);
        AVLNode<Integer> var37 = null;
        var35.setRight(var37);
        var34.setLeft(var35);
        AVLNode<Integer> var38 = new AVLNode<>(rand592);var38.setHeight(0);var38.setBalanceFactor(0);
        AVLNode<Integer> var39 = null;
        var38.setLeft(var39);
        AVLNode<Integer> var40 = null;
        var38.setRight(var40);
        var34.setRight(var38);
        otherTree.setLeft(var34);
        AVLNode<Integer> var41 = new AVLNode<>(rand834);var41.setHeight(0);var41.setBalanceFactor(0);
        AVLNode<Integer> var42 = null;
        var41.setLeft(var42);
        AVLNode<Integer> var43 = null;
        var41.setRight(var43);
        otherTree.setRight(var41);
        assertTrue(treesEqual(otherTree));


        // Operation 7
        Integer rand909 = new Integer(909);
        tree.add(rand909);

        // Validating last operation...
        otherTree = new AVLNode<>(rand614);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var44 = new AVLNode<>(rand304);var44.setHeight(1);var44.setBalanceFactor(0);
        AVLNode<Integer> var45 = new AVLNode<>(rand115);var45.setHeight(0);var45.setBalanceFactor(0);
        AVLNode<Integer> var46 = null;
        var45.setLeft(var46);
        AVLNode<Integer> var47 = null;
        var45.setRight(var47);
        var44.setLeft(var45);
        AVLNode<Integer> var48 = new AVLNode<>(rand592);var48.setHeight(0);var48.setBalanceFactor(0);
        AVLNode<Integer> var49 = null;
        var48.setLeft(var49);
        AVLNode<Integer> var50 = null;
        var48.setRight(var50);
        var44.setRight(var48);
        otherTree.setLeft(var44);
        AVLNode<Integer> var51 = new AVLNode<>(rand834);var51.setHeight(1);var51.setBalanceFactor(-1);
        AVLNode<Integer> var52 = null;
        var51.setLeft(var52);
        AVLNode<Integer> var53 = new AVLNode<>(rand909);var53.setHeight(0);var53.setBalanceFactor(0);
        AVLNode<Integer> var54 = null;
        var53.setLeft(var54);
        AVLNode<Integer> var55 = null;
        var53.setRight(var55);
        var51.setRight(var53);
        otherTree.setRight(var51);
        assertTrue(treesEqual(otherTree));


        // Operation 8
        assertSame(rand909, tree.remove(rand909.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand614);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var56 = new AVLNode<>(rand304);var56.setHeight(1);var56.setBalanceFactor(0);
        AVLNode<Integer> var57 = new AVLNode<>(rand115);var57.setHeight(0);var57.setBalanceFactor(0);
        AVLNode<Integer> var58 = null;
        var57.setLeft(var58);
        AVLNode<Integer> var59 = null;
        var57.setRight(var59);
        var56.setLeft(var57);
        AVLNode<Integer> var60 = new AVLNode<>(rand592);var60.setHeight(0);var60.setBalanceFactor(0);
        AVLNode<Integer> var61 = null;
        var60.setLeft(var61);
        AVLNode<Integer> var62 = null;
        var60.setRight(var62);
        var56.setRight(var60);
        otherTree.setLeft(var56);
        AVLNode<Integer> var63 = new AVLNode<>(rand834);var63.setHeight(0);var63.setBalanceFactor(0);
        AVLNode<Integer> var64 = null;
        var63.setLeft(var64);
        AVLNode<Integer> var65 = null;
        var63.setRight(var65);
        otherTree.setRight(var63);
        assertTrue(treesEqual(otherTree));


        // Operation 9
        assertSame(rand592, tree.remove(rand592.intValue()));

        // Validating last operation...
        otherTree = new AVLNode<>(rand614);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var66 = new AVLNode<>(rand304);var66.setHeight(1);var66.setBalanceFactor(1);
        AVLNode<Integer> var67 = new AVLNode<>(rand115);var67.setHeight(0);var67.setBalanceFactor(0);
        AVLNode<Integer> var68 = null;
        var67.setLeft(var68);
        AVLNode<Integer> var69 = null;
        var67.setRight(var69);
        var66.setLeft(var67);
        AVLNode<Integer> var70 = null;
        var66.setRight(var70);
        otherTree.setLeft(var66);
        AVLNode<Integer> var71 = new AVLNode<>(rand834);var71.setHeight(0);var71.setBalanceFactor(0);
        AVLNode<Integer> var72 = null;
        var71.setLeft(var72);
        AVLNode<Integer> var73 = null;
        var71.setRight(var73);
        otherTree.setRight(var71);
        assertTrue(treesEqual(otherTree));


        // Operation 10
        Integer rand568 = new Integer(568);
        tree.add(rand568);

        // Validating last operation...
        otherTree = new AVLNode<>(rand614);otherTree.setHeight(2);otherTree.setBalanceFactor(1);
        AVLNode<Integer> var74 = new AVLNode<>(rand304);var74.setHeight(1);var74.setBalanceFactor(0);
        AVLNode<Integer> var75 = new AVLNode<>(rand115);var75.setHeight(0);var75.setBalanceFactor(0);
        AVLNode<Integer> var76 = null;
        var75.setLeft(var76);
        AVLNode<Integer> var77 = null;
        var75.setRight(var77);
        var74.setLeft(var75);
        AVLNode<Integer> var78 = new AVLNode<>(rand568);var78.setHeight(0);var78.setBalanceFactor(0);
        AVLNode<Integer> var79 = null;
        var78.setLeft(var79);
        AVLNode<Integer> var80 = null;
        var78.setRight(var80);
        var74.setRight(var78);
        otherTree.setLeft(var74);
        AVLNode<Integer> var81 = new AVLNode<>(rand834);var81.setHeight(0);var81.setBalanceFactor(0);
        AVLNode<Integer> var82 = null;
        var81.setLeft(var82);
        AVLNode<Integer> var83 = null;
        var81.setRight(var83);
        otherTree.setRight(var81);
        assertTrue(treesEqual(otherTree));


        // Operation 11
        Integer rand274 = new Integer(274);
        tree.add(rand274);

        // Validating last operation...
        otherTree = new AVLNode<>(rand304);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var84 = new AVLNode<>(rand115);var84.setHeight(1);var84.setBalanceFactor(-1);
        AVLNode<Integer> var85 = null;
        var84.setLeft(var85);
        AVLNode<Integer> var86 = new AVLNode<>(rand274);var86.setHeight(0);var86.setBalanceFactor(0);
        AVLNode<Integer> var87 = null;
        var86.setLeft(var87);
        AVLNode<Integer> var88 = null;
        var86.setRight(var88);
        var84.setRight(var86);
        otherTree.setLeft(var84);
        AVLNode<Integer> var89 = new AVLNode<>(rand614);var89.setHeight(1);var89.setBalanceFactor(0);
        AVLNode<Integer> var90 = new AVLNode<>(rand568);var90.setHeight(0);var90.setBalanceFactor(0);
        AVLNode<Integer> var91 = null;
        var90.setLeft(var91);
        AVLNode<Integer> var92 = null;
        var90.setRight(var92);
        var89.setLeft(var90);
        AVLNode<Integer> var93 = new AVLNode<>(rand834);var93.setHeight(0);var93.setBalanceFactor(0);
        AVLNode<Integer> var94 = null;
        var93.setLeft(var94);
        AVLNode<Integer> var95 = null;
        var93.setRight(var95);
        var89.setRight(var93);
        otherTree.setRight(var89);
        assertTrue(treesEqual(otherTree));


        // Operation 12
        Integer randneg613 = new Integer(-613);
        tree.add(randneg613);

        // Validating last operation...
        otherTree = new AVLNode<>(rand304);otherTree.setHeight(2);otherTree.setBalanceFactor(0);
        AVLNode<Integer> var96 = new AVLNode<>(rand115);var96.setHeight(1);var96.setBalanceFactor(0);
        AVLNode<Integer> var97 = new AVLNode<>(randneg613);var97.setHeight(0);var97.setBalanceFactor(0);
        AVLNode<Integer> var98 = null;
        var97.setLeft(var98);
        AVLNode<Integer> var99 = null;
        var97.setRight(var99);
        var96.setLeft(var97);
        AVLNode<Integer> var100 = new AVLNode<>(rand274);var100.setHeight(0);var100.setBalanceFactor(0);
        AVLNode<Integer> var101 = null;
        var100.setLeft(var101);
        AVLNode<Integer> var102 = null;
        var100.setRight(var102);
        var96.setRight(var100);
        otherTree.setLeft(var96);
        AVLNode<Integer> var103 = new AVLNode<>(rand614);var103.setHeight(1);var103.setBalanceFactor(0);
        AVLNode<Integer> var104 = new AVLNode<>(rand568);var104.setHeight(0);var104.setBalanceFactor(0);
        AVLNode<Integer> var105 = null;
        var104.setLeft(var105);
        AVLNode<Integer> var106 = null;
        var104.setRight(var106);
        var103.setLeft(var104);
        AVLNode<Integer> var107 = new AVLNode<>(rand834);var107.setHeight(0);var107.setBalanceFactor(0);
        AVLNode<Integer> var108 = null;
        var107.setLeft(var108);
        AVLNode<Integer> var109 = null;
        var107.setRight(var109);
        var103.setRight(var107);
        otherTree.setRight(var103);
        assertTrue(treesEqual(otherTree));


        // Operation 13
        Integer rand935 = new Integer(935);
        tree.add(rand935);

        // Validating last operation...
        otherTree = new AVLNode<>(rand304);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var110 = new AVLNode<>(rand115);var110.setHeight(1);var110.setBalanceFactor(0);
        AVLNode<Integer> var111 = new AVLNode<>(randneg613);var111.setHeight(0);var111.setBalanceFactor(0);
        AVLNode<Integer> var112 = null;
        var111.setLeft(var112);
        AVLNode<Integer> var113 = null;
        var111.setRight(var113);
        var110.setLeft(var111);
        AVLNode<Integer> var114 = new AVLNode<>(rand274);var114.setHeight(0);var114.setBalanceFactor(0);
        AVLNode<Integer> var115 = null;
        var114.setLeft(var115);
        AVLNode<Integer> var116 = null;
        var114.setRight(var116);
        var110.setRight(var114);
        otherTree.setLeft(var110);
        AVLNode<Integer> var117 = new AVLNode<>(rand614);var117.setHeight(2);var117.setBalanceFactor(-1);
        AVLNode<Integer> var118 = new AVLNode<>(rand568);var118.setHeight(0);var118.setBalanceFactor(0);
        AVLNode<Integer> var119 = null;
        var118.setLeft(var119);
        AVLNode<Integer> var120 = null;
        var118.setRight(var120);
        var117.setLeft(var118);
        AVLNode<Integer> var121 = new AVLNode<>(rand834);var121.setHeight(1);var121.setBalanceFactor(-1);
        AVLNode<Integer> var122 = null;
        var121.setLeft(var122);
        AVLNode<Integer> var123 = new AVLNode<>(rand935);var123.setHeight(0);var123.setBalanceFactor(0);
        AVLNode<Integer> var124 = null;
        var123.setLeft(var124);
        AVLNode<Integer> var125 = null;
        var123.setRight(var125);
        var121.setRight(var123);
        var117.setRight(var121);
        otherTree.setRight(var117);
        assertTrue(treesEqual(otherTree));


        // Operation 14
        Integer rand678 = new Integer(678);
        tree.add(rand678);

        // Validating last operation...
        otherTree = new AVLNode<>(rand304);otherTree.setHeight(3);otherTree.setBalanceFactor(-1);
        AVLNode<Integer> var126 = new AVLNode<>(rand115);var126.setHeight(1);var126.setBalanceFactor(0);
        AVLNode<Integer> var127 = new AVLNode<>(randneg613);var127.setHeight(0);var127.setBalanceFactor(0);
        AVLNode<Integer> var128 = null;
        var127.setLeft(var128);
        AVLNode<Integer> var129 = null;
        var127.setRight(var129);
        var126.setLeft(var127);
        AVLNode<Integer> var130 = new AVLNode<>(rand274);var130.setHeight(0);var130.setBalanceFactor(0);
        AVLNode<Integer> var131 = null;
        var130.setLeft(var131);
        AVLNode<Integer> var132 = null;
        var130.setRight(var132);
        var126.setRight(var130);
        otherTree.setLeft(var126);
        AVLNode<Integer> var133 = new AVLNode<>(rand614);var133.setHeight(2);var133.setBalanceFactor(-1);
        AVLNode<Integer> var134 = new AVLNode<>(rand568);var134.setHeight(0);var134.setBalanceFactor(0);
        AVLNode<Integer> var135 = null;
        var134.setLeft(var135);
        AVLNode<Integer> var136 = null;
        var134.setRight(var136);
        var133.setLeft(var134);
        AVLNode<Integer> var137 = new AVLNode<>(rand834);var137.setHeight(1);var137.setBalanceFactor(0);
        AVLNode<Integer> var138 = new AVLNode<>(rand678);var138.setHeight(0);var138.setBalanceFactor(0);
        AVLNode<Integer> var139 = null;
        var138.setLeft(var139);
        AVLNode<Integer> var140 = null;
        var138.setRight(var140);
        var137.setLeft(var138);
        AVLNode<Integer> var141 = new AVLNode<>(rand935);var141.setHeight(0);var141.setBalanceFactor(0);
        AVLNode<Integer> var142 = null;
        var141.setLeft(var142);
        AVLNode<Integer> var143 = null;
        var141.setRight(var143);
        var137.setRight(var141);
        var133.setRight(var137);
        otherTree.setRight(var133);
        assertTrue(treesEqual(otherTree));
    }



    //


    // wordSearch edge cases

    @Test(timeout = TIMEOUT)
    public void testWordSearchEmptyArray() {
        AVL<String> letterTree = new AVL<>();

        String[] word = new String[0];
        List<String> path = letterTree.wordSearch(word);
        assertEquals(0, path.size());
        assertEquals(Collections.emptyList(), path);

        // When tree has stuff in it.
        letterTree = new AVL<>();

        letterTree.add("h");

        word = new String[0];
        path = letterTree.wordSearch(word);
        assertEquals(0, path.size());
        assertEquals(Collections.emptyList(), path);
    }

    //

    // ========================= EXCEPTION TESTS =========================

    // constructor null data
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testConstructorNull() {
        tree = new AVL<>(null);
    }

    // constructor null elems
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testConstructorNullElem() {
        tree = new AVL<>(Arrays.asList(1, 2, null, 3, 4));
    }

    // add null data
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddNull() {
        tree.add(null);
    }

    // remove null data
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testRemNull() {
        tree.remove(null);
    }

    // remove not found
    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemNotFound() {
        tree.add(1);
        tree.add(3);
        tree.add(4);
        tree.remove(2);
    }

    // get null data
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testGetNull() {
        tree.add(2);
        tree.get(null);
    }

    // get not found
    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testGetNotFound() {
        tree.add(1);
        tree.add(3);
        tree.add(4);
        tree.get(2);
    }

    // contains null data
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testContainsNull() {
        tree.add(1);
        tree.contains(null);
    }

    // word search null word
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testSearchNull() {
        tree.add(2);
        tree.wordSearch(null);
    }
}