package com.dev.jk.datastructures.trees;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeTest {

    IBinaryTree<Integer> binaryTree;

    @Before
    public void setUp() {
        binaryTree = new BinaryTreeImpl<>();
    }

    @Test
    public void isEmpty() {
        assertThat(binaryTree.isEmpty()).isTrue();
    }

    @Test
    public void testAll() {
        binaryTree.add(10);
        binaryTree.add(5);
        binaryTree.add(24);
        binaryTree.add(2);
        binaryTree.add(100);
        binaryTree.add(21);
        binaryTree.add(1);
        System.out.println(binaryTree.inOrder());
        System.out.println(binaryTree.ascendingOrder());
        System.out.println(binaryTree.descendingOrder());
        assertThat(binaryTree.contains(100)).isTrue();
        System.out.println(binaryTree.preOrder());
        System.out.println(binaryTree.postOrder());
        assertThat(binaryTree.size()).isEqualTo(7);
        binaryTree.delete(24);
        assertThat(binaryTree.size()).isEqualTo(6);
        assertThat(binaryTree.contains(24)).isFalse();
        System.out.println(binaryTree.ascendingOrder());
        System.out.println(binaryTree.descendingOrder());
    }

}
