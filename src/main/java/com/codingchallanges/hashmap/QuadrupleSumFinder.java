package com.codingchallanges.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
/*
You are given a list of n integers and an arbitrary integer target value target.
Your task involves finding a pair of integers in the array whose sum equals the value of target.
If multiple pairs satisfy this condition, choose the one with a lower index of the last element
that appears in the array. If no pairs' sum equals target, return an empty list.

Example:
For the input array arr = [2, 13, 4, 7, 5, 15] and a target target = 9, the output should be [2, 7]
because the sum of these numbers equals 9. [4, 5] is also a valid pair, but it appears later (5 appears after 7).
 */
public class QuadrupleSumFinder {

    public int[] solution(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], i);
        }
        int complement = 0;

        SortedMap<Integer, int[]> sortedMap = new TreeMap<>();;

        System.out.println("Samples:");
        for(int i = 0; i < arr.length; i++){

            complement = target - arr[i];

            if (map.containsKey(complement) && map.get(complement) > i){

                System.out.println("[" + arr[i] + ", " + complement + "]");

                // Using index of the second element (right) as sort key (default ascending)
                sortedMap.put(map.get(complement), new int[] {arr[i], complement});
            }

        }

        return sortedMap.isEmpty() ? new int[]{} : sortedMap.get(sortedMap.firstKey());
    }

     public static void main(String[] args) {

        QuadrupleSumFinder finder = new QuadrupleSumFinder();

        int[] arr = {2, 13, 4, 7, 5, 15};
        int target = 9;
//         Output : [2, 7]

//         int[] arr = {1, 2, 3, 4, 9, 10};
//         int target = 13;
//           Output : [4, 9]

//         int[] arr = {50, -50};
//         int target = 100;

//         int[] arr = {0, 0, 0, 0, 0};
//         int target = 0;

//         int[] arr = {-100, -50, 0, 50, 100};
//         int target = -150;

//         int[] arr = {-66, 45, 95, -84, -35, -70, 26, 94, 15, 20, 66, -3, -47, -76, 24, -93, -1, 10, 55, 95, 96, -100, 78, 14, -32, 84, -42, 51, -74, -19, -93, -95, -94, 66, 38, -98, -3, 75, -45, 8, 85, -93, 35, -44, 95, 12, 26, 41, -41, -12, -41, 73, -44, 94, 17, -26, -95, 6, 42, 64, -75, -53, 61, 85, -25, -70, 90, -15, 84, 82, 28, 8, 29, 71, -52, -23, -28, 50, 27, 29, 0, 50, -92, 22, -38, 90, 3, 6, 70, -56, -7, 40, 79, 98, 72, 88, -5, -78, 12, 69};
//         int target = -10;

        int[] result = finder.solution(arr, target);

        System.out.println("result = " + (result.length == 0 ? "[]" : "[" + result[0] + ", " + result[1] + "]"));
     }

}

