package com.kkkk.pattern.behavioral;

/**
 * @author Yulin.Wang
 * @date 2020/2/14
 * @description
 */

public class LiveState implements State {
    @Override
    public void doAction() {
        System.out.println("live");
    }
}
