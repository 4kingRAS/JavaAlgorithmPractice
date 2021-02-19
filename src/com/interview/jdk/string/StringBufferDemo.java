package com.interview.jdk.string;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author Yulin.Wang
 * @date 2019/11/25
 * @description s
 */
//TODO:

public class StringBufferDemo {
    public static void main(String[] args) {
        String a = "abc " + "def";
        String b = "abc def";
        String c = "测试a";
        String d = "测试b";
        String[] s = {"测试a", "测试b"};

        StringBuffer aa = new StringBuffer("abc ");
        System.out.print(ClassLayout.parseClass(String.class)
                .toPrintable());
        aa.append("def");
        System.out.println(a == b); // true
        System.out.println(aa.toString() == b); // false
    }
}
