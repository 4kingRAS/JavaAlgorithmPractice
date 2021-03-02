package com.interview.codegame.LeetCode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Yulin.Wang
 * @date 2021/2/25
 * @description
 *
 * 给定一个按照 **升序** 排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

public class P34_FirstAndLast {
    public static int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        int r = nums.length - 1;
        int l = 0;
        while (r >= l) {
            int m = (l + r) >>> 1;
            if (nums[m] >= target) {
                first = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        l = (first == -1) ? 0 : first;
        r = nums.length - 1;
        while (r >= l) {
            int m = (l + r) >>> 1;
            if (nums[m] <= target) {
                last = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        if (first == -1 || last == -1) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, last};
        }
    }

    public static void main(String[] args) {
        int[] b = {3};
        int[] a = {4,4,4,4};

        System.out.println(Arrays.toString(searchRange(b, 4)));

    }

}
