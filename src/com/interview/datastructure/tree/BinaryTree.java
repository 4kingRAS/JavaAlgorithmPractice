package com.interview.datastructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Yulin.Wang
 * @date created at 2019/9/19,  last modified at 2021/03/02
 * @description  Tree 自制轮子
 *               造树： 从左到右，从上到下，可填充空
 */
//TODO:

public class BinaryTree<E> {
    static class Node<E> {
        Node<E> parent;
        Node<E> leftChild;
        Node<E> rightChild;
        E data;

        public Node(Node<E> parent, E data) {
            this.parent = parent;
            this.data = data;
        }
    }
    protected int size = 0;
    protected int height = 0;
    private final Node<E> root;
    protected enum ORDER{ PRE, IN, POST, BREADTH, DEPTH }

    public BinaryTree(Node<E> root) {
        this.root = root;
        size++;
        height++;
    }

    public BinaryTree() {
        this.root = null;
    }

    public int getSize() {
        return this.size;
    }

    public boolean empty() {
        return this.root == null;
    }

    public Node<E> getRoot() {
        return this.root;
    }

    public List<E> traverse(ORDER order) {
        List<E> list = new ArrayList<>();
        switch (order) {
            case PRE:
                traversePreOrderIteration(list, this.root);
                break;
            default:
                traversePreOrder(list, this.root);
        }
        return list;
    }

    private void traversePreOrder(List<E> list, Node<E> e) {
        if (e == null) return;
        list.add(e.data);
        traversePreOrder(list, e.leftChild);
        traversePreOrder(list, e.rightChild);
    }

    private List<E>  traversePreOrderIteration(List<E> list, Node<E> root) {
        Stack<Node<E>> s = new Stack<>();
        Node<E> x = root;
        while (true) {
            s = goDownLeft(list, s, x);
            if (s.isEmpty()) {
                break;
            }
            x = s.pop();
        }
        return list;
    }

    private Stack<Node<E>> goDownLeft(List<E> list, Stack<Node<E>> s, Node<E> x) {
        while (x.data != null) {
            list.add(x.data);
            s.push(x.rightChild);
            x = x.leftChild;
        }
        return s;
    }

    public static void main(String[] args) {

    }

}
