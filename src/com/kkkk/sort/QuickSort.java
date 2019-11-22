package com.kkkk.sort;

import com.kkkk.Utils;

/**
 * @author Yulin.Wang
 * @date 2019/9/11
 * @description s
 */
//TODO:

public class QuickSort {
    static void quickSort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(a, lo, hi);   // 将小于pivot的移至左边，大于的移右边
            quickSort(a, lo, pivot);            // 对左右继续排序
            quickSort(a, pivot + 1, hi);
        }
    }

    static int partition(int[] a, int lo, int hi) {
        int pivot = (lo + hi) >> 1;
        for (int i = lo; i <= hi; i++) {
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 122, 3, 3, 7, 55, 55, 0, 9, 33, 21};
        int[] b = {3, 4, 2, 1, 5};
        quickSort(a, 0, a.length - 1);
        Utils.printArray(a);
    }

}
