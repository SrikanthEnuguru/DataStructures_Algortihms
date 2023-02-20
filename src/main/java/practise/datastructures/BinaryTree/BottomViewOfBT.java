package practise.datastructures.BinaryTree;

import java.util.*;

/**
 * Given a Binary Tree,  print the bottom view from left to right.
 * A node x is there in output if x is the bottommost node at its horizontal distance from root.
 * Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1,
 * and that of right child is horizontal distance of x plus 1.
 * <p>
 * If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal.
 */
public class BottomViewOfBT {

    public static void main(String[] args) {
        /* Constructed binary tree is
                1
              /   \
             2     3
            / \    /\
           4   5  6  7
        */
        BinaryTree bst = BinaryTreeUtil.createSampleBT();
        printBottomView(bst);

        /* Constructed binary tree is
                20
              /   \
             8     22
            / \
           4   12
               / \
              10  14
        */
        bst = BinaryTreeUtil.createSampleBT2();
        printBottomView(bst);
    }

    static void printBottomView(BinaryTree bst) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<BinaryTreeNode> q = new LinkedList<>();
        BinaryTreeNode temp = bst.root;
        int hd = 0;
        temp.hd = hd;
        q.add(temp);

        while (!q.isEmpty()) {
            temp = q.remove();
            hd = temp.hd;
            map.put(hd, temp.data);
            if (temp.left != null) {
                temp.left.hd = hd - 1;
                q.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.hd = hd + 1;
                q.add(temp.right);
            }
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.print(entry.getValue() + " ");
        }
    }
}
