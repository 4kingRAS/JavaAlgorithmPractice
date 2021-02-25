package com.interview.codegame.LeetCode;

/**
 * @author Yulin.Wang
 * @date 2021/2/22
 * @description
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
 */

public class PO57_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length <= 2) return nums;

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] > target) {
                r--;
                continue;
            } else if (nums[l] + nums[r] < target) {
                l++;
                continue;
            }
            return new int[]{nums[l], nums[r]};
        }

        return new int[]{};
    }
}
