package practise.top.medium.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 *
 * Refer : https://leetcode.com/problems/longest-common-prefix/solutions/127449/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"leets", "leetcode", "leet", "leeds"};
        System.out.println(longestCommonPrefix_HorizontalScanning(strs));
    }

    /**
     *
     * Time complexity : O(S), where S is the sum of all characters in all strings.
     * In the worst case all n strings are the same. The algorithm compares the string S1S1S1 with the other strings [S2…Sn]
     * There are S character comparisons, where S is the sum of all characters in the input array.
     *
     * Space complexity : O(1). We only used constant extra space.
     */
    public static String longestCommonPrefix_HorizontalScanning(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            // if prefix is not present in strs[i], remove 1 char from prefix and check again
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
