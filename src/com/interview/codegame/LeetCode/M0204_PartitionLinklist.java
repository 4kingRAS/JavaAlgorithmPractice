package com.interview.codegame.LeetCode;

/**
 * @author Yulin.Wang
 * @date 2020/9/15
 * @description
 */

public class M0204_PartitionLinklist {

    public static ListNode partition(ListNode head, int x) {
        ListNode big = new ListNode(-1);
        ListNode bigCur = null;
        ListNode cur = head;
        ListNode last = head;
        boolean litFlag = true;
        boolean bigFlag = true;
        while (cur != null) {
            if (cur.val >= x) {
                if (litFlag) {
                    last = cur.next;
                    head = cur.next;
                } else {
                    last.next = cur.next;
                }
                if (bigFlag) {
                    bigCur = cur;
                    big.next = bigCur;
                    bigFlag = false;
                } else {
                    bigCur.next = cur;
                    bigCur = cur;
                }

            } else {
                litFlag = false;
                last = cur;
            }
            cur = cur.next;
        }

        if (!bigFlag) bigCur.next = null;
        if (last != null) {
            last.next = big.next;
            return head;
        } else {
            return big.next;
        }
    }

    public static void main(String[] args) {
        int[] a = {1};
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head = partition(head, 3);
        System.out.println(head.next.val);
    }

}
