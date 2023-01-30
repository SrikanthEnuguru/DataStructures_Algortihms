package practise.top.medium.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/127839/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Time complexity : O(2n)=O(n). In the worst case each character will be visited twice by iii and jjj.
     * <p>
     * Space complexity : O(min(m,n)). Same as the previous approach.
     * We need O(k) space for the sliding window, where kkk is the size of the Set.
     * The size of the Set is upper bounded by the size of the string nnn and the size of the charset/alphabet mmm.
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        int l = 0;
        int ans = 0;

        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            chars.put(rc, chars.getOrDefault(rc, 0) + 1);

            while (chars.get(rc) > 1) {
                char lc = s.charAt(l);
                chars.put(lc, chars.get(lc) - 1);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
