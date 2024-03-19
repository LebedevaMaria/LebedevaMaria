package com.example.demo;

import com.example.demo.controller.BookExceptions;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
@Component
public class InMemoryBookRepository implements BookRepository {
  private final List<Book> books;
  private static final AtomicLong idGenerator = new AtomicLong(0);

  public InMemoryBookRepository() {
    books = new CopyOnWriteArrayList<>();
    Set<String> firstBook = Set.of("Раскольников", "Старуха");
    Set<String> secondBook = Set.of("Болконский", "Дуб");
    books.add(new Book(idGenerator.incrementAndGet(), "Достоевский Ф. М.", "Преступление и наказание", firstBook));
    books.add(new Book(idGenerator.incrementAndGet(), "Толстой Л. Н.", "Война и мир", secondBook));
  }




  @Override
  public Optional<Book> findByTag(String tag) {
    return books.stream()
            .filter(c -> c.getTags().contains(tag))
            .findFirst();
  }

  @Override
  public List<Book> findAll() {
    return new ArrayList<>(books);
  }

  @Override
  public Book save(Book book) {
    if (book.getId() == null) {
      book.setId(idGenerator.incrementAndGet());
      books.add(book);
      return book;
    } else {
      synchronized (this) {
        for (Book c: books) {
          if (Objects.equals(c.getId(), book.getId())) {
            c.setAuthor(book.getAuthor());
            c.setTags(book.getTags());
            c.setTitle(book.getTitle());
            return book;
          }
        }
        throw new BookExceptions.BookNotFoundException("No book with id=" + book.getId());
      }
    }
  }

  @Override
  public Optional<Book> findById(Long id) {
    return books.stream()
            .filter(c -> Objects.equals(c.getId(), id))
            .findFirst();
  }

  @Override
  public void deleteById(Long id) {
    synchronized (this) {
      for (int i = 0; i < books.size(); ++i) {
        Book c = books.get(i);
        if (Objects.equals(c.getId(), id)) {
          books.remove(i);
        }
      }
      throw new BookExceptions.BookNotFoundException("No book with id=" + id);
    }
  }


}
