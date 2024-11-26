package com.codingchallanges.hashtable;

import java.util.*;

/*
 * firstNotRepeatingCharacter
 *
 * https://app.codesignal.com/interview-practice/task/uX5iLwhc6L5ckSyNC/description
 *
 * Given a string s consisting of small English letters, find and return the first
 * instance of a non-repeating character in it. If there is no such character, return '_'.
 *
 * Example
 *
 * For s = "abacabad", the output should be
 * solution(s) = 'c'.
 *
 * There are 2 non-repeating characters in the string: 'c' and 'd'. Return 'c' since it appears in the string first.
 *
 * For s = "abacabaabacaba", the output should be
 * solution(s) = '_'.
 *
 * There are no characters in this string that do not repeat.
 *
 * Asked ask at Fidelity interview
 */
public class FirstNotRepeatingCharacter {

	// O(n x n)
	private static char firstNotRepeatingCharacter(String s) {

		Set<Character> visited = new HashSet<>();
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);

			StringBuilder sb = new StringBuilder(s.substring(i+1));

			if(!visited.contains(ch) && sb.indexOf(ch+"") < 0) return ch; // Scanning substring is like doing O(n x n)

			visited.add(ch);
		}

		return '_';
	}

	// Best approach. O(n)
	public static char firstNotRepeatingCharacterV2(String s) {

	    Set<Character> visited = new HashSet<>();
	    LinkedList<Character> visitedOnlyOnce = new LinkedList<>();

	    for(int i = 0; i < s.length(); i++){

	        Character c = s.charAt(i);

	        if(visited.contains(c)){
	        	visitedOnlyOnce.remove(c);
	        } else {
	            visited.add(c);
	            visitedOnlyOnce.add(c);
	        }
	    }

	    if(visitedOnlyOnce.isEmpty())
	        return '_';
	    else
	        return visitedOnlyOnce.getFirst();
	}

	// Second approach. O(n+n) = O(n)
	public static char firstNotRepeatingCharacterV3(String s) {

		Map<Character, Integer> map = new HashMap<>();

		for(int i = 0; i < s.length(); i++){

			map.put(s.charAt(i), map.getOrDefault((new Character(s.charAt(i))), 0) + 1);
		}

		for(int i = 0; i < s.length(); i++){
			if(map.get(s.charAt(i)) == 1) return s.charAt(i);
		}

		return '_';
	}

	public static void main(String[] args) {

		System.out.println(firstNotRepeatingCharacterV2("abacabad"));
		System.out.println(firstNotRepeatingCharacterV2("abacabaabacaba"));
		System.out.println(firstNotRepeatingCharacterV2("fbfgblknefvmstbnsdpfgjyhnrxsm"));
	}

}
