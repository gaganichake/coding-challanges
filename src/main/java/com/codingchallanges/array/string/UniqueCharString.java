package com.codingchallanges.array.string;

import java.util.HashSet;
import java.util.Set;

/*
 * CTCI 1.1
 *
 * Implement an algorithm to determine if a string has all unique characters.
 */
public class UniqueCharString {

	public static boolean isUniqueCharString(String s) {

		//If character is ASCII, total number a valid unique character can be at most 128.
		if(s == null || s.isEmpty() || s.length() > 128) return false;

		Set<Character> charSet = new HashSet<>();// Alternatively you may create an array of booleans to mark the occurrence of a character.

		for(int index = 0; index < s.length(); index++) {

			if(charSet.contains(s.charAt(index)))
				return false;
			else
				charSet.add(s.charAt(index));
		}

		return true;
	}

	public static void main(String[] args) {

		System.out.println("Is unique Character String : " + isUniqueCharString("Gagan"));

//		for(int i = 0; i <128 ; i++) {
//			System.out.println(i + " = " + (char) i);
//		}

	}

}
