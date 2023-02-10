package practise.datastructures.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
 * height-balanced binary search tree.
 * <p>
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
 * <p>
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/solutions/194035/convert-sorted-list-to-binary-search-tree/?orderBy=most_votes
 */
public class ConvertSortedListToBinarySearchTree {
    private List<Integer> values = new ArrayList<Integer>();

    /**
     * Time Complexity: O(NlogN)
     * From the looks of it, this seems to be an O(N2)algorithm. However, on closer analysis,
     * it turns out to be a bit more efficient than O(N^2).
     * <p>
     * Space Complexity: O(logN). Since we are resorting to recursion, there is always the added space complexity
     * of the recursion stack that comes into picture. This could have been O(N) for a skewed tree,
     * but the question clearly states that we need to maintain the height balanced property.
     * This ensures the height of the tree to be bounded by O(logN). Hence, the space complexity is O(logN).
     */
    public TreeNode sortedListToBST_Approach1(ListNode head) {

        // If the head doesn't exist, then the linked list is empty
        if (head == null) {
            return null;
        }

        // Find the middle element for the list.
        ListNode mid = this.findMiddleElement(head);

        // The mid becomes the root of the BST.
        TreeNode node = new TreeNode(mid.val);

        // Base case when there is just one element in the linked list
        if (head == mid) {
            return node;
        }

        // Recursively form balanced BSTs using the left and right halves of the original list.
        node.left = this.sortedListToBST_Approach1(head);
        node.right = this.sortedListToBST_Approach1(mid.next);
        return node;
    }

    private ListNode findMiddleElement(ListNode head) {

        // The pointer used to disconnect the left half from the mid node.
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        // Iterate until fastPr doesn't reach the end of the linked list.
        while (fastPtr != null && fastPtr.next != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // Handling the case when slowPtr was equal to head.
        if (prevPtr != null) {
            prevPtr.next = null;
        }

        return slowPtr;
    }

    /**
     * Time Complexity: The time complexity comes down to just O(N) now since we convert the linked list to an
     * array initially and then we convert the array into a BST. Accessing the middle element now takes O(1) time and
     * hence the time complexity comes down.
     * <p>
     * Space Complexity: Since we used extra space to bring down the time complexity,
     * the space complexity now goes up to O(N) as opposed to just O(logN) in the previous solution.
     * This is due to the array we construct initially.
     */
    public TreeNode sortedListToBST_Appraoch2(ListNode head) {

        // Form an array out of the given linked list and then
        // use the array to form the BST.
        this.mapListToValues(head);

        // Convert the array to
        return convertListToBST(0, this.values.size() - 1);
    }

    private TreeNode convertListToBST(int left, int right) {
        // Invalid case
        if (left > right) {
            return null;
        }

        // Middle element forms the root.
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(this.values.get(mid));

        // Base case for when there is only one element left in the array
        if (left == right) {
            return node;
        }

        // Recursively form BST on the two halves
        node.left = convertListToBST(left, mid - 1);
        node.right = convertListToBST(mid + 1, right);
        return node;
    }

    private void mapListToValues(ListNode head) {
        while (head != null) {
            this.values.add(head.val);
            head = head.next;
        }
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
