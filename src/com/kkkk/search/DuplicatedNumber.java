package com.kkkk.search;

/**
 * @author Yulin.Wang
 * @date 2020/1/13
 * @description 长度为n的数组里所有数字在0 - n-1 范围内，找出重复数字
 */

public class DuplicatedNumber {
    public static boolean hasDuplicatedNum(int[] a, int[] ans) {
        if (a == null || a.length < 1) {
            return false;
        }

        int c = 0;
        for (int i = 0; i < a.length; i++) {
            while (a[i] != i) {
                if (a[i] == a[a[i]]) {
                    ans[c] = a[i];
                    c++;
                    return true;
                }
                int tmp = a[i];
                a[i] = a[tmp];
                a[tmp] = tmp;
            }
        }

        return false;
    }

    public DuplicatedNumber() {
    }
}
