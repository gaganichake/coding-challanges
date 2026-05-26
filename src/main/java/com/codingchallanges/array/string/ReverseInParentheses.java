package com.codingchallanges.array.string;
/**
 * reverseInParentheses
 * <p>
 * <a href="https://app.codesignal.com/arcade/intro/level-3/9DgaPsE2a7M6M2Hu6">reverseInParentheses</a>
 * <p>
 * Write a function that reverses characters in (possibly nested) parentheses in the input string.
 * <p>
 * Input strings will always be well-formed with matching ()s.
 * <p>
 * Example:
 * <p>
 * For inputString = "(bar)", the output should be solution(inputString) = "rab";
 * <p>
 * For inputString = "foo(bar)baz", the output should be solution(inputString) = "foorabbaz";
 * <p>
 * For inputString = "foo(bar)baz(blim)", the output should be solution(inputString) = "foorabbazmilb";
 * <p>
 * For inputString = "foo(bar(baz))blim", the output should be solution(inputString) = "foobazrabblim". Because "foo(bar(baz))blim" becomes "foo(barzab)blim" and then "foobazrabblim".
 */

public class ReverseInParentheses {

	private static String reverseInParentheses(String inputString) {

		if (inputString == null || inputString.isEmpty()
				|| (inputString.indexOf('(') == -1 && inputString.indexOf(')') == -1))
			return inputString;

		StringBuilder sb = new StringBuilder();

		String start = inputString.substring(0, inputString.lastIndexOf('('));
		sb.append(start);

		String end = inputString.substring(inputString.lastIndexOf('(') + 1);
		String middle = end.substring(0, end.indexOf(')'));
		sb.append(new StringBuffer(middle).reverse());

		end = end.substring(end.indexOf(')') + 1);
		sb.append(end);

		return reverseInParentheses(sb.toString());
	}

	// New approach
	private static String reverseInParentheses2(String inputString) {

		if(!inputString.contains("(")) return inputString;

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < inputString.length(); i++) {

			char ch = inputString.charAt(i);

			if(ch == ')') {
				String substring = sb.substring(sb.lastIndexOf("(")+1, sb.length());
//                System.out.println("Substring: " + substring);
				sb.replace(sb.lastIndexOf("("), sb.length(), new StringBuilder(substring).reverse().toString());
			} else {
				sb.append(ch);
			}
		}
//        System.out.println("Intermediate: " + sb);
		return reverseInParentheses(sb.toString());
	}

	public static void main(String[] args) {

		System.out.println("Output: " + reverseInParentheses2("(bar)")); // Output: "rab"
		System.out.println("Output: " + reverseInParentheses2("foo(bar)baz")); // Output: "foorabbaz"
		System.out.println("Output: " + reverseInParentheses2("foo(bar)baz(blim)")); // Output: "foorabbazmilb"
		System.out.println("Output: " + reverseInParentheses2("foo(bar(baz))blim")); // Output: "foobazrabblim"

	}

}
