package com.example.demo;

import com.example.demo.Book;
import com.example.demo.BookRequestToCreate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class BookControllerTest {
  @Autowired private TestRestTemplate rest;

  @Test
  void EndToEnd() {
    ResponseEntity<Book> createBookResponse =
        rest.postForEntity(
            "/api/books",
            new BookRequestToCreate(
                "Лермонтов М. B.", "Герой нашего времени", Set.of("Печорин", "Максим Максимыч")),
            Book.class);
    assertTrue(
        createBookResponse.getStatusCode().is2xxSuccessful(),
        "Unexpected status code: " + createBookResponse.getStatusCode());
    Book createBookResponseBody = createBookResponse.getBody();

    long id = createBookResponseBody.getId();

    ResponseEntity<Book> getBookResponse =
        rest.getForEntity("/api/books/{id}", Book.class, Map.of("id", id));

    assertTrue(
        getBookResponse.getStatusCode().is2xxSuccessful(),
        "Unexpected status code: " + getBookResponse.getStatusCode());

    Book getBookResponseBody = getBookResponse.getBody();
    assertEquals("Лермонтов М. B.", getBookResponseBody.getAuthor());
    assertEquals("Герой нашего времени", getBookResponseBody.getTitle());
    Set<String> bookTags = getBookResponseBody.getTags();
    Set<String> originTags = Set.of("Печорин", "Максим Максимыч");
    Iterator<String> iterator = bookTags.iterator();
    boolean flag = true;
    while (iterator.hasNext()) {
      if (!originTags.contains(iterator.next())) {
        flag = false;
      }
    }
    System.out.println(flag);

    String tag = "Печорин";
    ResponseEntity<Book> getBookResponseFindByTags =
        rest.getForEntity("/api/books/tags/{tag}", Book.class, Map.of("tag", tag));
    Book getBookByTagsBody = getBookResponseFindByTags.getBody();
    assertEquals("Лермонтов М. B.", getBookByTagsBody.getAuthor());
    assertEquals("Герой нашего времени", getBookByTagsBody.getTitle());

    rest.put(
        "/api/books/{id}",
        new BookRequestToUpdate(
            "Лермонтов М. Ю.", "Герой нашего времени", Set.of("Печорин", "Максим Максимыч")),
        Map.of("id", id));
    ResponseEntity<Book> getBookUpdateResponse =
        rest.getForEntity("/api/books/{id}", Book.class, Map.of("id", id));
    Book getBookUpdateBody = getBookUpdateResponse.getBody();
    assertEquals("Лермонтов М. Ю.", getBookUpdateBody.getAuthor());
    assertEquals("Герой нашего времени", getBookUpdateBody.getTitle());

    rest.delete("/api/books/{id}", Map.of("id", id));
    ResponseEntity<Book> getBookResposeDelete =
        rest.getForEntity("/api/books/{id}", Book.class, Map.of("id", id));
    Book getBookDeleteBody = getBookResposeDelete.getBody();
    assertNull(getBookDeleteBody.getTitle());
    assertNull(getBookDeleteBody.getAuthor());
    assertNull(getBookDeleteBody.getTags());
  }
}
