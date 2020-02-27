package com.effective.memory;

/**
 * @author Yulin.Wang
 * @date 2019/11/28
 * @description 克隆以及，深拷贝 浅拷贝相关
 * @see Object clone()
 */

public class CopyDemo {
    static class Member implements Cloneable {
        private String name;

        public Member(String name) {
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) throws Exception {
        Member a = new Member("sadas");
        Member b = (Member) a.clone();
        System.out.println(a.name);
        System.out.println(b.name);
    }

}
