package com.dev.jk.datastructures.queue;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueueImplTest {

    private IQueue<Long> queue;

    @Before
    public void setUp() {
        queue = new QueueImpl<>();
    }

    @Test
    public void test() {
        for(int i=0; i < 10; i++) {
            queue.add(Long.valueOf(i));
        }
        assertThat(queue.isFull()).isTrue();
        assertThat(queue.add(Long.valueOf(20))).isFalse();
        assertThat(queue.size()).isEqualTo(10);
        for(int i=0; i < 10; i++) {
            Long element = queue.remove();
            assertThat(element).isEqualTo(Long.valueOf(i));
        }
        assertThat(queue.isEmpty()).isTrue();
    }
}
