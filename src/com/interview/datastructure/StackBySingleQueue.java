package com.interview.datastructure;

import java.util.LinkedList;

/**
 * @author Yulin.Wang
 * @date 2021/5/27
 * @description
 */

public class StackBySingleQueue {
    //用一个队列实现，每次入队都反转。
    private final LinkedList<Integer> list;

    /** Initialize your data structure here. */
    public StackBySingleQueue() {
        list = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int size = list.size();
        list.addFirst(x);
        while (size > 0) {
            list.addFirst(list.removeLast());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return list.removeLast();
    }

    /** Get the top element. */
    public int top() {
        return list.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.isEmpty();
    }
}
