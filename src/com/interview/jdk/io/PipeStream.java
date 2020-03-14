package com.interview.jdk.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author Yulin.Wang
 * @date 2020/3/13
 * @description 管道操作，用于线程对象间输入输出
 * 字节  PipedInputStream
 * 字符  PipedReader
 */

class Ot implements Runnable {
    private PipedOutputStream outputStream;

    public Ot() {
        this.outputStream = new PipedOutputStream();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 9; i++) {
                this.outputStream.write(("sss\n").getBytes());

            }
            this.outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedOutputStream getStream() {
        return outputStream;
    }
}

class It implements Runnable {
    private PipedInputStream inputStream;

    public It() {
        this.inputStream = new PipedInputStream();
    }

    @Override
    public void run() {
        try {

            byte[] data = new byte[256];
            while (this.inputStream.read(data) != -1) {
                System.out.println(new String(data));
            }

            this.inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedInputStream getStream() {
        return inputStream;
    }
}

public class PipeStream {
    public static void main(String[] args) throws IOException {
        Ot ot = new Ot();
        It it = new It();
        ot.getStream().connect(it.getStream()); // 管道连接
        new Thread(ot).start();
        new Thread(it).start();
    }
}
