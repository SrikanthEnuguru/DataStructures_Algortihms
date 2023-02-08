package practise.top.medium.dp;

/**
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * <p>
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 * <p>
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * <p>
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 * <p>
 * https://leetcode.com/problems/unique-paths-ii/description/
 * https://leetcode.com/problems/unique-paths-ii/solutions/184772/unique-paths-ii/?orderBy=most_votes
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int dp[][] = new int[rows + 1][cols + 1];

        // fill 1st row
        boolean isObstacleFound = false;
        for (int i = 0; i < cols; i++) {
            if (isObstacleFound || obstacleGrid[0][i] == 1) {
                isObstacleFound = true;
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }

        // fill 1st column
        isObstacleFound = false;
        for (int i = 0; i < cols; i++) {
            if (isObstacleFound || obstacleGrid[i][0] == 1) {
                isObstacleFound = true;
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }

        // fill dp table
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // if obstacle found
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    // else logic same as unique paths prob
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
