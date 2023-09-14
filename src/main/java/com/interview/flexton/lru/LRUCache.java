package com.interview.flexton.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gasieugru
 */
public class LRUCache {
    private Map<Integer, Node> map = new HashMap<>();
    private int capacity;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            this.remove(node);
            this.insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            this.remove(map.get(key));
        }

        if (map.size() == capacity) {
            this.remove(tail.prev);
        }
        this.insert(new Node(key, value));
    }

    public void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;

        head.next = node;
        node.prev = head;
    }
}
