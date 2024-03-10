package practise.top.hard.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * https://leetcode.com/problems/sliding-window-maximum/solutions/458121/java-all-solutions-b-f-pq-deque-dp-with-explanation-and-complexity-analysis/
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // assume nums is not null
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[n - k + 1]; // number of windows
        Deque<Integer> dq = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; ++i) {
            // remove indices that are out of bound
            while (dq.size() > 0 && dq.peekFirst() < i-k+1) {
                dq.pollFirst();
            }
            // remove indices whose corresponding values are less than nums[i]
            while (dq.size() > 0 && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            // add nums[i]
            dq.offerLast(i);
            // add to result
            if (i-k+1 >= 0) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }

}
