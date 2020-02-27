package com.interview.jdk.concurrent;

/**
 * @author Yulin.Wang
 * @date 2019/11/24
 * @description s
 */
//TODO:

public class AlterAddSub {
    static class Resourse {
        private int num = 0;
        private volatile boolean flag = true;

        public synchronized void add() throws Exception {
            if (!this.flag) {
                super.wait();  // Object.wait , 让给减法线程
            }
            Thread.sleep(100);
            this.num++;
            System.out.println(Thread.currentThread().getName() + " - 加一 - " + num);
            this.flag = false; //加减轮替
            super.notifyAll();
        }

        public synchronized void sub() throws Exception {
            if (this.flag) {
                super.wait();
            }
            Thread.sleep(200);
            this.num--;
            System.out.println(Thread.currentThread().getName() + " - 减一 - " + num);
            this.flag = true;
            super.notifyAll();
        }
    }

    static class Add implements Runnable {
        private Resourse resourse;

        public Add(Resourse resourse) {
            this.resourse = resourse;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    resourse.add();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Sub implements Runnable {
        private Resourse resourse;

        public Sub(Resourse resourse) {
            this.resourse = resourse;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    resourse.sub();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Resourse resourse = new Resourse();
        Add at = new Add(resourse);
        Sub st = new Sub(resourse);
        new Thread(at,"a1").start();
        new Thread(at,"a2").start();
        new Thread(st,"s1").start();
        new Thread(st,"s2").start();
    }

}
