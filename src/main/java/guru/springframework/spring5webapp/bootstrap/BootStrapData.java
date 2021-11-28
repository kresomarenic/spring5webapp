package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootStrapData(
      AuthorRepository authorRepository,
      BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    Author author1 = new Author("Eric", "Evans");
    Book book1 = new Book("Domain Driven Design", "123123");
    author1.getBooks().add(book1);
    book1.getAuthors().add(author1);
    authorRepository.save(author1);
    bookRepository.save(book1);

    Author author2 = new Author("Rod", "Johnson");
    Book book2 = new Book("J2EE Development without EJB", "56465465");
    author2.getBooks().add(book2);
    book2.getAuthors().add(author2);
    authorRepository.save(author2);
    bookRepository.save(book2);

    Publisher pub1 = new Publisher("Publisher 1", "Address1", "City1", "State1", "10001");
    publisherRepository.save(pub1);
    Publisher pub2 = new Publisher("Publisher 2", "Address2", "City2", "State2", "10002");
    publisherRepository.save(pub2);

    System.out.println("Started in bootstrap");
    System.out.println("Number of authors: " + authorRepository.count());
    System.out.println("Number of books: " + bookRepository.count());
    System.out.println("Number of publishers: " + publisherRepository.count());

  }
}
