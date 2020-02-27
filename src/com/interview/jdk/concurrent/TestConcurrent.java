package com.interview.jdk.concurrent;

/**
 * @author Yulin.Wang
 * @date 2019/11/5
 * @description s
 */
//TODO:

class MyThread implements Runnable {
    private int ticket = 10;

    public synchronized boolean sale() {
        if (this.ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "ticket = " + this.ticket--);
            return true;
        } else {
            System.out.println("No more");
            return false;
        }
    }

    @Override
    public void run() {
        while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!sale()) break;
        }
    }
}

public class TestConcurrent {
    public static void main(String[] args) throws Exception {
        MyThread mt = new MyThread();
        new Thread(mt, "a").start();
        new Thread(mt, "b").start();
        new Thread(mt, "c").start();
    }
}
