package practise.top.medium.dp;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * <p>
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 * <p>
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/solutions/506853/java-a-general-greedy-solution-to-process-similar-problems/
 */
public class JumpGameII {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));
    }

    public static int jump(int[] nums) {
        int cnt = 0, farCanReach = 0, end = 0;
        for (int i = 0; end < nums.length - 1; end = farCanReach) {
            cnt++;
            while (i < nums.length && i <= end) {
                farCanReach = Math.max(farCanReach, i + nums[i++]);
            }
            if (end == farCanReach) return -1;
        }
        return cnt;
    }
}
