package practise.datastructures.BinarySearchTree;

import practise.datastructures.BinaryTree.BinaryTree;
import practise.datastructures.BinaryTree.BinaryTreeNode;
import practise.datastructures.BinaryTree.BinaryTreeUtil;

public class LowestCommonAncestorBST {

    public static void main(String[] args) {
        /* Constructed binary search tree is
                10
              /    \
            -10     30
              \     / \
              8   25 60
            / \    \   \
           6  9    28   78
        */
        BinaryTree bst = BinaryTreeUtil.createSampleBST2();
        BinaryTreeNode res = LCA_BST(bst.root, 28, 78);
        System.out.println("LCA of Node 28 and 78 is : " + res.data);
        res = LCA_BST(bst.root, 6, 30);
        System.out.println("LCA of Node 6 and 30 is : " + res.data);
        res = LCA_BST(bst.root, 30, 78);
        System.out.println("LCA of Node 30 and 78 is : " + res.data);
    }

    static BinaryTreeNode LCA_BST(BinaryTreeNode node, int n1, int n2) {
        if (node == null) {
            return null;
        }
        if (node.data > Math.max(n1, n2)) {
            return LCA_BST(node.left, n1, n2);
        } else if (node.data < Math.min(n1, n2)) {
            return LCA_BST(node.right, n1, n2);
        } else {
            return node;
        }


    }
}
