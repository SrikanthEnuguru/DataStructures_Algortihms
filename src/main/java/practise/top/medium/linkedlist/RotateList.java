package practise.top.medium.linkedlist;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 * <p>
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * <p>
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 * <p>
 * https://leetcode.com/problems/rotate-list/
 * https://leetcode.com/problems/rotate-list/solutions/240869/rotate-list/?orderBy=most_votes
 */
public class RotateList {
    /**
     * Time complexity : O(N) where N is a number of elements in the list.
     * <p>
     * Space complexity : O(1) since it's a constant space solution.
     */
    public ListNode rotateRight(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for (n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }
}
