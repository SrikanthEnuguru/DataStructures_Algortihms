package practise.datastructures.BinaryTree;

public class PreOrderTraversal {
	
	public static void preOrderRecursive(BinaryTreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.getData());
		preOrderRecursive(root.getLeft());
		preOrderRecursive(root.getRight());		
	}

}
