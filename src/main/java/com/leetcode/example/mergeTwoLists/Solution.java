package com.leetcode.example.mergeTwoLists;

import com.leetcode.example.utils.ListNode;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list1 = createListNode(new int[]{1});
        ListNode list2 = createListNode(new int[]{});
        ListNode result = solution.mergeTwoLists(list1, list2);
        System.out.println(result);
    }

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head = new ListNode();
        ListNode tail = head;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                tail.next = list2;
                list2 = list2.next;
            } else {
                tail.next = list1;
                list1 = list1.next;
            }
            tail = tail.next;
        }

        tail.next = list1 == null ? list2 : list1;

        return head.next;
    }
}
