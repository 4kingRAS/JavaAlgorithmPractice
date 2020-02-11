package com.kkkk.jdk.string;

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

        StringBuffer aa = new StringBuffer("abc ");
        aa.append("def");
        System.out.println(a == b); // true
        System.out.println(aa.toString() == b); // false
    }
}
