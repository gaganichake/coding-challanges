package com.codingchallanges.array.string;

/**
 * CTCI 1.4
 * <p>
 * Write a method to replace all spaces in a string with '%20'. You may assume that the
 * string has sufficient space at the end of the string to hold the additional characters,
 * and that you are given the "true" length of the string.
 */
public class ReplaceSpaces {

	public static String replaceSpaces(String s) {
		
		char[] c = s.toCharArray();
		
		replaceSpaces(c);
		
		return new String(c);
	}
	
	public static void replaceSpaces(char[] c) {
		
		
		for(int i = 0; i < c.length; i++) {
			
			if(c[i] == ' ') {
				shift(c, i);
				c[i] = '%';
				c[i+1] = '2';
				c[i+2] = '0';
				i+=2;
			}
		}
	}
	
	private static void shift(char[] c, int at) {

		if (c.length - 1 - (at + 2) >= 0) System.arraycopy(c, at + 3 - 2, c, at + 3, c.length - 1 - (at + 2));
	}
	
	// If you are give the true length of the string.
	public static String replaceSpaces(String s, int length) {
		
		char[] c = s.toCharArray();
		
		replaceSpaces(c, length);
		
		return new String(c);
	}
	
	// If you are give the true length of the string.
	public static void replaceSpaces(char[] c, int length) {
		
		
		for(int i = length, j =  c.length - 1; i >= 0; i--, j--) {
			
			if(c[i] == ' ') {
				c[j - 2] = '%';
				c[j - 1] = '2';
				c[j] = '0';
				j-=2;
			} else {
				c[j] =  c[i];
			}
		}
	}

	public static String replaceSpacesStringBuilder(String s) {

		StringBuilder sb = new StringBuilder();
		char last = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				if(last != ' ') sb.append("%20");
			} else {
				sb.append(s.charAt(i));
			}
			last = s.charAt(i);
		}
		if(last == ' ') sb.delete(sb.length() - 3, sb.length()); // remove the last "%20"
		return sb.toString();
	}
	
	public static void main(String[] args) {

		System.out.println(replaceSpaces(" This is a nice day          ")); // Output: %20This%20is%20a%20nice%20day
//		System.out.println(replaceSpaces("     This is a nice day      ", 18)); //work on this
	}

}
