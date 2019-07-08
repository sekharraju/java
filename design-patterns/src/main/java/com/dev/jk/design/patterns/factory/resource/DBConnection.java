package com.dev.jk.design.patterns.factory.resource;

@FunctionalInterface
public interface DBConnection {

    void executeDBCall(String query);

}
