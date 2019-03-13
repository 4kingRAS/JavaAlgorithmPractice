package com.kkkk.adt;

/**
 * @author      Yulin.Wang
 * @date        2019-03-04
 * @description
 * @see         java.util.LinkedList
 * @param       <E> type of the Element in this LinkedList
 **/
//TODO:

public class LinkedList<E> {

    public LinkedList() {

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

}
