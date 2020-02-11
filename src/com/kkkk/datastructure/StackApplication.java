package com.kkkk.datastructure;

import java.util.Stack;

/**
 * @author Yulin.Wang
 * @date 2019/12/8
 * @description
 */

public class StackApplication {


    /**
     * @param n 十进制数
     * @param base 进制
     * @return 转换后的整数
     * 短除法，商为低位，余数接着除，到0为止
     */
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

    /**
     * @param s 含有括号或无括号的字符串
     * @return 如果无括号或括号严格左右匹配，为true  ()
     *
     * 简明版括号匹配
     * 原理，凡遇 '(, {' push, 遇 '), }' pop
     */
    public static boolean verifyBracket(String s) {
        Stack<Character> ch = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{') { ch.push(c); }
            else if (c == ')' || c == '}') {
                char counter = (c == ')') ? '(' : '{';
                if (!ch.empty() && ch.peek() == counter) { ch.pop(); }
                else return false;
            }
        }
        return ch.empty(); // 栈为空说明匹配合法
    }

    public static void main(String[] args) {
        System.out.println(convertDecimal(16, 8));
        System.out.println(verifyBracket("(sdass{sadsa(ds)a})(assa){()}(--}--)"));
    }
}
