package com.dev.jk.design.patterns.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingletonDataSource2 implements Serializable {

    private static SingletonDataSource2 singleton = new SingletonDataSource2();

    private static final String  EARLY_INIT_MESSAGE = "earlyInitialization-Serializable-safe";

    private String doNotModifyMe = EARLY_INIT_MESSAGE;

    private SingletonDataSource2() {
    }

    public static SingletonDataSource2 getSingletonInstance() {
        return singleton;
    }

    public String getDoNotModifyMe() {
        return doNotModifyMe;
    }

    public void setDoNotModifyMe(String doNotModifyMe) {
        this.doNotModifyMe = doNotModifyMe;
    }

    public Object readResolve() throws ObjectStreamException {
        singleton.doNotModifyMe = EARLY_INIT_MESSAGE;
        return singleton;
    }

    public Object writeReplace() throws ObjectStreamException {
        singleton.doNotModifyMe = EARLY_INIT_MESSAGE;
        return singleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton, no to cloning");
    }
}

