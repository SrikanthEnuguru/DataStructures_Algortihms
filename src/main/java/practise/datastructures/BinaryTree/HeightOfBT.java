package practise.datastructures.BinaryTree;

public class HeightOfBT {
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
        BinaryTree bt = BinaryTreeUtil.createSampleBT2();
        System.out.println(height(bt.root));
        /* Constructed binary tree is
                1
              /   \
             3     2
            / \    /\
           7   6  5  4
        */
        bt = BinaryTreeUtil.createSampleBT();
        System.out.println(height(bt.root));
    }

    static int height(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if (lh > rh) {
            return 1 + lh;
        } else {
            return 1 + rh;
        }
    }
}
