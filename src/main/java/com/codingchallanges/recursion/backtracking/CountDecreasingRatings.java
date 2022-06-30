package com.codingchallanges.recursion.backtracking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Amazon Online Assessment 1 from HankerRank
 * 02/09/2022
 */
public class CountDecreasingRatings {

	/*
	 * Complete the 'countDecreasingRatings' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * INTEGER_ARRAY ratings as parameter.
	 */

	// Execution time exceeded
	public static long countDecreasingRatings(List<Integer> rating) {
		// Write your code here
		long count = 0;
		Map<String, Integer> map = new HashMap<>();
		String str;
		int n;

		// System.out.println(rating);
		for (int i = 0; i < rating.size(); i++) {

			for (int j = i + 1; j <= rating.size(); j++) {

				List<Integer> subSet = rating.subList(i, j);

				str = subSet.toString();

				if (map.containsKey(str)) {
					count += map.get(str);
				} else {
					n = isValidSubSet(subSet);
					count += n;
					map.put(str, n);
				}

			}
		}
		return count;
	}

	private static int isValidSubSet(List<Integer> rating) {

		// System.out.println(rating);
		int r = rating.get(0);

		for (int i = 1; i < rating.size(); i++) {

			if (r - rating.get(i) != 1)
				return 0;

			r = rating.get(i);
		}
		return 1;
	}
	
	public static long countDecreasingRatingsOptimized(List<Integer> rating) {
		// Write your code here
		long count = 0;
		
		for (int i = 1; i < rating.size(); i++) {
			
			rating.set(i, rating.get(i-1) - rating.get(i));
		}
		rating.set(0, 1);
		
		//TODO

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
