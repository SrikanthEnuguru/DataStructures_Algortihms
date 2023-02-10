package practise.datastructures.BinarySearchTree;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two
 * nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * <p>
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solutions/205932/lowest-common-ancestor-of-a-binary-search-tree/?orderBy=most_votes
 */
public class LowestCommonAncestorOfBinarySearchTree {
    /**
     * Time Complexity : O(N), where N is the number of nodes in the BST.
     * In the worst case we might be visiting all the nodes of the BST.
     * <p>
     * Space Complexity : O(1)
     */
    public TreeNode lowestCommonAncestor_Itr(TreeNode root, TreeNode p, TreeNode q) {

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        // Start from the root node of the tree
        TreeNode node = root;

        // Traverse the tree
        while (node != null) {

            // Value of ancestor/parent node.
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return node;
            }
        }
        return null;
    }

    /**
     * Time Complexity: O(N), where N is the number of nodes in the BST.
     * In the worst case we might be visiting all the nodes of the BST.
     * <p>
     * Space Complexity: O(N). This is because the maximum amount of space utilized by the
     * recursion stack would be N since the height of a skewed BST could be N.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Value of current node or parent node.
        int parentVal = root.val;

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }
}
