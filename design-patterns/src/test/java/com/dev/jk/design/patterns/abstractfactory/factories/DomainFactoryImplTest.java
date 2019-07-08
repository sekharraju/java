package com.dev.jk.design.patterns.abstractfactory.factories;

import com.dev.jk.design.patterns.abstractfactory.AbstractObjectFactory;
import com.dev.jk.design.patterns.abstractfactory.domain.Book;
import com.dev.jk.design.patterns.abstractfactory.domain.EnglishBook;
import com.dev.jk.design.patterns.abstractfactory.domain.HindiBook;
import com.dev.jk.design.patterns.abstractfactory.domain.NonVegPizza;
import com.dev.jk.design.patterns.abstractfactory.domain.Pizza;
import com.dev.jk.design.patterns.abstractfactory.domain.VegPizza;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DomainFactoryImplTest {

    private DomainFactory domainFactory;

    @Before
    public void setUp() {
        domainFactory = new DomainFactoryImpl();
    }

    @Test
    public void assertBookCreation() {
         AbstractObjectFactory<Book> bookFactory = domainFactory.createDomainFactory(Book.class);
         Book book = bookFactory.createObject(EnglishBook.class);
         assertThat(book).isInstanceOf(EnglishBook.class);
         book = bookFactory.createObject(HindiBook.class);
         assertThat(book).isInstanceOf(HindiBook.class);
    }

    @Test
    public void assertPizzaCreation() {
        AbstractObjectFactory<Pizza> pizzaFactory = domainFactory.createDomainFactory(Pizza.class);
        Pizza pizza = pizzaFactory.createObject(VegPizza.class);
        assertThat(pizza).isInstanceOf(VegPizza.class);
        pizza = pizzaFactory.createObject(NonVegPizza.class);
        assertThat(pizza).isInstanceOf(NonVegPizza.class);
    }

}
