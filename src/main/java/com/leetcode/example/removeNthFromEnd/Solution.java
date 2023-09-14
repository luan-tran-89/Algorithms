package com.leetcode.example.removeNthFromEnd;


import com.leetcode.example.utils.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = ListNode.createListNode(new int[]{1,2,3,4,5});
        System.out.println(Solution.removeNthFromEnd(head, 2));

        ListNode head1 = ListNode.createListNode(new int[]{1,2});
        System.out.println(Solution.removeNthFromEnd(head1, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
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

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        int depth = removeHelper(head,n);
        head = depth > n ? head : head.next;
        return head;
    }

    public static int removeHelper(ListNode head, int n){
        if(head.next == null){
            return 1;
        }
        int cur = 1 + removeHelper(head.next, n);
        if(cur == n + 1) {
            head.next = head.next == null ? null : head.next.next;
        }
        return cur;
    }
}
