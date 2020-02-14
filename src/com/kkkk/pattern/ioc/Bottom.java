package com.kkkk.pattern.ioc;

/**
 * @author Yulin.Wang
 * @date 2020/2/11
 * @description
 */

public class Bottom {
    private Wheels wheels;

    public Wheels getWheels() {
        return wheels;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    public Bottom(Wheels wheels) {
        this.wheels = wheels;
    }
}
