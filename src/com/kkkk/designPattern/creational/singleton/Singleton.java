package com.kkkk.designPattern.creational.singleton;

/**
 * @author Yulin.Wang
 * @date 2019/9/13
 * @description s
 */
//TODO:

public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        //加入 synchronize 保证线程安全， 懒汉式
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "It's my singleton";
    }

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        System.out.println(s);
    }

}
