package com.kkkk.OI.LeetCode;

/**
 * @author Yulin.Wang
 * @date 2019-09-07
 * @description https://leetcode-cn.com/contest/weekly-contest-152/problems/prime-arrangements/
 */
//TODO:

public class P1175_PrimeArrange {
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

    public static void main(String[] args) {
        final int M = 1000000007;
        int n = 100;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime_test6(i)) sum++;
        }
        long s = 1;
        for (int i = 1; i <= sum; i++) {
            s = s * i % M;
        }
        long r = 1;
        for (int i = 1; i <= n - sum; i++) {
            r = r * i % M;
        }
        long res = r * s % M;
        System.out.println(res);

    }
}
