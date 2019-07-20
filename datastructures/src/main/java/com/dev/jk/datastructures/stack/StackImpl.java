package com.dev.jk.datastructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StackImpl<T> implements IStack<T> {

    private static int INDEX_EMPTY_STACK = -1;

    private static int INDEX_OF_FULL_STACK = Integer.MAX_VALUE;

    private AtomicInteger top = new AtomicInteger(-1);

    private List<T> elements = new ArrayList<>();

    public synchronized boolean push(T element) {
        if(top.get() == INDEX_OF_FULL_STACK) {
            return false;
        }
        if(elements.add(element)) {
            top.incrementAndGet();
            return true;
        }
        return false;
    }

    public synchronized T pop() {
        if (top.get() == INDEX_EMPTY_STACK) {
            return null;
        }
        return elements.remove(top.getAndDecrement());
    }

    public synchronized T seek() {
        if (top.get() == INDEX_EMPTY_STACK) {
            return null;
        }
        return elements.get(top.get());

    }

    public synchronized boolean isEmpty() {
        return top.get() == INDEX_EMPTY_STACK;
    }

    public boolean isFull() {
        return top.get() == INDEX_OF_FULL_STACK;
    }
}
