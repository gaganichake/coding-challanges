package com.codingchallanges.array.string;

/**
 * Write a function to revere a String.
 * <p>
 * Amazon interview question: live coding challenge.
 * September 18, 2020
 */
public class ReverseString {

	// Using StringBuffer. O(1)
	public static String reverseString1(String s) {

		return new StringBuffer(s).reverse().toString();
	}

	// Using Character array. O(n)
	public static String reverseString2(String s) {

		char[] c = new char[s.length()];

		for(int i = 0; i < s.length(); i++) {

			c[s.length() - i - 1] = s.charAt(i);
		}

		return new String(c);
	}

	// Using Character array. O(n/2) = O(n)
	public static String reverseString(String s) {

		char[] c = new char[s.length()];

		for(int i = 0; i < s.length(); i++) {

			c[s.length() - 1 - i] = s.charAt(i);
			c[i] = s.charAt(s.length() - 1 - i);

			if(i >= s.length() - 1 - i) {
				break;
			}
		}

		return new String(c);
	}

	public static void main(String[] args) {

		System.out.println(reverseString(""));
		System.out.println(reverseString("a"));
		System.out.println(reverseString("abcdef"));
		System.out.println(reverseString("abcdefg"));
	}

}
