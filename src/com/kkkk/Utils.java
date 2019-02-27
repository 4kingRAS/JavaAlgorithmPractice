package com.kkkk;

/**
 * @Author Yulin.Wang
 * @Date 2019-02-25
 * @Description
 **/

public class Utils {
    /**
     * usage: z = swap(a, a=b, b=c, ... y=z);
     *
     * JAVA没有指针，用swap
     */
    public <T> T swap(T... args) {
        return args[0];
    }
}
