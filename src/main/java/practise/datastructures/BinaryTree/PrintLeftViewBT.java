package practise.datastructures.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftViewBT {

	public static void main(String[] args) {				
		BinaryTree tree = BinaryTreeUtil.createSampleBT();
		printLeftViewUsingLevelOrder(tree.getRoot());
		PrintLeftViewBT obj  = new PrintLeftViewBT();
		obj.printLeftViewRec(tree.getRoot());
	}
	
	public static void printLeftViewUsingLevelOrder(BinaryTreeNode root) {
		if(root==null) {
			return ;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int n = q.size();
			for(int i=1;i<=n; i++) {
				BinaryTreeNode temp = q.poll();
				if(i==1) {
					System.out.println(temp.getData());
				}
				if(temp.getLeft()!=null) {
					q.add(temp.getLeft());				
				}
				if(temp.getRight()!=null) {
					q.add(temp.getRight());
				}
			}			
			
		}
	}
	
	public void printLeftViewRec(BinaryTreeNode root) {
		printLeftViewAux(root,1);
	}
	
	int max_level= 0;
	public void printLeftViewAux(BinaryTreeNode node, int level) {
		if(node==null) return;
		if(level>max_level) {
			System.out.println(node.getData());
			max_level=level;
		}
		printLeftViewAux(node.getLeft(), level+1);
		printLeftViewAux(node.getRight(), level+1);
	}

}
