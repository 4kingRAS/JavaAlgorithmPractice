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

    public static void main (String[] args) throws InterruptedException {
        a = 5;
        for (int i = 0; i < 22; i++) {
            System.out.println(i);
            Thread.sleep(1000);
        }
    }


}
