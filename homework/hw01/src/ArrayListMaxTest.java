import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Each test checks each method individually.
 * <p>
 * 1. For all add method tests, shifting and doubling capacity is checked (capacity is
 * doubled twice).
 * <p>
 * 2. For all remove method tests, shifting is checked.
 * <p>
 * 3. Other methods are checked as well.
 * <p>
 * 4. For all invalid input tests, exception is expected and list should be unchanged.
 *
 * @author Yoo Ri Jhang
 * @version 1.0
 */

/*  IF YOU NEED TO SEE YOUR RESULT IN THE TERMINAL OR DEBUG, USE THIS TO PRINT YOUR ARRAYLIST IN TERMINAL
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
*/
public class ArrayListMaxTest {

    private static final int TIMEOUT = 200;
    private ArrayList<String> list;

    @Before
    public void setUp() {
        list = new ArrayList<>();
    }

    // ADD TESTS .................................................................
    @Test(timeout = TIMEOUT)
    public void testAddAtIndex() {  // tests adding to front, back, and elsewhere indexes
        list.addAtIndex(0, "3a");   // 3a   ... EDGE CASE: tests adding to front
        list.addAtIndex(0, "1a");   // 1a, 3a
        list.addAtIndex(1, "2a");   // 1a, 2a, 3a   ... tests adding to middle
        list.addAtIndex(3, "8a");   // 1a, 2a, 3a, 8a   ... EDGE CASE: tests adding to back
        list.addAtIndex(3, "5a");   // 1a, 2a, 3a, 5a, 8a
        list.addAtIndex(4, "6a");   // 1a, 2a, 3a, 5a, 6a, 8a
        list.addAtIndex(5, "7a");   // 1a, 2a, 3a, 5a, 6a, 7a, 8a
        list.addAtIndex(3, "4a");   // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a
        list.addAtIndex(8, "9a");   // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a

        assertEquals(9, list.size());
        String[] expected = new String[9];
        expected[0] = "1a";
        expected[1] = "2a";
        expected[2] = "3a";
        expected[3] = "4a";
        expected[4] = "5a";
        expected[5] = "6a";
        expected[6] = "7a";
        expected[7] = "8a";
        expected[8] = "9a";
        assertArrayEquals(expected, list.getBackingArray());

        list.addAtIndex(9, "3a");   // ... 3a   ... EDGE CASE: adding to back after full, capacity doubles
        list.addAtIndex(9, "1a");   // ... 1a, 3a
        list.addAtIndex(10, "2a");   // ... 1a, 2a, 3a
        list.addAtIndex(12, "9a");   // ... 1a, 2a, 3a, 9a
        list.addAtIndex(12, "5a");   // ... 1a, 2a, 3a, 5a, 9a
        list.addAtIndex(13, "6a");   // ... 1a, 2a, 3a, 5a, 6a, 9a
        list.addAtIndex(14, "7a");   // ... 1a, 2a, 3a, 5a, 6a, 7a, 9a
        list.addAtIndex(12, "4a");   // ... 1a, 2a, 3a, 4a, 5a, 6a, 7a, 9a
        list.addAtIndex(16, "8a");   // ... 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a

        assertEquals(18, list.size());
        expected = new String[18];
        expected[0] = "1a";
        expected[1] = "2a";
        expected[2] = "3a";
        expected[3] = "4a";
        expected[4] = "5a";
        expected[5] = "6a";
        expected[6] = "7a";
        expected[7] = "8a";
        expected[8] = "9a";
        expected[9] = "1a";
        expected[10] = "2a";
        expected[11] = "3a";
        expected[12] = "4a";
        expected[13] = "5a";
        expected[14] = "6a";
        expected[15] = "7a";
        expected[16] = "8a";
        expected[17] = "9a";
        assertArrayEquals(expected, list.getBackingArray());

        // should be double capacity now
        list.addAtIndex(0, "start");    // start ... ...    EDGE CASE: adding to front after full, capacity doubles
        list.addAtIndex(19, "3a");   // start ... ... 3a
        list.addAtIndex(19, "2a");   // start ... ... 2a, 3a
        list.addAtIndex(21, "8a");   // start ... ... 2a, 3a, 8a
        list.addAtIndex(21, "5a");   // start ... ... 2a, 3a, 5a, 8a
        list.addAtIndex(22, "6a");   // start .. ... 2a, 3a, 5a, 6a, 8a
        list.addAtIndex(23, "7a");   // start ... ... 2a, 3a, 5a, 6a, 7a, 8a
        list.addAtIndex(21, "4a");   // start ... ... 2a, 3a, 4a, 5a, 6a, 7a, 8a
        list.addAtIndex(26, "9a");   // start ... ... 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a
        list.addAtIndex(19, "1a");   // start ... ... 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a
        assertEquals(28, list.size());
        expected = new String[36];
        expected[0] = "start";
        expected[1] = "1a";
        expected[2] = "2a";
        expected[3] = "3a";
        expected[4] = "4a";
        expected[5] = "5a";
        expected[6] = "6a";
        expected[7] = "7a";
        expected[8] = "8a";
        expected[9] = "9a";
        expected[10] = "1a";
        expected[11] = "2a";
        expected[12] = "3a";
        expected[13] = "4a";
        expected[14] = "5a";
        expected[15] = "6a";
        expected[16] = "7a";
        expected[17] = "8a";
        expected[18] = "9a";
        expected[19] = "1a";
        expected[20] = "2a";
        expected[21] = "3a";
        expected[22] = "4a";
        expected[23] = "5a";
        expected[24] = "6a";
        expected[25] = "7a";
        expected[26] = "8a";
        expected[27] = "9a";
        assertArrayEquals(expected, list.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddToFront() {
        list.addToFront("9a");
        list.addToFront("8a");
        list.addToFront("7a");
        list.addToFront("6a");
        list.addToFront("5a");
        list.addToFront("4a");
        list.addToFront("3a");
        list.addToFront("2a");
        list.addToFront("1a");  // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a
        // full, need to resize for next input

        assertEquals(9, list.size());

        list.addToFront("9a");  // should be double capacity now
        list.addToFront("8a");
        list.addToFront("7a");
        list.addToFront("6a");
        list.addToFront("5a");
        list.addToFront("4a");
        list.addToFront("3a");
        list.addToFront("2a");
        list.addToFront("1a");  // ... 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a
        // full, need to resize for next input

        assertEquals(18, list.size());

        list.addToFront("9a");  // should be double capacity now
        list.addToFront("8a");
        list.addToFront("7a");
        list.addToFront("6a");
        list.addToFront("5a");
        list.addToFront("4a");
        list.addToFront("3a");
        list.addToFront("2a");
        list.addToFront("1a");  // ... ... 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a

        assertEquals(27, list.size());
        String[] expected = new String[36];
        expected[0] = "1a";
        expected[1] = "2a";
        expected[2] = "3a";
        expected[3] = "4a";
        expected[4] = "5a";
        expected[5] = "6a";
        expected[6] = "7a";
        expected[7] = "8a";
        expected[8] = "9a";
        expected[9] = "1a";
        expected[10] = "2a";
        expected[11] = "3a";
        expected[12] = "4a";
        expected[13] = "5a";
        expected[14] = "6a";
        expected[15] = "7a";
        expected[16] = "8a";
        expected[17] = "9a";
        expected[18] = "1a";
        expected[19] = "2a";
        expected[20] = "3a";
        expected[21] = "4a";
        expected[22] = "5a";
        expected[23] = "6a";
        expected[24] = "7a";
        expected[25] = "8a";
        expected[26] = "9a";
        assertArrayEquals(expected, list.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddToBack() {
        list.addToBack("1a");
        list.addToBack("2a");
        list.addToBack("3a");
        list.addToBack("4a");
        list.addToBack("5a");
        list.addToBack("6a");
        list.addToBack("7a");
        list.addToBack("8a");
        list.addToBack("9a");   // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a

        assertEquals(9, list.size());
        // full, need to resize for next input

        list.addToBack("1a");   // should be double capacity now
        list.addToBack("2a");
        list.addToBack("3a");
        list.addToBack("4a");
        list.addToBack("5a");
        list.addToBack("6a");
        list.addToBack("7a");
        list.addToBack("8a");
        list.addToBack("9a");   // ... 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a

        assertEquals(18, list.size());
        // full, need to resize for next input

        list.addToBack("1a");   // should be double capacity now
        list.addToBack("2a");
        list.addToBack("3a");
        list.addToBack("4a");
        list.addToBack("5a");
        list.addToBack("6a");
        list.addToBack("7a");
        list.addToBack("8a");
        list.addToBack("9a");   // ... ... 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a

        assertEquals(27, list.size());
        String[] expected = new String[36];
        expected[0] = "1a";
        expected[1] = "2a";
        expected[2] = "3a";
        expected[3] = "4a";
        expected[4] = "5a";
        expected[5] = "6a";
        expected[6] = "7a";
        expected[7] = "8a";
        expected[8] = "9a";
        expected[9] = "1a";
        expected[10] = "2a";
        expected[11] = "3a";
        expected[12] = "4a";
        expected[13] = "5a";
        expected[14] = "6a";
        expected[15] = "7a";
        expected[16] = "8a";
        expected[17] = "9a";
        expected[18] = "1a";
        expected[19] = "2a";
        expected[20] = "3a";
        expected[21] = "4a";
        expected[22] = "5a";
        expected[23] = "6a";
        expected[24] = "7a";
        expected[25] = "8a";
        expected[26] = "9a";
        assertArrayEquals(expected, list.getBackingArray());
    }

    // REMOVE TESTS ..............................................................
    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndex() {
        list.addAtIndex(0, "3a");   // 3a
        list.addAtIndex(0, "1a");   // 1a, 3a
        list.addAtIndex(1, "2a");   // 1a, 2a, 3a
        list.addAtIndex(3, "8a");   // 1a, 2a, 3a, 8a
        list.addAtIndex(3, "5a");   // 1a, 2a, 3a, 5a, 8a
        list.addAtIndex(4, "6a");   // 1a, 2a, 3a, 5a, 6a, 8a
        list.addAtIndex(5, "7a");   // 1a, 2a, 3a, 5a, 6a, 7a, 8a
        list.addAtIndex(3, "4a");   // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a
        list.addAtIndex(8, "9a");   // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a

        assertEquals(9, list.size());

        //EDGE CASE: removing from back.. could run into problems with your left-shifting!
        list.removeAtIndex(8);  // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a
        //EDGE CASE: removing from front
        list.removeAtIndex(0);  // 2a, 3a, 4a, 5a, 6a, 7a, 8a
        //removing from a middle index
        list.removeAtIndex(3);  // 2a, 3a, 4a, 6a, 7a, 8a

        assertEquals(6, list.size());   //size should decrease
        String[] expected = new String[9];
        expected[0] = "2a";
        expected[1] = "3a";
        expected[2] = "4a";
        expected[3] = "6a";
        expected[4] = "7a";
        expected[5] = "8a";
        assertArrayEquals(expected, list.getBackingArray());
    }
    @Test(timeout = TIMEOUT)
    public void testRemoveFromFront() {
        list.addAtIndex(0, "3a");   // 3a
        list.addAtIndex(0, "1a");   // 1a, 3a
        list.addAtIndex(1, "2a");   // 1a, 2a, 3a
        list.addAtIndex(3, "8a");   // 1a, 2a, 3a, 8a
        list.addAtIndex(3, "5a");   // 1a, 2a, 3a, 5a, 8a
        list.addAtIndex(4, "6a");   // 1a, 2a, 3a, 5a, 6a, 8a
        list.addAtIndex(5, "7a");   // 1a, 2a, 3a, 5a, 6a, 7a, 8a
        list.addAtIndex(3, "4a");   // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a
        list.addAtIndex(8, "9a");   // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a
        list.addAtIndex(9, "1a");   // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a, 1a

        assertEquals(10, list.size());

        //capacity should stay the same!!
        list.removeFromFront(); // 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a, 1a

        assertEquals(9, list.size());
        String[] expected = new String[18];
        expected[0] = "2a";
        expected[1] = "3a";
        expected[2] = "4a";
        expected[3] = "5a";
        expected[4] = "6a";
        expected[5] = "7a";
        expected[6] = "8a";
        expected[7] = "9a";
        expected[8] = "1a";
        assertArrayEquals(expected, list.getBackingArray());

        for (int i = 0; i < 9; i++) {   // clearing everything
            list.removeFromFront();
        }

        assertEquals(0, list.size());
        expected = new String[18];
        assertArrayEquals(expected, list.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromBack() {
        list.addAtIndex(0, "3a");   // 3a
        list.addAtIndex(0, "1a");   // 1a, 3a
        list.addAtIndex(1, "2a");   // 1a, 2a, 3a
        list.addAtIndex(3, "8a");   // 1a, 2a, 3a, 8a
        list.addAtIndex(3, "5a");   // 1a, 2a, 3a, 5a, 8a
        list.addAtIndex(4, "6a");   // 1a, 2a, 3a, 5a, 6a, 8a
        list.addAtIndex(5, "7a");   // 1a, 2a, 3a, 5a, 6a, 7a, 8a
        list.addAtIndex(3, "4a");   // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a
        list.addAtIndex(8, "9a");   // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a
        list.addAtIndex(9, "1a");   // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a, 1a

        assertEquals(10, list.size());

        //capacity should stay the same!!
        list.removeFromBack(); // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a

        assertEquals(9, list.size());
        String[] expected = new String[18];
        expected[0] = "1a";
        expected[1] = "2a";
        expected[2] = "3a";
        expected[3] = "4a";
        expected[4] = "5a";
        expected[5] = "6a";
        expected[6] = "7a";
        expected[7] = "8a";
        expected[8] = "9a";
        assertArrayEquals(expected, list.getBackingArray());

        for (int i = 0; i < 9; i++) { // clearing everything
            list.removeFromFront();
        }

        assertEquals(0, list.size());
        expected = new String[18];
        assertArrayEquals(expected, list.getBackingArray());
    }

    // GET, ISEMPTY, CLEAR TESTS .............................................................
    @Test(timeout = TIMEOUT)
    public void getTest() {
        list.addToFront("4a");
        list.addToFront("3a");
        list.addToFront("2a");
        list.addToFront("1a");  // 1a, 2a, 3a, 4a

        assertEquals("4a", list.get(3));
        assertEquals("1a", list.get(0));
    }

    @Test(timeout = TIMEOUT)
    public void isEmptyTest() {
        assertTrue(list.isEmpty());

        list.addToFront("4a");

        assertFalse(list.isEmpty());

        list.removeFromBack();

        assertTrue(list.isEmpty());
    }

    @Test(timeout = TIMEOUT)
    public void clearTest() {
        list.addAtIndex(0, "3a");   // 3a
        list.addAtIndex(0, "1a");   // 1a, 3a
        list.addAtIndex(1, "2a");   // 1a, 2a, 3a
        list.addAtIndex(3, "8a");   // 1a, 2a, 3a, 8a
        list.addAtIndex(3, "5a");   // 1a, 2a, 3a, 5a, 8a
        list.addAtIndex(4, "6a");   // 1a, 2a, 3a, 5a, 6a, 8a
        list.addAtIndex(5, "7a");   // 1a, 2a, 3a, 5a, 6a, 7a, 8a
        list.addAtIndex(3, "4a");   // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a
        list.addAtIndex(8, "9a");   // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a
        list.addAtIndex(9, "1a");   // 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a, 1a

        //should go back to initial capacity 9
        list.clear();

        assertEquals(0, list.size());
        String[] expected = new String[9];
        assertArrayEquals(expected, list.getBackingArray());
    }

    // EXCEPTION TESTS .............................................................
    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void addAtIndexException1() {    //negative index
        list.addToFront("4a");
        list.addToFront("3a");
        list.addToFront("2a");
        list.addToFront("1a");  // 1a, 2a, 3a, 4a

        list.addAtIndex(-1, "invalid index");
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void addAtIndexException2() {    //index > size (adding to further than back)
        list.addToFront("4a");
        list.addToFront("3a");
        list.addToFront("2a");
        list.addToFront("1a");  // 1a, 2a, 3a, 4a

        list.addAtIndex(5, "invalid index");
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void addAtIndexException3() {
        list.addToFront("4a");
        list.addToFront("3a");
        list.addToFront("2a");
        list.addToFront("1a");  // 1a, 2a, 3a, 4a

        list.addAtIndex(2, null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void addToFrontException() {
        list.addToFront("4a");
        list.addToFront("3a");
        list.addToFront("2a");
        list.addToFront("1a");  // 1a, 2a, 3a, 4a

        list.addToFront(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void addToBackException() {
        list.addToFront("4a");
        list.addToFront("3a");
        list.addToFront("2a");
        list.addToFront("1a");  // 1a, 2a, 3a, 4a

        list.addToBack(null);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void removeAtIndexException1() {
        list.addToFront("4a");
        list.addToFront("3a");
        list.addToFront("2a");
        list.addToFront("1a");  // 1a, 2a, 3a, 4a

        list.removeAtIndex(-1);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void removeAtIndexException2() {
        list.addToFront("4a");
        list.addToFront("3a");
        list.addToFront("2a");
        list.addToFront("1a");  // 1a, 2a, 3a, 4a

        list.removeAtIndex(4);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void removeFromFrontException() {
        list.removeFromFront();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void removeFromBackException() {
        list.removeFromBack();
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void getException1() {
        list.get(-3);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void getException2() {
        list.addToFront("4a");
        list.addToFront("3a");
        list.addToFront("2a");
        list.addToFront("1a");  // 1a, 2a, 3a, 4a

        list.get(4);
    }
}