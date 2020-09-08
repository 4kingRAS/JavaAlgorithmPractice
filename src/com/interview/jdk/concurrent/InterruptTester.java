package com.interview.jdk.concurrent;

/**
 * @author Yulin.Wang
 * @date 2020/5/25
 * @description
 */

public class InterruptTester implements Runnable {
    private int count = 0;
    @Override
    public void run() {
        while (true) {
            count++;
            try {
                System.out.println(count);
                Thread.sleep(100);
                if (count > 10) {
                    synchronized (this) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) throws Exception {
        InterruptTester a = new InterruptTester();
        Thread t = new Thread(a);
        t.start();
        System.out.println("---");
        Thread.sleep(2000);
        a.count = 0;

        synchronized (a) { //没有synchronized会IllegalMonitorStateException
            a.notify();
        }
        System.out.println("--22-");
    }
}
