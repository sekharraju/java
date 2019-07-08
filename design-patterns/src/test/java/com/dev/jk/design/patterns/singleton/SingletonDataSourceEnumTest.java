package com.dev.jk.design.patterns.singleton;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SingletonDataSourceEnumTest {

    private SingletonDataSourceEnum singletonDataSourceEnum;

    @Before
    public void setUp() {
        SingletonDataSourceEnum singletonDataSourceEnum = SingletonDataSourceEnum.getSingletonInstance();
    }

    @Test
    public void serialization() throws IOException, ClassNotFoundException {

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singletonDataSourceEnum.text"));
        out.writeObject(singletonDataSourceEnum);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("singletonDataSourceEnum.text"));
        SingletonDataSourceEnum deserializedInstance = (SingletonDataSourceEnum) in.readObject();
        in.close();

        Assertions.assertThat(deserializedInstance).isEqualTo(singletonDataSourceEnum);
    }

}
