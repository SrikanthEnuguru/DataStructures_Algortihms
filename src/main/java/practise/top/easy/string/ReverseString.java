package practise.top.easy.string;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * <p>
 * Refer: https://leetcode.com/problems/reverse-string/solutions/404367/official-solution/
 */
public class ReverseString {
    /**
     * Time complexity : O(N) to swap N/2N/2N/2 element.
     * <p>
     * Space complexity : O(1) it's a constant space solution.
     */
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
