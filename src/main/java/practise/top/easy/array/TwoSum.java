package practise.top.easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Refer: https://leetcode.com/problems/two-sum/solutions/127810/official-solution/
 */
public class TwoSum {

    /**
     * Time complexity: O(n)
     * We traverse the list containing nnn elements only once. Each lookup in the table costs only O(1)O(1)O(1) time.
     * <p>
     * Space complexity: O(n). The extra space required depends on the number of items stored in the hash table,
     * which stores at most nnn elements.
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
