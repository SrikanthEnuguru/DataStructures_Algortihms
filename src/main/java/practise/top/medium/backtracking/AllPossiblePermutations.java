package practise.top.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * https://leetcode.com/problems/permutations/editorial/
 */
public class AllPossiblePermutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(ans, curr, nums);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans,List<Integer> curr, int[] nums) {
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return ;
        }

        for(int num:nums){
            if(!curr.contains(num)){
                curr.add(num);
                backtrack(ans,curr,nums);
                curr.remove(curr.size()-1);
            }
        }
    }
}
