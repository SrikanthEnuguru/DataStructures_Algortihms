package practise.datastructures.linkedlist;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * Example 3:
 *
 * Input: nums = [3,3,3,3,3]
 * Output: 3
 *
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 */
class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(fast!=slow);

        slow = nums[0];

        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}