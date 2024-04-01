package com.example.demo;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class Book {


  private Long id;
  private String author;
  private String title;
  private Set<String> tags;


  public Book(Long id, String author, String title, Set<String> tags) {
    this.id = id;
    this.author = author;
    this.title = title;
    this.tags = tags;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Set<String> getTags() {
    return tags;
  }

  public void setTags(Set<String> tags) {
    this.tags = tags;
  }
}
