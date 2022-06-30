package com.codingchallanges.array.sort;

import java.util.*;

/*
 * CTCI 11.2
 *
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 * Note: The strings in the result array do not need to be fully sorted.
 */
public class SortAnagramStrings {

	// Time complexity:  O(n log(n))
	// This algorithm performs sorting which is not a goal. We only need to group the anagrams.
	public static void sortByAnagramStrings(String[] array) {

		Arrays.sort(array, new AnagramComparator());
	}

	// Time complexity: O(n)
	// Using bucket sort
	public static void sortByAnagramStrings2(String[] array) {

		Map<String, List<String>> map = new HashMap<>();

		//Collect anagrams
		for(String str :  array) {

			String key = sortedCharString(str);

			if(!map.containsKey(key)) {

				map.put(key, new ArrayList<>());
			}

			List<String> anagrams = map.get(key);
			anagrams.add(str);
		}

		int index = 0;

		//Arrange anagrams
		for(String key : map.keySet()) {

			List<String> anagrams = map.get(key);

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
//		sortByAnagramStrings(array);
		sortByAnagramStrings2(array);

		System.out.print(Arrays.toString(array));

	}

}
