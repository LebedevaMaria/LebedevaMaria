package com.example.demo;

import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class BookRequestToUpdate {
  @NotNull
  private Set<String> tags;
  @NotNull
  private String author;
  @NotNull
  private String title;

  public BookRequestToUpdate(String author, String title, Set<String> tags) {
    this.tags = tags;
    this.author = author;
    this.title = title;
  }

  public Set<String> getTags() {
    return tags;
  }

  public void setTags(Set<String> tags) {
    this.tags = tags;
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
}
