package com.codingchallanges.array.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * containsDuplicates
 *
 * https://app.codesignal.com/interview-practice/task/CfknJzPmdbstXhsoJ/description
 *
 * Given an array of integers, write a function that determines whether the array
 * contains any duplicates. Your function should return true if any element appears
 * at least twice in the array, and it should return false if every element is distinct.
 */
public class ContainsDuplicates {

	boolean containsDuplicates(Integer[] a) {

	    // List<Integer> visited = new ArrayList<>();

	    // for(int i = 0; i < a.length; i++){
	    //     if(visited.contains(a[i])) return true;
	    //     visited.add(a[i]);
	    // }

		//The execution time is much better than above solution
	    Set<Integer> unique = new HashSet<>(Arrays.asList(a));
	    return unique.size() != a.length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
