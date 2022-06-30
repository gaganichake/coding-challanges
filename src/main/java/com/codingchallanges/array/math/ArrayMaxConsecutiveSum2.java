package com.codingchallanges.array.math;

/*
 * arrayMaxConsecutiveSum2
 *
 * https://app.codesignal.com/interview-practice/task/dQD4TCunke2JQ98rj/description
 *
 * Given an array of integers, find the maximum possible sum you can get from one of its
 * contiguous subarrays. The subarray from which this sum comes must contain at least 1 element
 *
 * Example:
 * For inputArray = [-2, 2, 5, -11, 6], the output should be
 * arrayMaxConsecutiveSum2(inputArray) = 7
 *
 * The contiguous subarray that gives the maximum possible sum is [2, 5], with a sum of 7
 */
public class ArrayMaxConsecutiveSum2 {

	static int arrayMaxConsecutiveSum2(int[] inputArray) {

		int maxSum = Integer.MIN_VALUE;
		int sum;
		int[] prefixSum = new int[inputArray.length + 1];

		for (int i = 0; i < inputArray.length; i++) {

			prefixSum[i + 1] = prefixSum[i] + inputArray[i];
		}

		for (int i = 0; i < inputArray.length; i++) {

			for (int j = i; j < inputArray.length; j++) {

				// sum = sum(i, j, inputArray);//This causes more execution time.

				sum = prefixSum[j + 1] - prefixSum[i + 1 - 1];//Using prefix sum technique

				if (sum > maxSum) {
					maxSum = sum;
				}
			}
		}
		return maxSum;
	}

	private int sum(int i, int j, int[] inputArray) {

		int sum = 0;

		for (; i <= j; i++) {
			sum += inputArray[i];
		}
		return sum;
	}

	public static void main(String[] args) {

		int[] inputArray = { -2, 2, 5, -11, 6 };

		System.out.println(arrayMaxConsecutiveSum2(inputArray));
	}

}
