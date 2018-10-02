package practise.datastructures.BinaryTree;

import static practise.datastructures.BinaryTree.BinaryTreeUtil.createSampleBT2;

public class RemoveShortPathNodesBT {

    public static void main(String[] args) {
        /* Constructed binary tree is
               20
             /   \
            8     22
           / \
          4   12
              / \
             10  14
       */
        BinaryTree bt = createSampleBT2();
        System.out.println("Original Tree : ");
        printInOrder(bt.root);
        System.out.println();

        /* For k =4, result binary tree will be
               20
             /
            8
            \
             12
            / \
           10  14
       */

        int k = 4;
        System.out.println("After removing root to leaf path nodes having length less than 4: ");
        removeShortPathNodes(bt.root, k);
        printInOrder(bt.root);
    }

    static void printInOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    // Method which calls the utitlity method to remove the short path nodes.
    static BinaryTreeNode removeShortPathNodes(BinaryTreeNode node, int k) {
        return removeShortPathNodesUtil(node, 1, k);
    }

    // Utility method that actually removes the nodes which are not
    // on the pathLen >= k. This method can change the root as well.
    static BinaryTreeNode removeShortPathNodesUtil(BinaryTreeNode node, int level, int k) {

        //Base condition
        if (node == null) {
            return null;
        }

        // Traverse the tree in postorder fashion so that if a leaf
        // node path length is shorter than k, then that node and
        // all of its descendants till the node which are not
        // on some other path are removed.
        node.left = removeShortPathNodesUtil(node.left, level + 1, k);
        node.right = removeShortPathNodesUtil(node.right, level + 1, k);

        // If root is a leaf node and it's level is less than k then
        // remove this node.
        // This goes up and check for the ancestor nodes also for the
        // same condition till it finds a node which is a part of other
        // path(s) too.
        if (node.left == null && node.right == null && level < k) {
            return null;
        }

        // Return root;
        return node;
    }
}
