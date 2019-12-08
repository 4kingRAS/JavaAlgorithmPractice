package com.kkkk.adt;

import java.util.Stack;

/**
 * @author Yulin.Wang
 * @date 2019/12/8
 * @description
 */

public class StackApplication {

    public static char[] convertDecimal(Integer n, Integer base) {
        if (n == null || base == null) return null;

        char[] c = new char[20];
        Stack<Integer> s = new Stack<>();
        int d = n;
        while (d != 0) {
            s.push(d % base);
            d = d / base;
        }
        int l = s.size();
        for (int i = 0; i < l; i++) {
            c[i] = (char) (s.pop() + '0');
        }
        return c;
    }

    public static boolean verifyBracket(String s) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(convertDecimal(16, 8));
    }
}
