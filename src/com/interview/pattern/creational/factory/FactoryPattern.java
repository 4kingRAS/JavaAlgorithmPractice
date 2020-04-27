package com.interview.pattern.creational.factory;

import com.interview.pattern.demo.Circle;
import com.interview.pattern.demo.IShape;
import com.interview.pattern.demo.Square;

/**
 * @author Yulin.Wang
 * @date 2019-09-10
 * @description s
 */

public class FactoryPattern {
    public static final int CIRCLE = 0;
    public static final int SQUARE = 1;
    public IShape createShape(int shapeType) {
        switch (shapeType) {
            case CIRCLE:
                return new Circle();
            case SQUARE:
                return new Square();
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        FactoryPattern sf = new FactoryPattern();
        IShape s = sf.createShape(FactoryPattern.CIRCLE);
        s.draw();
    }

}
