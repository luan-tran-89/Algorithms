package com.leetcode.linkedList.palindrome;

import com.leetcode.example.utils.ListNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * 234. Palindrome Linked List
 *
 * Given the head of a singly linked list, return true if it is a
 * palindrome or false otherwise.
 *
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 *
 * Constraints:
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 * Follow up: Could you do it in O(n) time and O(1) space?
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = ListNode.createListNode(new int[]{1, 2, 2, 1});
        System.out.println(s.isPalindrome(head));
        head = ListNode.createListNode(new int[]{1, 2});
        System.out.println(s.isPalindrome(head));

        head = ListNode.createListNode(new int[]{1, 1, 2, 1});
        System.out.println(s.isPalindrome(head));
    }

    // Time complexity: O(n) - Space complexity: O(n)
    public boolean isPalindrome3(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode current = head;

        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        current = head;
        while (current != null) {
            if (current.val != stack.pop()) {
                return false;
            }
            current = current.next;
        }

        return true;
    }

    // Time complexity: O(n) - Space complexity: O(1)
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseSlow = this.reverseList(slow);
        fast = head;
        while (reverseSlow != null) {
            if (fast.val != reverseSlow.val) {
                return false;
            }
            fast = fast.next;
            reverseSlow = reverseSlow.next;
        }

        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        ListNode current = head;
        ListNode reverseList = this.reverseList(current);
        ListNode current1 = reverseList;

        while (current != null) {
            if (current1.val != current.val) {
                return false;
            }

            current = current.next;
            current1 = current1.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
