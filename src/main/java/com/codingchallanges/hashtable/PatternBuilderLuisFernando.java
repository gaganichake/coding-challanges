package com.codingchallanges.hashtable;

import java.util.HashMap;
import java.util.Map;

// Passing all tests
public class PatternBuilderLuisFernando {

    // Map
    // KEy ///////// VALUE
    // car ---------  a
    // plain -------  b

    // Pattern:  "a", "a", "b", "a"
    // Input:  "car", "car", "plain", "ship"

    public boolean isFollowingPatterns(String[] strings, String[] patterns) {
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
}
