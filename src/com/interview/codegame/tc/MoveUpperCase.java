package com.interview.codegame.tc;

import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2020/5/22
 * @description 小写字母放前面，大写放后面,不能申请新数组变量。
 *              aSGedHFsJ  ===  aedsSGHFJ
 */

public class MoveUpperCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.nextLine().toCharArray();
        int up = 0;
        int low = 0;
        for (int i = 0; i < s.length; i++) {
            if (Character.isUpperCase(s[i]) && i != s.length - 1) {
                for (int j = i+1; j < s.length; j++) {
                    if (Character.isLowerCase(s[j])) {
                        for (int k = j; k > i; k--) {
                            char t = s[k];
                            s[k] = s[k - 1];
                            s[k - 1] = t;
                        }
                        up = j;
                        break;
                    }
                }
            }

        }

        for (char c : s) {
            System.out.print(c);
        }
    }
}
