package practise.top.easy.binarytree;

import java.util.LinkedList;

/**
 * Refer: https://leetcode.com/problems/maximum-depth-of-binary-tree/solutions/176802/official-solution/
 */
public class MaxDepth {
    /**
     * Time complexity : we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes.
     * <p>
     * Space complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only left child node,
     * the recursion call would occur NNN times (the height of the tree), therefore the storage to keep the call stack would
     * be O(N). But in the best case (the tree is completely balanced), the height of the tree would be log(N).
     * Therefore, the space complexity in this case would be O(log(N)).
     */
    public int maxDepth_Recursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth_Recursive(root.left);
        int r = maxDepth_Recursive(root.right);
        return Math.max(l, r) + 1;
    }

    /**
     * Time & Space complexity same as above
     */
    public int maxDepth_Iteration(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        if (root == null) return 0;

        stack.add(root);
        depths.add(1);

        int depth = 0, current_depth = 0;
        while (!stack.isEmpty()) {
            root = stack.pollLast();
            current_depth = depths.pollLast();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(root.left);
                stack.add(root.right);
                depths.add(current_depth + 1);
                depths.add(current_depth + 1);
            }
        }
        return depth;
    }
}
