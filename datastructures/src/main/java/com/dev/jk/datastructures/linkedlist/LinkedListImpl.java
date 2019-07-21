package com.dev.jk.datastructures.linkedlist;

public class LinkedListImpl<T> implements ILinkedList<T> {

    private Node<T> first;

    private Node<T> last;

    private int size = 0;

    @Override
    public boolean add(T element) {
        return addLast(element);
    }

    @Override
    public boolean addFirst(T element) {
        Node<T> newNode = new Node<>(first, null, element);
        first = newNode;
        if(last ==  null) {
            last = first;
        }
        size++;
        return true;
    }

    @Override
    public boolean addLast(T element) {
        Node<T> newNode = new Node<>(null, null, element);
        if(isEmpty()) {
            first = newNode;
            last = newNode;
            size++;
            return true;
        }

        if(size == 1) {
            first.next = newNode;
            newNode.previous = first;
            last = newNode;
            size++;
            return true;
        }

        newNode.previous = last;
        last.next = newNode;
        last = newNode;
        size++;
        return true;
    }

    @Override
    public T remove() {
        return removeFirst();
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }
        Node<T> beingRemoved;
        if(size == 1) {
            beingRemoved = first;
            first = null;
            last = null;
        } else {
            beingRemoved = first;
            first = first.next;
            first.previous = null;
            beingRemoved.next = null;
        }
        size--;
        return beingRemoved.element;
    }

    @Override
    public T removeLast() {
        if(isEmpty()) {
            return null;
        }
        Node<T> beingRemoved;
        if(size == 1) {
            beingRemoved = last;
            first = null;
            last = null;
        } else {
            beingRemoved = last;
            last = last.previous;
            last.next = null;
            beingRemoved.previous = null;
        }
        size--;
        return beingRemoved.element;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<E> {
        private E element;

        private Node<E> next;

        private Node<E> previous;

        public Node(Node<E> next, Node<E> previous, E element) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }


    }
}
