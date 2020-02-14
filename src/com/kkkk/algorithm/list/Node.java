package com.kkkk.algorithm.list;

/**
 * @author Yulin.Wang
 * @date 2020/2/13
 * @description
 */

public class Node<E> {
    private final E value;
    private Node<E> next;

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
