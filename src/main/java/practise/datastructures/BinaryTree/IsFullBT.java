package practise.datastructures.BinaryTree;

public class IsFullBT {

    public static void main(String[] args) {
        BinaryTree bt = BinaryTreeUtil.createSampleBT();
        if (isFullBT(bt.root)) {
            System.out.println("Given Tree is a Full Binary Tree.");
        } else {
            System.out.println("Given Tree is NOT a Full Binary Tree.");
        }

        /* Constructed binary search tree is
                10
              /    \
            -10     30
              \     / \
              8   25 60
            / \    \   \
           6  9    28   78
        */
        bt = BinaryTreeUtil.createSampleBST2();
        if (isFullBT(bt.root)) {
            System.out.println("Given Tree is a Full Binary Tree.");
        } else {
            System.out.println("Given Tree is NOT a Full Binary Tree.");
        }
    }

    static boolean isFullBT(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null && root.right != null) {
            return isFullBT(root.left) && isFullBT(root.right);
        }
        return false;
    }
}
