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

public class SingletonDataSource2Test {

    private SingletonDataSource2 singletonDataSource2;

    @Before
    public void setUp() {
        singletonDataSource2 = SingletonDataSource2.getSingletonInstance();
    }

    @Test
    public void serialization() throws IOException, ClassNotFoundException {

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singletonDataSource2.text"));
        out.writeObject(singletonDataSource2);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("singletonDataSource2.text"));
        SingletonDataSource2 deserializedInstance = (SingletonDataSource2) in.readObject();
        in.close();

        Assertions.assertThat(deserializedInstance).isEqualTo(singletonDataSource2);
    }

}
