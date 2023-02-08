package practise.top.medium.dp;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * <p>
 * https://leetcode.com/problems/minimum-path-sum/
 * https://leetcode.com/problems/minimum-path-sum/solutions/127608/minimum-path-sum/?orderBy=most_votes
 */
public class MinimumPathSum {

    /**
     * Time complexity : O(mn). We traverse the entire matrix once.
     * <p>
     * Space complexity : O(mn). Another matrix of the same size is used.
     */
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;

        int[][] dp = new int[rows + 1][cols + 1];
        dp[0][0] = grid[0][0];

        // fill 1st row
        for (int i = 1; i < rows; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        // fill 1st col
        for (int i = 1; i < cols; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
