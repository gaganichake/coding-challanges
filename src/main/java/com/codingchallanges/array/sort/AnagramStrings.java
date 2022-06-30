package com.codingchallanges.array.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * isAnagramStrings
 *
 * Hint: Sorting is the key to solve this problem.
 *
 * https://app.codesignal.com/
 *
 * Find if two sentences s and t are anagrams. Meaning they can be made equals to each
 * other by changing the position of the words or by changing the position of letters
 * within a word or by doing both.
 *
 * A letter in word A can not be swapped with a letter in word B.
 * Also you can not split any word.
 *
 * It is guaranteed that the input sentences will have at least one word and all words
 * will be separated by one space. Also, no sentence will start or begin with a space.
 */
public class AnagramStrings {

	public static boolean isAnagramStrings(String s, String t) {

		if(s.length() != t.length()) return false;

		List<String> listS = splitAndSort(s);

		List<String> listT = splitAndSort(t);

		if(listS.size() != listT.size()) return false;

		for(int i = 0; i < listS.size(); i++){
			if(!listS.get(i).equals(listT.get(i))) return false;
		}

		return true;
	}

	private static List<String> splitAndSort(String str) {

		String[] strArray = str.split(" ");
		char[] cArray;
		List<String> list =  new ArrayList<>();

		for (String s : strArray) {
			cArray = s.toCharArray();
			Arrays.sort(cArray);
			list.add(new String(cArray));
		}
		Collections.sort(list);
		return list;
	}

	public static void main(String[] args) {

		System.out.println(isAnagramStrings("a bored cat", "act boerd a") );

		System.out.println(isAnagramStrings("abc abcdef mom abcdefgh", "bca abcefd abcdefgh mo") );

	}

}
