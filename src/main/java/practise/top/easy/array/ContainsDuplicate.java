package practise.top.easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums,
 * return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: true
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: false
 * <p>
 * Refer: https://leetcode.com/problems/contains-duplicate/solutions/127825/contains-duplicate/
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
