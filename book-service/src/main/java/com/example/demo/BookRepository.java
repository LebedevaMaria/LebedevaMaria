package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
  Optional<Book> findByTag(String tag);
  List<Book> findAll();
  Book save(Book book);
  Optional<Book> findById(Long id);

  void deleteById(Long id);

}
