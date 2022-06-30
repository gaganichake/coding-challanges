package com.codingchallanges.array.sort;

import java.util.ArrayList;
import java.util.List;

/*
 * Quick Sort (Partition Sort)
 *
 * https://www.hackerrank.com/challenges/quicksort1/problem
 *
 * This challenge is a modified version of the Quick Sort algorithm
 * that only addresses partitioning. It is implemented as follows:
 *
 * Step 1: Divide
 * Choose some pivot element, p, and partition your unsorted array, arr, into
 * three smaller arrays: left, right, equals and , where each element in left < p,
 * each element in right < p, and each element in equal = p.
 */
public class QuickSortPart1 {

	// Using Arrays
//	private static void quikSortPart1(int[] arr) {
//
//		int[] left = lessThen(arr, arr[0]);
//
//		System.out.println(Utility.arrayToString(left));
//
//		int[] equal = { arr[0] };
//
//		System.out.println(Utility.arrayToString(equal));
//
//		int[] right = greaterThen(arr, arr[0]);
//
//		System.out.println(Utility.arrayToString(right));
//	}
//
//	private static int[] lessThen(int[] arr, int n) {
//
//		int length = 0;
//
//		for (int i = 0; i < arr.length; i++) {
//
//			if (arr[i] < n) {
//
//				length++;
//			}
//		}
//
//		int[] result = new int[length];
//
//		int index = 0;
//
//		for (int i = 0; i < arr.length; i++) {
//
//			if (arr[i] < n) {
//
//				result[index] = arr[i];
//				index++;
//			}
//		}
//
//		return result;
//	}
//
//	private static int[] greaterThen(int[] arr, int n) {
//
//		int length = 0;
//
//		for (int i = 0; i < arr.length; i++) {
//
//			if (arr[i] > n) {
//
//				length++;
//			}
//		}
//
//		int[] result = new int[length];
//
//		int index = 0;
//
//		for (int i = 0; i < arr.length; i++) {
//
//			if (arr[i] > n) {
//
//				result[index] = arr[i];
//				index++;
//			}
//		}
//
//		return result;
//	}

	// Using ArrayList
	private static void quikSortPart1UsingArrayList(int[] arr) {

		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		List<Integer> equals = new ArrayList<>();
		int pivote = arr[0];


		for (int j : arr) {

			if (j < pivote) {
				left.add(j);
			} else if (j > pivote) {
				right.add(j);
			} else {
				equals.add(j);
			}
		}

		System.out.println("left = " + left);

		System.out.println("pivote = [" + pivote + "]");

		System.out.println("right = " + right);

		List<Integer> all = new ArrayList<>();
		all.addAll(left);
		all.addAll(equals);
		all.addAll(right);
		System.out.println(all);
	}

	public static void main(String[] args) {

		int[] array = { 6, 7, 1, 5, 6, 2 };

//		quikSortPart1(array);
		quikSortPart1UsingArrayList(array);
	}
}
