package com.interview.network;

/**
 * @author Yulin.Wang
 * @date 2021/5/25
 * @description
 */

public class HelloServiceImpl implements RPCService{

    @Override
    public String hello(String name) {
        return "Hello " + name;
    }

}
