package com.codingchallanges.prefixsum;

/*
 * sumInRange
 *
 * https://app.codesignal.com/interview-practice/task/4MoqQLaw22nrzXbgs/description
 *
 * You have an array of integers nums and an array queries, where queries[i] is a pair
 * of indices (0-based). Find the sum of the elements in nums from the indices at
 * queries[i][0] to queries[i][1] (inclusive) for each query, then add all of the sums
 * for all the queries together. Return that number modulo 10^9 + 7
 *
 * Example
 * For nums = [3, 0, -2, 6, -3, 2] and queries = [[0, 2], [2, 5], [0, 5]], the output should be
 * sumInRange(nums, queries) = 10.
 *
 * The array of results for queries is [1, 3, 6], so the answer is 1 + 3 + 6 = 10.
 */
public class SumInRange {

	 // Using Brute-force technique. Time Complexity: O(n * n)
	int sumInRange(int[] nums, int[][] queries) {

	    int sum = 0;
	    int mod = 1000000007;

		for (int[] query : queries) {

			for (int j = query[0]; j <= query[1]; j++) {

				sum = sum + nums[j];
			}
		}

	    return Math.floorMod(sum, mod);
	}

	// Using Prefix Sum technique. Time Complexity: O(n)
	// https://app.codesignal.com/interview-practice/topics/common-techniques-basic/tutorial
	int sumInRange2(int[] nums, int[][] queries) {

	    int sum = 0;
	    int mod = 1000000007;

	    int[] prefixSum = new int[nums.length + 1];//This array is one plus size of input array
	    // No need to initialize as default is zero. i.e. prefixSum[0] = 0

	    for(int i = 0; i < nums.length; i++){
	        prefixSum[i+1] = prefixSum[i] + nums[i];
	    }

	    int startIndexOfNums, endIndexOfNums;
		for (int[] query : queries) {

			startIndexOfNums = query[0];
			endIndexOfNums = query[1];
			sum += prefixSum[endIndexOfNums + 1] - prefixSum[startIndexOfNums + 1 - 1];
			//Need to modulo the intermediate results (not only the final sum), in order to avoid an integer overflow.
			//Distributive property: (a + b) % n = [(a % n) + (b % n)] % n
			sum = Math.floorMod(sum, mod);
		}

	    // sum = sum % mod;
	    // if(sum < 0) sum = mod + sum;
	    // The above two lines are equivalent to sum = Math.floorMod(sum, mod);
	    return sum;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
