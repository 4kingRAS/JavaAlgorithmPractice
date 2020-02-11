package com.kkkk.codegame.patA;

import com.kkkk.algo.math.PollardRhoFactorization;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019-08-27
 * @description s
 **/
//TODO:

public class A1059_PrimeFactor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long[] a = PollardRhoFactorization.Pollard_rho(n);

        if (n == 1) {
            System.out.print("1=1");
            return;
        }

        Arrays.sort(a);
        int c = 1;
        long t = a[0];
        System.out.printf("%d=%d", n, t);
        for (int i = 1; i < a.length; i++) {
            if (a[i] != t) {
                if (c > 1) {
                    System.out.printf("^%d*", c);
                    c = 1;
                } else {
                    System.out.print("*");
                }
                System.out.printf("%d", a[i]);
                t = a[i];
            } else {
                c++;
            }
            if (i == a.length - 1 && c > 1) {
                System.out.printf("^%d", c);
                return;
            }
        }

    }
}
