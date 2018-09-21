package practise.datastructures.linkedlist;

import static practise.datastructures.linkedlist.LinkedListUtil.getSampleLinkedListOddNumOfNodes;
import static practise.datastructures.linkedlist.LinkedListUtil.printLinkedList;

public class RotateLinkedList {
    public static void main(String[] args) {
        LinkedList ll_odd = getSampleLinkedListOddNumOfNodes();
        printLinkedList(ll_odd.head);
        rotateLinkedList(ll_odd, 2);
        printLinkedList(ll_odd.head);
    }

    static void rotateLinkedList(LinkedList ll, int k) {
        if (k == 0) {
            return;
        }

        ListNode current = ll.head;
        int count = 1;

        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return;
        }

        ListNode KthNode = current;

        while (current.next != null) {
            current = current.next;
        }

        current.next = ll.head;
        ll.head = KthNode.next;
        KthNode.next = null;

    }
}
