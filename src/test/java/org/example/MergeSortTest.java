package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class MergeSortTest {
  @Test
  public void sortTest(){
    List<Integer> arr = List.of(2, 4, 1, 6, 7, 3);
    MergeSort mergeSort = new MergeSort(7);
    List<Integer> arrTop = List.of(1, 2, 3, 4, 6, 7);
    mergeSort.sort(arr);
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