package com.interview;

// 62 209

import com.interview.algorithm.sort.QuickSort;
import com.interview.jdk.concurrent.FairLockTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;

        ListNode cur = head.next;
        ListNode last = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = last;
            last = cur;
            cur = tmp;
        }
        head.next = null;
        return last;
    }

    public static void print(ListNode cur) {
        while (cur != null) {
            System.out.print(cur.val + " - ");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] { 111, 3, 9, 22, 3, 7, 12 };

        QuickSort.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

        ArrayList<String> s = new ArrayList<>();
        LinkedList<String> w = new LinkedList<>();
    }


}
