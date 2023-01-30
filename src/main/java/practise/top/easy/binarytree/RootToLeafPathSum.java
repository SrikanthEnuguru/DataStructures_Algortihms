package practise.top.easy.binarytree;

import java.util.Stack;

/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * <p>
 * A leaf is a node with no children.
 * <p>
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 */
public class RootToLeafPathSum {
    int target;

    public boolean hasPathSum_recursive(TreeNode root, int targetSum) {
        target = targetSum;
        return dfs(root, 0);
    }

    public boolean dfs(TreeNode node, int curr) {
        if (node == null) return false;

        if (node.left == null && node.right == null) {
            return curr + node.val == target;
        }
        curr = curr + node.val;
        boolean left = dfs(node.left, curr);
        boolean right = dfs(node.right, curr);
        return left || right;
    }

    public boolean hasPathSum_Iterative(TreeNode root, int targetSum) {
        Stack<StatePathSum> stack = new Stack<>();
        stack.push(new StatePathSum(root, 0));

        while (!stack.isEmpty()) {
            StatePathSum state = stack.pop();
            TreeNode node = state.node;
            int curr = state.curr;

            if (node.left == null && node.right == null) {
                return curr + node.val == targetSum;
            }
            curr = curr + node.val;

            if (node.left != null) {
                stack.push(new StatePathSum(node.left, curr));
            }
            if (node.right != null) {
                stack.push(new StatePathSum(node.right, curr));
            }
        }
        return false;
    }
}

class StatePathSum {
    TreeNode node;
    int curr;

    StatePathSum(TreeNode node, int curr) {
        this.node = node;
        this.curr = curr;
    }
}

