package practise.datastructures.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
 * <p>
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 * <p>
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 * <p>
 * https://leetcode.com/problems/find-median-from-data-stream/solutions/127527/find-median-from-data-stream/
 */
public class FindMedianFromDataStream {
    PriorityQueue<Integer> minH;
    PriorityQueue<Integer> maxH;

    /**
     * initialize your data structure here.
     */
    public FindMedianFromDataStream() {
        minH = new PriorityQueue<Integer>();
        /* By default, Java provides min heap. For max heap, we need to pass in a appropriate comparator */
        maxH = new PriorityQueue<>(1, new Comparator<Integer>() {
            public int compare(Integer ob1, Integer ob2) {
                return ob2.compareTo(ob1);
            }
        });
    }

    /**
     * Time complexity: O(5⋅logn)+O(1)≈O(logn).
     * <p>
     * At worst, there are three heap insertions and two heap deletions from the top.
     * Each of these takes about O(logn) time.
     * Finding the median takes constant O(1) time since the tops of heaps are directly accessible.
     * Space complexity: O(n) linear space to hold input in containers.
     */
    public void addNum(int num) {
        maxH.add(num);
        minH.add(maxH.poll());
        if (minH.size() > maxH.size()) {
            maxH.add(minH.poll());
        }
    }

    public double findMedian() {
        if (minH.size() == maxH.size())
            return (double) (maxH.peek() + minH.peek()) * 0.5;
        else
            return (double) maxH.peek();
    }
}
