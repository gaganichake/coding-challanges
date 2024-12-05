package com.codingchallanges.hashtable;

import java.util.ArrayList;
import java.util.HashMap;

// Passing all tests
public class PatternBuilderJusticeCalderon {

    /*
    Requirements:
    - Assume that our array will have length from 1 to 10
    - There will always be at least one element in the array
    - The string array and pattern array will always have the same length
    - Assume that the pattern array can have any number of unique elements

    Algorithm:
    Inputs: ["cat", "dog", "dog"],  ["a", "b", "b"]
    Outputs: True

    - Note the count and position of the pattern elements
    - Iterate through the pattern array first to identify the pattern to crosscheck with the input
    - Once we've identified the pattern encoding, we can use the same procedure to check the input array

    - HashMap algorithm idea
        - Step 1: Iterate through the pattern array, put element as the key, and then add a 1-D array
            of the index positions

                ["a", "b", "b"]

                { "a" : [0]
                  "b" : [1, 2]
                }

         - Step 2: " " " input string array, put element as key, then add a 1-D array of index positions
                ["cat", "dog", "dog"]

                { "cat" : [0]
                  "dog" : [1, 2]
                }

         - Step 3: For each key value pair in the pattern HashMap, confirm that the values match

                ["cat", "dog", "doggy"]

                { "cat" : [0]
                  "dog" : [1]
                  "doggy" : [2]
                }

     */


    public boolean isFollowingPatterns(String[] strings, String[] patterns) {

        HashMap<String, ArrayList<Integer>> inputStringArrayMap = buildHashMap(strings);
        HashMap<String, ArrayList<Integer>> inputPatternMap = buildHashMap(patterns);

        // Performing the check to validate the patterns
        for (ArrayList<Integer> indexArray : inputPatternMap.values()) {
            if (!inputStringArrayMap.containsValue(indexArray)) {
                return false;
            }
        }

        return true;

    }

    public static HashMap<String, ArrayList<Integer>> buildHashMap(String[] array) {

        HashMap<String, ArrayList<Integer>> inputArrayMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            // Check if the element is present in the HashMap
            var checkElementPresent = inputArrayMap.get(array[i]);

            if (checkElementPresent == null) {
                // Put element into HashMap
                ArrayList<Integer> mapList = new ArrayList<>();
                mapList.add(i);
                inputArrayMap.put(array[i], mapList);
            } else {
                checkElementPresent.add(i);
            }
        }

        return inputArrayMap;
    }

}

