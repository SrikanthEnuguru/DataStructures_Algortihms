package practise.top.medium.array;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.
 * <p>
 * A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
 * <p>
 * Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.
 * <p>
 * Each range [a,b] in the list should be output as:
 * <p>
 * "a->b" if a != b
 * "a" if a == b
 * <p>
 * https://leetcode.com/problems/missing-ranges/solutions/863162/official-solution/
 */
public class MissingRanges {

    /**
     * Time complexity : O(N).
     * <p>
     * This is because we are only iterating over the array once, and at each step, we're performing O(1) operations.
     * We treat the string building as O(1) because the strings can never be more than a fixed size.
     * <p>
     * Space complexity : O(1).
     * <p>
     * The output list has a worst case size of O(N).
     * This case occurs when we have a missing range between each of the consecutive elements in the input array
     * (for example, if the input array contains all even numbers between lower and upper).
     * We aren't using any other additional space, beyond fixed-sized constants that don't grow with the size of the input.
     * <p>
     * However, output space that is simply used to return the output (and not to do any processing)
     * is not counted for the purpose of space complexity analysis.
     * For this reason, the overall space complexity is O(1).
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        int prev = lower - 1;
        // condition is i<=nums.length, because we want to check the upper limit also. Watch video for more info.
        for (int i = 0; i <= nums.length; i++) {
            int cur = (i < nums.length) ? nums[i] : upper + 1;
            if (prev + 1 <= cur - 1) {
                ans.add(formatRange(prev + 1, cur - 1));
            }
            prev = cur;
        }
        return ans;
    }

    private String formatRange(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        }
        return lower + "->" + upper;
    }
}
