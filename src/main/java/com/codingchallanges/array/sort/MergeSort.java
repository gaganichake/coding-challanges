package com.codingchallanges.array.sort;

import java.util.Arrays;

/*
 * https://www.youtube.com/watch?v=KF2j-9iSf4Q
 */
public class MergeSort {

	/*
	 * Merge Sort is a Divide and Conquer algorithm
	 *
	 * time complexity: O(n log(n))
	 * Space complexity: O(n)
	 */
	private static void mergeSort(int[] array, int left, int right) {

		if(right - left <= 0) {
			return;
		}

		int mid = (left + right) / 2;

		mergeSort(array, left, mid);System.out.println("> " + Arrays.toString(array));

		mergeSort(array, mid+1, right);System.out.println("> " + Arrays.toString(array));

		merge(array, left, mid, mid+1, right);

	}

	private static void merge(int[] array, int leftStart, int leftEnd, int rightStart, int rightEnd) {

		int[] sortedArray = new int[array.length];
		int sortedIndex = leftStart;
		int i = leftStart;
		int j = rightStart;

		while(i <= leftEnd && j <= rightEnd) {

			if(array[i] <= array[j]) {
				sortedArray[sortedIndex] =  array[i];
				i++;
			} else {
				sortedArray[sortedIndex] =  array[j];
				j++;
			}
			sortedIndex++;
		}

		System.arraycopy(array, i, sortedArray, sortedIndex, leftEnd - i + 1);// either one of them will be effective
		System.arraycopy(array, j, sortedArray, sortedIndex, rightEnd - j + 1);// either one of them will be effective
		System.arraycopy(sortedArray, leftStart, array, leftStart, rightEnd - leftStart + 1);
	}

	public static void main(String[] arg) {

//		int[] array = {12, 11, 13, 5, 6, 7};
//		int[] array = {38, 27, 43, 3, 9, 82, 10};
		int[] array = {6, 5, 3, 1, 9, 8, 7, 2, 4};

		System.out.println("Before: " + Arrays.toString(array));

		mergeSort(array, 0, array.length - 1);

		System.out.println("After: " + Arrays.toString(array));

	}

}
