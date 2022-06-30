package com.codingchallanges.array.string;

/*
 * Given a string s, return true if the s can be palindrome after deleting at
 * most one character from it.
 *
 * https://leetcode.com/problems/valid-palindrome-ii/
 *
 * Approach #1: Brute Force : For each index i in the given string, let's remove that
 * character, then check if the resulting string is a palindrome. If it is, (or if the
 * original string was a palindrome), then we'll return true
 *
 * Approach #2: Greedy : If the beginning and end characters of a string are the same
 * (ie. s[0] == s[s.length - 1]), then whether the inner characters are a palindrome
 * (s[1], s[2], ..., s[s.length - 2]) uniquely determines whether the entire string
 * is a palindrome.
 */
public class MakePalindrome {

	//Approach #1: Brute force
//	public static int makePalindromeBruteForce(String s) {
		//TODO
//	}

	// Approach #2: Greedy
    public static boolean makePalindrome(String s) {

    	int low = 0, high = s.length() - 1;

		while (low < high) {

			if (s.charAt(low) != s.charAt(high)){// Case sensitive comparison

				return isPalindrome(s, low+1, high) || isPalindrome(s, low, high-1);

			}
			low++;
			high--;
		}
		return true;//No need to remove a character
    }

	/*
	 * When input is case sensitive
	 */
	public static boolean isPalindrome(String s, int low, int high) {

		// Assuming zero or one length is a Palindrome
		if (s == null || s.length() < 2)
			return true;

		while (low < high) {
			if (s.charAt(low++) != s.charAt(high--))// Case sensitive comparison
				return false;
		}

		return true;
	}

	public static void main(String[] args) {

		System.out.println("Removing character at this index will make the String Palindrome:");
		System.out.println(makePalindrome("p"));
		System.out.println(makePalindrome("ab"));
		System.out.println(makePalindrome("aba"));
		System.out.println(makePalindrome("abba"));
		System.out.println(makePalindrome("abca"));
		System.out.println(makePalindrome("abcdef"));
	}

}
