package com.codingchallanges.array.math;
/*
 * adjacentElementsProduct
 *
 * https://app.codesignal.com/arcade/intro/level-2/xzKiBHjhoinnpdh6m
 *
 * Given an array of integers, find the pair of adjacent elements
 * that has the largest product and return that product.
 */
public class AdjacentElementsProduct {

	int adjacentElementsProduct(int[] inputArray) {

	    int largetProduct = -1000000;//This constraint is given in the problem itself.

	    for(int i = 0; i < inputArray.length-1; i++){
	        int product = inputArray[i] * inputArray[i+1];
	        if(largetProduct < product) largetProduct = product;
	    }

	    return largetProduct;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
