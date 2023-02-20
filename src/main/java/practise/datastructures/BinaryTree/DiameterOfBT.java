package practise.datastructures.BinaryTree;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * <p>
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * The length of a path between two nodes is represented by the number of edges between them.
 * <p>
 * https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/707/traversals-trees-graphs/4669/
 * https://leetcode.com/problems/diameter-of-binary-tree/solutions/1102557/official-solution/
 */
public class DiameterOfBT {
    private int diameter;

    /**
     * Let N be the number of nodes in the tree.
     * <p>
     * Time complexity: O(N). This is because in our recursion function longestPath, we only enter and exit from each node once.
     * We know this because each node is entered from its parent, and in a tree, nodes only have one parent.
     * <p>
     * Space complexity: O(N). The space complexity depends on the size of our implicit call stack during our DFS,
     * which relates to the height of the tree. In the worst case, the tree is skewed so the height of the tree is O(N).
     * If the tree is balanced, it'd be O(logN).
     */
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }

    private int longestPath(TreeNode node) {
        if (node == null) return 0;
        // recursively find the longest path in
        // both left child and right child
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        // update the diameter if left_path plus right_path is larger
        diameter = Math.max(diameter, leftPath + rightPath);

        // return the longest one between left_path and right_path;
        // remember to add 1 for the path connecting the node and its parent
        return Math.max(leftPath, rightPath) + 1;
    }
}
