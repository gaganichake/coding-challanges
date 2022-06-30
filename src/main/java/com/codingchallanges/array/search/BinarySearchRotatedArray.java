package com.codingchallanges.array.search;

/*
 * Find a given element:
 * CTCI 11.3 Given a sorted array of n integers that has been rotated an unknown number of
 * time, write code to find an element in the array. You may assume that the array was
 * originally sorted in increasing order.
 *
 * Find minimum element:
 * A sorted array has been rotated so that the elements might appear in the order
 * 3, 4, 5, 6, 7, 1, 2. How would you find the minimum element?
 * You may assume that the array has all unique elements.
 */
public class BinarySearchRotatedArray {

	public static int findMin(int[] arr) {

		if(arr.length == 0) return 0;

		int left = 0, right = arr.length - 1;

		return binarySearchFindMin(arr, left, right);
	}

	private static int binarySearchFindMin(int[] arr, int left, int right) {

		int mid = left + (right - left) / 2;

		if(left >= right) return arr[left];

		if(arr[mid] > arr[right]) {
			return binarySearchFindMin(arr, mid+1, right);
		} else {
			return binarySearchFindMin(arr, left, mid);
		}
	}

	private static int linearSearch(int[] arr, int left, int right) {

		int min = arr[left];

		for(int i = left; i < right; i++) {

			if(arr[i] < min) {
				min = arr[i];
			}
		}

		return min;
	}


	public static int findElement(int[] arr, int k) {

		if(arr.length == 0) return 0;

		int left = 0, right = arr.length - 1;

		return binarySearch(arr, left, right, k);
	}

	private static int binarySearch(int[] arr, int left, int right, int k) {

		int mid = left + (right - left) / 2;
		//int mid = (left + right) / 2;

		if(arr[mid] == k) return mid;

		if(left > right) return -1;

		if(arr[left] < arr[mid]) {

			if(k >= arr[left] && k <= arr[mid]) {
				return binarySearch(arr, left, mid-1, k);
			} else {
				return binarySearch(arr, mid+1, right, k);
			}
		} else if(arr[mid] < arr[right]){

			if(k >= arr[mid] && k <= arr[right]) {
				return binarySearch(arr, mid+1, right, k);
			} else {
				return binarySearch(arr, left, mid-1, k);
			}
		} else if(arr[left] == arr[mid]) {

			if(arr[mid] != arr[right]) {
				return binarySearch(arr, mid+1, right, k);
			} else {
				int result = binarySearch(arr, left, mid-1, k);
				if(result == -1) {
					return binarySearch(arr, mid+1, right, k);
				} else {
					return result;
				}
			}
 		}
		return -1;
	}

	public static void main(String[] arg) {

//		int[] array = {3, 4, 5, 6, 7, 1, 2 };
//		int[] array = {6, 7, 1, 2 };
//		int[] array = {7, 1, 2 };
//		int[] array = {1, 2 };
		int[] array = {5, 6, 7, 1, 2, 3, 4};
		int left = 0;

		System.out.println("Minimum element: " + findMin(array));
		System.out.println("Minimum element: " + linearSearch(array, left, array.length));

		System.out.println("Element was found at position:" + findElement(array, 1));
	}

}
