package com.interview.algorithm.list;

/**
 * @author Yulin.Wang
 * @date 2020/2/26
 * @description          A -> B -> C -> D -> E -> F -> G -> H
 *       REVERSE 3 ====> C -> B -> A -> F -> E -> D -> G -> H
 *                       k = 1 不变， k = n 时整个翻转
 *       solution: 1、尾插法
 *                 2、栈
 */

public class ReverseKNode {

    /**
     * 尾插法 tail前进k步，cur依次插入，如果tail遇null跳出， 0（2 n）
     * @param head 头
     * @param k k次
     * @param <E> 泛型
     * @return 新的头结点
     */
    public <E> Node<E> reverseK(Node<E> head, Integer k) {
        if (k == 1) {
            return head;
        }
        Node<E> newHead = new Node<E>(null, head);    //用于指向新头
        Node<E> prev = newHead;
        Node<E> tail = newHead;

        while (true) {
            int count = k;
            while (count > 0 && tail != null) {
                tail = tail.getNext();
                count--;
            }
            if (tail == null) { break; }
            Node<E> tempHead = prev.getNext();          //注意初始prev 即 newHead
            while (prev.getNext() != tail) {
                Node<E> cur = prev.getNext();           //指向要转移的
                prev.setNext(cur.getNext());            //先保存下一个，注意在最后一轮newHead指向了tail
                cur.setNext(tail.getNext());            //循环初始转移点指向tail的下一批节点
                tail.setNext(cur);                      //tail.next指向转移点
            }
            prev = tempHead;                            //第一批之后prev脱离newHead
            tail = tempHead;                            //tempHead.next指向了下一批
        }
        return newHead.getNext(); // 即翻转后头结点
    }

    public static void main(String[] args) {
        String a = "ABCDEFGH";
        char[] s = a.toCharArray();
        Node<Character> head = new Node<>('H', null);
        Node<Character> cur = head;
        for (char c : s) {
            cur.setNext(new Node<>(c, null));
            cur = cur.getNext();
        }
        head = head.getNext();

        head = new ReverseKNode().reverseK(head, 3);
        while (head != null) {
            System.out.printf("%c ", head.getValue());
            head = head.getNext();
        }
    }
}
