package com.codingchallanges.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Facebook Coding challenge, Jan 18, 2022

1. Return true/false if such combination exist in a given array of integers: a^2 + b^2 = c^2
    * Input array can have a length from 0 to N.
    * Array elements can be negative, positive or zero.
    * Example 1: [3, -1, 2, 4, 5, 6] result is true because found  3^2 + 4^2 = 5^2 exist.
    * Example 2: [0, -1, 0] result in false
 */
public class PythagorasNumbers {

    public static void main(String[] arg) {

        int[] sampleArray1 = {3, -1, 2, 4, 5, 6};
        System.out.println(isPythagorasNumbers(sampleArray1));

        int[] sampleArray2 = {0, -1, 0};
        System.out.println(isPythagorasNumbers(sampleArray2));
    }

    private static boolean isPythagorasNumbers(int[] numbers){
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < numbers.length; i++){

            numbers[i] = numbers[i] * numbers[i];
            set.add(numbers[i]);
        }

        System.out.println(set);

        for(int i = 0; i < numbers.length; i++){

            int c = numbers[i];
            set.remove(c);

            // Is combination exist such that a + b = c
            for(int j = 0; i != j && j < numbers.length; j++) {

                int b = numbers[j];
                set.remove(b);

                int a = c - b;

                // Is combination exist such that a = c - b, find a
                if(set.contains(a)) return true;
                set.add(b);
            }
            set.add(c);
        }
    return false;
    }

    private static boolean isPythagorasNumbersOptimized(int[] numbers){
        // Handle trivial cases
        if (numbers == null || numbers.length < 3) return false;

        int n = numbers.length;
        long[] squares = new long[n];
        Map<Long, Integer> counts = new HashMap<>();

        // Compute squares and frequency counts (use long to avoid overflow)
        for (int i = 0; i < n; i++){
            squares[i] = (long) numbers[i] * (long) numbers[i];
            counts.put(squares[i], counts.getOrDefault(squares[i], 0) + 1);
        }

        // Check all unordered pairs (i < j) as candidates for a and b.
        // If their squared-sum exists as c^2 in the original array at an index
        // different from i and j, then we've found a valid triplet.
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                long sum = squares[i] + squares[j];
                Integer cnt = counts.get(sum);
                if (cnt == null) continue;

                // Determine how many occurrences of 'sum' are required as a distinct c
                // If sum equals neither squares[i] nor squares[j], we need 1 occurrence.
                // If sum equals exactly one of them, we need 2 occurrences (one for c and one for that a/b).
                // If sum equals both (only possible when squares[i] == squares[j] == sum), we need 3.
                int required = 1;
                boolean eqi = (sum == squares[i]);
                boolean eqj = (sum == squares[j]);
                if (eqi && eqj) required = 3;
                else if (eqi || eqj) required = 2;

                if (cnt >= required) return true;
            }
        }

        return false;
    }
}
