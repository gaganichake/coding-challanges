package com.codingchallanges.hashtable;

/*
Asked in Caterpillar interview on Nov 21, 2024

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:
Input: s = "aaa", p = "*a"
Output: true
Explanation: '*' matches any sequence.

Example 4:
Input: s = "aaa", p = "*c"
Output: false
Explanation: '*' matches any sequence, but c not found.

Example 5:
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

Example 6:
Input: s = "cb", p = "?b"
Output: true

Found: https://leetcode.com/problems/wildcard-matching/description/
 */
public class IsMatchingRegexPattern {

    public static void main(String[] args) {

        System.out.println(matchPattern("aa", "a")); // false
        System.out.println(matchPattern("aa", "*")); // true
        System.out.println(matchPattern("aaa", "*a")); // true
        System.out.println(matchPattern("aaa", "*c")); // false
        System.out.println(matchPattern("cb", "?a")); // false
        System.out.println(matchPattern("cb", "?b")); // true
    }

    private static boolean matchPattern(String s, String p) {

        int j = 0;
        for(int i = 0; i < p.length(); i++) {

            char pCh = p.charAt(i);

            if(pCh == '*') {

                if(j < s.length()-1 && s.charAt(j) == s.charAt(++j)) {
                    while (j < s.length()-1 && s.charAt(j) == s.charAt(++j)) {
//                        j++;
                    }
                    continue;
                } else {
                    return false;
                }
            }

            if(pCh != '?' && pCh != s.charAt(j)) {
                return false;
            }
            j++;
        }

        return j >= s.length()-1;
    }
}
