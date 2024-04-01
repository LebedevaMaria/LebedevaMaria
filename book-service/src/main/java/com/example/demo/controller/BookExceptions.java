package com.example.demo.controller;

public class BookExceptions {
  public static class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message){
      super(message);
    }
    public BookNotFoundException(String message, Throwable cause){
      super(message, cause);
    }
  }
}
