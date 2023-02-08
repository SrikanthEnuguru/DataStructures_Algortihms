package practise.top.medium.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a set of non-negative integers and a sum value, check if there exists a subset in our given set,
 * such that sum of elements of subset = given sum value
 * <p>
 * Input :
 * set=[2,2,3] sum = 5
 * <p>
 * Output: True
 * [2,3] is the subset with sum=5
 * <p>
 * https://www.youtube.com/watch?v=34l1kTIQCIA&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=8
 */
public class VerifySubsetSum {
    static Map<String, Boolean> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(isSubsetSum_1D(new int[]{2, 2, 3}, 7));
    }

    /**
     * Best approach, with Time Complexity = O(n*sum)
     * Space Complexity = O(sum)
     */
    public static boolean isSubsetSum_1D(int[] nums, int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int curr : nums) {
            for (int j = sum; j >= curr; j--) {
                dp[j] |= dp[j - curr];
            }
        }
        return dp[sum];
    }

    // Returns true if there is a subset of set[] with sun equal to given sum
    public static boolean isSubsetSum(int[] set, int sum) {
        int n = set.length;
        return dp(set, n, sum);
    }

    public static boolean dp(int[] set, int n, int rem) {
        // Base Cases
        if (rem == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        boolean res;
        String key = n + "," + rem;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // If last element is greater than sum, then ignore it
        if (set[n - 1] > rem) {
            res = dp(set, n - 1, rem);
        } else {
            /* else, check if sum can be obtained by any of the following
        (a) including the last element
        (b) excluding the last element */
            res = dp(set, n - 1, rem) || dp(set, n - 1, rem - set[n - 1]);
        }

        memo.put(key, res);
        return memo.get(key);
    }

    public static boolean isSubsetSum_tab(int[] set, int sum) {
        int n = set.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (set[i - 1] > j) {
                    // exclude case if wt at index n is greater than remaining weight
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /* else, check if sum can be obtained by any of the following
                    (a) including the last element
                    (b) excluding the last element */
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
                }
            }
        }

        // uncomment this code to print table
        // System.out.println(Arrays.deepToString(dp));
        /*for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= sum; j++)
                System.out.print(dp[i][j]);
            System.out.println("\n");
        }*/
        return dp[n][sum];
    }


}
