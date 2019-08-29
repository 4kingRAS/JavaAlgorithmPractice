package com.kkkk.math;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019-08-25
 * @description s
 **/
//TODO:

public class HighPrecisionMultiply {

    private static long multiply(char[] a, char[] b) {

        int alen = a.length;
        int blen = b.length;

        if ((alen== 1 && a[0] == '0')|| (blen == 1 && b[0] == '0')) {
            System.out.println(0);
            return 0;
        }

        int[] out = new int[128];
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
        for (int i = c; i >= 0; i--) {
            System.out.print(out[i]);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        char[] a = s[0].toCharArray();
        char[] b = s[1].toCharArray();

        multiply(a, b);

    }

}
