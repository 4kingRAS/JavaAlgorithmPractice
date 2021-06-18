package com.interview.network;

/**
 * @author Yulin.Wang
 * @date 2021/6/8
 * @description
 */

public class RPCServer {

    public static void main(String[] args) throws Exception {
        RPCService service = new HelloServiceImpl();
        RPCFramework.export(service, 1234);
    }

}
