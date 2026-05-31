package com.codingchallanges.hashmap;

import java.util.*;
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
    public boolean areFollowingPatterns(String[] strings, String[] patterns) {

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
    static boolean areFollowingPatternsHashMap(String[] strings, String[] patterns) {

        //if(strings.length != patterns.length) return false;//Not required. It is a guaranteed constraint.

        Map<String, List<Integer>> patternMap = convertToHashMap(patterns);
        System.out.println("patternMap = " + patternMap);
        // Time: O(n)
        for(List<Integer> list : patternMap.values()){

            // All indexes at i should have same String in array strings[]
            if(list.stream().map(i -> strings[i]).collect(Collectors.toSet()).size() != 1){
                return false;
            }

            // Longer approach, however it exits early, however adds O(n x n)
            // Set<String> uniqueStrings = new HashSet<>();
            // for(Integer i :  list) {
            //     if(uniqueStrings.isEmpty()) {
            //         uniqueStrings.add(strings[i]);
            //     } else {
            //         if(!uniqueStrings.contains(strings[i])) return false;
            //     }
            // }
        }

        return true;
    }

    // Time: O(n)
//    private static Map<String, List<Integer>> convertToHashMap(String[] patterns) {
//
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
//    }

    // Time: O(n) - Optimized using Java Streams and functional programming
    private static Map<String, List<Integer>> convertToHashMap(String[] patterns) {
        return IntStream.range(0, patterns.length)
                .boxed()
                .collect(Collectors.groupingBy(i -> patterns[i]));
    }

}
