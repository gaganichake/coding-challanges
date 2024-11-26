package com.codingchallanges.array.math;

public class IsPrime {

	// n is a prime number if it is not divisible by any number BETWEEN 1 and n (i.e. 2 though n-1)
	// 0 and 1 are not prime
	// All negative numbers are also not prime
	public static boolean isPrime(int n) {

		if(n < 2) {
			return false;
		}

		for(int i = 2; i < n; i++) {

			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}

	//With optimization
	public static boolean isPrimeOptimized(int n) {

		if(n < 2) {
			return false;
		}

		double sqrt = Math.sqrt(n);
		for(int i = 2; i <= sqrt; i++) {

			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		System.out.println("n = -10 -> result = " + isPrimeOptimized(-10));
		System.out.println("n = -1 -> result = " + isPrimeOptimized(-1));
		System.out.println("n = 0 -> result = " + isPrimeOptimized(0));
		System.out.println("n = 1 -> result = " + isPrimeOptimized(1));
		System.out.println("n = 2 -> result = " + isPrimeOptimized(2));
		System.out.println("n = 3 -> result = " + isPrimeOptimized(3));
		System.out.println("n = 4 -> result = " + isPrimeOptimized(4));
		System.out.println("n = 5 -> result = " + isPrimeOptimized(5));
		System.out.println("n = 6 -> result = " + isPrimeOptimized(6));
		System.out.println("n = 7 -> result = " + isPrimeOptimized(7));
		System.out.println("n = 8 -> result = " + isPrimeOptimized(8));
		System.out.println("n = 9 -> result = " + isPrimeOptimized(9));
		System.out.println("n = 10 -> result = " + isPrimeOptimized(10));
		System.out.println("n = 11 -> result = " + isPrimeOptimized(11));
		System.out.println("n = 12 -> result = " + isPrimeOptimized(12));
		System.out.println("n = 13 -> result = " + isPrimeOptimized(13));
		System.out.println("n = 14 -> result = " + isPrimeOptimized(14));
		System.out.println("n = 15 -> result = " + isPrimeOptimized(15));
		System.out.println("n = 16 -> result = " + isPrimeOptimized(16));
		System.out.println("n = 17 -> result = " + isPrimeOptimized(17));

	}

}
