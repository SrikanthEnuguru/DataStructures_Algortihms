package practise.datastructures.BinaryTree;

public class DistanceBwTwoNodesBT {
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
        System.out.println("Distance between nodes 10 and 22: " + distance(bt.root, bt.root.left.right.left, bt.root.right));
        System.out.println("Distance between nodes 4 and 14: " + distance(bt.root, bt.root.left.left, bt.root.left.right.right));
        System.out.println("Distance between nodes 20 and 22: " + distance(bt.root, bt.root.right, bt.root));
    }

    //We first find LCA of two nodes. Then we find distance from LCA to two nodes
    static int distance(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2) {
        BinaryTreeNode lca = lca(root, n1, n2);
        int d1 = findLevel(lca, n1, 0);
        int d2 = findLevel(lca, n2, 0);
        return d1 + d2;
    }

    static BinaryTreeNode lca(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2) {
        if (root == null) {
            return null;
        }
        if (root == n1 || root == n2) {
            return root;
        }

        BinaryTreeNode left = lca(root.left, n1, n2);
        BinaryTreeNode right = lca(root.right, n1, n2);

        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }

        return left != null ? left : right;
    }

    // Returns level of key k if it is present in
    // tree, otherwise returns -1
    static int findLevel(BinaryTreeNode lca, BinaryTreeNode node, int level) {
        if (lca == null) {
            return -1;
        }
        if (lca.data == node.data) {
            return level;
        }
        int left = findLevel(lca.left, node, level + 1);
        if (left == -1) {
            return findLevel(lca.right, node, level + 1);
        }
        return left;
    }
}
