package com.codingchallanges.stack;

import java.util.Stack;

/*
 * https://www.hackerrank.com/challenges/balanced-brackets/problem
 */
public class BalancedBrackets {

	public static boolean isBalanced(String s) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			if (isOpening(s.charAt(i)))
				stack.push(s.charAt(i));

			if (isClosing(s.charAt(i))) { // The String contains characters other than brackets then use both isOpening & isClosing checks.

				if (stack.isEmpty() || getClosing(stack.pop()) != s.charAt(i))
					return false;
			}
		}

		System.out.println("stack: " + stack);// Stack will not be empty if the last bracket is unbalanced

		return stack.isEmpty();
	}

	private static char getClosing(char braket) {
		switch (braket) {
		case '{':
			return '}';
		case '(':
			return ')';
		case '[':
			return ']';
		default:
			return ' ';
		}
	}

	private static boolean isOpening(char c) {
		return c == '(' || c == '{' || c == '[';
	}

	private static boolean isClosing(char c) {
		return c == ')' || c == '}' || c == ']';
	}

	public static void main(String[] args) {

		System.out.println(isBalanced("]"));
		System.out.println(isBalanced("["));
		System.out.println(isBalanced("{{[[(((((((())]]}}"));
		System.out.println(isBalanced("{[()]}"));
		System.out.println(isBalanced("{[(])}"));
		System.out.println(isBalanced("{{[[(())]]}}"));
		System.out.println(isBalanced("{{[[(())]]}}("));

	}

}
