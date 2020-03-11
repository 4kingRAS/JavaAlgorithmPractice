package com.interview.jdk.io;

import java.io.*;

/**
 * @author Yulin.Wang
 * @date 2020/3/11
 * @description 字符输出流， 跟OutputStream一样 都是接口，要自己实现
 *                  writer 使用到了缓冲区，要close后才有结果。
 */

public class WriteAndRead {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/yl.wang/Desktop/Java/Algorithm/src/output.txt");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            String s = "hahaer";
            Writer writer = new FileWriter(file);
            writer.write(s);
            writer.close();

            Reader reader = new FileReader(file);
            char[] ch = new char[200];
            reader.read(ch);
            System.out.println(ch);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
