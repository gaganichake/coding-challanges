package com.codingchallanges.recursion.backtracking;

import java.util.*;

/*
 * Google technical interview (II) Sep/17/2021
 *
 * Input
 * 	String
 * 	Set<Character>
 * Output
 * 	Return the shortest substring (or length) that contains all the characters in the set.
 *
 * * * * * * * * * * * * *
 * Grainger coding challange
 *
 * Given two Strings "hackerearth" and "are" find the shorted substring in "hackerearth" which
 * has all characters in "are".
 *
 * Example: "achker", "area, "rea", "ear" all valid substring but the shortest is "rea" and "ear"
 *
 * Cross questions:
 * 1. How you can ignore the substring that are shorter than "are" and optimize it?
 * 2. There are three loops in the code, can you remove any loops?
 * 3. What if the input string to find ("are") has duplicate characters?
 *
 * * * * * * * * * * * * *
 * minSubstringWithAllChars
 *
 * https://app.codesignal.com/interview-practice/task/rFeSD5rNy9RxfLcqg/description
 *
 * You have two strings, s and t. The string t contains only unique elements. Find and
 * return the minimum consecutive substring of s that contains all of the elements from t.
 *
 * It's guaranteed that the answer exists. If there are several answers, return the one
 * which starts from the smallest index.
 *
 */
public class ShortestSubstring {

    //Brute-force method. Time complexity: O(n x n); Space complexity: O(n)
    public static String shortestSubstring(String str, Set<Character> set) {

        String substring;
        String shortedSubstring = "";
        int minSize = set.size();//Substring shorter than size of set are not qualified

        for (int i = 0; i < str.length(); i++) {

            for (int j = i + minSize; j <= str.length(); j++) {

                substring = str.substring(i, j);

                if (hasAllChar(substring, set)) {

                    if (shortedSubstring.isEmpty() || shortedSubstring.length() > substring.length()) {
                        shortedSubstring = substring;
                    }
                }
            }
        }
        return shortedSubstring;
    }

    //Backtracking method. Time complexity: O(n x n); Space complexity: O(n)
    public static String shortestSubstringBacktracking(String str, Set<Character> set) {

        List<String> output = new ArrayList<>();


        shortestSubstringBacktracking(str, set, new StringBuffer(), output, 0);

        //System.out.println(output);

        String shortedSubstring = "";

        for (String substring : output) {

            if (shortedSubstring.isEmpty() || shortedSubstring.length() > substring.length()) {
                shortedSubstring = substring;
            }
        }

        return shortedSubstring;
    }

    private static void shortestSubstringBacktracking(String str, Set<Character> set, StringBuffer substring, List<String> output, int start) {

        if (str.contains(substring.toString()) && hasAllChar(substring.toString(), set)) {

            output.add(substring.toString());

        } else {

            for (int i = start; i < str.length(); i++) {

                substring.append(str.charAt(i));

                shortestSubstringBacktracking(str, set, substring, output, i + 1);

                substring.deleteCharAt(substring.length() - 1);
            }
        }
    }

    private static boolean hasAllChar(String substring, Set<Character> set) {

        for (Character c : set) {

            if (!substring.contains(c + "")) {

                return false;
            }
        }

        return true;
    }

    //CodeSingle variant of the same problem
    public static String minSubstringWithAllChars(String s, String t) {

        String substring;
        String shortedSubstring = "";
        int minSize = t.length();//Substring shorter than length of t are not qualified

        for (int i = 0; i < s.length(); i++) {

            for (int j = i + minSize; j <= s.length(); j++) {

                substring = s.substring(i, j);

                if (hasAllChar(substring, t)) {

                    if (shortedSubstring.isEmpty() || shortedSubstring.length() > substring.length()) {
                        shortedSubstring = substring;
                    }
                }
            }
        }
        return shortedSubstring;
    }

    private static boolean hasAllChar(String substring, String t) {

        char[] charArr = t.toCharArray();

        for (char c : charArr) {

            if (!substring.contains(c + "")) {

                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

//		String str =  "afopgngfknfngoxbg";
        String str = "2000702007";
//		Character[] c = {'f', 'g'};
        Character[] c = {'2', '7'};

        Set<Character> set = new HashSet<>(Arrays.asList(c));

        System.out.println("shortedSubstring = " + shortestSubstring(str, set));
        System.out.println("shortedSubstringBacktracking = " + shortestSubstringBacktracking(str, set));
        System.out.println("minSubstringWithAllChars = " + minSubstringWithAllChars(str, "27"));
    }
}
