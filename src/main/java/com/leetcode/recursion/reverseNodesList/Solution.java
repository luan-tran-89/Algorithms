package com.leetcode.recursion.reverseNodesList;

import com.leetcode.recursion.ListNode;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        System.out.println(solution.reverseList(one));
    }


    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
