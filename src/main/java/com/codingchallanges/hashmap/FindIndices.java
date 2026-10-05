package com.codingchallanges.hashmap;

import java.util.HashMap;
import java.util.Map;

public class FindIndices {

    public int[] findIndices(int[] arrA, int[] arrB) {

        // Correct bruteforce solution, timeout because of O(n x n)
        // for(int i = 0; i < arrA.length; i++){
        //     for(int j = i+1; j < arrA.length; j++){
        //         if(i != j && arrA[i] + arrA[j] == arrB[i] + arrB[j])  return new int[]{i, j};
        //     }
        // }

        if (arrA == null || arrB == null || arrA.length != arrB.length) {
            return new int[]{0, 0};
        }

        Map<Integer, Integer> aSubBMap = new HashMap<>();

        for(int i = 0; i < arrA.length; i++){
            aSubBMap.putIfAbsent(arrA[i] - arrB[i], i);
        }

        for(int i = 0; i < arrA.length; i++){

            int diff =  arrB[i] - arrA[i];

            if(aSubBMap.containsKey(diff)){

                int j = aSubBMap.get(diff);

                return new int[]{i, j};

            }
        }

        return new int[]{0, 0};
    }
}
