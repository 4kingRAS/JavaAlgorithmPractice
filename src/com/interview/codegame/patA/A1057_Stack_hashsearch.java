package com.interview.codegame.patA;

import java.util.Scanner;
import java.util.Stack;
/**
 * @author Yulin.Wang
 * @date 2019-08-30
 * @description s
 **/
//TODO:

public class A1057_Stack_hashsearch {

    private static final int SQRTN = 316;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Stack<Integer> s = new Stack<>();
        int[] hash = new int[100001];
        int[] block = new int[SQRTN]; // sqrt(100001)

        for (int i = 0; i < n; i++) {
            String cmd = sc.nextLine();

            int x = 0;
            if (cmd.contains(" ")) {
                String[] t = cmd.split(" ");
                x = Integer.parseInt(t[1]);
                s.push(x);
                block[x / SQRTN]++;
                hash[x]++;
            } else {
                if (cmd.equals("Pop")) {
                    if (s.empty()) {
                        System.out.println("Invalid");
                        continue;
                    }
                    x = s.pop();
                    block[x / SQRTN]--;
                    hash[x]--;
                    System.out.println(x);
                }

                if (cmd.equals("PeekMedian")) {
                    if (s.empty()) {
                        System.out.println("Invalid");
                        continue;
                    }
                    int k = (s.size() % 2 == 0) ? s.size() / 2 : (s.size() + 1) / 2;
                    int sum = 0;
                    int id = 0;
                    while (sum + block[id] < k) { // 找到对应block
                        sum += block[id++];
                    }

                    int num = id * SQRTN;
                    while (sum + hash[num] < k) {
                        sum += hash[num++];
                    }
                    System.out.println(num);
                }
            }

        }

    }

}
