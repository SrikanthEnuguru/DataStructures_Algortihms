package practise.top.hard.array;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * <p>
 * Video: https://www.youtube.com/watch?v=LPFhl65R7ww
 * Solution: https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     * <p>
     * Solution
     * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
     * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
     * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
     * <p>
     * Time complexity is O(log(min(x,y))
     * Space complexity is O(1)
     * <p>
     * https://leetcode.com/problems/median-of-two-sorted-arrays/
     * https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/4
     */
    public static double findMedianSortedArrays(int input1[], int input2[]) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (input1.length > input2.length) {
            return findMedianSortedArrays(input2, input1);
        }
        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }

    public static double findMedianSortedArrays_WrongTimeComplexity(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int m = nums1.length;
        int n = nums2.length;
        int o = m + n;
        int[] arr = new int[m + n];
        double res = 0;

        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                arr[p3] = nums1[p1];
                p1++;
                p3++;
            } else {
                arr[p3] = nums2[p2];
                p3++;
                p2++;
            }
        }

        if (p1 == m && p2 != n) {
            for (int i = p2; i < n; i++) {
                arr[p3] = nums2[i];
                p3++;
            }
        } else if (p2 == n && p1 != m) {
            for (int i = p1; i < m; i++) {
                arr[p3] = nums1[i];
                p3++;
            }
        }

        if (arr.length % 2 == 1) {
            res = arr[arr.length / 2];
        } else {
            int idx = arr.length / 2;
            res = (arr[idx] + arr[idx - 1]) / 2.0;
        }
        return res;

    }
}
