package practise.datastructures.BinarySearchTree;

/**
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes
 * of the tree were swapped by mistake. Recover the tree without changing its structure.
 * <p>
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 * https://github.com/striver79/FreeKaTreeSeries/blob/main/recoverBSTJava
 */
public class RecoverBinarySearchTree {
    private TreeNode first;
    private TreeNode prev;
    private TreeNode middle;
    private TreeNode last;

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null && (root.val < prev.val)) {

            // If this is first violation, mark these two nodes as
            // 'first' and 'middle'
            if (first == null) {
                first = prev;
                middle = root;
            }

            // If this is second violation, mark this node as last
            else
                last = root;
        }

        // Mark this node as previous
        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if (first != null && last != null) {
            int t = first.val;
            first.val = last.val;
            last.val = t;
        } else if (first != null && middle != null) {
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
}
