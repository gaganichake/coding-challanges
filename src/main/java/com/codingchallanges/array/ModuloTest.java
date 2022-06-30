package com.codingchallanges.array;

import static java.lang.Math.floorMod;

public class ModuloTest {

	public static void main(String[] args) {

		final int mod = 1000000007;

		System.out.println(floorMod(100000000 * 3, mod));

		System.out.println(100000000 * 3 % mod);

	}

}
