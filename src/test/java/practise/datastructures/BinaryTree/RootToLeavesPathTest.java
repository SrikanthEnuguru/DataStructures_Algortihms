package practise.datastructures.BinaryTree;

import org.junit.Test;

public class RootToLeavesPathTest {

	@Test
	public void printRootToLeavesPathsTest() {
		BinaryTree tree = new BinaryTreeTest().createSampleBT();
		RootToLeavesPath.printRootToLeavesPaths(tree.getRoot());
	}
}
