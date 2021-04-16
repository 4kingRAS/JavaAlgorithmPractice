package com.interview.codegame.LeetCode;

/**
 * @author Yulin.Wang
 * @date 2021/3/4
 * @description
 * 输入：nums = [7,2,5,10,8], m = 2
 * 输出：18
 *                  【数组保持顺序连续】
 * 一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * https://leetcode-cn.com/problems/split-array-largest-sum/
 *
 * 两种方法：二分 和 动态规划
 *
 */

public class P410_SplitArray {

    public static int splitArray(int[] nums, int m) {
        //* 1. 得到上界为所有元素和，下界为最大元素。
        int upper = 0;
        int lower = 0;
        for (int i = 0; i < nums.length; i++) {
            upper += nums[i];
            if (nums[i] > lower) {
                lower = nums[i];
            }
        }

        while (lower < upper) {
            int mid = (upper - lower) >> 2 + lower;
            if (check(nums, mid, m)) {

            }
        }


        return 2;
    }

    //挑一个上下界之间的中间数传入
    public static boolean check(int[] nums, int x, int m) {
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > x) {    // 有一个子数组和大于mid数
                cnt++;                  // 子数组个数++
                sum = nums[i];          // 重新统计
            } else {
                sum += nums[i];         // 存子数组和
            }
        }
        return cnt <= m;
    }

    public static void main(String[] args) {
        int[] a = {7, 2, 5, 10, 8};

    }
}
