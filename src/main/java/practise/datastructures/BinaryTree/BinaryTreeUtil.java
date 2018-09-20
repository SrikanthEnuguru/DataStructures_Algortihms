package practise.datastructures.BinaryTree;

public class BinaryTreeUtil {
	
	
	public static BinaryTree createSampleBT() {
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
