package com.codingchallanges.recursion.backtracking;

import java.util.Arrays;

/*
 * 
 */
public class ContiguousSubsets {

	// This is solved using Brute-force technique. Backtracking will add non-ContiguousSubsets
	static void contiguousSubsets(int[] inputArray) {

		for (int i = 0; i < inputArray.length; i++) {

			for (int j = i+1; j <= inputArray.length; j++) {

				System.out.println(Arrays.toString(Arrays.copyOfRange(inputArray, i, j)));
			}
		}
	}


	public static void main(String[] args) {
		
		int[] nums = { 1, 2, 3, 4};

		contiguousSubsets(nums);
	}

}
