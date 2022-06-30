package com.codingchallanges.array.search;

import java.util.Arrays;

/*
 * CTCI 11.7 Sub-Problem: Longest Increasing Subsequence
 *
 */
public class LongestIncreasingSubsequence {

	// This solution is different than given in the book
	public static int[] longestIncreasingSequence(int[] array){

		//Similar to prefixSum technique but using array.length instead of array.length + 1
		int[] prefixDiff = new int[array.length];
		Arrays.fill(prefixDiff, 0);

		int longestIndex = 0;
		int longest = 0;

		//First element [0] of array will always have height difference of 0
		for(int i = 1; i < array.length; i++) {

			if(array[i] > array[i-1]) {
				prefixDiff[i] = 1 + prefixDiff[i-1];
			}

			if(prefixDiff[i] > longest) {
				longestIndex = i;
			}
		}
		System.out.println(Arrays.toString(prefixDiff));
		System.out.println(longestIndex);

		return Arrays.copyOfRange(array, longestIndex - prefixDiff[longestIndex], longestIndex+1);
	}


	public static void main(String[] args) {

		//Please note this array is partially sorted, having sorted sub-sequences
//		int[] array = {13, 14, 10, 11, 12};//Difference is 1
		int[] array = {13, 14, 10, 11, 16};//Difference is greater than 1

		System.out.println(Arrays.toString(longestIncreasingSequence(array)));

	}

}
