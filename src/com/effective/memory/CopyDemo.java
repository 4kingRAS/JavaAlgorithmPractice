package com.effective.memory;

import com.interview.algorithm.list.Node;

/**
 * @author Yulin.Wang
 * @date 2019/11/28
 * @description 克隆以及，深拷贝 浅拷贝相关
 *
 *
 *
 *
 *
 * @see Object clone()
 */

public class CopyDemo {


    public static void main(String[] args)  {
        int c = 1;
        int d = c;
        d = 2;
        Node<String> a = new Node<>("AAA", null);
        Node<String> b = a;

        b.setValue("ccc");
        System.out.println(a.getValue());
        System.out.println(b.getValue());
        System.out.println(c + "\n" +d);

    }

}
