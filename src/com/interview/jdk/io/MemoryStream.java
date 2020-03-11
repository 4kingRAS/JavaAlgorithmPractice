package com.interview.jdk.io;

import java.io.*;

/**
 * @author Yulin.Wang
 * @date 2020/3/11
 * @description
 */

public class MemoryStream {
    public static void main(String[] args) throws IOException {
        String s = "sdsaas";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(s.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        int data;
        while ((data = inputStream.read()) != -1) {
            outputStream.write((char) Character.toUpperCase(data));
        }

        //outputStream.toByteArray();   可得到字节数据

        System.out.println(outputStream.toString());

    }
}
