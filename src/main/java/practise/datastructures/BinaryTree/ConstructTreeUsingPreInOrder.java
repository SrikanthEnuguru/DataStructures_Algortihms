package practise.datastructures.BinaryTree;

public class ConstructTreeUsingPreInOrder {
    static int preIndex = 0;

    public static void main(String[] args) {
        /* Constructed binary tree is
                1
              /   \
             2     3
            / \   / \
           4   5  6  7
        */

        int[] in = new int[]{4, 2, 5, 1, 6, 3, 7};
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int len = in.length;
        BinaryTreeNode root = buildTree(in, pre, 0, len - 1);
        System.out.println("Root: " + root.data);
        System.out.println("Child of Node 1: " + root.left.data + " , " + root.right.data);
        System.out.println("Child of Node 2: " + root.left.left.data + " , " + root.left.right.data);
        System.out.println("Child of Node 3: " + root.right.left.data + " , " + root.right.right.data);
    }

    /* Recursive function to construct binary of size len from
       Inorder traversal in[] and Preorder traversal pre[].
       Initial values of inStrt and inEnd should be 0 and len -1.
       The function doesn't do any error checking for cases where
       inorder and preorder do not form a tree */
    static BinaryTreeNode buildTree(int[] in, int[] pre, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        /* Pick current node from Preorder traversal using preIndex
           and increment preIndex */
        BinaryTreeNode tNode = new BinaryTreeNode(pre[preIndex]);
        preIndex = preIndex + 1;

        /* If this node has no children then return */
        if (inStart == inEnd) {
            return tNode;
        }

        /* Else find the index of this node in Inorder traversal */
        int index = findIndex(in, inStart, inEnd, tNode.data);

        /* Using index in Inorder traversal, construct left and
           right subtress */
        tNode.left = buildTree(in, pre, inStart, index - 1);
        tNode.right = buildTree(in, pre, index + 1, inEnd);

        return tNode;
    }

    /* Function to find index of value in arr[start...end]
     The function assumes that value is present in in[] */
    static int findIndex(int[] in, int start, int end, int value) {
        int i;
        for (i = start; i <= end; i++) {
            if (in[i] == value) {
                return i;
            }
        }
        return i;
    }

}
