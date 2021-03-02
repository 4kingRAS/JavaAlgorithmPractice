package com.interview.network;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author Yulin.Wang
 * @date 2020/3/10
 * @description
 */

public class EchoClient {

    public static void main(String[] args) {

        String json = "{\n" +
                "  \"type\": \"5G\",\n" +
                "  \"data\": {\n" +
                "    \"var\": \"1321\",\n" +
                "    \"cap\": \"132\",\n" +
                "    \"ver\": \"asds\",\n" +
                "    \"temp\": \"ada\",\n" +
                "    \"mem\": \"sdas\",\n" +
                "    \"cpu\": \"sadsa\",\n" +
                "    \"band\": \"sadas\"\n" +
                "  }\n" +
                "}\r\n";

        String xxx = "{\n" +
                "  \"type\": \"5G\",\n" +
                "  \"datasdashnldasjhlkdjalkjdlsakhlsan" +
                "asjdlajdlkasjlkdjsakldjalkda" +
                "sdlasjdljakldsjalkdasjd" +
                "xzczxcxzxz";

        final String ip = "127.0.0.1";
        //final String ip = "8.129.170.91";
        try {
            Socket socket = new Socket(ip, 10086);
            BufferedWriter sockWriter = new BufferedWriter(new OutputStreamWriter(
                    socket.getOutputStream()
            ));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    System.in, StandardCharsets.UTF_8
            ));
            BufferedReader sockReader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream(), StandardCharsets.UTF_8
            ));

            char[] buf = new char[1024];

            new Thread(() -> {
                try {
                    String tmp;
                    while ((tmp = bufferedReader.readLine()) != null) {
                        String s;
                        switch (tmp) {
                            case "1":
                                break;
                            case "2":
                                break;
                        }
                        sockWriter.write(tmp + "\r\n");
                        sockWriter.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            while (sockReader.read(buf) != -1) {
                System.out.println(buf);
                Arrays.fill(buf, '\0');
            }

            bufferedReader.close();
            sockWriter.close();
            sockReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
