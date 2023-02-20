package practise.top.hard.binarytree;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * <p>
 * The path sum of a path is the sum of the node's values in the path.
 * <p>
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * <p>
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/solutions/2827786/binary-tree-maximum-path-sum/?orderBy=most_votes
 */
public class BinaryTreeMaximumPathSum {
    /**
     * Let n be the number of nodes in the tree.
     * <p>
     * Time complexity: O(n)
     * <p>
     * Each node in the tree is visited only once. During a visit, we perform constant time operations,
     * including two recursive calls and calculating the max path sum for the current node.
     * So the time complexity is O(n)
     * <p>
     * Space complexity: O(n)
     * <p>
     * We don't use any auxiliary data structure, but the recursive call stack can go as deep as the tree's height.
     * In the worst case, the tree is a linked list, so the height is n. Therefore, the space complexity is O(n).
     */
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gainFromSubtree(root);
        return maxSum;
    }

    private int maxSum;

    // post order traversal of subtree rooted at `root`
    private int gainFromSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // add the path sum from left subtree. Note that if the path
        // sum is negative, we can ignore it, or count it as 0.
        // This is the reason we use `Math.max` here.
        int gainFromLeft = Math.max(gainFromSubtree(root.left), 0);

        // add the path sum from right subtree. 0 if negative
        int gainFromRight = Math.max(gainFromSubtree(root.right), 0);

        // if left or right path sum are negative, they are counted
        // as 0, so this statement takes care of all four scenarios
        maxSum = Math.max(maxSum, gainFromLeft + gainFromRight + root.val);

        // return the max sum for a path starting at the root of subtree
        return Math.max(gainFromLeft + root.val, gainFromRight + root.val);
    }
}
