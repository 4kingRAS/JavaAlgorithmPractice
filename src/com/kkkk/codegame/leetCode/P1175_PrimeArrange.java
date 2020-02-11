package com.kkkk.codegame.leetCode;

import com.kkkk.algo.math.MathUtils;

/**
 * @author Yulin.Wang
 * @date 2019-09-07
 * @description https://leetcode-cn.com/contest/weekly-contest-152/problems/prime-arrangements/
 */
//TODO:

public class P1175_PrimeArrange {

    public static void main(String[] args) {
        final int M = 1000000007;
        int n = 100;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (MathUtils.isPrime(i)) sum++;
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
