package practise.datastructures.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

    public static void main(String[] args) {
        /* Constructed binary tree is
                1
              /   \
             2     3
            / \    /\
           4   5  6  7
        */
        BinaryTree bt = BinaryTreeUtil.createSampleBT();
        connectNextNode(bt);
        System.out.println("Next Right of Node: 1 : " + bt.root.nextRight);
        System.out.println("Next Right of Node: 2 : " + bt.root.left.nextRight.data);
        System.out.println("Next Right of Node: 3 : " + bt.root.right.nextRight);
        System.out.println("Next Right of Node: 4 : " + bt.root.left.left.nextRight.data);
        System.out.println("Next Right of Node: 5 : " + bt.root.left.right.nextRight.data);
        System.out.println("Next Right of Node: 6 : " + bt.root.right.left.nextRight.data);
        System.out.println("Next Right of Node: 7 : " + bt.root.right.right.nextRight);
    }

    static void connectNextNode(BinaryTree bt) {
        if (bt.root == null) {
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<>();
        BinaryTreeNode node = bt.root;
        q.add(node);
        q.add(null);
        while (!q.isEmpty()) {
            node = q.remove();
            if (node != null) {
                node.nextRight = q.peek();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            } else if (!q.isEmpty()) {
                q.add(null);
            }
        }
    }
}
