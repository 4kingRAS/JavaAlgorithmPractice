package com.kkkk;

import java.util.Scanner;

import com.kkkk.adt.Stack;
import com.kkkk.sort.BasicSort;

public class Main {

    public static void main(String[] args) {

        boolean b = false;
        int n = 5;
        for (boolean s = false; s = !s; n--) {
            System.out.println(b = !b);
            s = false;
        }

    }

    public void testStack() {
        Utils utils = new Utils();
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> s = new Stack<>(6);

        char a = '\u0030';
        System.out.println(a);

        for (int i = 0; i < 6; i++) {
            s.push(scanner.nextInt());
        }

        for (int i = 0; i < 6; i++) {
            System.out.println(s.pop());
        }
        System.out.println(s.isEmpty());
    }

}
