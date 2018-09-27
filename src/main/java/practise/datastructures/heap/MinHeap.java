package practise.datastructures.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap {
    private List<Integer> nodes;

    public MinHeap() {
        nodes = new ArrayList<>();
    }

    public MinHeap(int[] arr) {
        nodes = new ArrayList<>();
        for (int val : arr) {
            nodes.add(val);
        }
        buildHeap();
    }

    public void buildHeap() {
        for (int i = parent(nodes.size() - 1); i >= 0; i--) {
            heapify(i);
        }
    }

    public void heapify(int i) {
        int leftIdx = leftIdx(i);
        int rightIdx = rightIdx(i);
        int smallest = i;

        if (leftIdx < nodes.size() && nodes.get(leftIdx) < nodes.get(smallest)) {
            smallest = leftIdx;
        }
        if (rightIdx < nodes.size() && nodes.get(rightIdx) < nodes.get(smallest)) {
            smallest = rightIdx;
        }
        if (smallest != i) {
            Collections.swap(nodes, smallest, i);
            heapify(smallest);
        }
    }

    public Integer peek() {
        if (nodes.size() <= 0) {
            return null;
        }
        return nodes.get(0);
    }

    public Integer poll() {
        if (nodes.size() <= 0) {
            return null;
        }
        int minElement = nodes.get(0);
        Collections.swap(nodes, 0, nodes.size() - 1);
        nodes.remove(nodes.size() - 1);
        heapify(0);
        return minElement;
    }

    public void offer(int data) {
        nodes.add(data);
        percolateUp(nodes.size() - 1);
    }

    public void percolateUp(int i) {
        int data = nodes.get(i);
        while (i > 0 && data < nodes.get(parent(i))) {
            nodes.set(i, nodes.get(parent(i)));
            i = parent(i);
        }
        nodes.set(i, data);
    }

    public int leftIdx(int i) {
        return (2 * i) + 1;
    }

    public int rightIdx(int i) {
        return (2 * i) + 2;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }
}
