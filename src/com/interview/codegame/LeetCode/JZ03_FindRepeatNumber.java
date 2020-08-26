package com.interview.codegame.LeetCode;

/*
        输入：
        [2, 3, 1, 0, 2, 5, 3]
        输出：2 或 3
*/
public class JZ03_FindRepeatNumber {

    public static int findRepeatNumber(int[] nums) {
        byte[] mask = new byte[nums.length];
        for (int i : nums) {
            if (mask[i] == 0)
                mask[i] = 1;
            else
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] a = {2, 3, 5, 0, 1, 2, 5, 3};

        System.out.println(findRepeatNumber(a));

    }
}
