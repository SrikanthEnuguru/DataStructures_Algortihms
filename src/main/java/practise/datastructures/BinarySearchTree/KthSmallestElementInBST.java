package practise.datastructures.BinarySearchTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/solutions/284145/kth-smallest-element-in-a-bst/?orderBy=most_votes
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = inorder(root, new ArrayList<>());
        return arr.get(k-1);
    }

    public List<Integer> inorder(TreeNode root, List<Integer> arr){
        if(root==null) return arr;

        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public int kthSmallest_Itr(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        while(true) {
            while(root != null) {
                stack.offerFirst(root);
                root = root.left;
            }
            root = stack.pollFirst();
            if(--k == 0) return root.val;
            root = root.right;
        }
    }
}
