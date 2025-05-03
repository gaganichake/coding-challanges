package com.codingchallanges.array.sort;

import com.codingchallanges.array.Utility;

import java.util.Arrays;

/**
 * <a href="https://www.hackerrank.com/challenges/insertionsort1/problem">insertionsort1</a>
 * <p>
 * Given a sorted list with an unsorted number in the rightmost
 * cell, can you write some simple code to insert into the array so that it remains sorted?
 * <p>
 * [1, 2, 4, 5, 3]
 */
public class InsertionSortPart1 {

	/*
	 * Time complexity: O(n)
	 */
	public static void insertionSortPart1(int[] arr, int unsortedIndex) {

		int unsortedElement = arr[unsortedIndex];

		int currentIndex = unsortedIndex;

		// Shifting left to right
		for (int lowerIndex = unsortedIndex - 1; lowerIndex >= 0; lowerIndex--) {

			if (arr[lowerIndex] > unsortedElement) {
				arr[currentIndex] = arr[lowerIndex];
				System.out.println("> Shifting "+arr[lowerIndex]+" : " + Arrays.toString(arr));
			} else {
				break;
			}
			currentIndex--;
		}

		// Inserting right to left
		arr[currentIndex] = unsortedElement;
		System.out.println("< Inserting "+unsortedElement+" : " + Arrays.toString(arr));
	}

	/*
	 * Time complexity: O(n)
	 */
	public static void insertionSortPart1Version2(int[] arr, int length) {

		if(length < 2)  return;

		for(int i = length-2; i >= 0; i--) {

			if(arr[i] > arr[i+1]) {
				Utility.swap(arr, i, i+1);
			} else {
				break;
			}

			System.out.println("Sorting: " + Arrays.toString(arr));
		}
	}

	public static void main(String[] args) {

//		int[] array = { 1, 2, 4, 5, 3 };
		int[] array = {2, 3, 4, 5, 1}; // Special case when all elements are greater then last one.
//		int[] array = { 5, 3 };
//		int[] array = { 3 };

		System.out.println("Before: " + Arrays.toString(array));

		insertionSortPart1Version2(array, array.length);

		System.out.println("After: " + Arrays.toString(array));
	}

}
