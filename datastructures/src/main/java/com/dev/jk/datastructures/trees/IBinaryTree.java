package com.dev.jk.datastructures.trees;

import java.util.List;

public interface IBinaryTree<T> {

    void add(T element);

    void delete(T element);

    int size();

    boolean isEmpty();

    boolean contains(T element);

    List<T> inOrder();

    List<T> preOrder();

    List<T> postOrder();

    List<T> ascendingOrder();

    List<T> descendingOrder();

}
