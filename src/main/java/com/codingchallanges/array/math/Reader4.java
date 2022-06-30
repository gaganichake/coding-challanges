package com.codingchallanges.array.math;

public class Reader4 {

	private static int totalRead = 0;

	public int read4(char[] buf4){

		String file = "abcdefghijklmnopqrstuvwzyz";
		int thisRead = 4;

		if((file.length()-totalRead) > 4) {
			totalRead+=thisRead;
		} else {
			thisRead = file.length()-totalRead;
			totalRead+=thisRead;
		}

		System.out.println("totalRead="+totalRead);
		return thisRead;
	}
}
