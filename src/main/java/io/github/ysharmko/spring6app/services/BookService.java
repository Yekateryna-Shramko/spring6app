package io.github.ysharmko.spring6app.services;

import io.github.ysharmko.spring6app.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
