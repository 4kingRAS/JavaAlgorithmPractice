package com.kkkk.concurrent;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Yulin.Wang
 * @date 2019/11/6
 * @description 管程法 monitor 解决生产者消费者
 */

class Product {
    private int count = 0;
    public int inc() {
        return ++count;
    }
    public int dec() {
        return --count;
    }
}

public class TestProducerAndConsumer {
    static class Producer implements Runnable{
        private Product p;

        public Producer(Product p) {
            this.p = p;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("生产了一个，当前有" + produce());
                monitor.insert();
            }
        }

        public int produce() {
            return p.inc();
        }

    }

    static class Consumer implements Runnable {
        private Product p;

        public Consumer(Product p) {
            this.p = p;
        }

        @Override
        public void run() {
            while (true) {
                int a = 0;
                monitor.remove();
                for (int i = 0; i < 20000000; i++) {
                    a*=a;
                }
                System.out.println("消费了一个，当前有" + consume());
            }
        }

        public int consume() {
            return p.dec();
        }
    }

    static class Monitor {
        private final int N = 10;
        public Product product = new Product();
        private int count = 0; // 计数

        public synchronized void insert() {
            if (count == N) goSleep();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            if (count == 1) notify(); // 有一个了，唤醒消费者
        }

        public synchronized void remove() {
            if (count == 0) goSleep();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            if (count == N - 1) notify(); // 唤醒生产者
        }

        private void goSleep() {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
    }
    public static Monitor monitor = new Monitor();

    public static void main(String[] args) {
        Product product = new Product();
        new Thread(new Producer(product)).start();
        new Thread(new Consumer(product)).start();

    }
}
