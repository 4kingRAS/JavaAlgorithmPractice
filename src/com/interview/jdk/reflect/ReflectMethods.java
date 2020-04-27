package com.interview.jdk.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author Yulin.Wang
 * @date 2020/3/15
 * @description
 */

public class ReflectMethods {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("com.interview.pattern.demo.Person");
        System.out.println(cls.getName());
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            System.out.println(constructor);
        }

        for (Constructor<?> constructor : cls.getConstructors()) {
            System.out.println(constructor);
        }

        for (Method method : cls.getDeclaredMethods()) { // 获取本类方法
            System.out.println(method);
        }

        for (Method method : cls.getMethods()) { // 获取所有方法，包括父类的
            System.out.println(method);
        }
    }
}
