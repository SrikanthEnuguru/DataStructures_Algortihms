package practise.datastructures.BinaryTree;

/**
 * The idea is to traverse the given Binary Tree. For every node, check if it is a leaf node.
 * If yes, then return 1. If not leaf node then if left subtree is NULL, then recur for right subtree.
 * And if right subtree is NULL, then recur for left subtree. If both left and right subtrees are not NULL,
 * then take the minimum of two heights.
 */

public class MinimumDepthOfBT {
    public static void main(String[] args) {
        /* Constructed binary tree is
                3
              /    \
             6      8
            / \     \
           2   11    13
               / \   /
              9  5  7
        */
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node13 = new BinaryTreeNode(13);
        BinaryTreeNode node8 = new BinaryTreeNode(8, null, node13);
        BinaryTreeNode node11 = new BinaryTreeNode(11, node9, node5);
        BinaryTreeNode node6 = new BinaryTreeNode(6, node2, node11);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node8);

        System.out.print("Min Depth : " + minDepth(node3));
    }


    /* Function to calculate the minimum depth of the tree */
    static int minDepth(BinaryTreeNode root) {
        // Corner case. Should never be hit unless the code is called on root = NULL
        if (root == null) {
            return 0;
        }

        // Base case : Leaf Node. This accounts for height = 1.
        if (root.left == null && root.right == null) {
            return 1;
        }

        // If left subtree is NULL, recur for right subtree
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        // If right subtree is NULL, recur for left subtree
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
