package com.kkkk.codegame.leetCode;

/**
 * @author Yulin.Wang
 * @date 2019-09-06
 * @description s
 **/

/**
 * 接雨水，找到最高点，从两边遍历，做差，求出蓄水量。
 * tips: 找到最高点，可以保证低点肯定能包起来。
 */

public class P42_WaterI {
    public static void main(String[] args) {
        int[] height = {0,1,0,3,1,0,1,4,2,1,2,4};

        int max = 0;
        int maxpos = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxpos = i;
            }
        }

        int sum = 0;
        int t = 0;
        int th = 0;
        for (int i = 1; i <= maxpos; i++) {
            int diff = height[i] - height[i - 1];
            th -= diff;
            if (th > 0) {
                sum += th;
            } else {
                th = 0;
            }
        }

        th = 0;
        for (int i = height.length - 2; i >= maxpos; i--) {
            int diff = height[i] - height[i + 1];
            th -= diff;
            if (th > 0) {
                sum += th;
            } else {
                th = 0;
            }
        }
        System.out.println(sum);
    }
}
