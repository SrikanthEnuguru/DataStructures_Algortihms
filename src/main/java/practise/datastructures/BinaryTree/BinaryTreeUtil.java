package practise.datastructures.BinaryTree;

public class BinaryTreeUtil {
	
	
	public static BinaryTree createSampleBT() {
		/* Constructed binary tree is
                1
              /   \
             2     3
            / \    /\
           4   5  6  7

           Inorder: 4 2 5 1 6 3 7
        */
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		 BinaryTreeNode node6 = new BinaryTreeNode(6);
		 BinaryTreeNode node7 = new BinaryTreeNode(7);
		 BinaryTreeNode node2 = new BinaryTreeNode(2,node4,node5);
		 BinaryTreeNode node3 = new BinaryTreeNode(3,node6,node7);
		 BinaryTreeNode root = new BinaryTreeNode(1,node2,node3);
		BinaryTree tree = new BinaryTree(root);
		return tree;
	}

	public static BinaryTree createSampleBTMirror() {
		/* Constructed binary tree is
                1
              /   \
             3     2
            / \    /\
           7   6  5  4
        */
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		BinaryTreeNode node6 = new BinaryTreeNode(6);
		BinaryTreeNode node7 = new BinaryTreeNode(7);
		BinaryTreeNode node2 = new BinaryTreeNode(2, node5, node4);
		BinaryTreeNode node3 = new BinaryTreeNode(3, node7, node6);
		BinaryTreeNode root = new BinaryTreeNode(1, node3, node2);
		BinaryTree tree = new BinaryTree(root);
		return tree;
	}

	public static BinaryTree createSampleBST() {		
		BinaryTreeNode node1 = new BinaryTreeNode(1);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		 BinaryTreeNode node3 = new BinaryTreeNode(3);
		 BinaryTreeNode node7 = new BinaryTreeNode(7);
		 
		 BinaryTreeNode node2 = new BinaryTreeNode(2,node1,node3);
		 BinaryTreeNode node6 = new BinaryTreeNode(6,node5,node7);
		 BinaryTreeNode root = new BinaryTreeNode(4,node2,node6);
		 
		BinaryTree tree = new BinaryTree(root);
		return tree;
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
	public static BinaryTree createSampleBST2() {
		BinaryTreeNode node6 = new BinaryTreeNode(6);
		BinaryTreeNode node9 = new BinaryTreeNode(9);
		BinaryTreeNode node28 = new BinaryTreeNode(28);
		BinaryTreeNode node78 = new BinaryTreeNode(78);

		BinaryTreeNode node8 = new BinaryTreeNode(8, node6, node9);
		BinaryTreeNode node25 = new BinaryTreeNode(25, null, node28);
		BinaryTreeNode node60 = new BinaryTreeNode(60, null, node78);
		BinaryTreeNode node_10 = new BinaryTreeNode(-10, null, node8);
		BinaryTreeNode node30 = new BinaryTreeNode(30, node25, node60);
		BinaryTreeNode root = new BinaryTreeNode(10, node_10, node30);

		BinaryTree tree = new BinaryTree(root);
		return tree;
	}

	public static BinaryTree createSampleBT2() {
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node22 = new BinaryTreeNode(22);
		BinaryTreeNode node10 = new BinaryTreeNode(10);
		BinaryTreeNode node14 = new BinaryTreeNode(14);
		BinaryTreeNode node12 = new BinaryTreeNode(12, node10, node14);
		BinaryTreeNode node8 = new BinaryTreeNode(8, node4, node12);

		BinaryTreeNode root = new BinaryTreeNode(20, node8, node22);
		BinaryTree tree = new BinaryTree(root);
		return tree;
	}


}
