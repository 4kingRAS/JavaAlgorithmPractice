package com.kkkk.algorithm.dynamic;

import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019-05-13
 * @description dynamic and basic LongestCommonSequence
 **/
//TODO:

public class LCS {
    public String getLCSrecu(String origin) {

        return "";
    }

    public static int dpLCS(char[] a, char[] b) {
        //dp method
        boolean debug = true;
        int la = a.length;
        int lb = b.length;

        int[][] dp = new int[la+1][lb+1];  //外围为0
        for (int i = 1; i < la+1; i++) {
            for (int j = 1; j < lb+1; j++) {
                dp[i][j] = dp[i-1][j-1];
                if (b[j - 1] == a[i - 1]) {
                    dp[i][j]++;
                } else {
                    dp[i][j] = dp[i][j-1] > dp[i-1][j] ? dp[i][j-1] : dp[i-1][j];
                }

                if (debug) {
                    System.out.print(dp[i][j]);
                }
            }
            if (debug) { System.out.println(); }
        }
        return dp[la][lb];
    }

    public static int lcs(char[] a, int at, char[] b, int bt) {

        //recursive

        if (at == -1 || bt == -1) return 0;
        if (a[at] == b[bt]) {
            return lcs(a, at - 1, b, bt - 1) + 1;
        } else {
            int ta = lcs(a, at - 1, b, bt);
            int tb = lcs(a, at, b, bt - 1);
            return ta > tb ? ta : tb;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine().trim();
            String[] a = line.split(" ");
            //int length = lcs(a[0].toCharArray(), a[0].length()-1, a[1].toCharArray(), a[1].length()-1);

            int length = dpLCS(a[0].toCharArray(), a[1].toCharArray());
            System.out.println(length);


        }
    }

}
