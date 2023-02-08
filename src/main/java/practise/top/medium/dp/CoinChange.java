package practise.top.medium.dp;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * <p>
 * https://leetcode.com/problems/coin-change/solutions/127438/coin-change/?orderBy=most_votes
 */
public class CoinChange {

    /**
     * Time complexity : O(S*n). On each step the algorithm finds the next F(i) in n iterations, where 1≤i≤S1.
     * Therefore in total the iterations are S∗n.
     * Space complexity :O(S). We use extra space for the memoization table
     */
    public int coinChange_1D(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int a = 1; a <= amount; a++) {
            for (int c : coins) {
                if (a - c >= 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - c]);
                }
            }
        }

        if (dp[amount] > amount) {
            return -1;
        } else return dp[amount];
    }

    public int coinChange_tab(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    //it is always possible to make 0 amount by not including coin
                    // so min coins needed=0 in this case
                    dp[i][j] = 0;
                } else if (i == 0) {
                    // if coins =0 & amt >0
                    // use +INF or highest sum from given constraints.
                    dp[i][j] = 100000;
                } else if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // in include case do not decrement i, because this is unbounded knapsack use case
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return dp[n][amount] >= 100000 ? -1 : dp[n][amount];
    }
}

