package com.interview.jdk;

/**
 * @author Yulin.Wang
 * @date 2019/11/25
 * @description 实现资源自动关闭的接口，1.实现AutoCloseable  2.需要结合异常处理实现自动关闭
 * @see AutoCloseable
 */

interface IMessage extends AutoCloseable{
    public void send();
}

public class AutoCloseDemo {
    static class Message implements IMessage{
        private String msg;

        public Message(String msg) {
            this.msg = msg;
        }

        @Override
        public void send() {
            if (this.open()) {
                System.out.println("send " + msg);
            }
        }

        public boolean open() {
            System.out.println("GET RESOURCE");
            return true;
        }

        @Override
        public void close() throws Exception {
            System.out.println("close RESOURCE");
        }

    }
    public static void main(String[] args) throws Exception {
        try (Message message = new Message("ssss")) {
            message.send();
        } catch (Exception e ) {   // 结合异常处理后可以实现自动关闭
            e.printStackTrace();
        }
    }
}
