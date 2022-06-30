package com.codingchallanges.array.sort;

import com.codingchallanges.array.Utility;

import java.util.Arrays;

/*
 * https://www.youtube.com/watch?v=6Gv8vg0kcHc
 */
public class BubbleSort {

	/*
	 * Time complexity: O(n x n)
	 * Space complexity: O(1)
	 */
	public static int[] bubbleSort(int[] array) {

		boolean isSorted = false;

		while(!isSorted) {

			isSorted = true;

			for(int i = 0; i < array.length-1; i++) {

				if(array[i] > array[i+1]) {

					isSorted = false;

					Utility.swap(array, i, i+1);
				}
			}
			System.out.println("> " + Arrays.toString(array));
		}
		return array;
	}

	/*
	 *  Improvement: We will reduce the array length by one after every full
	 *  iteration if the array is still unsorted. Because at the end of every
	 *  full iteration the basic algorithm will place the biggest number at
	 *  the end of the array. So we need to examine only the unsorted length.
	 *
	 *  Time complexity: O(n x n)
	 *  Space complexity: O(1)
	 */
	public static int[] bubbleSort2(int[] array) {

		boolean isSorted = false;
		int unsortedLength = array.length-1;

		while(!isSorted) {

			isSorted = true;

			for(int i = 0; i < unsortedLength; i++) {

				if(array[i] > array[i+1]) {

					isSorted = false;

					Utility.swap(array, i, i+1);
				}
			}
			unsortedLength--;
			System.out.println("> " + Arrays.toString((array)));
		}
		return array;
	}

	public static void main(String[] args) {

		int[] array = {3, 15, 5, 20, 8, 2, 1};

		System.out.println("Before: " + Arrays.toString((array)));

		System.out.println("After: " + Arrays.toString(bubbleSort2(array)));

	}

}
