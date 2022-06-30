package com.codingchallanges.array.search;

import com.codingchallanges.array.Utility;
import com.codingchallanges.array.matrix.PairComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * CTCI 11.7 Longest Increasing Subsequence of Pairs
 *
 * We have a list of pairs of items. Find the longest sequence such that both the first and
 * second items are in non-decreasing order;
 *
 */
public class LongestIncreasingSubsequenceOfPairs {

	//This solution is different than given in the book
	public static int[][] longestIncreasingSequence(int[][] array){

		//Sort all pairs by first index and second index
		List<int[]> list = Arrays.asList(array);
		list.sort(new PairComparator());

		//Similar to prefixSum technique but using array.length instead of array.length - 1
		int[] prefixDiff = new int[array.length];
		Arrays.fill(prefixDiff, 0);

		int longestIndex = 0;
		int longest = 0;

		//First element [0] of array will always have height difference of 0
		for(int i = 1; i < list.size(); i++) {

			if(list.get(i)[1] > list.get(i-1)[1]) {
				prefixDiff[i] = 1 + prefixDiff[i-1];
			}

			if(prefixDiff[i] > longest) {
				longestIndex = i;
			}
		}
		System.out.println(Arrays.toString(prefixDiff));
		System.out.println(longestIndex);
		return list.subList(longestIndex - prefixDiff[longestIndex], longestIndex+1).toArray(new int[prefixDiff[longestIndex]][]);
	}

 public static void main(String[] args) {

		//Unsorted pairs on numbers
//		int[][] array = {{5, 13}, {6, 14}, {6, 10}, {7,11}, {8, 16}};
		int[][] array = {{65, 60}, {70, 150}, {56, 90}, {75,190}, {60, 95}, {68, 110}, {35, 65}, {40, 60}, {45, 63}};

		System.out.println(Utility.printTwoDArray(longestIncreasingSequence(array)));

	}

}
