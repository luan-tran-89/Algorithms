package com.interview.flexton.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gasieugru
 */
public class LRUCache1 {
    Map<Integer, Node> map = new HashMap<>();
    int capacity = 0;

    Node head = new Node(0, 0);

    Node tail = new Node(0, 0);

    LRUCache1(int capacity) {
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

    private void remove(Node node) {
        map.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);

        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }

    static class Node {
        Node prev;
        Node next;
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

}
