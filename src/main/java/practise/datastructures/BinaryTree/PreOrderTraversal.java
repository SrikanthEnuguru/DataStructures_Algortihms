package practise.datastructures.BinaryTree;

import java.util.Stack;

public class PreOrderTraversal {
	
	public static void preOrderRecursive(BinaryTreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.getData());
		preOrderRecursive(root.getLeft());
		preOrderRecursive(root.getRight());		
	}
	
	public static void preOrderIterative(BinaryTreeNode root) {
		if(root == null) {
			return;
		}
		
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		BinaryTreeNode node=root;
		
		while(node!=null) {
			System.out.print(node.getData());
			s.push(node);
			node=node.getLeft();
		}
		
		while(!s.isEmpty()) {
			node= s.pop();
			if(node.getRight()!=null) {
				node = node.getRight();
				while(node!=null) {
					System.out.print(node.getData());
					s.push(node);
					node=node.getLeft();
				}
			}
		}
		
		
	}

}
