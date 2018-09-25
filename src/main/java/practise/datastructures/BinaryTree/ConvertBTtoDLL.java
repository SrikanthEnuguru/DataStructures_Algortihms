package practise.datastructures.BinaryTree;

public class ConvertBTtoDLL {

    // head --> Pointer to head node of created doubly linked list
    static BinaryTreeNode head;

    // Initialize previously visited node as NULL. This is
    // static so that the same value is accessible in all recursive
    // calls
    static BinaryTreeNode prev = null;

    public static void main(String[] args) {
        /* Constructed binary tree is
                1
              /   \
             2     3
            / \    /\
           4   5  6  7

           Inorder: 4 2 5 1 6 3 7
        */
        BinaryTree bt = BinaryTreeUtil.createSampleBT();
        BinaryTree2DoubleLinkedList(bt.root);
        print(head);
    }


    // A simple recursive function to convert a given Binary tree to Doubly Linked List
    static void BinaryTree2DoubleLinkedList(BinaryTreeNode root) {
        // Base case
        if (root == null)
            return;

        // Recursively convert left subtree
        BinaryTree2DoubleLinkedList(root.left);

        // Now convert this node
        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        // Finally convert right subtree
        BinaryTree2DoubleLinkedList(root.right);
    }


    static void print(BinaryTreeNode root) {
        BinaryTreeNode curr = null;
        while (root != null) {
            curr = root;
            System.out.print(root.data + " ");
            root = root.right;
        }
        System.out.println();
        root = curr;
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.left;
        }
    }

}
