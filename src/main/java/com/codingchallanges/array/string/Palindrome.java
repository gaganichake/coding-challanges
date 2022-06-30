package com.codingchallanges.array.string;

/*
 * checkPalindrome
 *
 * https://app.codesignal.com/arcade/intro/level-1/s5PbmwxfECC52PWyQ
 * Given the string, check if it is a palindrome.
 *
 *
 * https://leetcode.com/problems/valid-palindrome/
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
 * removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric
 * characters include letters and numbers. (Simply asking to ignore cases and special characters
 * but accepting letters and numbers)
 *
 *
 * *************************
 * 11/30/2021 - MetLife
 * Find if the give string is a Palindrome
 * Example: Borro or Rob?
 * Ignore cases, spaces and special characters
 *
 * Below all approaches use Two Pointers.
 *
 * Another good solution of this problem is, you just reverse the input String and compare
 * the new String with the original one. Java StringBuilder has an build-in method reverse()
 * to reverse the underling string and return a new one.
 */
public class Palindrome {

	/*
	 * When input is case sensitive (version 1)
	 */
	public static boolean checkPalindromeV1(String inputString) {

	    if(inputString == null || inputString.length() == 1) return true;

	    for(int i = 0; i < inputString.length(); i++){

	    	int oppositeIndex = inputString.length() - 1 - i;

	        if(inputString.charAt(i) != inputString.charAt(oppositeIndex)) return false;// Case sensitive comparison
	        if(i > oppositeIndex) break;
	    }

	    return true;
	}


	/*
	 * When input is case sensitive (version 2)
	 */
	public static boolean checkPalindromeV2(String s) {

		// Assuming zero or one length is a Palindrome
		if (s == null || s.length() < 2)
			return true;

		int low = 0, high = s.length() - 1;

		while (low < high) {
			if (s.charAt(low++) != s.charAt(high--))// Case sensitive comparison
				return false;
		}

		return true;
	}

	/*
	 * When input is case insensitive
	 */
	public static boolean isPalindromeIgnoreCase(String s) {

		// Assuming zero or one length is a Palindrome
		if (s == null || s.length() < 2)
			return true;

		int low = 0, high = s.length() - 1;

		while (low < high) {
			if (Character.toLowerCase(s.charAt(low++)) != Character.toLowerCase(s.charAt(high--)))// Case insensitive comparison
				return false;
		}

		return true;
	}

	/*
	 * When input is case insensitive and contains white spaces
	 */
	public static boolean isPalindromeIngoreCaseWhiteSpace(String s) {

		// Assuming zero or one length is a Palindrome
		if (s == null || s.length() < 2)
			return true;

		int low = 0, high = s.length() - 1;

		while (low < high) {

			while(Character.isWhitespace(s.charAt(low))) low++;//Ignoring white spaces

			while(Character.isWhitespace(s.charAt(high))) high--;//Ignoring white spaces

			if (Character.toLowerCase(s.charAt(low++)) != Character.toLowerCase(s.charAt(high--)))// Case insensitive comparison
				return false;
		}

		return true;
	}

	/*
	 * When input is case insensitive, contains white spaces and special characters like ? ! , #  and numbers
	 */
	public static boolean isPalindromeIgnoreCaseNumberSpecialChar(String s) {

		// Assuming zero or one length is a Palindrome
		if (s == null || s.length() < 2)
			return true;

		int low = 0, high = s.length() - 1;

		while (low < high) {

			while(low < high && !Character.isLetter(s.charAt(low))) low++;// Ignoring any special characters and numbers
			while(low < high && !Character.isLetter(s.charAt(high))) high--;// Ignoring any special characters and numbers

			if (Character.toLowerCase(s.charAt(low++)) != Character.toLowerCase(s.charAt(high--)))// Case insensitive comparison
				return false;
		}

		return true;
	}

	/*
	 * Leetcode
	 * When input is case insensitive, contains white spaces and special characters like ? ! , #
	 */
	public static boolean isPalindromeIgnoreCaseSpecialChar(String s) {

		// Assuming zero or one length is a Palindrome
		if (s == null || s.length() < 2)
			return true;

		int low = 0, high = s.length() - 1;

		while (low < high) {

			while(low < high && !Character.isLetter(s.charAt(low)) && !Character.isDigit(s.charAt(low))) low++;// Ignoring any special characters and numbers
			while(low < high && !Character.isLetter(s.charAt(high)) && !Character.isDigit(s.charAt(high))) high--;// Ignoring any special characters and numbers

			System.out.println(s.charAt(low) + " - " + s.charAt(high));

			if (Character.toLowerCase(s.charAt(low++)) != Character.toLowerCase(s.charAt(high--)))// Case insensitive comparison
				return false;
		}

		return true;
	}


	public static void main(String[] args) {

//		System.out.println(checkPalindromeV1(null));
//		System.out.println(checkPalindromeV1("p"));
//		System.out.println(checkPalindromeV1("ab"));
//		System.out.println(checkPalindromeV1("aba"));
//		System.out.println(checkPalindromeV1("abba"));
//		System.out.println(checkPalindromeV1("abBa"));
//
//		System.out.println(checkPalindromeV1("abBa"));
//
//		System.out.println(checkPalindromeV1("     bm m"));
//
//		System.out.println(checkPalindromeV1("Borro or Rob?"));
//		System.out.println(checkPalindromeV1("     bm m"));
//		System.out.println(isPalindromeIgnoreCaseSpecialChar(".,"));
//		System.out.println(isPalindromeIgnoreCaseSpecialChar("0P"));
		System.out.println(isPalindromeIgnoreCaseSpecialChar("ab2a"));
	}

}
