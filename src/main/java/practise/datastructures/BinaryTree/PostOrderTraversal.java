package practise.datastructures.BinaryTree;

public class PostOrderTraversal {

	public static void PostOrderRecursive(BinaryTreeNode root) {
		if(root == null) {
			return;
		}		
		PostOrderRecursive(root.getLeft());
		PostOrderRecursive(root.getRight());
		System.out.print(root.getData());
	}
	
}
