import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.Random;

/**
 * This is a basic set of unit tests for Sorting.
 *
 * Passing these tests doesn't guarantee any grade on these assignments. These
 * student JUnits that we provide should be thought of as a sanity check to
 * help you get started on the homework and writing JUnits in general.
 *
 * We highly encourage you to write your own set of JUnits for each homework
 * to cover edge cases you can think of for each data structure. Your code must
 * work correctly and efficiently in all cases, which is why it's important
 * to write comprehensive tests to cover as many cases as possible.
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public class SortingStudentTest {

    private static final int TIMEOUT = 200;
    private TeachingAssistant[] tas;
    private TeachingAssistant[] tasByName;
    private ComparatorPlus<TeachingAssistant> comp;

    @Before
    public void setUp() {
        /*
            Unsorted Names:
                index 0: Alex
                index 1: Ivan
                index 2: Miguel
                index 3: Reece
                index 4: Eunseo
                index 5: Antonia
                index 6: Yotam
                index 7: Mitchell
                index 8: Harrison
                index 9: Destini
         */

        /*
            Sorted Names:
                index 0: Alex
                index 1: Antonia
                index 2: Destini
                index 3: Eunseo
                index 4: Harrison
                index 5: Ivan
                index 6: Miguel
                index 7: Mitchell
                index 8: Reece
                index 9: Yotam
         */

        tas = new TeachingAssistant[10];
        tas[0] = new TeachingAssistant("Alex");
        tas[1] = new TeachingAssistant("Ivan");
        tas[2] = new TeachingAssistant("Miguel");
        tas[3] = new TeachingAssistant("Reece");
        tas[4] = new TeachingAssistant("Eunseo");
        tas[5] = new TeachingAssistant("Antonia");
        tas[6] = new TeachingAssistant("Yotam");
        tas[7] = new TeachingAssistant("Mitchell");
        tas[8] = new TeachingAssistant("Harrison");
        tas[9] = new TeachingAssistant("Destini");
        tasByName = new TeachingAssistant[10];
        tasByName[0] = tas[0];
        tasByName[1] = tas[5];
        tasByName[2] = tas[9];
        tasByName[3] = tas[4];
        tasByName[4] = tas[8];
        tasByName[5] = tas[1];
        tasByName[6] = tas[2];
        tasByName[7] = tas[7];
        tasByName[8] = tas[3];
        tasByName[9] = tas[6];

        comp = TeachingAssistant.getNameComparator();
    }

    @Test(timeout = TIMEOUT)
    public void testInsertionSort() {
        Sorting.insertionSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Number of comparisons: " + comp.getCount(),
            comp.getCount() <= 30 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testCocktailSort() {
        Sorting.cocktailSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Number of comparisons: " + comp.getCount(),
            comp.getCount() <= 33 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testMergeSort() {
        Sorting.mergeSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Number of comparisons: " + comp.getCount(),
            comp.getCount() <= 24 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testLsdRadixSort() {
        int[] unsortedArray = new int[] {54, 28, 58, 84, 20, 122, -85, 3};
        int[] sortedArray = new int[] {-85, 3, 20, 28, 54, 58, 84, 122};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test(timeout = TIMEOUT)
    public void testQuickSort() {
        Sorting.quickSort(tas, comp, new Random(234));
        assertArrayEquals(tasByName, tas);
        assertTrue("Number of comparisons: " + comp.getCount(),
            comp.getCount() <= 30 && comp.getCount() != 0);
    }

    /**
     * Class for testing proper sorting.
     */
    private static class TeachingAssistant {
        private String name;

        /**
         * Create a teaching assistant.
         *
         * @param name name of TA
         */
        public TeachingAssistant(String name) {
            this.name = name;
        }

        /**
         * Get the name of the teaching assistant.
         *
         * @return name of teaching assistant
         */
        public String getName() {
            return name;
        }

        /**
         * Create a comparator that compares the names of the teaching
         * assistants.
         *
         * @return comparator that compares the names of the teaching assistants
         */
        public static ComparatorPlus<TeachingAssistant> getNameComparator() {
            return new ComparatorPlus<TeachingAssistant>() {
                @Override
                public int compare(TeachingAssistant ta1,
                                   TeachingAssistant ta2) {
                    incrementCount();
                    return ta1.getName().compareTo(ta2.getName());
                }
            };
        }

        @Override
        public String toString() {
            return "Name: " + name;
        }

        @Override
        public boolean equals(Object other) {
            if (other == null) {
                return false;
            }
            if (this == other) {
                return true;
            }
            return other instanceof TeachingAssistant
                && ((TeachingAssistant) other).name.equals(this.name);
        }
    }

    /**
     * Inner class that allows counting how many comparisons were made.
     */
    private abstract static class ComparatorPlus<T> implements Comparator<T> {
        private int count;

        /**
         * Get the number of comparisons made.
         *
         * @return number of comparisons made
         */
        public int getCount() {
            return count;
        }

        /**
         * Increment the number of comparisons made by one. Call this method in
         * your compare() implementation.
         */
        public void incrementCount() {
            count++;
        }
    }
}