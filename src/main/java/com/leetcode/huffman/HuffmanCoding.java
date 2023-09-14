package com.leetcode.huffman;

import java.util.*;

/**
 * @author gasieugru
 */
public class HuffmanCoding {
    private static Map<Character, String> codes = new HashMap<>();
    private static Map<Character, Integer> freq = new HashMap<>();
    private static PriorityQueue<HuffmanNode> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println("Input: " + str);
        String encoding = encode(str);
        System.out.println("Encoding: " + encoding);

        String decoding = decode(queue.peek(), encoding);
        System.out.println("Decoding: " + decoding);

        System.out.println(codes);
        System.out.println(freq);

    }

    public static String encode(String str) {
        codes = new HashMap<>();
        freq = new HashMap<>();
        queue = new PriorityQueue<>();

        calcFreq(str);

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            HuffmanNode node = new HuffmanNode(entry.getKey(), entry.getValue());
//            node.data = entry.getKey();
//            node.freq = entry.getValue();
            queue.add(node);
        }

        while (queue.size() > 1 ) {
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();
            HuffmanNode f = new HuffmanNode('-', left.freq + right.freq, left, right);
            queue.add(f);
        }

        storeCodes(queue.peek(), "");

        StringBuilder encodedString = new StringBuilder();

        for (char c : str.toCharArray()) {
            encodedString.append(codes.get(c));
        }

        return encodedString.toString();
    }

    public static String decode(HuffmanNode root, String encodedString) {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            HuffmanNode curr = root;

            for (char c : encodedString.toCharArray()) {
                curr = c == '0' ? curr.left : curr.right;

                if (curr.left == null && curr.right == null) {
                    sb.append(curr.data);
                    curr = root;
                }
            }
        }

        return sb.toString();
    }
    private static void calcFreq(String str) {
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
    }

    public static void storeCodes(HuffmanNode root, String s) {
        if (root == null) {
            return;
        }

        if (root.data != '-') {
            codes.put(root.data, s);
        }

//        if (root.left == null && root.right == null && Character.isLetter(root.data)) {
//            System.out.println(root.data + "   |  " + s);
//            codes.put(root.data, s);
//            return;
//        }
        storeCodes(root.left, s + "0");
        storeCodes(root.right, s + "1");
    }

    static class ImplementComparator implements Comparator<HuffmanNode> {

        @Override
        public int compare(HuffmanNode o1, HuffmanNode o2) {
            return o1.freq - o2.freq;
        }
    }

}
