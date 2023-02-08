package practise.top.hard.linkedlist;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * <p>
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * <p>
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * <p>
 * https://leetcode.com/problems/sort-list/solutions/840381/official-solution/
 */
public class SortLinkedList {

    /**
     * Time Complexity: O(nlogn), where nnn is the number of nodes in linked list.
     * The algorithm can be split into 2 phases, Split and Merge.
     * <p>
     * Space Complexity: O(logn) , where n is the number of nodes in linked list.
     * Since the problem is recursive, we need additional space to store the recursive call stack.
     * The maximum depth of the recursion tree is logn
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}

