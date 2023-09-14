package com.leetcode.others.trie;

/**
 * @author gasieugru
 */
public class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public Node getRoot() {
        return root;
    }

    public Node getNode(int index) {
        return root.getNode(index);
    }

    public void insert(String word) {
        root.insert(word, 0);
    }

    public boolean search(String word) {
        return root.search(word, 0);
    }

    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }

    public static class Node {
        Node[] nodes;
        boolean isEnd;

        String word;

        Node() {
            nodes = new Node[26];
        }

        public Node getNode(int index) {
            return nodes[index];
        }

        public String getWord() {
            return word;
        }

        public void insert(String word, int index) {
            if (index >= word.length()) {
                return;
            }

            int i = word.charAt(index) - 'a';
            if (nodes[i] == null) {
                nodes[i] = new Node();
            }

            if (index == word.length() - 1) {
                nodes[i].isEnd = true;
                nodes[i].word = word;
            }
            nodes[i].insert(word, index + 1);
        }

        public boolean search(String word, int index) {
            if (index >= word.length()) {
                return false;
            }
            char c = word.charAt(index);
            if (c != '.') {
                Node node = nodes[c - 'a'];
                if (node == null) {
                    return false;
                }

                if (index == word.length() - 1 && node.isEnd) {
                    return true;
                }
                return node.search(word, index + 1);
            } else {
                boolean res = false;
                for (Node node : nodes) {
                    if (node != null) {
                        if (node != null && index == word.length() - 1 && node.isEnd) {
                            res = true;
                        }
                        res = res || node.search(word, index + 1);
                    }
                }
                return res;
            }
        }

        public boolean startsWith(String prefix, int index) {
            if (index >= prefix.length()) {
                return false;
            }

            Node node = nodes[prefix.charAt(index) - 'a'];
            if (node == null) {
                return false;
            }

            if (index == prefix.length() - 1) {
                return true;
            }
            return node.startsWith(prefix, index + 1);
        }
    }
}
