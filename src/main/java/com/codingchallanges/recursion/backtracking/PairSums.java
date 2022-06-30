package com.codingchallanges.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Pair Sums
 * 
 * https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=840934449713537&c=420501606451133&ppid=454615229006519&practice_plan=1
 * 
 * Given a list of n integers arr[0..(n-1)], determine the number of different pairs of elements within it which sum to k.
 * 
 * If an integer appears in the list multiple times, each copy is considered to be different; that is, two pairs are considered different if one pair includes at least one array index which the other doesn't, even if they include the same values.
 * 
 * Signature
 * int numberOfWays(int[] arr, int k)
 * 
 * Input
 * n is in the range [1, 100,000].
 * Each value arr[i] is in the range [1, 1,000,000,000].
 * k is in the range [1, 1,000,000,000].
 * 
 * Output
 * Return the number of different pairs of elements which sum to k.
 * 
 * Example 1
 * 
 * n = 5
 * k = 6
 * arr = [1, 2, 3, 4, 3]
 * output = 2
 * 
 * The valid pairs are 2+4 and 3+3.
 * 
 * Example 2
 * n = 5
 * k = 6
 * arr = [1, 5, 3, 3, 3]
 * output = 4
 * 
 * There's one valid pair 1+5, and three different valid pairs 3+3 (the 3rd and 4th elements, 3rd and 5th elements, and 4th and 5th elements).
 */
public class PairSums {

	int numberOfWays(int[] arr, int k) {
		// Write your code here
		counter = 0;// rest before every execution
		pairs(arr, new ArrayList<>(), 0, k);

		return counter;
	}

	private static int counter;

	private void pairs(int[] arr, List<Integer> temp, int startIndex, int k) {

		if (temp.size() == 2 && temp.stream().mapToInt(Integer::intValue).sum() == k) {
			counter++;
		}

		if (temp.size() > 2)
			return;

		for (int i = startIndex; i < arr.length; i++) {

			temp.add(arr[i]);

			pairs(arr, temp, i + 1, k);

			temp.remove(temp.size() - 1);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
