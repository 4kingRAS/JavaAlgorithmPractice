package com.kkkk.adt;

import java.util.ArrayList;

/**
 * @author Yulin.Wang
 * @date 2019-03-11
 * @description s
 **/
//TODO:

public class Stack<E> {
    private static final int STACK_EMPTY= -1;
    int capacity;
    int topStack;
    ArrayList<E> s;

    public Stack(int size) {
        s = new ArrayList<>();
        capacity = size;
        topStack = STACK_EMPTY;
    }

    public boolean isEmpty() {
        return topStack == STACK_EMPTY;
    }

    public boolean isFull() {
        return topStack == capacity - 1;
    }

    public void push(E node) {
        if(topStack != capacity - 1) {
            topStack++;
            s.add(topStack, node);
        }
    }

    public E top() {
        return s.get(topStack);
    }

    public E pop() {
        if(topStack != -1) {
            E t = s.get(topStack);
            s.remove(topStack);
            topStack--;
            return t;
        }
        return null;
    }

}
