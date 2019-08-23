package com.kkkk;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char[] t = {'A', 'B', 'C', 'D', 'E', 'F'};
        String[] out = new String[259];

        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        String in = sc.nextLine();

        char[] s = in.toCharArray();

        int l = 0;
        for (int i = 0; i < len - 1; i++) {
            Byte c = sc.nextByte();
            if (c == ' ') {
                l++;
                continue;
            }
            if (c == 'A')
            {
                out[l++] = String.valueOf(12);
                out[l] = String.valueOf(34);
            }
            else if (c == 'B')
            {
                out[l++] = "AB";
                out[l] = "CD";
            }
            else {
                out[l] = "o";
            }
        }

        System.out.printf("%d ", l+1);
        for (int i = 0; i < l; i++) {

        }

    }


}
