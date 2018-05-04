package practise.datastructures.BinaryTree;

public class BinaryTree {
	
	private BinaryTreeNode root;
	
	public BinaryTree() {		
		this.root = null;
	}

	public BinaryTree(BinaryTreeNode root) {		
		this.root = root;
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	
	public boolean isDataExists(int data) {
		return BinaryTreeNode.findDataInBT(root, data);
	}
	
	public int numOfNodes() {
		return root.numOfNodes();
	}
	
}
