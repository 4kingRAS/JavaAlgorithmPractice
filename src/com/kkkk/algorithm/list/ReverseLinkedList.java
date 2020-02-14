package com.kkkk.algorithm.list;

import java.awt.*;

/**
 * @author Yulin.Wang
 * @date 2020/2/13
 * @description
 */

public class ReverseLinkedList {
    /**
     * @param head
     * @param <E>
     * @return
     */
    public static <E> Node<E> reverse(Node<E> head) {
        Node<E> currentHead = head;
        Node<E> newHead = null;
        /*
         1 - Loop invariant: 写下循环中变量要满足的条件：
         currentHead point to reversing list
         newHead point to reversed list
         2 - 保证循环开始前，满足条件
         3 - 写循环体，保证循环体【开始】和【结束】时，满足条件
        */
        while (currentHead != null) {
            Node<E> next = currentHead.getNext();
            currentHead.setNext(newHead);
            newHead = currentHead;
            currentHead = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        String a = "ABCDESFG";
        char[] s = a.toCharArray();
        Node<Character> head = new Node<>(s[0], null);
        Node<Character> cur = head;
        for (char c : s) {
            if (c != s[0]) {
                Node<Character> next = new Node<>(c, null);
                cur.setNext(next);
                cur = next;
            }
        }
        Node<Character> newHead = ReverseLinkedList.reverse(head);
        System.out.println();
    }
}
