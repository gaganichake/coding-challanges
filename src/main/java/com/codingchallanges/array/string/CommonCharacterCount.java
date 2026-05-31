package com.codingchallanges.array.string;

import java.util.HashMap;
import java.util.Map;

public class CommonCharacterCount {

    static int getCommonCharacterCount(String s1, String s2) {

        if(null == s1 || null == s2 || s1.isEmpty() || s2.isEmpty()) {
            return 0;
        }

        char[] s1Array = s1.toCharArray();
        Map<Character, Integer> mapS1 = new HashMap<>();

        for (char ch : s1Array) {
            mapS1.put(ch, mapS1.getOrDefault(ch, 0) + 1);
        }

        int counter = 0;

        char[] s2Array = s2.toCharArray();

        for (char ch : s2Array) {

            if (mapS1.containsKey(ch) && mapS1.get(ch) > 0) {
                counter++;
                mapS1.put(ch, mapS1.get(ch) - 1);
            }
        }

        return counter;
    }

    public static void main(String[] args) {

        System.out.println(getCommonCharacterCount("You need to do more practice",
                "Practice makes you perfect"));

    }
}
