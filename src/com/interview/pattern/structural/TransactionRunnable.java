package com.interview.pattern.structural;

/**
 * @author Yulin.Wang
 * @date 2020/2/14
 * @description
 */

public class TransactionRunnable implements Runnable {
    private final Runnable innerRunnable;

    public TransactionRunnable(Runnable innerRunnable) {
        this.innerRunnable = innerRunnable;
    }

    @Override
    public void run() {
        try {
            beginTransaction();
            innerRunnable.run();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commit();
        }
    }

    private void commit() {
        System.out.println("commit");
    }

    private void beginTransaction() {
        System.out.println("begin");
    }
}
