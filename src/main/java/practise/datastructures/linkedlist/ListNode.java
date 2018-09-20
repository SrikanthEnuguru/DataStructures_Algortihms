package practise.datastructures.linkedlist;

public class ListNode {

    int data;
    ListNode next;

    ListNode() {
        next = null;
    }

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return data + " ";
    }
}
