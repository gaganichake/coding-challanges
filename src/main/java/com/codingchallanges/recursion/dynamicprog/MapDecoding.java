package com.codingchallanges.recursion.dynamicprog;

import java.util.HashMap;
import java.util.Map;

/**
 *  mapDecoding
 * <p>
 *  <a href="https://app.codesignal.com/interview-practice/task/7o2Aba2Zep3MJPKQ3/description">mapDecoding</a>
 * <p>
 *  A top secret message containing uppercase letters from 'A' to 'Z' has been encoded as numbers using the following mapping:
 *  'A' -> 1
 *  'B' -> 2
 *  ...
 *  'Z' -> 26
 * <p>
 *  You are an FBI agent and you need to determine the total number of ways that the message can be decoded.
 * <p>
 *  Since the answer could be very large, take it modulo 109 + 7.
 */
public class MapDecoding {

    private final static Map<Integer, Integer> map = new HashMap<>();

    int solution(String message) {

        map.clear();

        return mapDecoding(0, message);// Start is a position of numbers in the String

    }

    // Top-down strategy - Recursion with memorization
    private static int mapDecoding(int index, String numString) {

        final int mod = 1000000007;

        if(numString == null || numString.isEmpty() || index == numString.length()) return 1;

        if(numString.charAt(index) == '0') return 0;

        if(index == numString.length()-1) return 1;

        if(map.containsKey(index)){
            return map.get(index);
        }

        int count = mapDecoding(index+1, numString); // next single digit number

        if(Integer.parseInt(numString.substring(index, index+2)) <= 26){
            count = count + mapDecoding(index+2, numString); // next two digit number
            count = Math.floorMod(count, mod);
        }

        map.put(index, count);

        return count;
    }
}
