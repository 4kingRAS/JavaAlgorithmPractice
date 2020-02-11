package com.unitest;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Yulin.Wang
 * @date 2020/2/11
 * @description
 */

public class UnitList implements Iterable<Integer> {
    UnitNode head = null;
    UnitNode tail = null;

    public void add(Unit unit) {
        UnitNode node = new UnitNode(unit, null);
        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
    }

    class UnitIterator implements Iterator<Integer> {
        UnitNode current;

        public UnitIterator(UnitNode head) {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            int value = current.getValue().getNum();
            current = current.getNext();
            return value;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new UnitIterator(head);
    }
}
