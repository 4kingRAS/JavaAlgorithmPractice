package com.interview.codegame.LeetCode;

import java.util.HashMap;

/**
 * @author Yulin.Wang
 * @date 2021/6/15
 * @description   head -> new -> old -> tail
 */

public class P146_LRU {
    //extends LinkedHashMap<Integer, Integer>
    int capacity;
    int size;
    HashMap<Integer, DNode> map;
    DNode head = new DNode();     //dummy
    DNode tail = new DNode();

    class DNode {
        int key;
        int value;
        DNode prev;
        DNode next;

        public DNode() {}
        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public P146_LRU(int capacity) {
        //super(capacity, 0.75F, true);
        this.capacity = capacity;
        this.map = new HashMap<>();
        head.next = tail;
        tail.prev = head;               // make dummy nodes
    }

    public int get(int key) {
        DNode node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            System.out.println(node.value);
            return node.value;
        }

    }

    public void put(int key, int value) {
        DNode node = map.get(key);

        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            node = new DNode(key, value);
            size++;
            map.put(key, node);
            addToHead(node);
            if (size > capacity) {
                removeTail();
                size--;
            }
        }

        System.out.println(map.toString());
    }

    private void addToHead(DNode node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    private void moveToHead(DNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DNode node) {
        // with dummy nodes, no need check null
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private int removeTail() {
        // Capacity full remove tail node
        DNode node = tail.prev;
        removeNode(node);
        map.remove(node.key, node);
        return node.key;
    }

    /* use LinkedHashMap
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
     */

    public static void main(String[] args) {
        P146_LRU lRUCache = new P146_LRU(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);
    }

}
