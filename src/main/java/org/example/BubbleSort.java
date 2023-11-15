package org.example;

import java.util.List;


public class BubbleSort extends Sort{
    protected BubbleSort(int maxLen) {
        super(maxLen);
    }

    @Override
    public TypeSort getType(){
        return TypeSort.bubbleSort;
    }

    @Override
    public void sort(List<Integer> arr){
        for (int i = 0; i < arr.size(); i++){
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)){
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
    }
}
