package practise.datastructures.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	
	public static void leverOrder(BinaryTreeNode root) {
		if(root == null) {
			return;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		System.out.print("Level Order Traversal : ");
		q.add(root);		
		while(!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			System.out.print(temp.getData());			
			if(temp.getLeft() != null) {
				q.add(temp.getLeft());
			}
			if(temp.getRight()!=null) {
				q.add(temp.getRight());
			}						
		}
	}
	
	public static void leverOrderRecursive(BinaryTree tree) {
		int height = tree.height(tree.getRoot());
		for(int i=1;i<=height;i++) {
			levelOrderRecAux(tree.getRoot(),i);
		}
	}
	
	private static void levelOrderRecAux(BinaryTreeNode root,int h) {
		if(root==null) {
			return;
		}
		if(h==1) {
			System.out.print(root.getData());
		} else if(h>1) {
			levelOrderRecAux(root.getLeft(), h-1);
			levelOrderRecAux(root.getRight(), h-1);
		}
	}
	
	public static void leverOrderLevelWise(BinaryTreeNode root) {
		if(root == null) {
			return;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		System.out.print("Level Order Traversal : ");
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if(temp!=null) {
				System.out.print(temp.getData());
				if(temp.getLeft() != null) {
					q.add(temp.getLeft());
				}
				if(temp.getRight()!=null) {
					q.add(temp.getRight());
				}	
			} else {				
				System.out.println();
				if (!q.isEmpty()) {
					q.add(null);
				}
			}
		}
	}
}
