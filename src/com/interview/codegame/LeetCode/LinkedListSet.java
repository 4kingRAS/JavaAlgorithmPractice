package com.interview.codegame.LeetCode;

/**
 * @author Yulin.Wang
 * @date 2020/2/27
 * @description         P25 ReverseKGroup
 *                      P206 ReverseLinkedList
 *                      P92  ReverseLinkedList II
 */

public class LinkedListSet {

    /**
     * @param head HEAD
     * @return P206
     */
    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode newHead = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = newHead;
            newHead = current;
            current = next;
        }
        return newHead;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.printf(head.next == null ? "%d" : "%d -> ", head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < 6; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = null;

        printList(head);
        System.out.println();
        head = reverseList(head);
        printList(head);
    }
}
