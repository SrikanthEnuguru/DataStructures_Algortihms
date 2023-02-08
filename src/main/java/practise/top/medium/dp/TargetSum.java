package practise.top.medium.dp;

import java.util.HashMap;

/**
 * You are given an integer array nums and an integer target.
 * <p>
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 * <p>
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 * <p>
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * <p>
 * https://leetcode.com/problems/target-sum/solutions/127455/target-sum/
 */
public class TargetSum {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    /**
     * Time complexity: O(t⋅n). The memo array of size O(t⋅n) has been filled just once.
     * Here, t refers to the sum of the nums array and n refers to the length of the nums array.
     * <p>
     * Space complexity: O(t⋅n). The depth of recursion tree can go up to n. The memo array contains t⋅n elements.
     */

    public static int findTargetSumWays(int[] nums, int target) {
        return dp(nums, target, 0, new HashMap<>());
    }

    public static int dp(int[] nums, int target, int idx, HashMap<String, Integer> memo) {
        //base cases
        if (idx >= nums.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        String key = idx + "," + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int pos = dp(nums, target + nums[idx], idx + 1, memo);
        int neg = dp(nums, target - nums[idx], idx + 1, memo);
        memo.put(key, pos + neg);
        return memo.get(key);
    }
}
