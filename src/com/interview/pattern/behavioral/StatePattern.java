package com.interview.pattern.behavioral;

/**
 * @author Yulin.Wang
 * @date 2020/2/14
 * @description 状态模式，根据状态决定动作
 */

public class StatePattern {
    public static void main(String[] args) {
        DeadState deadState = new DeadState();
        LiveState liveState = new LiveState();
        Thing thing = new Thing(liveState);
        thing.doAction();
        thing.setState(deadState);
        thing.doAction();
    }
}
