package practise.datastructures.linkedlist;

public class LinkedListUtil {
    static LinkedList getSampleLinkedList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        LinkedList ll = new LinkedList(node1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return ll;
    }

    static LinkedList getSampleLinkedListOddNumOfNodes() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        LinkedList ll = new LinkedList(node1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return ll;
    }

    static void printLinkedList(ListNode head) {
        ListNode temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
