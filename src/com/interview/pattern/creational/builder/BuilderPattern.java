package com.interview.pattern.creational.builder;

/**
 * @author Yulin.Wang
 * @date 2020/2/16
 * @description
 */

public class BuilderPattern {

    // 参数检查 可抛出异常  illegalArgumentException
    public static void main(String[] args) {
        CocaCola c = new CocaCola.Builder(10, 12.2)
                .sugar(222)
                .sodium(222)
                .water(111)
                .caffeine(566.3)
                .build();
        System.out.println(c);
    }
}
