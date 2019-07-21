package com.dev.jk.datastructures.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListImplTest {

    private ILinkedList<Integer> linkedList;

    @Before
    public void setUp() {
        linkedList = new LinkedListImpl<>();
    }

    @Test
    public void test() {
        for(int i = 0; i < 10; i++) {
            assertThat(linkedList.size()).isEqualTo(i);
            linkedList.addLast(i);
        }

        for(int i = 10; i > 5; i--) {
            assertThat(linkedList.size()).isEqualTo(i);
            int lastRemoved = linkedList.removeLast();
            assertThat(lastRemoved).isEqualTo(i-1);
        }

        for(int i = 0; i < 5; i++) {
            assertThat(linkedList.size()).isEqualTo(5-i);
            int firstRemoved = linkedList.removeFirst();
            assertThat(firstRemoved).isEqualTo(i);
        }
        assertThat(linkedList.isEmpty()).isTrue();
    }
}
