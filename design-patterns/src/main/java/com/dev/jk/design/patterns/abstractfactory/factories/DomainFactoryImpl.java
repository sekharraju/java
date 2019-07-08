package com.dev.jk.design.patterns.abstractfactory.factories;

import com.dev.jk.design.patterns.abstractfactory.AbstractObjectFactory;
import com.dev.jk.design.patterns.abstractfactory.domain.Book;
import com.dev.jk.design.patterns.abstractfactory.domain.Pizza;

public class DomainFactoryImpl implements DomainFactory {

    @Override
    public <T> AbstractObjectFactory<T> createDomainFactory(Class<T> tClass) {

        AbstractObjectFactory<T> objectFactory = null;
        if(tClass.equals(Book.class)) {
            objectFactory = (AbstractObjectFactory<T>) new BookFactory();
        } else if(tClass.equals(Pizza.class)) {
            objectFactory = (AbstractObjectFactory<T>) new PizzaFactory();
        }
        return objectFactory;

    }

}
