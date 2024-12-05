package com.codingchallanges.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Not passing all tests
public class PatternBuilderJonatanMartinez {


    public boolean isFollowingPatterns(String[] strings, String[] patterns) {

        if (strings.length != patterns.length) {
            return false;
        }

        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            String currentWord = strings[i];
            if (map.containsKey(currentWord)) {
                List currentList = map.get(currentWord);
                currentList.add(i);
                map.put(currentWord, currentList);
            } else {
                List currentList = new ArrayList();
                currentList.add(i);
                map.put(currentWord, currentList);
            }
        }

        boolean result = true;
//        map.forEach((word, list) -> {
//            Integer currentInterger = list.get(0);
//            String currentPattern = patterns[currentInterger];
//            list.stream(() -> {
//            if (currentPattern != patterns[index]) {
//                result = false;
//            }
//        });
//    });
        return result;
}
}
