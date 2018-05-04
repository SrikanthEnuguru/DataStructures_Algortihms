package practise.datastructures.BinaryTree;

import org.junit.Test;

public class BinaryTreeTest {
	
	public BinaryTree createSampleBT() {
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

	@Test
	public void preOrderRecursiveTest() {
		BinaryTree tree = createSampleBT();
		System.out.print("PreOrderTraversal : ");
		PreOrderTraversal.preOrderRecursive(tree.getRoot());
		System.out.println();
	}
	
	@Test
	public void inOrderRecursiveTest() {
		BinaryTree tree = createSampleBT();	
		System.out.print("InOrderTraversal : ");
		InOrderTraversal.inOrderRecursive(tree.getRoot());
		System.out.println();
	}
	
	@Test
	public void postOrderRecursiveTest() {
		BinaryTree tree = createSampleBT();	
		System.out.print("PostOrderTraversal : ");
		PostOrderTraversal.PostOrderRecursive(tree.getRoot());
		System.out.println();
	}

}
