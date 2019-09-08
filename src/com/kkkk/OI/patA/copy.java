package com.kkkk.OI.patA;

/**
 * @author Yulin.Wang
 * @date 2019-08-08
 * @description s
 **/
//TODO:

import java.util.*;
import java.io.*;

class edge{
    int v;
    int w;
    int t;
    public edge(int v,int w,int t){
        this.v=v;
        this.w=w;
        this.t=t;
    }
    public int other(int a){
        return v==a?w:v;
    }
}
public class copy{
    public static ArrayList<edge>[] adj;
    static int[] edgeTo;
    static int[] ins;
    static int sp;
    static int n;
    static boolean[] marked;
    static int[] times;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");
        int max=Integer.parseInt(str[0]);
        n=Integer.parseInt(str[1]);
        sp=Integer.parseInt(str[2]);
        int m=Integer.parseInt(str[3]);
        edgeTo=new int[n+1];
        ins=new int[n+1];
        marked=new boolean[n+1];
        times=new int[n+1];
        adj=(ArrayList<edge>[])new ArrayList[n+1];
        str=br.readLine().split(" ");
        adj[0]=new ArrayList<edge>();
        ins[0]=0;
        edgeTo[0]=0;
        times[0]=0;
        for(int i=1;i<=n;i++){
            ins[i]=max/2-Integer.parseInt(str[i-1]);
            adj[i]=new ArrayList<edge>();
            times[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<m;i++){
            str=br.readLine().split(" ");
            int v=Integer.parseInt(str[0]);
            int w=Integer.parseInt(str[1]);
            int t=Integer.parseInt(str[2]);
            edge e=new edge(v,w,t);
            adj[v].add(e);
            adj[w].add(e);
        }
        Dijktra(0);
        ArrayList<Integer> out=new ArrayList<Integer>();
        int temp=sp;
        while(edgeTo[temp]!=temp){
            out.add(temp);
            temp=edgeTo[temp];
        }
        out.add(0);
        System.out.print(Math.max(presum(sp), 0)+" ");
        temp=Math.max(presum(sp), 0);
        for(int i=out.size()-1;i>0;i--){
            int a=out.get(i);
            temp=temp-ins[a];
            System.out.print(a+"->");
        }
        System.out.print(sp+" ");
        System.out.print(temp-ins[sp]);

    }
    public static void Dijktra(int s){
        PriorityQueue<Integer> pq=new PriorityQueue<>(16,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return times[o1]-times[o2];
            }
        });
        pq.add(s);
        while(!pq.isEmpty()){
            int v=pq.poll();
            if(v==sp) return;
            marked[v]=true;
            for(edge e: adj[v]){
                int w=e.other(v);
                if(!marked[w]){
                    if(times[w]>(times[v]+e.t)){
                        times[w]=times[v]+e.t;
                        edgeTo[w]=v;
                    }else if(times[w]==(times[v]+e.t)){
                        int temp=edgeTo[w];
                        if(presum(temp)>presum(v)){
                            edgeTo[w]=v;
                        }
                    }
                    pq.add(w);
                }

            }
        }
    }
    public static int presum(int x){
        int temp=ins[x];
        while(edgeTo[x]!=x){
            x=edgeTo[x];
            if(temp<0&&ins[x]>0){
                temp=ins[x];
            }else{
                temp+=ins[x];
            }
        }
        return temp;
    }
}

