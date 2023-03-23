package io.github.ysharmko.spring6app.repositiries;

import io.github.ysharmko.spring6app.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository <Publisher, Long> {
}
