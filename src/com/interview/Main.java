package com.interview;

// 62 209

import com.interview.algorithm.sort.QuickSort;
import com.interview.jdk.concurrent.FairLockTest;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.IntStream;

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
        HashMap<String, String> hashMap = new HashMap();

        List<StringBuilder> list =
                Collections.synchronizedList(new ArrayList<>(List.of(new StringBuilder(""))));

        StringBuilder sb = IntStream.of(1).mapToObj(n -> {
            int targetKeyHash;
            targetKeyHash = (targetKeyHash = list.get(0).hashCode()) ^ (targetKeyHash >>> 16);
            //得到 sb的hash，参考hashmap 的 hash()

            int targetTab = 63 & targetKeyHash;
            while (list.size() < 40) {
                StringBuilder nsb = new StringBuilder();
                int keyHash;
                keyHash = (keyHash = nsb.hashCode()) ^ (keyHash >>> 16);
                int tab = 63 & keyHash;

                if (tab == targetTab) {
                    list.add(nsb);
                }
                //不断制造与sb相同hash 的 StringBuilder对象，加入list
            }

            var es = Executors.newFixedThreadPool(8);
            AtomicInteger ai = new AtomicInteger(0);
            int c = list.stream().mapToInt(Object::hashCode).min().getAsInt();
            for (int i = 0; i < 8; i++) {
                es.execute(() -> {
                    while (ai.get() < 1) {
                        StringBuilder nsb = new StringBuilder("");
                        if (nsb.hashCode() == c) {
                            if (ai.get() < 1) {
                                list.add(nsb);
                                ai.getAndIncrement();
                            }
                            break;
                        }
                    }
                });
            }

            while (ai.get() < 1) {
                StringBuilder nsb = new StringBuilder("");
                if (nsb.hashCode() == c) {
                    list.add(nsb);
                    ai.getAndIncrement();
                    break;
                }
            }
            es.shutdownNow();
            return list.get(list.size() - 1);
        }).findFirst().orElseThrow();

        Set<StringBuilder> set = new HashSet<>(list);
        set.add(sb);
        System.out.println(set.contains(sb));
        sb.append("oops");
        System.out.println(set.contains(sb));

    }


}
