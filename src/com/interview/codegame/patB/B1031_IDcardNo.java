package com.interview.codegame.patB;

import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019-08-29
 * @description s
 **/
//TODO:

public class B1031_IDcardNo {
    // only verified least 17 digit
    public static void main(String[] args) {
        final char[] tab = {'1', '0', 'X', '9', '8',
                            '7', '6', '5', '4', '3', '2'};

        // 17 digit * weight = z ,  z <--> x depend on tab
        final int[] weight = {7, 9, 10, 5, 8, 4, 2, 1, 6,
                                3, 7, 9, 10, 5, 8, 4, 2};
        boolean isAll = true;

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] ret = new String[n];
        for (int i = 0; i < n; i++) {
            ret[i] = sc.nextLine();
            char[] s = ret[i].toCharArray();
            int sum = 0;
            for (int j = 0; j < 17; j++) {
                sum += (s[j] - '0') * weight[j];
            }
            if (tab[sum % 11] != s[17]) {
                isAll = false;
            } else {
                ret[i] = "";
            }
        }
        if (isAll) {
            System.out.println("All passed");
        }
        for (int i = 0; i < n; i++) {
            if (!ret[i].equals("")) {
                System.out.println(ret[i]);
            }
        }

    }

}
