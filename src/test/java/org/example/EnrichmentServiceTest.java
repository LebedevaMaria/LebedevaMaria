package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EnrichmentServiceTest {
  EnrichmentService enrichmentService = new EnrichmentService(List.of(Message.EnrichmentType.MSISDN));
  User user = new User("Roach", "Tapkovich");
  @Test
  public void updateUserByMsisdnTest(){
    Map<String, User> testUser = new HashMap<>();
    testUser.put("66666666666", user);
    enrichmentService.updateUserByMsisdn("66666666666", user);
    Assertions.assertEquals(enrichmentService.people, testUser);
  }

  @Test
  public void findByMsisdnTest(){
    Map<String, User> testUser = new HashMap<>();
    testUser.put("66666666666", user);
    enrichmentService.updateUserByMsisdn("66666666666", user);
    User user2 = enrichmentService.findByMsisdn("66666666666");
    Assertions.assertEquals(user2, user);
  }

  @Test
  public void enrichTest(){
    Map<String, String> enrichTest = new HashMap<>();
    enrichTest.put("action", "button_click");
    enrichTest.put("page", "book_card");
    enrichTest.put("msisdn", "88005553535");
    enrichTest.put("firstName", "Roach");
    enrichTest.put("lastName", "Tapkovich");

    Map<String, String> input = new HashMap<>();
    input.put("action", "button_click");
    input.put("page", "book_card");
    input.put("msisdn", "88005553535");
    enrichmentService.updateUserByMsisdn("88005553535", user);
    Message message = new Message(input, Message.EnrichmentType.MSISDN);
    boolean flag = true;
    Map<String, String> result = enrichmentService.enrich(message);
    if (result.size() != enrichTest.size()){
      flag = false;
    } else {

      for (String key : enrichTest.keySet()) {
        if (!(enrichTest.get(key).equals(result.get(key)))){
          flag = false;
        }
      }
    }
    Assertions.assertTrue(flag);
  }
}