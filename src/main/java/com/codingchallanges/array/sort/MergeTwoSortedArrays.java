package com.codingchallanges.array.sort;

import java.util.Arrays;

/**
 * CTCI 11.1
 * <p>
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the end
 * to hold B. Write a method to merge B into A in sorted order.
 */
public class MergeTwoSortedArrays {

	//This is brute-force approach. Time Complexity: O(a * b)
	public static void mergeTwoSortedArrays(int[] a, int[] b, int lengthOfA){

		int indexOfA = 0;

		for(int i : b) {
			System.out.println(i);
			while(i > a[indexOfA]) {
				indexOfA++;
			}
			shiftA(a, lengthOfA++, indexOfA);
			a[indexOfA] = i;
		}
	}

	private static void shiftA(int[] a, int lengthOfA, int indexOfA) {

		// Manual array copy
//		for(int i = lengthOfA; i > indexOfA; i--) {
//
//			a[i] = a[i-1];
//		}

		if (lengthOfA - indexOfA >= 0) System.arraycopy(a, indexOfA, a, indexOfA + 1, lengthOfA - indexOfA);
	}

	//Linear time complexity O(a + b) = O(n)
	public static void mergeTwoSortedArrays2(int[] a, int[] b, int lenghtOfA){

		int indexOfA = lenghtOfA - 1;
		int indexOfB = b.length - 1;
		int mergedIndexOfA = a.length-1;

		while(indexOfB >= 0) {

			if(a[indexOfA] > b[indexOfB]) {
				a[mergedIndexOfA] = a[indexOfA];
				indexOfA--;
			} else {
				a[mergedIndexOfA] = b[indexOfB];
				indexOfB--;
			}
			mergedIndexOfA--;
		}

	}

	public static void main(String[] args) {

		int[] a = {0, 2, 5, 7, 10, 22, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
				Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
				Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
		int[] b = {1, 3, 4, 5, 7, 8, 9, 10, 21, 23};
		int lenghtOfA = 6;

//		mergeTwoSortedArrays(a, b, lenghtOfA);
		mergeTwoSortedArrays2(a, b, lenghtOfA);

		System.out.println(Arrays.toString(a));

	}

}
