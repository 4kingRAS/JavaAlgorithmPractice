package com.effective.api;

/**
 * @author Yulin.Wang
 * @date 2019/11/25
 * @description Runtime 类，一些重要方法
 * @see Runtime
 */

public class RuntimeDemo {

    public static void printRuntimeInfo(Runtime run) {
        //MAX MEMORY = 1/4  SYSTEM MEMORY
        System.out.println("JVM MAX MEM: " + run.maxMemory() +
                "Bytes = " + run.maxMemory() / (1024*1024*1024) + "GB");
        System.out.println("Program total MEM: " + run.totalMemory() +
                "Bytes = " + run.totalMemory() / (1024*1024) + "MB");
        System.out.println("Program free MEM: " + run.freeMemory() +
                "Bytes = " + run.freeMemory() / (1024*1024) + "MB");

    }

    public static void main(String[] args) throws Exception {
        Runtime run = Runtime.getRuntime();
        System.out.println("CPUs: " + run.availableProcessors());

        printRuntimeInfo(run);

        String s = " 2";
        for (int i = 0; i < 10000; i++) {
            s += "2312";   // 循环中应该用append
        }

        printRuntimeInfo(run);

        run.gc();
        Thread.sleep(2000);

        printRuntimeInfo(run);

    }
}
