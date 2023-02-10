package practise.datastructures.BinarySearchTree;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 * <p>
 * Input: n = 3
 * Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * <p>
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * https://leetcode.com/problems/unique-binary-search-trees-ii/solutions/187794/unique-binary-search-trees-ii/?orderBy=most_votes
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees_Rec(1, n);
    }

    public LinkedList<TreeNode> generateTrees_Rec(int start, int end) {
        LinkedList<TreeNode> all_trees = new LinkedList<TreeNode>();
        if (start > end) {
            all_trees.add(null);
            return all_trees;
        }

        // pick up a root
        for (int i = start; i <= end; i++) {
            // all possible left subtrees if i is choosen to be a root
            LinkedList<TreeNode> left_trees = generateTrees_Rec(start, i - 1);

            // all possible right subtrees if i is choosen to be a root
            LinkedList<TreeNode> right_trees = generateTrees_Rec(i + 1, end);

            // connect left and right trees to the root i
            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = l;
                    current_tree.right = r;
                    all_trees.add(current_tree);
                }
            }
        }
        return all_trees;
    }
}

