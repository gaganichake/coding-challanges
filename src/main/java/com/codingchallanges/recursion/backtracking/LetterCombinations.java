package com.codingchallanges.recursion.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {

	private final static Map<String, String>  phone = new HashMap<>();

	public static List<String> letterCombinations(String digits) {

		phone.put("2", "abc");
		phone.put("3", "def");
		phone.put("4", "ghi");
		phone.put("5", "jkl");
		phone.put("6", "mno");
		phone.put("7", "pqrs");
		phone.put("8", "tuv");
		phone.put("9", "wxyz");

		List<String> output = new ArrayList<>();

		letterCombinations(digits, "", output);

		return output;
	}

	public static void letterCombinations(String digits, String newCombination, List<String> output) {

		// if there is no more digits to check
		if (digits.length() == 0) {
			// the combination is done
			output.add(newCombination);
//			System.out.println("newCombination: " + newCombination);

		} else {

			// if there are still digits to check
			String digit = digits.substring(0, 1);//Pick first digit from the remaining digits

			// Iterate over all letters which map
			// the next available digit
			String letters = phone.get(digit);

			for (int i = 0; i < letters.length(); i++) {

				char letter = letters.charAt(i);
//				System.out.println("add (" + letter + "): " + newCombination + letter);

				// append the current letter to the combination
				// and proceed to the next digits
				letterCombinations(digits.substring(1), newCombination + letter, output);//remaining digits
//				System.out.println("return: " + newCombination);
			}
		}
	}

	public static void main(String[] args) {

		//System.out.println(letterCombinations(""));
		//System.out.println(letterCombinations("2"));
		System.out.println(letterCombinations("23"));

	}

}
