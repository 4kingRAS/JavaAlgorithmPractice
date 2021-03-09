package com.interview.codegame.LeetCode;

import java.util.Arrays;
import java.util.List;

public class P14_LCP {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        char[] s = strs[0].toCharArray();
        int j = s.length;
        for (int i = 1; i < strs.length; i++) {
            if (j == 0) return "";
            for (int k = 0; k < Math.min(j, strs[i].length()); k++) {
                if (s[k] != strs[i].charAt(k)) {
                    j = k;
                    break;
                }
            }
        }
        return String.copyValueOf(s, 0, j);
    }

    public static void main(String[] args) {
        String[] s = {"adas","asd","aaa"};
        System.out.println(longestCommonPrefix(s));
    }
}
