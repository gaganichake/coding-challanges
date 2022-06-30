package com.codingchallanges.array.histogram;

/*
 * Amazon practice question
 * 
 * You are given an array of integers which describe elevation at each point in a 2D landscape.
 * For example, the input [ 1 2 3 1 2 4 1 2 1 ] describes a landscape that looks like this:
 *             *      
 *       *     *      
 *     * *   * *   *  
 *   * * * * * * * * *
 * [ 1 2 3 1 2 4 1 2 1 ]
 * i 0 1 2 3 4 5 6 7 8
 * Water will fall down on the landscape, filling up anywhere that it's not able to fall off.
 * Find the total "area" of water that would be collected in the landscape.
 * For example, for the input [ 1 2 3 1 2 4 1 2 1 ], the result should be 4, as illustrated by
 * the 4 "/" characters.
 *             *      
 *       * / / *      
 *     * * / * * / *  
 *   * * * * * * * * *
 * [ 1 2 3 1 2 4 1 2 1 ]
 * i 0 1 2 3 4 5 6 7 8
 * 
 * Solution credit: https://www.geeksforgeeks.org/trapping-rain-water/
 */
public class WaterFallArea {

	public static int waterFallArea(int[] array) {
		
	    // To store the maximum water
	    // that can be stored
		int area = 0;
	 
	    // For every element of the array except first and last element
	    for(int i = 1; i < array.length - 1; i++)
	    {
	         
	        // Find maximum element on its left
	        int left = array[i];
	        for(int j = 0; j < i; j++)
	        {
	            left = Math.max(left, array[j]);
	        }
	 
	        // Find maximum element on its right
	        int right = array[i];
	        for(int j = i + 1; j < array.length; j++)
	        {
	            right = Math.max(right, array[j]);
	        }
	 
	        // Update maximum water value
	        area += Math.min(left, right) - array[i];
	    }
	    return area;
	}
	
	public static void main(String[] args) {
		// [ 1 2 3 1 2 4 1 2 1 ] -> [ 1 2 3 3 3 4 2 2 1 ]

		int[] array = {1, 2, 3, 1, 2, 4, 1, 2, 1};
		System.out.print(waterFallArea(array));
	}

}
 