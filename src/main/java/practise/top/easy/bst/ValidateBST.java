package practise.top.easy.bst;

import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/solutions/204551/official-solution/
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return validate_recursive(root, null, null);
    }

    /**
     * Time complexity : O(N) since we visit each node exactly once.
     * Space complexity : O(N) since we keep up to the entire tree.
     */
    public boolean validate_recursive(TreeNode node, Integer small, Integer large) {
        //base case
        if (node == null) {
            return true;
        }
        // check conditions
        if ((small != null && small >= node.val) || (large != null && node.val >= large)) {
            return false;
        }
        boolean left = validate_recursive(node.left, small, node.val);
        boolean right = validate_recursive(node.right, node.val, large);
        return left && right;
    }

    public boolean validate_Iterative(TreeNode root) {
        Stack<State> stack = new Stack<>();
        stack.push(new State(root, null, null));

        while (!stack.isEmpty()) {
            State state = stack.pop();
            TreeNode node = state.node;
            Integer small = state.small;
            Integer large = state.large;

            if ((small != null && small >= node.val) || (large != null && node.val >= large)) {
                return false;
            }
            if (node.left != null) {
                stack.push(new State(node.left, small, node.val));
            }
            if (node.right != null) {
                stack.push(new State(node.right, node.val, large));
            }
        }
        return true;
    }
}


class State {
    TreeNode node;
    Integer small;
    Integer large;

    State(TreeNode node, Integer small, Integer large) {
        this.node = node;
        this.small = small;
        this.large = large;
    }
}
