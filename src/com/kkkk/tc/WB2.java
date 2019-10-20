package com.kkkk.tc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019/9/19
 * @description s
 */
//TODO:

public class WB2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int edge = sc.nextInt();

        byte[][] m = new byte[edge + 1][edge + 1];

        for (int i = 1; i <= edge; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            m[s][e] = 1;
            m[e][s] = 1;
        }
        int start = sc.nextInt();
        int end = sc.nextInt();

        boolean[] rs = new boolean[node + 1];
        Arrays.fill(rs, false);
        int cur = start;
        while (true) {
            for (int i = 1; i <= node; i++) {
                if (rs[i] == false) {
                    if (m[cur][i] != 0) {
                        rs[cur] = true;
                        rs[i] = true;
                    }
                }

            }
        }

    }
}
