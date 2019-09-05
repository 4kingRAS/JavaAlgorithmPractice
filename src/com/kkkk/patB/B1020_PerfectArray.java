package com.kkkk.patB;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019-08-30
 * @description s
 **/
//TODO:

public class B1020_PerfectArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        int i = 0, j = 0, count = 1;
        while(i < n && j < n){
            while(j < n && a[j] <= a[i]*p){
                count = Math.max(count, j - i +1);
                j++;
            }
            i++;
        }
        System.out.println(count);

    }

}
