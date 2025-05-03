package com.codingchallanges.array.sort;

import java.util.Arrays;

/**
 * <a href="https://www.hackerrank.com/challenges/insertionsort2">insertionsort2</a>
 * <p>
 * 7, 6, 5, 2, 4, 3, 1
 * <p>
 * 7
 * 0
 * <p>
 * 7, 6
 * 0, 1
 * .  7
 * 0, 1
 * 6, 7
 * <p>
 * 6, 7, 5
 * 0, 1, 2
 * ., 6, 7
 * 5, 6, 7
 * <p>
 * 5, 6, 7, 2
 * 0, 1, 3, 4
 * ., 5, 6, 7
 * 2, 5, 6, 7
 * <p>
 * 2, 5, 6, 7, 4
 * 0, 1, 3, 4, 5
 * 2, ., 5, 6, 7
 * 2, 4, 5, 6, 7
 * <p>
 * 2, 4, 5, 6, 7, 3
 * 0, 1, 2, 3, 4, 5
 * 2, ., 4, 5, 6, 7
 * 2, 3, 4, 5, 6, 7
 * <p>
 * 2, 3, 4, 5, 6, 7, 1
 * 0, 1, 2, 3, 4, 5, 6
 * ., 2, 3, 4, 5, 6, 7
 * 1, 2, 3, 4, 5, 6, 7
 *
 */
public class InsertionSort {

	/*
	 * Time complexity: O(n x n)
	 */
	private static int[] insertionSort(int[] arr) {

		if (arr.length < 2) return arr;

		for (int i = 1; i < arr.length; i++) {

			InsertionSortPart1.insertionSortPart1(arr, i);
		}

		return arr;
	}

	/*
	 * Time complexity: O(n x n)
	 */
	private static int[] insertionSort2(int[] arr) {

		if(arr.length < 2)  return arr;

		for(int i = 1; i < arr.length; i++) {

			InsertionSortPart1.insertionSortPart1Version2(arr, i+1);
		}

		return arr;
	}

//	private static void insertionSortPart1Version2(int[] arr, int length) {
//
//		if(length < 2)  return;
//
//		for(int i = length-2; i >= 0; i--) {
//
//			if(arr[i] > arr[i+1]) {
//				Utility.swap(arr, i, i+1);
//			} else {
//				break;
//			}
//
//			System.out.println("Sorting: " + Arrays.toString(arr));
//		}
//	}

	public static void main(String[] args) {

//		int[] array = { 7, 6, 5, 2, 4, 3, 1 };
//		int[] array = {1, 4, 3, 5, 6, 2 };
		int[] array = { 3, 4, 7, 5, 6, 2, 1 };


		System.out.println("Before: " + Arrays.toString(array));

		int[] sortedArray = insertionSort2(array);

		System.out.println("After: " + Arrays.toString(sortedArray));
	}


}
