package com.codingchallanges.array.sort;

import java.util.Arrays;

/*
 * Make Array Consecutive
 *
 * https://app.codesignal.com/arcade/intro/level-2/bq2XnSr5kbHqpHGJC
 *
 * Ratiorg got statues of different sizes as a present from CodeMaster
 * for his birthday, each statue having an non-negative integer size.
 * Since he likes to make things perfect, he wants to arrange them from
 * smallest to largest so that each statue will be bigger than the
 * previous one exactly by 1. He may need some additional statues to be
 * able to accomplish that. Help him figure out the minimum number of
 * additional statues needed.
 *
 * Example:
 *
 * For statues = [6, 2, 3, 8], the output should be
 * makeArrayConsecutive2(statues) = 3.
 *
 * Ratiorg needs statues of sizes 4, 5 and 7.
 */
public class MakeArrayConsecutive {

	public static int makeArrayConsecutive2(int[] statues) {

	    int count = 0;

	    if(statues.length == 1) return count;

	    Arrays.sort(statues);

	    for(int i = 0; i < statues.length-1; i++){

	        count+= statues[i+1] - statues[i] - 1;//count should be zero if difference is already one.
	    }

	    return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
