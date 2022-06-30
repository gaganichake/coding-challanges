package com.codingchallanges.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * A palindrome string is a string that reads the same backward as forward.
 *
 * https://leetcode.com/problems/palindrome-partitioning/
 * https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 *
 * Compare with https://leetcode.com/problems/subsets/
 */
public class PalindromePartitioning {

	public static List<List<String>> partitions(String str) {

		List<List<String>> output = new ArrayList<>();

		partitions(str, new ArrayList<>(), output, 0);

		return output;
	}

	public static void partitions(String str, List<String> newPartitions, List<List<String>> output, int start) {

		if (start >= str.length()) {
			output.add(new ArrayList<>(newPartitions));
//			System.out.println("newPartitions: " + newPartitions);
		}

		for (int i = start; i < str.length(); i++) {

			if (isPalindrome(str, start, i)) {

				newPartitions.add(str.substring(start, i + 1));
//				System.out.println("add (" + str.substring(start, i + 1) + "): " + newPartitions);

				partitions(str, newPartitions, output, i + 1);
//				System.out.println("return: " + newPartitions);
//				String remove = newPartitions.get(newPartitions.size() - 1);

				newPartitions.remove(newPartitions.size() - 1);
//				System.out.println("remove (" + remove + "): " + newPartitions);
			}
		}
	}

	public static boolean isPalindrome(String s, int low, int high) {

		while (low < high)
			if (s.charAt(low++) != s.charAt(high--))
				return false;
		return true;
	}

	public static void main(String[] args) {

		System.out.println(partitions("aab"));
	}

}
