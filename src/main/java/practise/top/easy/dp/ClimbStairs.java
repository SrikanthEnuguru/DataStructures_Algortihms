package practise.top.easy.dp;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Refer: https://leetcode.com/problems/climbing-stairs/solutions/127722/official-solution/
 */
public class ClimbStairs {
    /**
     * Time complexity : O(n). Single loop upto nnn.
     * <p>
     * Space complexity : O(n). dp array of size nnn is used.
     */
    public int climbStairs_DP(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    /**
     * Time complexity : O(n). Single loop upto n is required to calculate nth fibonacci number.
     * <p>
     * Space complexity : O(1). Constant space is used.
     */
    public int climbStairs_Fibonacci(int n) {
        if (n <= 2) {
            return n;
        }

        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
