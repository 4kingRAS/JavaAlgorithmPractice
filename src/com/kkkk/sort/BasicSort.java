package com.kkkk.sort;

import com.kkkk.Utils;

/**
 * @Author Yulin.Wang
 * @Date 2019-02-25
 * @Description
 **/

public class BasicSort {

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void bubbleSort(int[] a) {
        Utils utils = new Utils();
        int n = a.length;
        /* 当sorted = true时停止循环， sorted = !sorted返回!sorted，且更改了sorted */
        for (boolean sorted = false; sorted = !sorted; n--) {
            for (int j = 1; j < n; j++) {
                if (a[j - 1] > a[j]) {
                    swap(a, j, j-1);
                    sorted = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 1, 3, 6, 7, 4, 9, 33, 21};
        BasicSort t = new BasicSort();
        t.bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }

    }

}
