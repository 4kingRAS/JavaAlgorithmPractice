package com.interview.pattern.ioc;

/**
 * @author Yulin.Wang
 * @date 2020/2/11
 * @description Ioc的精髓就是尽量推迟实例化，轮子底盘汽车放到main里一起实例化实例化。
 */

public class Container {

    public static void injection() { // 此方法就是Ioc容器， 就是Listener
        Wheels wheels = new Wheels(30); // 只需改轮子
        Bottom bottom = new Bottom(wheels);
        Car car = new Car(bottom);
        car.run();
    }

    public static void main(String[] args) {
        Container.injection();
    }
}
