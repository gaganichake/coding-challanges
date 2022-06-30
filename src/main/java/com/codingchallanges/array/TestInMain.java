package com.codingchallanges.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestInMain {

	public static void main(String[] args) {


		Map<String, String> page = new HashMap<>();

		List<String> list = (List<String>) page.values();

		StringBuffer sb = new StringBuffer();

		sb.append("blah");

		foo(sb);

		System.out.println(sb);

	}

	private static void foo(StringBuffer sb) {

		sb.append("-blah");

		sb = new StringBuffer();

		sb.append("blah-blah-blah");

//		System.out.println(sb);
	}

}
