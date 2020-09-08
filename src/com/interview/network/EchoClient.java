package com.interview.network;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2020/3/10
 * @description
 */

public class EchoClient {

    public static void main(String[] args) {
        final String ip = "127.0.0.1";
        final String ip2 = "47.100.202.14";
        try {
            Socket socket = new Socket(ip, 9001);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                    socket.getOutputStream()
            ));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    System.in, StandardCharsets.UTF_8
            ));
            BufferedReader sockReader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream(), StandardCharsets.UTF_8
            ));

            char[] buf = new char[220];
            while (sockReader.read(buf) != -1) {
                bufferedWriter.flush();
                System.out.println(buf);
                if (buf[0] == 'q') {
                    break;
                }
            }
            bufferedReader.close();
            bufferedWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
