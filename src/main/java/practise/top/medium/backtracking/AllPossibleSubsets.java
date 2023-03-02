package practise.top.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * https://leetcode.com/problems/subsets/editorial/
 */
public class AllPossibleSubsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, ans, nums);
        return ans;
    }

    public void backtrack(List<Integer> curr, int i, List<List<Integer>> ans, int[] nums) {
        if (i > nums.length) {
            return;
        }

        ans.add(new ArrayList<>(curr));
        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            backtrack(curr, j + 1, ans, nums);
            curr.remove(curr.size() - 1);
        }
    }
}
