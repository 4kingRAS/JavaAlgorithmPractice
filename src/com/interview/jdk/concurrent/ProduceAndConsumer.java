package com.interview.jdk.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Yulin.Wang
 * @date 2020/9/14
 * @description
 */

public class ProduceAndConsumer {

    public static String lock = "asdsa";

    public static void doSomething(long n) {
        while (n > 0) {
            double d = Math.random()*2;
            n--;
        }
    }

    public static void main(String[] args) {
        List<Integer> sharedQueue = new ArrayList<>();
        Thread t1 = new Thread(new Producer(sharedQueue), "Producer1");
        Thread t8 = new Thread(new Producer(sharedQueue), "Producer2");
        Thread t2 = new Thread(new Consumer(sharedQueue), "Consumer1");
        Thread t3 = new Thread(new Consumer(sharedQueue), "Consumer2");
        Thread t4 = new Thread(new Consumer(sharedQueue), "Consumer3");

        t1.start();
        t8.start();

        t3.start();
        t2.start();
        t4.start();
    }
    static class Producer implements Runnable{
        private final List<Integer> taskQueue;
        private final int MAX_SIZE = 10;

        Producer(List<Integer> sharedQueue) {
            this.taskQueue = sharedQueue;
        }

        @Override
        public void run() {
            while (true) {
                int count = 0;
                try {
                    produce(count++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void produce(int i) throws InterruptedException {
            ProduceAndConsumer.doSomething(722312);
            synchronized (taskQueue) {
                while (taskQueue.size() == MAX_SIZE) {
                    System.out.println("QUEUE IS FULL.  - " + Thread.currentThread().getName());
                    taskQueue.wait();
                }
                taskQueue.add(i);
                System.out.println(Thread.currentThread().getName() + ", remain " + taskQueue.size());
                taskQueue.notifyAll(); // synchronize块结束才会真正wake
            }
        }
    }

    static class Consumer implements Runnable{
        private final List<Integer> taskQueue;

        Consumer(List<Integer> sharedQueue) {
            this.taskQueue = sharedQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void consume() throws InterruptedException {
            ProduceAndConsumer.doSomething(1231222);
            synchronized (taskQueue) {
                while (taskQueue.isEmpty()) {
                    System.out.println("QUEUE IS Empty.  - " + Thread.currentThread().getName());
                    taskQueue.wait();
                }
                taskQueue.remove(0);
                System.out.println(Thread.currentThread().getName() + ", remain " + taskQueue.size());
                taskQueue.notify();
            }
        }

    }
}

