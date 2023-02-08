package practise.algorithms.dp;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 * https://leetcode.com/problems/longest-common-subsequence/solutions/598321/longest-common-subsequence/
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String X = "AGGTAB";
		String Y = "GXTXAYB";
		char[] s1 = X.toCharArray();
		char[] s2 = Y.toCharArray();
		int m = s1.length;
		int n = s2.length;
		System.out.println("Length of Longest Common Subsequence for " + X + ", " + Y + " is (Recursion): " 
		+ LCS_Rec(s1, s2, m, n));
		
		System.out.println("Length of Longest Common Subsequence for " + X + ", " + Y + " is (DP): " 
				+ LCS_DP(s1, s2, m, n));
	}

	static int LCS_Rec(char[] s1, char[] s2, int m, int n) {

		if (m == 0 || n == 0) {
			return 0;
		}

		if (s1[m - 1] == s2[n - 1]) {
			return 1 + LCS_Rec(s1, s2, m - 1, n - 1);
		} else {
			return Math.max(LCS_Rec(s1, s2, m - 1, n), LCS_Rec(s1, s2, m, n - 1));
		}
	}

	/**
	 * Time complexity : O(M⋅N).
	 * We're solving M⋅N subproblems. Solving each subproblem is an O(1) operation.
	 *
	 * Space complexity : O(M⋅N)
	 * We'e allocating a 2D array of size M⋅Nto save the answers to subproblems.
	 */
	
	static int LCS_DP(char[] s1, char[] s2, int m, int n) {
		int L[][] = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					L[i][j]=0;
				} else if(s1[i-1]==s2[j-1]) {
					L[i][j]=1+L[i-1][j-1];
				} else {
					L[i][j]=Math.max(L[i-1][j], L[i][j-1]);
				}
			}
		}
		return L[m][n];
	}

}
