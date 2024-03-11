package practise.top.medium.string;

/**
 * Given a string s, return the number of palindromic substrings in it.
 * <p>
 * A string is a palindrome when it reads the same backward as forward.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * <p>
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * <p>
 * https://leetcode.com/problems/palindromic-substrings/solutions/953080/palindromic-substrings/
 */
public class CountAllPalindromicSubstrings {
    /**
     * Time Complexity: O(N2) for input string of length N.
     * The number of dynamic programming states that need to calculated is the same as the number of substrings i.e. (N2)=N(N−1)/2.
     * Each state can be calculated in constant time using a previously calculated state.
     * Thus overall time take in the order of O(N2)
     * <p>
     * Space Complexity: O(N2) for an input string of length N.
     * We need to allocate extra space to hold all (N2) dynamic programming states.
     */
    public int countSubstrings_DP(String s) {
        int n = s.length();
        int ans = 0;

        if (n <= 0) {
            return ans;
        }

        boolean[][] dp = new boolean[n][n];
        //Base case for single char strings
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans++;
        }
        //Base case for two char strings
        for (int i = 0; i < n-1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1]) {
                ans++;
            }
        }

        // for strings whose len>2
        for (int len = 3; len <= n; len++) {
            for (int i = 0, j = i + len - 1; j < n; i++, j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (dp[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * Time Complexity: O(N2)for input string of length N. The total time taken in this approach is dictated by two variables:
     * <p>
     * The number of possible palindromic centers we process.
     * How much time we spend processing each center.
     * The number of possible palindromic centers is 2N−1: there are N single character centers and N−1 consecutive character pairs as centers.
     * <p>
     * Each center can potentially expand to the length of the string, so time spent on each center is linear on average.
     * Thus total time spent is N⋅(2N−1) ≃N2
     * <p>
     * Space Complexity: O(1). We don't need to allocate any extra space since we are repeatedly iterating on the input string itself.
     */
    public int countSubstrings_ExpandAroundCenter(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); ++i) {
            // odd-length palindromes, single character center
            ans += countPalindromesAroundCenter(s, i, i);

            // even-length palindromes, consecutive characters center
            ans += countPalindromesAroundCenter(s, i, i + 1);
        }

        return ans;
    }

    private int countPalindromesAroundCenter(String ss, int lo, int hi) {
        int ans = 0;

        while (lo >= 0 && hi < ss.length()) { // <---- remember this
            if (ss.charAt(lo) != ss.charAt(hi))
                break;      // the first and last characters don't match!

            // expand around the center
            lo--; // <---- remember this
            hi++; // <---- remember this

            ans++;
        }

        return ans;
    }
}
