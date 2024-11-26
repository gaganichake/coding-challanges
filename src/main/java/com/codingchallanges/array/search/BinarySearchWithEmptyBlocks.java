package com.codingchallanges.array.search;

import java.util.Arrays;

/*
 * CTCI 11.5 Given a sorted array of strings which is interspersed with empty strings, write
 * a method to find the location of a given string
 */
public class BinarySearchWithEmptyBlocks {

	/*
	 * First try to solve this problem with numbers. Consider -1 as entry block
	 */
	private static int binarySearch(int[] array, int left, int right, int key) {

		if (left <= right) {

			int mid = left + (right - left) / 2;// This is even better

			if(array[mid] == -1) {

				int tempLeft = mid - 1;
				int tempRight = mid + 1;

				while(true) {

					if(tempLeft < left && tempRight > right) {
						return -1;
					} else if(tempLeft >= left && array[tempLeft] != -1) {
						mid = tempLeft;
						break;
					} else if(tempRight <= right && array[tempRight] != -1) {
						mid = tempRight;
						break;
					}
					tempLeft--;
					tempRight++;
				}
			}

			if (key == array[mid]) {
				return mid;
			} else if (key < array[mid])
					return binarySearch(array, left, mid - 1, key);
				else
					return binarySearch(array, mid + 1, right, key);
			}
		return -1;
	}

	/*
	 * Now try to implement the above algorithm for Strings
	 */
	private static int binarySearchString(String[] array, int left, int right, String key) {

		if (left <= right) {

			int mid = left + (right - left) / 2;// This is even better

			if(array[mid].isEmpty()) {

				int tempLeft = mid - 1;
				int tempRight = mid + 1;

				while(true) {

					if(tempLeft < left && tempRight > right) {
						return -1;
					} else if(tempLeft >= left && !array[tempLeft].isEmpty()) {
						mid = tempLeft;
						break;
					} else if(tempRight <= right && !array[tempRight].isEmpty()) {
						mid = tempRight;
						break;
					}
					tempLeft--;
					tempRight++;
				}
			}

			if (key.equals(array[mid])) {
				return mid;
			} else if (key.compareTo(array[mid]) < 0)
					return binarySearchString(array, left, mid - 1, key);
				else
					return binarySearchString(array, mid + 1, right, key);
		}
		return -1;
	}

	public static void main(String[] arg) {

		int[] array = {2, -1, 7, 10, -1, -1, -1, 60, 99};
		System.out.println(Arrays.stream(array));
		int key = 10;

		int index = binarySearch(array, 0, array.length - 1, key);

		if (index != -1)
			System.out.println("The number " + key + " found at position " + index);
		else
			System.out.println("The number " + key + " not found at any position");


		String[] arrayString = "a,,ab,,,,abc,abcd,,,abce,,abcdf".split(",");
		System.out.println(Arrays.asList(arrayString));

		String keyStr = "abce";

		int index2 = binarySearchString(arrayString, 0, arrayString.length - 1, keyStr);

		if (index2 != -1)
			System.out.println("The string '" + keyStr + "' found at position " + index2);
		else
			System.out.println("The number '" + keyStr + "' not found at any position");
	}
}
