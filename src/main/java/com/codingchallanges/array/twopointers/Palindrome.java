package com.codingchallanges.array.twopointers;

/**
 * checkPalindrome
 * <p>
 * <a href="https://app.codesignal.com/arcade/intro/level-1/s5PbmwxfECC52PWyQ">checkPalindrome</a>
 * Given the string, check if it is a palindrome.
 * *************************
 * <p>
 * <a href="https://leetcode.com/problems/valid-palindrome/">valid-palindrome</a>
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
 * removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric
 * characters include letters and numbers. (Simply asking to ignore cases and special characters
 * but accepting letters and numbers)
 * <p>
 * *************************
 * <p>
 * 11/30/2021 - MetLife
 * Find if the give string is a Palindrome
 * Example: Borro or Rob?
 * Ignore cases, spaces and special characters
 * *************************
 * <p>
 * Below all approaches use Two Pointers.
 * <p>
 * Another good solution of this problem is, you just reverse the input String and compare
 * the new String with the original one. Java StringBuilder has a build-in method reverse()
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
	 * Simplified
	 * When input is case insensitive, contains white spaces and special characters like ? ! , #  and numbers
	 */
	public static boolean isPalindromeIgnoreCaseNumberSpecialCharV2(String s) {

		if (s == null) throw new IllegalArgumentException();
		if (s.isEmpty() || s.length() == 1) return true;

		s = s.toLowerCase();
		char[] chars = s.toCharArray();

		int i = 0;
		int j = chars.length - 1;
		while (i < j) {

			while (i < j && !Character.isAlphabetic(chars[i])) { i++;}
			while (i < j && !Character.isAlphabetic(chars[j])) { j--;}

			if (chars[i] != chars[j]) {
				return false;
			}
			i++;
			j--;
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

//        System.out.println(isPalindromeIgnoreCaseNumberSpecialChar(null));
		System.out.println("p ->" + isPalindromeIgnoreCaseNumberSpecialChar("p"));
		System.out.println("ab ->" + isPalindromeIgnoreCaseNumberSpecialChar("ab"));
		System.out.println("aba ->" + isPalindromeIgnoreCaseNumberSpecialChar("aba"));
		System.out.println("abba ->" + isPalindromeIgnoreCaseNumberSpecialChar("abba"));
		System.out.println("abBa ->" + isPalindromeIgnoreCaseNumberSpecialChar("abBa"));
		System.out.println("abCa ->" + isPalindromeIgnoreCaseNumberSpecialChar("abCa"));
		System.out.println("     bm m ->" + isPalindromeIgnoreCaseNumberSpecialChar("     bm m"));
		System.out.println("Borro or Rob? ->" + isPalindromeIgnoreCaseNumberSpecialChar("Borro or Rob?"));
		System.out.println("M  m   bm m ->" + isPalindromeIgnoreCaseNumberSpecialChar("M  m   bm m"));
		System.out.println("., ->" + isPalindromeIgnoreCaseNumberSpecialChar(".,"));
		System.out.println("0P ->" + isPalindromeIgnoreCaseNumberSpecialChar("0P"));
		System.out.println("ab2a ->" + isPalindromeIgnoreCaseNumberSpecialChar("ab2a"));
	}

}
