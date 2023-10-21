package org.example;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void TestMerge(){
        var ans = new ArrayList<Integer>(Arrays.stream(new int[]{3, 5, 7, 9}).boxed().toList());
        var qua = new ArrayList<Integer>(Arrays.stream(new int[]{9, 5, 3, 7}).boxed().toList());
        Sort.sort(qua, "mergeSort");
        assert ans.equals(qua);
    }

    @Test
    void TestBubble(){
        var ans = new ArrayList<Integer>(Arrays.stream(new int[]{3, 5, 7, 9}).boxed().toList());
        var qua = new ArrayList<Integer>(Arrays.stream(new int[]{9, 5, 3, 7}).boxed().toList());
        Sort.sort(qua, "bubbleSort");
        assert ans.equals(qua);
    }
}