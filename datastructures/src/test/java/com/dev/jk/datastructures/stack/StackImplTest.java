package com.dev.jk.datastructures.stack;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StackImplTest {

    private IStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new StackImpl<>();
    }

    @Test
    public void test() {
        for(int i= 0; i < 10 ; i++) {
            stack.push(i);
        }
        for(int i =  10; i > 0; i --) {
            Integer element = stack.pop();
            assertThat(element).isEqualTo(Integer.valueOf(i-1));
        }
    }

}
