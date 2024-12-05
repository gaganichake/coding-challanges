package com.codingchallanges.hashtable;

import java.util.HashMap;
import java.util.Map;
/**
 * given a list of strings and patterns,
 * 1. check that equal strings have the same pattern letter
 * 2. patterns cannot be shared between strings
 */
// No passing all tests
public class PatternBuilderXiaoPingHuynh {

    // returns true if strings follow the pattern order,
    // that is there is a 1:1 mapping between a string and a pattern
    public boolean evaluateStringPattern(String[] strings, String[] patterns) {
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
