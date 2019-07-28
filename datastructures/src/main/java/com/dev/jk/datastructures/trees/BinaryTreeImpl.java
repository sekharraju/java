package com.dev.jk.datastructures.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeImpl<T extends Comparable<T>> implements IBinaryTree<T> {

    private Node<T> root;

    public void add(T element) {
        root = insertElement(root, element);
    }

    @Override
    public void delete(T element) {
        root = deleteElement(root, element);
    }

    private Node<T> deleteElement(Node<T> parent, T element) {
        if(parent == null) {
            return null;
        }
        if(parent.element == element) {

            if(parent.right == null && parent.left == null) {
                return null;
            }

            if(parent.right == null) {
                return parent.left;
            }

            if(parent.left == null) {
                return parent.right;
            }

            T smallElement = smallest(parent.right);

            parent.element = smallElement;

            parent.right = deleteElement(parent.right, smallElement);

            return parent;
        }

        if(element.compareTo(parent.element) < 0) {
            parent.left = deleteElement(parent.left, element);
            return parent;
        }

        parent.right = deleteElement(parent.right, element);
        return parent;
    }

    private T smallest(Node<T> parent) {
        if(parent == null) {
            return null;
        }
        if(parent.left == null) {
            return parent.element;
        }
        return smallest(parent.left);
    }

    protected Node<T> insertElement(Node<T> parent, T element) {
        if(parent == null) {
            return new Node(element, null, null);
        }
        if(element.compareTo(parent.element) > 0) {
            parent.right = insertElement(parent.right, element);
        }
        if(element.compareTo(parent.element) < 0) {
            parent.left = insertElement(parent.left, element);
        }
        return parent;
    }

    public int size() {
        return findSize(root);
    }

    private int findSize(Node<T> parent) {
        if(parent == null) {
            return 0;
        }
        return findSize(parent.left) + 1 + findSize(parent.right);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T element) {
        return containsElement(root, element);
    }

    protected boolean containsElement(Node<T> parent, T element) {
        if(parent == null || element == null) {
            return false;
        }
        if(parent.element == element) {
            return true;
        }

        if(element.compareTo(parent.element) < 0) {
            return containsElement(parent.left, element);
        }

        if(element.compareTo(parent.element) > 0) {
            return containsElement(parent.right, element);
        }

        return false;
    }

    public List<T> inOrder() {
        List<T> elements = new ArrayList<>();
        return inOrderOfElements(root, elements);
    }

    protected List<T> inOrderOfElements(Node<T> parent, List<T> traversed) {
        if(parent == null) {
            return traversed;
        }
        inOrderOfElements(parent.left, traversed);
        traversed.add(parent.element);
        inOrderOfElements(parent.right, traversed);
        return traversed;
    }

    public List<T> preOrder() {
        List<T> preOrderedElements = new ArrayList<>();
        return preOrderOfElements(root, preOrderedElements);
    }

    private List<T> preOrderOfElements(Node<T> parent, List<T> preOrderedElements) {
        if(parent == null) {
            return preOrderedElements;
        }
        preOrderedElements.add(parent.element);
        preOrderOfElements(parent.left, preOrderedElements);
        preOrderOfElements(parent.right, preOrderedElements);
        return preOrderedElements;
    }

    public List<T> postOrder() {
        List<T> postOrderedElements = new ArrayList<>();
        return postOrderOfElements(root, postOrderedElements);
    }

    @Override
    public List<T> ascendingOrder() {
        return inOrder();
    }

    public List<T> descendingOrder() {
        List<T> reverseOrdered = new ArrayList<>();
        return descendingOrderOfElements(root, reverseOrdered);
    }

    private List<T> descendingOrderOfElements(Node<T> parent, List<T> reverseOrder) {
        if(parent == null) {
            return reverseOrder;
        }
        descendingOrderOfElements(parent.right, reverseOrder);
        reverseOrder.add(parent.element);
        descendingOrderOfElements(parent.left, reverseOrder);
        return reverseOrder;
    }

    private List<T> postOrderOfElements(Node<T> parent, List<T> postOrderedElements) {
        if(parent == null) {
            return postOrderedElements;
        }
        preOrderOfElements(parent.left, postOrderedElements);
        preOrderOfElements(parent.right, postOrderedElements);
        postOrderedElements.add(parent.element);
        return postOrderedElements;
    }


    private static class Node<T> {
        T element;

        Node<T> left;

        Node<T> right;

        public Node(T element, Node<T> left, Node<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

}
