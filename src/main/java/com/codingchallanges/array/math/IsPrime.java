package com.codingchallanges.array.math;

public class IsPrime {

	// n is a prime number if it is not divisible by 2 though n-1
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
	public static boolean isPrimeOptim(int n) {

		if(n < 2) {
			return false;
		}

		for(int i = 2; i <= Math.sqrt(n); i++) {

			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		System.out.println("n = -10 -> result = " + isPrimeOptim(-10));
		System.out.println("n = -1 -> result = " + isPrimeOptim(-1));
		System.out.println("n = 0 -> result = " + isPrimeOptim(0));
		System.out.println("n = 1 -> result = " + isPrimeOptim(1));
		System.out.println("n = 2 -> result = " + isPrimeOptim(2));
		System.out.println("n = 3 -> result = " + isPrimeOptim(3));
		System.out.println("n = 4 -> result = " + isPrimeOptim(4));
		System.out.println("n = 5 -> result = " + isPrimeOptim(5));
		System.out.println("n = 6 -> result = " + isPrimeOptim(6));
		System.out.println("n = 7 -> result = " + isPrimeOptim(7));
		System.out.println("n = 8 -> result = " + isPrimeOptim(8));
		System.out.println("n = 9 -> result = " + isPrimeOptim(9));
		System.out.println("n = 10 -> result = " + isPrimeOptim(10));
		System.out.println("n = 11 -> result = " + isPrimeOptim(11));
		System.out.println("n = 12 -> result = " + isPrimeOptim(12));
		System.out.println("n = 13 -> result = " + isPrimeOptim(13));
		System.out.println("n = 14 -> result = " + isPrimeOptim(14));
		System.out.println("n = 15 -> result = " + isPrimeOptim(15));
		System.out.println("n = 16 -> result = " + isPrimeOptim(16));
		System.out.println("n = 17 -> result = " + isPrimeOptim(17));

	}

}
