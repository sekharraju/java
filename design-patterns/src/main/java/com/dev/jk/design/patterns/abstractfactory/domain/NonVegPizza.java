package com.dev.jk.design.patterns.abstractfactory.domain;


public class NonVegPizza implements Pizza {

    @Override
    public void eatMe() {
        System.out.println("done with eating of Non Veg Pizza");
    }

}

