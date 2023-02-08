package practise.top.medium.dp;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * The answer is guaranteed to fit into a signed 32-bit integer.
 * <p>
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * https://leetcode.com/problems/coin-change-ii/solutions/430649/coin-change-ii/?orderBy=most_votes
 * https://www.youtube.com/watch?v=ruMqWViJ2_U&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=15
 */
public class CoinChangeII {
    /**
     * dp[x] = exclude + include = dp[x]+dp[x-coin]
     * <p>
     * Initiate number of combinations array with the base case "no coins": dp[0] = 1, and all the rest = 0.
     * Loop over all coins:
     * For each coin, loop over all amounts from 0 to amount:
     * For each amount x, compute the number of combinations: dp[x] += dp[x - coin].
     * Return dp[amount]
     */
    public int change_1D(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) {
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }

    public int change_tab(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }
}
