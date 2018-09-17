package practise.datastructures.BinaryTree;

import java.util.Stack;

public class InOrderTraversal {

	public static void inOrderRecursive(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		inOrderRecursive(root.getLeft());
		System.out.print(root.getData());
		inOrderRecursive(root.getRight());
	}

	public static void inOrderIterativeStack(BinaryTreeNode root) {
		if (root == null) {
			return;
		}

		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		BinaryTreeNode node = root;
		
		while(node!=null) {
			s.push(node);
			node= node.getLeft();
		}
		
		while(!s.isEmpty()) {
			node = s.pop();
			System.out.print(node.getData());
			if(node.getRight()!=null) {
				node=node.getRight();
				while(node!=null) {
					s.push(node);
					node=node.getLeft();
				}
			}
		}
	}
}
