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

	public static void main(String[] args) {

		System.out.println(reverseInParentheses("(bar)"));

	}

}
