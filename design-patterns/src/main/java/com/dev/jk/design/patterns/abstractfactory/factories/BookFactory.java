package com.dev.jk.design.patterns.abstractfactory.factories;

import com.dev.jk.design.patterns.abstractfactory.AbstractObjectFactory;
import com.dev.jk.design.patterns.abstractfactory.domain.Book;
import com.dev.jk.design.patterns.abstractfactory.domain.EnglishBook;
import com.dev.jk.design.patterns.abstractfactory.domain.HindiBook;

public class BookFactory extends AbstractObjectFactory<Book> {

    @Override
    public Book createObject(Class<? extends Book> bookClass) {
        Book book = null;
        if (bookClass.equals(EnglishBook.class)) {
            book = new EnglishBook();
        } else if (bookClass.equals(HindiBook.class)) {
            book = new HindiBook();
        }
        return book;
    }
}
