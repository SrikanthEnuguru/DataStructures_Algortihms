package practise.top.easy.linkedlist;

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * Input: head = [1,2,2,1]
 * Output: true
 * <p>
 * Refer: https://leetcode.com/problems/palindrome-linked-list/solutions/433547/official-solution/
 */
public class CheckLinkedListPalindrome {
    public boolean isPalindrome(ListNode head) {
        boolean result = true;
        if (head == null) {
            return true;
        }
        // find firstHalfEnd
        ListNode firstHalfEnd = firstHalfEnd(head);

        //reverse second half
        ListNode secondHalfStart = reverse(firstHalfEnd.next);

        //check palindrome case
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;

        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        //revert back the reversed second half
        firstHalfEnd.next = reverse(firstHalfEnd.next);

        return result;
    }

    public ListNode firstHalfEnd(ListNode head) {
        ListNode fp = head;
        ListNode sp = head;
        while (fp.next != null && fp.next.next != null) {
            fp = fp.next.next;
            sp = sp.next;
        }
        return sp;
    }

    public ListNode reverse(ListNode head) {
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
}
