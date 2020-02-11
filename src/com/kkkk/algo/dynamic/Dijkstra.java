package com.kkkk.algo.dynamic;

import com.kkkk.Utils;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Yulin.Wang
 * @date 2019-09-08
 * @description s
 */
//TODO:

public class Dijkstra {

    static final int INF = 999999;

    /**
     * @param start 起点
     * @param node  节点数
     * @param map   地图 必须初始化为INF
     * @param _INF  INF
     * @param pre   每个点的最短前驱
     * @return d[i] = s到i最短路径长度
     */
    public static int[] dijkstra(int start, int node, int[][] map, int _INF, Stack<Integer>[] pre) {
        boolean[] vis = new boolean[node + 1];
        int[] d = new int[node + 1];
        Arrays.fill(vis, false);
        Arrays.fill(d, _INF);
        d[start] = 0;

        for (int i = 1; i <= node; i++) {

            int min = _INF, u = -1;
            for (int j = 1; j <= node; j++) {
                if (!vis[j] && d[j] < min) {
                    u = j;
                    min = d[j];
                }
            }

            vis[u] = true;
            for (int v = 1; v <= node; v++) {
                if (!vis[v] && map[u][v] != _INF) { // 不搜索不连通和已访问的点
                    int cur = d[u] + map[u][v];
                    if (d[v] > cur) {
                        d[v] = cur;
                        pre[v].clear();
                        pre[v].push(u);
                    } else if (cur == d[v]) {
                        pre[v].push(u);        //生成多个路径
                    }
                }
            }

        }

        return d;
    }

    public static void main(String[] args) {
        final int NODES = 5;
        int[][] map = new int[NODES + 1][NODES + 1];
        String[] list = {"1 2 2", "1 3 3", "1 4 1", "2 5 1",
                        "3 5 1", "3 4 1", "4 5 3"};
        for (int i = 0; i <= NODES; i++) {
            Arrays.fill(map[i], INF);
        }


        for (int i = 0; i < list.length; i++) {
            String[] ss = list[i].split(" ");
            int s = Integer.parseInt(ss[0]);
            int e = Integer.parseInt(ss[1]);
            map[s][e] = Integer.parseInt(ss[2]);
            map[e][s] = map[s][e];
        }

        Stack<Integer>[] pre = (Stack<Integer>[]) new Stack[NODES + 1];
        for (int i = 0; i <= NODES; i++) {
            pre[i] = new Stack<>();
        }

        int[] dis = dijkstra(1, NODES, map, INF, pre);
        Utils.printArray(dis);
        for (int i = 1; i < pre.length; i++) {
            System.out.println();
            while (!pre[i].empty()) {
                int a = pre[i].pop();
                System.out.printf("%d ", a);
            }
        }



    }
}
