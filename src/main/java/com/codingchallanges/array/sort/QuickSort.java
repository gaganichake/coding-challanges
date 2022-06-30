package com.codingchallanges.array.sort;

import com.codingchallanges.array.Utility;

import java.util.Arrays;

/*
 *
 * https://www.hackerrank.com/challenges/quicksort2/problem
 *
 * https://www.youtube.com/watch?v=SLauY6PpjW4
 *
 * Quick Sort is a Divide and Conquer algorithm
 */
public class QuickSort {

	public static void quickSort(int[] array) {

		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int left, int right) {

		if(left >= right) {
			return;
		}

		int mid = (left + right) / 2;

		int pivot = array[mid];System.out.println("Pivot: " + pivot);

		int partitionIndex  = partition(array, left, right, pivot);

		quickSort(array, left, partitionIndex-1);System.out.println("> " + Arrays.toString(array));

		quickSort(array, partitionIndex, right);System.out.println("> " + Arrays.toString(array));

	}

	private static int partition(int[] array, int left, int right, int pivot) {

		while(left <= right) {

			while(array[left] < pivot) {
				left++;
			}

			while(array[right] > pivot) {
				right--;
			}

			if(left <= right) {
				Utility.swap(array, left, right);
				left++;
				right--;
			}
		}

		return left;
	}

	public static void main(String[] args) {

//		Integer[] array = {7, 6, 5, 4, 3, 2, 1};
//
//		System.out.println(Utility.arrayToString(quickSort(array)));

		int[] array = {7, 3, 5, 1, 6, 2, 4};

		System.out.println("Before: " + Arrays.toString(array));

		quickSort(array);

		System.out.println("After: " + Arrays.toString(array));
	}
}
