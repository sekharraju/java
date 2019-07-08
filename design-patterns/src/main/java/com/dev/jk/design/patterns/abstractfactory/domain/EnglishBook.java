package com.dev.jk.design.patterns.abstractfactory.domain;

public class EnglishBook implements Book {

    @Override
    public void readMe() {
        System.out.println("done with english book reading");
    }
}
