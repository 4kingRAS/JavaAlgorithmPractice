package com.interview.datastructure;

import java.util.Stack;

/**
 * @author Yulin.Wang
 * @date 2020/04/27
 * @description 两个栈模拟一个队列
 */

public class QueueByStack<E> {
    private final Stack<E> from;
    private final Stack<E> to;

    public QueueByStack() {
        from = new Stack<>();
        to = new Stack<>();
    }

    public void appendHead(E node) {
        from.push(node);
    }

    public E removeTail() {
        if (to.isEmpty()) {
            if (from.isEmpty()) {
                return null;
            } else {
                while (!from.isEmpty()){
                    to.push(from.pop());
                }
                return to.pop();
            }
        } else {
            return to.pop();
        }
    }

    public int size() {
        return 0;
    }

    public static void main(String[] args) {
        QueueByStack<Integer> queue = new QueueByStack<>();
        queue.appendHead(5);
        queue.appendHead(4);
        queue.appendHead(1);

        System.out.println(queue.removeTail());
        System.out.println(queue.removeTail());
        queue.appendHead(32);
        System.out.println(queue.removeTail());
        System.out.println(queue.removeTail());
        queue.appendHead(3);
        System.out.println(queue.removeTail());
        System.out.println(queue.removeTail());
    }
}
