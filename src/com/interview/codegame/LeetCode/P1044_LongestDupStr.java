package com.interview.codegame.LeetCode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yulin.Wang
 * @date 2021/6/1
 * @description
 *
 * 给出一个字符串S，考虑其所有重复子串（S 的连续子串，出现两次或多次，可能会有重叠）。
 * 返回任何具有最长可能长度的重复子串。（如果 S不含重复子串，那么答案为""。）
 *
 * 输入："banana"
 * 输出："ana"
 *
 * 解法： 从长度 n-1 to 1 ，得到子串s，查找是否有另一个
 *
 *      长度为 4 时，长度为指数将字符串转换为一个数：
 *      字符串哈希化： abcd -> 0123 -> 0 * 26^3 + 1 * 26^2 + 2 * 26^1 + 3 * 26^0
 *           滑动后： bcde -> 1234 -> ( abcd - 0 * 26^3 ) * 26 + 4 * 26^0
 *           当长度特别长时会溢出，故需要取余
 */

public class P1044_LongestDupStr {

    public static int search(int L, long mod, int len, int[] arr) {
        return 0;
    }

    public static String longestDupSubstring(String s) {
        int len = s.length();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = s.charAt(i) - 'a';
        }

        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long)Math.pow(2, 32);

        // binary search, L = repeating string length
        int left = 1, right = len;
        int L;
        while (left != right) {
            L = left + (right - left) / 2;                      //initial： len - 1
            if (search(L, modulus, len, arr) != -1) {
                left = L + 1;
            } else {
                right = L;
            }
        }

        int start = search(left - 1, modulus, len, arr);
        return start != -1 ? s.substring(start, start + left - 1) : "";
    }

}
