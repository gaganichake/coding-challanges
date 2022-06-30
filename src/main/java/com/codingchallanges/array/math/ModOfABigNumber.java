package com.codingchallanges.array.math;

public class ModOfABigNumber {

	public static int modNum(long num, int m) {

		int result = 0;

		while(num > Integer.MAX_VALUE) {

			result += Integer.MAX_VALUE % m;
			num -= Integer.MAX_VALUE;
		}

		result += num % m;

		result = result % m;// Distributive property: (a + b) % n = [(a % n) + (b % n)] % n

		return result;

    }

    // Function to compute num (mod a)
    public static int modStr(String num, int a) {

        // Initialize result
        int res = 0;

        // One by one process all digits of 'num'
        for (int i = 0; i < num.length(); i++)
            res = (res * 10 + (int)num.charAt(i) - '0') % a;

        return res;
    }


	public static void main(String[] args) {

		int m = 10;
		String numStr = "12316767678678";

        System.out.println(modStr(numStr, m));

        long num = 12316767678678L;

        System.out.println(modNum(num, m));
	}

}
