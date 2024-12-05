package com.codingchallanges.hashtable;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class PatternBuilderSebastian {

    public boolean isFollowingPatterns(String[] strings, String[] patterns) {

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
}
