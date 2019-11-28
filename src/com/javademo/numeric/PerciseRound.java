package com.javademo.numeric;

/**
 * @author Yulin.Wang
 * @date 2019/11/28
 * @description s
 */
//TODO:

public class PerciseRound {
    public static double round(double num, int scale) {
        return Math.round(num * Math.pow(10, scale)) / Math.pow(10, scale);
    }

    public static void main(String[] args) {
        System.out.println(Math.round(15.0));
        System.out.println(Math.round(-15.0));
        System.out.println(Math.round(-15.5));  // -15
        System.out.println(Math.round(-15.51)); // -16 缺点：丢失精度
        System.out.println(round(-15.53261, 3));
    }
}
