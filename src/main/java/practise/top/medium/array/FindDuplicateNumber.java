package practise.top.medium.array;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 * https://leetcode.com/problems/find-the-duplicate-number/solutions/127594/find-the-duplicate-number/
 */
public class FindDuplicateNumber {

    /**
     * linked list fast & slow pointer approach
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findDuplicate_TwoPointer(int[] nums) {
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

    public int findDuplicate(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int ans = -1;
        while (l<=r){
            int mid = (l+r)/2;

            int count =0;
            for (int num:nums){
                if(num<=mid){
                    count++;
                }
            }

            if(count>mid){
                ans = mid;
                r=mid-1;
            } else {
                l=mid+1;
            }
        }
        return ans;
    }
}
