package com.interview.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Yulin.Wang
 * @date 2020/3/10
 * @description
 */

public class EchoServer {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket serverSocket = new ServerSocket(9991);

            Socket socket = serverSocket.accept(); // client
            System.out.println("BUFFERSIZE: " + serverSocket.getReceiveBufferSize());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream(), StandardCharsets.UTF_8
            ));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                if (str.equalsIgnoreCase("quit")) {
                    break;
                }
                System.out.println(str);
            }
            serverSocket.close();
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
