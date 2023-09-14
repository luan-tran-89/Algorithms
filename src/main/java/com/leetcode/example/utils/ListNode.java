package com.leetcode.example.utils;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createListNode(int[] values) {
        ListNode head = new ListNode();
        ListNode tail = new ListNode();
        head.next = tail;
        for (int i = 0; i < values.length; i++) {
            tail.val = values[i];
            if (i != values.length - 1) {
                tail.next = new ListNode();
                tail = tail.next;
            }
        }
        return head.next;
    }

    public static ListNode createListNodeWithLoop(int[] values, int pos) {
        ListNode head = new ListNode();
        ListNode tail = new ListNode();
        ListNode temp = null;

        head.next = tail;
        for (int i = 0; i < values.length; i++) {
            tail.val = values[i];
            if (i != values.length - 1) {
                tail.next = new ListNode();
                if (pos > 0 && pos == i) {
                    temp = tail;
                }
                tail = tail.next;
            }
        }

        tail.next = temp;
        return head.next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
