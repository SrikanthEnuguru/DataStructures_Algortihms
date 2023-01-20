package practise.top.easy.string;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
 * removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * <p>
 * Refre: https://leetcode.com/problems/valid-palindrome/solutions/546199/official-solution/
 */
public class ValidPalindrome {

    /**
     * Time complexity : O(n), in length nnn of the string. We traverse over each character at-most once,
     * until the two pointers meet in the middle, or when we break and return early.
     * <p>
     * Space complexity : O(1). No extra space required, at all.
     */
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            char lc = s.charAt(l);
            char rc = s.charAt(r);

            if (!Character.isLetterOrDigit(lc)) {
                l++;
                continue;
            }

            if (!Character.isLetterOrDigit(rc)) {
                r--;
                continue;
            }

            if (Character.toLowerCase(lc) != Character.toLowerCase(rc)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
