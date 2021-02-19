package com.interview.algorithm.math;

/**
 * @author Yulin.Wang
 * @date 2019-08-22
 * @description s
 **/
//TODO:

public class MathUtils {

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

    public static boolean isPrime(long n) {
        return isPrime_test6(n);
    }


    /**
     * >=5的素数一定和6的倍数相邻
     **/
    private static boolean isPrime_test6(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) { return true; }
        if (n % 6 != 1 && n % 6 != 5) { return false; }

        for (int i = 5; i <= Math.sqrt(n); i+=6) {
            if (n % i == 0 || n % (i+2) == 0)
                return false;
        }
        return true;
    }

    private static int randomInt(int scale) {
        return (int) (Math.random()*scale);
    }

    private static Double randomDouble(int scale) {
        return (Math.random()*scale);
    }

    public static int byteToInt(byte b) {
        return b & 0xFF;
    }

}
