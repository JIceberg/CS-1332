import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Charlie Jenkins cjenkins72@gatech.edu
 * @version 1.0
 */
public class PatternMatchingCharlieTest {

    private CharacterComparator comparator;

    @Rule
    public Timeout globalTimeout = new Timeout(200, TimeUnit.MILLISECONDS);

    @Before
    public void setup() {
        comparator = new CharacterComparator();
    }

    @Test
    public void testBuildFailureTableCase3() {
        /*
            pattern: abaababa
            failure table: [0, 0, 1, 1, 2, 3, 2, 3]
            comparisons: 9
         */
        int[] failureTable = PatternMatching.buildFailureTable("abaababa", comparator);
        int[] expected = {0, 0, 1, 1, 2, 3, 2, 3};
        assertArrayEquals(expected, failureTable);
        assertTrue("Did not use the comparator.",
                comparator.getComparisonCount() != 0);
        assertEquals("Comparison count was " + comparator.getComparisonCount()
                + ". Should be 9.", 9, comparator.getComparisonCount());
    }

    @Test
    public void testPatternLongerThanTextKMP() {
        /*
            pattern: abaababa
            text: aba
            comparisons: 0
         */
        List<Integer> kmpResult = PatternMatching.kmp("abaababa", "aba", comparator);
        assertTrue(kmpResult.isEmpty());
        assertEquals("Comparison count was " + comparator.getComparisonCount()
                + ". Should be 0.", 0, comparator.getComparisonCount());
    }

    @Test
    public void testKMPMatchCase3() {
        /*
            pattern: abaababa
            text: abaababaaabaababa
            indices: 0, 9
            expected total comparison: 28 (19 from searching, 9 from failure table)
            failure table: [0, 0, 1, 1, 2, 3, 2, 3]
            comparisons: 9
        0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10| 11| 12| 13| 14| 15| 16
        a | b | a | a | b | a | b | a | a | a | b | a | a | b | a | b | a
        --+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---
        a | b | a | a | b | a | b | a |   |   |   |   |   |   |   |   |
        - | - | - | - | - | - | - | - |   |   |   |   |   |   |   |   |     comparisons: 8
          |   |   |   |   | a | b | a | a | b | a | b | a |   |   |   |
          |   |   |   |   |   |   |   | - | - |   |   |   |   |   |   |     comparisons: 2
          |   |   |   |   |   |   |   | a | b | a | a | b | a | b | a |
          |   |   |   |   |   |   |   |   | - |   |   |   |   |   |   |     comparisons: 1
          |   |   |   |   |   |   |   |   | a | b | a | a | b | a | b | a
          |   |   |   |   |   |   |   |   | - | - | - | - | - | - | - | -   comparisons: 8
         comparisons: 19
         */
        List<Integer> thisAnswer = new ArrayList<>(2);
        thisAnswer.add(0);
        thisAnswer.add(9);
        assertEquals(thisAnswer,
                PatternMatching.kmp("abaababa", "abaababaaabaababa", comparator));
        assertTrue("Did not use the comparator.",
                comparator.getComparisonCount() != 0);
        assertEquals("Comparison count was " + comparator.getComparisonCount()
                + ". Should be 28.", 28, comparator.getComparisonCount());
    }

    @Test
    public void rabinKarpSameCharacters() {
        /*
        Checks that hashing is correct and takes into account the order that it reads the
        characters.
         */
        List<Integer> thisAnswer = new ArrayList<>(1);
        thisAnswer.add(5);
        assertEquals(thisAnswer,
                PatternMatching.rabinKarp("abc", "cbacbabc", comparator));
        assertTrue("Did not use the comparator.",
                comparator.getComparisonCount() != 0);
        assertEquals("Comparison count was " + comparator.getComparisonCount()
                + ". Should be 3.", 3, comparator.getComparisonCount());
    }

    @Test
    public void patternInsidePatternRabinKarp() {
        /*
        Pattern overlaps with itself, so will need to not skip over previously checked pattern,
        but only increment by one, causing it to check the 'a' at index 1 twice.
         */
        List<Integer> thisAnswer = new ArrayList<>(1);
        thisAnswer.add(0);
        thisAnswer.add(1);
        assertEquals(thisAnswer, PatternMatching.rabinKarp("aa", "aaa", comparator));
        assertTrue("Did not use the comparator.",
                comparator.getComparisonCount() != 0);
        assertEquals("Comparison count was " + comparator.getComparisonCount()
                + ". Should be 4.", 4, comparator.getComparisonCount());
    }

    @Test
    public void skipImpossibleCharacterBoyerMoore() {
        /*
        Compares from back, so first checked index will be index 2. Mismatch at index 2, so shift
         front of pattern to compare with index 3 of the text. Will only need to compare 4 times
         because of this.
         */
        List<Integer> thisAnswer = new ArrayList<>(1);
        thisAnswer.add(3);
        assertEquals(thisAnswer, PatternMatching.boyerMoore("abc", "abdabc", comparator));
        assertTrue("Did not use the comparator.",
                comparator.getComparisonCount() != 0);
        assertEquals("Comparison count was " + comparator.getComparisonCount()
                + ". Should be 4.", 4, comparator.getComparisonCount());
    }
}