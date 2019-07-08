package com.dev.jk.design.patterns.singleton;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class SingletonDataSource1Test {

    private SingletonDataSource1 singletonDataSource1;

    @Before
    public void setUp() {
        singletonDataSource1 = SingletonDataSource1.getSingletonInstance();
    }

    @Test
    public void assertNotNull() {
        Assertions.assertThat(singletonDataSource1).isNotNull();
    }

    @Test
    public void assertEquals() {
        SingletonDataSource1 instance2 = SingletonDataSource1.getSingletonInstance();
        SingletonDataSource1 instance3 = SingletonDataSource1.getSingletonInstance();
        Assertions.assertThat(instance2).isEqualTo(instance3);
        Assertions.assertThat(instance3).isEqualTo(singletonDataSource1);
    }
}
