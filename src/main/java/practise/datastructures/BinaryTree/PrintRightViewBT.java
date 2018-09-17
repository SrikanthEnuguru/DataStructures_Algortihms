package practise.datastructures.BinaryTree;

public class PrintRightViewBT {

	public static void main(String[] args) {				
		BinaryTree tree = BinaryTreeUtil.createSampleBT();		
		PrintRightViewBT obj  = new PrintRightViewBT();
		obj.printRightViewRec(tree.getRoot());
	}	
	
	public void printRightViewRec(BinaryTreeNode root) {
		printRightViewAux(root,1);
	}
	
	int max_level= 0;
	public void printRightViewAux(BinaryTreeNode node, int level) {
		if(node==null) return;
		if(level>max_level) {
			System.out.println(node.getData());
			max_level=level;
		}
		printRightViewAux(node.getRight(), level+1);
		printRightViewAux(node.getLeft(), level+1);
		
	}

}
