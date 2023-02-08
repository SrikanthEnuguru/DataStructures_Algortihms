package practise.top.medium.dp;

/**
 * Given an array of integers, return the min subset sum diff.
 *
 * Input:[1,6,11,5]
 * Output: 1 [1,6,5][11]
 *
 * Input: [1,6,11,15]
 * Output: 1 [1,15][6,11]
 */
public class MinimumSubsetSumDifference {

    public static void main(String[] args) {
        System.out.println(minDiff(new int[]{1,6,11,15}));
    }

    public static int minDiff(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //solve subset sum problem
        int n = nums.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        // Find min diff value
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            int first = i;
            int second = sum - i;
            if (dp[n][i] && diff > Math.abs(first - second)) {
                diff = Math.abs(first - second);
            }
        }
        return diff;
    }
}
