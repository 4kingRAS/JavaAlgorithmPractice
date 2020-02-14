package com.kkkk.pattern.structural;

/**
 * @author Yulin.Wang
 * @date 2020/2/14
 * @description
 */

public class DecoratorPattern {
    public static void main(String[] args) {
        new LogRunnable(
                new TransactionRunnable(
                        new Task()
                )
        ).run();
    }
}
