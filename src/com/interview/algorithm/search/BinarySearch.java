package com.interview.algorithm.search;

import com.interview.algorithm.sort.BasicSort;

/**
 * @author Yulin.Wang
 * @date 2019-08-29
 * @description s
 **/
//TODO:

public class BinarySearch {

    //序列有序
    public static int binarySearch(int[] a, int e) {
        int lo = 0, hi = a.length;
        while (hi - lo > 1) {// 区间宽度 == 1时终止
            int mi = (lo + hi) >>> 1; // 无符号右移，防止加法溢出
            if (e < a[mi]) {
                hi = mi;
            } else {
                lo = mi;
            }
        }
        return (e == a[lo]) ? lo : -1; // -1 cant find
    }

    // 返回不大于e的最后一个元素
    public static int binarySearchLE(int[] a, int e) {
        int lo = 0, hi = a.length;
        while (hi > lo) {// 区间宽度 == 0时终止
            int mi = (lo + hi) >>> 1;
            if (e < a[mi]) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return lo - 1; // mi = lo - 1 if e exist
    }

    public static void main(String[] args) {
        int[] a = new int[32];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * 100);
        }

        BasicSort.sort(a, BasicSort.method.BUBBLEX);

        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.println();
        System.out.println(binarySearchLE(a, a[3]));

        int[] aaa = {2, 3, 1, 2, 2, 3};
        int[] bb = new int[3];
        System.out.println(DuplicatedNumber.hasDuplicatedNum(aaa, bb));
        System.out.println(bb[0]);
    }

}
