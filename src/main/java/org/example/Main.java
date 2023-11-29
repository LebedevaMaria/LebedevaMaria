package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
  public static void main(String[] args) {
    User user = new User("Vasya", "Ivanov");
    EnrichmentService enrichmentService = new EnrichmentService(List.of(Message.EnrichmentType.MSISDN));
    enrichmentService.updateUserByMsisdn("88005553535", user);

    Map<String, String> input = new HashMap<>();
    input.put("action", "button_click");
    input.put("page", "book_card");
    input.put("msisdn", "88005553535");
    Message message = new Message(input, Message.EnrichmentType.MSISDN);

    System.out.println(enrichmentService.enrich(message));
  }
}