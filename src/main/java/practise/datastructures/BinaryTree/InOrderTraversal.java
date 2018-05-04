package practise.datastructures.BinaryTree;

public class InOrderTraversal {
	
	public static void inOrderRecursive(BinaryTreeNode root) {
		if(root == null) {
			return;
		}
		inOrderRecursive(root.getLeft());
		System.out.print(root.getData());		
		inOrderRecursive(root.getRight());		
	}
}
