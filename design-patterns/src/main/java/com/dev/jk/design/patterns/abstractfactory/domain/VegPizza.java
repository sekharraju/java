package com.dev.jk.design.patterns.abstractfactory.domain;

public class VegPizza implements Pizza {

    @Override
    public void eatMe() {
        System.out.println("done with eating of Veg Pizza");
    }

}
