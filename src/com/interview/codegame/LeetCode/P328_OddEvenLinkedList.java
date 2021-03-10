package com.interview.codegame.LeetCode;

import java.util.List;

/**
 * @author Yulin.Wang
 * @date 2020/9/29
 * @description
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 */

public class P328_OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        //ListNode last = head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode curO = new ListNode();
        ListNode curE = new ListNode();

        boolean isOdd = true;

        while (cur != null) {
            if (isOdd) {
                odd.next = cur;
            } else {
                even.next = cur;
            }
            isOdd = !isOdd;

            cur = cur.next;
        }


        return head;
    }

    public static void main(String[] args) {

    }

}
