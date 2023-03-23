package io.github.ysharmko.spring6app.services;

import io.github.ysharmko.spring6app.domain.Author;
import io.github.ysharmko.spring6app.repositiries.AuthorRepository;

public interface AuthorService {


    Iterable<Author> findAll();




}
