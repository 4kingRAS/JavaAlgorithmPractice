package com.kkkk.adt;

import java.util.ArrayList;

/**
 * @author      Yulin.Wang
 * @date        2019-03-02
 * @description abstract data structure linklist implement with cursor
 * @see         java.util.LinkedList
 * @param       <E> type of the Element in this LinkedList.
 **/

//TODO: finish insert remove

public class LinkedListInCursor<E> {

    private static final int CUR_SIZE = 100;
    public ArrayList<Node<E>> curSpace;


    /**
     * 没有泛型数组，用ArrayList分配游标空间。  curSpace[0] as head
     * */
    public LinkedListInCursor() {
        //  curSpace = new Node[CUR_SIZE]; cant do it
        curSpace = new ArrayList<>();
        for (int i = 0; i < CUR_SIZE; i++) {
            Node<E> t = new Node<E>(i, null, i+1);
            curSpace.add(t);
        }
        curSpace.get(CUR_SIZE - 1).next = 0;
    }

    public int alloc() {
        int pos;
        pos = curSpace.get(0).next;
        curSpace.get(0).next = curSpace.get(pos).next;
        return pos;
    }

    public void free(int pos) {
        curSpace.get(pos).next = curSpace.get(0).next;
        curSpace.get(0).next = pos;
    }

    private static class Node<E> {
        E element;
        int next;
        int prev;

        Node(int next, E element, int prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    //end of this class
}
