package com.interview.pattern.creational.singleton;

/**
 * @author Yulin.Wang
 * @date 2019/9/13
 * @description s
 */
//TODO:


class DoubleCheckSingleton {
    private volatile static DoubleCheckSingleton singleton; // volatile 实例化后立即刷新，而不要副本
    private DoubleCheckSingleton (){}
    public static DoubleCheckSingleton getInstance() {
        if (singleton == null) {                            //检查是否存在 ，存在时就不需要同步，提高性能
            synchronized (DoubleCheckSingleton.class) {     //锁上
                if (singleton == null) {                    //再次检查
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }

    @Override
    public String toString() {
        return "DoubleCheck";
    }
}

public class Singleton {

    // lazy loading 懒汉式
    //private static Singleton instance;

    //饿汗，线程安全， 浪费内存
    private static Singleton instance = new Singleton();

    private Singleton() {
        System.out.println("NEW" + Thread.currentThread().getName());
    }

    public void print() {
        System.out.println(Thread.currentThread().getName() + "000");
    }

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
        for (int i = 0; i < 9; i++) {
            new Thread(() -> {
                Singleton.getInstance().print();
            }, "s" + i).start();
        }
    }

}
