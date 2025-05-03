package com.codingchallanges.array.math;

/**
 * Add to binary numbers given as String
 * <p>
 * Similar problems:
 * 	1. Add two decimal number given (can be given as integer or String)
 * 	2. Add two numbers give as Linked List. Output should also be in Linked List.
 * <p>
 * Facebook interview question:
 * <p>
 * Add two binary numbers given to you as strings of "0"s and "1"s.
 * The result should be the string of "0"s and "1"s representing the numbers' sum.
 * The result is allowed to contain one leading zero (for simplicity).
 * <p>
 * Example 1:
 * input1: 11 -> 3
 * input2 : 111 -> 7
 * <p>
 *      11
 *     111
 * =  1010
 * <p>
 * Example 2:
 *       101
 *      1011
 * =   10000
 */
public class AddTwoBinaryNumbers {

	// This is what I coded during the interview.
//	public String sum (String n1, String n2){
//
//		  if(n1.length() > n2.lnegth()){
//		    sum(n2, n1);
//
//		  }
//
//		  StringBuilder sb = new StringBuilder();
//
//		  int carry = 0;
//		  int sum = 0;
//
//		  for(int i = 0;  i < n2.length; i++){
//
//		    sum+= i < n1.lenght : Integer.valueOf(n1.charAt(i)) + 0;
//		    sum+=Integer.valueOf(n2.charAt(i));
//		    sum+=carry;
//
//		    sb.append(sum % 2);
//		    carry = sum / 2
//
//		  }
//
//		  sum+=carry;
//
//		  sb.reverse().toString();
//
//		}

	// Correct implementation
	public static String sum(String n1, String n2){

		 //Ensuring n2 is a bigger than n1
		  if(n1.length() > n2.length()){
		    sum(n2, n1);
		  }

		  StringBuilder sb = new StringBuilder();

		  //String reversal is required because the zero'th index is at left side.
		  StringBuilder n1sb = new StringBuilder(n1);
		  n1 = n1sb.reverse().toString();

		  StringBuilder n2sb = new StringBuilder(n2);
		  n2 = n2sb.reverse().toString();

		  int carry = 0;
		  int sum;

		  //Iterate the bigger number
		  for(int i = 0;  i < n2.length(); i++){

		    sum = (i < n1.length() ? Integer.parseInt(""+n1.charAt(i)) : 0) + Integer.parseInt(""+n2.charAt(i)) + carry;

		    sb.append(sum % 2);
		    carry = sum / 2;
			System.out.println(sb);
		  }

		  sb.append(carry);

		  return sb.reverse().toString();

		}

	public static void main(String[] arg) {

		System.out.println(sum("11", "111"));//Output: 1010
//		System.out.println(sum("101", "1011"));//Output: 10000
	}
}
