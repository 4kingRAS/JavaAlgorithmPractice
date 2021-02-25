package com.interview.algorithm.math;

import com.interview.Utils;

import java.util.Arrays;

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

    public static Double randomDouble(int scale) {
        return (Math.random()*scale);
    }

    public static int byteToInt(byte b) {
        return b & 0xFF;
    }

    // 得到一个在闭区间 [min, max] 内的随机整数
    public static int randInt(int min, int max) {
        return  (int) ((max - min) * Math.random());
    }

    /**
     * **分析洗牌算法正确性的准则：产生的结果必须有 n! 种可能，否则就是错误的。**
     * 因为一个长度为 n 的数组的全排列就有 n! 种
     */
    public static void shuffleArray(int[] arr) {
        int n = arr.length;
        for (int i = 0 ; i < n; i++) {
            // 从 i 到最后随机选一个元素
            int rand = randInt(i, n - 1);
            Utils.swap(arr, i, rand);
        }
    }

}
