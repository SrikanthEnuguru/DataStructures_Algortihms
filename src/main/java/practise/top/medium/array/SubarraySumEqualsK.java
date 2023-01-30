package practise.top.medium.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * [1,2] & [3]
 * <p>
 * https://leetcode.com/problems/subarray-sum-equals-k/solutions/127728/subarray-sum-equals-k/
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(subarraySum_slow(new int[]{1, 2, 3}, 3));
    }

    /**
     * Time complexity : O(n). The entire nums array is traversed only once.
     * <p>
     * Space complexity : O(n). Hashmap map can contain up to nnn distinct entries in the worst case.
     */
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // v imp... base condition
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    /**
     * Time complexity : O(n^2). We need to consider every subarray possible.
     * <p>
     * Space complexity : O(1). Constant space is used.
     */
    public static int subarraySum_slow(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
