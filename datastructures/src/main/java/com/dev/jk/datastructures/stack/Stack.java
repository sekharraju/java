package com.dev.jk.datastructures.stack;

public interface Stack<T> {

    boolean push(T element);

    T pop();

    T seek();

    boolean isEmpty();

    boolean isFull();

}
