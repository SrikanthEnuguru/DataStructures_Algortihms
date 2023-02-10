package practise.top.medium.array;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
 * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * https://leetcode.com/problems/minimum-size-subarray-sum/solutions/127732/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        // This is very imp
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                ans = Math.min(ans, i - left + 1);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}
