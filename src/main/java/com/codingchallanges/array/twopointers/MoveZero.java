package com.codingchallanges.array.twopointers;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/">move-zeroes</a>
 * <p>
 * Move all 0's to the end of it while maintaining the
 * relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 **/
public class MoveZero {

    // Two pointers approach
    // tips: do not push the zero's to the end. Rather bring non-zero numbers to the beginning.
    public static void moveZeroes(int[] nums) {

        int temp;
        for(int i = 0, z = 0; i < nums.length; i++){

            if(nums[i] != 0){
                temp = nums[z];
                nums[z] = nums[i];
                nums[i] = temp;
                z++;
                }
            System.out.println("process : " + Arrays.toString(nums));
            }
        }

	public static void main(String[] args) {

//		int[] array = {0,1,0,3,12};
//		int[] array = {2,0,4,5,0,1};
      int[] array = {0,0,7,0,0,9};

		System.out.println("Before: " + Arrays.toString(array));

		moveZeroes(array);

		System.out.println("After: " + Arrays.toString(array));

		//Output: [1,3,12,0,0]
	}

}
