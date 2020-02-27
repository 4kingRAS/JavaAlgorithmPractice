package com.interview.pattern.structural;

/**
 * @author Yulin.Wang
 * @date 2020/2/14
 * @description
 */

public class Task implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("+++++");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
