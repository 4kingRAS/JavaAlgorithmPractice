package com.interview.jdk.io;

import java.io.*;

/**
 * @author Yulin.Wang
 * @date 2020/3/10
 * @description
 *
 *      io中四种流， input output reader writer
 */

public class OutputTest {
    public static void main(String[] args) {
        File file = new File("/Users/yl.wang/Desktop/Java/Algorithm/src/output.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            OutputStream outputStream = new FileOutputStream(file);
            String str = "测试输出";
            outputStream.write(str.getBytes());
            //outputStream.close(); //autocloseable 的try catch自动实现了close
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
