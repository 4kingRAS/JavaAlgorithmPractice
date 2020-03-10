package com.interview.jdk.io;

import java.io.*;

/**
 * @author Yulin.Wang
 * @date 2020/3/10
 * @description
 */

public class InputTest {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/yl.wang/Desktop/Java/Algorithm/src/output.txt");
            InputStream inputStream = new FileInputStream(file);
            String str = new String(inputStream.readAllBytes());
            System.out.println(str);
            //inputStream.close(); //autocloseable 的try catch自动实现了close
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
