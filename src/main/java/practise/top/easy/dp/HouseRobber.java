package practise.top.easy.dp;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
    Map<Integer, Integer> memo = new HashMap<>();

    public int rob_BottomUp(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    public int rob_TopDown(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return dp(nums.length - 1, nums);
    }

    public int dp(int i, int[] nums) {
        if (i == 0) {
            return nums[0];
        }
        if (i == 1) {
            return Math.max(nums[0], nums[1]);
        }

        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        memo.put(i, Math.max(dp(i - 2, nums) + nums[i], dp(i - 1, nums)));
        return memo.get(i);
    }
}
