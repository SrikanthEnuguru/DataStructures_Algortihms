package practise.datastructures.heap;

public class HeapTest {
    public static void main(String[] args) {
        int[] arr = {4, 7, 6, 5, 10, 2, 1};
        System.out.print("Elements in Min Heap: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        MinHeap minHeap = new MinHeap(arr);
        System.out.println("Peek(): Min element: " + minHeap.peek());
        System.out.println("Poll(): Removing Min element: " + minHeap.poll());
        System.out.println("Peek(): Min element: " + minHeap.peek());
        System.out.println("Offer(): Adding element: 1");
        minHeap.offer(1);
        System.out.println("Peek(): Min element: " + minHeap.peek());

        int[] arr2 = {4, 7, 6, 5, 10, 2, 1};
        System.out.print("Elements in Max Heap: ");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println();
        MaxHeap maxHeap = new MaxHeap(arr2);
        System.out.println("Peek(): Min element: " + maxHeap.peek());
        System.out.println("Poll(): Removing Min element: " + maxHeap.poll());
        System.out.println("Peek(): Min element: " + maxHeap.peek());
        System.out.println("Offer(): Adding element: 10");
        maxHeap.offer(10);
        System.out.println("Peek(): Min element: " + maxHeap.peek());

    }
}
