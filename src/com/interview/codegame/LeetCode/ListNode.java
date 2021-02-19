package com.interview.codegame.LeetCode;

/**
 * @author Yulin.Wang
 * @date 2020/9/15
 * @description
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode() { val = -1; }
    ListNode(int x) { val = x; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void printNodes(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
