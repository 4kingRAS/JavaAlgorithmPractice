package com.interview.codegame.tc;

import java.util.HashMap;

/**
 * @author Yulin.Wang
 * @date 2019/9/15
 * @description s
 */
//TODO:

public class VIP2 {

    static class LFU {
        int capacity;
        int pKey = 0;
        int[][] freq;
        HashMap<Integer, Integer> map;
        LFU(int cache) {
            capacity = cache;
            map = new HashMap<>();
            freq = new int[cache][2]; // [frequency , key]
        }

        void set(int key, int value) {
            if (map.size() < capacity) {
                map.put(key, value);
                freq[pKey][0] = 0;
                freq[pKey][1] = key;
                pKey++;
            } else {
                int min = freq[0][0];
                pKey = freq[0][1];
                for (int i = 1; i < capacity; i++) {
                    if (freq[i][0] < min) {
                        min = freq[i][0];
                        pKey = i;
                    }
                }
                map.remove(freq[pKey][1]);
                map.put(key, value);
                freq[pKey][0] = 0;
                freq[pKey][1] = key;
            }
        }

        int get(int key) {
            for (int i = 0; i < capacity; i++) {

            }
            return map.get(key);
        }

    }

    public static void main(String[] args) {
        Object o;
    }

}
