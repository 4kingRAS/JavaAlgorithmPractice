package com.kkkk.designPattern.creational.singleton;

/**
 * @author Yulin.Wang
 * @date 2019/9/13
 * @description s
 */
//TODO:

class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton() {

    }

    @Override
    public String toString() {
        return "Lazy";
    }

    public static LazySingleton getInstance() { // 加 synchronized 可以线程安全
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

public class Singleton {

    // lazy loading 懒汉式
    //private static Singleton instance;

    //饿汗，线程安全， 浪费内存
    private static Singleton instance = new Singleton();

    private Singleton() {}

    /*
    public static synchronized Singleton getInstance() {
        //加入 synchronize 保证线程安全， 懒汉式
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
     */

    public static Singleton getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "It's my singleton";
    }

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        LazySingleton l = LazySingleton.getInstance();
        System.out.println(s);
        System.out.println(l);
    }

}
