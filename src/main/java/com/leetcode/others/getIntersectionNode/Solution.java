package com.leetcode.others.getIntersectionNode;

import com.leetcode.example.utils.ListNode;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode headA = ListNode.createListNode(new int[] {4,1,8,4,5});
        ListNode headB = ListNode.createListNode(new int[] {5,6,1,8,4,5});
        System.out.println(s.getIntersectionNode(headA, headB));

        try {
            int[] a = {};
            System.out.println(a[5]);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while(a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

}
