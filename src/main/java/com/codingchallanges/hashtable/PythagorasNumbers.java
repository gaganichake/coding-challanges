package com.codingchallanges.hashtable;

import java.util.HashSet;
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
}
