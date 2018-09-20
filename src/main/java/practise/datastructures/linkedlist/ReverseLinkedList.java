package practise.datastructures.linkedlist;

import static practise.datastructures.linkedlist.LinkedListUtil.getSampleLinkedList;
import static practise.datastructures.linkedlist.LinkedListUtil.printLinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList ll = getSampleLinkedList();
        printLinkedList(ll.head);
        ListNode temp = reverse(ll.head);
        printLinkedList(temp);
    }

    static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
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
