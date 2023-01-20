package practise.top.easy.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Refer: https://leetcode.com/problems/binary-tree-level-order-traversal/solutions/255802/official-solution/
 */
public class LevelsUsingLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
        if(root==null){
            return levels;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int n = q.size();
            for(int i=0;i<n; i++){
                TreeNode node = q.poll();
                level.add(node.val);

                if(node.left !=null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            levels.add(level);
        }
        return levels;
    }
}
