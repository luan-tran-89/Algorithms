package com.interview.flexton.lru;

/**
 * @author gasieugru
 */
public class Node {
    Node prev;

    Node next;

    int key;

    int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

}
