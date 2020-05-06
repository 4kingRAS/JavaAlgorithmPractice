package com.interview;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        String key = sc.nextLine();

        int lk = key.length();
        int count = 0;
        for (String s : str) {
            if (key.equals(s)) {
                count++;
                continue;
            }
            while (s.contains(key)) {
                s = s.substring(0, s.lastIndexOf(key));
                count++;
            }
        }

        System.out.println(count);
        for (int i = str.length - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.print(str[i]);
                break;
            }
            System.out.printf("%s ", str[i]);
        }

    }

}
