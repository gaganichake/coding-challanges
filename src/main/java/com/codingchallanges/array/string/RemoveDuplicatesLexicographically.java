package com.codingchallanges.array.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Google technical interview (I) Sep/17/2021
 * <p>
 * Given a String, remove all duplicate character from the String maintaining all
 * unique characters in lexicographically order.
 */
public class RemoveDuplicatesLexicographically {

	public static String removeDuplicatesLexicographically(String s) {

		Map<Character, List<Integer>> map = new HashMap<>();

		for(int i = 0; i < s.length(); i++) {

			char c  = s.charAt(i);
			List<Integer> list = map.getOrDefault(c, new ArrayList<>());
			list.add(i);
			map.put(c, list);
		}

		System.out.println(map);

		for(int i = 0; i < s.length()-1; i++) {

			char c  = s.charAt(i);

			List<Integer> list = map.get(c);

			if(list.size() > 1) {

				if(c > s.charAt(i+1)) {
					list.remove(0);
				} else {
					list = new ArrayList<>();
					list.add(i);
					map.put(c, list);// here the list size will always be 1
				}
			}
		}

		System.out.println(map);

		char[] charArray = new char[s.length()];//I originally used "new char[map.size()];" in the interview. That was the only mistake.

		for(char c : map.keySet()) {

			charArray[map.get(c).get(0)] = c;

		}

//		for(int i = 0; i < charArray.length; i++) {

//			System.out.print(charArray[i] + ",");// You can see the array has empty element that will be ignored while creating a String
//		}
//		System.out.println();

		return new String(charArray);
	}

	public static void main(String[] args) {

		System.out.println(removeDuplicatesLexicographically("level"));//Expected output : evl

	}

	// Incorrect result
//	private static String removeDuplicatesLexicographically(String inputString) {
//
//		SortedSet set = new TreeSet<Character>();
//
//		char[] chArr = inputString.toCharArray();
//
//		for (char ch :  chArr){
//
//			set.add(ch);
//		}
//		StringBuffer sb = new StringBuffer();
//
//		set.forEach(c -> sb.append(c));
//
//		return sb.toString();
//	}
}
