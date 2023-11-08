package org.example;
import java.util.ArrayList;
import java.util.List;

public class GetSort {
  public List<Sort> algorithm;
  public GetSort(List<Sort> algoritm) {
    this.algorithm = algoritm;
  }
  public ArrayList<Integer> sort(List<Integer> arr, TypeSort typeSort){
    for(Sort algoritm : algorithm){
      if (algoritm.getType() == typeSort){
        try{
          algoritm.normLen(arr);

          ArrayList<Integer> newArr= new ArrayList<>(arr);
          algoritm.sort(newArr);
          return newArr;
        } catch (RuntimeException e){

        }
      }
    }
    throw new RuntimeException("Wrong algorithm");
  }

}
