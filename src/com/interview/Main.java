package com.interview;

// 62 209

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
        //int[] a = {1, 2, 3, 4, 5};
        int[] a = {1,2};
        ListNode h = new ListNode(a[0]);
        ListNode cur = h;
        for (int i = 1; i < a.length; i++) {
            cur.next = new ListNode(a[i]);
            cur = cur.next;
        }

        cur = h;
        print(cur);
        cur = reverseList(h);
        System.out.println();
        print(cur);
    }

}
