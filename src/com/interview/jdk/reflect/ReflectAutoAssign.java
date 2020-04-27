package com.interview.jdk.reflect;

import com.interview.pattern.demo.Box;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Yulin.Wang
 * @date 2020/4/23
 * @description 利用反射实现属性自动赋值
 */

public class ReflectAutoAssign {
    public static void main(String[] args) {
        String value = "s:james|i:998";
        Box b = ClassInstanceFactory.create(Box.class, value);
        System.out.println(b.getS() + b.getI());
    }
}

class ClassInstanceFactory {
    private ClassInstanceFactory() {}

    public static <T> T create(Class<?> clazz, String attr) {
        try {
            Object obj = clazz.getDeclaredConstructor().newInstance();
            String[] s = attr.split("\\|");
            for (int i = 0; i < s.length; i++) {
                String[] val = s[i].split(":");
                try {
                    //field 获取成员变量
                    Field field = obj.getClass().getDeclaredField(val[0]);
                    //需要给属性首字母大写：
                    if (val[0].length() == 1) {
                        val[0] = val[0].toUpperCase();
                    } else {
                        val[0] = val[0].substring(0, 1).toUpperCase() + val[0].substring(1);
                    }
                    //method 获取setter；
                    Method setter = obj.getClass().getDeclaredMethod("set" + val[0],
                            field.getType());
                    setter.invoke(obj, val[1]);
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }
            return (T) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}