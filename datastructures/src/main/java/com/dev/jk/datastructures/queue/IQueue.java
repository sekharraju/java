package com.dev.jk.datastructures.queue;

public interface IQueue<T> {

    boolean add(T element);

    T remove();

    T peek();

    boolean isFull();

    boolean isEmpty();

    int size();

}
