package com.kkkk.patB;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019-08-29
 * @description s
 **/
//TODO:

public class B1035_InsertNMerge {

    int[] t;
    boolean isInsertion = true;

    static boolean compareArray(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) { return false; }
        }
        return true;
    }

    void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            boolean f = (i != 1) && compareArray(a, t);
            int j = i, t = a[i];
            while (j > 0 && a[j - 1] > t) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = t;
            if (f) {
                System.out.print("Insertion Sort");
                System.out.println();
                for (int k = 0; k < a.length; k++) {
                    System.out.print(a[k]);
                    if (k != a.length - 1) System.out.print(" ");
                }
                return;
            }
        }
    }

    void mergeSort(int[] a) {
        boolean f = false;
        for (int i = 2; i / 2 <= a.length; i *= 2) {
            if(i != 2 && compareArray(a, t)) {
                f = true;
            }

            for (int j = 0; j < a.length; j+=i) {
                Arrays.sort(a, j, Math.min(j+i, a.length));
            }

            if (f) {
                isInsertion = false;
                System.out.print("Merge Sort");
                System.out.println();
                for (int k = 0; k < a.length; k++) {
                    System.out.print(a[k]);
                    if (k != a.length - 1) System.out.print(" ");
                }
                return;
            }

        }

    }

    public static void main(String[] args) {
        B1035_InsertNMerge b = new B1035_InsertNMerge();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] a = new int[n];
        int[] tp = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            tp[i] = a[i];
        }

        b.t = new int[n];
        for (int i = 0; i < n; i++) {
            b.t[i] = sc.nextInt();
        }

        b.mergeSort(a);
        if (b.isInsertion) {
            b.insertionSort(tp);
        }
    }

}
