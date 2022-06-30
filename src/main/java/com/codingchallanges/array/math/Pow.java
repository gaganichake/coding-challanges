package com.codingchallanges.array.math;

/*
 * Calculate x to the power of n
 */
public class Pow {

	// Iterative O(n)
	public static double pow(double x, int n) {

		double product = 1.0;

		for (int i = 0; i < Math.abs(n); i++) {
			product = product * x;
		}

		if (n < 0)
			return 1 / product;
		else
			return product;
	}


    // Using recursion O(n)
    static double powRec(double x, int n) {

    	if(n == 0) return 1.0;

    	if(n > 0)
    		return x * powRec(x, n-1);
    	else
    		return 1/x * powRec(x, n+1);
    }

    // Dynamic programming O(n/2)
    public static double fastPow(double x, int n) {

        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }

    }

	public static void main(String[] args) {

		System.out.println(pow(5, 3));
		System.out.println(pow(2, -4));

		System.out.println(powRec(5, 3));
		System.out.println(powRec(2, -4));

		System.out.println(fastPow(5, 3));
		System.out.println(fastPow(2, -4));
	}
}
