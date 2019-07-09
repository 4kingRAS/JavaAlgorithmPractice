package com.kkkk.patB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019-07-09
 * @description pat 乙级反转链表，java没有指针类型，实现存取很复杂，要用hashmap
 **/

//Tips:

/*
LinkedList<E>

        get(int index) is O(n)
        add(E element) is O(1)
        add(int index, E element) is O(n)
        remove(int index) is O(n)
        Iterator.remove() is O(1) <--- main benefit of LinkedList<E>
        ListIterator.add(E element) is O(1) <--- main benefit of LinkedList<E>

ArrayList<E>

        get(int index) is O(1) <--- main benefit of ArrayList<E>
        add(E element) is O(1) amortized, but O(n) worst-case since the array must be resized and copied
        add(int index, E element) is O(n - index) amortized, but O(n) worst-case (as above)
        remove(int index) is O(n - index) (i.e. removing last is O(1))
        Iterator.remove() is O(n - index)
        ListIterator.add(E element) is O(n - index)
*/

public class ReverseLinkedList {
    private static class Node<E> {
        E data;
        E next;
        E addr;

        Node(E data, E next, E addr) {
            this.data = data;
            this.next = next;
            this.addr = addr;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        String a[] = line.split(" ");
        String first = a[0];
        int sum = Integer.valueOf(a[1]);
        int k = Integer.valueOf(a[2]);
        ArrayList<Node> ll = new ArrayList<Node>();

        int c = sum;
        HashMap<String, Node<String>> map = new HashMap<String, Node<String>>();
        while (c != 0){
            line = sc.nextLine().trim();
            String t[] = line.split(" ");

            map.put(t[0], new Node<String>(t[1], t[2], t[0]));
            c--;
        }
        sc.close();

        Node<String> p = null;
        while (!first.equals("-1")) {
            c++;
            Node<String> n = map.get(first);
            first = n.next;
            p = n;
            if (c > 1) {
                n.next = p.addr;
            }
        }

        //out
        for (int i = 0; i<ll.size()-1; i++){
            String str = ""+ll.get(i).address;
            String str2 = ""+ll.get(i+1).address;
            while(str.length() < 5)
                str = "0"+str;
            while(str2.length() < 5)
                str2 = "0"+str2;
            System.out.println(str + " " + ll.get(i).val + " " + str2);
        }
        String str = ""+ll.get(ll.size()-1).address;
        while(str.length() < 5)
            str = "0"+str;
        System.out.println(str + " " + ll.get(ll.size()-1).val + " -1");

    }

}
