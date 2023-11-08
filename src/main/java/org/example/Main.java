package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int n = 5;
    List<Integer> arr = List.of(1, 2, 6, 4, 10, 4, 5, 2, 0, 4);


    var sorting = new GetSort(List.of(new BubbleSort(10), new MergeSort(15)));
    ArrayList<Integer> sortArr = sorting.sort(arr, TypeSort.mergeSort);
    System.out.println(sortArr);
  }
}
