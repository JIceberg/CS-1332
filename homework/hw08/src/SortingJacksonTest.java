import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Tests to check that all cases pass for randomly generated arrays
 *
 * @author Jackson Isenberg
 * @version 1.0
 */
public class SortingJacksonTest {

    private static final int TIMEOUT = 200;
    private Integer[] array;
    private int[] intArray;
    private Comparator<Integer> comparator;

    @Before
    public void setUp() {
        array = new Integer[(int) (Math.random() * 20 + 1)];
        intArray = new int[array.length];
        comparator = Comparator.comparingInt(a -> a);
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 101 - 50);
            intArray[i] = array[i];
        }
    }

    private boolean isSorted(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Test(timeout = TIMEOUT)
    public void testInsertionSort() {
        for (int i = 0; i < 100; i++) {
            setUp();
            Sorting.insertionSort(array, comparator);
            assertTrue(isSorted(array));
        }
    }

    @Test(timeout = TIMEOUT)
    public void testCocktailSort() {
        for (int i = 0; i < 100; i++) {
            setUp();
            Sorting.cocktailSort(array, comparator);
            assertTrue(isSorted(array));
        }
    }

    @Test(timeout = TIMEOUT)
    public void testMergeSort() {
        for (int i = 0; i < 100; i++) {
            setUp();
            Sorting.mergeSort(array, comparator);
            assertTrue(isSorted(array));
        }
    }

    @Test(timeout = TIMEOUT)
    public void testRadixSort() {
        for (int i = 0; i < 100; i++) {
            setUp();
            Sorting.lsdRadixSort(intArray);
            assertTrue(isSorted(intArray));
        }
    }

    @Test(timeout = TIMEOUT)
    public void testQuickSort() {
        for (int i = 0; i < 100; i++) {
            setUp();
            Sorting.quickSort(array, comparator, new Random(254));
            assertTrue(isSorted(array));
        }
    }

}
