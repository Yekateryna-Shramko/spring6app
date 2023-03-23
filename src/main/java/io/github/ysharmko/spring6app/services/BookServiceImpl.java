package io.github.ysharmko.spring6app.services;

import io.github.ysharmko.spring6app.domain.Book;
import io.github.ysharmko.spring6app.repositiries.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
