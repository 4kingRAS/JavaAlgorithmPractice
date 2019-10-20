package com.kkkk;

import java.util.Scanner;

public class Main {

    public static int a = 3;

    public int getA() {
        return a;
    }

    public static void setA(int a) {
        Main.a = a;
    }

    public static void main(String[] args) {
        a = 5;
        System.out.println(a);
        Main aa = new Main();
        Main bb = new Main();
        setA(3);
        System.out.println(aa.getA());
        a = 4;
        System.out.println(bb.getA());
        System.out.println(aa.getA());

    }


}
