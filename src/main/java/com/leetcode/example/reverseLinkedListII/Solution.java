package com.leetcode.example.reverseLinkedListII;


import com.leetcode.example.utils.ListNode;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 * 92. Reverse Linked List II
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 *
 * Example 2:
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 * Constraints:
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.createListNode(new int[]{1,2,3,4,5});
        System.out.println(solution.reverseBetween(head, 2, 4));
    }

    private ListNode left;
    private boolean stop;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        this.left = head;
        this.stop = false;
        this.reverse(head, left, right);
        return head;
    }

    private void reverse(ListNode right, int m, int n) {
        if (n == 1) {
            return;
        }
        right = right.next;

        if (m > 1) {
            this.left = this.left.next;
        }

        this.reverse(right, m-1, n-1);

        if (this.left == right || right.next == this.left) {
            this.stop = true;
        }

        if (!this.stop) {
            int temp = this.left.val;
            this.left.val = right.val;
            right.val = temp;

            this.left = this.left.next;
        }
    }
}
