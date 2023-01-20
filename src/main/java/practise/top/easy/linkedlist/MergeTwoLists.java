package practise.top.easy.linkedlist;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * <p>
 * Refer: https://leetcode.com/problems/merge-two-sorted-lists/solutions/127763/official-solution/
 */
public class MergeTwoLists {
    /**
     * Time complexity : O(n+m)
     * <p>
     * Because each recursive call increments the pointer to l1 or l2 by one
     * (approaching the dangling null at the end of each list), there will be exactly one call to mergeTwoLists per element
     * in each list. Therefore, the time complexity is linear in the combined size of the lists.
     * <p>
     * Space complexity : O(n+m)
     * <p>
     * The first call to mergeTwoLists does not return until the ends of both l1 and l2 have been reached,
     * so n+m stack frames consume O(n+m)O(n + m)O(n+m) space.
     */
    public ListNode mergeTwoLists_Recursive(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists_Recursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists_Recursive(list1, list2.next);
            return list2;
        }
    }

    /**
     * Time complexity : O(n+m)
     * <p>
     * Because exactly one of l1 and l2 is incremented on each loop iteration,
     * the while loop runs for a number of iterations equal to the sum of the lengths of the two lists.
     * All other work is constant, so the overall complexity is linear.
     * <p>
     * Space complexity : O(1)
     * <p>
     * The iterative approach only allocates a few pointers, so it has a constant overall memory footprint.
     */
    public ListNode mergeTwoLists_Iterative(ListNode list1, ListNode list2) {
        ListNode sentinel = new ListNode(-1);
        ListNode curr = sentinel;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 == null) {
            curr.next = list2;
        } else {
            curr.next = list1;
        }
        return sentinel.next;
    }
}
