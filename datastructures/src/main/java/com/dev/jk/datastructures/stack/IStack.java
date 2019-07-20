package com.dev.jk.datastructures.stack;

public interface IStack<T> {

    boolean push(T element);

    T pop();

    T seek();

    boolean isEmpty();

    boolean isFull();

}
