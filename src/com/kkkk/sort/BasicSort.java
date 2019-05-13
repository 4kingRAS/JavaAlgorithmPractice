package com.kkkk.sort;

import com.kkkk.Utils;

/**
 * @Author Yulin.Wang
 * @Date 2019-02-25
 * @Description
 **/

public class BasicSort {

    public void bubbleSort(int[] a) {
        Utils utils = new Utils();
        int n = a.length;
        /* 当sorted = true时停止循环， sorted = !sorted返回!sorted，且更改了sorted */
        for (boolean sorted = false; sorted = !sorted; n--) {
            for (int j = 1; j < n; j++) {
                if (a[j - 1] > a[j]) {
                    a[j] = utils.swap(a[j-1], a[j-1] = a[j]);
                    sorted = false;
                }
            }
        }
    }
}
