package practise.datastructures.linkedlist;

import static practise.datastructures.linkedlist.LinkedListUtil.getSampleLinkedList;
import static practise.datastructures.linkedlist.LinkedListUtil.getSampleLinkedListWithLoop;

public class DetectLoopInLinkedList {

    public static void main(String[] args) {
        LinkedList ll = getSampleLinkedList();
        detectLoop(ll);

        ll = getSampleLinkedListWithLoop();
        detectLoop(ll);
    }

    static boolean detectLoop(LinkedList ll) {
        ListNode sp = ll.head;
        ListNode fp = ll.head;

        while (sp != null && fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            if (sp == fp) {
                System.out.println("Loop Exists");
                return true;
            }
        }
        System.out.println("Loop Doesn't Exists");
        return false;
    }
}
