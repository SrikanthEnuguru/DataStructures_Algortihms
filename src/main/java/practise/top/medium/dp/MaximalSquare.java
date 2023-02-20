package practise.top.medium.dp;

/**
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * https://leetcode.com/problems/maximal-square/description/
 * https://leetcode.com/problems/maximal-square/solutions/127442/maximal-square/?orderBy=most_votes
 */
public class MaximalSquare {
    /**
     * Time complexity : O(mn). Single pass.
     * <p>
     * Space complexity : O(mn). Another matrix of same size is used for dp.
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m + 1][n + 1];
        int largest = 0;
        // for convenience, we add an extra all zero column and row
        // outside of the actual dp table, to simplify the transition
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    largest = Math.max(largest, dp[i][j]);
                }
            }
        }
        return largest*largest;
    }
}
