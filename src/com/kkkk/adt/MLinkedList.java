package com.kkkk.adt;

/**
 * @author      Yulin.Wang
 * @date        2019-03-04
 * @description
 * @see         java.util.LinkedList
 * @param       <E> type of the Element in this MLinkedList
 **/
//TODO:

public class MLinkedList<E> {

    Node<E> head = null;
    Node<E> tail = null;
    transient int size = 0;  // transient : turn off the serialization

    public MLinkedList() {
        //make empty list
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(E e) {
        if (head == null) {
            head = new Node<>(null, e, null);
            tail = head;
        }
        tail = new Node<>(null, e, tail);
        size++;
    }

    public void remove(Node<E> node) {
        node.prev.next = null;
        tail = node.prev;
        size--;
    }

    public void put(Node<E> node) {
        //
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

}
