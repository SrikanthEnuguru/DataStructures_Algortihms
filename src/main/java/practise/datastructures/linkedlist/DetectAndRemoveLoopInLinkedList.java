package practise.datastructures.linkedlist;

import static practise.datastructures.linkedlist.LinkedListUtil.*;

public class DetectAndRemoveLoopInLinkedList {

    public static void main(String[] args) {
        LinkedList ll = getSampleLinkedListWithLoop();
        detectAndRemoveLoop(ll);
        printLinkedList(ll.head);

        ll = getSampleLinkedList();
        detectAndRemoveLoop(ll);
        printLinkedList(ll.head);
    }

    static void detectAndRemoveLoop(LinkedList ll) {
        ListNode sp = ll.head;
        ListNode fp = ll.head;

        while (sp != null && fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            if (sp == fp) {
                System.out.println("Loop Detected");
                break;
            }
        }

        sp = ll.head;
        ListNode last = null;
        while (sp != null && fp != null) {
            sp = sp.next;
            last = fp;
            fp = fp.next;
            if (sp == fp) {
                break;
            }
        }
        if (last != null) {
            last.next = null;
        } else {
            System.out.println("No Loop Found");
        }

    }
}
