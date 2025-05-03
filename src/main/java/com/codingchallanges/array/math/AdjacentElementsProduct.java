package com.codingchallanges.array.math;
/**
 * adjacentElementsProduct
 * <p>
 * <a href="https://app.codesignal.com/arcade/intro/level-2/xzKiBHjhoinnpdh6m">adjacentElementsProduct</a>
 * <p>
 * Given an array of integers, find the pair of adjacent elements
 * that has the largest product and return that product.
 * <p>
 * Example
 * For inputArray = [3, 6, -2, -5, 7, 3], the output should be
 * solution(inputArray) = 21.
 * <p>
 * 7 and 3 produce the largest product.
 */
public class AdjacentElementsProduct {

	static int adjacentElementsProduct(int[] inputArray) {

	    int largestProduct = -1000000;//This constraint is given in the problem itself.

	    for(int i = 0; i < inputArray.length-1; i++){
	        int product = inputArray[i] * inputArray[i+1];
	        if(largestProduct < product) largestProduct = product;
	    }

	    return largestProduct;
	}

	public static void main(String[] args) {

		System.out.println(adjacentElementsProduct(new int[] {3, 6, -2, -5, 7, 3}));
	}
}
