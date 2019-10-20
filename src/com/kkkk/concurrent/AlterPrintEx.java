package com.kkkk.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author Yulin.Wang
 * @date 2019/10/9
 * @description s
 */
//TODO:

public class AlterPrintEx {
    // using CountDownLatch

    private CountDownLatch sec = new CountDownLatch(1);
    private CountDownLatch trd = new CountDownLatch(1);

    public AlterPrintEx() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        printThird.run();
    }

    public static void main(String[] args) {
        AlterPrintEx a = new AlterPrintEx();
    }

}
