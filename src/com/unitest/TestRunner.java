package com.unitest;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author Yulin.Wang
 * @date 2020/2/11
 * @description
 */

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(UnitTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());

        UnitList list = new UnitList();
        list.add(new Unit("1", 1));
        list.add(new Unit("2", 3));
        list.add(new Unit("3", 2));
        list.add(new Unit("4", 4));

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
