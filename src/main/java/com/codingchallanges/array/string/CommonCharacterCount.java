package com.codingchallanges.array.string;

import java.util.HashMap;
import java.util.Map;

public class CommonCharacterCount {

    int getCommonCharacterCount(String s1, String s2) {

        if(null == s1 || null == s2 || s1.isEmpty() || s1.isEmpty()) {
            return 0;
        }

        char[] s2CharArray = s2.toCharArray();
        Map<String, Integer> myMap = new HashMap<>();

        for(int i = 0; i < s2CharArray.length; i++) {
            if(!myMap.containsKey(String.valueOf(s2CharArray[i]))) {
                myMap.put(String.valueOf(s2CharArray[i]), 1);
            } else {
                myMap.put(String.valueOf(s2CharArray[i]), myMap.get(String.valueOf(s2CharArray[i])) + 1);
            }
        }

        int counter = 0;

        char[] s1CharArray = s1.toCharArray();

        for(int j = 0; j < s1CharArray.length; j++) {
            if(myMap.containsKey(String.valueOf(s1CharArray[j]))
                    && myMap.get(String.valueOf(s1CharArray[j])) > 0) {
                counter++;
                myMap.put(String.valueOf(s1CharArray[j]),
                        myMap.get(String.valueOf(s1CharArray[j])) - 1);
            }
        }

        return counter;
    }
}
