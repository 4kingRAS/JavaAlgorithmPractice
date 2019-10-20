package com.kkkk.tc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019/9/19
 * @description s
 */
//TODO:

public class WB1 {
    private static char[] mul(char[] a, char[] b) {

        int alen = a.length;
        int blen = b.length;

        int[] out = new int[1024];
        Arrays.fill(out, 0);

        int c = 0;
        for (int i = blen - 1; i >= 0; i--) {
            for (int j = alen - 1; j >= 0; j--) {
                int an = a[j] - '0';
                int bn = b[i] - '0';
                int cur = alen + blen - i - j - 2;
                int ret = an*bn;
                if (out[cur] + ret % 10 > 9) {
                    out[cur] += ret % 10 - 10;
                    out[cur+1] += 1;
                } else {
                    out[cur] += ret % 10;
                }

                if (ret / 10 > 0) out[cur+1] += ret / 10;
                c = cur;
            }

        }

        if (out[c+1] != 0) { c++; }
        char[] r = new char[c+1];
        for (int i = c; i >= 0; i--) {
            r[c-i] = (char)(out[i] + 48);
        }

        return r;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 1;
        if (n <= 15) {
            for (int i = 1; i <= n; i++) {
                sum *= i;
            }
            String s = String.valueOf(sum);
            char[] c = s.toCharArray();
            for (int i = c.length - 1; i >= 0; i--) {
                if (c[i] != '0') {
                    System.out.println(c[i]);
                    return;
                }
            }
        }

        int a = 1;
        char[] ss = String.valueOf(a).toCharArray();
        for (int i = 1; i <= n; i++) {
            char[] aa = mul(ss, String.valueOf(i).toCharArray());
            ss = aa.clone();
        }
        System.out.println(ss);
        for (int i = ss.length - 1; i >= 0; i--) {
            if (ss[i] != '0') {
                System.out.println(ss[i]);
                return;
            }
        }
    }
}
