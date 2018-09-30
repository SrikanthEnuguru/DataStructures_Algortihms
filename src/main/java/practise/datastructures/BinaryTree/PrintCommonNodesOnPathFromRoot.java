package practise.datastructures.BinaryTree;

public class PrintCommonNodesOnPathFromRoot {
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
        BinaryTree bt = BinaryTreeUtil.createSampleBT2();
        printCommonNodes(bt.root, bt.root.left.right.left, bt.root.left.right.right);
    }

    /**
     * Find the LCA of given two nodes.
     * Print all ancestors of the LCA as done in this post, also print the LCA.
     */

    static void printCommonNodes(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2) {
        BinaryTreeNode lca = DistanceBwTwoNodesBT.lca(root, n1, n2);
        if (lca == null) {
            return;
        }
        printAncestors(root, lca);
    }

    static boolean printAncestors(BinaryTreeNode root, BinaryTreeNode lca) {
        /* base cases */
        if (root == null || lca == null) {
            return false;
        }
        if (root.data == lca.data) {
            System.out.print(root.data + " ");
            return true;
        }
        /* If target is present in either left or right
        subtree of this node, then print this node */
        if (printAncestors(root.left, lca) || printAncestors(root.right, lca)) {
            System.out.print(root.data + " ");
            return true;
        }
        return false;
    }
}
