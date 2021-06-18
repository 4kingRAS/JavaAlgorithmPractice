package com.interview.network;

/**
 * @author Yulin.Wang
 * @date 2021/6/8
 * @description
 */

public class RPCClient {

    public static void main(String[] args) throws Exception {
        RPCService service = RPCFramework.refer(RPCService.class, "127.0.0.1", 1234);
        for (int i = 0; i < Integer.MAX_VALUE; i ++) {
            String hello = service.hello("World" + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }
    }

}
