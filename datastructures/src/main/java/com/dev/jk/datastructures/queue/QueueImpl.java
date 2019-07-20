package com.dev.jk.datastructures.queue;

public class QueueImpl<T> implements IQueue<T> {

    private int head = 0;

    private int capacity = 10;

    private int rear = capacity - 1;

    private int size = 0;

    private Object[] elements =  new Object[capacity];

    @Override
    public synchronized boolean add(T element) {
        if(isFull()) {
            return false;
        }
        rear = (rear + 1) % capacity;
        elements[rear] = element;
        size = size + 1;
        return true;
    }

    @Override
    public synchronized T remove() {
        if(isEmpty()) {
            return null;
        }
        T element = (T) elements[head];
        head = (head +1) % capacity;
        size = size - 1;
        return element;
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            return null;
        }
        return (T) elements[head];
    }

    @Override
    public boolean isFull() {
        return capacity == size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }


}
