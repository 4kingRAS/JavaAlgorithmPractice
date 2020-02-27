package com.interview.codegame.codeWar;

public class NthSeries {
    /**
    SeriesSum(1) => 1 = "1.00"
    SeriesSum(2) => 1 + 1/4 = "1.25"
    SeriesSum(5) => 1 + 1/4 + 1/7 + 1/10 + 1/13 = "1.57"
     **/
    public static String seriesSum(int n) {
        if (n == 0) return "0.00";
        double sum = 0.00f;
        for (int i = 0; i < n; i++) {
            sum += 1f/(1+i*3);
        }
        return String.format("%.2f", sum);
    }

    public static void main(String[] args) {
        System.out.println(seriesSum(1));
    }

}
