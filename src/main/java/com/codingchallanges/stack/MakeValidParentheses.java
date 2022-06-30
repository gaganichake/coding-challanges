package com.codingchallanges.stack;

/*
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * 
 * Return any one valid result.
 * 
 * Also see https://leetcode.com/problems/remove-invalid-parentheses/
 */
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class MakeValidParentheses {

	// Approach 1: Using a Stack and String Builder
	public static String minRemoveToMakeValid(String s) {

		if (s == null || s.length() == 0)
			return "";

		Stack<Integer> stack = new Stack<>();// To store the indices not the Parentheses
		Set<Integer> deleteAt = new HashSet<>();// To store the indices not the Parentheses

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == ')') {

				if (stack.isEmpty()) {
					deleteAt.add(i);// Delete the closing Parentheses if not balanced.
				} else {
					stack.pop();
				}
			}

			if (s.charAt(i) == '(') {
				stack.add(i);
			}
		}

		// Stack will not be empty if there are opening Parentheses at the end the string
		while (!stack.isEmpty()) {
			deleteAt.add(stack.pop());// Also delete the opening Parentheses if not balanced.
		}

		// Instead of deleting the character from the existing String you
		// can create a new String which does not contain those character.
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (!deleteAt.contains(i)) {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	
	// Approach 2: Two Parse String Builder
    public String minRemoveToMakeValid2(String s) {
        StringBuilder result = removeInvalidClosing(s, '(', ')');// Delete the closing Parentheses if not balanced.
        result = removeInvalidClosing(result.reverse(), ')', '(');// Delete the opening Parentheses if not balanced.
        return result.reverse().toString();
    }
    
    private StringBuilder removeInvalidClosing(CharSequence string, char open, char close) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;//Use can also use a Stack
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == open) {
                balance++;//Push to Stack
            } if (c == close) {
                if (balance == 0) continue;//Found a closing bracket without an opening bracket.
                balance--;//Pop from Stack
            }
            sb.append(c);
        }  
        return sb;
    }
    
	public static void main(String[] args) {
		String s1 = "a)b(c)d";
//		Output: "ab(c)d
		System.out.println(minRemoveToMakeValid(s1));
		
		String s2 = "))((";
		System.out.println(minRemoveToMakeValid(s2));
		//Output: ""
		
		String s3 = "(a(b(c)d)";
		System.out.println(minRemoveToMakeValid(s3));
		//Output: "a(b(c)d)"
		//Other valid results are (ab(c)d), (a(bc)d) however this algorithm does not cover them. See another algorithm https://leetcode.com/problems/remove-invalid-parentheses/

		String s4 = "(a(b(c)d)(";
		System.out.println(minRemoveToMakeValid(s4));
		//Output: "a(b(c)d)"
	}

}
