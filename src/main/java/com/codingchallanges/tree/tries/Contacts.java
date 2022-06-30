package com.codingchallanges.tree.tries;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.hackerrank.com/challenges/contacts/problem
 * 
 * Complete the 'contacts' function below.
 *
 * The function is expected to return an INTEGER_ARRAY. 
 * The function accepts 2D_STRING_ARRAY queries as parameter.
 */
public class Contacts {

	public static List<Integer> contacts(List<String> queries) {

		Tries node = new Tries();

		List<Integer> result = new ArrayList<>();

		for (String query : queries) {

			String op = query.split(" ")[0];
			String word = query.split(" ")[1];

			if (op.equals("add"))
				node.add(word);
			else if (op.equals("find"))
				result.add(node.findPrefix(node, word));
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		
		List<String> queries = new ArrayList<>();
		queries.add("add ed");
		queries.add("add eddie");
		queries.add("add edward");
		queries.add("find ed");
		queries.add("add edwina");
		queries.add("find edw");
		queries.add("find a");
		
		System.out.println(contacts(queries));
	}

}
