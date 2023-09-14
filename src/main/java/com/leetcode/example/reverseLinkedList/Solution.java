package com.leetcode.example.reverseLinkedList;

import com.leetcode.example.utils.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * 206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Example 3:
 * Input: head = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 *
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode list = ListNode.createListNode(new int[]{1,2,3,4,5});
        System.out.println(solution.reverseList(list).toString());
    }

    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode tmp1 = null;
        ListNode tmp2 = head;

        while (tmp2 != null) {
            tmp1 = result;
            result = tmp2;
            tmp2 = tmp2.next;
            result.next = tmp1;
        }

        return result;
    }

}
