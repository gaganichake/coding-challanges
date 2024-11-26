package com.codingchallanges.array.sort;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/move-zeroes/
 *
 * Move all 0's to the end of it while maintaining the
 * relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZero {

    // tips: do not push the zero's to the end. Rather bring non-zero numbers to the beginning.
    public static void moveZeroes(int[] nums) {

        int firstIndexOfZero = 0;
        int temp;

        for(int i = 0; i < nums.length; i++){

            if(nums[i] != 0){
                temp = nums[firstIndexOfZero];
                nums[firstIndexOfZero] = nums[i];
                nums[i] = temp;

                firstIndexOfZero++;
                System.out.println("process : " + Arrays.toString(nums));
                }
            }
        }

//    public void moveZeroes(int[] nums) {
//
//        int firstIndexOfZero = -1;
//
//        for(int i = 0; i < nums.length; i++){
//
//            if(nums[i] == 0){
//                if(firstIndexOfZero == -1)
//                    firstIndexOfZero = i;
//            } else {
//                if(firstIndexOfZero != -1){
//                    nums[firstIndexOfZero] = nums[i];
//                    nums[i] = 0;
//                    firstIndexOfZero++;
//                }
//            }
//        }
//    }

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
