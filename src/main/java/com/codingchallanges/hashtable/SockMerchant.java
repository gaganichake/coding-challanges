package com.codingchallanges.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Sales by Match
 *
 * https://www.hackerrank.com/challenges/sock-merchant/
 *
 * There is a large pile of socks that must be paired by color.
 * Given an array of integers representing the color of each
 * sock, determine how many pairs of socks with matching colors there are.
 *
 * Example: array = [1, 2, 1, 2, 3, 2]
 * There is one pair of color 1 and one of color 2. There are three odd socks left, one of each color. The number of pairs is 2.
 */
public class SockMerchant {


	//Time Complexity: O(n)
	public static int sockMerchant(int[] arr) {

		Map<Integer, Integer> map =  new HashMap<>();

		for (int color : arr) {

			map.put(color, map.getOrDefault(color, 1) + 1);
		}

		int pairs = 0;

		for(int color : map.keySet()) {

			pairs += (map.get(color)/color)/2;
		}
		return pairs;
	}

	/*
	 * Complete the sockMerchant function below. This algorithm sorts the array
	 * Explanation: If array is empty or size 1, return 0 If n is 0 or 1, return 0
	 * Sort the array - any order Create a variable 'pair'. Initialize with 0 Create
	 * a variable 'previous'. Initialize with 0 If an array with more than one
	 * element repeat this - Pick fist element from the array. If 'previous' is not
	 * zero and current element is equals to the previous element, do this -
	 * Increment variable 'pairs' by one Reset 'previous' to 0 Else Set 'previous'
	 * to current element
	 *
	 * Time Complexity: O(n)
	 */
//    static int sockMerchant(int n, int[] ar) {
//
//        if(n < 2 || ar.length < 2) return 0;
//
//        int pairs = 0, previous = 0;
//
//        Arrays.sort(ar);
//
//        for(int i = 0; i < ar.length;  i++){
//
//            if(previous != 0 && ar[i] == previous){
//                pairs++;
//                previous = 0;
//            }else{
//                previous = ar[i];
//            }
//        }
//        return pairs;
//    }

	/*
	 * This algorithm uses Hash Set and does not sort the array. Explanation: If
	 * array is empty or size 1, return 0. If n is 0 or 1, return 0. Create a Set
	 * Create a variable 'pair'. Initialize with 0 If an array with more than one
	 * element repeat this - Pick fist element from the array. If the current
	 * element already exist in the Set, do this - Increment variable 'pairs' by one
	 * Remove that element from the Set Else Store the current element in the Set
	 *
	 * Time Complexity: O(n)
	 */
    static int sockMerchant(int n, int[] ar) {

        if(n < 2 || ar.length < 2) return 0;

        int pairs = 0;

        Set<Integer> bucket = new HashSet<>();

		for (int j : ar) {

			if (bucket.contains(j)) {
				pairs++;
				bucket.remove(j);
			} else {
				bucket.add(j);
			}
		}
        return pairs;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sockMerchant(new int[] {1, 2, 1, 2, 3, 2}));
		System.out.println(sockMerchant(new int[] {5, 1, 8, 1, 5, 1}));
	}

}
