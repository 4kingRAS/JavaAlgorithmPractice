package com.interview.datastructure.tree;

import java.util.*;

/**
 * @author Yulin.Wang
 * @date created at 2019/9/19,  last modified at 2021/03/02
 * @description  Tree 自制轮子
 *               造树： 从左到右，从上到下，可填充空
 */
//TODO:

public class BinaryTree<E> {
    static class Node<E> {
        Node<E> left;
        Node<E> right;
        E data;

        public Node() {}

        public Node(E data) {
            this.data = data;
        }

        public Node(E data, Node<E> left, Node<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    private int size = 0;
    private int height = 0;
    private Node<E> root;


    public BinaryTree(Node<E> root) {
        this.root = root;
        size++;
        height++;
    }
    public BinaryTree() {
    }

    /**
     * @param list node list
     * @return binary tree build by list with level order.
     */
    public BinaryTree<E> build(List<E> list) {
        if (list == null || list.size() == 0) {
            return null;
        }

        E item = list.get(0);
        this.root = new Node<>(item);
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);                            // 创建队列
        size++;

        int index = 1;                              //记录元素个数
        while (!queue.isEmpty()) {
            Node<E> node = queue.remove();          //取队列头

            if (index == list.size()) { break; }    // 取完退出循环
            item = list.get(index++);               // 左子树
            if (item != null) {
                node.left = new Node<>(item);
                queue.add(node.left);
                size++;
            }

            if (index == list.size()) { break; }    // 取完退出循环
            item = list.get(index++);               // 右子树
            if (item != null) {
                node.right = new Node<>(item);
                queue.add(node.right);
                size++;
            }

        }
        return this;
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

    private List<E> traversePreOrder(Node<E> root) {
        ArrayList<E> list = new ArrayList<>();
        visit(list, root);
        return list;
    }

    private void visit(List<E> list, Node<E> e) {
        if (e == null) return;
        list.add(e.data);
        visit(list, e.left);
        visit(list, e.right);
    }

    private List<E>  traversePreOrderIteration(Node<E> root) {
        ArrayList<E> list = new ArrayList<>();
        Stack<Node<E>> s = new Stack<>();
        Node<E> x = root;
        while (true) {
            while (x.data != null) {
                list.add(x.data);
                s.push(x.right);
                x = x.left;
            }
            if (s.isEmpty()) {
                break;
            }
            x = s.pop();
        }
        return list;
    }

    private List<E> traverseLevelOrder(Node<E> root) {
        ArrayList<E> list = new ArrayList<>();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);                // 首先入队 root

        while (!queue.isEmpty()) {      // 队列为空结束
            Node<E> n = queue.poll();   // 取队首
            list.add(n.data);
            if (n.left != null) {       // 加入左
                queue.add(n.left);
            }
            if (n.right != null) {      // 加入右
                queue.add(n.right);
            }
        }

        return list;
    }

    public boolean isBalanced(Node root) {
        return calcBalanced(root) != -1;
    }

    private int calcBalanced(Node root) {
        if (root == null) return 0;

        int ld = calcBalanced(root.left);
        int rd = calcBalanced(root.right);
        if (ld == -1 || rd == -1) {
            return -1;
        }
        return Math.abs(ld - rd) < 2 ? Math.max(ld, rd) + 1 : -1;
    }

    /**
     * ------------------------tester-----------------------------
     */
    public static void main(String[] args) {
        List<Integer> t = List.of(1, 2, 3, 2131, 213, 11, 56);

        BinaryTree<Integer> tree = new BinaryTree<>();
        tree = tree.build(t);
        System.out.println(tree.size);

        System.out.println(tree.traversePreOrder(tree.getRoot()));
    }
}
