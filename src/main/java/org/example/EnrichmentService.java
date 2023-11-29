package org.example;

import java.util.*;

public class EnrichmentService implements UserRepository{
  List<Message.EnrichmentType> validEnrichmentType = new ArrayList<Message.EnrichmentType>();

  public Map<String, User> people = new HashMap<>();
  public EnrichmentService(List<Message.EnrichmentType> validEnrichmentType) {
    this.validEnrichmentType = validEnrichmentType;
  }

  public synchronized Map<String, String> enrich(Message message){
    boolean flag = false;
    for (var type: validEnrichmentType) {
      if (type == message.enrichmentType){
        flag = true;
      }
    }

    if (flag == true){
      if (message.enrichmentType == Message.EnrichmentType.MSISDN){
        if(message.content.containsKey("msisdn")){
          User user = findByMsisdn(message.content.get("msisdn"));
          message.content.put("firstName", user.firstName);
          message.content.put("lastName", user.lastName);
          return message.content;
        }
      }
    }
    return message.content;
  }



  @Override
  public User findByMsisdn(String msisdn) {
    return people.get(msisdn);
  }

  @Override
  public void updateUserByMsisdn(String msisdn, User user) {
    people.put(msisdn, user);
  }
}
