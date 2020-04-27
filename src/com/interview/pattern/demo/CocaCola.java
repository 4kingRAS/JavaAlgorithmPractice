package com.interview.pattern.demo;

/**
 * @author Yulin.Wang
 * @date 2020/2/16
 * @description immutable object with builder
 */

public class CocaCola {
    private final double size;
    private final double price;
    private final int sugar;
    private final int water;
    private final int sodium;
    private final double caffeine;
    public static class Builder {
        private double size;
        private double price;
        private int sugar;
        private int water;
        private int sodium;
        private double caffeine;

        public Builder(double size, double price) {
            this.size = size;
            this.price = price;
        }

        public Builder sugar(int val) {
            this.sugar = val;
            return this;
        }
        public Builder water(int val) {
            this.water = val;
            return this;
        }
        public Builder sodium(int val) {
            this.sodium = val;
            return this;
        }
        public Builder caffeine(double val) {
            this.caffeine = val;
            return this;
        }
        public CocaCola build() {
            return new CocaCola(this);
        }
    }

    private CocaCola(Builder builder) { // 利用内部类可见性
        this.size = builder.size;
        this.price = builder.price;
        this.sugar = builder.sugar;
        this.water = builder.water;
        this.sodium = builder.sodium;
        this.caffeine = builder.caffeine;
    }
}
