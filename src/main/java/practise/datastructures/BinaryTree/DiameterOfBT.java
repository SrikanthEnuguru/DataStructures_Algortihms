package practise.datastructures.BinaryTree;

public class DiameterOfBT {

    public static void main(String[] args) {
        /* creating a binary tree and entering the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode(1);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.right = new BinaryTreeNode(3);
        tree.root.left.left = new BinaryTreeNode(4);
        tree.root.left.right = new BinaryTreeNode(5);
        System.out.println("The diameter of given binary tree is : "
                + diameter(tree.root));
        System.out.println("The diameter of given binary tree is : "
                + diameter_new(tree.root));
    }


    // Function to calculate diameter of tree.
    // Time Complexity: O(n^2)
    static int diameter(BinaryTreeNode root) {

        /* base case if tree is empty */
        if (root == null) {
            return 0;
        }

        /* get the height of left and right sub trees */
        int lh = HeightOfBT.height(root.left);
        int rh = HeightOfBT.height(root.right);

        /* get the diameter of left and right subtrees */
        int ld = diameter(root.left);
        int rd = diameter(root.right);

        /* Return max of following three
          1) Diameter of left subtree
         2) Diameter of right subtree
         3) Height of left subtree + height of right subtree + 1 */
        return Math.max(1 + lh + rh, Math.max(ld, rd));
    }

    // Function to calculate diameter of tree.
    // Time Complexity: O(n)
    static int diameter_new(BinaryTreeNode root) {
        /* base case if tree is empty */
        if (root == null) {
            return 0;
        }

        int ans = Integer.MIN_VALUE;
        ans = height(root, ans);
        return ans;
    }

    static int height(BinaryTreeNode root, int ans) {
        /* base case if tree is empty */
        if (root == null) {
            return 0;
        }

        /* get the height of left and right sub trees */
        int lh = height(root.left, ans);
        int rh = height(root.right, ans);

        // update the answer, because diameter of a
        // tree is nothing but maximum value of
        // (left_height + right_height + 1) for each node
        ans = Math.max(ans, 1 + lh + rh);

        return 1 + Math.max(lh, rh);
    }
}
