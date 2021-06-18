package com.interview.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yulin.Wang
 * @date 2021/5/27
 * @description
 */

public class StackBy2Queue {
    private static Queue<Integer> tmp = new LinkedList<Integer>();
    private static Queue<Integer> origin = new LinkedList<Integer>();


    public StackBy2Queue() {
    }

    public Integer pop() {
        return origin.remove();
    }

    public Integer peek() {
        return origin.peek();
    }

    public void push(Integer n) {
        if (origin.isEmpty()) {
            origin.add(n);
        } else {
            while (!origin.isEmpty()) {
                tmp.add(origin.remove());
            }
            origin.add(n);
            while (!tmp.isEmpty()) {
                origin.add(tmp.remove());
            }
        }
    }


    public static void main(String[] args) {
        StackBy2Queue s = new StackBy2Queue();
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        s.push(6);
        s.push(4);
        s.push(7);
        s.push(8);
        s.pop();
        s.pop();
        System.out.println(s.peek());
    }

}
