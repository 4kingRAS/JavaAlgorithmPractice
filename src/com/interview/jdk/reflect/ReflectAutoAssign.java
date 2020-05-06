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
        String value = "s:james|i:998";  //属性值
        Box b;
        try {
            b = ClassInstanceFactory.create(Box.class, value);
            System.out.println(b.getS() + b.getI());
        } catch (Exception e) {
            System.out.println("shibai");
        }
    }
}

class ClassInstanceFactory {
    private ClassInstanceFactory() {}

    public static Object convertValue(String type, String value) {
        if (type == null) return null;
        switch (type) {
            case "java.lang.Long" :
                return Long.parseLong(value);
            case "int" :
                return Integer.parseInt(value);
                //.....
        }
        return value;
    }

    public static <T> T create(Class<?> clazz, String attr) throws Exception {
        Object obj = clazz.getDeclaredConstructor().newInstance();
        String[] s = attr.split("\\|");
        for (int i = 0; i < s.length; i++) {
            String[] value = s[i].split(":");
            try {
                String var = value[0];
                String val = value[1];
                //field 获取成员变量
                Field field = obj.getClass().getDeclaredField(var);
                //需要给属性首字母大写：
                if (var.length() == 1) {
                    var = var.toUpperCase();
                } else {
                    var = var.substring(0, 1).toUpperCase() + var.substring(1);
                }
                //method 获取setter；
                Method setter = obj.getClass().getDeclaredMethod("set" + var,
                        field.getType());
                Object v = convertValue(field.getType().getName(), val);
                setter.invoke(obj, v);
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
        return (T) obj;
    }
}