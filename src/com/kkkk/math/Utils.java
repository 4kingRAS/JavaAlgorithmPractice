package com.kkkk.math;

/**
 * @author Yulin.Wang
 * @date 2019-08-22
 * @description s
 **/
//TODO:

public class Utils {

    public static long gcd(long a, long b) {
        if (a == 0) return 1;
        if (a < 0) return gcd(-a, b);

        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

}
