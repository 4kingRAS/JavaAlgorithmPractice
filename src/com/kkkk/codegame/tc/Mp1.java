package com.kkkk.codegame.tc;

import java.util.Arrays;

/**
 * @author Yulin.Wang
 * @date 2019-09-06
 * @description s
 **/
//TODO:

public class Mp1 {
    /**
     * https://www.nowcoder.com/question/next?pid=15241156&qid=325931&tid=27180756
     */

    static int solution(int[] prices, int budget) {
        Arrays.sort(prices);

        int remain = budget;
        int sum = 0;
        if (budget < prices[0]) return -1;
        for (int i = prices.length - 1; i >= 0; i--) {
            sum += remain / prices[i];
            remain = remain % prices[i];
        }
        if (remain > 0) return -1;
        return sum;
    }

    public static void main(String[] args) {
        int[] p = {500,200,100};
        int b = 900;
        int res = solution(p, b);
        System.out.println(res);

    }
}
