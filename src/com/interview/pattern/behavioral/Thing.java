package com.interview.pattern.behavioral;

/**
 * @author Yulin.Wang
 * @date 2020/2/14
 * @description
 */

public class Thing {
    private State state;

    public Thing(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void doAction() {
        this.state.doAction();
    }
}
