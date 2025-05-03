package com.codingchallanges.array.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * sumOfTwo
 * <p>
 * <a href="https://app.codesignal.com/interview-practice/task/Hm98RnqK9Be575yoj/description">sumOfTwo</a>
 * <p>
 * You have two integer arrays, a and b, and an integer target value v. Determine
 * whether there is a pair of numbers, where one number is taken from a and the other
 * from b, that can be added together to get a sum of v. Return true if such a pair
 * exists, otherwise return false.
 */
public class TwoSumTwoArrays {

	boolean sumOfTwo(Integer[] a, Integer[] b, int v) {

		//When sum is not possible
	    if(a.length == 0 || b.length == 0) return false;

	    //Choose the shortest length array to iterate in future steps
	    if(a.length > b.length) {
	        Integer[] temp = a;
	        a = b;
	        b = temp;
	    }

	    //Using Set instead of List in order to remove duplicates
	    Set<Integer> set = new HashSet<>(Arrays.asList(a));//Smaller array goes here


	    //Bigger array goes here
	    for(int i = 0; i < b.length; i++){

	       //To reduce the iteration further, scan the array from both ends
	        if(set.contains(v-b[i]) || set.contains(v-b[b.length-1-i])) return true;

	        //Break when you are in the middle of the length
	        if(i > b.length-1-i) break;
	    }

	    return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
