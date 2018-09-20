package practise.datastructures.BinaryTree;

public class RootToLeavesPath {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTreeUtil.createSampleBT();
		printRootToLeavesPaths(tree.getRoot());
	}
	
	public static void printRootToLeavesPaths(BinaryTreeNode root) {
		int[] paths = new int[1000];
		printRootToLeavesPathsAux(root,paths,0);
	}
	
	private static void printRootToLeavesPathsAux(BinaryTreeNode node, int[] paths,int pathLen) {
		paths[pathLen]=node.getData();
		pathLen++;
		
		if(node.getLeft()==null && node.getRight()==null) {
			printPath(paths,pathLen);
		} else {
			printRootToLeavesPathsAux(node.getLeft(),paths,pathLen);
			printRootToLeavesPathsAux(node.getRight(),paths,pathLen);
		}
	}
	
	private static void printPath(int[] path,int pathLen) {
		for(int i=0;i<pathLen;i++) {
			System.out.print(path[i]+" ");
		}
		System.out.println();
	}

}
