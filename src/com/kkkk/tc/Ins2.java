package com.kkkk.tc;

        import java.util.Arrays;
        import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019/9/16
 * @description s
 */
//TODO:

public class Ins2 {
    public static int bubbleSortEX(int[] a) {
        int lo = 0, hi = a.length;
        int last = hi;
        int c = 0;
        while (lo < last) {
            int l = lo, h = hi--;   // 每N轮迭代， 最高N位是有序的
            last = l;               // 最右侧的逆序
            while (++l < h) {
                if (a[l - 1] > a[l]) {
                    last = l;       //记录最后一次逆序，显然大于last的为有序
                    int t = a[l];
                    a[l] = a[l - 1];
                    a[l - 1] = t;
                }
            } // 如果有一轮检查通过，直接结束
            c++;
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int c = bubbleSortEX(a);

        System.out.println(c - 1);
    }
    // 1 4 2 5 3   zhao 1 2 3
    // 5 6 7 1 4 3 2 zhao 5 6 7 找最长自然数序列
//    int[] t = a.clone();
//        Arrays.sort(t);
//
//    int c = 0;
//        for (int i = 0; i < n; i++) {
//        if (a[i] == t[c]) {
//            c++;
//        }
//    }
}
