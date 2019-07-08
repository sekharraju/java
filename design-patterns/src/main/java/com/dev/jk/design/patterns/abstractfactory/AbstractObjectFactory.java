package com.dev.jk.design.patterns.abstractfactory;

public abstract class AbstractObjectFactory<T> {

    public abstract T createObject(Class<? extends T> tClass);

}
