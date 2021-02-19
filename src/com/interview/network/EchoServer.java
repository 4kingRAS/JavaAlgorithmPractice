package com.interview.network;

import java.io.*;
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
            ServerSocket serverSocket = new ServerSocket(10086);

            Socket socket = serverSocket.accept(); // client
            System.out.println("BUFFERSIZE: " + serverSocket.getReceiveBufferSize());
            System.out.println("Remote: " + socket.getRemoteSocketAddress());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream(), StandardCharsets.UTF_8
            ));
            BufferedReader keyBoardReader = new BufferedReader(new InputStreamReader(
                    System.in, StandardCharsets.UTF_8
            ));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                    socket.getOutputStream(), StandardCharsets.UTF_8
            ));

            new Thread(() -> {
                try {
                    String tmp;
                    while ((tmp = keyBoardReader.readLine()) != null) {
                        String s = "{\"statusasdasd\nsadsa\":\"0\"}\r\n";
                        bufferedWriter.write(tmp);
                        bufferedWriter.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();


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
