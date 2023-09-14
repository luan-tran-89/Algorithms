package com.leetcode.huffman;

/**
 * @author gasieugru
 */
public class HuffmanNode implements Comparable<HuffmanNode> {
    int freq;
    char data;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode() {
    }

    public HuffmanNode(char data, int freq) {
        this.data = data;
        this.freq = freq;
    }

    public HuffmanNode(char data, int freq, HuffmanNode left, HuffmanNode right) {
        this.data = data;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "freq=" + freq +
                ", data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.freq - o.freq;
    }
}
