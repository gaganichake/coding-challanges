package com.codingchallanges.hashmap;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * areFollowingPatterns
 *
 * https://app.codesignal.com/interview-practice/task/3PcnSKuRkqzp8F6BN/description
 *
 * Given an array strings, determine whether it follows the sequence given in the patterns array.
 * In other words, there should be no i and j for which strings[i] = strings[j] and patterns[i] ≠ patterns[j]
 * or for which strings[i] ≠ strings[j] and patterns[i] = patterns[j]
 *
 * Example
 * For strings = ["cat", "dog", "dog"] and patterns = ["a", "b", "b"], the output should be
 * solution(strings, patterns) = true;
 *
 * For strings = ["cat", "dog", "doggy"] and patterns = ["a", "b", "b"], the output should be
 * solution(strings, patterns) = false
 *
 * Guaranteed constraints:
 * patterns.length = strings.length
 */
public class AreFollowingPatterns {

    public static void main(String[] args) {
        System.out.println(areFollowingPatternsHashMap(new String[]{"cat", "dog", "dog"}, new String[] {"a", "b", "b"})); // true
        System.out.println(areFollowingPatternsHashMap(new String[]{"cat", "dog", "doggy"}, new String[] {"a", "b", "b"})); // false
    }

    // This is a working solution. Passed all tests. However, it does not use HashTable. Time complexity: O(n^2)
    public static boolean areFollowingPatternsBruteForce(String[] strings, String[] patterns) {

        //if(strings.length != patterns.length) return false;//Not required. It is a guaranteed constraint.

        for (int i = 0; i < patterns.length; i++) {

            for (int j = 0; j < patterns.length; j++) {

                if (patterns[i].equals(patterns[j]) && !strings[i].equals(strings[j])) return false;

                if (!patterns[i].equals(patterns[j]) && strings[i].equals(strings[j])) return false;
            }
        }

        return true;
    }

    // Solved using HashTable. Time complexity: O(n) +. O(n) = O(n + n) = O(n)
    public static boolean areFollowingPatternsHashMap(String[] strings, String[] patterns) {

        //if(strings.length != patterns.length) return false;//Not required. It is a guaranteed constraint.

        Map<String, List<Integer>> patternMap = convertToHashMap(patterns);
        System.out.println("patternMap = " + patternMap);
        // Time: O(n)
        for(List<Integer> list : patternMap.values()){

            // Longer approach, however it exits early, however adds O(n x n)
            // Set<String> uniqueStrings = new HashSet<>();
            // for(Integer i :  list) {
            //     if(uniqueStrings.isEmpty()) {
            //         uniqueStrings.add(strings[i]);
            //     } else {
            //         if(!uniqueStrings.contains(strings[i])) return false;
            //     }
            // }

            // All indexes at 'i' should have same String in array strings[]
            if(list.stream().map(i -> strings[i]).collect(Collectors.toSet()).size() != 1){
                return false;
            }
        }

        return true;
    }

    // Time: O(n)
    private static Map<String, List<Integer>> convertToHashMap(String[] patterns) {

//        Map<String, List<Integer>> map = new HashMap<>();
//
//        for (int i = 0; i < patterns.length; i++) {
//
//            String key = patterns[i];
//
//            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
//            list.add(i);
//            map.put(key, list);
//        }
//        return map;

        // Optimized using Java Streams and functional programming
        return IntStream.range(0, patterns.length)
                .boxed()
                .collect(Collectors.groupingBy(i -> patterns[i]));
    }


    private static boolean areFollowingPatternsReverseMap(String[] strings, String[] strings1) {
        if (strings.length != strings1.length) {
            return false;
        }

        java.util.Map<String, String> patternMap = new java.util.HashMap<>();
        java.util.Map<String, String> reverseMap = new java.util.HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            String p = strings1[i];

            if (patternMap.containsKey(s)) {
                if (!patternMap.get(s).equals(p)) {
                    return false;
                }
            } else {
                patternMap.put(s, p);
            }

            if (reverseMap.containsKey(p)) {
                if (!reverseMap.get(p).equals(s)) {
                    return false;
                }
            } else {
                reverseMap.put(p, s);
            }
        }

        return true;
    }

    // Map
    // KEy ///////// VALUE
    // car ---------  a
    // plain -------  b
    // Pattern:  "a", "a", "b", "a"
    // Input:  "car", "car", "plain", "ship"
    public static boolean isFollowingPatternsByLuisFernando(String[] strings, String[] patterns) {
        Map<String, String> elementsMap = new HashMap<>();
        if (strings.length != patterns.length) {
            return false;
        }

        for (int i = 0; i < strings.length; i++) {
            if(!elementsMap.containsKey(strings[i])) {
                if (elementsMap.values().contains(patterns[i])) {
                    return false;
                }
                elementsMap.put(strings[i], patterns[i]);
            }
            else {
                final String patternValue = elementsMap.get(strings[i]);
                if (!patternValue.equals(patterns[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isFollowingPatternsBySebastian(String[] strings, String[] patterns) {

        Set<String> duplicatedInPattern = new HashSet<>(Arrays.asList(patterns));
        Set<String> duplicatedInStrings = new HashSet<>(Arrays.asList(strings));

        if(patterns.length == duplicatedInPattern.size() && duplicatedInStrings.size() == strings.length){
            return true;
        }


        Map<String, List<Integer>> duplicatedPositions = new HashMap<>();
        for (int i = 0; i < patterns.length; i++){
            if(duplicatedPositions.containsKey(patterns [i])){
                duplicatedPositions.get(patterns[i]).add(i);
            }else {

                duplicatedPositions.put(patterns[i], new ArrayList<>());
                duplicatedPositions.get(patterns[i]).add(i);
            }
        }
        AtomicBoolean result = new AtomicBoolean();
        result.set(true);
        duplicatedPositions.forEach((key, value)-> {
            if (value.size() > 1){
                Set<String> values = new HashSet<>();
                value.forEach(pos -> values.add(strings[pos]));
                if(values.size() != 1 && result.get()){
                    result.set(false);
                }
            }
        } );
        return result.get();

    }

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


    public static boolean isFollowingPatternsByJusticeCalderon(String[] strings, String[] patterns) {

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
            ArrayList<Integer> checkElementPresent = inputArrayMap.get(array[i]);

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

    // Not passing all tests
    // returns true if strings follow the pattern order,
    // that is there is a 1:1 mapping between a string and a pattern
    public static boolean evaluateStringPatternByXiaoPingHuynh(String[] strings, String[] patterns) {
        // create patternToStringMap
        // for idx in range(0, strings.length):
        // if patternToStringMap has key patterns[idx] AND patternTostringMap.get(pattern) != current string,
        //    return false as strings dont follow given pattern
        // map patterns[idx] to strings[idx] if not in map already
        // return true after loop finishes

        // strings: cat, dog, fox
        // pattern: a
        if (strings.length != patterns.length) {
            return false;
        }
        Map<String, String> patternToStringMap = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (patternToStringMap.containsKey(patterns[i])
                    && !patternToStringMap.get(patterns[i]).equals(strings[i])) {
                return false;
            }
            if (!patternToStringMap.containsKey(patterns[i])) {
                patternToStringMap.put(patterns[i], strings[i]);
            }
        }
        return true;
    }
}
