import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

/**
 * Your implementation of various sorting algorithms.
 *
 * @author Jackson Isenberg
 * @version 1.1
 * @userid jisenberg3 (i.e. gburdell3)
 * @GTID 903556168 (i.e. 900000000)
 *
 * Collaborators: N/A
 *
 * Resources: N/A
 */

public class Sorting {

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n)
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("Arguments must not be null/");
        }
        for (int j = 1; j < arr.length; j++) {
            int i = j;
            while (i > 0 && comparator.compare(arr[i - 1], arr[i]) > 0) {
                T temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                i--;
            }
        }
    }

    /**
     * Implement cocktail sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n)
     *
     * NOTE: See pdf for last swapped optimization for cocktail sort. You
     * MUST implement cocktail sort with this optimization
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void cocktailSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("Arguments must not be null/");
        }
        boolean swapsMade = true;
        int start = 0;
        int end = arr.length - 1;
        while (swapsMade) {
            swapsMade = false;
            int startIndex = start;
            int endIndex = end;
            for (int i = start; i < end; i++) {
                if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapsMade = true;
                    endIndex = i;
                }
            }
            end = endIndex;
            if (swapsMade) {
                swapsMade = false;
                for (int i = end; i > start; i--) {
                    if (comparator.compare(arr[i - 1], arr[i]) > 0) {
                        T temp = arr[i];
                        arr[i] = arr[i - 1];
                        arr[i - 1] = temp;
                        swapsMade = true;
                        startIndex = i;
                    }
                }
                start = startIndex;
            }
        }
    }

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(n log n)
     *
     * And a best case running time of:
     * O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: If two data are equal when merging, think about which subarray
     * you should pull from first
     *
     * @param <T>        data type to sort
     * @param arr        the array to be sorted
     * @param comparator the Comparator used to compare the data in arr
     * @throws IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("Arguments must not be null/");
        }

        // base case
        if (arr.length < 2) {
            return;
        }

        // create the left and right subarrays
        int length = arr.length;
        int mid = length / 2;
        T[] left = (T[]) new Object[mid];
        T[] right = (T[]) new Object[length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < length; i++) {
            right[i - mid] = arr[i];
        }
        mergeSort(left, comparator);
        mergeSort(right, comparator);

        // merge the two arrays
        int i = 0;
        int j = 0;
        while (i < left.length && j < right.length) {
            if (comparator.compare(right[j], left[i]) > 0) {
                arr[i + j] = left[i];
                i++;
            } else {
                arr[i + j] = right[j];
                j++;
            }
        }

        // copy over the rest of the array if needed
        while (i < left.length) {
            arr[i + j] = left[i];
            i++;
        }
        while (j < right.length) {
            arr[i + j] = right[j];
            j++;
        }
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not get full
     * credit if you do not implement the one we have taught you!
     *
     * Remember you CANNOT convert the ints to strings at any point in your
     * code! Doing so may result in a 0 for the implementation.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(kn)
     *
     * And a best case running time of:
     * O(kn)
     *
     * You are allowed to make an initial O(n) passthrough of the array to
     * determine the number of iterations you need.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * Refer to the PDF for more information on LSD Radix Sort.
     *
     * You may use ArrayList or LinkedList if you wish, but it may only be
     * used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with other sorts. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * @param arr the array to be sorted
     * @throws java.lang.IllegalArgumentException if the array is null
     */
    public static void lsdRadixSort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Arguments must be non-null");
        }

        // find the max value
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int abs = arr[i] == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(arr[i]);
            if (abs > max) {
                max = abs;
            }
        }

        // perform the sort using buckets
        LinkedList<Integer>[] buckets = (LinkedList<Integer>[]) new LinkedList[19];
        for (int pow = 1; max / pow > 0; pow *= 10) {
            for (int i = 0; i < arr.length; i++) {
                int digit = (arr[i] / pow) % 10;
                if (buckets[digit + 9] == null) {
                    buckets[digit + 9] = new LinkedList<>();
                }
                buckets[digit + 9].add(arr[i]);
            }
            int idx = 0;
            for (LinkedList<Integer> bucket : buckets) {
                while (bucket != null && !bucket.isEmpty()) {
                    arr[idx++] = bucket.remove();
                }
            }
        }
    }

    /**
     * Implement quick sort.
     *
     * Use the provided random object to select your pivots. For example if you
     * need a pivot between a (inclusive) and b (exclusive) where b > a, use
     * the following code:
     *
     * int pivotIndex = rand.nextInt(b - a) + a;
     *
     * If your recursion uses an inclusive b instead of an exclusive one,
     * the formula changes by adding 1 to the nextInt() call:
     *
     * int pivotIndex = rand.nextInt(b - a + 1) + a;
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n log n)
     *
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not receive
     * credit if you do not use the one we have taught you!
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @param rand       the Random object used to select pivots
     * @throws java.lang.IllegalArgumentException if the array or comparator or
     *                                            rand is null
     */
    public static <T> void quickSort(T[] arr, Comparator<T> comparator,
                                     Random rand) {
        quickSort(arr, 0, arr.length - 1, comparator, rand);
    }

    /**
     * Quicksort helper method
     *
     * @param <T>           data type to sort
     * @param arr           the array that must be sorted after the method runs
     * @param a             the start index
     * @param b             the end index
     * @param comparator    the Comparator used to compare the data in arr
     * @param rand          the Random object used to select pivots
     */
    private static <T> void quickSort(T[] arr, int a, int b, Comparator<T> comparator, Random rand) {
        if (b - a < 1) {
            return;
        }
        int pivotIndex = rand.nextInt(b - a + 1) + a;
        T pivot = arr[pivotIndex];
        arr[pivotIndex] = arr[a];
        arr[a] = pivot;
        int i = a + 1;
        int j = b;
        while (j >= i) {
            while (j >= i && comparator.compare(arr[i], pivot) <= 0) {
                i++;
            }
            while (j >= i && comparator.compare(arr[j], pivot) >= 0) {
                j--;
            }
            if (j >= i) {
                T temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
                j--;
            }
        }
        T temp = arr[a];
        arr[a] = arr[j];
        arr[j] = temp;
        quickSort(arr, a, j - 1, comparator, rand);
        quickSort(arr, j + 1, b, comparator, rand);
    }
}
