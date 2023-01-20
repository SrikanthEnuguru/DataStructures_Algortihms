package practise.top.easy.array;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * <p>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * <p>
 * https://leetcode.com/problems/maximum-subarray/solutions/1126554/official-solution/
 */
public class MaximumSubarray {
    /**
     * Time complexity: O(N), where N is the length of nums.
     * <p>
     * We iterate through every element of nums exactly once.
     * <p>
     * Space complexity: O(1)
     * <p>
     * No matter how long the input is, we are only ever using 2 variables: currentSubarray and maxSubarray.
     */
    public int maxSubArray(int[] nums) {
        // Initialize our variables using the first element.
        int curr_max = nums[0];
        int max_so_far = nums[0];

        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            curr_max = Math.max(num, curr_max + num);
            max_so_far = Math.max(max_so_far, curr_max);
        }

        return max_so_far;
    }
}
