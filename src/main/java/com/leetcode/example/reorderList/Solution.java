package com.leetcode.example.reorderList;

import com.leetcode.example.utils.ListNode;

/**
 * https://leetcode.com/problems/reorder-list/
 * 143. Reorder List
 * You are given the head of a singly linked-list. The list can be represented as:
 *      L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *      L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 *
 * Example 2:
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *
 * Constraints:
 * The number of nodes in the list is in the range [1, 5 * 104].
 * 1 <= Node.val <= 1000
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode list = ListNode.createListNode(new int[]{1,2,3,4,5});
        s.reorderList(list);
        System.out.println(list);

    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // {4, 5}
        ListNode second = slow.next;

        // Remove data from middle + 1 to last node
        // head -> {1, 2, 3}
        ListNode prevNode = slow.next = null;

        // Revert data from middle + 1 to last node
        // prevNode -> {5,4}
        while(second != null) {
            ListNode tmp = second.next;
            second.next = prevNode;
            prevNode = second;
            second = tmp;
        }

        ListNode first = head;
        second = prevNode;

        // Append data between {1, 2, 3} & {5,4}
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}
