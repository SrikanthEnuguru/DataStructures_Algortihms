package practise.top.medium.dp;

/**
 * Given an integer array nums, return true if you can partition the array into two subsets such that
 * the sum of the elements in both subsets is equal or false otherwise.
 * <p>
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * <p>
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * <p>
 * https://leetcode.com/problems/partition-equal-subset-sum/solutions/811019/partition-equal-subset-sum/
 */
public class PartitionEqualSubsetSum {
    /**
     * Let n be the number of array elements and m be the subSetSum.
     * <p>
     * Time Complexity : O(m⋅n).
     * <p>
     * In the worst case where there is no overlapping calculation, the maximum number of entries in the memo would be m⋅n.
     * For each entry, overall we could consider that it takes constant time, i.e. each invocation of dfs() at most emits one entry in the memo.
     * <p>
     * The overall computation is proportional to the number of entries in memo. Hence, the overall time complexity is O(m⋅n).
     * <p>
     * Space Complexity: O(m⋅n). We are using a 2 dimensional array memo of size (m⋅n) and O(n) space to store the recursive call stack.
     * This gives us the space complexity as O(n) + O(m⋅n) = O(m⋅n)
     */
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        int n = nums.length;
        Boolean[][] memo = new Boolean[n + 1][subSetSum + 1];
        return dfs(nums, n - 1, subSetSum, memo);
    }

    public boolean dfs(int[] nums, int n, int subSetSum, Boolean[][] memo) {
        // Base Cases
        if (subSetSum == 0)
            return true;
        if (n == 0 || subSetSum < 0)
            return false;
        // check if subSetSum for given n is already computed and stored in memo
        if (memo[n][subSetSum] != null)
            return memo[n][subSetSum];
        // store the result in memo
        memo[n][subSetSum] = dfs(nums, n - 1, subSetSum - nums[n - 1], memo) ||
                dfs(nums, n - 1, subSetSum, memo);

        return memo[n][subSetSum] ;
    }

    /**
     * Time Complexity : O(m⋅n), where mmm is the subSetSum, and n is the number of array elements.
     * We iteratively fill the array of size m⋅n.
     * <p>
     * Space Complexity : O(m⋅n) , where nnn is the number of array elements and mmm is the subSetSum.
     * We are using a 2 dimensional array dp of size m⋅n
     */

    public boolean canPartition_memo(int[] nums) {
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][subSetSum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            int curr = nums[i - 1];
            for (int j = 0; j <= subSetSum; j++) {
                if (j < curr)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || (dp[i - 1][j - curr]);
            }
        }
        return dp[n][subSetSum];
    }
}
