package com.kkkk.jdk.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Yulin.Wang
 * @date 2019/9/27
 * @description s
 */
//TODO:

public class CopyBytes {

    public static void main(String[] args) throws IOException {
        try (FileInputStream in = new FileInputStream("a.txt");
             FileOutputStream out = new FileOutputStream("b.txt")) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }
    }

}
