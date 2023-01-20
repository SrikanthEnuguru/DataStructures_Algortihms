package practise.top.easy.linkedlist;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * <p>
 * Refer: https://leetcode.com/problems/remove-nth-node-from-end-of-list/solutions/127454/official-solution/
 */
public class RemoveNthNodeFromEnd {

    /**
     * Time complexity : O(L)
     * <p>
     * The algorithm makes one traversal of the list of LLL nodes. Therefore time complexity is O(L)O(L)O(L).
     * <p>
     * Space complexity : O(1)
     * <p>
     * We only used constant extra space.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode fp = head;
        ListNode sp = head;
        int count = 0;
        while (count <= n) {
            fp = fp.next;
        }

        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next;
        }
        sp.next = sp.next.next;
        return sentinel.next;
    }
}
