package com.dev.jk.datastructures.linkedlist;

public interface ILinkedList<T> {

    boolean add(T element);

    boolean addFirst(T element);

    boolean addLast(T element);

    T remove();

    T removeFirst();

    T removeLast();

    boolean isEmpty();

    boolean isFull();

    int size();
}
