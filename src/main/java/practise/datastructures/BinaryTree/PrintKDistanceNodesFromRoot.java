package practise.datastructures.BinaryTree;

// Java program to print nodes at k distance from root

public class PrintKDistanceNodesFromRoot {

    public static void main(String[] args) {
        /* Constructed binary tree is
                1
              /   \
             2     3
            / \    /\
           4   5  6  7
        */
        BinaryTree tree = BinaryTreeUtil.createSampleBT();
        printKDistanceNodesDown(tree.root, 2);
    }

    public static void printKDistanceNodesDown(BinaryTreeNode node, int k) {

        // Base Case
        if (node == null || k < 0)
            return;

        // If we reach a k distant node, print it
        if (k == 0) {
            System.out.print(node.data + " ");
            return;
        }

        // Recur for left and right subtrees
        printKDistanceNodesDown(node.left, k - 1);
        printKDistanceNodesDown(node.right, k - 1);
    }
}
