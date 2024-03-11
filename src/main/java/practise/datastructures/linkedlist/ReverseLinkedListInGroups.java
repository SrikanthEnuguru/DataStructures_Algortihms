package practise.datastructures.linkedlist;

import java.util.Stack;

import static practise.datastructures.linkedlist.LinkedListUtil.getSampleLinkedList;
import static practise.datastructures.linkedlist.LinkedListUtil.printLinkedList;

public class ReverseLinkedListInGroups {

    public static void main(String[] args) {
        LinkedList ll = getSampleLinkedList();
        printLinkedList(ll.head);
        ListNode temp = reverseLinkedListInGroups(ll.head, 2);
        printLinkedList(temp);

        ll = getSampleLinkedList();
        printLinkedList(ll.head);
        temp = reverseLinkedListInGroupsUsingStack(ll.head, 3);
        printLinkedList(temp);
    }

    static ListNode reverseLinkedListInGroups(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) {
                return head;
            }
            temp = temp.next;
        }

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
        if (next != null) {
            head.next = reverseLinkedListInGroups(next, k);
        }
        // prev is now head of input list
        return prev;
    }

    /* Reverses the linked list in groups of size k
    and returns the pointer to the new head node. */
    static ListNode reverseLinkedListInGroupsUsingStack(ListNode head, int k) {

        Stack s = new Stack();
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            int count = 0;

            // Terminate the loop whichever comes first
            // either current == NULL or count >= k
            while (count < k && curr != null) {
                s.push(curr);
                curr = curr.next;
                count++;
            }

            // Now pop the elements of stack one by one
            while (!s.empty()) {
                if (prev == null) {
                    prev = (ListNode) s.pop();
                    head = prev;
                } else {
                    prev.next = (ListNode) s.pop();
                    prev = prev.next;
                }
            }

        }
        // Next of last element will point to NULL.
        prev.next = null;
        return head;
    }
}
