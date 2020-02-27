package com.effective.number;

/**
 * @author Yulin.Wang
 * @date 2020/2/16
 * @description
 */

public class BitOperation {
    /**
     * @param b byte
     * @param
     * @return Rotate left shift
     */
    public byte rol(byte b, byte offset) {
        if (offset < 0) {
            return b;
        }
        return (byte) (b << offset | b >> (8 - offset));
    }

    public static void main(String[] args) {
        byte a = 0b1000001;
        System.out.println(a);
    }
}
