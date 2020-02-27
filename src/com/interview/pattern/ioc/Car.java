package com.interview.pattern.ioc;

/**
 * @author Yulin.Wang
 * @date 2020/2/11
 * @description
 */

public class Car {
    private Bottom bottom;

    public Car(Bottom bottom) {
        this.bottom = bottom; //注入
    }

    public void run() {
        System.out.println(bottom.getWheels().count);
    }
}
