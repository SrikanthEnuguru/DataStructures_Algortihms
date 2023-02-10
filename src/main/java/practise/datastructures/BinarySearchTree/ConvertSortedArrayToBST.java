package practise.datastructures.BinarySearchTree;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced binary search tree.
 * <p>
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 * <p>
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/solutions/422736/convert-sorted-array-to-bst/
 */
public class ConvertSortedArrayToBST {
    int[] nums;

    public TreeNode helper(int left, int right) {
        if (left > right) return null;

        // always choose left middle node as a root
        int mid = (left + right) / 2;

        // preorder traversal: node -> left -> right
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(left, mid - 1);
        root.right = helper(mid + 1, right);
        return root;
    }

    /**
     * Time complexity: O(N) since we visit each node exactly once.
     * <p>
     * Space complexity: O(logN).
     * The recursion stack requires O(logN) space because the tree is height-balanced.
     * Note that the O(N) space used to store the output does not count as auxiliary space,
     * so it is not included in the space complexity.
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }
}
