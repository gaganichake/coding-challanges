package com.codingchallanges.array.math;

/*
 * centuryFromYear
 *
 * https://app.codesignal.com/arcade/intro/level-1/egbueTZRRL5Mm4TXN
 *
 * Given a year, return the century it is in. The first century spans
 * from the year 1 up to and including the year 100, the second - from
 * the year 101 up to and including the year 200, etc
 */
public class Century {

	static int centuryFromYear(int year) {

		int century = year / 100;

		if (year % 100 != 0)
			century++;

		return century;
	}

	public static void main(String[] args) {

		System.out.println(centuryFromYear(1700));
		System.out.println(centuryFromYear(1950));
		System.out.println(centuryFromYear(2000));
	}

}
