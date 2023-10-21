package org.example;

import java.util.ArrayList;
import java.util.Collections;
public class Sort {

        public static void mergeSort(ArrayList<Integer> list) {
            Collections.sort(list);
        }

        public static void bubbleSort(ArrayList<Integer> arr) {
            for (int i = 0; i < arr.size(); i++) {
                for (int j = i + 1; j < arr.size(); j++) {
                    if (arr.get(i) > arr.get(j)) {
                        int temp = arr.get(i);
                        arr.set(i, arr.get(j));
                        arr.set(j, temp);
                    }
                }
            }
        }

    public static void sort(ArrayList<Integer> list, String name){
        if (name.equals("mergeSort")){
            mergeSort(list);
        } else {
            bubbleSort(list);
        }
    }
}
