package com.codingchallanges;

import java.util.Arrays;

/*
 * findLongestSubarrayBySum
 *
 * https://app.codesignal.com/interview-practice/task/izLStwkDr5sMS9CEm/description
 *
 * You have an unsorted array arr of non-negative integers and a number s. Find the longest
 * contiguous subarray in arr that has a sum equal to s. Return two integers that represent
 * its inclusive bounds. If there are several possible answers, return the one with the
 * smallest left bound. If there are no answers, return [-1].
 *
 * Your answer should be 1-based, meaning that the first position of the array is 1 instead
 * of 0.
 */
public class Solution {

    public static void main(String[] args) {

        int[] inputArr = {2, 0, 1, 3, 2, 1, 2, 3};
        System.out.println(Arrays.toString(findLongestSubarrayBySumV3(5, inputArr)));
    }

    static int[] findLongestSubarrayBySumV3(int s, int[] arr)
    {
       int[] result = {-1};
       int left = -1; int right = -1;

       int[] prefixSum = new int[arr.length+1];
        prefixSum[0] = 0;

        for (int i = 0; i < arr.length; i++) {

            prefixSum[i + 1] = prefixSum[i] + arr[i];

            if(s == prefixSum[i+1]){
                left = 0;
                right = i;
            } else if(s == prefixSum[i + 1] - prefixSum[i]){
                left = i;
                right = i+1;
            }

        }
        System.out.println(Arrays.toString(prefixSum));
        if(left > -1){
            result = new int[]{left, right};
        }

        return result;
    }
}

