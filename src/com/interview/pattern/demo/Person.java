package com.interview.pattern.demo;

/**
 * @author Yulin.Wang
 * @date 2020/3/15
 * @description
 */

public class Person extends AbstractBase {
    private int age;
    private String name;


    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void print() {
        System.out.println("sss");
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
