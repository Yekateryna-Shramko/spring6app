package io.github.ysharmko.spring6app.repositiries;


import io.github.ysharmko.spring6app.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
