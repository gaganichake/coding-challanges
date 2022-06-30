package com.codingchallanges.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 * https://leetcode.com/problems/permutations/
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 *
 * Compare with https://leetcode.com/problems/subsets/
 */
public class NumberPermutations {

	public static List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> output = new ArrayList<>();

		permutations(nums, new ArrayList<>(), output);

		return output;
	}

	// Backtracking: DFS + Recursion + Dynamic
	private static void permutations(int[] nums, List<Integer> newCombination, List<List<Integer>> output) {

		// Add a copy of newCombination to the output list.
		if (newCombination.size() == nums.length) {
			output.add(new ArrayList<>(newCombination));

		} else {

			for (int num : nums) {

				if (newCombination.contains(num)) continue; // element already exists, skip

				newCombination.add(num);

				permutations(nums, newCombination, output);

				// Backtrack
				newCombination.remove(newCombination.size() - 1);
			}
		}
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3 };

		System.out.println(permute(nums));

	}

}
