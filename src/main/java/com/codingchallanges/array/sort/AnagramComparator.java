package com.codingchallanges.array.sort;

import java.util.Arrays;
import java.util.Comparator;

public class AnagramComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {

		char[] cArr1 = o1.toCharArray();

		Arrays.sort(cArr1);

		char[] cArr2 = o2.toCharArray();

		Arrays.sort(cArr2);

		return new String(cArr1).compareTo(new String(cArr2));
	}

}
