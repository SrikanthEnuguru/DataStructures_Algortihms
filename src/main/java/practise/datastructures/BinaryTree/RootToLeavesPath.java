package practise.datastructures.BinaryTree;

import java.util.LinkedList;
import java.util.List;

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

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new LinkedList<>();
		if(root==null) return paths;

		LinkedList<TreeNode> node_stack = new LinkedList<>();
		LinkedList<String> path_stack = new LinkedList<>();
		node_stack.add(root);
		path_stack.add(Integer.toString(root.val));
		TreeNode node;
		String path;
		while ( !node_stack.isEmpty() ) {
			node = node_stack.pollLast();
			path = path_stack.pollLast();
			if ((node.left == null) && (node.right == null))
				paths.add(path);
			if (node.left != null) {
				node_stack.add(node.left);
				path_stack.add(path + "->" + node.left.val);
			}
			if (node.right != null) {
				node_stack.add(node.right);
				path_stack.add(path + "->" + node.right.val);
			}
		}
		return paths;
	}

}
