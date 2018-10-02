package practise.datastructures.BinaryTree;

import static practise.datastructures.BinaryTree.BinaryTreeUtil.createSampleBT2;

public class IsSubTree {
    public static void main(String[] args) {
        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \    \
          4      6    13
           \
            30
        */

        BinaryTree M = new BinaryTree();
        BinaryTree S = new BinaryTree();

        BinaryTreeNode node30 = new BinaryTreeNode(30);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node13 = new BinaryTreeNode(13);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, node30);
        BinaryTreeNode node10 = new BinaryTreeNode(10, node4, node6);
        BinaryTreeNode node3 = new BinaryTreeNode(3, null, node13);
        BinaryTreeNode node26 = new BinaryTreeNode(26, node10, node3);

        M.root = node26;
        S.root = node10;

        if (isSubTree(M.root, S.root)) {
            System.out.println("TRUE !! S is a subtree os Main Tree M");
        } else {
            System.out.println("FALSE !! S is NOT a subtree os Main Tree M");
        }

        /* Constructed binary tree is
               20
             /   \
            8     22
           / \
          4   12
              / \
             10  14
       */
        S = createSampleBT2();
        if (isSubTree(M.root, S.root)) {
            System.out.println("TRUE !! S is a subtree os Main Tree M");
        } else {
            System.out.println("FALSE !! S is NOT a subtree os Main Tree M");
        }
    }

    /* This function returns true if S is a subtree of T, otherwise false */
    static boolean isSubTree(BinaryTreeNode M, BinaryTreeNode S) {
        /* base cases */
        if (S == null) {
            return true;
        }

        if (M == null) {
            return false;
        }

        /* Check the tree with root as current node */
        if (areIdentical(M, S)) {
            return true;
        }

        /* If the tree with root as current node doesn't match then
           try left and right subtrees one by one */
        return isSubTree(M.left, S) || isSubTree(M.right, S);

    }

    /* A utility function to check whether trees with roots as root1 and
       root2 are identical or not */
    static boolean areIdentical(BinaryTreeNode n1, BinaryTreeNode n2) {
        /* base cases */
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        /* Check if the data of both roots is same and data of left and right
           subtrees are also same */
        return (n1.data == n2.data) && areIdentical(n1.left, n2.left) && areIdentical(n1.right, n2.right);
    }
}
