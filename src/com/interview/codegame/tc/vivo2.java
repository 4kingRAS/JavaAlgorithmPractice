package com.interview.codegame.tc;

/**
 * @author Yulin.Wang
 * @date 2020/3/8
 * @description
 */

public class vivo2 {
    public static int solution(int n) {
        int count = 8;
        int m = n;
        int[] ans = new int[9];
        int index = 0;
        while (m > 1) {
            for (int i = 9; i >= 1; i--) {
                if (m % i == 0) {
                    ans[index] = i;
                    m = m / i;
                    index++;
                }
            }
        }
        int s = ans[index - 2];
        if (index > 0) {

            for (int i = index - 3; i >= 0; i--) {
                s = s * 10 + ans[i];
            }
            return s;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(36));
    }
}
