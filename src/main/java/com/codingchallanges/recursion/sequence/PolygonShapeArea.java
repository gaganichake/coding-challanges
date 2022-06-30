package com.codingchallanges.recursion.sequence;

/*
 * PolygonShapeArea
 * 
 * https://app.codesignal.com/arcade/intro/level-2/yuGuHvcCaFCKk56rJ
 * 
 * Below we will define an n-interesting polygon. Your task is to find 
 * the area of a polygon for a given n.
 *
 * A 1-interesting polygon is just a square with a side of length 1. 
 * An n-interesting polygon is obtained by taking the n - 1-interesting 
 * polygon and appending 1-interesting polygons to its rim, side by side. 
 * You can see the 1-, 2-, 3- and 4-interesting polygons in the picture below.
 * 
 * Example: 
 * For n = 2, the output should be shapeArea(n) = 5; 
 * For n = 3, the output should be shapeArea(n) = 13
 * 
 * Solution:
 * Two edge cases: shapeArea(1) = 1, shapeArea(2) = 5
 * One formula: shapeArea(n) = shapeArea(n - 1) + (n - 1) * 4
 */
public class PolygonShapeArea {

	// Time Complexity: O(n); Space Complexity: O(n)
	public static int shapeArea(int n) {
		 
	    if(n == 1) return 1;
	    
	    if(n == 2) return 5;
	    
	    return shapeArea(n - 1) + (n - 1) * 4;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(shapeArea(1));//1
		System.out.println(shapeArea(2));//5
		System.out.println(shapeArea(3));//13
		System.out.println(shapeArea(4));
		System.out.println(shapeArea(5));//41
		System.out.println(shapeArea(100));//19801
		System.out.println(shapeArea(7000));//97986001
		System.out.println(shapeArea(8000));//127984001
		System.out.println(shapeArea(9999));//199940005
		System.out.println(shapeArea(9998));//199900013
		System.out.println(shapeArea(8999));//161946005

	}

}
