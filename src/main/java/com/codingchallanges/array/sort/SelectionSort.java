package com.codingchallanges.array.sort;

import com.codingchallanges.array.Utility;

import java.util.Arrays;

/*
 * SelectionSort
 *
 * Time complexity: O(n ^ 2)
 * Space complexity: O(1)
 *
 * Selection Sort is the child's algorithm: simple but inefficient.
 * Find the smallest element using a linear scan and move it to
 * the front (swapping it with the front element). Then find the
 * second smallest element and move it, again doing a linear scan.
 * Continue doing this until all elements are in place.
 */
public class SelectionSort {

	public static void selectionSort(int[] array) {

		for(int i = 0; i < array.length; i++) {

			Utility.swap(array, i, indexOfSmallestElement(array, i));
		}
	}

	private static int indexOfSmallestElement(int[] array, int startIndex) {

		int indexOfSmallestElement = -1;
		int smallestElement = Integer.MAX_VALUE;

		for (int i = startIndex; i < array.length; i++) {

			if (smallestElement > array[i]) {
				smallestElement = array[i];
				indexOfSmallestElement = i;
			}
		}
		return indexOfSmallestElement;
	}

	public static void main(String[] args) {

//		int[] array = {7, 6, 5, 4, 3, 2, 1};

		int[] array = {7, 3, 5, 1, 6, 2, 4};

		System.out.println("Before: " + Arrays.toString(array));

		selectionSort(array);

		System.out.println("After: " + Arrays.toString(array));

	}

}
