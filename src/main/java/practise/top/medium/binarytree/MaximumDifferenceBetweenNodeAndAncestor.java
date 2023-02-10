package practise.top.medium.binarytree;

/**
 * Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
 * <p>
 * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
 * <p>
 * Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation: We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 * <p>
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/solutions/895566/official-solution/?orderBy=most_votes
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
    /**
     * Let NNN be the number of nodes in the binary tree.
     * <p>
     * Time complexity: O(N) since we visit all nodes once.
     * <p>
     * Space complexity: O(N) since we need stacks to do recursion,
     * and the maximum depth of the recursion is the height of the tree, which is O(N)
     * in the worst case and O(log(N)) in the best case.
     */
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, root.val, root.val);
    }

    public int helper(TreeNode node, int curMax, int curMin) {
        // if encounter leaves, return the max-min along the path
        if (node == null) {
            return curMax - curMin;
        }
        // else, update max and min
        // and return the max of left and right subtrees
        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);

        int left = helper(node.left, curMax, curMin);
        int right = helper(node.right, curMax, curMin);

        return Math.max(left, right);
    }
}
