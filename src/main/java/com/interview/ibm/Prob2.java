package com.interview.ibm;

import com.leetcode.example.utils.ListNode;

/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * A binary number is represented as a series of O's and 1's.
 * In this challenge, the series will be in the form of a singly-linked list.
 * Each node instance, a LinkedListNode, has a value,data, and a pointer to the next node, next.
 *
 * Given a reference to the head of a singly-linked list,convert the binary number represented to a decimal number.
 *
 * Example:
 * binary: 0->1->0->0->1->1->null
 * Linked list corresponding to the binary number (010011)[2] or decimal (19)[10].
 * Function DescriptionComplete the function getNumber in the editor below.
 * getNumber has the following parameter(s):
 * 	binary: reference to the head of a singly-linked list of binary digits
 * Returns:
 * 	int: a (long integer)[10] representation of the binary numberConstraints
 * 	1≤n≤64
 * 	All LinkedListNode.data = {01}
 * 	The described (integer)[2] < 2^64
 *
 * Sample Case 0
 *  Sample Input: LinkedListNode.data = [0, 0, 1, 1, 0, 1, 0] 011010
 *  Sample Output: 26
 *  Explanation
 *      binary: 0->0->1->1->0->1->0->null
 *      The linked list forms the binary number
 * 	        0011010(0011010)[2] = (26)[10]
 *
 * Sample Case 1
 *  Sample Input: LinkedListNode.data = [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]000011111
 *  Sample Output: 31
 *  Explanation
 *      binary:  0->0->0->0->0->1->1->1->1->1->null
 *      The linked list forms the binary number
 * 	        0000011111→ (0000011111)[2] = (31)[10]
 *
 * @author gasieugru
 */
public class Prob2 {

    public static void main(String[] args) {
        // 5 = 2^0 + 2^2 = 1 + 4
        System.out.println(getDecimalValue(ListNode.createListNode(new int[]{1, 0 , 1})));
        // 0
        System.out.println(getDecimalValue(ListNode.createListNode(new int[]{0})));
        // 31 = 2^0 + 2^1 + 2^2 + 2^3 + 2^4 = 1 + 2 + 4 + 8 + 16
        System.out.println(getDecimalValue(ListNode.createListNode(new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1})));
        // 26 = 2^1 + 2^3 + 2^4 = 2 + 8 + 16
        // = 2 (1 + 2^2 + 2^3) = 2*(1 + 2*(2*(1 + 2^1)))
        System.out.println(getDecimalValue(ListNode.createListNode(new int[]{0, 0, 1, 1, 0, 1, 0})));
    }

    public static int getDecimalValue(ListNode head) {
        int res = 0;

        while (head != null) {
            res = res * 2 + head.val;
            head = head.next;
        }

        return res;
    }

}
