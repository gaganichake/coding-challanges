package com.codingchallanges.array.math;

/**
 * centuryFromYear
 * <p>
 * <a href="https://app.codesignal.com/arcade/intro/level-1/egbueTZRRL5Mm4TXN">centuryFromYear</a>
 * <p>
 * Given a year, return the century it is in. The first century spans
 * from the year 1 up to and including the year 100, the second - from
 * the year 101 up to and including the year 200, etc
 * <p>
 * Example
 * For year = 1905, the output should be
 * solution(year) = 20;
 * For year = 1700, the output should be
 * solution(year) = 17.
 */
public class Century {

	static int centuryFromYear(int year) {

		return year % 100 == 0 ? year / 100 : (year / 100 + 1);
	}

	public static void main(String[] args) {

		System.out.println(centuryFromYear(1700));
		System.out.println(centuryFromYear(1905));
		System.out.println(centuryFromYear(2000));
	}

}
