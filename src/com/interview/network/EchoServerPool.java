package com.interview.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yulin.Wang
 * @date 2020/5/1
 * @description 每个链接起一个线程，用线程池
 */

public class EchoServerPool {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9991);
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        while (true) {
            Socket socket = serverSocket.accept(); // 接到一个新链接
            Runnable runnable = () -> {
                BufferedReader bufferedReader = null;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(
                            socket.getInputStream(), StandardCharsets.UTF_8));
                    String s;
                    while ((s = bufferedReader.readLine()) != null) {
                        System.out.println(socket.getRemoteSocketAddress().toString() + ": " + s);
                    }
                } catch (IOException e) {
                    System.out.println("error");
                }
            };
            executorService.submit(runnable);
        }
    }
}
