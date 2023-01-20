package practise.top.medium.bst;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 *
 * https://leetcode.com/problems/delete-node-in-a-bst/solutions/281988/delete-node-in-a-bst/
 */
public class DeleteNodeInBST {

    /*
 One step right and then always left
 */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    /*
    One step left and then always right
    */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    /**
     *
     * Time complexity : O(logN). During the algorithm execution we go down the tree all the time - on the left or on the right,
     * first to search the node to delete (O(H1) time complexity as already discussed) and then to actually delete it.
     * H1 is a tree height from the root to the node to delete. Delete process takes O(H2) time,
     * where H2 is a tree height from the root to delete to the leafs. That in total results in O(H1+H2)=O(H) time complexity,
     * where H is a tree height, equal to logN in the case of the balanced tree.
     *
     * Space complexity : O(H) to keep the recursion stack, where H is a tree height. H=logN for the balanced tree.
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // delete from the right subtree
        if (key > root.val) root.right = deleteNode(root.right, key);
            // delete from the left subtree
        else if (key < root.val) root.left = deleteNode(root.left, key);
            // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null) root = null;
                // the node is not a leaf and has a right child
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}
