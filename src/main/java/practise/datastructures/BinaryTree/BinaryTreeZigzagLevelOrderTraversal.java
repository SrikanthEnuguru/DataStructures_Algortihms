package practise.datastructures.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * <p>
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/solutions/461703/binary-tree-zigzag-level-order-traversal/?orderBy=most_votes
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
        if (root == null) return levels;

        boolean leftToRight = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }

                if (leftToRight) {
                    level.add(node.val);
                } else {
                    // This is very smart move
                    level.addFirst(node.val);
                }
            }
            leftToRight = !leftToRight;
            levels.add(level);
        }
        return levels;
    }
}
