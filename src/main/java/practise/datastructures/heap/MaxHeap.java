package practise.datastructures.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap {
    private List<Integer> nodes;

    public MaxHeap() {
        nodes = new ArrayList<>();
    }

    public MaxHeap(int[] arr) {
        nodes = new ArrayList<>();
        for (int i : arr) {
            nodes.add(i);
        }
        buildHeap();
    }

    public void buildHeap() {
        for (int i = parent(nodes.size() - 1); i >= 0; i--) {
            heapify(i);
        }
    }

    public void heapify(int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;
        if (left < nodes.size() && nodes.get(left) > nodes.get(largest)) {
            largest = left;
        }
        if (right < nodes.size() && nodes.get(right) > nodes.get(largest)) {
            largest = right;
        }
        if (largest != i) {
            Collections.swap(nodes, largest, i);
            heapify(largest);
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
        int maxElement = nodes.get(0);
        Collections.swap(nodes, 0, nodes.size() - 1);
        nodes.remove(nodes.size() - 1);
        heapify(0);
        return maxElement;
    }

    public void offer(int val) {
        nodes.add(val);
        percolateUp(nodes.size() - 1);
    }

    public void percolateUp(int i) {
        int data = nodes.get(i);
        while (i > 0 && data > nodes.get(parent(i))) {
            nodes.set(i, nodes.get(parent(i)));
            i = parent(i);
        }
        nodes.set(i, data);
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int left(int i) {
        return (2 * i) + 1;
    }

    public int right(int i) {
        return (2 * i) + 2;
    }

}
