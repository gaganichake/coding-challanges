package com.codingchallanges.array.math;

/**
 * <a href="https://leetcode.com/problems/reverse-integer/">reverse-integer</a>
 * <p>
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer
 * range [-231, 231 - 1], then return 0
 */
public class ReverseInteger {

	   static public int reverse(int x) {

		   int rev = 0;

		   while(x != 0) {

			   System.out.println(rev * 10 + " | " + x % 10);

			   if(rev * 10L > Integer.MAX_VALUE) {
				   return 0;
			   }

			   rev = rev * 10 + x % 10;
			   x = x / 10;

			   System.out.println("rev = " + rev + " | " + "x = " + x + "\n");
		   }

		   return rev;
	   }

	public static void main(String[] args) {

		System.out.println(reverse(-123456));
		//System.out.println(reverse(1534236469));
		//System.out.println(964632435 * 10L);
	}

}
