package org.example;

import java.util.List;
import java.util.Collections;

public class MergeSort extends Sort{
    public MergeSort(int maxLen){
        super(maxLen);
    }
    @Override
    public TypeSort getType(){
        return TypeSort.mergeSort;
    }

    @Override
    public void sort(List<Integer> arr){
        Collections.sort(arr);
    }
}
