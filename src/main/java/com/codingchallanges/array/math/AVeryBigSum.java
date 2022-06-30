package com.codingchallanges.array.math;

/*
 * https://www.hackerrank.com/challenges/a-very-big-sum/problem
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 * where n is the length of input array
 */
public class AVeryBigSum {

	//Using long type when number are bigger that integer
	static long aVeryBigSum(long[] ar) {

		long sum = 0;

		for (long l : ar) {
			sum += l;
		}

		return sum;
	}

	public static void main(String[] args) {

		String[] arItems = "1000000001 1000000002 1000000003 1000000004 1000000005".split(" ");

		long[] ar = new long[arItems.length];

		for (int i = 0; i < arItems.length; i++) {
			long arItem = Long.parseLong(arItems[i]);
			ar[i] = arItem;
		}

		long result = aVeryBigSum(ar);

		System.out.println(result);
	}
}
