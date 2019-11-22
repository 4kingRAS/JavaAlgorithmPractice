package com.kkkk.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author Yulin.Wang
 * @date 2019/10/9
 * @description s
 */
//TODO:

class Foo {
    public void one() {
        System.out.println("1");
    }

    public void two() {
        System.out.println("2");
    }

    public void three() {
        System.out.println("3");
    }

}

class ThreadAP implements Runnable {
    private int a;
    private Foo foo;
    public ThreadAP(Foo foo, int a) {
        this.a = a;
        this.foo = foo;
    }

    @Override
    public void run() {
        switch (a) {
            case 1:
                foo.one();
                break;
            case 2:
                foo.two();
                break;
            case 3:
                foo.three();
                break;
        }
    }
}

public class AlterPrintEx {
    /**
     * using CountDownLatch
     **/
    /*
    private CountDownLatch sec = new CountDownLatch(1);
    private CountDownLatch trd = new CountDownLatch(1);

     */

    private Object lock = new Object();
    private boolean oneFinished = false;
    private boolean twoFinished = false;
    public AlterPrintEx() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            printFirst.run();
            oneFinished = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!oneFinished) {
                lock.wait();
            }
            printSecond.run();
            twoFinished = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!twoFinished) {
                lock.wait();
            }
            printThird.run();
        }
    }

    public static void main(String[] args) throws Exception{
        AlterPrintEx a = new AlterPrintEx();
        Foo foo = new Foo();

        int[] ar = {3, 2, 1};
        new Thread(new ThreadAP(foo, ar[0])).start();
        new Thread(new ThreadAP(foo, ar[1])).start();
        new Thread(new ThreadAP(foo, ar[2])).start();
    }

}
