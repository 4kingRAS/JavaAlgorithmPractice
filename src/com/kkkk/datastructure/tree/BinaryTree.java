package com.kkkk.datastructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

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

        public Node(Node<E> parent, E data) {
            this.parent = parent;
            this.data = data;
        }
    }
    protected int size;
    protected int height;
    private Node<E> root;
    protected enum ORDER{ PRE, IN, POST, BREADTH, DEPTH }
    protected ArrayList<E> list = new ArrayList<>();
    private Node<E> current;

    public BinaryTree(Node<E> root) {
        this.root = root;
        current = root;
    }

    public void buildTree(ArrayList<E> list) {
        int cur = 0;
        insert(list, root, null, cur);
    }

    public int insert(ArrayList<E> list, Node<E> n, Node<E> p, int cur) {
        if (cur < list.size()) {
            E e = list.get(cur);
            cur++;
            if (e != null) {
                n.data = e;
                size++;
                current = n;
                n.leftChild = new Node<>(n, null);
                n.rightChild = new Node<>(n, null);
                cur = insert(list, n.leftChild, n, cur);
                cur = insert(list, n.rightChild, n, cur);
            }
        }
        return cur;
    }

//    public void insertLeft(Node<E> n, E e) {
//        size++;
//        n.insertLeft(e);
//        height = updateHeight(n);
//    }
//
//    public void insertRight(Node<E> n, E e) {
//        size++;
//        n.insertRight(e);
//        height = updateHeight(n);
//    }

    public int getSize() {
        return size;
    }

    public boolean empty() {
        return root == null;
    }

    public Node<E> getRoot() {
        return root;
    }

    public ArrayList<E> getList() {
        return list;
    }

//    public int updateNodeHeight(Node<E> e) {
//        if (e == null) {
//            return 0;
//        } else {
//            return e.height = 1 + Math.max(
//                    (e.leftChild == null) ? 0 : 1 ,
//                    (e.rightChild == null) ? 0 : 1);
//        }
//    }
//
//    public int updateHeight(Node<E> e) {
//        height = 0;
//        while (e != null) {
//            height += updateNodeHeight(e);
//            e = e.parent;
//        }
//        return height;
//    }

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
        Integer[] a = {1, 3, null, null, 32, null, 6, 0, 65};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a));
        BinaryTree<Integer> tree = new BinaryTree<>(new Node<Integer>(null, 0));
        tree.buildTree(list);
        tree.traverse(ORDER.PRE);
        System.out.println("BinaryTree[ size: " + tree.getSize() + " height:]");
        System.out.println(tree.list);
    }

}
