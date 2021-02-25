package com.interview;

/**
 * @Author Yulin.Wang
 * @Date 2019-02-25
 * @Description
 **/

public class Utils {
    /**
     * usage: z = swap(a, a=b, b=c, ... y=z);
     *
     * JAVA没有指针，用swap

    public <T> T swap(T... args) {
        return args[0];
    }
    */

    public static void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.println();
    }

//    public static <T> T[] copyOfRange(T[], int begin, int end) {
//
//    }

}
