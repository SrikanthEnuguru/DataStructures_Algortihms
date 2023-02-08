package practise.top.medium.dp;

/**
 * Given an array of numbers and a sum, count no of subsets with the given sum
 * Input: nums=[2,1,1] sum=2
 * Output: 2 [2][1,1]
 * <p>
 * https://www.youtube.com/watch?v=MqYLmIzl8sQ&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=10&t=596s
 */
public class CountSubsetsWithGivenSum {
    public static void main(String[] args) {
        System.out.println(countSS(new int[]{2, 1, 1}, 4));
    }

    public static int countSS(int[] nums, int sum) {
        int n = nums.length;
        Integer[][] memo = new Integer[n + 1][sum + 1];
        return dp_memo(nums, n, sum, memo);
    }

    public static int dp_memo(int[] nums, int n, int sum, Integer[][] memo) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0 || sum < 0) {
            return 0;
        }

        if (memo[n][sum] != null) {
            return memo[n][sum];
        }
        if (nums[n - 1] > sum) {
            memo[n][sum] = dp_memo(nums, n - 1, sum, memo);
        } else {
            memo[n][sum] = dp_memo(nums, n - 1, sum, memo) + dp_memo(nums, n - 1, sum - nums[n - 1], memo);
        }
        return memo[n][sum];
    }
}
