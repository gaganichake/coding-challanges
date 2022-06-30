package com.codingchallanges.recursion.backtracking;

import java.util.Arrays;

/*
 * Contiguous Subarrays
 * 
 * https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=226517205173943&c=420501606451133&ppid=454615229006519&practice_plan=1
 * 
 * You are given an array arr of N integers. For each index i, you are required to determine the number of contiguous subarrays that fulfill the following conditions:
 * - The value at index i must be the maximum element in the contiguous subarrays, and
 * - These contiguous subarrays must either start from or end on index i.

 * Signature
 * int[] countSubarrays(int[] arr)

 * Input
 * - Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
 * - Size N is between 1 and 1,000,000

 * Output
 * An array where each index i contains an integer denoting the maximum number of contiguous subarrays of arr[i]

 * Example:
 * arr = [3, 4, 1, 6, 2]
 * output = [1, 3, 1, 5, 1]

 * Explanation:
 * For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
 * For index 1 - [4], [3, 4], [4, 1]
 * For index 2 - [1]
 * For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
 * For index 4 - [2]
 * So, the answer for the above input is [1, 3, 1, 5, 1]
 */

public class ContiguousSubarrays {

	static int[] countSubarrays(int[] arr) {

		int[] outout = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {

			int counter = 1;

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] > arr[j])
					counter++;
				else
					break;
			}

			for (int j = i - 1; j >= 0; j--) {

				if (arr[i] > arr[j])
					counter++;
				else
					break;
			}

			outout[i] = counter;

		}

		return outout;
	}

	public static void main(String[] args) {

		int[] test_1 = { 3, 4, 1, 6, 2 };
		//int[] expected_1 = { 1, 3, 1, 5, 1 };
		int[] output_1 = countSubarrays(test_1);

		System.out.println(Arrays.toString(output_1));

		int[] test_2 = { 2, 4, 7, 1, 5, 3 };
		//int[] expected_2 = { 1, 2, 6, 1, 3, 1 };
		int[] output_2 = countSubarrays(test_2);

		System.out.println(Arrays.toString(output_2));

	}

}
