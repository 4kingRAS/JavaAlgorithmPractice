package com.interview.codegame.tc;

import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019/9/10
 * @description s
 */
//TODO:

public class INS {

    static class mark {
        int s = 0;
        int num = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cut = new int[101];

        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            cut[cur] = cur;
        }

        mark[] odd = new mark[101];
        mark[] even = new mark[101];
        for (int i = 0; i < 100; i++) {
            even[i] = new mark();
            odd[i] = new mark();
        }
        int c = 0;
        int idx = 0;
        for (int i = 1; i <= 99; i+=2) {
            if (cut[i] == 0) {
                if (c == 0) {
                    idx++;
                    odd[idx].s = i;
                }
                c++;
                if (i == 99) {
                    odd[idx].num = c;
                }
            } else {
                odd[idx].num = c;
                c = 0;
            }
        }
        int ol = idx;
        c = 0;
        idx = 0;
        for (int i = 2; i <= 100; i+=2) {
            if (cut[i] == 0) {
                if (c == 0) {
                    idx++;
                    even[idx] = new mark();
                    even[idx].s = i;
                }
                c++;
                if (i == 100) {
                    even[idx].num = c;
                }
            } else {
                even[idx].num = c;
                c = 0;
            }
        }
        int el = idx;
        int max = 0;
        int s = 0;
        for (int i = 0; i <= ol; i++) {
            if (odd[i].num > max) {
                max = odd[i].num;
                s = odd[i].s;
            }
        }
        int emax = 0;
        int es = 0;
        for (int i = 0; i <= el; i++) {
            if (even[i].num > emax) {
                emax = even[i].num;
                es = even[i].s;
            }
        }
        if (max == emax) {
            if (s > es) {
                s = es;
            }
        } else {
            s = (max > emax) ? s : es;
            max = Math.max(max, emax);
        }
        System.out.printf("%d %d", s, max);
    }
}
