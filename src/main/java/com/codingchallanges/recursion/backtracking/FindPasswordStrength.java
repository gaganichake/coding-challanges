package com.codingchallanges.recursion.backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * Amazon Online Assessment 2 from HankerRank
 * 02/09/2022
 * 
 * Duplicate characters should be counted only 1
 */
public class FindPasswordStrength {

	/*
	 * Complete the 'findPasswordStrength' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * STRING password as parameter.
	 */

	public static long findPasswordStrength(String password) {
		// Write your code here

		long count = 0L;
		String str;
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < password.length(); i++) {

			for (int j = i + 1; j <= password.length(); j++) {

				str = password.substring(i, j);

				if (map.containsKey(str)) {
					count += map.get(str);
				} else {
					Character[] cArr = str.chars().mapToObj(ch -> (char) ch).toArray(Character[]::new);
					int n = (new HashSet<>(Arrays.asList(cArr))).size();
					count += n;
					map.put(str, n);
				}

				// System.out.println(Arrays.toString(cArr));
			}
		}

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
