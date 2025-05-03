package com.codingchallanges.array.math;

/**
 * countTinyPairs
 * <p>
 * CodeSignal
 * <p>
 * You are given two arrays of integers a and b of the same length, and
 * integer k. We will be iterating through array a from left to right,
 * and simultaneously through array b from right to left, and looking at
 * pairs (x, y), where x is from a and y is from b. Such a pair is called
 * tiny if the concatenation xy is strictly less than k.
 * <p>
 * Your task is to return the number of tiny pairs that you'll encounter
 * during the simultaneous iteration through a and b.
 */
public class CountTinyPairs {

	static int countTinyPairs(int[] a, int[] b, int k) {

		int count = 0, number;

		for(int i = 0; i < a.length; i++) {

			number = Integer.parseInt(a[i] + "" + b[a.length - 1 - i]);

			if(number < k) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {

		int[] a = {1, 2, 3};
		int[] b = {1, 2, 3};
		int k = 31;

		// Expected output 2
		System.out.println(countTinyPairs(a, b, k));
	}

}
