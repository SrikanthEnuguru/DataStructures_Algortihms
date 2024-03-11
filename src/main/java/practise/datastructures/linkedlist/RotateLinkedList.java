package practise.datastructures.linkedlist;

import static practise.datastructures.linkedlist.LinkedListUtil.getSampleLinkedListOddNumOfNodes;
import static practise.datastructures.linkedlist.LinkedListUtil.printLinkedList;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 * https://leetcode.com/problems/rotate-list/description/
 */
public class RotateLinkedList {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        int size = 1; // since we are already at head node
        ListNode fast=head;
        ListNode slow = head;

        while(fast.next!=null){
            size++;
            fast = fast.next;
        }

        for(int i=size-k%size;i>1;i--) // i>1 because we need to put slow.next at the start.
            slow = slow.next;

        // No dummy variable.
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}
