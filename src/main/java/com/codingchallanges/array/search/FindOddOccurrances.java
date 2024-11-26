package com.codingchallanges.array.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Amazon (AWS) job interview question - live coding challenge.
 *
 * Provided an unsorted array of numbers. Create a function which returns a
 * list of numbers occurring odd number of times in the array.
 */
public class FindOddOccurrances {

	// Brute force approach
	// Time complexity: O(n pow 2)
	// Space complexity: O(n)
	public static Set<Integer> oddOccurrence(int[] array) {

		Set<Integer> result = new HashSet<>();

		int count = 0;

		for (int current : array) {

			if (result.contains(current)) {
				continue;//This is a big improvement
			}

			for (int i : array) {

				if (current == i) {
					count++;
				}
			}

			if (count % 2 != 0) {
				result.add(current);
			}

			count = 0;
		}

		return result;
	}

	//This is break thru improvement
	// Time complexity: O(n)
	// Space complexity: O(n)
	public static Set<Integer> findOddOccurrence2(int[] array) {

		Set<Integer> result = new HashSet<>();// memorization

		for (int current : array) {

			if (result.contains(current)) {
				result.remove(current);// Better use of memorization
			} else {
				result.add(current);
			}
		}
		return result;
	}

	public static void main(String[] arg) {

		int[] array = {1, 3, 2, 3, 2, 3};

		System.out.println("Following number were found odd times: " + findOddOccurrence2(array));
	}

}
