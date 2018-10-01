package practise.datastructures.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node tail = null;

    LRUCache(int capacity) {
        this.capacity = capacity;
    }

    int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }

    void remove(Node n) {
        //if node is head
        if (n.prev == null) {
            head = n.next;
        } else {
            n.prev.next = n.next;
        }

        //if node is tail
        if (n.next == null) {
            tail = n.prev;
        } else {
            n.next.prev = n.prev;
        }
    }

    void setHead(Node n) {
        n.next = head;
        n.prev = null;
        if (head != null) {
            head.prev = n;
        }
        head = n;
        if (tail == null) {
            tail = head;
        }
    }

    void set(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
                setHead(created);
            } else {
                setHead(created);
            }
            map.put(key, created);
        }
    }

}

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
