package practise.datastructures.BinaryTree;

import static practise.datastructures.BinaryTree.PrintKDistanceNodesFromRoot.printKDistanceNodesDown;

/**
 * here are two types of nodes to be considered.
 * 1) Nodes in the subtree rooted with target node.
 * For example if the target node is 8 and k is 2, then such nodes are 10 and 14.(PrintKDistanceNodesFromRoot is used)
 * <p>
 * 2) Other nodes, may be an ancestor of target, or a node in some other subtree.
 * For target node 8 and k is 2, the node 22 comes in this category. (This will be the main challenge)
 */
public class PrintKDistanceNodesFromTarget {

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
        BinaryTree tree = BinaryTreeUtil.createSampleBT2();
        BinaryTreeNode target = tree.root.left.right;
        System.out.println("Target Node Data: " + target.data);
        printKNodesFromTarget(tree.root, target, 2);

    }

    // Prints all nodes at distance k from a given target node.
    // The k distant nodes may be upward or downward.
    // This function returns distance of root from target node, it returns -1
    // if target node is not present in tree rooted with root.
    static int printKNodesFromTarget(BinaryTreeNode node, BinaryTreeNode target, int k) {

        // Base Case 1: If tree is empty, return -1
        if (node == null) {
            return -1;
        }

        // If target is same as root.
        if (node == target) {
            printKDistanceNodesDown(node, k);
            return 0;
        }

        //dl is Distance of root's left child from target
        int dl = printKNodesFromTarget(node.left, target, k);

        // Check if target node was found in left subtree
        if (dl != -1) {
            if (dl + 1 == k) {
                System.out.print(node.data + " ");
            } else {
                // Else go to right subtree and print all k-dl-2 distant nodes
                // Note that the right child is 2 edges away from left child
                printKDistanceNodesDown(node.right, k - dl - 2);
            }
            return 1 + dl;
        }

        // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
        // Note that we reach here only when node was not found in left
        // subtree
        int dr = printKNodesFromTarget(node.right, target, k);
        if (dr != -1) {
            if (dr + 1 == k) {
                System.out.print(node.data + " ");
            } else {
                printKDistanceNodesDown(node.left, k - dr - 2);
            }
            return 1 + dr;
        }

        // If target was neither present in left nor in right subtree
        return -1;
    }
}
