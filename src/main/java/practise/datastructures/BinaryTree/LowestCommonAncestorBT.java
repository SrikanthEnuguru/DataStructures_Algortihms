package practise.datastructures.BinaryTree;

public class LowestCommonAncestorBT {

    public static void main(String[] args) {

        /* Constructed binary tree is
                3
              /    \
             6      8
            / \     \
           2   11    13
               / \   /
              9  5  7
        */
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node13 = new BinaryTreeNode(13);
        BinaryTreeNode node8 = new BinaryTreeNode(8, null, node13);
        BinaryTreeNode node11 = new BinaryTreeNode(11, node9, node5);
        BinaryTreeNode node6 = new BinaryTreeNode(6, node2, node11);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node8);

        System.out.println("LCA of Node 2 and 8 is : " + LCA_BT(node3, node2, node8).data);
        System.out.println("LCA of Node 2 and 5 is : " + LCA_BT(node3, node2, node5).data);
        System.out.println("LCA of Node 8 and 13 is : " + LCA_BT(node3, node8, node13).data);
    }

    static BinaryTreeNode LCA_BT(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2) {
        if (root == null) {
            return null;
        }

        if (root == n1 || root == n2) {
            return root;
        }

        BinaryTreeNode left = LCA_BT(root.left, n1, n2);
        BinaryTreeNode right = LCA_BT(root.right, n1, n2);

        if (left != null && right != null) {
            return root;
        }

        if (left == null && right == null) {
            return null;
        }

        return (left != null) ? left : right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //result
        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;
        }
        else { //both left and right are not null, we found our result
            return root;
        }
    }
}
