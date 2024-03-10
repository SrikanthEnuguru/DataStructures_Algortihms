package practise.top.medium.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, s, that represents a DNA subsequence, and a number k
 * return all the contiguous subsequences (substrings) of length k
 * that occur more than once in the string. The order of the returned subsequences does not matter.
 * If no repeated substring is found, the function should return an empty set.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT" k=10
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 * Example 2:
 * <p>
 * Input: s = "AAAAAAAAAAAAA" k=10
 * Output: ["AAAAAAAAAA"]
 */
public class RepeatedDNASequences {
    public static Set<String> findRepeatedSequences(String s, int k) {

        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for (int i = 0; i + k - 1 < s.length(); i++) {
            String kWord = s.substring(i, i + k);
            if (!seen.add(kWord)) {
                repeated.add(kWord);
            }
        }
        return repeated;
    }
}
