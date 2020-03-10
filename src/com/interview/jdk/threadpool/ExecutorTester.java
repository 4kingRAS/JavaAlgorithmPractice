package com.interview.jdk.threadpool;

import com.interview.pattern.structural.Task;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yulin.Wang
 * @date 2020/3/10
 * @description
 */

public class ExecutorTester {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 9; i++) {
            executorService.submit(new Task());
        }
        System.out.println("done");
    }
}
