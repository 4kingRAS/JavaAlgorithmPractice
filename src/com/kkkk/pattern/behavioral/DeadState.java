package com.kkkk.pattern.behavioral;

/**
 * @author Yulin.Wang
 * @date 2020/2/14
 * @description
 */

public class DeadState implements State {

    @Override
    public void doAction() {
        System.out.println("dead");
    }

    public void bomb() {
        System.out.println("sss");
    }
}
