package com.codingchallanges.array.string;

public class IsSortedLexicographically {

	public static void main(String[] args) {

//		String[] words = {"a","ab","abc"};
//		String[] words = {"a","ab","abc","a"};
//		String[] words = {"a","b","abc"};
//		String[] words = {"a","ba","abcd"};
//		String[] words = {"word","world","row"};
//		String[] words = {"apple","app"};
//		String[] words = {"app", "apple"};
		String[] words = {"abcdef", "gh"};

		System.out.println(isSortedLexicographically(words));

	}

	 public static boolean isSortedLexicographically(String[] words) {

		 if(words.length < 2) return true;

		 for(int i = 0; i < words.length - 1; i++) {

			 if(!compare(words[i], words[i+1]))
				 return false;
		 }

		 return true;
	 }

	private static boolean compare(String string1, String string2) {

		int minLength = Math.min(string1.length(), string2.length());

		for(int i = 0; i < minLength; i++) {

			if(string1.charAt(i) > string2.charAt(i)) return false;
		}

		if(string1.substring(0, minLength).equals(string2.substring(0, minLength))) {
			return string1.length() <= string2.length();
		}

		return true;
	}
}
