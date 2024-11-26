package com.codingchallanges.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Design an algorithm to print all permutation of a string. For simplicity, assume all characters are unique.  
 */
public class StringPermutation {

	/*
	 * Using recursion
	 */
	public static void printPermutation(String s) {

		String newCombination = "";

		printPermutation(s, newCombination);
	}

	private static void printPermutation(String s, String newCombination) {

//		 If string is empty
		if (s.length() == 0) {

			System.out.println(newCombination);
			return;
		}

//      If all characters are NOT unique then print only distinct permutations
//      Make a boolean array of size '26' which stores false by default and make true 
//      at the position which alphabet is being used
//      boolean alpha[] = new boolean[26];

		for (int i = 0; i < s.length(); i++) {

//			 ith character of s
			char ch = s.charAt(i);

			// Rest of the string after excluding the ith character
			String restString = s.substring(0, i) + s.substring(i + 1);

//			 If the character has not been used then recursive call will take place.
//			 Otherwise, there will be no recursive call
//            if (!alpha[ch - 'a'])
//			 Recursive call
			printPermutation(restString, newCombination + ch);
//			alpha[ch - 'a'] = true;
		}
	}
	
	/*
	 * Using backtracking
	 */
	public static void generatePermutation(String str) {
	
		generatePermutation(str, 0, str.length());
	}

	private static void generatePermutation(String str, int start, int end) {
		// Prints the permutations
		if (start == end - 1)
			System.out.println(str);
		else {
			for (int i = start; i < end; i++) {
				// Swapping the string by fixing a character
				str = swapString(str, start, i);
				// Recursively calling function generatePermutation() for rest of the characters
				generatePermutation(str, start + 1, end);
				// Backtracking - swapping the characters again.
				str = swapString(str, start, i);
			}
		}
	}
	
	// Function for swapping the characters at position i with character at position j
	private static String swapString(String a, int i, int j) {
		char[] b = a.toCharArray();
		char ch;
		ch = b[i];
		b[i] = b[j];
		b[j] = ch;
		return String.valueOf(b);
	}
	
	
	/*
	 * Standard Backtracking technique
	 */
	public static List<String> permute(String str) {
		
		List<String> output = new ArrayList<>();
		
		permute(str, new ArrayList<>(), output);
		
		return output;
	}
	

	private static void permute(String str, List<Character> newCombination, List<String> output) {

		if(newCombination.size() == str.length()) {
			output.add(characterToString(newCombination));
		} else {
			
			for(int i = 0; i < str.length(); i++) {
				
				if(!newCombination.contains(str.charAt(i))){
					
					newCombination.add(str.charAt(i));
					
					permute(str, newCombination, output);
					
					newCombination.remove(newCombination.size() - 1);
				}
			}
		}
	}
	
	private static String characterToString(List<Character> list) {

//		char[] array = new char[list.size()];
//		for(int i = 0; i < array.length; i++) {
//			array[i] = list.get(i);
//		}
//
//		return new String(array);

		return list.stream().map(ch -> ch.toString()).reduce("", (a, b) -> a + b);
	}

	public static void main(String[] args) {

		String s = "abc";
		
//		System.out.println("printPermutation(s):");
//		printPermutation(s);
//		System.out.println("generatePermutation(s):");
//		generatePermutation(s);
		System.out.println("permute(s):");
		System.out.println(permute(s));

	}

}
