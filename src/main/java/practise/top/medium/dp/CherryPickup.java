package practise.top.medium.dp;

import java.util.Arrays;

public class CherryPickup {
    int[][] grid;
    int[][][] memo;
    int n;

    /**
     * Time Complexity: O(N^3) where N is the length of grid. Our dynamic programming has O(N^3) states.
     * <p>
     * Space Complexity: O(N^3)the size of memo.
     */
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.memo = new int[n][n][n];

        for (int[][] layer : memo) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        return Math.max(0, dp(0, 0, 0));
    }

    public int dp(int r1, int c1, int c2) {
        /**
         * if we have two people at positions (r1, c1) and (r2, c2), then r2 = r1 + c1 - c2.
         * That means the variables r1, c1, c2 uniquely determine 2 people who have walked the same
         * r1 + c1 number of steps. This sets us up for dynamic programming quite nicely.
         */
        int r2 = r1 + c1 + -c2;

        // base cases for checking row & column limits
        // Also check for thorns i.e., -1
        if (r1 >= n || c1 >= n || c2 >= n || r2 >= n ||
                grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -999999;
        }

        // if value is already calculated in memo, return the same
        if (memo[r1][c1][c2] != Integer.MIN_VALUE) {
            return memo[r1][c1][c2];
        }

        // if person reached end i.e., right bottom return the value from grid
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        // add cherry (1) or 0 to the ans for person 1.
        int ans = grid[r1][c1];

        // if both persons are on same location in grid, only 1 person can pick the cherry
        if (c1 != c2) {
            ans += grid[r2][c2];
        }

        // 4 possibilities for person 1 and 2 moving down and right:
        //Person 1 down and person 2 down: dp[r1+1][c1][c2];
        //Person 1 right and person 2 down: dp[r1][c1+1][c2];
        //Person 1 down and person 2 right: dp[r1+1][c1][c2+1];
        //Person 1 right and person 2 right: dp[r1][c1+1][c2+1];
        ans += Math.max(Math.max(dp(r1, c1 + 1, c2 + 1), dp(r1 + 1, c1, c2 + 1)),
                Math.max(dp(r1, c1 + 1, c2), dp(r1 + 1, c1, c2)));

        memo[r1][c1][c2] = ans;
        return ans;
    }
}
