package com.interview.jdk.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Yulin.Wang
 * @date 2019/9/27
 * @description s
 */
//TODO:

public class TestString {
    public static void main(String[] args) {
        String s1 = "new";
        String s2 = new String("new");
        String s3 = "n" + "ew";
        String s4 = "ew";
        String s5 = "n" + s4;

        System.out.println(s1 == s2);
        System.out.println(s1 == s3); // JVM优化成 s3 = "new"
        System.out.println(s2 == s3);
        System.out.println(s1 == s5);
        System.out.println(s3 == s5); // 调用StringBuffer。append
        System.out.println(s5.equals(s2));

        StringBuilder sb = new StringBuilder("");
        Set<StringBuilder> set = new HashSet<>();
        set.add(sb);
        System.out.println(set.contains(sb));
        System.out.println(sb.hashCode());
        sb.append("asdas");
        System.out.println(set.contains(sb));
        System.out.println(sb.hashCode());

        Scanner sc = new Scanner(System.in);

        String a = sc.next("\\d{4}-\\d{2}");
        System.out.println(a);
    }
}
