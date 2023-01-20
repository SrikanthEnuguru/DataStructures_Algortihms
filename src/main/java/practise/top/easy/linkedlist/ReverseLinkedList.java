package practise.top.easy.linkedlist;

/**
 * Refer: https://leetcode.com/problems/reverse-linked-list/solutions/127809/official-solution/
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        ListNode n = reverseList_Recursive(n1);
    }

    /**
     * Time complexity : O(n). Assume that nnn is the list's length, the time complexity is O(n)O(n)O(n).
     * <p>
     * Space complexity : O(1).
     */
    public ListNode reverseList_Iterative(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * Time complexity : O(n).
     * Assume that nnn is the list's length, the time complexity is O(n)O(n)O(n).
     * <p>
     * Space complexity : O(n). The extra space comes from implicit stack space due to recursion.
     * The recursion could go up to nnn levels deep.
     */
    public static ListNode reverseList_Recursive(ListNode node) {
        //base condition
        if (node == null || node.next == null) {
            return node;
        }
        ListNode p = reverseList_Recursive(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }
}
