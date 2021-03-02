package com.interview;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Main {

    public static void main(String[] args) {
        String s = "[IMEI:231221]";
        String kv = s.substring(1, s.length() - 1);
        System.out.println(kv.split(":")[0]);
        CopyOnWriteArraySet<String> a = new CopyOnWriteArraySet<>();
        a.add("123121");
        a.add("123121333");
        a.add("23");
        a.add("23");
        a.add("123121333");
        System.out.println(a.toString());

    }

    public static ArrayList<String> JSONtoList(JSONObject json) {
        ArrayList<String> list = new ArrayList<>();
        JSONArray ja = JSON.parseArray(json.toJSONString());
        for (int i = 0; i < ja.size(); i++) {
            list.add((String) ja.get(i));
        }
        return list;
    }

}
