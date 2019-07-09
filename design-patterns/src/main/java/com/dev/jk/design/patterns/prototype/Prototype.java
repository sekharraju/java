package com.dev.jk.design.patterns.prototype;

public interface Prototype extends Cloneable {

    Vehicle cretaePrototype() throws CloneNotSupportedException;

}
