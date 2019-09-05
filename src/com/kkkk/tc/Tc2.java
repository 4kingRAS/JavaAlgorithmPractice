package com.kkkk.tc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019-09-01
 * @description s
 **/
//TODO:

public class Tc2 {

    public static int insertionSort(int[][] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            int j = i;
            int[] t = a[i];
            int tp = a[i][0]*(i - 1) + a[i][1]*(len - i);
            while (j > 0) {
                int fa = a[j][0];
                int fb = a[j][1];
                a[j] = a[j - 1];
                j--;
            }
            a[j] = t;
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += a[i][0] * (i - 1);
            sum += a[i][1] * (len - i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] s = new int[n][2];
        for (int i = 0; i < n; i++) {
            s[i][0] = sc.nextInt();
            s[i][1] = sc.nextInt();
        }
        sc.close();

        System.out.println(insertionSort(s));
    }
}
