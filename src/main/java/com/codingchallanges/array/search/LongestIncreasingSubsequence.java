package com.codingchallanges.array.search;

import java.util.Arrays;

/*
 * CTCI 11.7 Sub-Problem: Longest Increasing Subsequence
 *
 */
public class LongestIncreasingSubsequence {

	// This solution is different from given in the book
	public static int[] longestIncreasingSequence(int[] array){

		//Similar to prefixSum technique, using sum of length instead. Using array.length instead of array.length - 1
		int[] prefixLength = new int[array.length];
		Arrays.fill(prefixLength, 0);

		int lengthOfLongestSequence = 0;
		int indexOfLargestValue = 0;

		//First element [0] of array will always have height difference of 0
		for(int i = 1; i < prefixLength.length; i++) {

			if(array[i] > array[i-1]) {
				prefixLength[i] = 1 + prefixLength[i-1];//Calculate length
			}

			if(prefixLength[i] > lengthOfLongestSequence) {
				lengthOfLongestSequence = prefixLength[i];
				indexOfLargestValue = i;
			}
		}

		return Arrays.copyOfRange(array, indexOfLargestValue - prefixLength[indexOfLargestValue], indexOfLargestValue+1);
	}

	public static void main(String[] args) {

		//Please note this array is partially sorted, having sorted sub-sequences

		System.out.println(Arrays.toString(longestIncreasingSequence(new int[] {13, 14, 10, 11, 12})));
		System.out.println(Arrays.toString(longestIncreasingSequence(new int[] {1, 9, 10, 5, 7})));
	}
}
