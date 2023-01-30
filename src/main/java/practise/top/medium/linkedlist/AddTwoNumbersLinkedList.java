package practise.top.medium.linkedlist;

import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * https://leetcode.com/problems/add-two-numbers/solutions/127833/add-two-numbers/
 */
public class AddTwoNumbersLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l14 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l26 = new ListNode(6);
        ListNode l24 = new ListNode(4);

        l1.next = l14;
        l14.next = l13;
        l13.next = null;

        l2.next = l26;
        l26.next = l24;
        l24.next = null;

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    /**
     * Time complexity : O(max(m,n)).
     * Assume that m and n represents the length of l1 and l2 respectively,
     * the algorithm above iterates at most max(m,n) times.
     * <p>
     * Space complexity : O(max(m,n)).
     * The length of the new list is at most max(m,n)+1.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummy.next;
    }
}
