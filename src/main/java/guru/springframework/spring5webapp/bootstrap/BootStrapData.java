package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepositiry;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component


public class BootStrapData implements CommandLineRunner {

    private final AuthorRepositiry authorRepositiry;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepositiry authorRepositiry, BookRepository bookRepository) {
        this.authorRepositiry = authorRepositiry;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Author jeremiah = new Author("jeremiah1", "jeremiah2");
        Book judith = new Book("judith1", "3124241241");

        jeremiah.getBooks().add(judith);
        judith.getAuthors().add(jeremiah);

judith.setPublisher(publisher);
publisher.getBooks().add(judith);


        authorRepositiry.save(jeremiah);
        bookRepository.save(judith);



        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without something","4142323523");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepositiry.save(rod);
        bookRepository.save(noEJB);


        System.out.println("Started with bootstrap");
        System.out.println("Number of books "+ bookRepository.count());

    }
}
