package practise.datastructures.BinaryTree;

public class CheckIsBST {

	public static void main(String[] args) {
		BinaryTree bst= BinaryTreeUtil.createSampleBST();
		BinaryTree notBst = BinaryTreeUtil.createSampleBT();
		System.out.println(isBST(bst.getRoot()));
		System.out.println(isBST(notBst.getRoot()));

	}
	
	 static boolean isBST(BinaryTreeNode root) {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	 static boolean isBSTUtil(BinaryTreeNode node, int min, int max) {
		
		if(node==null) {
			return true;
		}
		
		//check constraints
		if(node.getData()<min || node.getData()>max) {
			return false;
		}
		
		return isBSTUtil(node.getLeft(),min,node.getData()-1) &&
				isBSTUtil(node.getRight(), node.getData()+1,max);
	}

}
