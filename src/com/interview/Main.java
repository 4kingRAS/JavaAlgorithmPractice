package com.interview;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        JSONObject a = new JSONObject();
        a.put("a","s");
        a.put("b","1s");
        a.put("c","2s");
        System.out.println(a.toJSONString());

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
