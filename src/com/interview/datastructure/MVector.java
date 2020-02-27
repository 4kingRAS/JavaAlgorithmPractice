package com.interview.datastructure;


import java.util.Scanner;

/**
 * @author Yulin.Wang
 * @date 2019-05-20
 * @description vector class implementation
 * @see         java.util.Vector
 **/
//TODO:

public class MVector<E> {

    private int capacity;
    private int count = 0;
    private Object[] data;

    public MVector(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                    capacity);
        this.capacity = capacity;
        this.data = new Object[capacity];
    }

    public MVector() { this(10); }

    public int insert(E element) {
        data[count] = element;
        return count++;
    }

    public E get(int index) {
        if (index >= count)
            throw new ArrayIndexOutOfBoundsException(index);
        return (E) data[index];
    }

    public E set(int index, E value) {
        // return old
        if (index >= count)
            throw new ArrayIndexOutOfBoundsException(index);

        E old = (E) data[index];
        data[index] = value;
        return old;
    }

    public void copyInto(Object[] anArray) {
        System.arraycopy(data, 0, anArray, 0, count);
    }

    public int expand() {
        return 0;
    }

    public static void main(String[] args) {
        MVector<Integer> s = new MVector<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            System.out.println(s.insert(sc.nextInt()));
        }
    }

}
