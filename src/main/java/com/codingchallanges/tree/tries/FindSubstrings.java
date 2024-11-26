package com.codingchallanges.tree.tries;

import java.util.*;
import java.util.stream.Collectors;

public class FindSubstrings {

    // This is not an expected solution. Time complexity is O(n * n)
    // Expected to utilize Tree data structure to solve the problem
    static String[] solution(String[] words, String[] parts) {

        if(parts.length == 0) return words;

        //Sorted in decreasing order of the length (Not the reverse of the natural order)
        // This code does the same sorting
        // Arrays.sort(parts, (o1, o2) -> (o1.length() > o2.length() ? -1 : o1.length() < o2.length() ? 1 : 0));
        Arrays.sort(parts, Comparator.comparingInt(s -> -s.length()));

        System.out.println("Sorted parts: " + Arrays.asList(parts));

        for(int i = 0; i < words.length; i++) {

            String word = words[i];
            int smallestIndexOfPart = word.length();
            int lastPartLength = parts[0].length();

            for(String part : parts) {

                if(word.indexOf(part) > -1) {

                    if(smallestIndexOfPart != word.length() && part.length() < lastPartLength)
                        break;

                    if(word.indexOf(part) < smallestIndexOfPart) {
                        words[i] = updateWord(word, part);
                        smallestIndexOfPart = word.indexOf(part);
                    }

                    lastPartLength = part.length();
                    System.out.println("SmallestIndexOfPart: " + smallestIndexOfPart + ", part: " + part + ", word =" + words[i]);
                }
            }
        }

        return words;
    }

    private static String updateWord(String word, String part) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(word, 0, word.indexOf(part));
        stringBuilder.append("[");
        stringBuilder.append(part);
        stringBuilder.append("]");
        stringBuilder.append(word, word.indexOf(part)+part.length(), word.length());
        return stringBuilder.toString();
    }

    // Tries : Incomplete implementation
    static String[] solution2(String[] words, String[] parts) {

        if(parts.length == 0) return words;

        //Sorted in decreasing order of the length (Not the reverse of the natural order)
//        Arrays.sort(parts, Comparator.comparingInt(s -> -s.length()));

//        System.out.println("Sorted parts: " + Arrays.asList(parts));

        // Create Trie of parts
        Tries trie = new Tries();
        for(String part : parts) {
            trie.add(part);
        }

        for(int i = 0; i < words.length; i++) {

            String word = words[i];
            StringBuilder substr = new StringBuilder();
            int longestSubstring = 0;
            char[] charArray = word.toCharArray();

            for(int j = 0; j < charArray.length; j++){

                substr.append(charArray[j]);

                if(trie.search(substr.toString())){
                    if(substr.length() > longestSubstring) {
                        longestSubstring = substr.length();
                        words[i] = updateWord(word, substr.toString());
                    }
                } else {
                    break;
                }
            }
        }


        return words;
    }

    // Better solution would be to search the (character of) word in parts instead of searching the parts in the word.
    // To achieve this you need to first convert the parts array in Tries data structure.

    public static void main(String[] args) {
        String[] words = {"Apple", "Melon", "Orange", "Watermelon"};
        String[] parts = {"a", "mel", "lon", "el", "An"};
        System.out.println(Arrays.stream(solution(words, parts)).collect(Collectors.toList()));

        words = new String[] {"neuroses", "myopic", "sufficient", "televise", "coccidiosis", "gules", "during", "construe", "establish", "ethyl"};
        parts = new String[] {"aaaaa", "Aaaa", "E", "z", "Zzzzz", "a", "mel", "lon", "el", "An", "ise", "d", "g", "wnoVV", "i", "IUMc", "P", "KQ", "QfRz", "Xyj", "yiHS"};
        System.out.println(Arrays.stream(solution(words, parts)).collect(Collectors.toList()));
    }
}
