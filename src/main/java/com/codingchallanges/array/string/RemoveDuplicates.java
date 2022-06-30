package com.codingchallanges.array.string;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static String removeDuplicates(String s) {

		StringBuilder sb = new StringBuilder(s);

		Set<Character> set = new HashSet<>();

		for(int i = 0; i < sb.length(); i++) {

			if(set.contains(sb.charAt(i))) {

				sb.deleteCharAt(i--);

			} else {

				set.add(sb.charAt(i));
			}

		}

		return sb.toString();
	}

	public static void main(String[] args) {

		System.out.println(removeDuplicates("ABCDEEFGHAIJCDKLMNOGPQRSTUVVUWXYZ"));

	}

}
