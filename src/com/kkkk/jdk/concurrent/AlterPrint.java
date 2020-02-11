package com.kkkk.jdk.concurrent;

/**
 * @author Yulin.Wang
 * @date 2019/9/17
 * @description s
 */
//TODO:

public class AlterPrint {
    public static class P implements Runnable {
        static volatile int i = 0;
        final Object self;
        final Object prev;
        String name;

        public P(Object s, Object p, String n) {
            self = s;
            prev = p;
            name = n;
        }

        @Override
        public void run() {
            while (i < 10) {
                synchronized (prev) {
                    synchronized (self) {
                        if (name.equals("A")) {
                            i++;
                        }
                        System.out.println(name + i);
                        self.notifyAll();
                    }
                    try {
                        if (i == 10) {
                            prev.notifyAll();
                        } else {
                            prev.wait(); // 立即释放 prev锁，当前线程休眠，等待唤醒
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Object aa = new Object();
        Object bb = new Object();
        P a = new P(bb, aa, "A");
        P b = new P(aa, bb, "B");
        new Thread(a).start();
        Thread.sleep(10);
        new Thread(b).start();
        Thread.sleep(10);

    }
}
