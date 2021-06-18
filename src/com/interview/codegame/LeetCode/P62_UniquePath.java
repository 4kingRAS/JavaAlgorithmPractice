package com.interview.codegame.LeetCode;

/**
 * @author Yulin.Wang
 * @date 2021/4/8
 * @description   P[i,j] = MIN(P[i-1,j], P[i,j-1]) + 1
 */

public class P62_UniquePath {
    public static int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];

        for (int i = 0; i < m; i++) {
            path[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            path[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }

        System.out.println(path[m - 1][n - 1]);
        return 0;
    }

    public static void main(String[] args) {
        uniquePaths(3, 7);
    }

}
