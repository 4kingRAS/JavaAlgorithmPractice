package com.interview.jdk.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author Yulin.Wang
 * @date 2020/9/16
 * @description LeetCode 1115
 *  通用交替打印类方法
 *              https://leetcode-cn.com/problems/print-foobar-alternately/
 */

public class FooBar {

    private int n;
    private Semaphore foos = new Semaphore(1);
    private Semaphore bars = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foos.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            System.out.print("foo");
            bars.release();
        }
    }

    public void bar() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bars.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            System.out.print("bar");
            foos.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
