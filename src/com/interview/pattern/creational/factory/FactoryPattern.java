package com.interview.pattern.creational.factory;

/**
 * @author Yulin.Wang
 * @date 2019-09-10
 * @description s
 */
//TODO:

class ShapeFactory {
    public static final int CIRCLE = 0;
    public static final int SQUARE = 1;
    public Shape createShape(int shapeType) {
        switch (shapeType) {
            case CIRCLE:
                return new Circle();
            case SQUARE:
                return new Square();
            default:
                return null;
        }
    }
}

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

public class FactoryPattern {

    public static void main(String[] args) {
        ShapeFactory sf = new ShapeFactory();
        Shape s = sf.createShape(ShapeFactory.CIRCLE);
        s.draw();
    }

}
