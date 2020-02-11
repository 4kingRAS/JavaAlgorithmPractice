package com.unitest;

import java.util.Objects;

/**
 * @author Yulin.Wang
 * @date 2020/2/11
 * @description
 */

public class Unit {
    private String msg;
    private Integer num;

    public Unit (String msg, Integer num) {
        this.msg = msg;
        this.num = num;
    }

    public String print() {
        System.out.println(this.msg);
        return this.msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return Objects.equals(msg, unit.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msg);
    }
}
