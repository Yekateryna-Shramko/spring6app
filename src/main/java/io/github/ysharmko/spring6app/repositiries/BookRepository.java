package io.github.ysharmko.spring6app.repositiries;

import io.github.ysharmko.spring6app.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
