package io.github.ysharmko.spring6app.bootstrap;

import io.github.ysharmko.spring6app.domain.Author;
import io.github.ysharmko.spring6app.domain.Book;
import io.github.ysharmko.spring6app.domain.Publisher;
import io.github.ysharmko.spring6app.repositiries.AuthorRepository;
import io.github.ysharmko.spring6app.repositiries.BookRepository;
import io.github.ysharmko.spring6app.repositiries.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author misha = new Author();
        misha.setFirstName("Misha-Мяв");
        misha.setLastName("Мур");

        Book mishasBook = new Book();
        mishasBook.setTitle("Мяу");
        mishasBook.setIsbn(Integer.toString(Integer.MAX_VALUE));

        Author mishaSaved = authorRepository.save(misha);
        Book mishasBookSaved = bookRepository.save(mishasBook);

        Author kisia = new Author();
        kisia.setFirstName("Зайка");
        kisia.setLastName("Мяв");

        Book catsBook = new Book();
        catsBook.setTitle("Как будить Мишу");
        catsBook.setIsbn("fkjesLCFN");

        Author kisiaSaved = authorRepository.save(kisia);
        Book catsBookSaved = bookRepository.save(catsBook);

        Publisher somePublisher = new Publisher();
        somePublisher.setAddress("somewhere");
        somePublisher.setCity("smallCity");
        somePublisher.setZip("0000");
        somePublisher.setState("not a state");
        somePublisher.setPublisherName("good name");

        Publisher somePublisherSaved = publisherRepository.save(somePublisher);

        mishaSaved.getBooks().add(mishasBookSaved);
        mishasBookSaved.getAuthors().add(misha);
        kisiaSaved.getBooks().add(catsBookSaved);
        catsBookSaved.getAuthors().add(kisia);

        mishasBookSaved.setPublisher(somePublisherSaved);
        catsBookSaved.setPublisher(somePublisherSaved);



        authorRepository.save(mishaSaved);
        authorRepository.save(kisiaSaved);
        bookRepository.save(mishasBookSaved);
        bookRepository.save(catsBookSaved);

        System.out.println("In Bootstrap: ");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
