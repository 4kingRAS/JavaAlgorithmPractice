package com.unitest;

/**
 * @author Yulin.Wang
 * @date 2020/2/11
 * @description
 */

public class UnitNode {
    private Unit value;
    private UnitNode next;

    public Unit getValue() {
        return value;
    }

    public void setValue(Unit value) {
        this.value = value;
    }

    public UnitNode getNext() {
        return next;
    }

    public void setNext(UnitNode next) {
        this.next = next;
    }

    public UnitNode(Unit value, UnitNode next) {
        this.value = value;
        this.next = next;
    }
}
