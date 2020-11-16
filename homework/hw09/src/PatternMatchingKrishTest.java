import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Krish Nathan knathan8@gatech.edu
 * @version 1.0
 */

public class PatternMatchingKrishTest {

    private CharacterComparator comparator;

    private static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        this.comparator = new CharacterComparator();
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable() {
        CharSequence pattern1 = "abacab";
        Map<Character, Integer> expected1 = new HashMap<>();
        expected1.put('a', 4);
        expected1.put('b', 5);
        expected1.put('c', 3);

        assertEquals(expected1, PatternMatching.buildLastTable(pattern1));

        CharSequence pattern2 = "happy";
        Map<Character, Integer> expected2 = new HashMap<>();
        expected2.put('a', 1);
        expected2.put('h', 0);
        expected2.put('p', 3);
        expected2.put('y', 4);

        assertEquals(expected2, PatternMatching.buildLastTable(pattern2));
    }

    // example from https://gatech.instructure.com/courses/132344/files/folder/Slides_Videos/Module12?preview=14378223
    @Test(timeout = TIMEOUT)
    public void testBoyerMooreSingle1() {
        CharSequence pattern = "abacab";
        CharSequence text = "abacbabadcabacab";

        List<Integer> expected = new ArrayList<>();
        expected.add(10);

        List<Integer> indices = PatternMatching.boyerMoore(pattern, text,
                this.comparator);

        assertEquals(expected, indices);
        assertEquals(13, comparator.getComparisonCount());
    }

    // example from https://gatech.instructure.com/courses/132344/files/folder/Slides_Videos/Module12?preview=14378289
    @Test(timeout = TIMEOUT)
    public void testBoyerMooreSingle2() {
        CharSequence pattern = "happy";
        CharSequence text = "because im happy";

        List<Integer> expected = new ArrayList<>();
        expected.add(11);

        List<Integer> indices = PatternMatching.boyerMoore(pattern, text,
                this.comparator);

        assertEquals(expected, indices);
        assertEquals(8, comparator.getComparisonCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreMultiple() {
        CharSequence pattern = "bcabc";
        CharSequence text = "afghbcabcabcr";

        /*
        Pattern: "bcabc"
        LOT: a  b  c
             2  3  4
        Text:     a f g h b c a b c a b c r
        Pattern:  b c a b c                     1 comp, shift = 3, i = 0+4-3 = 1
                    b c a b c                   3 comp, shift = -1, i = 1+2-(-1) = 4
                          b c a b c             5 comp, match
                            b c a b c           1 comp, shift = 2, i=5+4-2=7
                                b c a b c       5 comp, match
                                  b c a b c     1 comp, end
         */

        List<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(7);

        List<Integer> indices = PatternMatching.boyerMoore(pattern, text,
                this.comparator);

        assertEquals(expected, indices);
        assertEquals(16, comparator.getComparisonCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreBestCase() {
        // this is the best case because the last letter in the pattern is
        // not contained in the text so we can always skip
        CharSequence pattern = "rock";
        CharSequence text = "the red roses grow in ireland";

        List<Integer> expected = new ArrayList<>();

        List<Integer> indices = PatternMatching.boyerMoore(pattern, text,
                this.comparator);

        assertEquals(expected, indices);
        assertEquals(7, comparator.getComparisonCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreWorstCase() {
        // this is the worst case because we always mismatch on the first
        // character in the pattern, so Boyer Moore becomes brute force
        CharSequence pattern = "baaaa";
        CharSequence text = "aaaaaaaaaaabaaaaa";

        List<Integer> expected = new ArrayList<>();
        expected.add(11);

        List<Integer> indices = PatternMatching.boyerMoore(pattern, text,
                this.comparator);

        assertEquals(expected, indices);
        assertEquals(46, comparator.getComparisonCount());

    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable1() {
        CharSequence pattern1 = "revararev";
        int[] expected1 = new int[]{0, 0, 0, 0, 1, 0, 1, 2, 3};
        assertArrayEquals(expected1, PatternMatching.buildFailureTable(pattern1,
                this.comparator));
        assertEquals(9, comparator.getComparisonCount());
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable2() {
        CharSequence pattern2 = "abacada";
        int[] expected2 = new int[]{0, 0, 1, 0, 1, 0, 1};
        assertArrayEquals(expected2, PatternMatching.buildFailureTable(pattern2,
                this.comparator));
        assertEquals(8, comparator.getComparisonCount());
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable3() {
        CharSequence pattern3 = "theatha";
        int[] expected3 = new int[]{0, 0, 0, 0, 1, 2, 0};
        assertArrayEquals(expected3, PatternMatching.buildFailureTable(pattern3,
                this.comparator));
        assertEquals(7, comparator.getComparisonCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMPSingle() {
        CharSequence text = "ababacadabaabacabacaba";
        CharSequence pattern = "abacaba";

        List<Integer> expected = new ArrayList<>();

        expected.add(11);
        expected.add(15);

        // 7 comparisons for failure table, 27 comparisons for KMP algorithm

        assertEquals(expected, PatternMatching.kmp(pattern, text, this.comparator));
        assertEquals(34, comparator.getComparisonCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMPMultipleMatches1() {
        CharSequence text = "acdefedefedefgbdefedef";
        CharSequence pattern = "defedef";

        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(6);
        expected.add(15);

        // 6 comparisons for failure table, 23 comparisons for KMP algorithm

        assertEquals(expected, PatternMatching.kmp(pattern, text, this.comparator));
        assertEquals(29, comparator.getComparisonCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMPRepetitivePattern() {
        CharSequence text = "cccccaaaaacatacac";
        CharSequence pattern = "acatacac";

        List<Integer> expected = new ArrayList<>();
        expected.add(9);

        // 9 comparisons for failure table, 21 comparisons for KMP algorithm

        assertEquals(expected, PatternMatching.kmp(pattern, text, this.comparator));
        assertEquals(30, comparator.getComparisonCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMPWorstCase() {
        CharSequence text = "bbbabbbabbbbabbbabbba";
        CharSequence pattern = "bbbb";

        List<Integer> expected = new ArrayList<>();
        expected.add(8);

        // 3 comparisons for failure table, 33 comparisons for KMP algorithm

        assertEquals(expected, PatternMatching.kmp(pattern, text, this.comparator));
        assertEquals(36, comparator.getComparisonCount());
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpWorstCase() {
        // this is the worst case because the hash always matches, so we have
        // to compare the pattern to every substring in the text
        CharSequence text = "aaaaaaaaaaaaaa";
        CharSequence pattern = "aaa";

        List<Integer> expected = new ArrayList<>();
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            expected.add(i);
        }

        assertEquals(expected, PatternMatching.rabinKarp(pattern, text,
                this.comparator));
        assertEquals(36, comparator.getComparisonCount());
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpBestCase() {
        // this is the best case because the hash of the text and pattern
        // match exactly twice when the pattern appears in the text
        CharSequence text = "cdbaedafagebcabdfage";
        CharSequence pattern = "fage";

        List<Integer> expected = new ArrayList<>();
        expected.add(7);
        expected.add(16);

        assertEquals(expected, PatternMatching.rabinKarp(pattern, text,
                this.comparator));
        assertEquals(8, comparator.getComparisonCount());
    }

}
