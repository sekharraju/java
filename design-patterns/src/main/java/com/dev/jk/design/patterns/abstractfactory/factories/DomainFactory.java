package com.dev.jk.design.patterns.abstractfactory.factories;

import com.dev.jk.design.patterns.abstractfactory.AbstractObjectFactory;

public interface DomainFactory {

    <T> AbstractObjectFactory<T> createDomainFactory(Class<T> tClass);

}
