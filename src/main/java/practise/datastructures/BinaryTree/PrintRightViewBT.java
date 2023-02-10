package practise.datastructures.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * <p>
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class PrintRightViewBT {

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        solve(root, 0, list);
        return list;
    }

    public void solve(TreeNode node, int height, ArrayList<Integer> list) {
        if (node == null)
            return;
        if (list.size() == height) {
            list.add(node.val);
        }
        solve(node.right, height + 1, list);
        solve(node.left, height + 1, list);
    }

    public List<Integer> rightSideView_Itr(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 1; i <= n; i++) {
                TreeNode node = q.poll();
                if (i == n) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }

        }
        return res;
    }
}
