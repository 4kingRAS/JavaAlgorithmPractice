package com.interview.codegame.LeetCode;

/*
你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过*，/，+，-，(，)的运算得到 24。

示例 1:

输入: [4, 1, 8, 7]
输出: True
解释: (8-4) * (7-1) = 24
示例 2:

输入: [1, 2, 1, 2]
输出: False
 */

import java.util.ArrayList;
import java.util.List;

public class P679_JudgePoint24 {
    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<Double>();
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }

    public boolean solve(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }

        for (double n : list) {
            //TODO: 排列组合
            //if ()
        }
        return false;
    }

}
