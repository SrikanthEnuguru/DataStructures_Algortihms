package practise.top.easy.bst;

/**
 * Given the root of a Binary Search Tree (BST), return the
 * minimum absolute difference between the values of any two different nodes in the tree.
 * <p>
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/solutions/585431/java-accepted-solution-inorder-with-clear-explanation/?orderBy=most_votes
 */
public class MinimumAbsoluteDifferenceInBST {
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;

        getMinimumDifference(root.left);

        // inorder of BST is increasing order
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        // set curr value of node to prev
        prev = root.val;

        getMinimumDifference(root.right);
        return min;
    }
}
