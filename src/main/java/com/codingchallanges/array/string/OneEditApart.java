package com.codingchallanges.array.string;

/*
 * Edit Distance
 *
 * https://leetcode.com/problems/one-edit-distance/
 * https://www.facebook.com/careers/life/sample_interview_questions
 *
 * Write a function that returns whether two words are exactly "one edit" away using the
 * following signature:
 *
 * boolean OneEditApart(string s1, string s2);
 *
 * An edit is:
 * - Inserting one character anywhere in the word (including at the beginning and end)
 * - Removing one character
 * - Replacing one character
 *
 * (This algorithm can be used in a full-text search engine where you want to add searches that
 * are only One Edit Apart from the input key.)
 *
 * Examples:
 * OneEditApart("cat", "dog") = false
 * OneEditApart("cat", "cats") = true
 * OneEditApart("cat", "cut") = true
 * OneEditApart("cat", "cast") = true
 * OneEditApart("cat", "at") = true
 * OneEditApart("cat", "act") = false
 *
 * Solution:
 * There are many solutions to this problem. One optimal solution is to walk each string in
 * unison, tracking if a difference has been encountered. If a second difference is
 * encountered, return false.
 * If one string is longer than the other, then the difference must
 * mean it is an insertion, so skip a character in the longer string and continue.
 * Additionally, there are symmetry and short circuit opportunities.
 *
 */
public class OneEditApart {

	public static boolean isOneEditDistance(String shorter, String longer) {

		// Ensure that left String is shorter than right one.
		if (shorter.length() > longer.length())
			return isOneEditDistance(longer, shorter);

		// The strings are NOT one edit away distance
		// if the length difference is more than 1.
		if (longer.length() - shorter.length() > 1) // edge case
			return false;

		//if(shorter.equals(longer)) return false; // will be covered

		for (int i = 0; i < shorter.length(); i++) {

			if (shorter.charAt(i) != longer.charAt(i)) { // As soon as you find the first difference

				// if strings have the same length
				if (shorter.length() == longer.length()) {

					return shorter.substring(i + 1).equals(longer.substring(i + 1));// Compare rest of the substrings

				} else { // if strings have different lengths

					return shorter.substring(i).equals(longer.substring(i + 1));
				}
			}
		}

		// If there is no differences on shorter.length() distance
		// then the strings are one edit away only if
		// longer String has one more character. Example: cat & cats
		return longer.length() - shorter.length() == 1;
	}

	public static void main(String[] args) {

		System.out.println(isOneEditDistance1("cat", "dog"));//false
		System.out.println(isOneEditDistance1("cat", "cats"));//true
		System.out.println(isOneEditDistance1("cat", "cut"));//true
		System.out.println(isOneEditDistance1("cat", "cast"));//true
		System.out.println(isOneEditDistance1("cat", "at"));//true
		System.out.println(isOneEditDistance1("cat", "act"));//false
		System.out.println(isOneEditDistance1("abcc", "accc"));//true
		System.out.println(isOneEditDistance1("abc", "abc"));//false
	}

	//One more implementation
	public static boolean isOneEditDistance1(String s1, String s2) {

		if(s1 == null || s2 == null) return false;

		if(s1.length() < s2.length()) isOneEditDistance1(s2, s1);//Keeping s1 to be a longer string

		if(s1.length() - s2.length() > 1) return false;

		int countDiff = 0;

		if(s1.length() == s2.length()) {
			for(int i = 0; i < s1.length(); i++) {

				if(s1.charAt(i) != s2.charAt(i)) {
					countDiff++;
				}
			}

			return countDiff == 1;

		} else {
			//removal required
			for(int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {

				if(s1.charAt(i) != s2.charAt(j)) {
					countDiff++;
					i++;
				}
			}

			return countDiff < 2; // 0 if difference found beyond s2.length()
		}


	}
}
