package practise.datastructures.BinaryTree;

import java.util.Stack;

public class PrintSpiralBT {
    public static void main(String[] args) {
         /* Constructed binary tree is
                1
              /   \
             2     3
            / \    /\
           4   5  6  7
        */
        BinaryTree bt = BinaryTreeUtil.createSampleBT();
        printSpiralBT(bt.root);
    }

    // Java implementation of an O(n) approach of level order
    // traversal in spiral form
    static void printSpiralBT(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        // Create two stacks to store alternate levels
        Stack<BinaryTreeNode> s1 = new Stack<>();
        Stack<BinaryTreeNode> s2 = new Stack<>();

        // Push first level to first stack 's1'
        s1.push(root);
        // Keep ptinting while any of the stacks has some nodes
        while (!s1.isEmpty() || !s2.isEmpty()) {

            // Print nodes of current level from s1 and push nodes of
            // next level to s2
            while (!s1.isEmpty()) {
                BinaryTreeNode temp = s1.pop();
                System.out.print(temp.data + " ");

                // Note that is right is pushed before left
                if (temp.right != null) {
                    s2.push(temp.right);
                }
                if (temp.left != null) {
                    s2.push(temp.left);
                }
            }

            // Print nodes of current level from s2 and push nodes of
            // next level to s1
            while (!s2.isEmpty()) {
                BinaryTreeNode temp = s2.pop();
                System.out.print(temp.data + " ");
                // Note that is left is pushed before right
                if (temp.left != null) {
                    s1.push(temp.left);
                }
                if (temp.right != null) {
                    s1.push(temp.right);
                }
            }
        }
    }
}
