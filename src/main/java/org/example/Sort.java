package org.example;

import java.util.List;

public abstract class Sort {
    void sort(List<Integer> array) {

    }

    TypeSort getType() {
        return null;
    }

    public int maxLen;
    protected Sort(int maxLen){
        this.maxLen = maxLen;
    }
    public void normLen(List<Integer> arr) {
        if (arr.size() > maxLen) {
            throw new RuntimeException("В массиве много элементов");

        }
    }
}