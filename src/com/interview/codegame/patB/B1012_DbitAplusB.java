package com.interview.codegame.patB;

import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019-08-30
 * @description s
 **/
//TODO:

public class B1012_DbitAplusB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();
        sc.close();

        if (d == 10) {
            System.out.println(a + b);
        } else if (d == 2) {
            System.out.println(Integer.toBinaryString(a + b));
        } else {
            int sum = a + b;
            StringBuilder ss = new StringBuilder();
            while (sum != 0) {
                ss.append(sum % d);
                sum = sum / d;
            }
            System.out.println(ss.reverse().toString());
        }
    }

}
