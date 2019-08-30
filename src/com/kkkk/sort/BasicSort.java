package com.kkkk.sort;

import com.kkkk.Utils;

import java.util.Arrays;

/**
 * @Author Yulin.Wang
 * @Date 2019-02-25
 * @Description
 **/

public class BasicSort {

    //  only ascend
    public enum method { BUBBLE, INSERTION, MERGE, SELECTION }

    private static final boolean DEBUG = true;

    public static void sort(int[] arr, method m) {
        switch (m) {
            case BUBBLE:
                bubbleSort(arr);
                break;
            case MERGE:
                mergeSortRc(arr);
                break;
            case INSERTION:
                insertionSort(arr);
                break;
            case SELECTION:
                selectionSort(arr);
                break;
            default:
                break;
        }
    }

    /**
     *  经过N次排序,后N个数肯定有序
     */
    public static void bubbleSort(int[] a) {
        int n = a.length;
        /* 当sorted = true时停止循环， sorted = !sorted返回!sorted，且更改了sorted */
        for (boolean sorted = false; sorted = !sorted; n--) {
            for (int j = 1; j < n; j++) {
                if (a[j - 1] > a[j]) {
                    Utils.swap(a, j, j-1);
                    sorted = false;
                }
            }
        }
    }

    /**
     * 将较小数交换到前面
     */
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    Utils.swap(a, i, j);
                }
            }
        }
    }

    /**
     * 将最小数插入位置i，最坏情况O(n^2)
     */
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i, t = a[i];
            while (j > 0 && a[j - 1] > t) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = t;
        }
    }

    /**
     * 分治
     */
    public static void mergeSortRc(int[] a) {
        int len = a.length;
        divide(a, 0, len);  // NOT len -1 !!
    }

    static void divide(int[] a, int l, int r) {
        if (r - l < 2) { return; }  // terminate

        int m = (l + r)>>1;
        divide(a, l, m);
        divide(a, m, r); // divide
        merge(a, l, m, r);

        if (DEBUG) { printArray(a); }
    }

    static void merge(int[] a, int l, int m, int r) {
        int[] b = Arrays.copyOfRange(a, l, m); // left arr
        int[] c = Arrays.copyOfRange(a, m, r); // right arr

        // j ctrl left, k ctrl right,  i is cur
        int lenb = m - l;
        int lenc = r - m;
        for (int i = l, j = 0, k = 0; (j < lenb) || (k < lenc); ) {
            // j,k没走到尽头,  a的起点移动到l
            if ((j < lenb) && ((lenc <= k) || (b[j] <= c[k]))) {
                //将left最小的赋给a[i]
                a[i++] = b[j++];
            }
            if ((k < lenc) && ((lenb <= j) || (c[k] < b[j]))) {
                a[i++] = c[k++];
            }

        }
    }

    static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 122, 3, 3, 7, 55, 55, 0, 9, 33, 21};
        int[] b = {3,4,2,1,5};
        mergeSortRc(b);

    }

}
