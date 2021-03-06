package practise.datastructures.BinaryTree;

public class BinaryTreeNode {

	public int data;
	public int hd;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	public BinaryTreeNode nextRight;
	
	public BinaryTreeNode(int data) {		
		this.data = data;
		this.hd = Integer.MAX_VALUE;
		this.left = null;
		this.right = null;
		this.nextRight = null;
	}
	
	public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {		
		this.data = data;
		this.hd = Integer.MAX_VALUE;
		this.left = left;
		this.right = right;
		this.nextRight = null;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BinaryTreeNode getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	public BinaryTreeNode getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public BinaryTreeNode getNextRight() {
		return nextRight;
	}

	public void setNextRight(BinaryTreeNode nextRight) {
		this.nextRight = nextRight;
	}

	public int getHd() {
		return hd;
	}

	public void setHd(int hd) {
		this.hd = hd;
	}
	
	// Tests whether this node is a leaf node.
	public boolean isLeaf() {
		return left == null && right == null;
	}
	
	// Tests whether the root argument contains within itself the data argument.
	public static boolean findDataInBT(BinaryTreeNode node,int data) {
		if(node == null) {
			return false;
		}
		if(node.data == data) {
			return true;
		}
		return findDataInBT(node.left,data)||findDataInBT(node.right,data);
	}
	
	public int numOfNodes() {
		int leftCount = this.left==null ? 0 : left.numOfNodes();
		int rightCount = this.right==null?0 : right.numOfNodes();
		return 1+leftCount+rightCount;
	}
	

}
