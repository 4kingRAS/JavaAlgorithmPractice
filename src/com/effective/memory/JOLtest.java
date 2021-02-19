package com.effective.memory;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author Yulin.Wang
 * @date 2020/10/19
 * @description
 */

public class JOLtest {
    static class A {
        char a;
        String b;
        String[] c = {"你", "a"};
    }

    public static void main(String[] args) {
        A a = new A();

        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(A.class).toPrintable());
        System.out.println(ClassLayout.parseInstance(a.c[1]));
    }
}
