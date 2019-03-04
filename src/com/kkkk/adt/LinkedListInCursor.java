package com.kkkk.adt;

/**
 * @author      Yulin.Wang
 * @date        2019-03-02
 * @description abstract data structure linklist implement with cursor
 * @see         java.util.LinkedList
 * @param       <E> type of the Element in this LinkedList.
 **/

//TODO: finish insert remove

public class LinkedListInCursor<E> {

    static int position;
    Node<E>[] cursorSpace;

    public LinkedListInCursor() {

    }




    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> next, E element, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }




    //end of this class
}
