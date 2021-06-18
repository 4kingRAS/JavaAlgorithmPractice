package com.interview.network;

/**
 * @author Yulin.Wang
 * @date 2021/6/8
 * @description
 */

public class RPCServiceImpl implements RPCService {

    @Override
    public String hello(String name) {
        return "Hello " + name;
    }

}
