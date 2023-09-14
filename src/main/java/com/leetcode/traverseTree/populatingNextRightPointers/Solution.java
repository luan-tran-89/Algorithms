package com.leetcode.traverseTree.populatingNextRightPointers;

import com.leetcode.traverseTree.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 117. Populating Next Right Pointers in Each Node II
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 *
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following definition:
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 *
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A),
 * your function should populate each next pointer to point to its next right node, just like in Figure B.
 * The serialized output is in level order as connected by the next pointers,
 * with '#' signifying the end of each level.
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 212 - 1].
 * -1000 <= Node.val <= 1000
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        Node left = new Node(2, new Node(4), new Node(5));
        Node right = new Node(3, null, new Node(7));
        Node root = new Node(1, left, right);
        Node result = s.connect(root);
        System.out.println(result);
    }

    public Node connect(Node root) {
        Map<Integer, List<Node>> map = new HashMap<>();
        this.helper(root, 0, map);
        for (Map.Entry<Integer, List<Node>> entry : map.entrySet()) {
            List<Node> nodes = entry.getValue();
            for (int i = 1; i < nodes.size(); i++) {
                nodes.get(i - 1).next = nodes.get(i);
            }
        }
        return root;
    }

    private void helper(Node node, int level, Map<Integer, List<Node>> map) {
        if (node == null) {
            return;
        }

        List<Node> list = map.computeIfAbsent(level, (k) -> new ArrayList<>());
        list.add(node);
        level++;
        this.helper(node.left, level, map);
        this.helper(node.right, level, map);
    }
}
