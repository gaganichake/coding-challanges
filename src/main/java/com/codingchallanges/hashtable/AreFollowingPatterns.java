package com.codingchallanges.hashtable;

import java.util.*;
import java.util.stream.Collectors;

/*
 * areFollowingPatterns
 *
 * https://app.codesignal.com/interview-practice/task/3PcnSKuRkqzp8F6BN/description
 *
 * Given an array strings, determine whether it follows the sequence given in the patterns array. In other words, there should be no i and j for which strings[i] = strings[j] and patterns[i] ≠ patterns[j] or for which strings[i] ≠ strings[j] and patterns[i] = patterns[j]
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
        // TODO Auto-generated method stub

    }

    // This is a working solution. Passed all tests. However, it does not use HashTable. Time complexity: O(n^2)
    boolean areFollowingPatterns(String[] strings, String[] patterns) {

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
    boolean solution1(String[] strings, String[] patterns) {

        //if(strings.length != patterns.length) return false;//Not requried. It is a guaranteed constraint.

        Map<String, List<Integer>> patternMap = covertToHashMap(patterns);

        // Set<String> uniqueStrings = new HashSet<>();

        // Time: O(n)
        for(List<Integer> list : patternMap.values()){

            // All indexes at i should have same String in array strings[]
            return list.stream().map(i -> strings[i]).collect(Collectors.toSet()).size() == 1;

            // Longer approach, however it exits ealry, which is good.
            // for(Integer i :  list) {
            //     if(uniqueStrings.isEmpty()) {
            //         uniqueStrings.add(strings[i]);
            //     } else {
            //         if(!uniqueStrings.contains(strings[i])) return false;
            //     }
            //     uniqueStrings.clear();
            // }
        }

        return true;
    }

    // Time: O(n)
    private Map<String, List<Integer>> covertToHashMap(String[] patterns) {

        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < patterns.length; i++) {

            String key = patterns[i];

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(i);
        }
        return map;
    }

}
