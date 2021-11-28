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

    Publisher pub1 = new Publisher();
    pub1.setName("Publisher 1");
    pub1.setAddressLine1("Address1");
    pub1.setCity("City1");
    pub1.setState("State1");
    pub1.setZip("10001");
    publisherRepository.save(pub1);

    Author author1 = new Author("Eric", "Evans");
    Book book1 = new Book("Domain Driven Design", "123123");
    author1.getBooks().add(book1);
    book1.getAuthors().add(author1);
    book1.setPublisher(pub1);
    pub1.getBooks().add(book1);
    authorRepository.save(author1);
    bookRepository.save(book1);
    publisherRepository.save(pub1);

    Author author2 = new Author("Rod", "Johnson");
    Book book2 = new Book("J2EE Development without EJB", "56465465");
    author2.getBooks().add(book2);
    book2.getAuthors().add(author2);
    book2.setPublisher(pub1);
    pub1.getBooks().add(book2);
    authorRepository.save(author2);
    bookRepository.save(book2);
    publisherRepository.save(pub1);




    System.out.println("Started in bootstrap");
    System.out.println("Number of authors: " + authorRepository.count());
    System.out.println("Number of books: " + bookRepository.count());
    System.out.println("Number of publishers: " + publisherRepository.count());
    System.out.println("Publisher number of books: " + pub1.getBooks().size());

  }
}
