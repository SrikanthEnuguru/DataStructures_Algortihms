package practise.datastructures.BinaryTree;

import java.util.Stack;

public class CheckBTsAreMirror {
    public static void main(String[] args) {
        /* Constructed binary tree is
                1
              /   \
             2     3
            / \    /\
           4   5  6  7
        */
        BinaryTree bt1 = BinaryTreeUtil.createSampleBT();
        /* Constructed binary tree is
                1
              /   \
             3     2
            / \    /\
           7   6  5  4
        */
        BinaryTree bt2 = BinaryTreeUtil.createSampleBTMirror();
        if (areMirror_Rec(bt1.root, bt2.root)) {
            System.out.println("Both Trees are Mirrors");
        } else {
            System.out.println("Both Trees are NOT Mirrors");
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
        BinaryTree bt3 = BinaryTreeUtil.createSampleBT2();
        if (areMirror_Rec(bt1.root, bt3.root)) {
            System.out.println("Both Trees are Mirrors");
        } else {
            System.out.println("Both Trees are NOT Mirrors");
        }

        if (areMirror_Itr(bt1.root, bt2.root)) {
            System.out.println("Both Trees are Mirrors");
        } else {
            System.out.println("Both Trees are NOT Mirrors");
        }

        if (areMirror_Itr(bt1.root, bt3.root)) {
            System.out.println("Both Trees are Mirrors");
        } else {
            System.out.println("Both Trees are NOT Mirrors");
        }
    }

    /* Given two trees, return true if they are
       mirror of each other */
    static boolean areMirror_Rec(BinaryTreeNode root1, BinaryTreeNode root2) {

        /* Base case : Both empty */
        if (root1 == null && root2 == null) {
            return true;
        }
        // If only one is empty
        if (root1 == null || root2 == null) {
            return false;
        }
        /* Both non-empty, compare them recursively
           Note that in recursive calls, we pass left
           of one tree and right of other tree */
        return root1.data == root2.data && areMirror_Rec(root1.left, root2.right) && areMirror_Rec(root1.right, root2.left);
    }

    // function to check whether the two binary trees are mirrors of each other or not
    static boolean areMirror_Itr(BinaryTreeNode root1, BinaryTreeNode root2) {
        /* Base case : Both empty */
        if (root1 == null && root2 == null) {
            return true;
        }

        // If only one is empty
        if (root1 == null || root2 == null) {
            return false;
        }

        Stack<BinaryTreeNode> s1 = new Stack<>();
        Stack<BinaryTreeNode> s2 = new Stack<>();

        while (true) {
            // iterative inorder traversal of 1st tree and
            // reverse inorder traversal of 2nd tree
            while (root1 != null && root2 != null) {
                // if the corresponding nodes in the two traversal
                // have different data values, then they are not
                // mirrors of each other.
                if (root1.data != root2.data) {
                    return false;
                }
                s1.push(root1);
                s2.push(root2);
                root1 = root1.left;
                root2 = root2.right;
            }

            // if at any point one root becomes null and
            // the other root is not null, then they are
            // not mirrors. This condition verifies that
            // structures of tree are mirrors of each other.
            if (!(root1 == null && root2 == null)) {
                return false;
            }

            if (!s1.isEmpty() && !s2.isEmpty()) {
                root1 = s1.pop();
                root2 = s2.pop();
                /* we have visited the node and its left subtree.
               Now, it's right subtree's turn */
                root1 = root1.right;
                /* we have visited the node and its right subtree.
               Now, it's left subtree's turn */
                root2 = root2.left;
            } else {
                break;
            }
        }

        return true;

    }
}
