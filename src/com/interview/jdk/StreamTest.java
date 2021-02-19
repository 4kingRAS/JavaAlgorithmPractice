package com.interview.jdk;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Yulin.Wang
 * @date 2021/1/26
 * @description
 */

public class StreamTest {
    public static void main(String[] args) {
        System.out.println("10个随机数");
        IntStream.generate(() -> (int) (System.nanoTime() % 100)).limit(10)
                .forEach(x -> System.out.print(x + " "));
        System.out.println("");
        System.out.println("等差数列");
        Stream.iterate(0, n -> n + 3).limit(10).forEach(x -> System.out.print(x + " "));
    }
}
