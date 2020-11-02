import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Your implementations of various string searching algorithms.
 *
 * @author Jackson Isenberg
 * @version 1.0
 * @userid jisenberg3
 * @GTID 903556168
 *
 * Collaborators: N/A
 *
 * Resources: LeetCode
 */
public class PatternMatching {

    /**
     * Knuth-Morris-Pratt (KMP) algorithm relies on the failure table (also
     * called failure function). Works better with small alphabets.
     *
     * Make sure to implement the buildFailureTable() method before implementing
     * this method.
     *
     * @param pattern    the pattern you are searching for in a body of text
     * @param text       the body of text where you search for pattern
     * @param comparator you MUST use this to check if characters are equal
     * @return list containing the starting index for each match found
     * @throws java.lang.IllegalArgumentException if the pattern is null or has
     *                                            length 0
     * @throws java.lang.IllegalArgumentException if text or comparator is null
     */
    public static List<Integer> kmp(CharSequence pattern, CharSequence text,
                                    CharacterComparator comparator) {
        List<Integer> indices = new ArrayList<>();
        if (pattern == null || pattern.length() == 0) {
            throw new IllegalArgumentException("Pattern must be nonnull and have length greater than 0");
        } else if (text == null) {
            throw new IllegalArgumentException("Text sequence cannot be null");
        } else if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null");
        } else {
            if (text.length() < pattern.length()) {
                return indices;
            }
            int[] f = buildFailureTable(pattern, comparator);
            int j = 0;
            int i = 0;
            while (i + pattern.length() - 1 - j < text.length()) {
                if (comparator.compare(pattern.charAt(j), text.charAt(i)) == 0) {
                    if (j == pattern.length() - 1) {
                        indices.add(i++ - j);
                        j = f[j];
                    } else {
                        j++;
                        i++;
                    }
                } else if (j == 0) {
                    i++;
                } else {
                    j = f[j - 1];
                }
            }
        }
        return indices;
    }

    /**
     * Builds failure table that will be used to run the Knuth-Morris-Pratt
     * (KMP) algorithm.
     *
     * The table built should be the length of the input text.
     *
     * Note that a given index i will contain the length of the largest prefix
     * of the pattern indices [0..i] that is also a suffix of the pattern
     * indices [1..i]. This means that index 0 of the returned table will always
     * be equal to 0
     *
     * Ex. pattern = ababac
     *
     * table[0] = 0
     * table[1] = 0
     * table[2] = 1
     * table[3] = 2
     * table[4] = 3
     * table[5] = 0
     *
     * If the pattern is empty, return an empty array.
     *
     * @param pattern    a pattern you're building a failure table for
     * @param comparator you MUST use this to check if characters are equal
     * @return integer array holding your failure table
     * @throws java.lang.IllegalArgumentException if the pattern or comparator
     *                                            is null
     */
    public static int[] buildFailureTable(CharSequence pattern,
                                          CharacterComparator comparator) {
        if (pattern == null) {
            throw new IllegalArgumentException("Pattern cannot be null to build failure table");
        } else if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null to build failure table");
        } else {
            int[] table = new int[pattern.length()];    // initializes an array of pattern length with all 0s
            int i = 0;
            int j = 1;
            while (j < table.length) {
                if (comparator.compare(pattern.charAt(i), pattern.charAt(j)) == 0) {
                    table[j++] = ++i;
                } else if (i == 0) {
                    table[j++] = 0;
                } else {
                    i = table[i - 1];
                }
            }
            return table;
        }
    }

    /**
     * Boyer Moore algorithm that relies on last occurrence table. Works better
     * with large alphabets.
     *
     * Make sure to implement the buildLastTable() method before implementing
     * this method.
     *
     * Note: You may find the getOrDefault() method from Java's Map class
     * useful.
     *
     * @param pattern    the pattern you are searching for in a body of text
     * @param text       the body of text where you search for the pattern
     * @param comparator you MUST use this to check if characters are equal
     * @return list containing the starting index for each match found
     * @throws java.lang.IllegalArgumentException if the pattern is null or has
     *                                            length 0
     * @throws java.lang.IllegalArgumentException if text or comparator is null
     */
    public static List<Integer> boyerMoore(CharSequence pattern,
                                           CharSequence text,
                                           CharacterComparator comparator) {
        List<Integer> indices = new ArrayList<>();
        if (pattern == null || pattern.length() == 0) {
            throw new IllegalArgumentException("Pattern must be nonnull and have length greater than 0");
        } else if (text == null) {
            throw new IllegalArgumentException("Text sequence cannot be null");
        } else if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null");
        } else {
            Map<Character, Integer> last = buildLastTable(pattern);
            int i = 0;
            while (i <= text.length() - pattern.length()) {
                int j = pattern.length() - 1;
                while (j >= 0 && comparator.compare(text.charAt(i + j), pattern.charAt(j)) == 0) {
                    j--;
                }
                if (j == -1) {
                    indices.add(i);
                    i++;
                } else {
                    int shift = last.getOrDefault(text.charAt(i + j), -1);
                    if (shift < j) {
                        i += j - shift;
                    } else {
                        i++;
                    }
                }
            }
        }
        return indices;
    }

    /**
     * Builds last occurrence table that will be used to run the Boyer Moore
     * algorithm.
     *
     * Note that each char x will have an entry at table.get(x).
     * Each entry should be the last index of x where x is a particular
     * character in your pattern.
     * If x is not in the pattern, then the table will not contain the key x,
     * and you will have to check for that in your Boyer Moore implementation.
     *
     * Ex. pattern = octocat
     *
     * table.get(o) = 3
     * table.get(c) = 4
     * table.get(t) = 6
     * table.get(a) = 5
     * table.get(everything else) = null, which you will interpret in
     * Boyer-Moore as -1
     *
     * If the pattern is empty, return an empty map.
     *
     * @param pattern a pattern you are building last table for
     * @return a Map with keys of all of the characters in the pattern mapping
     * to their last occurrence in the pattern
     * @throws java.lang.IllegalArgumentException if the pattern is null
     */
    public static Map<Character, Integer> buildLastTable(CharSequence pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("Cannot build a last occurrence table with a null pattern");
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i), i);
        }
        return map;
    }

    /**
     * Prime base used for Rabin-Karp hashing.
     * DO NOT EDIT!
     */
    private static final int BASE = 113;

    /**
     * Runs the Rabin-Karp algorithm. This algorithms generates hashes for the
     * pattern and compares this hash to substrings of the text before doing
     * character by character comparisons.
     *
     * When the hashes are equal and you do character comparisons, compare
     * starting from the beginning of the pattern to the end, not from the end
     * to the beginning.
     *
     * You must use the Rabin-Karp Rolling Hash for this implementation. The
     * formula for it is:
     *
     * sum of: c * BASE ^ (pattern.length - 1 - i)
     *   c is the integer value of the current character, and
     *   i is the index of the character
     *
     * We recommend building the hash for the pattern and the first m characters
     * of the text by starting at index (m - 1) to efficiently exponentiate the
     * BASE. This allows you to avoid using Math.pow().
     *
     * Note that if you were dealing with very large numbers here, your hash
     * will likely overflow; you will not need to handle this case.
     * You may assume that all powers and calculations CAN be done without
     * overflow. However, be careful with how you carry out your calculations.
     * For example, if BASE^(m - 1) is a number that fits into an int, it's
     * possible for BASE^m will overflow. So, you would not want to do
     * BASE^m / BASE to calculate BASE^(m - 1).
     *
     * Ex. Hashing "bunn" as a substring of "bunny" with base 113
     * = (b * 113 ^ 3) + (u * 113 ^ 2) + (n * 113 ^ 1) + (n * 113 ^ 0)
     * = (98 * 113 ^ 3) + (117 * 113 ^ 2) + (110 * 113 ^ 1) + (110 * 113 ^ 0)
     * = 142910419
     *
     * Another key point of this algorithm is that updating the hash from
     * one substring to the next substring must be O(1). To update the hash,
     * subtract the oldChar times BASE raised to the length - 1, multiply by
     * BASE, and add the newChar as shown by this formula:
     * (oldHash - oldChar * BASE ^ (pattern.length - 1)) * BASE + newChar
     *
     * Ex. Shifting from "bunn" to "unny" in "bunny" with base 113
     * hash("unny") = (hash("bunn") - b * 113 ^ 3) * 113 + y
     *              = (142910419 - 98 * 113 ^ 3) * 113 + 121
     *              = 170236090
     *
     * Keep in mind that calculating exponents is not O(1) in general, so you'll
     * need to keep track of what BASE^(m - 1) is for updating the hash.
     *
     * Do NOT use Math.pow() in this method.
     *
     * @param pattern    a string you're searching for in a body of text
     * @param text       the body of text where you search for pattern
     * @param comparator you MUST use this to check if characters are equal
     * @return list containing the starting index for each match found
     * @throws java.lang.IllegalArgumentException if the pattern is null or has
     *                                            length 0
     * @throws java.lang.IllegalArgumentException if text or comparator is null
     */
    public static List<Integer> rabinKarp(CharSequence pattern,
                                          CharSequence text,
                                          CharacterComparator comparator) {
        List<Integer> indices = new ArrayList<>();
        if (pattern == null || pattern.length() == 0) {
            throw new IllegalArgumentException("Pattern must be nonnull and have length greater than 0");
        } else if (text == null) {
            throw new IllegalArgumentException("Text sequence cannot be null");
        } else if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null");
        } else {
            if (pattern.length() > text.length()) {
                return indices;
            }
            int[] hashesAndPow = hash(text, pattern, 0, pattern.length());
            int substringHash = hashesAndPow[0];
            int patternHash = hashesAndPow[1];
            int pow = hashesAndPow[2];
            int i = 0;
            int j = 0;
            while (i <= text.length() - pattern.length()) {
                if (substringHash == patternHash
                        && comparator.compare(text.charAt(i + j), pattern.charAt(j)) == 0) {
                    if (j == pattern.length() - 1) {
                        indices.add(i);
                        j = 0;
                        if (i + pattern.length() < text.length()) {
                            substringHash = nextHash(text.charAt(i), text.charAt(i + pattern.length()),
                                    substringHash, pow);
                        }
                        i++;
                    } else {
                        j++;
                    }
                } else {
                    if (i + pattern.length() < text.length()) {
                        substringHash = nextHash(text.charAt(i), text.charAt(i + pattern.length()),
                                substringHash, pow);
                    }
                    j = 0;
                    i++;
                }
            }
        }
        return indices;
    }

    /**
     * A helper method to compute the hash
     *
     * @param text      the sequence of characters for the text
     * @param pattern   the sequence of characters for the pattern
     * @param start     the start of the substring in the sequence
     * @param length    the length of the substring
     * @return the hash of the substring
     */
    private static int[] hash(CharSequence text, CharSequence pattern, int start, int length) {
        int pow = 1;
        int textHash = 0;
        int patternHash = 0;
        for (int i = start + length - 1; i >= start; i--) {
            textHash += Character.hashCode(text.charAt(i)) * pow;
            patternHash += Character.hashCode(pattern.charAt(i - start)) * pow;
            // lol gg ez
            if (i > start) {
                pow *= BASE;
            }
        }
        return new int[]{textHash, patternHash, pow};
    }

    /**
     * A helper method to compute the next hash
     * for the rolling hash method
     *
     * @param oldChar   the old character to be removed from the substring
     * @param newChar   the new character to be added to the substring
     * @param oldHash   the old hash
     * @param pow       the power we computed at the start
     * @return the new hash
     */
    private static int nextHash(char oldChar, char newChar, int oldHash, int pow) {
        return (oldHash - Character.hashCode(oldChar) * pow) * BASE + Character.hashCode(newChar);
    }
}
