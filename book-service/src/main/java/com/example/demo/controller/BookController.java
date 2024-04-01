package com.example.demo.controller;

import com.example.demo.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class BookController {
  private final BookRepository bookRepository;

  public BookController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }
  @GetMapping("/books")
  public List<Book> bookTable() {
    return bookRepository.findAll();
  }

  @GetMapping("/books/tags/{tag}")
  public Book getBook(@NotNull @PathVariable("tag") String tags) {
    return bookRepository.findByTag(tags).orElseThrow();
  }

  @PutMapping("/books/{id}")
  public void updateBook(@NotNull @PathVariable Long id, @NotNull @RequestBody @Valid BookRequestToUpdate request) {
    Book book = bookRepository.findById(id).orElseThrow();
    book.setTags(request.getTags());
    book.setTitle(request.getTitle());
    book.setAuthor(request.getAuthor());
    bookRepository.save(book);
  }

  @GetMapping("/books/{id}")
  public Book getBookId(@NotNull @PathVariable("id") Long id) {
    return bookRepository.findById(id).orElseThrow();
  }

  @PostMapping("/books")
  public Book createBook(@RequestBody BookRequestToCreate request) {
    Book book = new Book(null,request.getAuthor(), request.getTitle(), request.getTags());
    return bookRepository.save(book);
  }

  @DeleteMapping("/books/{id}")
  public void deleteBook(@NotNull @PathVariable Long id) {
    bookRepository.deleteById(id);
  }


}
