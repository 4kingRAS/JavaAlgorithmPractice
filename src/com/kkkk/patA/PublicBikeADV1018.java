package com.kkkk.patA;

import java.util.*;

/**
 * @author Yulin.Wang
 * @date 2019-07-28
 * @description
 **/
//TODO:

public class PublicBikeADV1018 {

    final int inf = 99999;

    int c;
    int n;
    int sp;
    int edge;

    int[][] m;
    int[] cap;
    boolean[] visit;

    List<Integer> pre;
    List<Integer> path, temp;

    public int dijkstra(int s) {
        int[] d = new int[n+1];
        int min = inf;
        int unreachable = -1;  // if s cant connect others
        Arrays.fill(d, inf);
        d[s] = 0;

        for (int i = 0; i <= n; i++) {

        }
        return  0;
    }

    public void init() {

        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt(); // 0 is PBMC, NODE start from 1 to n
        sp = sc.nextInt();
        edge = sc.nextInt();

        m = new int[n+1][n+1];
        cap = new int[n+1];
        visit = new boolean[n+1];
        Arrays.fill(visit, false);
        pre = new ArrayList<>();
        temp = new ArrayList<>();
        path = new ArrayList<>();

        for (int i = 1; i < n+1; i++) {
            cap[i] = sc.nextInt();
        }

        for (int i = 0; i < edge; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            m[s][e] = sc.nextInt();
            m[e][s] = m[s][e];
        }
    }


    public static void main(String[] args) {

        PublicBikeADV1018 p = new PublicBikeADV1018();
        p.init();

    }

}
