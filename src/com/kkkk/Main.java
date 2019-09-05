package com.kkkk;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s1 = "new";
        String s2 = new String("new");
        String s3 = "n" + "ew";
        String s4 = "ew";
        String s5 = "n" + s4;

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
        System.out.println(s1 == s5);
        System.out.println(s3 == s5);
        System.out.println(s5.equals(s2));

        Scanner sc = new Scanner(System.in);
        String a = sc.next("\\d{4}-\\d{2}");
        System.out.println(a);

    }


}
