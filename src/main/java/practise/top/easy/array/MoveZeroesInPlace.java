package practise.top.easy.array;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * <p>
 * Refer: https://leetcode.com/problems/move-zeroes/solutions/127441/official-solution/
 */
public class MoveZeroesInPlace {

    /**
     * Space Complexity : O(1). Only constant space is used.
     * <p>
     * Time Complexity: O(n). However, the total number of operations are optimal.
     * The total operations (array writes) that code does is Number of non-0 elements.
     * This gives us a much better best-case (when most of the elements are 0) complexity than last solution.
     * However, the worst-case (when all elements are non-0) complexity for both the algorithms is same.
     */
    public void moveZeroes(int[] nums) {
        int lastNonZeroFound = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                //swap nums[lastNonZeroFound] and nums[i] and increment lastNonZeroFound
                int temp = nums[lastNonZeroFound];
                nums[lastNonZeroFound] = nums[i];
                nums[i] = temp;

                lastNonZeroFound++;
            }
        }
    }
}
