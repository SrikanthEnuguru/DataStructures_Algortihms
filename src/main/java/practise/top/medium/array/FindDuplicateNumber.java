package practise.top.medium.array;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * <p>
 * There is only one repeated number in nums, return this repeated number.
 * <p>
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * <p>
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * <p>
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * <p>
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

        // Find the intersection point of the two runners.
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        // Find the "entrance" to the cycle.
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**
     * Time Complexity: O(nlogn)
     * <p>
     * The outer loop uses binary search to identify a candidate - this runs in O(logn) time.
     * For each candidate, we iterate over the entire array which takes O(n) time,
     * resulting in a total of O(nlogn) time.
     * <p>
     * Space Complexity: O(1)
     * <p>
     * No additional storage is needed (barring a few variables), resulting in a constant O(1) space complexity.
     */
    public int findDuplicate(int[] nums) {
        // 'low' and 'high' represent the range of values of the target
        int low = 1, high = nums.length - 1;
        int duplicate = -1;

        while (low <= high) {
            int cur = (low + high) / 2;

            // Count how many numbers in 'nums' are less than or equal to 'cur'
            int count = 0;
            for (int num : nums) {
                if (num <= cur)
                    count++;
            }

            if (count > cur) {
                duplicate = cur;
                high = cur - 1;
            } else {
                low = cur + 1;
            }
        }
        return duplicate;
    }
}
