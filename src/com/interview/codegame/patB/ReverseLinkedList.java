package com.interview.codegame.patB;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019-07-09
 * @description pat 乙级反转链表，java没有指针类型，实现存取很复杂，要用hashmap
 **/

//Tips:

/*
LinkedList<E>

        get(int index) is O(n)
        add(E element) is O(1)
        add(int index, E element) is O(n)
        remove(int index) is O(n)
        Iterator.remove() is O(1) <--- main benefit of MLinkedList<E>
        ListIterator.add(E element) is O(1) <--- main benefit of MLinkedList<E>

ArrayList<E>

        get(int index) is O(1) <--- main benefit of ArrayList<E>
        add(E element) is O(1) amortized, but O(n) worst-case since the array must be resized and copied
        add(int index, E element) is O(n - index) amortized, but O(n) worst-case (as above)
        remove(int index) is O(n - index) (i.e. removing last is O(1))
        Iterator.remove() is O(n - index)
        ListIterator.add(E element) is O(n - index)
*/

public class ReverseLinkedList {
    public static class Node<E> {
        E data;
        E next;
        E addr;

        Node(E data, E next, E addr) {
            this.data = data;
            this.next = next;
            this.addr = addr;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        String a[] = line.split(" ");
        String first = a[0];
        int sum = Integer.valueOf(a[1]);
        int k = Integer.valueOf(a[2]);

        // IO
        int c = sum;
        HashMap<String, Node<String>> map = new HashMap<String, Node<String>>();
        while (c != 0){
            line = sc.nextLine().trim();
            String t[] = line.split(" ");

            map.put(t[0], new Node<String>(t[1], t[2], t[0]));
            c--;
        }
        sc.close();

        // 遍历一次，边读取边反转
        String head = null;
        String cur = first;
        String last = first;
        boolean isFirst = true;
        while (sum >= k) {
            c = k;
            Node<String> p = map.get(cur);
            while (c > 0) {
                Node<String> n = map.get(cur);
                cur = n.next;
                if (c < k) {
                    if (c == 1) {
                        if (isFirst) {
                            head = n.addr;
                            isFirst = false;
                            map.get(first).next = cur;
                            first = cur;
                        } else {
                            map.get(last).next = n.addr;
                            last = first;
                            first = cur;
                            if ((sum - k) < k) { map.get(last).next = "-1"; }
                        }
                    }
                    n.next = p.addr;
                    p = n;
                }
                c--;
            }
            sum -= k;

        }

        while (!head.equals("-1")) {
            Node<String> p = map.get(head);
            System.out.println(p.addr + " " + p.data + " " + p.next);
            head = p.next;
        }
    }
}
