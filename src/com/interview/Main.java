package com.interview;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static void main(String[] args) {
        var ages = new ArrayList<Integer>();
        Collections.addAll(ages, 7, 14, 23, 11, 49, 49);
        ages.removeIf(age -> age >= 40);
        System.out.println(ages.stream().mapToInt(Integer::intValue).sum());


        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 7, 14, 23, 11, 49, 49);
        int[] a = list.stream().mapToInt(Integer::intValue).toArray();
        AtomicBoolean b = new AtomicBoolean();
    }

}
