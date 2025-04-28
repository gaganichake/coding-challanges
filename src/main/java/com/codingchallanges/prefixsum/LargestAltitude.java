package com.codingchallanges.prefixsum;

/**
 * There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
 * The biker starts his trip on point 0 with altitude equal 0.
 * ---
 * Example 1:
 * Input: gain = [-5,1,5,0,-7]
 * Output: 1
 * Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
 * Example 2:
 * ---
 * Input: gain = [-4,-3,-2,-1,4,3,2]
 * Output: 0
 * Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
 * ---
 * <a href="https://leetcode.com/problems/find-the-highest-altitude">find-the-highest-altitude</a>
 */
public class LargestAltitude {
    /**
     * You are given an integer array gain where gain[i] is the net gain in altitude between points i and i + 1 for all
     * (0 <= i < gain.length). Return the highest altitude of a point.
     *
     */
    public int largestAltitude(int[] gain) {

        int[] prefixSum = new int[gain.length+1];
        prefixSum[0] = 0;
        int highestAltitude = 0;

        for(int i = 0; i < gain.length; i++){
            prefixSum[i+1] = prefixSum[i] + gain[i];
            if(prefixSum[i+1] > highestAltitude)
                highestAltitude = prefixSum[i+1];
        }

        return highestAltitude;
    }
}
