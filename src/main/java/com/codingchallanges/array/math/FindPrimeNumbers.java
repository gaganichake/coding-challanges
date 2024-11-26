package com.codingchallanges.array.math;

import java.util.Arrays;

/*
 * The Sieve of Eratosthenes
 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 *
 * Given a number n, write a function that returns the total number of primes up to and including n.
 *
 *Tests Conditions:
 *
 *n=-1 -> result=0
 *n=0 -> result=0
 *n=1 -> result=0
 *n=2 -> result=1
 *n=7 -> result=4
 *n=10,000 -> result=1,229
 *n=100,000 -> result=9,592
 *n=1,000,000 -> result=78,498
 *
 * 2, 3, 5, 7, 11, 13, 17, 19, 21, 23, 27
 */

public class FindPrimeNumbers {

	public static int findPrimeNumbers(int n) {

		if(n < 2) return 0;

		boolean[] prime = new boolean[n+1];

		//First, mark all numbers as prime
		Arrays.fill(prime, true);

		// Setting initial facts
		prime[0] = false; //0 is not a prime
		prime[1] = false; //1 is not a prime

//		for(int i = 2; i <= n; i++) {//This also works
		for(int i = 2; i <= Math.sqrt(n);i++) {//However, this is sufficient to end at prime's square root

			if(prime[i]) {
				//All multiples of prime are NOT prime
//				for(int j = 2; j * i <= n; j++) {//This works
				for(int j = i; j * i <= n; j++) {//However, starting with prime's square is sufficient
					prime[j * i] = false;
				}
			}
		}

		int count = 0;

		for(int i = 0; i < n + 1; i++) {
			if(prime[i]) count++;
		}

		return count;
	}

	public static void main(String[] args) {

		System.out.println("n = -10 -> result = " + findPrimeNumbers(-10));
		System.out.println("n = -1 -> result = " + findPrimeNumbers(-1));
		System.out.println("n = 0 -> result = " + findPrimeNumbers(0));
		System.out.println("n = 1 -> result = " + findPrimeNumbers(1));
		System.out.println("n = 2 -> result = " + findPrimeNumbers(2));
		System.out.println("n = 3 -> result = " + findPrimeNumbers(3));
		System.out.println("n = 4 -> result = " + findPrimeNumbers(4));
		System.out.println("n = 5 -> result = " + findPrimeNumbers(5));
		System.out.println("n = 6 -> result = " + findPrimeNumbers(6));
		System.out.println("n = 7 -> result = " + findPrimeNumbers(7));
		System.out.println("n = 8 -> result = " + findPrimeNumbers(8));
		System.out.println("n = 9 -> result = " + findPrimeNumbers(9));
		System.out.println("n = 10 -> result = " + findPrimeNumbers(10));
		System.out.println("n = 10000 -> result = " + findPrimeNumbers(10000));
		System.out.println("n = 100000 -> result = " + findPrimeNumbers(100000));
		System.out.println("n = 1000000 -> result = " + findPrimeNumbers(1000000));

	}

}
