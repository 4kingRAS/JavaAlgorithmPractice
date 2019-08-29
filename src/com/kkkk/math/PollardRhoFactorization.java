package com.kkkk.math;

import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019-08-22
 * @description s
 **/
//TODO:

public class PollardRhoFactorization {

    private static final int MAX_LENGTH = 256;
    public static long[] factor;
    public static int total = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        factor = new long[MAX_LENGTH];
        factorize(a);
        for (int i = 0; i < total; i++) {
            System.out.println(factor[i]);
        }
    }

    public static long[] Pollard_rho(long n) {
        factor = new long[MAX_LENGTH];
        factorize(n);
        long[] t = new long[total];
        for (int i = 0; i < total; i++) {
            t[i] = factor[i];
        }
        return t;
    }

    private static long factorize(long x) {

        if (x == 1) return 0;
        if (isPrime(x)) {
            factor[total++] = x;
            return x;
        }

        long a = 2;
        long b = 2;
        long p = 1;
        int size = 2;
        long c = (long)(Math.random()*x);
        while (p == 1) {
            for (int i = 0; i < size; i++) {
                if (p > 1) { break; }
                a = f(a, c, x);
                if (a == b) {
                    c = (long)(Math.random()*x);
                    continue;
                }
                p = Utils.gcd(Math.abs(a - b), x);
            }
            size *= 2;
            b = a;
        }
        return factorize(p) + factorize(x / p);
    }

    //pseudo random
    //usually (x^2 + 1) mod n   0 ->> n
    private static long f(long x, long c, long n) {
        return (x*x + c) % n;
    }

    private static boolean isPrime(long n) {
        return isPrime_test6(n);
    }


    /**
    * >=5的素数一定和6的倍数相邻
    **/
    private static boolean isPrime_test6(long n) {
        if (n == 2 || n == 3) { return true; }
        if (n % 6 != 1 && n % 6 != 5) { return false; }

        for (int i = 5; i <= Math.sqrt(n); i+=6) {
            if (n % i == 0 || n % (i+2) == 0)
                return false;
        }
        return true;
    }

}
