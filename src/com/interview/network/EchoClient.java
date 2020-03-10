package com.interview.network;

import java.io.*;
import java.net.Socket;

/**
 * @author Yulin.Wang
 * @date 2020/3/10
 * @description
 */

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9991);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                    socket.getOutputStream()
            ));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    System.in, "UTF-8"
            ));

            while (true) {
                String str = bufferedReader.readLine();
                bufferedWriter.write(str);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
                if (str.equalsIgnoreCase("quit")) {
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
