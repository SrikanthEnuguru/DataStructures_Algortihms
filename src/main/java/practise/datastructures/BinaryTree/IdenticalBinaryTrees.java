package practise.datastructures.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class IdenticalBinaryTrees {

    public static void main(String[] args) {
        /* Constructed binary tree is
                1
              /   \
             2     3
            / \    /\
           4   5  6  7
        */
        BinaryTree bt1 = BinaryTreeUtil.createSampleBT();
        BinaryTree bt2 = BinaryTreeUtil.createSampleBT();

        if (areBTsIdentical_Rec(bt1.root, bt2.root)) {
            System.out.println("Both Trees are identical");
        } else {
            System.out.println("Both Trees are NOT identical");
        }

        BinaryTree bt3 = BinaryTreeUtil.createSampleBT2();
        if (areBTsIdentical_Rec(bt1.root, bt3.root)) {
            System.out.println("Both Trees are identical");
        } else {
            System.out.println("Both Trees are NOT identical");
        }

        if (areBTsIdentical_Itr(bt1.root, bt2.root)) {
            System.out.println("Both Trees are identical");
        } else {
            System.out.println("Both Trees are NOT identical");
        }

        if (areBTsIdentical_Itr(bt1.root, bt3.root)) {
            System.out.println("Both Trees are identical");
        } else {
            System.out.println("Both Trees are NOT identical");
        }
    }

    static boolean areBTsIdentical_Rec(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.data == root2.data && areBTsIdentical_Rec(root1.left, root2.left) && areBTsIdentical_Rec(root1.right, root2.right);
    }

    static boolean areBTsIdentical_Itr(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        Queue<BinaryTreeNode> q1 = new LinkedList<>();
        Queue<BinaryTreeNode> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            BinaryTreeNode temp1 = q1.remove();
            BinaryTreeNode temp2 = q2.remove();

            if (temp1.data != temp2.data) {
                return false;
            }

            /* Enqueue left children of both nodes */
            if (temp1.left != null && temp2.left != null) {
                q1.add(temp1.left);
                q2.add(temp2.left);
            }
            // If one left child is empty and other is not(very IMP)
            else if (temp1.left != null || temp2.left != null) {
                return false;
            }

            // Right child code (Similar to left child code)
            if (temp1.right != null && temp2.right != null) {
                q1.add(temp1.right);
                q2.add(temp2.right);
            } else if (temp1.right != null || temp2.right != null) {
                return false;
            }
        }
        return true;
    }

}
