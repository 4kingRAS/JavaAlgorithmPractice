package com.kkkk.tc;

/**
 * @author Yulin.Wang
 * @date 2019-08-17
 * @description s
 **/
//TODO:
import java.util.Scanner;
import java.util.Stack;

//public class Main {
public class Tc1 {

    public int i = 0;
    char[] s;

    public String str() {
        String tp = "";
        String co = "";
        boolean isStr = false;
        while (true) {
            i++;
            if (s[i] == ']') break;
            if (s[i] == '[') {
                tp = tp + str();
                break;
            }

            if (isStr) tp = tp + s[i];
            if(s[i] != '|' && !isStr) {
                co = co + s[i];
            } else {
                isStr = true;
            }
        }

        return tp.repeat(Integer.valueOf(co));
    }

    public void init() {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        s = t.toCharArray();
        sc.close();

        i = 0;
        String p = "";
        while (i < t.length()){
            if (s[i] == '[') {
                p = p + str();
                i++;
            }
            p = p + s[i];
            i++;
        }

        System.out.println(p);
    }

    public static void main(String[] args) {
        Tc1 t = new Tc1();
        t.init();
    }
}
