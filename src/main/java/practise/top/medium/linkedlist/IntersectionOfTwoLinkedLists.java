package practise.top.medium.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 * <p>
 * For example, the following two linked lists begin to intersect at node c1:
 * <p>
 * <p>
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * <p>
 * Note that the linked lists must retain their original structure after the function returns.
 *
 * https://leetcode.com/problems/intersection-of-two-linked-lists/solutions/1089148/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists {
    /**
     * Let N be the length of list A and M be the length of list B.
     * <p>
     * Time complexity : O(N×M).
     * <p>
     * For each of the N nodes in list A, we are traversing over each of the nodes in list B.
     * In the worst case, we won't find a match, and so will need to do this until reaching the end of list B,
     * giving a worst-case time complexity of O(N×M).
     * <p>
     * Space complexity : O(1).
     * <p>
     * We aren't allocating any additional data structures,
     * so the amount of extra space used does not grow with the size of the input.
     */
    public ListNode getIntersectionNode_BF(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode pB = headB;
            while (pB != null) {
                if (headA == pB) return headA;
                pB = pB.next;
            }
            headA = headA.next;
        }
        return null;
    }

    /**
     * Time complexity : O(N+M).
     * <p>
     * Firstly, we need to build up the hash table.
     * It costs O(1) to insert an item into a hash table, and we need to do this for each of the M nodes in list B.
     * This gives a cost of O(M) for building the hash table.
     * <p>
     * Secondly, we need to traverse list A, and for each node, we need to check whether or not it is in the hash table. In the worst case, there will not be a match, requiring us to check all NNN nodes in list A.
     * As it is also O(1) to check whether or not an item is in a hash table, this checking has a total cost of O(N).
     * <p>
     * Finally, combining the two parts, we get O(M)+O(N)=O(M+N)
     * <p>
     * Space complexity : O(M).
     * <p>
     * As we are storing each of the nodes from list B into a hash table, the hash table will require O(M) space.
     * Note that we could have instead stored the nodes of list A into the hash table,
     * this would have been a space complexity of O(N). Unless we know which list is longer though, it doesn't make any real difference.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodesInB = new HashSet<ListNode>();

        while (headB != null) {
            nodesInB.add(headB);
            headB = headB.next;
        }

        while (headA != null) {
            // if we find the node pointed to by headA,
            // in our set containing nodes of B, then return the node
            if (nodesInB.contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }

        return null;
    }

    /**
     * Let N be the length of list A and M be the length of list B.
     * <p>
     * Time complexity : O(N+M).
     * <p>
     * In the worst case, each list is traversed twice giving 2⋅M+2⋅N, which is equivalent to O(N+M).
     * This is because the pointers firstly go down each list so that they can be "lined up" and then in the second iteration, the intersection node is searched for.
     * <p>
     * An interesting observation you might have made is that when the lists are of the same length, this algorithm only traverses each list once.
     * This is because the pointers are already "lined up" from the start, so the additional pass is unnecessary.
     * <p>
     * Space complexity : O(1).
     * <p>
     * We aren't allocating any additional data structures, so the amount of extra space used does not grow with the size of the input.
     * For this reason, Approach 3 is better than Approach 2.
     */
    public ListNode getIntersectionNode_TwoPointers(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
        // Note: In the case lists do not intersect, the pointers for A and B
        // will still line up in the 2nd iteration, just that here won't be
        // a common node down the list and both will reach their respective ends
        // at the same time. So pA will be NULL in that case.
    }
}
