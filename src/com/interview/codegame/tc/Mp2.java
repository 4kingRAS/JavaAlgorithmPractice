package com.interview.codegame.tc;

import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019-09-06
 * @description s
 **/
//TODO:

public class Mp2 {
    static class node {
        public int v;
        public node l;
        public node m;
        public node r;

    }

    public static node make(char[] s, int i) {
        int val = s[i] - '0';
        node n = new node();
        if (val < 10 && val > 0) {
            n.v = val;
            i++;
        }
        if (s[i] == '(') {
            i++;
            n.l = make(s, i);
            n.l.m = n;
        }
        if (s[i] == ',') {
            n.l = null;
            n.r = null;
            return n;
        }
        if (s[i] == ')') {
            i++;
            n.r = make(s, i);
            n.r.m = n;
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ss = sc.nextLine();

        char[] s = ss.toCharArray();

        node r = make(s, 0);

    }
}
