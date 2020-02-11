package com.kkkk.pattern.ioc;

/**
 * @author Yulin.Wang
 * @date 2020/2/11
 * @description
 */

public class Container {

    public void injection() { // 此方法就是Ioc容器， 就是Listener
        Wheels wheels = new Wheels(30); // 只需改轮子
        Bottom bottom = new Bottom(wheels);
        Car car = new Car(bottom);
    }

    public static void main(String[] args) {

    }
}
