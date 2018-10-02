package practise.datastructures.BinaryTree;

//Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.
public class MaxPathSumInBT {

    public static void main(String[] args) {
        /* Constructed binary tree is
                 10
              /    \
             2      10
            / \     \
           20  1    -25
                    / \
                   3   4
          Math path sum =42 (20+2+10+10)
        */
        BinaryTreeNode node20 = new BinaryTreeNode(20);
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node20, node1);
        BinaryTreeNode node_25 = new BinaryTreeNode(-25, node3, node4);
        BinaryTreeNode node10 = new BinaryTreeNode(10, null, node_25);
        BinaryTreeNode root = new BinaryTreeNode(10, node2, node10);

        System.out.print("Max Path Sum in BT: " + maxPathSum(root));
    }

    static int maxPathSum(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        maxPathSum(root, res);
        return res.val;
    }

    /**
     * For each node there can be four ways that the max path goes through the node:
     * 1. Node only
     * 2. Max path through Left Child + Node
     * 3. Max path through Right Child + Node
     * 4. Max path through Left Child + Node + Max path through Right Child
     */
    static int maxPathSum(BinaryTreeNode node, Res res) {
        if (node == null) {
            return 0;
        }

        // l and r store maximum path sum going through left and
        // right child of root respectively
        int l = maxPathSum(node.left, res);
        int r = maxPathSum(node.right, res);

        //Maximum of l and r
        int max_lr = Math.max(l, r);

        // Max path for parent call of root. This path must include at-most one child of root
        int max_single = Math.max(max_lr + node.data, node.data);

        // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + node.data);

        // Store the Maximum Result.
        res.val = Math.max(res.val, max_top);

        return max_single;
    }
}

// An object of Res is passed around so that the
// same value can be used by multiple recursive calls.
class Res {
    int val;
}
