package com.codingchallanges.prefixsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

/*
 * findLongestSubarrayBySum
 *
 * https://app.codesignal.com/interview-practice/task/izLStwkDr5sMS9CEm/description
 *
 * You have an unsorted array arr of non-negative integers and a number s. Find a longest
 * contiguous subarray in arr that has a sum equal to s. Return two integers that represent
 * its inclusive bounds. If there are several possible answers, return the one with the
 * smallest left bound. If there are no answers, return [-1].
 *
 * Your answer should be 1-based, meaning that the first position of the array is 1 instead
 * of 0.
 */
public class FindLongestSubarrayBySum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    //Works with 100% test cases but causes execution time error with large data set
    int[] findLongestSubarrayBySum(int s, int[] arr) {

        int[] prefixSum = new int[arr.length + 1];
        SortedMap<Integer, int[]> map = new TreeMap<>();

        //This iteration can be avoided
//	    for(int i = 0; i < arr.length; i++){
//
//	        prefixSum[i+1] = prefixSum[i] + arr[i];
//	    }

        for (int i = 1; i < prefixSum.length; i++) {

            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];//This also works. Reduces one iteration.

            for (int j = 0; j < i; j++) {

                if (prefixSum[i] - prefixSum[j] == s) {
                    int[] a = {j + 1, i};
                    map.put(i - j, a);
                }
            }
        }

        int[] a = {-1};

        return map.isEmpty() ? a : map.get(map.lastKey());
    }

    //This is an optimized algorithm of the above approach.
    int[] findLongestSubarrayBySumV2(int s, int[] arr) {

        int[] prefixSum = new int[arr.length + 1];
        int max = 0;
        int[] result = new int[2];

        for (int i = 0; i < arr.length; i++) {

            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        for (int i = 1; i < prefixSum.length; i++) {

            if (prefixSum[i] == s) {
                max = i;
                result[0] = 1;
                result[1] = i;
            }

            int leftIndex = Arrays.binarySearch(prefixSum, prefixSum[i] - s);

            if (leftIndex > -1) {
                if (max < i - leftIndex) {
                    max = i - leftIndex;
                    result[0] = leftIndex + 1;
                    result[1] = i;
                }
            }
        }

        int[] a = {-1};

        return max != 0 ? result : a;
    }

    //This is even more optimized algorithm of the above approach.
    //Credit: https://github.com/edyluisrey/Codefights-Algorithms
    int[] findLongestSubarrayBySumV3(int s, int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();//Use for prefix sum
        int max = 0;
        int sum = 0;
        int[] re = new int[2];

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == s) {
                max = i + 1;
                re[0] = 1;
                re[1] = i + 1;
            }
            if (map.containsKey(sum - s)) {
                if (max < i - map.get(sum - s)) {
                    max = i - map.get(sum - s);
                    re[0] = map.get(sum - s) + 2;
                    re[1] = i + 1;
                }
            }
            map.put(sum, i);
        }

        //System.out.println("max:"+max);

        if (max == 0)
            return new int[]{-1};
        else
            return re;

    }

}
