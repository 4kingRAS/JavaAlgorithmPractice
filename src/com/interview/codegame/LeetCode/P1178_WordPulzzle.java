package com.interview.codegame.leetCode;

import java.util.*;

/**
 * @author Yulin.Wang
 * @date 2019-09-07
 * @description s
 */
//TODO:

public class P1178_WordPulzzle {

    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> l = new ArrayList<>();
        int wlen  = words.length;

        // zip
        String[] zip = new String[wlen];
        for (int i = 0; i < wlen; i++) {
            char[] w = words[i].toCharArray();
            String t = "" + w[0];
            for (int j = 1; j < w.length; j++) {
                if (!t.contains(String.valueOf(w[j]))) {
                    t = t + w[j];
                }
            }
            zip[i] = t;
        }


        for (int i = 0; i < puzzles.length; i++) {
            char[] p = puzzles[i].toCharArray();
            int ans = 0;

            for (int j = 0; j < wlen; j++) {

                char[] w = zip[j].toCharArray();
                boolean isAns = false;
                for (int k = 0; k < w.length; k++) {
                    if (p[0] == w[k]) {
                        isAns = true;
                        break;
                    }
                }
                if (isAns) {
                    int c = 1;
                    for (int k = 1; k < p.length; k++) {
                        boolean isCtn = false;
                        for (int m = 0; m < w.length; m++) {
                            if (p[k] == w[m]) {
                                isCtn = true;
                                break;
                            }
                        }
                        if (isCtn) c++;
                    }
                    if (c == w.length) ans++;
                }

            }

            l.add(ans);
        }

        return l;
    }

    public static void main(String[] args) {
        String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};

        List<Integer> l = findNumOfValidWords(words, puzzles);
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }

}
