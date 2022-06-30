package com.codingchallanges.array.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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
 * There are 2 non-repeating characters in the string: 'c' and 'd'. Return c since it appears in the string first.
 *
 * For s = "abacabaabacaba", the output should be
 * solution(s) = '_'.
 *
 * There are no characters in this string that do not repeat.
 *
 * Asked ask at Fidelity interview
 */
public class FirstNotRepeatingCharacter {

	public static char firstNotRepeatingCharacter(String s) {

	    Set<Character> visited = new HashSet<>();
	    LinkedList<Character> nonRepeatingChars = new LinkedList<>();

	    for(int i = 0; i < s.length(); i++){

	        Character c = s.charAt(i);

	        if(visited.contains(c)){
	        	nonRepeatingChars.remove(c);
	        } else {
	            visited.add(c);
	            nonRepeatingChars.add(c);
	        }
	    }

	    if(nonRepeatingChars.isEmpty())
	        return '_';
	    else
	        return nonRepeatingChars.getFirst();
	}

	public static void main(String[] args) {

		System.out.println(firstNotRepeatingCharacter("fbfgblknefvmstbnsdpfgjyhnrx,sm"));
	}

}
