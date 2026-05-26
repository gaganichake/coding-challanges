package com.codingchallanges;


import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {

		String[] words = {"a","ab","abc"};
//		String[] words = {"a","ab","abc","a"};
//		String[] words = {"a","b","abc"};
//		String[] words = {"a","ba","abcd"};
//		String[] words = {"word","world","row"};
//		String[] words = {"apple","app"};
//		String[] words = {"app", "apple"};
//        String[] words = {"abcdef", "gh"};

        System.out.println(isSortedLexicographically(words));

    }

    public static boolean isSortedLexicographically(String[] words) {

        if(words.length < 2) return true;

        for(int i = 0; i < words.length - 1; i++) {

            if(!compare(words[i], words[i+1]))
                return false;
        }

        return true;
    }

    private static boolean compare(String string1, String string2) {

        String[] words = {string1, string2};
        Arrays.sort(words);
        return words[0].equals(words[1]);
    }

}

