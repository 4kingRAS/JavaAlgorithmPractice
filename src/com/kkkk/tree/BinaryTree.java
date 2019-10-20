package com.kkkk.tree;

import java.util.ArrayList;

/**
 * @author Yulin.Wang
 * @date 2019/9/19
 * @description s
 */
//TODO:

public class BinaryTree<E> {
    static class Node<E> {
        Node<E> parent;
        Node<E> leftChild;
        Node<E> rightChild;
        E data;
        int height;

        public Node(E e, Node<E> parent) {
            this.data = e;
            this.parent = parent;
        }

        public int size() { // O(n)
            int s = 1;
            if (leftChild != null) s += leftChild.size();
            if (rightChild != null) s += rightChild.size();
            return s;
        }

        public Node<E> insertLeft(E e) {
            return this.leftChild = new Node<>(e, this);
        }

        public Node<E> insertRight(E e) {
            return this.rightChild = new Node<>(e, this);
        }
    }
    protected int size;
    protected Node<E> root;
    protected enum ORDER{ PRE, IN, POST, BREADTH, DEPTH }
    public ArrayList<E> list = new ArrayList<>();
    private Node<E> current;

    public void add(E e) {
        if (current == null) {
            current = root;
        }
        if (current.leftChild == null) {
            insertLeft(current, e);
        } else if (current.rightChild == null) {
            insertRight(current, e);
            if (current.parent.rightChild.leftChild == null) {
            //todo
                return;
            }
        }
    }

    public Node<E> insertLeft(Node<E> n, E e) {
        size++;
        n.insertLeft(e);
        updateHeight(n);
        return n.leftChild;
    }

    public Node<E> insertRight(Node<E> n, E e) {
        size++;
        n.insertRight(e);
        updateHeight(n);
        return n.rightChild;
    }

    public int getSize() {
        return size;
    }

    public boolean empty() {
        return root == null;
    }

    public Node<E> root() {
        return root;
    }

    public int updateNodeHeight(Node<E> e) {
        if (e == null) {
            return 0;
        } else {
            return e.height = 1 + Math.max(
                    (e.leftChild == null) ? 0 : 1 ,
                    (e.rightChild == null) ? 0 : 1);
        }
    }

    public void updateHeight(Node<E> e) {
        while (e != null) {
            updateNodeHeight(e);
            e = e.parent;
        }
    }

    public void traverse(ORDER order) {
        list.clear();
        switch (order) {
            case PRE:
            default:
                traversePreOrder(root);
        }
    }

    private void traversePreOrder(Node<E> e) {
        if (e == null) return;
        list.add(e.data);
        traversePreOrder(e.leftChild);
        traversePreOrder(e.rightChild);
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 534, 22, 32, 123, 6, 0, 65};
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = new Node<>(a[0], null);
        for (int i = 1; i < a.length; i++) {
            tree.add(a[i]);
        }
        tree.traverse(ORDER.PRE);
        System.out.println(tree.list);
    }

}
