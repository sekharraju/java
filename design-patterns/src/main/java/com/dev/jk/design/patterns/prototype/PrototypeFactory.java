package com.dev.jk.design.patterns.prototype;

public interface PrototypeFactory {

    <T extends Vehicle> T createPrototype(Class<T> tClasss) throws CloneNotSupportedException;

}
