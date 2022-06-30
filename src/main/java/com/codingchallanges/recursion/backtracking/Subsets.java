package com.codingchallanges.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/subsets/
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Compare with https://leetcode.com/problems/permutations/
 */
public class Subsets {

	public static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> output = new ArrayList<>();

//		Arrays.sort(nums);// not necessary

		subsets(nums, new ArrayList<>(), output, 0);

		return output;
	}

	private static void subsets(int[] nums, List<Integer> newSubset, List<List<Integer>> output, int start) {

		// Add a copy of newSubset to the output list. At the very first call newSubset would be just empty - [].
		output.add(new ArrayList<>(newSubset));
//		System.out.println("newSubset: " + newSubset);

		for (int i = start; i < nums.length; i++) {

			newSubset.add(nums[i]);
//			System.out.println("add (" + nums[i] + "): " + newSubset);

			subsets(nums, newSubset, output, i + 1);
//			System.out.println("return: "+ newSubset);
//			int remove = newSubset.get(newSubset.size() - 1);

			// Backtrack: Remove the already completed combinations from the tempList
			newSubset.remove(newSubset.size() - 1);
//			System.out.println("remove (" + remove + "): " + newSubset);
		}
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4};

		System.out.println(subsets(nums));
	}

}
