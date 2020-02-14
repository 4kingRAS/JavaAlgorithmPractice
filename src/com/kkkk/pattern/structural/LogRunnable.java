package com.kkkk.pattern.structural;

/**
 * @author Yulin.Wang
 * @date 2020/2/14
 * @description
 */

public class LogRunnable implements Runnable {
    private final Runnable innerRunnable;

    public LogRunnable(Runnable innerRunnable) {
        this.innerRunnable = innerRunnable;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        System.out.println("START - " + startTime);
        innerRunnable.run();
        System.out.println("Finish - Elapsed time: " + (System.currentTimeMillis() - startTime));
    }
}
