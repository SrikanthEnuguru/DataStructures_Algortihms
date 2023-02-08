package practise.top.medium.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Find maximum profit by picking items such that -
 * 1) Item can only be picked once 0/1 time
 * 2) Cannot extend the bag weight limit w
 * <p>
 * Input:
 * wt: [3,2,4] profit: [6,8,7] w=8
 * <p>
 * Output: 15
 * picking weights 2,4 whose profits are 8,7
 * <p>
 * https://www.youtube.com/watch?v=mGfK-j9gAQA&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=4
 */
public class KnapsackProblem {
    static int[] wt;
    static int[] profit;
    static Map<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 2, 4}, new int[]{6, 8, 7}, 8));
        System.out.println(dp_tab(new int[]{3, 2, 4}, new int[]{6, 8, 7}, 8));
    }

    public static int maxProfit(int[] wts, int[] profits, int w) {
        profit = profits;
        wt = wts;
        return dp_memo(w, wt.length - 1);
    }

    public static int dp_memo(int rem, int n) {

        //base case
        if (rem < 0 || n < 0) {
            return 0;
        }

        String key = rem + "," + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result;
        if (wt[n] > rem) {
            // exclude case if wt at index n is greater than remaining weight
            result = dp_memo(rem, n - 1);
            //main logic
        } else {
            result = Math.max(/*Exclude case*/dp_memo(rem, n - 1), /*include case*/ profit[n] + dp_memo(rem - wt[n], n - 1));
        }
        memo.put(key, result);
        return result;
    }

    public static int dp_tab(int[] wts, int[] profits, int w) {
        int rows = wts.length + 1;
        int cols = w + 1;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // base case
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (wts[i - 1] > j) {
                    // exclude case if wt at index n is greater than remaining weight
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /* else, check if sum can be obtained by any of the following
                    (a) including the last element
                    (b) excluding the last element */
                    dp[i][j] = Math.max(dp[i - 1][j], profits[i - 1] + dp[i - 1][j - wts[i - 1]]);
                }
            }
        }
        // uncomment this code to print table
        // System.out.println(Arrays.deepToString(dp));
        return dp[rows - 1][cols - 1];
    }
}
