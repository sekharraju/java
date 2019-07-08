package com.dev.jk.design.patterns.singleton;

public class SingletonDataSource1 {

    private static SingletonDataSource1 singleton = new SingletonDataSource1();

    private final String code = "earlyInitialization";

    private SingletonDataSource1() {
    }

    public static SingletonDataSource1 getSingletonInstance() {
        return singleton;
    }

    public String getCode() {
        return code;
    }
}
