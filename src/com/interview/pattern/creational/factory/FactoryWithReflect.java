package com.interview.pattern.creational.factory;

/**
 * @author Yulin.Wang
 * @date 2020/3/14
 * @description 反射实现工厂模式
 */

public class FactoryWithReflect {
    private FactoryWithReflect() {}

    /**
     * @param className 接口的实现
     * @param clazz 接口实现类型
     * @return 如果实现类存在，获取接口实例化对象  ,  优势： 无限复用
     */
    public static <T> T getInstance(String className, Class<T> clazz) {
        T instance = null;
        try {
            instance = (T) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    public static void main(String[] args) {
        ICar car = FactoryWithReflect.getInstance("com.interview.pattern.creational.factory.Audi", ICar.class);
        car.run();
        IShape shape = FactoryWithReflect.getInstance("com.interview.pattern.creational.factory.Circle", IShape.class);
        shape.draw();
    }
}
