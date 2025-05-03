package com.codingchallanges.array.string;

/**
 * Edit Distance
 * <p>
 * <a href="https://leetcode.com/problems/one-edit-distance/">one-edit-distance</a>
 * <a href="https://www.facebook.com/careers/life/sample_interview_questions">sample_interview_questions</a>
 * <p>
 * Write a function that returns whether two words are exactly "one edit" away using the
 * following signature:
 * <p>
 * boolean OneEditApart(string s1, string s2);
 * <p>
 * An edit is:
 * - Inserting one character anywhere in the word (including at the beginning and end)
 * - Removing one character
 * - Replacing one character
 * <p>
 * (This algorithm can be used in a full-text search engine where you want to add searches that
 * are only One Edit Apart from the input key.)
 * <p>
 * Examples:
 * OneEditApart("cat", "dog") = false
 * OneEditApart("cat", "cats") = true
 * OneEditApart("cat", "cut") = true
 * OneEditApart("cat", "cast") = true
 * OneEditApart("cat", "at") = true
 * OneEditApart("cat", "act") = false
 * <p>
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

	public static boolean isOneEditDistance1(String shorter, String longer) {

		// Ensure that left String is shorter than right one.
		if (shorter.length() > longer.length())
			return isOneEditDistance1(longer, shorter);

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

	//One more implementation
	public static boolean isOneEditDistance2(String s1, String s2) {

		if(s1 == null || s2 == null) return false;

		if(s1.length() < s2.length()) isOneEditDistance2(s2, s1);//Keeping s1 to be a longer string

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

	private static boolean isOneEditDistance3(String key, String doc) {

		System.out.print("key = " + key + ", doc = " + doc + " | ");

		return  (key.length() == doc.length() && processSameLength(key, doc))
				|| processDiffLength(key, doc);
	}

	private static boolean processDiffLength(String longStr, String shortSrt) {

		if(longStr.length() < shortSrt.length()) return processDiffLength(shortSrt, longStr);

		if(longStr.length() - shortSrt.length() > 1) return false;

		if(shortSrt.length() == longStr.length()-1 && longStr.indexOf(shortSrt) > -1) return true;

		int errorCount = 0;

		for(int i = 0; i < shortSrt.length(); i++) {

			if(errorCount > 1) return false;

			if(shortSrt.charAt(i) - longStr.charAt(i+errorCount) != 0) errorCount++;
		}

		return errorCount == 1;
	}

	private static boolean processSameLength(String key, String doc) {

		int errorCount = 0;

		for(int i = 0; i < key.length(); i++) {

			if(errorCount > 1) return false;

			if(key.charAt(i) - doc.charAt(i) != 0) errorCount++;
		}

		return errorCount == 1;
	}
}
