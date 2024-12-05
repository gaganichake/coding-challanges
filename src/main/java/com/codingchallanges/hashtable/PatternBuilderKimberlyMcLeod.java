package com.codingchallanges.hashtable;

import java.util.ArrayList;
import java.util.HashMap;

// Not passing all tests
public class PatternBuilderKimberlyMcLeod {

    public boolean isFollowingPatterns(String[] strings, String[] patterns) {

        HashMap<String, ArrayList> mapOfPatterns = new HashMap<>();
        ArrayList<Integer> patternIndices = new ArrayList<>();
        for (int i = 0; i < patterns.length; i++){

            if (mapOfPatterns.containsKey(patterns[i])){ //error check
                patternIndices.add(i);
                mapOfPatterns.put(patterns[i], patternIndices);

            }
            else {
                patternIndices.add(i);
                mapOfPatterns.put(patterns[i], patternIndices);
            }
        }
        HashMap<String, ArrayList> mapOfStrings = new HashMap<>();
        ArrayList<Integer> stringIndices = new ArrayList<>();
        for (int i = 0; i < strings.length; i++){

            if (mapOfStrings.containsKey(strings[i])){ //error check
                stringIndices.add(i);
                mapOfStrings.put(strings[i], stringIndices);

            }
            else {

            }
        }


        // compare each hashmap

        return true;

    }

}
/*
cat -> a
dog -> b
dog


HashMap of pattern key: a, b / values: 0, 1, 2

HashMap<String, Integer[]> mapOfPattern
HashMap<String, Integer[]> mapOfString

interate hashmap


 ["cat", "dog", "dog"] and patterns = ["a", "b", "b"],
 [0, 1, 2] and [0, 1, 2]

 b > [1, 2] / dog > [1, 2]
 a > [0] / cat > [0]

  ["cat", "dog", "doggy"] and patterns = ["a", "b", "b"],

 a > [0], / cat > [0]
 b -> 1, 2] / dog > [1]

 doggy > 2



 */

