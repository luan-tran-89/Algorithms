package com.leetcode.example.utils;

/**
 * @author gasieugru
 */
public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", key, value);
    }
}
