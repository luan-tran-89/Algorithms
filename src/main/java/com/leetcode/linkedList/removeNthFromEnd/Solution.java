package com.leetcode.linkedList.removeNthFromEnd;

import com.leetcode.example.utils.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * 19. Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = ListNode.createListNode(new int[]{1,2,3,4,5});
        System.out.println(s.removeNthFromEnd(head, 2));

        ListNode head1 = ListNode.createListNode(new int[]{1,2});
        System.out.println(s.removeNthFromEnd(head1, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode low = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            low = low.next;
        }

        low.next = low.next.next;
        return head;
    }
}
