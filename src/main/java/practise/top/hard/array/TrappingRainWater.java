package practise.top.hard.array;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 * <p>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 * <p>
 * https://leetcode.com/problems/trapping-rain-water/solutions/127551/trapping-rain-water/
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap_TwoPointer(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    /**
     * Brute Force Approach
     * Time complexity: O(n2). For each element of array, we iterate the left and right parts.
     * <p>
     * Space complexity: O(1) extra space
     */
    public static int trap_BF(int[] heights) {
        if (heights.length == 0) return 0;

        int lmax = 0, rmax = 0, ans = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j >= 0; j--) {
                lmax = Math.max(lmax, heights[j]);
            }
            for (int j = i; j < heights.length; j++) {
                rmax = Math.max(rmax, heights[j]);
            }
            ans += Math.min(lmax, rmax) + heights[i];
        }
        return ans;
    }

    /**
     * Time complexity: O(n). Single iteration of O(n)
     * Space complexity: O(1) extra space. Only constant space required for left, right, left_max and right_max.
     */
    public static int trap_TwoPointer(int[] height) {
        if (height.length == 0) return 0;

        int l = 0;
        int r = height.length - 1;
        int lmax = 0;
        int rmax = 0;
        int ans = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] >= lmax) {
                    lmax = height[l];
                } else {
                    ans += lmax - height[l];
                }
                l++;
            } else {
                if (height[r] >= rmax) {
                    rmax = height[r];
                } else {
                    ans += rmax - height[r];
                }
                r--;
            }
        }
        return ans;
    }
}
