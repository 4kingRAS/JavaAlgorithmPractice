package com.kkkk.designPattern.creational.factory;

import com.kkkk.designPattern.creational.Shape;

/**
 * @author Yulin.Wang
 * @date 2019-09-10
 * @description s
 */
//TODO:

public class FactoryPattern {

    class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("O");
        }
    }

    class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("口");
        }
    }

}
