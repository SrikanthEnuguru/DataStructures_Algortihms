package practise.top.easy.array;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * Input: nums = [2,2,1]
 * Output: 1
 * <p>
 * https://leetcode.com/problems/single-number/solutions/127660/official-solution/
 */
public class SingleNumber {

    /**
     * Concept: Bit Manipulation
     * <p>
     * If we take XOR of zero and some bit, it will return that bit
     * a ^ 0 = a
     * <p>
     * If we take XOR of two same bits, it will return 0
     * a ^ a = 0
     * <p>
     * So we can XOR all bits together to find the unique number.
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
