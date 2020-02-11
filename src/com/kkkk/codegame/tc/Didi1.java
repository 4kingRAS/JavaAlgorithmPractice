package com.kkkk.codegame.tc;

import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019-08-27
 * @description s
 **/
//TODO:

public class Didi1 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split(" ");

        char[] op = new char[100000];
        int[] num = new int[100000];

        for (int i = 0; i < s.length; i++) {
            num[i] = Integer.parseInt(s[i]);
        }


    }

}
