package com.codingchallanges.prefixsum;

import java.util.Arrays;

/**
 *
 * arrayMaxConsecutiveSum2
 * <p>
 * <a href="https://app.codesignal.com/interview-practice/task/dQD4TCunke2JQ98rj/description">arrayMaxConsecutiveSum2</a>
 * <p>
 * Given an array of integers, find the maximum possible sum you can get from one of its
 * contiguous subarrays. The subarray from which this sum comes must contain at least 1 element
 * <p>
 * Example:
 * For inputArray = [-2, 2, 5, -11, 6], the output should be
 * arrayMaxConsecutiveSum2(inputArray) = 7
 * <p>
 * The contiguous subarray that gives the maximum possible sum is [2, 5], with a sum of 7
 */
public class ArrayMaxConsecutiveSum2 {

	static int arrayMaxConsecutiveSum2(int[] inputArray) {

//		int maxSum = Integer.MIN_VALUE;
//		int sum;
		int[] prefixSum = new int[inputArray.length + 1];
		int maxConsecutiveSum = 0;
		int nextSum = 0;

		for (int i = 0; i < inputArray.length; i++) {

			nextSum = prefixSum[i] + inputArray[i];

			if(nextSum > prefixSum[i]){
				prefixSum[i + 1] = nextSum;
			}
			maxConsecutiveSum = Math.max(maxConsecutiveSum, prefixSum[i + 1]);
		}
		System.out.println(Arrays.toString(prefixSum));
//		for (int i = 0; i < inputArray.length; i++) {
//
//			for (int j = i; j < inputArray.length; j++) {
//
//				// sum = sum(i, j, inputArray);//This causes more execution time.
//
//				sum = prefixSum[j + 1] - prefixSum[i + 1 - 1];//Using prefix sum technique
//
//				if (sum > maxSum) {
//					maxSum = sum;
//				}
//			}
//		}
		return maxConsecutiveSum;
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
