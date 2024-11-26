package com.codingchallanges.array.sort;

import java.util.*;

/*
 * CTCI 11.2
 *
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 * Note: The strings in the result array do not need to be fully sorted.
 */
public class SortByAnagramStrings {

	// Time complexity:  O(n log(n))
	// This algorithm performs sorting which is not a goal. We only need to group the anagrams.
	// Though this is a valid solution
	public static void sortByAnagramStrings(String[] array) {

		Arrays.sort(array, (s1, s2) -> {
			char[] chArr1 = s1.toCharArray();
			Arrays.sort(chArr1);
			char[] chArr2 = s2.toCharArray();
			Arrays.sort(chArr2);
			return new String(chArr1).compareTo(new String(chArr2));
		});
	}

	// Time complexity: O(n)
	// Using bucket sort
	public static void sortByAnagramStrings2(String[] array) {

		Map<String, List<String>> map = new HashMap<>();

		//Collect anagrams
		for(String str :  array) {

			String key = sortedCharString(str);

			List<String> anagrams = map.getOrDefault(key, new ArrayList<>());
			anagrams.add(str);
			map.put(key, anagrams);
		}

		int index = 0;

		//Arrange anagrams
		for(List<String> anagrams : map.values()) {

			for(String str : anagrams) {
				array[index++] = str;
			}
		}
	}

	public static String sortedCharString(String str) {

		char[] cArr = str.toCharArray();

		Arrays.sort(cArr);

		return new String(cArr);
	}

	public static void main(String[] args) {

		String[] array = "a bored cat act boerd a".split(" ");
		sortByAnagramStrings(array);

//		sortByAnagramStrings2(array);

		System.out.print(Arrays.toString(array));

	}

}
