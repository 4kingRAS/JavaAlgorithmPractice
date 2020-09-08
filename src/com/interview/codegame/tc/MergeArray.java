package com.interview.codegame.tc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Yulin.Wang
 * @date 2020/5/19
 * @description 题目示例可能有误，我是按（key1 == key1 and key2 == key2）写的
 *              题目没说是否有序，假设无序，则给proB.key1创建hashmap，value里用arraylist存放key1相同的proB
 *              创建索引 Om, 查找 约等于 On，总的时间复杂度O n+m
 *              空间复杂度需要创建一个proB的hash表
 */

class ProA {
    String key1;
    String key2;
    String v1;

    public ProA(String key1, String key2, String v1) {
        this.key1 = key1;
        this.key2 = key2;
        this.v1 = v1;
    }
}

class ProB {
    String key1;
    String key2;
    String v2;

    public ProB(String key1, String key2, String v2) {
        this.key1 = key1;
        this.key2 = key2;
        this.v2 = v2;
    }
}

class MergedAB {
    String key1;
    String key2;
    String v1;
    String v2;

    public MergedAB(String key1, String key2, String v1, String v2) {
        this.key1 = key1;
        this.key2 = key2;
        this.v1 = v1;
        this.v2 = v2;
    }
}

public class MergeArray {

    public static MergedAB[] merge(ProA[] arrProA, ProB[] arrProB) {
        if (arrProA == null || arrProB == null) {
            return null;
        }

        List<MergedAB> mergedABList = new ArrayList<>();
        HashMap<String, List<ProB>> hashMap = new HashMap<>();
        for (ProB b : arrProB) {                        //O m
            List<ProB> list;
            if (hashMap.containsKey(b.key1)) {
                list = hashMap.get(b.key1);
            } else {
                list = new ArrayList<>();
            }
            list.add(b);
            hashMap.put(b.key1, list);
        }

        for (ProA a : arrProA) {                        // O n
            if (hashMap.containsKey(a.key1)) {
                List<ProB> list = hashMap.get(a.key1);      // O 1

                for (ProB b : list) {                       // ~= O 1
                    if (b.key2.equals(a.key2)) {
                        MergedAB m = new MergedAB(a.key1, a.key2, a.v1, b.v2);
                        mergedABList.add(m);
                    }
                }
            }
        }

        MergedAB[] arr = new MergedAB[mergedABList.size()];
        for (int i = 0; i < mergedABList.size(); i++) {
            arr[i] = mergedABList.get(i);
        }

        return arr;
    }

    public static void main(String[] args) {
        ProA[] a = {
                new ProA("alice", "bob", "11"),
                new ProA("hlce", "box", "11"),
                new ProA("alice", "bob", "222"),
                new ProA("312ce", "box", "11"),
                new ProA("bob", "bob", "11"),
        };

        ProB[] b = {
                new ProB("alice", "bob", "22"),
                new ProB("hlce", "box", "2222"),
                new ProB("Alice", "bob", "333"),
                new ProB("312ce", "bos", "11"),
                new ProB("alice", "bob", "33"),
        };

        MergedAB[] arr = merge(a, b);
        for (MergedAB m : arr) {
            System.out.printf("%s %s %s %s\n", m.key1, m.key2, m.v1, m.v2);
        }
    }

}
