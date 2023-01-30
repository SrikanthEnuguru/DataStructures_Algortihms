package practise.top.medium.string;

/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * https://leetcode.com/problems/longest-palindromic-substring/solutions/127837/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    /**
     * Time complexity : O(n2). Since expanding a palindrome around its center could take O(n) time, the overall complexity is O(n2)
     * <p>
     * Space complexity : O(1).
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //length of odd palindrome
            int len1 = expandAroundCenter(s, i, i);
            //length of even palindrome
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        //dont for get that substr function is [x,y)
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        //first two conditions prevent an infinite loop
        //second condition verifies its a palindrome
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        /**
         * the loop will exit once it verifies that there isn't a palindrome any more. So L and R are both off by one.
         *     R = R-1; //correct off by one error
         *     L = L+1;
         *     return R - L + 1; //return length
         *
         *     simply (R-1)-(L+1)+1 = R-L-1
         */
        return R - L - 1;
    }
}
