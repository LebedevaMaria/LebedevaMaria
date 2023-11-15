package org.example;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
  @Test
  public void sortTest(){
    List<Integer> arr = List.of(2, 4, 1, 6, 7, 3);
    BubbleSort bubbleSort = new BubbleSort(7);
    List<Integer> arrTop = List.of(1, 2, 3, 4, 6, 7);
    bubbleSort.sort(arr);
    boolean flag = true;
    if(arr.size() == arrTop.size()){
      for (int i = 0; i < arr.size(); i++) {
        if (arr.get(i) != arrTop.get(i)){
          flag = false;
        }
      }
    }
    assertTrue(flag);
  }
}