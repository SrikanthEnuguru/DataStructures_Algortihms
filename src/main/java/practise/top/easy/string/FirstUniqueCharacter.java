package practise.top.easy.string;

import java.util.HashMap;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * <p>
 * Input: s = "leetcode"
 * Output: 0
 * <p>
 * Refer: https://leetcode.com/problems/first-unique-character-in-a-string/solutions/203359/official-solution/
 */
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
