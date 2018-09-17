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

}
