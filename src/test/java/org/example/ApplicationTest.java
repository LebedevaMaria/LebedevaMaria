package org.example;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;
public class ApplicationTest {
  @Test
  public void applicationTest() throws InterruptedException {
    List<Map<String, String>> listEnrichTest = new ArrayList<>();
    Map<String, String> enrichTest1 = new HashMap<>();
    enrichTest1.put("action", "button_click");
    enrichTest1.put("page", "book_card");
    enrichTest1.put("msisdn", "88005553531");
    enrichTest1.put("firstName", "Roach");
    enrichTest1.put("lastName", "Tapkovich");

    Map<String, String> enrichTest2 = new HashMap<>();
    enrichTest2.put("action", "button_click");
    enrichTest2.put("page", "book_card");
    enrichTest2.put("msisdn", "88005553532");
    enrichTest2.put("firstName", "Gavriil");
    enrichTest2.put("lastName", "Semenov");

    Map<String, String> enrichTest3 = new HashMap<>();
    enrichTest3.put("action", "button_click");
    enrichTest3.put("page", "book_card");
    enrichTest3.put("msisdn", "88005553533");
    enrichTest3.put("firstName", "Arbuz");
    enrichTest3.put("lastName", "Fedotov");

    Map<String, String> enrichTest4 = new HashMap<>();
    enrichTest4.put("action", "button_click");
    enrichTest4.put("page", "book_card");
    enrichTest4.put("msisdn", "88005553534");
    enrichTest4.put("firstName", "Floor");
    enrichTest4.put("lastName", "Ceilingovich");

    Map<String, String> enrichTest5 = new HashMap<>();
    enrichTest5.put("action", "button_click");
    enrichTest5.put("page", "book_card");
    enrichTest5.put("msisdn", "88005553535");
    enrichTest5.put("firstName", "Strowberry");
    enrichTest5.put("lastName", "Raspberries");

    listEnrichTest.add(enrichTest1);
    listEnrichTest.add(enrichTest2);
    listEnrichTest.add(enrichTest3);
    listEnrichTest.add(enrichTest4);
    listEnrichTest.add(enrichTest5);

    Map<String, String> input = new HashMap<>();
    input.put("action", "button_click");
    input.put("page", "book_card");
    input.put("msisdn", "88005553531");

    Map<String, String> input1 = new HashMap<>();
    input1.put("action", "button_click");
    input1.put("page", "book_card");
    input1.put("msisdn", "88005553532");

    Map<String, String> input2 = new HashMap<>();
    input2.put("action", "button_click");
    input2.put("page", "book_card");
    input2.put("msisdn", "88005553533");

    Map<String, String> input3 = new HashMap<>();
    input3.put("action", "button_click");
    input3.put("page", "book_card");
    input3.put("msisdn", "88005553534");

    Map<String, String> input4 = new HashMap<>();
    input4.put("action", "button_click");
    input4.put("page", "book_card");
    input4.put("msisdn", "88005553535");

    EnrichmentService enrichmentService = new EnrichmentService(List.of(Message.EnrichmentType.MSISDN));
    User user = new User("Roach", "Tapkovich");
    enrichmentService.updateUserByMsisdn("88005553531", user);
    User user1 = new User("Gavriil", "Semenov");
    enrichmentService.updateUserByMsisdn("88005553532", user1);
    User user2 = new User("Arbuz", "Fedotov");
    enrichmentService.updateUserByMsisdn("88005553533", user2);
    User user3 = new User("Floor", "Ceilingovich");
    enrichmentService.updateUserByMsisdn("88005553534", user3);
    User user4 = new User("Strowberry", "Raspberries");
    enrichmentService.updateUserByMsisdn("88005553535", user4);

    List<Map<String, String>> inputList = new ArrayList<>();
    inputList.add(input);
    inputList.add(input1);
    inputList.add(input2);
    inputList.add(input3);
    inputList.add(input4);

    List<Map<String, String>> enrichmentResults = new CopyOnWriteArrayList<>();
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    CountDownLatch latch = new CountDownLatch(5);
    for (int i = 0; i < 5; i++) {
      int finalI = i;
      executorService.submit(() -> {
        Message message = new Message(inputList.get(finalI), Message.EnrichmentType.MSISDN);
        enrichmentResults.add(
                enrichmentService.enrich(message)
        );
        latch.countDown();
      });
    }
    latch.await();
    boolean flag = true;
    for (int i = 0; i < 5; i++) {
      if (listEnrichTest.size() != enrichmentResults.size()){
        flag = false;
      } else {
        Map<String, String> first = listEnrichTest.get(i);
        boolean flag2 = false;
        for (int j = 0; j < enrichmentResults.size(); j++) {
          Map<String, String> second = enrichmentResults.get(j);
          if (first.size() != second.size()){
            flag2 = false;
          } else {
            for (String key : first.keySet()) {
              if ((first.get(key).equals(second.get(key)))){
                flag2 = true;
              }
            }
          }
        }
        if (!flag2){
          flag = false;
        }
      }
    }
    Assertions.assertTrue(flag);
  }
}