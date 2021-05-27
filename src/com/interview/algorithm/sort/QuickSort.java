package com.interview.algorithm.sort;

import com.interview.Utils;

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
            quickSort(a, lo, pivot - 1);     // 对左右继续排序
            quickSort(a, pivot + 1, hi);
        }
    }

    static int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo;
        for (int j = lo; j <= hi; j++) {
            if (a[j] < pivot) {
                Utils.swap(a, j, i);
                i++;
            }
        }
        Utils.swap(a, i, hi);
        return i;
    }

    /**
     * @param a 被排序数组
     * quicksort另一个写法
     */
    public static void sort(int[] a, int left, int right) {
        if (left > right) return;
        int lo, hi, pivot;

        pivot = a[left];    //取最左为pivot
        lo = left;
        hi = right;
        while (lo != hi) {
            while (lo < hi && a[hi] >= pivot) {
                hi--;
            }

            while (lo < hi && a[lo] <= pivot) {
                lo++;
            }

            if (lo < hi) {
                int t = a[lo];
                a[lo] = a[hi];
                a[hi] = t;
            }
        }
        a[left] = a[lo];
        a[lo] = pivot;

        sort(a, left, lo - 1);
        sort(a, lo + 1, right);
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 122, 3, 3, 7, 55, 55, 0, 9, 33, 21};
        int[] b = {3, 4, 2, 1, 5};
        quickSort(a, 0, a.length - 1);
        Utils.printArray(a);
    }

}
