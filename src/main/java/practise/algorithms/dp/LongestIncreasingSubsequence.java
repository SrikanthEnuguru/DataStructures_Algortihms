package practise.algorithms.dp;

import java.util.Arrays;

/**
 * 
 * @author Srikanth Enuguru
 * 
 *         Find a subsequence in given array in which the subsequence's elements
 *         are in sorted order, lowest to highest, and in which the subsequence
 *         is as long as possible
 * 
 *         Solution : Dynamic Programming is used to solve this question. DP
 *         equation is if(arr[i] > arr[j]) { T[i] = max(T[i], T[j] + 1 }
 * 
 *         Time complexity is O(n^2). Space complexity is O(n)
 * 
 *
 */

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		System.out.println("Length of lis is " + LIS_DP(arr, n) );
	}

	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int longest = 0;
		for (int c: dp) {
			longest = Math.max(longest, c);
		}

		return longest;
	}

	static int LIS_DP(int[] arr, int len) {
		int LIS[] = new int[len];

		for (int i = 0; i < len; i++) {
			LIS[i] = 1;
		}

		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
				}
			}
		}

		int res = LIS[0];
		for (int k = 1; k < LIS.length; k++) {
			if (LIS[k] > res) {
				res = LIS[k];
			}
		}

		return res;
	}

}
