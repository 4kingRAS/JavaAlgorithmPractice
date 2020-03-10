package com.interview.jdk;

import java.lang.ref.Cleaner;

/**
 * @author Yulin.Wang
 * @date 2019/11/25
 * @description 代替了finalize (deprecated since 9)
 * @see Object
 * @see java.lang.ref.Cleaner
 */
//TODO:

public class CleanerDemo {
    private Integer id;

    public CleanerDemo(Integer id) {
        this.id = id;
        System.out.println("new demo " + id);
    }

    private static class CleanerRunnable implements Runnable {
        private Integer id;

        public CleanerRunnable(Integer id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("Cleaned " + id);
        }
    }

    public static void main(String[] args) throws Exception {
        Cleaner cleaner = Cleaner.create(); // Singleton design
        for (int i = 0; i < 10; i++) {

            CleanerDemo demo = new CleanerDemo(i);
            /**
             * @param obj   the object to monitor
             * @param action a {@code Runnable} to invoke when the object becomes phantom reachable
             */
            cleaner.register(demo, new CleanerRunnable(i));
        }

        // demo is not reachable reference, see what's happened.
        String s = "  sss";
        for (int i = 0; i < 20000; i++) {
            int[] a = new int[10000];
            Thread.sleep(1);
        }
    }
}
