package com.codingchallanges.array.matrix;

import java.util.Comparator;

public class PairComparator implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {

		int[] a1 = (int[])o1;
		int[] a2 = (int[])o2;

//		if(a1[0] != a2[0]) {
//			return a1[0] < a2[0] ? -1 : 1;
//		} else {
//			return a1[1] < a2[1] ? -1 : a1[1] == a2[1] ? 0 : 1;
//		}

		if(a1[0] != a2[0]) {
			return Integer.compare(a1[0], a2[0]);
		} else {
			return Integer.compare(a1[1], a2[1]);
		}
	}
}
