package practise.datastructures.linkedlist;

import static practise.datastructures.linkedlist.LinkedListUtil.*;

public class MiddleElementInLinkedList {

    public static void main(String[] args) {
        LinkedList ll_odd = getSampleLinkedListOddNumOfNodes();
        printLinkedList(ll_odd.head);
        printMiddleElement(ll_odd);

        LinkedList ll_even = getSampleLinkedList();
        printLinkedList(ll_even.head);
        printMiddleElement(ll_even);
    }

    static void printMiddleElement(LinkedList ll) {
        ListNode sp = ll.head;
        ListNode fp = ll.head;

        while (sp != null && fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }
        System.out.println("Middle Element : " + sp.data);
    }
}
