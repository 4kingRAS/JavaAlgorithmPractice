package com.kkkk.dynamic;

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
            int length = lcs(a[0].toCharArray(), a[0].length()-1, a[1].toCharArray(), a[1].length()-1);
            System.out.println(length);
        }
    }

}
