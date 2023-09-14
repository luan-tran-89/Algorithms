package com.leetcode.example.rotateList;

import com.leetcode.example.utils.ListNode;

/**
 * https://leetcode.com/problems/rotate-list/
 * 61. Rotate List
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 *
 * Example 2:
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list1 = ListNode.createListNode(new int[]{1,2});
        ListNode result = solution.rotateRight(list1, 1);
        System.out.println(result);
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = head;
        int length = 0;
        while(tail != null) {
            length++;
            tail = tail.next;
        }

        if (length > 2) {
            int n = k > length ? k%length : k;
            tail = head;
            for (int i = 0; i<n; i++) {
                while(tail != null && tail.next != null) {
                    if (tail.next.next == null) {
                        ListNode temp = tail.next;
                        tail.next = null;
                        temp.next = head;
                        head = temp;
                        tail = head;
                        break;
                    }
                    tail = tail.next;
                }
            }
        }
        return head;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        ListNode tail = head;
        int length = 0;
        while(tail != null) {
            length++;
            tail = tail.next;
        }

        for (int i = 0; i<k; i++) {
            while(tail.next != null) {
                if (tail.next.next == null) {
                    ListNode temp = tail.next;
                    tail.next = null;
                    temp.next = head;
                    head = temp;
                    tail = head;
                    break;
                }
                tail = tail.next;
            }
        }

        return head;
    }
}
