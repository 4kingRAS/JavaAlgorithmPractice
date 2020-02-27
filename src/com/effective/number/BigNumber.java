package com.effective.number;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * @author Yulin.Wang
 * @date 2019/11/30
 * @description 大数据处理类
 * @see java.math.BigInteger
 * @see java.math.BigDecimal
 */

public class BigNumber {

    public static double round(double num, int scale) {
        // half up  0.5 向上进位
        return new BigDecimal(num).divide(new BigDecimal(1.0), scale, RoundingMode.HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        BigInteger a = new BigInteger("12312124354");
        BigDecimal b = new BigDecimal("129078.34534");
        System.out.println(a.intValue()); // overflow
        System.out.println(round(123.32567, 3));

    }
}
