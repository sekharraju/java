package com.dev.jk.design.patterns.abstractfactory.factories;

import com.dev.jk.design.patterns.abstractfactory.AbstractObjectFactory;
import com.dev.jk.design.patterns.abstractfactory.domain.NonVegPizza;
import com.dev.jk.design.patterns.abstractfactory.domain.Pizza;
import com.dev.jk.design.patterns.abstractfactory.domain.VegPizza;

public class PizzaFactory extends AbstractObjectFactory<Pizza> {

    @Override
    public Pizza createObject(Class<? extends Pizza> pizzaClass) {
        Pizza pizza = null;
        if (pizzaClass.equals(VegPizza.class)) {
            pizza = new VegPizza();
        } else if (pizzaClass.equals(NonVegPizza.class)) {
            pizza = new NonVegPizza();
        }
        return pizza;
    }

}

