package com.codingchallanges.array.search;

/*
 * Binary Search is a Divide and Conquer algorithm
 * Condition: The array must already be a sorted array.
 * Time complexity: O(log2 n)
 * Where 2 is a base. Base does not actually matter here
 * Base is 2 because it always divide the next set of elements by 2.
 * Space complexity: O(1)
 */
public class BinarySearch {

	/*
	 * Recursive method
	 */
	private static int binarySearchRecursive(int[] array, int left, int right, int key) {

		if (left <= right) {

//			int mid = (left + right) / 2;
			int mid = left + (right - left) / 2;// This is even better

			if (key == array[mid]) {
				return mid;
			} else if (key < array[mid])
				return binarySearchRecursive(array, left, mid - 1, key);
			else
				return binarySearchRecursive(array, mid + 1, right, key);
		}
		return -1;
	}

	/*
	 * Iterative method - while loop
	 */
	private static int binarySearchWhile(int[] array, int key) {

		int left = 0;
		int right = array.length - 1;
//		int mid = (left + right) / 2;
		int mid = left + (right - left) / 2;// This is even better


		while (left <= right) {
			if (key == array[mid])
				return mid;
			else if (key < array[mid])
				right = mid - 1;
			else
				left = mid + 1;
			mid = left + (right - left) / 2;
		}
		return -1;
	}

	/*
	 * Iterative method - for loop
	 * (This is less accurate that While loop)
	 */
	private static int binarySearchIterative(int[] array, int key) {

		int left = 0;
		int right = array.length - 1;
//		int mid = (left + right) / 2;
		int mid = left + (right - left) / 2;// This is even better

		for (int i = 0; i < array.length; i++) {
			if (key == array[mid])
				return mid;
			else if (key < array[mid])
				right = mid - 1;
			else
				left = mid + 1;
			mid = left + (right - left) / 2;
		}
		return -1;
	}

	public static void main(String[] arg) {

		int[] array = { 2, 4, 7, 10, 15, 56, 60, 99 };
//		int[] array = {0, 1, 2, 3, 4, 5, 6, 7 };

		int key = 7;

		System.out.println(binarySearchRecursive(array, 0, array.length - 1, key));

		System.out.println(binarySearchWhile(array, key));

		System.out.println(binarySearchIterative(array, key));

	}
}
