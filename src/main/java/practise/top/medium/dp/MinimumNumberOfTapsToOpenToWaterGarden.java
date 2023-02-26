package practise.top.medium.dp;

/**
 * There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).
 * <p>
 * There are n + 1 taps located at points [0, 1, ..., n] in the garden.
 * <p>
 * Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
 * <p>
 * Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.
 * <p>
 * https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/solutions/506853/java-a-general-greedy-solution-to-process-similar-problems/
 */
public class MinimumNumberOfTapsToOpenToWaterGarden {
    /**
     * For this problem, we just need construct a new array to move the value into the leftmost point we can water,
     * so the problem becomes Jump Game II. For example, at index i we could water (i - arr[i]) ~ (i + arr[i]).
     * So we store the farthest point we can water at "i - arr[i]". Then "left" in range [left, right] is index
     * and "right" is the value in arr[index].
     */
    public int minTaps(int n, int[] ranges) {
        // construct the arr
        int[] arr = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            int left = Math.max(0, i - ranges[i]);
            arr[left] = Math.max(arr[left], i + ranges[i]);
        }

        // same part like JumpGameII solution
        int end = 0, farCanReach = 0, cnt = 0;
        for (int i = 0; i < arr.length && end < n; end = farCanReach) {
            cnt++;
            while (i < arr.length && i <= end) {
                farCanReach = Math.max(farCanReach, arr[i++]);
            }
            if (end == farCanReach) return -1;
        }
        return cnt;
    }
}
