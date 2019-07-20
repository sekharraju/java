package com.dev.jk.datastructures;

import com.dev.jk.datastructures.stack.Stack;
import com.dev.jk.datastructures.stack.StackImpl;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StackImplTest {

    private Stack<Integer> stack;

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
