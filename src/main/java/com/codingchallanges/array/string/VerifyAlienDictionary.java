package com.codingchallanges.array.string;

import java.util.HashMap;
import java.util.Map;

/*
 * Verifying an Alien Dictionary
 *
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 *
 * In an alien language, surprisingly, they also use English lowercase letters,
 * but possibly in a different order. The order of the alphabet is some permutation
 * of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the
 * alphabet, return true if and only if the given words are sorted lexicographically
 * in this alien language.
 */
public class VerifyAlienDictionary {

		/*
		 * Words are sorted in ascending order as per the new language
		 */
	    public static boolean isAlienSorted(String[] words, String order) {

	        int[] index = new int[26];// New indices of 26 alphabets as per the Alien language

	        for (int i = 0; i < order.length(); ++i) {

	        	index[order.charAt(i) - 'a'] = i; System.out.println((order.charAt(i) - 'a')+"|"+order.charAt(i)+"|"+i);
	        }

	        for (int i = 0; i < words.length - 1; ++i) {

	            String word1 = words[i];
	            String word2 = words[i+1];
	            int minLength = Math.min(word1.length(), word2.length());

	            // Find the first difference word1[k] != word2[k].
	            for (int k = 0; k < minLength; ++k) {

	                if (word1.charAt(k) != word2.charAt(k)) {

	                    // If they compare badly, it's not sorted.
	                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
	                        return false;

	                    break;
	                }
	            }

	            // If we didn't find a first difference in minLength and words until minLength are same.
	            // Example: ("apple", "app").
	            if(word1.substring(0, minLength).equals(word2.substring(0, minLength))) {

		            if (word1.length() > word2.length())
		                return false;
	            }
	        }

	        return true;
	    }

	public static void main(String[] args) {

		String order = "hlabcdefgijkmnopqrstuvwxyz";
//		String[] words = {"hello","leetcode"};
		String[] words = {"hlabcdefgijkmnopqrstuvwxy","z"};

//		String order = "worldabcefghijkmnpqstuvxyz";
//		String[] words = {"word","world","row"};

//		String order = "abcdefghijklmnopqrstuvwxyz";
//		String[] words = {"apple", "app"};


//		System.out.println(isAlienSorted(words, order));

//		String[] words = {"a","ba","abcd"};

		System.out.println(isAlienSorted2(words, order));
	}

	// Using Map or HashTable
	 public static boolean isAlienSorted2(String[] words, String order) {

		 if(words.length < 2) return true;

		 Map<Character, Integer> map = new HashMap<>();

		 for(int i = 0; i < order.length(); i++) {
			 map.put(order.charAt(i), i);
		 }
		 

		 for(int i = 0; i < words.length - 1; i++) {

			 if(!compare(words[i], words[i+1], map))
				 return false;
		 }

		 return true;
	 }

	 private static boolean compare(String string1, String string2, Map<Character, Integer> order) {

		int minLength = Math.min(string1.length(), string2.length());

		for(int i = 0; i < minLength; i++) {

			if(order.get(string1.charAt(i)) > order.get(string2.charAt(i))) return false;
		}

		//Example: ("apple", "app")
		 return !string1.substring(0, minLength).equals(string2.substring(0, minLength))
				 || string1.length() <= string2.length();
	 }

}
